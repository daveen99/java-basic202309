package day09.api.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class DateTime {
    public static void main(String[] args) {

//        Date date = new Date();
//        System.out.println(date);

//        Calendar calendar = Calendar.getInstance();

        // 현재 날짜정보 얻기 (연 월 일 )
        LocalDate nowDate = LocalDate.now();
        System.out.println("nowDate = " + nowDate);
        
        // 현재 시간정보 얻기 (시 분 초 )
        LocalTime nowTime = LocalTime.now();
        System.out.println("nowTime = " + nowTime);

        LocalDateTime now = LocalDateTime.now();
        System.out.println("now = " + now);
        
        // 원하는 정보만 추출하고싶어요!!
        int year = now.getYear();
        int monthValue = now.getMonthValue();
        System.out.println("monthValue = " + monthValue);
        int dayOfMonth = now.getDayOfMonth();
        System.out.println("dayOfMonth = " + dayOfMonth);

        // 원하는 날짜 만들기
        LocalDateTime targetTime = LocalDateTime.of(2023, 11, 25,
                0, 0, 0);
        System.out.println("targetTime = " + targetTime);

        // 날짜 연산
        // 도서대여 시스템
        // 대출날짜 오늘 -> 반납날짜는 17일 뒤
        LocalDateTime rentalDate = LocalDateTime.now();
        LocalDateTime returnDate = rentalDate.plusDays(17);
        System.out.println("returnDate = " + returnDate);

        LocalDateTime localDateTime = rentalDate.plusYears(1)
                .plusMonths(6)
                .plusDays(28);
        System.out.println("localDateTime = " + localDateTime);

        // 사이 날짜 구하기
        LocalDate b = LocalDate.of(2019, 12, 28);
        LocalDate d = LocalDate.of(2023, 9, 22);

        boolean after = nowDate.isAfter(b);
        System.out.println("after = " + after);

        long between = ChronoUnit.DAYS.between(b, d);
        System.out.println("between = " + between);

        // 날짜 포맷 바꾸기
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy년 mm월 dd일 E요일 a hh시 mm분");

        String dateString = now.format(pattern);
        System.out.println("dateString = " + dateString);


    }
}
