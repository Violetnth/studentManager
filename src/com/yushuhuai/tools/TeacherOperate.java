package com.yushuhuai.tools;

import com.yushuhuai.bean.Teacher;
import com.yushuhuai.dao.TeacherDao;

import java.util.List;
import java.util.Scanner;

public class TeacherOperate {
    TeacherDao td = new TeacherDao();
    Scanner sc = new Scanner(System.in);


    public void addtea(){
        System.out.println("**********************添加*******************");
        System.out.print("请输入教师姓名：");
        String name = sc.next();
        td.addtea(new Teacher(name));
        List<Teacher> alltea = td.getAlltea();
        System.out.println("添加成功");
        System.out.println(alltea);
    }

    public void updatetea(){
        List<Teacher> alltea = td.getAlltea();
        System.out.println(alltea);
        System.out.println("**********************修改*******************");
        System.out.print("请输入修改教师id：");
        int id = sc.nextInt();
        Teacher byId = td.getById(id);
        System.out.println(byId);
        System.out.print("请输入修改教师姓名：");
        String name = sc.next();
        td.updatetea(new Teacher(id,name));
        Teacher byId1 = td.getById(id);
        System.out.println("修改成功");
        System.out.println(byId1);
    }

    public void deltea(){
        xx:while (true) {
            System.out.println("**********************删除*******************");
            List<Teacher> alltea = td.getAlltea();
            System.out.println(alltea);
            System.out.println("请输入删除教师id：");
            int id = sc.nextInt();
            zz:
            while (true) {
                System.out.println("是否确认删除？");
                System.out.print("请输入（Y/N）：");
                String yn = sc.next();
                switch (yn) {
                    case "y":
                        td.deltea(id);
                        System.out.println("删除成功");
                        List<Teacher> alltea1 = td.getAlltea();
                        System.out.println(alltea1);
                        break xx;
                    case "n":
                        System.out.println("取消成功");
                        System.out.println("-------是否继续删除--1、继续--2、返回至教师管理----");
                        System.out.print("请选择：");
                        int i = sc.nextInt();
                        if (i == 1) {
                            continue xx;
                        } else if (i == 2) {
                            break xx;
                        } else {
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

    public void selecttea(){
        ss:while (true){
            System.out.println("**********************查询*******************");
            System.out.println("1、多表联查--2、id查询--3、查询所有--4、返回上一级");
            System.out.print("请选择：");
            String input = sc.next();
            switch (input){
                case "1":
                    List<Teacher> all = td.getAll();
                    System.out.println(all);
                    break;
                case "2":
                    System.out.print("请输入查询教师id：");
                    int id = sc.nextInt();
                    Teacher byId = td.getById(id);
                    System.out.println(byId);
                    break;
                case "3":
                    List<Teacher> alltea = td.getAlltea();
                    System.out.println(alltea);
                    break;
                case "4":
                    break ss;
                default:
                    System.out.println("------------———-输入有误，请重新输入--------------");
                    continue ss;
            }
        }
    }

}
