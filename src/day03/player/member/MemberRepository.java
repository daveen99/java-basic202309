package day03.player.member;

// 책임(역할): 회원을 여러명 저장 관리하는 클래스
public class MemberRepository {

    // 필드: 회원 배열
    // [ { id: 1, name: 'ddd' }, {} ]
    Member[] memberList; // 가입된 회원 배열
    Member[] removeMembers; // 삭제된 회원 배열

    public MemberRepository() {
        this.memberList = new Member[] {
                new Member(1, "abc@def.com", "1234", "콩벌레", Gender.MALE, 15),
                new Member(2, "fff@ggg.com", "4567", "팥죽이", Gender.FEMALE, 30),
                new Member(3, "xxx@vvv.com", "8765", "카레맨", Gender.FEMALE, 45)
        };
        this.removeMembers = new Member[0];
    }

    /**
     * 모든 회원정보를 출력하는 메서드
     */
    void showMembers() {
        System.out.printf("=============== 현재 회원정보 ( 총 %d명 ) ============\n", memberList.length);
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
        temp[temp.length - 1] = newMember;
        memberList = temp;
        return true;
    }

    /**
     * 이메일의 중복여부를 확인하는 메서드
     *
     * @param1 email - 중복검사 대상 이메일
     * @return - 중복되었다면 true, 아니라면 false
     */
    boolean isDuplicatedEmail(String email) {
        for (Member member : memberList) {
            if (email.equals(member.email)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 이메일을 통해 특정 회원 객체를 찾아서 반환하는 메서드
     *
     * @param1 email - 탐색할 멤버객체의 이메일
     * @return - 해당 이메일과 일치하는 회원의 모든정보 객체
     *           이메일이 일치하지 않으면 null 리턴
     */
    Member findMemberByEmail(String email, boolean restore) {
        Member[] targetList = restore ? removeMembers : memberList;
        int index = findMemberIndexByEmail(email, restore);
        return index >= 0 ? targetList[index] : null;
    }
    /**
     * 이메일을 통해 인덱스를 가져오는 메서드
     */
    int findMemberIndexByEmail(String email, boolean restore) {
        Member[] targetList = restore ? removeMembers : memberList;
        for (int i = 0; i < targetList.length; i++) {
            Member member = targetList[i];
            if (email.equals(member.email)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 비밀번호를 수정하는 메서드
     */
    void updatePassword(String newPassword, String email) {
        Member member = findMemberByEmail(email, false);
        member.password = newPassword;
    }

    /**
     * 회원탈퇴를 처리하는 메서드
     */
    void deleteMember(String email, boolean restore) {
        Member[] delTargetList = restore ? removeMembers : memberList;
        Member[] addTargetList = restore ? memberList : removeMembers;
        // 기존 memberList배열에서 제거
        int index = findMemberIndexByEmail(email, restore);
        // 제거대상을 백업
        Member deletedMember = delTargetList[index];
        for (int i = index; i < delTargetList.length - 1; i++) {
            delTargetList[i] = delTargetList[i + 1];
        }
        Member[] temp = new Member[delTargetList.length - 1];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = delTargetList[i];
        }
        delTargetList = temp;

        // removeMembers배열에 추가
        temp = new Member[addTargetList.length + 1];
        for (int i = 0; i < addTargetList.length; i++) {
            temp[i] = addTargetList[i];
        }
        temp[temp.length - 1] = deletedMember;
        addTargetList = temp;

        if (restore) {
            removeMembers = delTargetList;
            memberList = addTargetList;
        } else {
            removeMembers = addTargetList;
            memberList = delTargetList;
        }
    }

    void printRemoveMembers() {
        System.out.println("===================================");
        for (Member removeMember : removeMembers) {
            System.out.println(removeMember.inform());
        }
        System.out.println("===================================");
    }

    /**
     * 현재 저장된 회원의 수를 알려주는 메서드
     */
    int getNumberOfMembers() {
        return memberList.length;
    }

    /**
     * 패스워드 일치검증 메서드
     */
    boolean isMatchPassword(String inputPassword, String originPassword) {
        return inputPassword.equals(originPassword);
    }
}