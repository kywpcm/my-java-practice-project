package main;

import java.util.List;
import java.util.function.UnaryOperator;

public interface InterfaceA extends List { // 인터페이스는 인터페이스만 상속 가능

    // 인터페이스 변수
    // private 키워드는 변수에는 쓸 수 없고, 메소드에만 쓸 수 있음(since 9)
    // 인터페이스 변수는 public static final 기본
    String str1 = "str1";
    String str2 = "str2";

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
//        str2 = "aaa";
    }

    // List의 abstract 메소드 구현
//    @Override
    default Integer remove(int index) {
        return -1;
    }

    static void myStaticMethodInInter() {
        System.out.println("myStaticMethodInInter~");
    }

    // java 9...
//    private String getMyString() {
//        return "myString";
//    }

}
