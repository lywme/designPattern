package com.company;
import java.lang.reflect.Array;
import java.util.*;

/**
 * Decorator装饰者
 */

public class Test{
    public static void main(String[] args){
        Drink coffee;
        //System.out.println(coffee.getCost());
        coffee=new Coffee();
        coffee=new Milk(coffee);
        coffee=new Diamond(coffee);

        System.out.println(coffee.cost());
        System.out.println(coffee.getName());
    }
}

abstract class Drink
{
    protected String name;
    protected double cost;

    public Drink(){}

    public Drink(String name,double cost)
    {
        this.name=name;
        this.cost=cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public abstract double cost();
}

class Coffee extends Drink
{
    public Coffee()
    {
        super("咖啡",9.8);
    }

    public double cost()
    {
        return super.getCost();
    }
}

class BubbleTea extends Drink
{
    public BubbleTea()
    {
        super("奶茶",8.8);
    }

    public double cost()
    {
        return super.getCost();
    }
}

class Decorator extends Drink
{
    private Drink drink;

    public Decorator(Drink drink)
    {
        this.drink=drink;
    }

    public double cost()
    {
        return super.getCost()+drink.cost();
    }

    public String getName()
    {
        return super.getName()+" , "+drink.getName();
    }
}

class Diamond extends Decorator
{
    public Diamond(Drink drink)
    {
        super(drink);
        this.cost=1.5;
        this.name="珍珠";
    }
}

class Milk extends Decorator
{
    public Milk(Drink drink)
    {
        super(drink);
        this.cost=3.0;
        this.name="加奶";
    }
}
