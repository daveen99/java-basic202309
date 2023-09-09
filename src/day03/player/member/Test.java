package day03.player.member;

public class Test {
    public static void main(String[] args) {

        MemberRepository mr = new MemberRepository();

        Member thief = new Member(4, "ttt@yyy.com",
                "9999", "밥도둑", Gender.MALE, 11);

        mr.addMember(thief);

        mr.showMembers();

        System.out.println("================");

        String email = "abc@def.com";
        boolean flag1 = mr.isDuplicatedEmail(email);
        System.out.println("flag1 = " + flag1);

        Member foundMember = mr.findMemberByEmail(email, false);
        System.out.println("foundMember.inform() = " + foundMember.inform());
    }
}
