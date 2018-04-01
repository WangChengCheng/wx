package com.southeast_ideas.wx.utils.http;

/**
 * Created by MichaelWang.
 * Date:2018/3/31
 * Time:17:27
 */

import com.southeast_ideas.wx.exception.WxErrorException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.impl.client.CloseableHttpClient;

import java.io.IOException;

/**
 * http请求执行器
 * @param <T> 返回值类型
 * @param <E> 请求参数类型
 */
public interface RequestExecutor<T, E> {
    /**
     *
     * @param httpclient
     *            传入的httpClient
     * @param uri
     *            uri
     * @param data
     *            数据
     * @return
     * @throws WxErrorException
     * @throws ClientProtocolException
     * @throws IOException
     */
    public T execute(CloseableHttpClient httpclient, String uri, E data)
            throws WxErrorException, ClientProtocolException, IOException;
}
