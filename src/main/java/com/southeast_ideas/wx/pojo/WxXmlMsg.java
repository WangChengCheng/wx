package com.southeast_ideas.wx.pojo;

import com.southeast_ideas.wx.utils.xml.XStreamCDataConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

/**
 * 微信消息
 * Created by MichaelWang.
 * Date:2018/3/29
 * Time:19:13
 */
@XStreamAlias("xml")
public class WxXmlMsg {
    /**
     * 所有消息类型 共有属性
     */
    @XStreamAlias("ToUserName")
    @XStreamConverter(value = XStreamCDataConverter.class)
    private String toUserName;      //开发者微信号

    @XStreamAlias("FromUserName")
    @XStreamConverter(value = XStreamCDataConverter.class)
    private String fromUserName;    //发送方帐号（一个OpenID）

    @XStreamAlias("CreateTime")
    private Long createTime;        //消息创建时间（整型）

    @XStreamAlias("MsgType")
    @XStreamConverter(value = XStreamCDataConverter.class)
    private String msgType;         //消息类型

    @XStreamAlias("MsgId")
    private Long msgId;             //消息id，64位整型

    /**
     * 文本类型 属性
     */
    @XStreamAlias("Content")
    @XStreamConverter(value = XStreamCDataConverter.class)
    private String content;         //文本消息内容

    /**
     * 图片类型、语音类型、视频类型、小（短）视频类型 共有属性
     */
    @XStreamAlias("MediaId")
    @XStreamConverter(value = XStreamCDataConverter.class)
    private String mediaId;         //图片消息媒体id，可以调用多媒体文件下载接口拉取数据。

    /**
     * 图片类型 属性
     */
    @XStreamAlias("PicUrl")
    @XStreamConverter(value = XStreamCDataConverter.class)
    private String picUrl;          //图片链接（由系统生成）

    /**
     * 语音类型 属性
     */
    @XStreamAlias("Format")
    @XStreamConverter(value = XStreamCDataConverter.class)
    private String format;          //语音格式，如amr，speex等

    @XStreamAlias("Recognition")
    @XStreamConverter(value = XStreamCDataConverter.class)
    private String recognition;     //语音识别结果，UTF8编码

    /**
     * 视频、小（短）视频类型 属性
     */
    @XStreamAlias("ThumbMediaId")
    @XStreamConverter(value = XStreamCDataConverter.class)
    private String thumbMediaId;    //视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。

    /**
     * 地理位置类型 属性
     */
    @XStreamAlias("Location_X")
    private Double locationX;      //地理位置维度

    @XStreamAlias("Location_Y")
    private Double locationY;      //地理位置经度

    @XStreamAlias("Scale")
    private Double scale;           //地图缩放大小

    @XStreamAlias("Label")
    @XStreamConverter(value = XStreamCDataConverter.class)
    private String label;           //地理位置信息

    /**
     * 链接类型 属性
     */
    @XStreamAlias("Title")
    @XStreamConverter(value = XStreamCDataConverter.class)
    private String title;           //消息标题

    @XStreamAlias("Description")
    @XStreamConverter(value = XStreamCDataConverter.class)
    private String description;     //消息描述

    @XStreamAlias("Url")
    @XStreamConverter(value = XStreamCDataConverter.class)
    private String url;             //消息链接

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public Long getMsgId() {
        return msgId;
    }

    public void setMsgId(Long msgId) {
        this.msgId = msgId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getRecognition() {
        return recognition;
    }

    public void setRecognition(String recognition) {
        this.recognition = recognition;
    }

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }

    public Double getLocationX() {
        return locationX;
    }

    public void setLocationX(Double locationX) {
        this.locationX = locationX;
    }

    public Double getLocationY() {
        return locationY;
    }

    public void setLocationY(Double locationY) {
        this.locationY = locationY;
    }

    public Double getScale() {
        return scale;
    }

    public void setScale(Double scale) {
        this.scale = scale;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "WxXmlMessage [toUserName=" + toUserName + ", fromUserName=" + fromUserName + ", createTime="
                + createTime + ", msgType=" + msgType + ", content=" + content + ", msgId=" + msgId + ", picUrl="
                + picUrl + ", mediaId=" + mediaId + ", format=" + format + ", thumbMediaId=" + thumbMediaId
                + ", locationX=" + locationX + ", locationY=" + locationY + ", scale=" + scale + ", label=" + label
                + ", title=" + title + ", description=" + description + ", url=" + url + "]";
    }
}
