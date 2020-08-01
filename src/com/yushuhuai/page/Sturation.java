package com.yushuhuai.page;


public class Sturation {
    public void caidan(){
        int tougao = 6;
        int jiankuan =25;
        int kuang = 70;
        for (int i = 1; i < tougao + jiankuan; i++) {
            for (int j = 1; j < kuang ; j++) {
                //上三角
                if (i <= tougao){
                    if (j >= (kuang/2+1)+1-i && j<=(kuang/2+1)-1+i){
                        System.out.print("哈");
                    }else {
                        System.out.print("嘿");
                    }
                }
                //下三角
                if (i>tougao && i<= jiankuan){
                    if (j>=(kuang/2+1)+1-i && j<=kuang-3*(i-tougao)){
                        System.out.print("哈");
                    }else if (j<=(kuang/2+1)-1+i && j>=0+3*(i-tougao)){
                        System.out.print("哈");
                    }else {
                        System.out.print("嘿");
                    }
                }
            }
            System.out.println("");
        }

        System.out.println("欢迎下次使用个屁er~~~");
        System.out.println("能看见打印输出这两句话，都是好兄弟~~~~~~");
    }

}
