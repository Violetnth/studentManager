package com.yushuhuai.dao;

import com.yushuhuai.bean.Clazz;
import com.yushuhuai.utils.DAO;
import com.yushuhuai.utils.JDBCTools;

import java.sql.Connection;
import java.util.List;

public class ClazzDao extends DAO {

    private static Connection conn = null;
    static {
        try {
            conn = JDBCTools.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public List<Clazz> getAll(){
        String sql = "select c.*, t.name as tname , s.name as sname from student s,teacher t,clazz c where s.clazz_id = c.t_id and c.id = t.id";
        return super.getForList(Clazz.class,sql);
    }
    public Clazz getById(Integer id){
        String sql = "select * from clazz where id = ?";
        return super.get(Clazz.class,sql,id);
    }
    public List<Clazz> selectAll(){
        String sql = "select * from clazz";
        return super.getForList(Clazz.class,sql);
    }



    public void addCla(Clazz cla){
        String sql = "insert into clazz(name,t_id) values(?,?)";
        super.update(conn,sql,cla.getName(),cla.getT_id());
    }



    public void updateAll(Clazz cla){
        String sql = "update clazz set t_id = ? , name = ? where id = ?";
        super.update(conn,sql,cla.getT_id(),cla.getName(),cla.getId());
    }


    public void delCla(Integer id){
        String sql = "delete from clazz where id = ?";
        super.update(conn,sql,id);
    }
}
