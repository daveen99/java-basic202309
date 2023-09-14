package day05.poly;

import java.util.Scanner;

// 자바에서는 자동으로 extends Object가 된다.
class A {}
class B extends A {}
class C extends A {}
class D extends B {}
class E extends C {}

public class Basic {

    /*
              Object (모든 자바클래스의 부모)
                |
                A
              /   \
            B      C
            |      |
            D      E
     */

    void test() {
        // 다형성: 자식객체가 부모의 타입을 사용할 수 있다.
        Object a = new A();
        A b = new B(); // 부모인 A의 형태를 가질 수도 있다.
        C c = new C();
        B d = new D();
        A e = new E(); // 할아버지 A도 사용가능 조카는안됨

        Object sc = new Scanner(System.in);

    }

}
