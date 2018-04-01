package com.southeast_ideas.wx.pojo;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

/**
 * Created by MichaelWang.
 * Date:2018/3/31
 * Time:15:34
 */
public class TemplateResult extends WxError {
    private String template_id;
    private String title;
    private String primary_industry;
    private String deputy_industry;
    private String content;
    private String example;

    public String getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrimary_industry() {
        return primary_industry;
    }

    public void setPrimary_industry(String primary_industry) {
        this.primary_industry = primary_industry;
    }

    public String getDeputy_industry() {
        return deputy_industry;
    }

    public void setDeputy_industry(String deputy_industry) {
        this.deputy_industry = deputy_industry;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    @Override
    public String toString() {
        return "TemplateResult{" +
                "template_id='" + template_id + '\'' +
                ", title='" + title + '\'' +
                ", primary_industry='" + primary_industry + '\'' +
                ", deputy_industry='" + deputy_industry + '\'' +
                ", content='" + content + '\'' +
                ", example='" + example + '\'' +
                '}';
    }

    /**
     * json --> obj
     * @param json
     * @return
     * @throws IOException
     */
    public static TemplateResult fromJson(String json) throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.readValue(json, TemplateResult.class);
    }
}
