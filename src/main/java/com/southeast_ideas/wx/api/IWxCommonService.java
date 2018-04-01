package com.southeast_ideas.wx.api;


import com.southeast_ideas.wx.exception.WxErrorException;
import com.southeast_ideas.wx.pojo.WxUserListResult;
import com.southeast_ideas.wx.utils.http.RequestExecutor;

import java.util.Map;

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

    /**
     * <pre>
     * 获取access_token, 不强制刷新access_token
     * 详情请见：{@link http://mp.weixin.qq.com/wiki/14/9f9c82c1af308e3b14ba9b973f99a8ba.html}
     * </pre>
     * @see #getAccessToken(boolean)
     * @return
     * @throws WxErrorException
     */
    String getAccessToken() throws WxErrorException;

    /**
     * <pre>
     * 获取access_token，本方法线程安全
     * 且在多线程同时刷新时只刷新一次，避免超出2000次/日的调用次数上限
     * 另：本service的所有方法都会在access_token过期是调用此方法
     * 程序员在非必要情况下尽量不要主动调用此方法
     * 详情请见: {@link http://mp.weixin.qq.com/wiki/14/9f9c82c1af308e3b14ba9b973f99a8ba.html}
     * </pre>
     *
     * @param forceRefresh
     *            强制刷新
     * @return
     * @throws WxErrorException
     */
    String getAccessToken(boolean forceRefresh) throws WxErrorException;

    /**
     * 当本Service没有实现某个API的时候，可以用这个，针对所有微信API中的GET请求
     *
     * @param url
     * @param queryParam
     * @return
     * @throws WxErrorException
     */
    String get(String url, Map<String, String> params) throws WxErrorException;

    /**
     * 当本Service没有实现某个API的时候，可以用这个，针对所有微信API中的POST请求
     *
     * @param url
     * @param postData
     * @return
     * @throws WxErrorException
     */
    String post(String url, String params) throws WxErrorException;

    /**
     * <pre>
     * Service没有实现某个API的时候，可以用这个，
     * 比{@link #get}和{@link #post}方法更灵活，可以自己构造RequestExecutor用来处理不同的参数和不同的返回类型。
     *
     * </pre>
     *
     * @param executor
     * @param uri
     * @param data
     * @param <T>
     * @param <E>
     * @return
     * @throws WxErrorException
     */
    <T, E> T execute(RequestExecutor<T, E> executor, String uri, E data) throws WxErrorException;

    /**
     * <pre>
     * 批量获取关注者openid
     * 详情请见：{@link http://mp.weixin.qq.com/wiki/12/54773ff6da7b8bdc95b7d2667d84b1d4.html}
     * </pre>
     * @param next_openid 第一个拉取的OPENID，不填默认从头开始拉取
     * @return
     * @throws WxErrorException
     */
    WxUserListResult batchGetUserOpenId(String next_openid) throws WxErrorException;
}
