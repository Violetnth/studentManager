package com.yushuhuai.page;

import com.yushuhuai.bean.Customer;
import com.yushuhuai.dao.CustomerDao;
import com.yushuhuai.utils.JDBCTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class UpdatePassword {

    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private Scanner sc = new Scanner(System.in);
    private CustomerDao cd = new CustomerDao();


    public void update(){
        zz:while (true){
            System.out.print("请输入需要修改的密码的用户名：");
            String username = sc.next();
            System.out.println("请选择验证信息：1、您的名字是？2、您父亲的名字是？3、您母亲的名字是？4、退出");
            System.out.print("请输入：");
            String input = sc.next();
            switch (input){
                case "1": {
                    xx:while(true){
                        try {
                            System.out.print("请输入您的名字是：");
                            String message = sc.next();
                            conn = JDBCTools.getConnection();
                            pstmt = conn.prepareStatement(cd.getmessage());
                            pstmt.setObject(1,message);
                            pstmt.setObject(2,username);
                            rs = pstmt.executeQuery();
                            if(rs.next()){
                                System.out.println("验证成功！！！");
                                System.out.print("请输入修改密码（注意只有这一次机会）：");
                                String password = sc.next();
                                cd.updatepassword(new Customer(username,password,null));
                                System.out.println("修改成功,请登录...");
                                break zz;
                            }else {
                                System.out.println("修改失败，请重新选择...");
                                continue zz;
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }finally {
                            JDBCTools.release(rs,pstmt,conn);
                        }
                    }
                }
                case "2":{
                    xx:while(true){
                        try {
                            System.out.print("请输入您父亲的名字是：");
                            String message = sc.next();
                            conn = JDBCTools.getConnection();
                            pstmt = conn.prepareStatement(cd.getmessage());
                            pstmt.setObject(1,message);
                            pstmt.setObject(2,username);
                            rs = pstmt.executeQuery();
                            if(rs.next()){
                                System.out.println("验证成功！！！");
                                System.out.print("请输入修改密码（注意只有这一次机会）：");
                                String password = sc.next();
                                cd.updatepassword(new Customer(username,password,null));
                                System.out.println("修改成功,请登录...");
                                break zz;
                            }else {
                                System.out.println("修改失败，请重新选择...");
                                continue zz;
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }finally {
                            JDBCTools.release(rs,pstmt,conn);
                        }
                    }
                }
                case "3":{
                    xx:while(true){
                        try {
                            System.out.print("请输入您母亲的名字是：");
                            String message = sc.next();
                            conn = JDBCTools.getConnection();
                            pstmt = conn.prepareStatement(cd.getmessage());
                            pstmt.setObject(1,message);
                            pstmt.setObject(2,username);
                            rs = pstmt.executeQuery();
                            if(rs.next()){
                                System.out.println("验证成功！！！");
                                System.out.print("请输入修改密码（注意只有这一次机会）：");
                                String password = sc.next();
                                cd.updatepassword(new Customer(username,password,null));
                                System.out.println("修改成功,请登录...");
                                break zz;
                            }else {
                                System.out.println("修改失败，请重新选择...");
                                continue zz;
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }finally {
                            JDBCTools.release(rs,pstmt,conn);
                        }
                    }
                }
                case "4":{
                    System.out.println("*********************************************");
                    System.out.println("-------------------退出系统--------------------");
                    System.out.println("~~~~~~~~~~~~~~~~~欢迎下次使用再见~~~~~~~~~~~~~~~~");
                    System.exit(-1);
                }
                default:{
                    System.out.println("输入其他类型，请重新输入");
                    continue zz;
                }
            }
        }
    }



    public void udpa(String str) {


    }

}
