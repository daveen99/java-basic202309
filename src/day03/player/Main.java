package day03.player;

public class Main {
    public static void main(String[] args) {

        new Player();


        Player parking = new Player("주차왕파킹");
        Player cooking = new Player("요리왕비룡");
//
        parking.attack(cooking);
        System.out.println("parking = " + parking);
        System.out.println("cooking = " + cooking);
    }
}
