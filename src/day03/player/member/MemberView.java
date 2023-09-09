package day03.player.member;

import java.util.Scanner;

// 역할: 회원관리 앱의 입출력을 담당
public class MemberView {

    // 상수 만들기
    public static final int MAX_REGISTER = 4;

    Scanner sc;
    MemberRepository mr;

    public MemberView() {
        this.sc = new Scanner(System.in);
        this.mr = new MemberRepository();
        viewProcess();
    }

    /**
     * 초기 메인 화면을 출력
     */
    void mainView() {
        System.out.println("\n##### 회원 관리 시스템 #####");
        if (mr.getNumberOfMembers() < MAX_REGISTER) System.out.println("* 1. 회원 정보 등록하기");
        System.out.println("* 2. 개별회원 정보 조회하기");
        System.out.println("* 3. 전체회원 정보 조회하기");
        System.out.println("* 4. 회원 정보 수정하기");
        System.out.println("* 5. 회원 정보 삭제하기");
        if (mr.getNumberOfMembers() < MAX_REGISTER) System.out.println("* 6. 회원 정보 복구하기");
        System.out.println("* 7. 프로그램 끝내기");
        System.out.println("=============================");
    }

    /**
     * 프로그램 화면 흐름을 제어하는 기능
     */
    void viewProcess() {
        while (true) {
            mainView();
            String menuNum = input(">> ");

            switch (menuNum) {
                case "1":
                    if (mr.getNumberOfMembers() > MAX_REGISTER - 1) {
                        System.out.println("# 더 이상 회원등록을 할 수 없습니다.");
                        continue;
                    }
                    signUp();
                    break;
                case "2":
                    showDetail();
                    break;
                case "3":
                    mr.showMembers();
                    stop();
                    break;
                case "4":
                    changePassword();
                    break;
                case "5":
                    deleteMemberProcess();
                    break;
                case "6":
                    if (mr.getNumberOfMembers() > MAX_REGISTER - 1) {
                        System.out.println("# 회원목록이 꽉차서 현재 복구가 불가능합니다.");
                        continue;
                    }
                    restoreMember();
                    break;
                case "7":
                    String answer = input("# 정말로 종료합니까? [y/n] : ");
                    if (answer.toLowerCase().charAt(0) == 'y') {
                        System.out.println("# 프로그램을 종료합니다.");
                        System.exit(0);
                    } else {
                        continue;
                    }
                    break;
                default:
                    System.out.println("\n# 메뉴 번호를 다시 입력하세요");
            }
        }
    }

    private void restoreMember() {
        // 이메일을 입력받음
        String email = input("# 복구 대상의 이메일: ");

        // 복구 대상 탐색
        Member member = mr.findMemberByEmail(email, true);

        if (member != null) {
            // 패스워드 검사
            String inputPw = input("# 비밀번호: ");

            if (mr.isMatchPassword(inputPw, member.password)) {
                mr.deleteMember(email, true);
                System.out.println("\n# 회원 복구가 처리되었습니다.");
            } else {
                System.out.println("\n# 비밀번호가 일치하지 않습니다.");
            }

        } else {
            System.out.println("\n# 조회 결과가 없습니다.");
        }
        stop();
    }

    private void deleteMemberProcess() {
        // 이메일을 입력받음
        String email = input("# 삭제 대상의 이메일: ");

        // 삭제 대상 탐색
        Member member = mr.findMemberByEmail(email, false);

        if (member != null) {
            // 패스워드 검사
            String inputPw = input("# 비밀번호: ");

            if (mr.isMatchPassword(inputPw, member.password)) {
                mr.deleteMember(email, false);
                System.out.println("\n# 회원 탈퇴가 처리되었습니다. 복구하시려면 복구메뉴를 이용하세요.");
            } else {
                System.out.println("\n# 비밀번호가 일치하지 않습니다.");
            }

        } else {
            System.out.println("\n# 조회 결과가 없습니다.");
        }
        stop();
    }

    private void showDetail() {
        // 이메일을 입력받음
        String email = input("# 조회 대상의 이메일: ");

        // 조회 대상 탐색
        Member member = mr.findMemberByEmail(email, false);

        // 회원이 탐색됨
        if (member != null) {
            // 탐색된 회원의 정보를 출력
            member.showDetailInfo();
        } else {
            System.out.println("\n# 조회 결과가 없습니다.");
        }
        stop();
    }

    private void changePassword() {
        // 이메일을 입력받음
        String email = input("# 수정 대상의 이메일: ");

        // 수정 대상 탐색
        Member member = mr.findMemberByEmail(email, false);

        // 회원이 탐색됨
        if (member != null) {
            System.out.printf("# %s님의 비밀번호를 변경합니다.\n", member.memberName);
            String newPassword = input("# 새로운 비밀번호: ");

            // 만약 새비번이 기존비번과 같은경우 pass
            if (member.password.equals(newPassword)) {
                System.out.println("# 기존 비밀번호와 동일합니다. 변경을 취소합니다.");
                stop();
                return;
            }
            mr.updatePassword(newPassword, email);
            System.out.println("# 비밀번호 변경이 완료되었습니다.");
        } else {
            System.out.println("\n# 조회 결과가 없습니다.");
        }
        stop();
    }

    // 회원가입 입출력을 처리하는 메서드
    void signUp() {

        String email = checkDuplicateEmailInput();
        String name = input("# 이름: ");
        String pw = input("# 패스워드: ");
        Gender gender = checkCorrectGenderInput();
        String age = input("# 나이: ");

        // 실제 배열에 저장 명령
        // 랜덤 아이디 생성 (1 ~ 999999)
        int randomId = (int) (Math.random() * 999999) + 1;
        Member newMember = new Member(randomId, email, pw, name, gender, Integer.parseInt(age));
        mr.addMember(newMember);

        System.out.println("# 회원 가입 성공!!");
        stop();
    }

    private Gender checkCorrectGenderInput() {
        while (true) {
            String inputGender = input("# 성별 [M/F]: ");
            switch (inputGender.toUpperCase()) {
                case "M":
                    return Gender.MALE;
                case "F":
                    return Gender.FEMALE;
                default:
                    System.out.println("# 성별을 M또는 F로 입력하세요!");
            }
        }
    }

    private String checkDuplicateEmailInput() {
        while (true) {
            String email = input("# 이메일: ");
            if (!mr.isDuplicatedEmail(email)) {
                return email;
            }
            System.out.println("# 이메일이 중복되었습니다.");
        }
    }

    // 입력처리를 간편하게 해주는 메서드
    public String input(String message) {
        System.out.print(message);
        return sc.nextLine();
    }

    // 엔터를 누르기전까지 멈추는 기능
    void stop() {
        System.out.println("\n======= 엔터를 눌러서 계속…======");
        sc.nextLine();
    }
}
