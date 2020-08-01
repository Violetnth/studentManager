package com.yushuhuai.page;

import com.yushuhuai.bean.Customer;
import com.yushuhuai.dao.CustomerDao;
import com.yushuhuai.utils.JDBCTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Signin {

    private CustomerDao cd = new CustomerDao();
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    public void sigin(){
        Scanner sc = new Scanner(System.in);
        qw:while (true) {
            try {
                conn = JDBCTools.getConnection();
                pstmt = conn.prepareStatement(cd.getSigninById());
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.print("请输入用户名：");
            String username = sc.next();
            if ("".equals(username)) {
                System.out.println("输入不能为空 ... 请重新输入");
                continue qw;
            } else {
                try {
                    pstmt.setObject(1, username);
                    rs = pstmt.executeQuery();
                    if (rs.next()) {
                        System.out.println("用户名重复...请重新注册");
                        continue qw;
                    } else {
                        yu:while (true){
                            System.out.print("请输入密码：");
                            String password = sc.next();
                            if("".equals(password) || password.equals(null)){
                                System.out.println("密码不能为空，请重新输入");
                                continue yu;
                            }else {
                                iu:while (true){
                                    System.out.print("确认密码：");
                                    String repassword = sc.next();
                                    if ("".equals(password) || password.equals(null)){
                                        System.out.println("密码不能为空，请重新输入");
                                        continue iu;
                                    }else {
                                        if (repassword.equals(password)){
                                            xx:while (true){
                                                System.out.println("请选择验证信息：1、您的名字是？2、您父亲的名字是？3、您母亲的名字是？4、退出");
                                                System.out.print("请选择：");
                                                String next = sc.next();
                                                if ("1".equals(next)){
                                                    System.out.print("请输入您的名字是：");
                                                    String message = sc.next();
                                                    cd.addcus(new Customer(username, password,message));
                                                    System.out.println("注册成功！！！ 请登录---------->");
                                                    break qw;
                                                }else if ("2".equals(next)){
                                                    System.out.print("请输入您父亲的名字是：");
                                                    String message = sc.next();
                                                    cd.addcus(new Customer(username, password,message));
                                                    System.out.println("注册成功！！！ 请登录---------->");
                                                    break qw;
                                                }else if ("3".equals(next)){
                                                    System.out.print("请输入您母亲的名字是：");
                                                    String message = sc.next();
                                                    cd.addcus(new Customer(username, password,message));
                                                    System.out.println("注册成功！！！ 请登录---------->");
                                                    break qw;
                                                }else if ("4".equals(next)){
                                                    System.out.println("*********************************************");
                                                    System.out.println("-------------------退出系统--------------------");
                                                    System.out.println("~~~~~~~~~~~~~~~~~欢迎下次使用再见~~~~~~~~~~~~~~~~");
                                                    System.exit(-1);
                                                }else {
                                                    System.out.println("------------———-输入有误，请重新输入--------------");
                                                    continue xx;
                                                }
                                            }
                                        }else {
                                            System.out.println("两次密码输入不一致，请重新输入");
                                            continue yu;
                                        }
                                    }
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    JDBCTools.release(rs, pstmt, conn);
                }
            }
        }
    }
}
