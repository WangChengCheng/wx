package com.southeast_ideas.wx.utils;

import com.southeast_ideas.wx.pojo.WxXmlMsg;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.basic.DateConverter;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

/**
 * 将接收的xml信息转变为Map信息
 *
 * Created by MichaelWang.
 * Date:2018/3/29
 * Time:19:24
 */
public class WxMsgConvertUtils {

    public static Logger logger = LoggerFactory.getLogger(WxMsgConvertUtils.class);

//    public static final XmlFriendlyNameCoder nameCoder = new XmlFriendlyNameCoder();
//
//    // 编码格式
//    private static final String ENCODING = "UTF-8";
//
//    // dom解析驱动
//    private static final DomDriver fixDriver = new DomDriver(ENCODING, nameCoder);
//
//    // 通用解析器
//    public static final XStream XSTREAM = new XStream(fixDriver);
//
//    static {
//        // 时区处理
//        TimeZone zone = TimeZone.getTimeZone("GMT-8:00");
//        XSTREAM.registerConverter(new DateConverter(zone), XStream.PRIORITY_NORMAL);
//        XSTREAM.autodetectAnnotations(true);
//    }

//    /**
//     * 该方法（方式）未使用
//     * 将接收到的xml信息转换为map信息
//     * @param request
//     * @return
//     */
//    public static Map<String, String> xmlToMap(HttpServletRequest request) {
//        Map<String, String> map = new HashMap<>();
//        SAXReader saxReader = new SAXReader();
//        InputStream inStream;
//        Document doc;
//        try {
//            inStream = request.getInputStream();
//            doc = saxReader.read(inStream);
//            Element root =doc.getRootElement();
//            List<Element> list = root.elements();
//            for (Element elem : list) {
//                map.put(elem.getName(), elem.getText());
//            }
//            inStream.close();
//        } catch (IOException|DocumentException e) {
//            logger.error("可能错误：\n1）读取request中xml信息出错;\n2）xml->doc过程出错；\n3）关闭InputStream时出错。\n");
//            e.printStackTrace();
//        }
//        return map;
//    }

//    /**
//     * 将xml信息转换为WxXmlMsg实体
//     * @param xml
//     * @return
//     */
//    public static WxXmlMsg xmlToClazz(String xml) {
////        // 让Root节点的XML与AReq对象关联
////        SAXReader reader = new SAXReader();
////        Document doc = null;
////        try {
////            doc = reader.read(xml);
////        } catch (DocumentException e) {
////            e.printStackTrace();
////        }
////        XSTREAM.alias("xml", WxXmlMsg.class);
//        return (WxXmlMsg) XSTREAM.fromXML(xml);
//    }

//    public static String clazzToXml(WxXmlMsg wxXmlMsg) {
//        XSTREAM.alias("xml", WxXmlMsg.class);
//        String toUser = wxXmlMsg.getFromUserName();
//        String fromUsert = wxXmlMsg.getToUserName();
//        wxXmlMsg.setFromUserName(fromUsert);
//        wxXmlMsg.setToUserName(toUser);
//        wxXmlMsg.setContent(wxXmlMsg.getContent()+"(return)");
//        return XSTREAM.toXML(wxXmlMsg);
//    }

//    public static WxXmlMsg xmlToClazz(InputStream xml) {
//        WxXmlMsg wxXmlMsg = new WxXmlMsg();
//        // 读取输入流
//        SAXReader reader = new SAXReader();
//        Document document = null;
//        try {
//            document = reader.read(xml);
//        } catch (DocumentException e) {
//            e.printStackTrace();
//        }
//        // 得到xml根元素
//        Element root = document.getRootElement();
//        // 得到根元素的所有子节点
//        List<Element> elementList = root.elements();
//
//        // 遍历所有子节点
//        for (Element e : elementList) {
//            System.out.println(e.getName() + "|" + e.getText());
////            map.put(e.getName(), e.getText());
//        }
//
//        try {
//            // 释放资源
//            xml.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return wxXmlMsg;
//    }

}
