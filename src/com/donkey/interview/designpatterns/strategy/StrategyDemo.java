package com.donkey.interview.designpatterns.strategy;

/**
 * @author 刻苦驴
 * @package com.donkey.interview.designpatterns.strategy
 * @description 策略模式
 * @since 2020.11.30 13:21
 */

public class StrategyDemo {
    public static void main(String[] args) {
        Zombie zombie = new FlagZombie();
        zombie.display();
        // 更换攻击方式
        zombie.setAttackable(new HitAttack());
        zombie.display();
    }

    interface Moveable {
        void move();
    }

    interface Attackable {
        void attack();
    }

    static abstract class Zombie {
        public abstract void display();

        Moveable moveable;
        Attackable attackable;

        abstract void move();

        abstract void attack();

        public Zombie(Moveable moveable, Attackable attackable) {
            this.moveable = moveable;
            this.attackable = attackable;
        }

        public Moveable getMoveable() {
            return moveable;
        }

        public void setMoveable(Moveable moveable) {
            this.moveable = moveable;
        }

        public Attackable getAttackable() {
            return attackable;
        }

        public void setAttackable(Attackable attackable) {
            this.attackable = attackable;
        }
    }

    static class StepByStep implements Moveable {
        @Override
        public void move() {
            System.out.println("一步一步");
        }
    }

    static class HitAttack implements Attackable {
        @Override
        public void attack() {
            System.out.println("打");
        }
    }

    static class BiteAttack implements Attackable {
        @Override
        public void attack() {
            System.out.println("咬");
        }
    }

    static class NormalZombie extends Zombie {
        public NormalZombie() {
            this(new StepByStep(), new BiteAttack());
        }

        public NormalZombie(Moveable moveable, Attackable attackable) {
            super(moveable, attackable);
        }

        @Override
        public void display() {
            System.out.println("普通");
            move();
            attack();
        }

        @Override
        void move() {
            moveable.move();
        }

        @Override
        void attack() {
            attackable.attack();
        }
    }

    static class FlagZombie extends Zombie {
        public FlagZombie() {
            this(new StepByStep(), new BiteAttack());
        }

        public FlagZombie(Moveable moveable, Attackable attackable) {
            super(moveable, attackable);
        }

        @Override
        public void display() {
            System.out.println("旗手");
            move();
            attack();
        }

        @Override
        void move() {
            moveable.move();
        }

        @Override
        void attack() {
            attackable.attack();
        }
    }
}
