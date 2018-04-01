package com.southeast_ideas.wx.api;

import com.southeast_ideas.wx.exception.WxErrorException;
import com.southeast_ideas.wx.pojo.*;

import java.io.IOException;

/**
 * Created by MichaelWang.
 * Date:2018/3/31
 * Time:16:46
 */
public class WxTempleteMessageService implements IWxTempleteMessageService {

    private IWxCommonService iWxCommonService = new WxCommonService();

    @Override
    public WxError templateSetIndustry(String industry1, String industry2) throws WxErrorException {
        WxError wxError;
        String url = WxConsts.URL_TEMPLATE_SET_INDUSTRY.replace("ACCESS_TOKEN", iWxCommonService.getAccessToken());
        String json = "{\"industry_id1\":\""+industry1+"\",\"industry_id2\":\""+industry2+"\"}";
        try {
            String postResult = iWxCommonService.post(url, json);
            wxError = WxError.fromJson(postResult);
        } catch (IOException e) {
            throw new WxErrorException("TemplateSetIndustry Failure.");
        }
        return wxError;
    }

    @Override
    public IndustryResult templateGetIndustry() throws WxErrorException {
        IndustryResult result = null;
        String getResult = null;
        String url = WxConsts.URL_TEMPLATE_GET_INDUSTRY.replace("ACCESS_TOKEN", iWxCommonService.getAccessToken());
        try {
            getResult = iWxCommonService.get(url, null);
            result = IndustryResult.fromJson(getResult);
        } catch (IOException e) {
            throw new WxErrorException("TemplateGetIndustry Failure.");
        }
        return result;
    }

    @Override
    public TemplateResult templateGetId(String template_id_short) throws WxErrorException {
        TemplateResult result = null;
        String postResult = null;
        String url = WxConsts.URL_TEMPLATE_GET_ID.replace("ACCESS_TOKEN", iWxCommonService.getAccessToken());
        String json = "{\"template_id_short\":\""+template_id_short+"\"}";
        try {
            postResult = iWxCommonService.post(url, json);
            result = TemplateResult.fromJson(postResult);
        } catch (IOException e) {
            throw new WxErrorException("TemplateGetId Failure.");
        }
        return result;
    }

    @Override
    public TemplateListResult templateGetList() throws WxErrorException {
        TemplateListResult result = null;
        String getResult = null;
        String url = WxConsts.URL_TEMPLATE_GET_LIST.replace("ACCESS_TOKEN", iWxCommonService.getAccessToken());
        try {
            getResult = iWxCommonService.get(url, null);
            result = TemplateListResult.fromJson(getResult);
        } catch (IOException e) {
            throw new WxErrorException("TemplateGetList Failure.");
        }
        return result;
    }

    @Override
    public WxError templateDelete(String template_id) throws WxErrorException {
        WxError result = null;
        String postResult = null;
        String url = WxConsts.URL_TEMPLATE_DELETE.replace("ACCESS_TOKEN", iWxCommonService.getAccessToken());
        String json = "{\"template_id\":\""+template_id+"\"}";
        try {
            postResult = iWxCommonService.post(url, json);
            result = WxError.fromJson(postResult);
        } catch (IOException e) {
            throw new WxErrorException("TemplateDelete Failure.");
        }
        return result;
    }

    @Override
    public TemplateSenderResult templateSend(TemplateSender sender) throws WxErrorException {
        TemplateSenderResult result = null;
        String postResult = null;
        String url = WxConsts.URL_TEMPLATE_SEND.replace("ACCESS_TOKEN", iWxCommonService.getAccessToken());
        System.out.println("URL_TEMPLATE_SEND:"+url);
        try {
            System.out.println("           sender:"+sender.toJson());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            postResult = iWxCommonService.post(url, sender.toJson());
            result = TemplateSenderResult.fromJson(postResult);
        } catch (IOException e) {
            System.out.println("postResult:"+postResult);
            throw new WxErrorException("TemplateSend Failure.");
        }
        return result;
    }
}
