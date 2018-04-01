package com.southeast_ideas.wx.api;

import com.southeast_ideas.wx.exception.WxErrorException;
import com.southeast_ideas.wx.pojo.*;

/**
 * Created by MichaelWang.
 * Date:2018/3/31
 * Time:15:16
 */
public interface IWxTempleteMessageService {
    /**
     * <pre>
     * 模板消息--设置行业
     *
     * 参数参考：{@link http://mp.weixin.qq.com/wiki/5/6dde9eaa909f83354e0094dc3ad99e05.html}的行业代码
     * </pre>
     *
     * @return
     * @throws WxErrorException
     */
    WxError templateSetIndustry(String industry1, String industry2) throws WxErrorException;

    /**
     * <pre>
     * 模板消息--获取设置的行业信息
     *
     * 参数参考：{@link http://mp.weixin.qq.com/wiki/5/6dde9eaa909f83354e0094dc3ad99e05.html}的行业代码
     * </pre>
     *
     * @return
     * @throws WxErrorException
     */
    IndustryResult templateGetIndustry() throws WxErrorException;

    /**
     * <pre>
     * 模板消息--获取模板ID
     *
     * 参数参考：{@link http://mp.weixin.qq.com/wiki/5/6dde9eaa909f83354e0094dc3ad99e05.html }的行业代码
     * </pre>
     *
     * @return
     * @throws WxErrorException
     */
    TemplateResult templateGetId(String template_id_short)throws WxErrorException;

    /**
     * <pre>
     * 模板消息--获取模板列表
     *
     * 参数参考：{@link http://mp.weixin.qq.com/wiki/5/6dde9eaa909f83354e0094dc3ad99e05.html}的行业代码
     * </pre>
     *
     * @return
     * @throws WxErrorException
     */
    TemplateListResult templateGetList()throws WxErrorException;

    /**
     * <pre>
     * 模板消息--删除模板
     *
     * 参数参考：{@link http://mp.weixin.qq.com/wiki/5/6dde9eaa909f83354e0094dc3ad99e05.html}的行业代码
     * </pre>
     *
     * @return
     * @throws WxErrorException
     */
    WxError templateDelete(String template_id)throws WxErrorException;

    /**
     * <pre>
     * 模板消息--发送模板
     *
     * 参数参考：{@link http://mp.weixin.qq.com/wiki/5/6dde9eaa909f83354e0094dc3ad99e05.html}的行业代码
     * </pre>
     *
     * @return
     * @throws WxErrorException
     */
    TemplateSenderResult templateSend(TemplateSender sender)throws WxErrorException;
}
