package com.southeast_ideas.wx.api;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by MichaelWang.
 * Date:2018/3/29
 * Time:16:31
 */
public interface IWxCommonService {
    /**
     * 验证Token
     * @param timestamp
     * @param nonce
     * @param signature
     * @return
     */
    boolean verifyToken(String timestamp, String nonce, String signature);

    void test();
}
