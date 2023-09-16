package day07.inter;

public class Livings implements Animal{
    String name;
    int age;

    @Override
    public void feed(String foodName) {

    }

    @Override
    public boolean sleep() {
        return false;
    }
}
