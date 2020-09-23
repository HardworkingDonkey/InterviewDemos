package com.donkey.interview.tooffer;

/**
 * @Author 刻苦驴
 * @Date 2020.09.08
 * @Time 22:50
 * @Package PACKAGE_NAME
 * @Description 面试题2-单例模式
 */

public class ToOffer_02_Singleton {
    private static ToOffer_02_Singleton instance = null;

    private ToOffer_02_Singleton() {

    }

    public static ToOffer_02_Singleton getInstance() {
        if (instance == null) {
            synchronized ("a") {
                if (instance == null) {
                    return instance = new ToOffer_02_Singleton();
                }
            }
        }
        return instance;
    }

//    public static void main(String[] args) {
//        System.out.println(com.donkey.ToOffer_02_Singleton.getInstance());
//        System.out.println(com.donkey.ToOffer_02_Singleton.getInstance());
//    }
}