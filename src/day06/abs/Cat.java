package day06.abs;

public class Cat extends Pet {

    public Cat(String name, String kind, int age) {
        super(name, kind, age);
    }

    public void takeNap() {
        System.out.println("고양이는 쿨쿨");
    }
    public void eat() {
        System.out.println("고양이는 냠냠");
    }
}
