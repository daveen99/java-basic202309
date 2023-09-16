package day07.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ThrowsPractice {

    public int inputNumber() throws InputMismatchException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        return n;
    }

    public int convert(String s) throws NumberFormatException {
        int n = Integer.parseInt(s);
        return n;
    }

    public int inputAndConvertNumber() {
        int n = 0;
        int m = 0;
        try {
            n = inputNumber();
            m = convert("100");
        } catch (InputMismatchException e) {
            System.out.println("정수로만 입력하세요.");
        } catch (NumberFormatException e) {
            System.out.println("숫자형태의 문자를 전달하세요.");
        }

        return n + m;
    }
}
