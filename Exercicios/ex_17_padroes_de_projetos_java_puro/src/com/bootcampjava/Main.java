package com.bootcampjava;

import com.bootcampjava.facade.Facade;
import com.bootcampjava.singleton.SingletonEager;
import com.bootcampjava.singleton.SingletonLazy;
import com.bootcampjava.singleton.SingletonLazyHolder;
import com.bootcampjava.strategy.*;

public class Main {
    public static void main(String[] args) {

        // Singleton

            SingletonLazy lazy = SingletonLazy.getInstance();
            System.out.println(lazy);
            lazy = SingletonLazy.getInstance();
            System.out.println(lazy);


            SingletonEager eager = SingletonEager.getInstance();
            System.out.println(eager);
            eager = SingletonEager.getInstance();
            System.out.println(eager);

            SingletonLazyHolder holder = SingletonLazyHolder.getInstance();
            System.out.println(holder);
            holder = SingletonLazyHolder.getInstance();
            System.out.println(holder);

         //Strategy

            Comportamento normal = new ComportamentoNormal();
            Comportamento defensivo = new ComportamentoDefensivo();
            Comportamento agressivo = new ComportamentoAgressivo();

            Robo robo = new Robo();
            robo.setComportamento(normal);
            robo.mover();
            robo.setComportamento(agressivo);
            robo.mover();
            robo.setComportamento(defensivo);
            robo.mover();

          //Facade

            Facade facade = new Facade();
            facade.migraCliente("Rafael","7154557");


    }
}