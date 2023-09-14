package day05.src;

import day03.member.Gender;

import java.text.CollationKey;
import java.util.Scanner;

import static util.Utility.input;

public class LibraryView {
    private static LibraryRepository repository;
    static Scanner sc = new Scanner(System.in);
    int userSelect;
    static BookUser bookUser;

    LibraryView() {
    }

    public static void firstVisit() {

        System.out.println("# 회원 정보를 입력해주세요.");
        System.out.print("# 이름: ");
        String userName = sc.nextLine();
        System.out.print("# 나이: ");
        int userAge = sc.nextInt();
        sc.nextLine();
        String userSex = "0";
        Gender gender = Gender.MALE;

        while (true) {
            System.out.print("# 성별(M/F): ");
            userSex = sc.nextLine();

            if (userSex.equals("m") || userSex.equals("M")) {
                gender = Gender.MALE;
                break;
            } else if (userSex.equals("f") || userSex.equals("F")) {
                gender = Gender.FEMALE;
                break;
            }
            System.out.println("# 성별을 제대로 입력해주세요.");
        }

        bookUser = new BookUser(
                userName, userAge, gender, 0);

    }

    public static void showLibraryInfo() {
        System.out.println("\n=========== 도서메뉴 ==========");
        System.out.println("# 1. 마이페이지");
        System.out.println("# 2. 도서 전체 조회");
        System.out.println("# 3. 도서 제목으로 검색");
        System.out.println("# 4. 도서 대여하기");
        System.out.println("# 5. 도서 저자이름으로 검색");
        System.out.println("# 9. 프로그램 종료하기");
        System.out.print("- 메뉴 번호: ");
        int userSelect = sc.nextInt();
        sc.nextLine();

        switch (userSelect) {
            case 1:
                myPage();
                break;
            case 2:
                bookInquiry();
                break;
            case 3:
                bookSearch();
                break;
            case 4:
                bookRental();
                break;
            case 5:
                searchAuthor();
                break;
            case 9:
                System.out.println("- 프로그램이 종료됩니다.");
                break;

        }
    }



    private static void enter() {
        System.out.print("엔터키를 눌러 계속...");
        while (true) {
            String check = sc.nextLine();
            if (check.isEmpty()) break;
        }
    }

    // 1번 문항
    private static void myPage() {
        System.out.println("\n******** 회원님 정보 ********");
        System.out.println("# 회원명: " + BookUser.getName());
        System.out.println("# 나이: " + BookUser.getAge());
        System.out.println("# 성별: " + BookUser.getGenderToString());
        System.out.println("# 쿠폰개수: " + BookUser.getCouponCount());
        enter();
        showLibraryInfo();
    }

    // 2번 문항
    private static void bookInquiry() {
        System.out.println("========== 모든 도서 정보 ==========");
        for (Book book : LibraryRepository.bookList) {
            System.out.println(book.info());
        }
        enter();
        showLibraryInfo();
    }

    // 3번 문항
    private static void bookSearch() {
        System.out.print("# 검색어: ");
        String word = sc.nextLine();

        System.out.println("======== [" + word + "] 검색 결과 ========");

        for (Book book : LibraryRepository.bookList) {
            String title = book.getTitle();
            if (title.contains(word)) {
                System.out.println(book.info());
            }
        }
        enter();
        showLibraryInfo();
    }

    // 4번 문항
    private static void bookRental() {
        System.out.println("========== 대여가능한 도서 정보 ==========");
        int count = 1;
        for (Book book : LibraryRepository.bookList) {
            System.out.println(count + ". " + book.info());
            count++;
        }
        System.out.print("- 대여할 도서 번호 입력: ");
        int userSelect = sc.nextInt();
        sc.nextLine();

        count = 1;
        for (Book book : LibraryRepository.bookList) {
            if (count == userSelect) {
                if (book.info().contains("만화")) {
                    CartoonBook cartoon = (CartoonBook) book;
                    if (checkAccessAge(cartoon)) {
                        System.out.println("# 도서가 성공적으로 대여되었습니다.");
                    } else {
                        System.out.println("# 도서 대여에 실패했습니다.");
                    }
                    break;
                } else {
                    CookBook cook = (CookBook) book;
                    if (checkCoupon(cook)) {
                        int coupon = bookUser.getCouponCount();
                        bookUser.setCouponCount(coupon + 1);
                        System.out.println("# 도서가 성공적으로 대여되었습니다. (쿠폰 +1)");
                        break;
                    } else {
                        System.out.println("# 도서 대여에 실패했습니다.");
                    }
                }

            }
            count++;

        }

        enter();
        showLibraryInfo();
    }

    // 5번 문항
    private static void searchAuthor() {
        System.out.print("\n# 저자이름 검색: ");
        String author = sc.nextLine();

        System.out.println("======== [" + author + "] 검색 결과 ========");

        for (Book book : LibraryRepository.bookList) {
            String authorB = book.getAuthor();
            if (authorB.contains(author)) {
                System.out.println(book.info());
            }
        }
        enter();
        showLibraryInfo();
    }


    private static boolean checkCoupon(CookBook book) {
        ;
        if (book.isCoupon()) {
            return true;
        }
        return false;
    }

    private static boolean checkAccessAge(CartoonBook book) {
        int age = bookUser.getAge();
        int accessAge = book.getAccessAge();

        if (age >= accessAge) {
            return true;
        }
        return false;
    }


    // 실행 메서드
    public static void start() {
        firstVisit();
        showLibraryInfo();
    }

}
