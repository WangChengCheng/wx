package com.southeast_ideas.wx.api;

/**
 * 微信消息类型
 * Created by MichaelWang.
 * Date:2018/3/29
 * Time:21:03
 */
public enum WxMsgTypeEnum{
    TEXT      (0, "text"),         //文本类型
    IMAGE     (1, "image"),        //图片类型
    VOICE     (2, "voice"),        //语音类型
    VIDEO     (3, "video"),        //视频类型
    SHORTVIDEO(4, "shortvideo"),   //小视频类型
    LOCATION  (5, "location"),     //地理位置类型
    LINK      (6, "link");         //链接类型

    private int index;
    private String label;

    private WxMsgTypeEnum(int index, String label) {
        this.index = index;
        this.label = label;
    }

    public int getIndex() {
        return index;
    }

    public String getLabel() {
        return label;
    }
}
