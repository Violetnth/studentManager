package com.yushuhuai.page;

import java.util.Scanner;

public class Index {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Signin si = new Signin();
        Login lo = new Login();
        System.out.println("**********欢迎使用Shelly学生信息管理系统**********");
        index:while (true){
            System.out.println("----------1、注册--2、登录--3、退出系统-----------");
            System.out.print("请选择：");
            String choose = sc.next();
            switch (choose){
                case "1": {
                    System.out.println("*********************************************");
                    System.out.println("---------------------注册---------------------");
                    si.sigin();
                }
                case "2": {

                    lo.login();
                    lo.operate();
                    break index;
                }
                case "3": {
                    System.out.println("*********************************************");
                    System.out.println("-------------------退出系统--------------------");
                    System.out.println("~~~~~~~~~~~~~~~~~欢迎下次使用再见~~~~~~~~~~~~~~~~");
                    System.exit(-1);
                }
                default: {
                    System.out.println("------------———-输入有误，请重新输入--------------");
                    continue index;
                }
            }
        }
        //嘿嘿嘿
        Sturation sturation = new Sturation();
        sturation.caidan();
    }
}
