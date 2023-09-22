package day09.io.stream;

import java.io.FileInputStream;

public class FileInputExample {
    public static void main(String[] args) {

        String path = "C:\\Users\\kimdaveen\\Desktop\\국비\\javafolder\\java-basic202309\\src\\day03\\member\\MemberRepository.java";

        try (FileInputStream fis = new FileInputStream(path)) {

            int data = 0;
            while (data != -1) {
                data = fis.read();

                // ASCII(아스키) 출력 담당
                System.out.write(data);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
