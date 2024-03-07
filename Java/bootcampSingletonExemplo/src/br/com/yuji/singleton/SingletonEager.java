package br.com.yuji.singleton;

// Singleton Apressado

public class SingletonEager {
    
    private static SingletonEager instance = new SingletonEager();

    
    private SingletonEager() {
    }
    
    
    public static SingletonEager getInstance() {
        return instance;
    }
}
