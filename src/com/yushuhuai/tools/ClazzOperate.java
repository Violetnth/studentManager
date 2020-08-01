package com.yushuhuai.tools;

import com.yushuhuai.bean.Clazz;
import com.yushuhuai.dao.ClazzDao;

import java.util.List;
import java.util.Scanner;

public class ClazzOperate {

    ClazzDao cd = new ClazzDao();
    Scanner sc = new Scanner(System.in);

    public void addclazz(){
        System.out.println("**********************添加*******************");
        System.out.print("请输入班级名称：");
        String name = sc.next();
        System.out.print("请输入班级号：");
        int t_id = sc.nextInt();
        cd.addCla(new Clazz(name,t_id));
        List<Clazz> allID = cd.selectAll();
        System.out.println("添加成功！");
        System.out.println(allID);
    }
    public void updateClazz(){
        List<Clazz> allID = cd.selectAll();
        System.out.println(allID);
        System.out.println("**********************修改*******************");
        System.out.print("请输入需要修改的班级ID：");
        int id = sc.nextInt();
        System.out.print("请输入新的班级名称：");
        String name = sc.next();
        System.out.print("请输入新的班级号：");
        int t_id = sc.nextInt();
        cd.updateAll(new Clazz(id,name,t_id));
        Clazz byId = cd.getById(id);
        System.out.println(byId);
    }
    public void delClazz(){
        xx:while (true) {
            System.out.println("**********************删除*******************");
            List<Clazz> allID = cd.selectAll();
            System.out.println(allID);
            System.out.print("请输入删除班级id：");
            int id = sc.nextInt();
            zz:
            while (true) {
                System.out.println("是否确认删除？");
                System.out.print("请输入（Y/N）：");
                String yn = sc.next();
                switch (yn) {
                    case "y":
                        cd.delCla(id);
                        System.out.println("删除成功..");
                        List<Clazz> allID1 = cd.selectAll();
                        System.out.println(allID1);
                        break xx;
                    case "n":
                        System.out.println("取消成功");
                        System.out.println("-------是否继续删除--1、继续--2、返回至班级管理----");
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
    public void selectCla(){
        xx:while (true){
            System.out.println("**********************查询*******************");
            System.out.println("1、多表联查--2、id查询--3、查询所有--4、返回上一级");
            System.out.print("请选择：");
            String input = sc.next();
            switch (input){
                case "1":
                    List<Clazz> all = cd.getAll();
                    System.out.println(all);
                    break;
                case "2":
                    System.out.print("请输入查询所在班级id：");
                    int id = sc.nextInt();
                    Clazz byId = cd.getById(id);
                    System.out.println(byId);
                    break;
                case "3":
                    List<Clazz> clazzes = cd.selectAll();
                    System.out.println(clazzes);
                    break;
                case "4":
                    break xx;
                default:
                    System.out.println("------------———-输入有误，请重新输入--------------");
                    continue xx;
            }
        }
    }
}
