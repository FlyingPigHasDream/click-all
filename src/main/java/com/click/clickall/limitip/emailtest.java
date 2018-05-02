package com.click.clickall.limitip;

/**
 * @author LiaoYangJun
 * @createTime 2018/5/2.
 */
public class emailtest {

    public static void main(String[] args) throws Exception {
        String  msg = ShowMail.getAllEmail("huibu021812@sina.com","0C7YiW9E");

        System.out.println("msg=" + msg);
        String checkcode = msg.split("验证码：")[1].split("  半小时内有效")[0];
        System.out.println("-------------------");
        System.out.println("checkcode =" + checkcode);
        System.out.println("checkcode length = " + checkcode.length());
    }
}
