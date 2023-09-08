package day03.member;

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
                        "카레맨", Gender.FEMALE, 45)
        };
    }

    /*
        * 모든 회원정보를 출력하는 메서드
     */
    void showMembers() {
        System.out.printf("========== 현재 회원정보 (총 %d명) ==========\n",
                memberList.length);
        for (Member member : memberList) {
            System.out.println(member.inform());
        }
    }

    /*
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

    /*
        * 이메일의 중복여부를 확인하는 메서드
     */

    /*
        * 이메일을 통해 특정 회원 객체를 찾아서 반환하는 메서드
     */

    /*
        * 비밀번호를 수정하는 메서드
     */

    /*
        * 회원탈퇴를 처리하는 메서드
     */
}
