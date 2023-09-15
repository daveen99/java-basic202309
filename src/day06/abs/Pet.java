package day06.abs;

public abstract class Pet {

    // 애완동물의 공통속성
    private String name;  //이름
    private String kind;  //종류
    private int age;      //나이

    public Pet() {}

    public Pet(String name, String kind, int age) {
        this.name = name;
        this.kind = kind;
        this.age = age;
    }

    // 공통 기능 (추상 O) 강제
    // 낮잠 기능
    public abstract void takeNap();
    // 밥먹는 기능
    public abstract void eat();

    // 선택적 기능 (추상 X) 비강제
    // 산책 기능
    public void walk() {}

    // 자식객체들은 이 내용을 바꾸지말고 그냥 써라 (final)
    // 메서드 내용 변경 불가능 (final)
    // 인사 기능
    public final String info() {
        return "Hello!! " + name;
    }
}
