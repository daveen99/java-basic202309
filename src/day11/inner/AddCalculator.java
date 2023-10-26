package day11.inner;

public class AddCalculator implements Calculator{

    // 메서드 이름 = 같아야함
    // 메개변수 타입 = 같아야함
    // 메개면수 이름 = 달라도됨
    // 리턴값의 속성 = 같아야함 int String float
    @Override
    public int operate(int n1, int n2) {
        return n1+n2;
    }
}
