package lld1.generics;

public class Demo <K,V>{
    public void doSomething(K key, V value){
        System.out.println(key);
        System.out.println(value);
    }

    public static <F,S> F getValue(F key, S value){
        System.out.println(key);
        System.out.println(value);
        return key;
    }
}
