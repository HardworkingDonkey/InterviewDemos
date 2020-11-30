package com.donkey.interview.designpatterns.singleton;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.designpatterns
 * @description 单例模式
 * @since 2020.10.26 20:36
 */

public class SingletonDemo {
    static class Singleton {
        private static Singleton instance = null;

        private Singleton() {

        }

        public static Singleton getInstance() {
            if (instance == null) {
                synchronized ("s") {
                    if (instance == null) {
                        instance = new Singleton();
                    }
                }
            }
            System.out.println(instance);
            return instance;
        }
    }

    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        System.out.println(instance);
    }
}

