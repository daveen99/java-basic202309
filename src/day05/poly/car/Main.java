package day05.poly.car;

import jdk.jshell.execution.Util;
import util.Utility;

public class Main {
    public static void main(String[] args) {

        int a = 10;
        double b = a;
        char c = (char)a;

        Avante avante = new Avante();
        Car cc = avante;
        Car avante2 = new Avante();
        Mustang mustang = new Mustang();
        mustang.exhaust();
        Car stinger = new Stinger();

        Car[] cars = {avante, avante2, mustang, stinger};
        for (Car cx : cars) {
           cx.accelerate();
        }

        Object[] arr = {"hello", "안녕", 10, false};

        Utility.makeLine();

        Driver park = new Driver();
        park.drive(new Mustang());
        park.drive(new Stinger());

        CarShop carShop = new CarShop();

        Utility.makeLine();
        Mustang myCar = (Mustang)carShop.exportCar(6000);
        myCar.accelerate();
        myCar.exhaust();

        Car[] myCarList = {myCar, avante};

        int x= 10;
        double[] dArr = {x};

        // 객체의 다운캐스팅은 전제조건이 있음
        // 한번 업캐스팅이 된 자식객체만 다시 다운캐스팅 가능
        Utility.makeLine();

        //1. Stinger -> Car  업캐스팅
//        Stinger myStinger = new Stinger();
        Car myStinger = new Stinger();
        // 1-1. 다시 다운캐스팅 가능
        Stinger ss = (Stinger) myStinger;

        // 처음부터 Car였다면 다운캐스팅을 할 수 없다;
//        Car car = new Car();
//        Avante aaa = (Avante) car;

        Utility.makeLine();

        Car carcar = carShop.exportCar(6000);

        System.out.println(carcar instanceof Avante);
        System.out.println(carcar instanceof Stinger);
        System.out.println(carcar instanceof Mustang);

        if (carcar instanceof Mustang) {
            Mustang ms = (Mustang) carcar;
            ms.exhaust();
        }


    }
}
