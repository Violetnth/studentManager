package com.yushuhuai.dao;

import com.yushuhuai.bean.Customer;
import com.yushuhuai.utils.DAO;
import com.yushuhuai.utils.JDBCTools;

import java.sql.Connection;

public class CustomerDao extends DAO {

    private static Connection conn = null;
    static {
        try {
            conn = JDBCTools.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addcus(Customer customer){
        String sql = "insert into customer(username,password,message) values(?,?,?)";
        super.update(conn, sql, customer.getUsername(), customer.getPassword(),customer.getMessage());
    }

    public void updatepassword(Customer cus){
        String sql = "update customer set password = ? where username = ? ";
        super.update(conn,sql,cus.getPassword(),cus.getUsername());
    }



    public String getSigninById(){
        String sql = "select * from customer where username = ?";
        return sql;
    }

    public String getLoginById(){
        String sql = "select * from customer where username = ? and password = ?";
        return sql;
    }

    public String getmessage(){
        String sql = "select * from customer where message = ? and username = ?";
        return sql;
    }

}
