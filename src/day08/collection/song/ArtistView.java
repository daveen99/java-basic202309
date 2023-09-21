package day08.collection.song;

import java.util.Scanner;

import static day08.collection.song.ArtistRepository.counter;
import static util.Utility.makeLine;

public class ArtistView {

    static Scanner sc = new Scanner(System.in);
    private static ArtistRepository ar;

    static {
        ar = new ArtistRepository();
    }

    public static void start() {
        int countArtist = counter();
        System.out.println("\n****** 음악 관리 프로그램 ******");
        System.out.println("# 현재 등록된 가수: " +  countArtist + "명");
        System.out.println("# 1. 노래 등록하기");
        System.out.println("# 2. 노래 정보 검색");
        System.out.println("# 3. 프로그램 종료");
        makeLine();
        getChoice();
    }
    public static void getChoice() {
        System.out.print(">> ");
        String userInput = sc.nextLine();

        switch (userInput) {
            case "1":
                setSong();
                pressEnter();
                start();
                break;
            case "2":
                searchSong();
                pressEnter();
                start();
                break;
            case "3":
                System.out.println("ㅡ 프로그램을 종료합니다... ");
                break;
            default:
                System.out.println("ㅡ (경고!) 올바른 값을 입력해주세요.");
                pressEnter();
                start();
        }
    }

    public static void pressEnter() {
        System.out.print("ㅡ Enter키를 눌러 계속...");
        while (true) {
            String check = sc.nextLine();
            if (check.isEmpty()) break;
        }
    }

    // 노래 정보 검색
    private static void searchSong() {
        System.out.println("# 검색할 가수명을 입력하세요.");
        System.out.print("ㅡ 가수명: ");
        String name = sc.nextLine();

        ar.songInfo(name);
    }

    // 노래 등록하기
    private static void setSong() {
        System.out.println("\n# 노래 등록을 시작합니다.");
        System.out.print("ㅡ 가수명: ");
        String artist = sc.nextLine();
        System.out.print("ㅡ 노래명: ");
        String song = sc.nextLine();

        // 제일 먼저 노래명 중복체크
        if(ar.songCheck(artist, song)) {
            System.out.println("# [" + song + "]곡은 이미 등록된 노래입니다.");

        } else {
            // 그다음에 가수명 중복체크
            if (ar.artistCheck(artist)) {
                System.out.println("# " + artist + "님의 노래목록에 " + song + "곡이 추가되었습니다.");
                ar.setSong2(artist, song);
                return;
            };
            // 전부 포함되지 않으면 신규가수
            ar.setSong(artist, song);
            System.out.println("# " + artist + "님이 신규 등록되었습니다.");
        }
    }
}
