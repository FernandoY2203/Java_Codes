package br.com.yuji.singleton;

// Singleton Lazy Holder

public class SingletonLazyHolder {
    
    private static class InstanceHolder {
        public static SingletonLazyHolder instance = new SingletonLazyHolder();
    }

    
    private SingletonLazyHolder() {
    }
    
    
    public static SingletonLazyHolder getInstance() {
        return InstanceHolder.instance;
    }
}
