package com.southeast_ideas.wx.pojo;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

/**
 * 微信AccessToken，微信API接口调用凭证
 * Created by MichaelWang.
 * Date:2018/3/31
 * Time:17:19
 */
public class WxAccessToken {
    private String access_token;
    private int expires_in = -1;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    public static WxAccessToken fromJson(String json) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, WxAccessToken.class);
    }

    @Override
    public String toString() {
        return "WxAccessToken{" +
                "access_token='" + access_token + '\'' +
                ", expires_in=" + expires_in +
                '}';
    }
}
