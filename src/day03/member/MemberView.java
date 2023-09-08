package day03.member;

import java.util.Scanner;

// 역할: 회원관리 앱의 입출력을 담당
public class MemberView {

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
        int i = mr.howManyUsers();

        System.out.println("\n##### 회원 관리 시스템 #####");
        if (i == 10) {
            System.out.println("* ※ 현재 회원수(10명) [인원초과] ※");
        } else {
            System.out.println("* 1. 회원 정보 등록하기");
        }
        System.out.println("* 2. 개별회원 정보 조회하기");
        System.out.println("* 3. 전체회원 정보 조회하기");
        System.out.println("* 4. 회원 정보 수정하기");
        System.out.println("* 5. 회원 정보 삭제하기");
        System.out.println("* 6. 프로그램 끝내기");
        System.out.println("* 7. 회원 복구하기");
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
                    signUp();
                    break;
                case "2":
                    showMember();
                    stop();
                    break;
                case "3":
                    mr.showMembers();
                    stop();
                    break;
                case "4":
                    changePassword();
                    break;
                case "5":
                    deleteMember();
                    break;
                case "6":
                    String answer = input("# 정말로 종료합니까? [y/n] : ");
                    if (answer.toLowerCase().charAt(0) == 'y') {
                        System.out.println("# 프로그램을 종료합니다.");
                        System.exit(0);
                    } else {
                        continue;
                    }
                    break;
                case "7":
                    memberRestore();
                    break;
                default:
                    System.out.println("\n# 메뉴 번호를 다시 입력하세요");
            }
        }
    }

    private void memberRestore() {
        if (mr.removeMembers.length == 0) {
            System.out.println("# 삭제된 회원정보가 없습니다.");
            stop();
            return;
        }
        Member member = checkEmailInput();
        if(checkPasswordInput(member)){
            if (mr.howManyUsers() == 10){
                return;
            }
            System.out.println("# 정보 확인완료, 복구 시작.");

            mr.restoreMethod(member);
            System.out.println("# 복구 완료.");
            stop();
        };
    }

    // 회원을 삭제한다
    private void deleteMember() {
        // 이메일을 입력받고 확인
        Member member = checkEmailInput();
        if (member != null) {
            if(checkPasswordInput(member)){
                mr.memberDelete(member);
                stop();
            };
        }
    }

    private void changePassword() {
        // 이메일을 입력받음
        String email = input("# 수정 대상의 이메일: ");

        // 수정 대상 탐색
        Member member = mr.findMemberByEmail(email);

        // 회원이 탐색됨
        if (member != null) {
            System.out.printf("# %s님의 비밀번호를 변경합니다.\n", member.memberName);
            String newPassword = input("# 새로운 비밀번호: ");

            // 새로운 비밀번호가 기존 비밀번호와 같은 경우
            if (member.password.equals(newPassword)) {
                System.out.println("# 기존 비밀번호와 동일합니다.");
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
        int i = mr.howManyUsers();
        if (i == 10) {
            System.out.println("# 회원수가 10명이 넘어 포화상태입니다. [가입불가]");
            stop();
            return;
        }

        String email = checkDuplicateEmailInput();
        String name = input("# 이름: ");
        String pw = input("# 패스워드: ");
        Gender gender = checkCorrectGenderInput();
        String age = input("# 나이: ");

        // 실제 배열에 저장 명령
        // 랜덤 아이디 생성 ( 1 ~ 999999 )
        int randomId = (int) (Math.random() * 999999) + 1;
        Member newMember = new Member(randomId, email, pw, name, gender, Integer.parseInt(age));
        mr.addMember(newMember);

        System.out.println("회원가입 완료");
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
                    System.out.println("# 성별을 M또는 F로만 입력해주세요.");
            }
        }

    }

    private String checkDuplicateEmailInput() {
        while (true) {
            String email = input("# 이메일: ");
            if (!mr.isDuplicatedEmail(email)) {
                return email;
            }
            System.out.println("#이메일이 중복되었습니다.");
        }
    }

    // 개별회원 이메일 검사
    private Member checkEmailInput() {
        String email = input("# 이메일 검색: ");
        Member member = mr.findMemberByEmail(email);

        if (member != null) {
            return member;
        } else {
            System.out.println("# 존재하지 않는 이메일입니다.");
            return null;
        }
    }
    // 패스워드 검사
    private boolean checkPasswordInput(Member member) {
        String password = input("# 비밀번호 확인: ");
        if (member.password.equals(password)) {
            System.out.println("# 비밀번호가 일치합니다.");
            stop();
            return true;
        }
        return false;
    }

    private void showMember() {
        Member member = checkEmailInput();
        if (member != null) {
            System.out.printf("# ID: %d번\n# 이메일: %s\n# 이름: %s\n# 성별: %s\n# 나이: %d세",
                    member.memberId, member.email, member.memberName,
                    member.gender, member.age);

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
