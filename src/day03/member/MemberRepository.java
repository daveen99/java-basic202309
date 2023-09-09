package day03.member;

import java.util.Arrays;

// 책임(역할): 회원을 여러명 저장관리하는 클래스
public class MemberRepository {

    // 필드: 회원 배열
    // [ { id: 1, name: 'ddd' }, {} ]
    Member[] memberList; // 가입된 회원 배열
    Member[] removeMembers; // 삭제된 회원 배열

    public MemberRepository() {
        this.memberList = new Member[] {
                new Member(1, "abc@def.com", "1234",
                        "콩벌레", Gender.MALE, 15),
                new Member(2, "fff@ggg.com", "4567",
                        "팥죽이", Gender.FEMALE, 30),
                new Member(3, "xxx@vvv.com", "8765",
                        "카레맨", Gender.FEMALE, 45),
                new Member(3, "xxx@vvv.com", "8765",
                        "카레맨", Gender.FEMALE, 45),
                new Member(3, "xxx@vvv.com", "8765",
                        "카레맨", Gender.FEMALE, 45),
                new Member(3, "xxx@vvv.com", "8765",
                        "카레맨", Gender.FEMALE, 45),
                new Member(3, "xxx@vvv.com", "8765",
                        "카레맨", Gender.FEMALE, 45),
                new Member(3, "xxx@vvv.com", "8765",
                        "카레맨", Gender.FEMALE, 45),
                new Member(3, "xxx@vvv.com", "8765",
                        "카레맨", Gender.FEMALE, 45),
                new Member(3, "xxx@vvv.com", "8765",
                        "카레맨", Gender.FEMALE, 45)
        };
        this.removeMembers = new Member[0];
    }

    /**
        * 모든 회원정보를 출력하는 메서드
     */
    void showMembers() {
        System.out.printf("========== 현재 회원정보 (총 %d명) ==========\n",
                memberList.length);
        for (Member member : memberList) {
            System.out.println(member.inform());
        }
    }

    /**
        * 새로운 회원정보를 추가하는 메서드
     */
    boolean addMember(Member newMember) {

        // push 알고리즘
        Member[] temp = new Member[memberList.length + 1];
        for (int i = 0; i < memberList.length; i++) {
            temp[i] = memberList[i];
        }
        temp[temp.length-1] = newMember;
        memberList = temp;
        return true;
    }

    /**
        * 이메일의 중복여부를 확인하는 메서드
        * @param1 email - 중복검사 대상 이메일
        * @return - 중복되었다면 true, 아니라면 false
     */
    boolean isDuplicatedEmail(String email) {
        for (Member member : memberList) {
            if(email.equals(member.email)){
                return true;
            }
        }
        return false;
    }

    // 이메일로 인덱스를 찾는 메서드
    int findMemberIndexByEmail(String email) {
        for (int i = 0; i < memberList.length; i++) {
            Member member = memberList[i];
            if (email.equals(member.email)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 이메일을 통해 특정 회원 객체를 찾아서 반환하는 메서드
     * @param1 email - 탐색할 멤버객체의 이메일
     * @return - 해당 이메일과 일치하는 회원의 모든정보 객체
     * 이메일이 일치하지 않으면 null값 반환
     */
    Member findMemberByEmail(String email) {
        for (Member member : memberList) {
            if (email.equals(member.email)) {
                return member;
            }
        }
        for (Member member2 : removeMembers) {
            if (email.equals(member2.email)){
                return member2;
            }
        }
        return null;
    }

    /*
        * 비밀번호를 수정하는 메서드
     */
    void updatePassword(String newPassword, String email) {
        Member member = findMemberByEmail(email);
        member.password = newPassword;
    }

    /**
     * 배열의 길이(회원의 수)를 반환하는 메서드
     */
    public int howManyUsers() {
        return memberList.length;
    }

    /*
        * 회원탈퇴를 처리하는 메서드
     */
    public void memberDelete(Member member) {

        for (int i = 0; i < memberList.length; i++) {
            if(member.equals(memberList[i])){
                deletePush(member);
                deleteM(i);
            }
        }


    }

    public void deleteM(int index) {
        Member[] temp = new Member[memberList.length-1];
        for (int i = index; i < memberList.length-1; i++) {
            memberList[i] = memberList[i+1];
        }
        for (int i = 0; i < temp.length; i++) {
            temp[i] = memberList[i];
        }

        memberList = temp;

        System.out.println("# 회원 삭제 완료.");
    }

    public void deletePush(Member member) {
        Member[] temp;

        if(removeMembers.length < 1) {
            temp = new Member[1];
            temp[0] = member;
        } else {
            temp = new Member[removeMembers.length+1];
            for (int i = 0; i < removeMembers.length; i++) {
                temp[i] = removeMembers[i];
            }
            temp[removeMembers.length+1] = member;
        }
        removeMembers = temp;


        System.out.println("# = 삭제대기열 =");
        for (Member removeMember : removeMembers) {
            System.out.println(removeMember.inform());
        }
    }


    public void restoreMethod(Member member) {
        Member[] temp = new Member[memberList.length+1];
        for (int i = 0; i < memberList.length; i++) {
            temp[i] = memberList[i];
        }
        temp[memberList.length] = member;
        memberList = temp;

        if (removeMembers.length == 1) {
            removeMembers = new Member[0];
        } else {
            temp = new Member[removeMembers.length-1];
            int index = 0;
            for (int i = 0; i < removeMembers.length; i++) {
                if (removeMembers[i] == member) {
                    index = i;
                }
            }

            for (int i = index; i < removeMembers.length-1; i++) {
                    removeMembers[i] = removeMembers[i+1];
            }
            for (int i = 0; i < temp.length; i++) {
                temp[i] = removeMembers[i];
            }
            removeMembers = temp;

        }


        System.out.println("# = 삭제대기열 =");
        for (Member removeMember : removeMembers) {
            System.out.println(removeMember.inform());
        }
    }
}
