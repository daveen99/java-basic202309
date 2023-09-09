package day04.encap;

public class Main {
    public static void main(String[] args) {

        Car myCar = new Car("그랜져");

        myCar.setSpeed(80);
        System.out.println(myCar.getSpeed());

        myCar.setMode('D');
        System.out.println(myCar.getMode());

//        myCar.inject();
//        myCar.putOil();
//        myCar.moveCylinder();
        myCar.pressButton();

    }
}
