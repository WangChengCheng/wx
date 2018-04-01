package com.southeast_ideas.wx.controller;

import com.southeast_ideas.wx.api.IWxCommonService;
import com.southeast_ideas.wx.api.WxCommonService;
import com.southeast_ideas.wx.api.WxMsgTypeEnum;
import com.southeast_ideas.wx.pojo.WxXmlMsg;
import com.southeast_ideas.wx.service.TemplateMsgDemo;
import com.southeast_ideas.wx.utils.WxMsgConvertUtils;
import com.southeast_ideas.wx.utils.xml.XStreamTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;

/**
 * Created by MichaelWang.
 * Date:2018/3/28
 * Time:22:08
 */
@Controller
@RequestMapping("/TokenVerification")
public class TokenVerification {
    private static Logger logger = LoggerFactory.getLogger(TokenVerification.class);

    private IWxCommonService iWxCommonService = new WxCommonService();

    private static Thread TEMPLATE_SENDER_THREAD = new Thread(new TemplateMsgDemo());

    @ResponseBody
    @RequestMapping(value = "/verifyToken", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
    public String doGet(HttpServletRequest request) {
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");
        return iWxCommonService.verifyToken(timestamp, nonce, signature) ? echostr : null;
    }

    @ResponseBody
    @RequestMapping(value = "/verifyToken", produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
    public String doPost(HttpServletRequest request) {
        // 获取encrypt_type 消息加解密方式标识
        String encrypt_type = request.getParameter("encrypt_type");
        logger.info("加密方式："+encrypt_type);
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        InputStream inStream = null;
        try {
            inStream = request.getInputStream();
        } catch (IOException e) {
            logger.error("提取XML消息失败");
            e.printStackTrace();
        }
        WxXmlMsg wxXmlMsg = XStreamTransformer.fromXml(WxXmlMsg.class, inStream);
        logger.info(wxXmlMsg.toString());

        testTemplateSend(wxXmlMsg.getContent());

        String fromUser = wxXmlMsg.getToUserName();
        String toUser = wxXmlMsg.getFromUserName();
        long createTime = Calendar.getInstance().getTimeInMillis();
        wxXmlMsg.setFromUserName(fromUser);
        wxXmlMsg.setToUserName(toUser);
        wxXmlMsg.setCreateTime(createTime);
        wxXmlMsg.setContent("已收到您的消息："+wxXmlMsg.getContent()+"。");
        return XStreamTransformer.toXml(WxXmlMsg.class, wxXmlMsg);
    }

    private void testTemplateSend(String msg) {
        if (msg.equals("start template sender")) {
            TemplateMsgDemo.EXIT = false;
            TEMPLATE_SENDER_THREAD.start();
        }
        if (msg.equals("stop template sender")) {
            TemplateMsgDemo.EXIT = true;
        }
    }

}
