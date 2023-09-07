package day02;

public class FieldAndLocal {

    int a; // 필드

    void foo(int c) { // 메서드
        int b = 10; // 지역 변수: 반드시 초기화를 수동으로 해야함

        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
    } // method block
} // class block
