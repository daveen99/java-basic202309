package day06.abs;

public class Dog extends Pet{

    public Dog(String name, String kind, int age) {
        super(name, kind, age);
    }

    public void takeNap() {
        System.out.println("강아지는 쿨쿨");
    }
    public void eat() {
        System.out.println("강아지는 냠냠");
    }
}
