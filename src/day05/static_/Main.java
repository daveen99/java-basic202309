package day05.static_;

import jdk.jshell.execution.Util;
import util.Utility;
import static java.lang.Math.random;
import static java.lang.System.out;
import static util.Utility.*;

public class Main {

    public static void main(String[] args) {

        Count c1 = new Count();
        Count c2 = new Count();

        c1.x = 10;
        c1.y = 50;

        c2.x = 20;
        c2.y = 100;

        c1.x *= 3;
        c1.y++;

        System.out.println("c1.x = " + c1.x); //예상10
        System.out.println("c1.y = " + c1.y); //예상50

//        Utility u = new Utility();
        makeLine();
        input("이름: ");

        random();

        out.println("c2.x = " + c2.x); //예상20
        out.println("c2.y = " + c2.y); //예상100

        // static 메서드는 클래스 이름으로 바로 접근가능
        Count.m1(c1);
        Count.m1(c2);

        c1.m2();
        c2.m2();
    }
}
