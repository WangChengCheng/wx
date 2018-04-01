package com.southeast_ideas.wx.pojo.demo;

/**
 * Created by MichaelWang.
 * Date:2018/4/1
 * Time:14:59
 */

/**
 * TemplateSender--FirstTemplateMsg--TemplateMsgItem 模板消息一共三级
 * {

     "touser":"OPENID",
     "template_id":"ngqIpbwh8bUfcSsECmogfXcV14J0tQlEpBO27izEYtY",
     "url":"http://weixin.qq.com/download",
     "topcolor":"#FF0000",
     "data":{
         "User": {
             "value":"黄先生",
             "color":"#173177"
         },

         "Date":{
             "value":"06月07日 19时24分",
             "color":"#173177"
         },

         "CardNumber": {
             "value":"0426",
             "color":"#173177"
         },

         "Type":{
             "value":"消费",
             "color":"#173177"
         },

         "Money":{
             "value":"人民币260.00元",
             "color":"#173177"
         },

         "DeadTime":{
             "value":"06月07日19时24分",
             "color":"#173177"
         },

         "Left":{
             "value":"6504.09",
             "color":"#173177"
         }
     }
 }
 */
public class FirstTemplateMsg {
    private TemplateMsgItem name;
    private TemplateMsgItem gender;
    private TemplateMsgItem age;



    public TemplateMsgItem getName() {
        return name;
    }

    public void setName(TemplateMsgItem name) {
        this.name = name;
    }

    public TemplateMsgItem getGender() {
        return gender;
    }

    public void setGender(TemplateMsgItem gender) {
        this.gender = gender;
    }

    public TemplateMsgItem getAge() {
        return age;
    }

    public void setAge(TemplateMsgItem age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "FirstTemplateMsg{" +
                "name=" + name +
                ", gender=" + gender +
                ", age=" + age +
                '}';
    }
}
