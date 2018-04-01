package com.southeast_ideas.wx.pojo.demo;

/**
 * Created by MichaelWang.
 * Date:2018/4/1
 * Time:15:00
 */
public class TemplateMsgItem {
    private String value;
    private String color;

    public TemplateMsgItem() {
    }

    public TemplateMsgItem(String value, String color) {
        this.value = value;
        this.color = color;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "TemplateMsgItem{" +
                "value='" + value + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
