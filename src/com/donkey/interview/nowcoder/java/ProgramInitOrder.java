package com.donkey.interview.nowcoder.java;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.nowcoder.java
 * @description 程序初始化顺序
 * @since 2020.10.08 19:42
 */

public class ProgramInitOrder {
    public static void main(String[] args) {
        // 运行顺序: 静态 -> 父类 -> 子类
        B b = new B();
        System.out.println(b.getI());

        b.setI(1);
        System.out.println(b.getI());
    }
}

class A {
    private int i = 0;

    public void setI(int i) {
        this.i = i;
    }

    public int getI() {
        return this.i;
    }

    static {
        System.out.println("父类的静态代码块: 1");
    }

    {
        System.out.println("父类的普通代码块: 3");
    }

    public A() {
        System.out.println("父类的构造方法: 4");
    }
}

class B extends A {

    static {
        System.out.println("子类的静态代码块: 2");
    }

    {
        System.out.println("子类的普通代码块: 5");
    }

    public B() {
        System.out.println("子类的构造方法: 6");
    }
}