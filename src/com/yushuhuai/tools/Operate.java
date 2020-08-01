package com.yushuhuai.tools;

import java.util.Scanner;

/**
 * 总操控台
 */
public class Operate {
    Scanner sc = new Scanner(System.in);
    public void studento(){
        xc:
        while (true) {
            StudentOperate so = new StudentOperate();
            System.out.println("——————————————————————学生管理——————————————————————");
            System.out.println("1、添加--2、修改--3、删除--4、查询--5、返回上一层--6、退出");
            System.out.print("请选择：");
            String input1 = sc.next();
            switch (input1) {
                case "1":
                    so.addstd();
                    break;
                case "2":
                    so.updatestd();
                    break;
                case "3":
                    so.delStuO();
                    break;
                case "4":
                    so.selectStu();
                    break;
                case "5":
                    break xc;
                case "6":
                    System.out.println("*********************************************");
                    System.out.println("-------------------退出系统--------------------");
                    System.out.println("~~~~~~~~~~~~~~~~~欢迎下次使用再见~~~~~~~~~~~~~~~~");
                    System.exit(-1);
                default:
                    System.out.println("------------———-输入有误，请重新输入--------------");
                    continue xc;
            }
        }
    }

    public void teachero(){
        TeacherOperate to = new TeacherOperate();
        xc:
        while (true){
            System.out.println("——————————————————————教师管理——————————————————————");
            System.out.println("1、添加--2、修改--3、删除--4、查询--5、返回上一层--6、退出");
            System.out.print("请选择：");
            String input = sc.next();
            switch (input){
                case "1":
                    to.addtea();
                    break;
                case "2":
                    to.updatetea();
                    break;
                case "3":
                    to.deltea();
                    break;
                case "4":
                    to.selecttea();
                    break;
                case "5":
                    break xc;
                case "6":
                    System.out.println("*********************************************");
                    System.out.println("-------------------退出系统--------------------");
                    System.out.println("~~~~~~~~~~~~~~~~~欢迎下次使用再见~~~~~~~~~~~~~~~~");
                    System.exit(-1);
                default:
                    System.out.println("------------———-输入有误，请重新输入--------------");
                    continue xc;
            }

        }
    }

    public void clazzo(){
        ClazzOperate co = new ClazzOperate();
        xc:while (true){
            System.out.println("——————————————————————班级管理——————————————————————");
            System.out.println("1、添加--2、修改--3、删除--4、查询--5、返回上一层--6、退出");
            System.out.print("请选择：");
            String input = sc.next();
            switch (input){
                case "1":
                    co.addclazz();
                    break;
                case "2":
                    co.updateClazz();
                    break;
                case "3":
                    co.delClazz();
                    break;
                case "4":
                    co.selectCla();
                    break;
                case "5":
                    break xc;
                case "6":
                    System.out.println("*********************************************");
                    System.out.println("-------------------退出系统--------------------");
                    System.out.println("~~~~~~~~~~~~~~~~~欢迎下次使用再见~~~~~~~~~~~~~~~~");
                    System.exit(-1);
                default:
                    System.out.println("------------———-输入有误，请重新输入--------------");
                    continue xc;
            }
        }

    }
}
