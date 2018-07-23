package main;

import java.util.List;
import java.util.function.UnaryOperator;

public interface InterfaceA extends List { // 인터페이스는 인터페이스만 상속 가능

    // List의 abstract 메소드 오버라이딩
    // 위로 올라가다 보면 Object에 구현되어져 있음
    boolean equals(Object obj);

    // List의 abstract 메소드 오버라이딩
    // 계층구조 아래에 구현되어져 있음
    @Override
    int size();

    // List의 default 메소드 오버라이딩
    @Override
    default void replaceAll(UnaryOperator operator) {

    }

    // List의 abstract 메소드 구현
    @Override
    default void add(int index, Object element) {

    }

    // List의 abstract 메소드 구현
    @Override
    default Object remove(int index) {
        return null;
    }

    public static void myStaticMethodInInter() {
        System.out.println("myStaticMethodInInter~");
    }

}
