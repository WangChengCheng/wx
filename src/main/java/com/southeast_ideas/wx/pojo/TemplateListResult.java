package com.southeast_ideas.wx.pojo;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.List;

/**
 * Created by MichaelWang.
 * Date:2018/3/31
 * Time:16:16
 */
public class TemplateListResult {
    private List<TemplateResult> template_list;

    public List<TemplateResult> getTemplate_list() {
        return template_list;
    }

    public void setTemplate_list(List<TemplateResult> template_list) {
        this.template_list = template_list;
    }

    /**
     * json --> obj
     *
     * @param json
     * @return
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws IOException
     */
    public static TemplateListResult fromJson(String json) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.readValue(json, TemplateListResult.class);
    }

    @Override
    public String toString() {
        return "TemplateListResult{" +
                "template_list=" + template_list +
                '}';
    }
}
