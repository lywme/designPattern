package com.company;
import java.lang.reflect.Array;
import java.util.*;

/**
 *   策略模式
 */

public class Test{
    public static void main(String[] args){
        Duck g=new GreenDuck();
        Duck r=new RedDuck();

        System.out.println("----我是绿头鸭----");
        g.makeSound();
        g.toFly();
        g.swim();
        System.out.println("----我是红头鸭----");
        r.makeSound();
        r.toFly();
        r.swim();

        System.out.println("----改变红头鸭叫声----");
        r.setQuack(new GaGaQuack());
        r.makeSound();
        r.toFly();
        r.swim();
    }
}


interface Fly
{
    public void fly();
}

interface Quack
{
    public void quack();
}

class GoodFly implements Fly
{
    @Override
    public void fly() {
        System.out.println("我飞的很好");
    }
}

class BadFly implements Fly
{
    @Override
    public void fly() {
        System.out.println("我基本不会飞");
    }
}

class GaGaQuack implements Quack
{
    @Override
    public void quack() {
        System.out.println("我叫起来嘎嘎叫");
    }
}

class KuaKuaQuack implements Quack
{
    @Override
    public void quack() {
        System.out.println("我叫起来夸夸叫");
    }
}

abstract class Duck
{
    protected Fly fly;
    protected Quack quack;

    public abstract void makeSound();
    public abstract void toFly();

    public Duck(){}

    public Duck(Fly fly,Quack quack)
    {
        this.fly=fly;
        this.quack=quack;
    }

    public Fly getFly() {
        return fly;
    }

    public void setFly(Fly fly) {
        this.fly = fly;
    }

    public Quack getQuack() {
        return quack;
    }

    public void setQuack(Quack quack) {
        this.quack = quack;
    }

    public void swim()
    {
        System.out.println("我是鸭子，我会游泳");
    }
}

class GreenDuck extends Duck
{
    public GreenDuck()
    {
        fly=new GoodFly();
        quack=new GaGaQuack();
    }

    @Override
    public void makeSound() {
        quack.quack();
    }

    @Override
    public void toFly() {
        fly.fly();
    }
}

class RedDuck extends Duck
{
    public RedDuck()
    {
        fly=new BadFly();
        quack=new KuaKuaQuack();
    }

    @Override
    public void makeSound() {
        quack.quack();
    }

    @Override
    public void toFly() {
        fly.fly();
    }
}
