package com.yushuhuai.dao;

import com.yushuhuai.bean.Student;
import com.yushuhuai.utils.DAO;
import com.yushuhuai.utils.JDBCTools;

import java.sql.Connection;
import java.util.List;

public class StudentDao extends DAO {
    private static Connection conn = null;
    static {
        try {
            conn = JDBCTools.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Student> getAll(){
        String sql = "select  s.* , t.name as tname , c.name as cname  from student s,teacher t,clazz c where s.clazz_id = c.t_id and c.id = t.id";
        return super.getForList(Student.class,sql);
    }

    public Student getById(Integer id){
        String sql = "select * from student where id = ?";
        return super.get(Student.class,sql,id);
    }

    public List<Student> getByall(){
        String sql = "select * from student";
        return super.getForList(Student.class,sql);
    }


    public List<Student> getname(Student stu){
        String sql = "select * from student where  name = ?";
        return super.getForList(Student.class,sql,stu.getName());
    }

    public void updateStu(Student stu){
        StringBuilder strb = new StringBuilder();
        strb.append("update student set ");
        String input = "null";
        if(!stu.getName().equals(input)){
            strb.append("name = '"+stu.getName()+"'");
            if (!stu.getGender().equals(input)){
                strb.append(" , gender = '"+stu.getGender()+"'");
            }

            if (!stu.getPhone().equals(input)){
                strb.append(" , phone = '"+stu.getPhone()+"'");
            }

            if(!stu.getClazz_id().equals(input)){
                strb.append(" , clazz_id = '"+stu.getClazz_id()+ "'");
            }

        }else
        if (!stu.getGender().equals(input)){
            strb.append("gender = '"+stu.getGender()+"'");
            if (!stu.getPhone().equals(input)){
                strb.append(" , phone = '"+stu.getPhone()+"'");
            }

            if(!stu.getClazz_id().equals(input)){
                strb.append(" , clazz_id = '"+stu.getClazz_id()+ "'");
            }
        }else
        if (!stu.getPhone().equals(input)){
            strb.append("phone = '"+stu.getPhone()+"'");
            if(!stu.getClazz_id().equals(input)){
                strb.append(" , clazz_id = '"+stu.getClazz_id()+ "'");
            }
        }else
        if(!stu.getClazz_id().equals(input)){
            strb.append(" clazz_id = '"+stu.getClazz_id()+ "'");
        }
        strb.append(" where id = " +stu.getId());
        String sql = strb.toString();
        super.update(conn,sql);
    }

    public void addStu(Student stu){
        String sql = "insert into student(name,gender,phone,clazz_id) values(?,?,?,?)";
        super.update(conn,sql,stu.getName(),stu.getGender(),stu.getPhone(),stu.getClazz_id());
    }



    public void delStu(Integer id){
        String sql = "delete from student where id = ?";
        super.update(conn,sql,id);
    }
}
