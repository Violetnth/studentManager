package com.yushuhuai.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DAO {

    public void update(Connection conn, String sql, Object...args){
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                pstmt.setObject(i+1,args[i]);
            }
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCTools.release(pstmt,null);
        }
    }

    public <E> E getForValue(String sql,Object ...args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCTools.getConnection();
            pstmt = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                pstmt.setObject(i+1, args[i]);
            }
            rs = pstmt.executeQuery();
            if(rs.next()) {
                return (E) rs.getObject(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(pstmt, conn);
        }
        return null;
    }

    public <T> List<T> getForList(Class<T> clazz, String sql, Object ... args){
        List<T> list = new ArrayList<T>();
        T entity = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCTools.getConnection();
            pstmt = conn.prepareStatement(sql);
            for(int i = 0;i < args.length;i++) {
                pstmt.setObject(i+1, args[i]);
            }
            rs = pstmt.executeQuery();
            List<Map<String,Object>> values = new ArrayList<Map<String,Object>>();
            ResultSetMetaData rsmd = rs.getMetaData();
            Map<String, Object> map = null;
            while(rs.next()) {
                map = new HashMap<String, Object>();
                for(int i = 0;i < rsmd.getColumnCount();i++) {
                    String columnLabel = rsmd.getColumnLabel(i+1);
                    Object columnValue = rs.getObject(columnLabel);
                    map.put(columnLabel, columnValue);
                }
                values.add(map);
            }
            if(values.size() > 0) {
                for (Map<String, Object> m : values) {
                    entity = clazz.newInstance();
                    for (Map.Entry<String, Object> entry : m.entrySet()) {
                        String fieldName = entry.getKey();
                        Object fieldValue = entry.getValue();
                        BeanUtils.setProperty(entity, fieldName, fieldValue);
                    }
                    list.add(entity);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(rs, pstmt, conn);
        }
        return list;
    }

    public <T> T get(Class<T> clazz,String sql,Object ... args) {
        T entity = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCTools.getConnection();
            pstmt = conn.prepareStatement(sql);
            for(int i = 0;i < args.length; i ++) {
                pstmt.setObject(i+1, args[i]);
            }
            rs = pstmt.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            Map<String , Object> values = new HashMap<String, Object>();
            while(rs.next()) {
                for(int i = 0;i < rsmd.getColumnCount(); i ++) {
                    String columnLabel = rsmd.getColumnLabel(i+1);
                    Object columnValue = rs.getObject(columnLabel);
                    values.put(columnLabel, columnValue);
                }
            }
            if(values.size() > 0) {
                entity = clazz.newInstance();
                for(Map.Entry<String, Object> entry : values.entrySet()) {
                    String fieldName = entry.getKey();
                    Object fieldValue = entry.getValue();
                    BeanUtils.setProperty(entity, fieldName, fieldValue);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCTools.release(rs, pstmt,conn);
        }
        return entity;
    }

}
