package main;

import java.util.Comparator;

public class ComparatorA implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }

    // equals는 구현 안해도 됨 (Object에 구현되어 있음)

    // Comparator 인터페이스의 default 키워드도 없는데 구현되어진 메소드는 뭐지..?
    // => static method !!

}
