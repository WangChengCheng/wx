package com.southeast_ideas.wx.exception;

import com.southeast_ideas.wx.pojo.WxError;

/**
 * Created by MichaelWang.
 * Date:2018/3/31
 * Time:15:00
 */
public class WxErrorException extends Exception {
    private WxError wxError;

    public WxErrorException(WxError wxError) {
        super(wxError.toString());
        this.wxError = wxError;
    }

    public WxErrorException(String errMsg) {
        super(errMsg);
    }

    public WxError getWxError() {
        return wxError;
    }
}
