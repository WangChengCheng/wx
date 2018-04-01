package com.southeast_ideas.wx.api;

import com.southeast_ideas.wx.exception.WxErrorException;
import com.southeast_ideas.wx.pojo.WxAccessToken;
import com.southeast_ideas.wx.pojo.WxUserListResult;
import com.southeast_ideas.wx.utils.http.RequestExecutor;
import com.southeast_ideas.wx.utils.http.SimpleGetRequestExecutor;
import com.southeast_ideas.wx.utils.http.SimplePostRequestExecutor;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

/**
 * Created by MichaelWang.
 * Date:2018/3/29
 * Time:16:33
 */
public class WxCommonService implements IWxCommonService {
    private Logger logger = LoggerFactory.getLogger(WxCommonService.class);
    //HttpClient
    protected CloseableHttpClient httpClient;

    /**
     * 构造方法，初始化httpClient
     */
    public WxCommonService() {
        httpClient = HttpClients.createDefault();
    }

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

    @Override
    public String getAccessToken() throws WxErrorException {
        return getAccessToken(false);
    }

    @Override
    public String getAccessToken(boolean forceRefresh) throws WxErrorException {
        if (forceRefresh) {
            WxConfig.getInstance().expireAccessToken();
        }
        if (WxConfig.getInstance().isAccessTokenExpired()) {
            synchronized (WxConfig.GLOBAL_ACCESS_TOKEN_REFRESH_LOCK) {
                if (WxConfig.getInstance().isAccessTokenExpired()) {
                    String url = WxConsts.URL_GET_ACCESSTOEKN
                                .replace("APPID", WxConfig.getInstance().getAppId())
                                .replace("APPSECRET", WxConfig.getInstance().getAppSecret());
                    System.out.println("URL_GET_ACCESSTOEKN="+url);
                    try {
                        String resultContent = get(url, null);
                        WxAccessToken accessToken = WxAccessToken.fromJson(resultContent);
                        WxConfig.getInstance().updateAccessToken(accessToken.getAccess_token(), accessToken.getExpires_in());
                        logger.info("Update AccessToken Success.");
                    } catch (IOException e) {
                        throw new WxErrorException("Update AccessToken Failure.");
                    }
                }
            }
        }
        return WxConfig.getInstance().getAccessToken();
    }

    @Override
    public String get(String url, Map<String, String> params) throws WxErrorException {
        return execute(new SimpleGetRequestExecutor(), url, params);
    }

    @Override
    public String post(String url, String params) throws WxErrorException {
        return execute(new SimplePostRequestExecutor(), url, params);
    }

    @Override
    public <T, E> T execute(RequestExecutor<T, E> executor, String uri, E data) throws WxErrorException {
        try {
            return executeInternal(executor, uri, data);
        } catch (WxErrorException e) {
            throw e;
        }
    }

    /**
     * 请求执行器
     *
     * @param executor
     * @param uri
     * @param data
     * @return
     * @throws WxErrorException
     * @throws IOException
     */
    protected synchronized <T, E> T executeInternal(RequestExecutor<T, E> executor, String uri, E data)
            throws WxErrorException{
        try {
            return executor.execute(getHttpclient(), uri, data);
        } catch (WxErrorException e) {
            throw e;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected CloseableHttpClient getHttpclient() {
        return this.httpClient;
    }

    @Override
    public WxUserListResult batchGetUserOpenId(String next_openid) throws WxErrorException {
        WxUserListResult result = null;
        next_openid = next_openid != null ? next_openid : "";
        String url = WxConsts.URL_BATCH_GET_USER_OPENID.replace("ACCESS_TOKEN", getAccessToken()).replace("NEXT_OPENID",
                next_openid);
        String getResult = get(url, null);
        try {
            result = WxUserListResult.fromJson(getResult);
        } catch (IOException e) {
            throw new WxErrorException("[wx-tools]batchGetUserOpenId failure.");
        }
        return result;
    }
}
