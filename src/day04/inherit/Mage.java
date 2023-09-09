package day04.inherit;

public class Mage extends Player{

    private int mana;

    public Mage(String nickName) {
        super(nickName);
        this.mana = 100;
    }

    @Override
    public void status() {
        super.status();
        System.out.println("# 마나: " + mana);
    }

    public void blizzard() {
        System.out.println("의 눈보라 시전!");
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int rage) {
        this.mana = rage;
    }
}
