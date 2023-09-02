package day01;

public class Casting {

    public static void main(String[] args) {

        int a = 100;
        int b = a;

        System.out.println("b = " + b);

        // 4비트인 INT와 다르게 1비트인 byte는
        // c의 4비트중 앞의 3비트를 버리고 변환된다.
        // c: 00000000 00000000 00000011 11101000
        int c = 1000; // 4
        // d: 1(음수)  1101000
        // 1의보수:    0010111
        // 2의보수:         +1
        //            0011000 => 24
        // 큰걸 작은걸로 강제 타입변환을 하면 값이 버려진다.
        byte d = (byte) c;  // 1

        System.out.println("d = " + d);

        double n = 3.5; // 8
        int m = (int) n;// 4
        // 다운캐스팅도 데이터소실이 있을 수 있음
        System.out.println("m = " + m);

        // 연산시 일어나는 자동 캐스팅
        int k = 100;
        double j = 5.6;
        // int가 double과 계산이 일어나면 int가 double로 변환되어 계산된다.
        double result = k + j;

        // 데이터 크기가 다른 데이터 끼리의 연산은
        // 작은 쪽을 큰 쪽으로 자동 변환 후 연산을 진행 한다.

        char x = 'A';
        int y = 3;

        int result2 = (char) (x + y);
        System.out.println(x+y);

        // int보다 작은 데이터 (byte, short, char)
        // 의 연산은 결과가 자동으로 int로 처리된다.
        byte b1 = 100;
        byte b2 = 120;

        int result3 = b1 + b2;

        System.out.println('A' + 'C');
        
        
        int g = 24;
        double r = (double)g / 5;
        System.out.println("r = " + r);
    }
}
