package com.southeast_ideas.wx.controller;

import com.southeast_ideas.wx.api.IWxCommonService;
import com.southeast_ideas.wx.api.WxCommonService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by MichaelWang.
 * Date:2018/3/28
 * Time:22:08
 */
@Controller
@RequestMapping("/TokenVerification")
public class TokenVerification {

    private IWxCommonService iWxCommonService = new WxCommonService();

    @ResponseBody
    @RequestMapping(value = "/verifyToken", produces = "application/json;charset=UTF-8")
    public String wxTest(HttpServletRequest request) {
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");
        iWxCommonService.test();
        return iWxCommonService.verifyToken(timestamp, nonce, signature) ? echostr : null;

    }

}
