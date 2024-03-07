package br.com.yuji;

import br.com.yuji.singleton.SingletonEager;
import br.com.yuji.singleton.SingletonLazy;
import br.com.yuji.singleton.SingletonLazyHolder;

public class Program {
    public static void main(String[] args) {
        
        // Singleton Tests 
        SingletonLazy sLazy = SingletonLazy.getInstance();
        System.out.println("Singleton Lazy: " + sLazy);
        sLazy = SingletonLazy.getInstance();
        System.out.println("Singleton Lazy Confirm: " + sLazy);
        
        System.out.println();
        
        SingletonEager sEager = SingletonEager.getInstance();
        System.out.println("Singleton Eager: " + sEager);
        sEager = SingletonEager.getInstance();
        System.out.println("Singleton Eager Confirm: " + sEager);
        
        System.out.println();
        
        SingletonLazyHolder sLazyHolder = SingletonLazyHolder.getInstance();
        System.out.println("Singleton Lazy Holder: " + sLazyHolder);
        sLazyHolder = SingletonLazyHolder.getInstance();
        System.out.println("Singleton Lazy Holder Confirm: " + sLazyHolder);
    }
    
}
