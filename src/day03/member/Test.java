package day03.member;

public class Test {
    public static void main(String[] args) {

        MemberRepository mr = new MemberRepository();

        Member thief = new Member(4, "ttt@yyy.com",
                "9999", "밥도둑", Gender.MALE, 11);

        mr.addMember(thief);

        mr.showMembers();
    }
}
