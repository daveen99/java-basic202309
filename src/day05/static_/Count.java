package day05.static_;

public class Count {

    // 제한자 (modifier)
    // 접근 제한자 (access), 사용 제한자 (usage)
    public static int x;  // 정적필드 (스태틱필드): 모든 객체가 공유함
    public int y;         // 인스턴스 필드: 각 객체별로 관리됨


    // static메서드 안에서는 static필드만 직접 참조가능
    // 인스턴스 필드는 객체를 명시적으로 밝혀야 가능
    // 정적 메서드
    public static void m1(Count c) {
        System.out.println("static 메서드 호출");
        System.out.println("x = " + x);
        System.out.println("y = " + c.y);
    }
    // 인스턴스 메서드 (this가 누군지 알고있다.)
    public void m2() {
        System.out.println("instance 메서드 호출");
        System.out.println("x = " + x);
        System.out.println("y = " + y);
    }
}
