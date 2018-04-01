package com.southeast_ideas.wx.pojo;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

/**
 * Created by MichaelWang.
 * Date:2018/3/31
 * Time:16:18
 */
public class TemplateSenderResult extends WxError{
    private long msgid;

    public long getMsgid() {
        return msgid;
    }

    @Override
    public String toString() {
        return "TemplateSenderResult{" +
                "msgid=" + msgid +
                '}';
    }

    /**
     *
     * json --> obj
     *
     * @param json
     * @return
     * @throws IOException
     */
    public static TemplateSenderResult fromJson(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.readValue(json, TemplateSenderResult.class);
    }

}
