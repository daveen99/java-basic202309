package day08.generic;

public class Apple extends Object{

    private int sweet; // 당도

    public Apple(int sweet) {
        this.sweet = sweet;
    }

    @Override
    public String toString() {
        return "이 사과의 당도는 " + sweet + "입니다.";
    }
}
