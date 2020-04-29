package com.company;
import java.lang.reflect.Array;
import java.util.*;

/**
 *   观察者模式 Observer
 */

public class Test{
    public static void main(String[] args){
        WeatherStation ws=new WeatherStation();
        Client1 c1=new Client1();
        Client2 c2=new Client2();

        ws.registerObserver(c1);
        ws.registerObserver(c2);
        ws.dataChange(30);
        ws.removeObserver(c2);
        ws.notifyObserver();
    }
}

/**
 * 以气象站和 订阅气象的订阅者为例
 */
interface Subject
{
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObserver();
}

interface Observer
{
    public void update(double temperture);
}

class Client1 implements Observer
{
    private double temperture;

    @Override
    public void update(double temperture) {
        this.temperture=temperture;
        displayTemperture();
    }

    public void displayTemperture()
    {
        System.out.println("Temperture is: "+temperture);
    }
}

class Client2 implements Observer
{
    private double temperture;

    @Override
    public void update(double temperture) {
        this.temperture=temperture;
        displayTemperture();
    }

    public void displayTemperture()
    {
        System.out.println("今天的气温是: "+temperture);
    }
}

class WeatherStation implements Subject
{
    private double temperature;
    private List<Observer> observers;

    public WeatherStation()
    {
        observers=new ArrayList<Observer>();
    }

    public void dataChange(double temperature)
    {
        this.temperature=temperature;
        notifyObserver();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObserver() {
        for(Observer o:observers)
        {
            o.update(temperature);
        }
    }
}
