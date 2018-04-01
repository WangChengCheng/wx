package com.southeast_ideas.wx.api;

import com.southeast_ideas.wx.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 微信公众号配置信息
 * Created by MichaelWang.
 * Date:2018/3/29
 * Time:10:35
 */
public class WxConfig {
    //全局的是否正在刷新access token的锁
    public static final Object GLOBAL_ACCESS_TOKEN_REFRESH_LOCK = new Object();
    private static Logger logger = LoggerFactory.getLogger(WxConfig.class);
    //使用this.getClass().getResourceAsStream(configFile)时，前面需要加/
    //使用this.getClass().getClassLoader().getResourceAsStream(configFile)，前面不需要加/
    private static final String configFile = "/config/wx.properties";
    private static WxConfig config = new WxConfig();

    //配置文件读取项
    private volatile String appId;
    private volatile String appSecret;
    private volatile String token;
    private volatile String aesKey;
    private volatile String mchId;
    private volatile String apiKey;

    //AccessToken
    private volatile String accessToken;
    private volatile long expiresTime;

    private WxConfig() {
        Properties p = new Properties();
        InputStream inputStream = this.getClass().getResourceAsStream(configFile);
        if (inputStream == null) {
            try {
                throw new FileNotFoundException("找不到配置文件");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        try {
            p.load(inputStream);
            this.appId = p.getProperty("wx.appId");
            this.appId = StringUtils.isNotBlank(this.appId) ? this.appId.trim() : this.appId;
            this.appSecret = p.getProperty("wx.appSecret");
            this.appSecret = StringUtils.isNotBlank(this.appSecret) ? this.appSecret.trim() : this.appSecret;
            this.token = p.getProperty("wx.token");
            this.token = StringUtils.isNotBlank(this.token) ? this.token.trim() : this.token;
            this.aesKey = p.getProperty("wx.aesKey");
            this.aesKey = StringUtils.isNotBlank(this.aesKey) ? this.aesKey.trim() : this.aesKey;
            this.mchId = p.getProperty("wx.mchId");
            this.mchId = StringUtils.isNotBlank(this.mchId) ? this.mchId.trim() : this.mchId;
            this.apiKey = p.getProperty("wx.apiKey");
            this.apiKey = StringUtils.isNotBlank(this.apiKey) ? this.apiKey.trim() : this.apiKey;
            inputStream.close();
        } catch (IOException e) {
            logger.error("File \"wx.properties\" load failed!");
            e.printStackTrace();
        }
        logger.info("File \"wx.properties\" loaded successfully!");
    }

    /**
     * 单例模式
     * @return
     */
    public static synchronized WxConfig getInstance() {
        return config;
    }

    public String getAppId() {
        return appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public String getToken() {
        return token;
    }

    public String getAesKey() {
        return aesKey;
    }

    public String getMchId() {
        return mchId;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public long getExpiresTime() {
        return expiresTime;
    }

    /**
     * 强制使AccessToken过期
     */
    public void expireAccessToken() {
        this.expiresTime = 0;
    }

    /**
     * 判断AccessToken是否过期
     * @return
     */
    public boolean isAccessTokenExpired() {
        return System.currentTimeMillis() > this.expiresTime;
    }

    public synchronized void updateAccessToken(String accessToken, int expiresInSeconds) {
        this.accessToken = accessToken;
        this.expiresTime = System.currentTimeMillis() + (expiresInSeconds - 200) * 1000l;
    }
}
