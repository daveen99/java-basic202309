package day11.inner;

class ABC {}
// 그냥 동등한 클래스


public class Main {

    // 내부 클래스
    // 내부 클래스는 static을 붙일수있고 일반적으로 붙인다.
    public static class SubCalculator implements Calculator {

        @Override
        public int operate(int n1, int n2) {
            return n1 - n2;
        }
    }

    public static class Cat implements Pet {
        @Override
        public void eat() {

        }
        @Override
        public void play() {

        }
    }

    public static void main(String[] args) {

        AddCalculator cal1 = new AddCalculator();
        //Calculator cal1 = new AddCalculator();
        int r1 = cal1.operate(10, 20);
        System.out.println("r1 = " + r1);

        // 내부 클래스
        Calculator cal2 = new SubCalculator();
        int r2 = cal2.operate(30, 25);
        System.out.println("r2 = " + r2);

        // 익명 클래스
        Calculator cal3 = new Calculator() {
            @Override
            public int operate(int n1, int n2) {
                return n1 * n2;
            }
        };
        int r3 = cal3.operate(5, 8);
        System.out.println("r3 = " + r3);

        // lambda(람다): 인터페이스의 추상메서드가 단 하나일때만 가능
        Calculator cal4 = (n1, n2) -> n1 / n2;
        int r4 = cal4.operate(20, 10);
        System.out.println("r4 = " + r4);


        // Pet의 익명클래스
        Pet shark = new Pet() {
            @Override
            public void eat() {

            }
            @Override
            public void play() {

            }
        };


    }
}
