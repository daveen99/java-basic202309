package day04.inherit;

// 상속 키워드 extends
public class Warrior extends Player{

    private int rage;

    public Warrior(String nickName) {
        super(nickName);
        System.out.println("워리어 생성ㅈㅏ 호출");
        this.rage = 100;
    }

    public void powerSlash() {
        System.out.println("의 파워슬래시 발동!");
    }

    // 오버라이딩
    // 규칙: 형태(이름, 매개변수, 리턴타입)는 부모가 물려준 그대로 써야함
    @Override  // 오버라이딩 규칙을 맞췄는지 검증해준다
    public void status() {
        super.status();
        System.out.println("# 분노: " + rage);
    }


    public int getRage() {
        return rage;
    }

    public void setRage(int rage) {
        this.rage = rage;
    }
}
