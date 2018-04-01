package com.southeast_ideas.wx.pojo;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by MichaelWang.
 * Date:2018/3/31
 * Time:20:49
 */
public class WxUserListResult {
    private int total;
    private int count;
    private WxOpenId data;
    private String next_openid; //ObjectMapper转换要求该对象所有属性和从微信服务器上接收到的json串中的属性名称完全一致

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public WxOpenId getData() {
        return data;
    }

    public void setData(WxOpenId data) {
        this.data = data;
    }

    public String getNext_openid() {
        return next_openid;
    }

    public void setNext_openid(String next_openid) {
        this.next_openid = next_openid;
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
    public static WxUserListResult fromJson(String json) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.readValue(json, WxUserListResult.class);
    }

    @Override
    public String toString() {
        return "WxUserListResult{" +
                "total=" + total +
                ", count=" + count +
                ", data=" + data +
                ", nextOpenId='" + next_openid + '\'' +
                '}';
    }

    public static class WxOpenId {
        private String[] openid;

        public String[] getOpenid() {
            return openid;
        }

        public void setOpenid(String[] openid) {
            this.openid = openid;
        }

        @Override
        public String toString() {
            return "WxOpenId{" +
                    "openid=" + Arrays.toString(openid) +
                    '}';
        }
    }
}
