package day05.final_;

public class Main {
    public static void main(String[] args) {

        Person kim = new Person("대한민국");
        Person nakamura = new Person("일본");
        System.out.println("나카무라씨의 국적: " + nakamura.nation);

        kim.name = "김영희";
//        kim.nation = "대한민국";

        kim.name = "김갑철";
    }
}
