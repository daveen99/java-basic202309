package day05.final_;

public class Person {

    String name;
    final String nation; // 국적

    //자바에서의 상수는 static final을 둘 다 사용해야 한다!
    static final double pi = 3.14;
    // 인텔리js 에서의 단축커맨드 prf  (public f


    public Person(String nation) {
        this.nation = nation;
    }
}
