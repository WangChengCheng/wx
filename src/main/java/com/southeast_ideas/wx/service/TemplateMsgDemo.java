package com.southeast_ideas.wx.service;

import com.southeast_ideas.wx.api.IWxCommonService;
import com.southeast_ideas.wx.api.IWxTempleteMessageService;
import com.southeast_ideas.wx.api.WxCommonService;
import com.southeast_ideas.wx.api.WxTempleteMessageService;
import com.southeast_ideas.wx.exception.WxErrorException;
import com.southeast_ideas.wx.pojo.TemplateSender;
import com.southeast_ideas.wx.pojo.TemplateSenderResult;
import com.southeast_ideas.wx.pojo.WxUserListResult;
import com.southeast_ideas.wx.pojo.demo.FirstTemplateMsg;
import com.southeast_ideas.wx.pojo.demo.TemplateMsgItem;

/**
 * Created by MichaelWang.
 * Date:2018/3/31
 * Time:20:40
 */
public class TemplateMsgDemo implements Runnable {
    private IWxCommonService iWxCommonService = new WxCommonService();
    private IWxTempleteMessageService iWxTempleteMessageService = new WxTempleteMessageService();
    private static String tempId = "LWLyiVXzpe607wZL-8V5LTa96hZ6Nbzk8KGIGZetK0U";
    public static volatile boolean EXIT = false;

    @Override
    public void run() {
        while (!EXIT) {
            try {
                WxUserListResult userListResult = iWxCommonService.batchGetUserOpenId(null);
                System.out.println("WxUserListResult======\n"+userListResult);
                System.out.println("Data==================\n"+userListResult.getData());
                String[] openIds = userListResult.getData().getOpenid();
                for (String openId : openIds) {
                    TemplateSender sender = new TemplateSender();
                    sender.setTouser(openId);
                    sender.setTemplate_id(tempId);
                    sender.setUrl("http://blog.southeast-ideas.com");
                    FirstTemplateMsg data = new FirstTemplateMsg();
                    data.setName(new TemplateMsgItem("老王","#173177"));
                    data.setGender(new TemplateMsgItem("男","#173177"));
                    data.setAge(new TemplateMsgItem("18","#173177"));
                    sender.setData(data);
                    TemplateSenderResult result = iWxTempleteMessageService.templateSend(sender);
                    System.out.println(result);
                }
            } catch (WxErrorException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 测试用
     * 要转换为json必须要有Getter方法
     */
    public class Me {
        private String name = "王**";
        private String gender = "男";
        private int age = 18;

        public Me() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public Me(String name, String gender, int age) {
            this.name = name;
            this.gender = gender;
            this.age = age;
        }

    }
}
