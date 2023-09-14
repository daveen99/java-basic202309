package day05.src;

import day03.member.Gender;

public class BookUser {

    private static String name; // 도서관 회원 이름
    private static int age; // 도서관 회원 나이
    private static Gender gender; // 성별
    private static int couponCount; // 쿠폰 갯수
    private Book[] rentBookList; // 빌린 책 정보들

    public BookUser() {
    }

    public BookUser(String name, int age, Gender gender, int couponCount) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.couponCount = couponCount;
    }

    public static String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static Gender getGender() {
        return gender;
    }
    public static String getGenderToString() {
        return getGender() == Gender.MALE ? "남성" : "여성";
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public static int getCouponCount() {
        return couponCount;
    }

    public static void setCouponCount(int Coupon) {
        couponCount = Coupon;
    }
}
