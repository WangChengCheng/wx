package com.southeast_ideas.wx.pojo;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

/**
 * Created by MichaelWang.
 * Date:2018/3/31
 * Time:16:24
 */
public class TemplateSender {
    private String touser;
    private String template_id;
    private String url;
    private Object data;

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "TemplateSender{" +
                "touser='" + touser + '\'' +
                ", template_id='" + template_id + '\'' +
                ", url='" + url + '\'' +
                ", data=" + data +
                '}';
    }

    /**
     * obj --> json
     * @return
     * @throws IOException
     */
    public String toJson() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(this);
    }
}
