package day04.inherit;

public class Hunter extends Player{
    private String beast;

    public Hunter(String nickName) {
        super(nickName);
        this.beast = "곰돌이";
    }

    @Override
    public void status() {
        super.status();
        System.out.println("# 동물: " + beast);
    }

    public void ArrowShot() {
        System.out.println("의 애로우 샷!");
    }
    public String getBeast() {
        return this.beast;
    }

    public void setBeast(String beast) {
        this.beast = beast;
    }
}
