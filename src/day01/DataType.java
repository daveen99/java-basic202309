package day01;

import java.util.Date;

public class DataType {

    static int add(int n1, int n2) {
        return n1 + n2;
    }

    public static void main(String[] args) {

        // 1byte == 8bit
        // -128 ~ 127
        byte a = 127;

        // 2byte == 16bit
        short b = 32767;

        // 4byte
        int c = 2147483647;

        // 8byte
        long d = 2147483648L;
        
        // float
        float e = 3.14F;
        System.out.println("e = " + e);

        double f = 1.23232323141241212323131;

        boolean b1 = true;
        boolean b2 = false;

        if (1 > 2) {

        }

        // 2byte
        char cc = 44032; // 가 -> 힣
        char cb = 65; // 대문자 A
        System.out.println("cc = " + cc);
        
        // 문자열 (문자 배열)
        char[] str = {'h','e','l','l','o'};
        System.out.println("str = " + new String(str));

        // 스트링은 기본(원시)타입이 아닙니다.
        String s = "hello"; // 내부적으로 char배열로 변환하여 가지고있음

        Date dddd = new Date();
    }
}
