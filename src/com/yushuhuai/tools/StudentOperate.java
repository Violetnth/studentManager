package com.yushuhuai.tools;

import com.yushuhuai.bean.Student;
import com.yushuhuai.bean.Teacher;
import com.yushuhuai.dao.StudentDao;

import java.util.List;
import java.util.Scanner;

public class StudentOperate {
    StudentDao std = new StudentDao();
    Scanner sc = new Scanner(System.in);
    public void addstd(){
        System.out.println("*********************添加**********************");
        System.out.print("请输入学生的姓名：");
        String name = sc.next();
        System.out.print("请输入学生性别：");
        String gender = sc.next();
        System.out.print("请输入学生手机号：");
        String phone = sc.next();
        System.out.print("请输入学生班级：");
        String clazz_id = sc.next();
        std.addStu(new Student(name,gender,phone,clazz_id));

        List<Student> byall = std.getByall();
        System.out.println("添加成功");
        System.out.println(byall);
    }

    public void updatestd(){
        List<Student> alltea = std.getByall();
        System.out.println(alltea);
        System.out.println("*********************修改**********************");
        System.out.println("--------------如需不修改，请输入null--------------");
        System.out.print("请输入修改学生id：");
        int id = sc.nextInt();
        System.out.print("请输入修改学生姓名：");
        String name = sc.next();
        System.out.print("请输入修改学生性别：");
        String gender = sc.next();
        System.out.print("请输入修改学生手机号：");
        String phone = sc.next();
        System.out.print("请输入修改学生班级：");
        String clazz = sc.next();
        std.updateStu(new Student(id,name,gender,phone,clazz));
        Student byId = std.getById(id);
        System.out.println("修改成功");
        System.out.println(byId);
    }

    public void delStuO(){
        xx:while (true){
            System.out.println("***********************删除********************");
            List<Student> byall = std.getByall();
            System.out.println(byall);
            System.out.print("请输出所删学生的id:");
            int id = sc.nextInt();
            zz:while (true) {
                System.out.println("是否确认删除？");
                System.out.print("请输入（Y/N）：");
                String yn = sc.next();
                switch (yn) {
                    case "y":
                        std.delStu(id);
                        System.out.println("删除成功");
                        List<Student> byall1 = std.getByall();
                        System.out.println(byall1);
                        break xx;
                    case "n":
                        System.out.println("取消成功");
                        System.out.println("-------是否继续删除--1、继续--2、返回至学生管理----");
                        System.out.print("请选择：");
                        int i = sc.nextInt();
                        if (i == 1) {
                            continue xx;
                        }else if (i == 2){
                            break xx;
                        }else {
                            System.out.println("输入其他类型，自动返回");
                            continue xx;
                        }
                    default:
                        System.out.println("------------———-输入有误，请重新输入--------------");
                        continue zz;
                }
            }
        }
    }

    public void selectStu(){
        xx:while (true){
            System.out.println("**********************查询*******************");
            System.out.println("1、多表联查--2、id查询--3、查询所有--4、姓名查询--5、返回上一级");
            System.out.print("请选择：");
            String sss = sc.next();
            switch (sss){
                case "1":{
                    List<Student> all = std.getAll();
                    System.out.println(all);
                    break;
                }
                case "2":{
                    System.out.print("请输入查询学生的id：");
                    int c = sc.nextInt();
                    Student byId = std.getById(c);
                    System.out.println(byId);
                    break;
                }
                case "3":{
                    List<Student> byall = std.getByall();
                    System.out.println(byall);
                    break;
                }
                case "4":{
                    System.out.print("请输入查询学生姓名：");
                    String name = sc.next();
                    List<Student> getname = std.getname(new Student(name, null, null, null));
                    System.out.println(getname);
                }
                case "5":{
                    break xx;
                }
                default:{
                    System.out.println("------------———-输入有误，请重新输入--------------");
                    continue xx;
                }
            }
        }
    }
}
