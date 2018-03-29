package com.southeast_ideas.wx.api;

import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Properties;

/**
 * Created by MichaelWang.
 * Date:2018/3/29
 * Time:16:33
 */
public class WxCommonService implements IWxCommonService {
    @Override
    public boolean verifyToken(String timestamp, String nonce, String signature) {
        String token = WxConfig.getInstance().getToken();
        String[] arr = new String[] {token, timestamp, nonce};
        Arrays.sort(arr);
        StringBuffer stringBuffer = new StringBuffer();
        for (String s : arr) {
            System.out.println(s);
            stringBuffer.append(s);
        }
        return DigestUtils.shaHex(stringBuffer.toString()).equals(signature);
    }

    public void test() {
        System.out.println("testtesttesttesttesttesttesttest");
    }
}
