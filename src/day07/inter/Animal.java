package day07.inter;

// class: 객체를 만드는 설계도
// interface: 클래스를 만드는 명세서
public interface Animal {

//    int a; // 필드를 선언할 수 없다.

//    Animal(){}; // 생성자를 선언할 수 없다.

    // 상수만 선언 가능 + psf는 안붙여도 된다.
    String PET = "dog";

    // 기능들을 명세
    void feed(String foodName);
    boolean sleep();

    // 추후에 만들어진 메서드들은
    // 강제로 오버라이딩 하게 하지 않는다.
    // 안그럼 에러가 마구마구 터지기때문
    default void makeHobby() {};
}
