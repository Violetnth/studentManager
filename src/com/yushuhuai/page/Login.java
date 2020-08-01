package com.yushuhuai.page;

import com.yushuhuai.dao.CustomerDao;
import com.yushuhuai.tools.Operate;
import com.yushuhuai.utils.JDBCTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 * 登录与登陆成功之后的操作
 */
public class Login {

    private CustomerDao cd = new CustomerDao();
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private Scanner sc = new Scanner(System.in);
    private UpdatePassword up = new UpdatePassword();
    public void login(){
        rt:
        while (true) {

            try {
                conn = JDBCTools.getConnection();
                pstmt = conn.prepareStatement(cd.getLoginById());

                System.out.println("*********************************************");
                System.out.println("---------------------登录---------------------");
                System.out.print("请输入用户名：");
                String username = sc.next();
                System.out.print("请输入密码：");
                String password = sc.next();
                pstmt.setObject(1, username);
                pstmt.setObject(2, password);
                rs = pstmt.executeQuery();
                if (rs.next()) {
                    System.out.println("登陆成功...");
                    break rt;
                } else {
                    System.out.println("登陆失败--1、重新登陆--2、修改密码--3、退出系统");
                    System.out.print("请选择：");
                    String i = sc.next();
                    if ("1".equals(i)){
                        continue rt;
                    }else if ("2".equals(i) ){
                        up.update();
                        continue rt;
                    }else if ("3".equals(i)){
                        System.out.println("*********************************************");
                        System.out.println("-------------------退出系统--------------------");
                        System.out.println("~~~~~~~~~~~~~~~~~欢迎下次使用再见~~~~~~~~~~~~~~~~");
                        System.exit(-1);
                    }else {
                        System.out.println("输入了其他类型，默认重新登陆");
                        continue rt;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                JDBCTools.release(rs, pstmt, conn);
            }
        }
    }
    public void operate(){
        ta:
        while (true) {
            Operate op = new Operate();
            System.out.println("***********************菜单*********************");
            System.out.println("----1、学生管理--2、教师管理--3、班级管理--4、退出----");
            System.out.print("请选择：");
            String input = sc.next();
            switch (input) {
                case "1":{
                    op.studento();
                    break;
                }
                case "2":{
                    op.teachero();
                    break;
                }
                case "3":{
                    op.clazzo();
                    break;
                }
                case "4": {
                    System.out.println("*********************************************");
                    System.out.println("-------------------退出系统--------------------");
                    System.out.println("~~~~~~~~~~~~~~~~~欢迎下次使用再见~~~~~~~~~~~~~~~~");
                    System.exit(-1);
                }
                default:{
                    System.out.println("------------———-输入有误，请重新输入--------------");
                    for (int i = 1; i <= 20; i++) {
                        for (int j = 1; j <= i; j++) {
                            System.out.print("--");
                        }
                        System.out.println("");
                    }
                    System.out.println("-----哈哈！想看彩蛋不？想看的话，按1；不想看，按2------");
                    int i = sc.nextInt();
                    if(i == 1){
                        break ta;
                    }else {
                        System.out.println("不想看~~~~~那算了");
                        continue ta;
                    }
                }
            }
        }
    }
}
