package day09.api.obj;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Company company = new Company("모나미", "서울지사");
        Pen redPen = new Pen(company, 1, "빨강", 500);
        Pen redPencil = new Pen(company, 1, "빨강", 500);

        Pen bluePen = new Pen(company, 2, "파랑", 600);

        System.out.println("redPen = " + (redPen.equals(redPencil)));

        System.out.println(redPen.hashCode());
        System.out.println(redPencil.hashCode());

        Set<Pen> penSet = new HashSet<>();
        penSet.add(bluePen);
        penSet.add(redPen);
        penSet.add(redPencil);

        System.out.println(penSet.size());
        System.out.println(penSet);

    }
}
