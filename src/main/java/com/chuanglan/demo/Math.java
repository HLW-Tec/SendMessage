package com.chuanglan.demo;


import java.util.*;

/**
 * Created by Administrator on 2017/10/21.
 */
public class Math {
    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();
        Random rand = new Random();
        for(int i = 0; i < 1; i++)
            while(!list.add(rand.nextInt(900000)+1));
        String msg="【葫芦娃签】你好,你的验证码是";
        for (Integer integer : list) {
            msg +=integer;
        }
        System.out.println(msg);
    }
}
