package com.yushuhuai.dao;


import com.yushuhuai.bean.Clazz;
import com.yushuhuai.bean.Teacher;
import com.yushuhuai.utils.DAO;
import com.yushuhuai.utils.JDBCTools;

import java.sql.Connection;
import java.util.List;

public class TeacherDao extends DAO {
    private static Connection conn = null;
    static {
        try {
            conn = JDBCTools.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<Teacher> getAll(){
        String sql = "select t.* , c.name as cname,  s.name as sname from student s,teacher t,clazz c where s.clazz_id = c.t_id and c.id = t.id";
        return super.getForList(Teacher.class,sql);
    }

    public List<Teacher> getAlltea(){
        String sql = "select * from teacher";
        return super.getForList(Teacher.class,sql);
    }

    public Teacher getById(Integer id){
        String sql = "select * from teacher where id = ?";
        return super.get(Teacher.class,sql,id);
    }

    public void addtea(Teacher tea){
        String sql = "insert into teacher(name) values(?)";
        super.update(conn,sql,tea.getName());
    }

    public void updatetea(Teacher tea){
        String sql = "update teacher set name = ? where id = ? ";
        super.update(conn,sql,tea.getName(),tea.getId());
    }

    public void deltea(Integer id){
        String sql = "delete from teacher where id = ?";
        super.update(conn,sql,id);
    }
}
