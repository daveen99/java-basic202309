package day07.inter;

public class BullDog extends Livings implements BadAnimal{

    @Override
    public void makeHobby() {
        super.makeHobby();
    }

    // Huntable
    @Override
    public void hunt(Animal animal) {

    }

    // Animal
    @Override
    public void feed(String foodName) {

    }

    @Override
    public boolean sleep() {
        return false;
    }

    // Violent
    @Override
    public void angry() {

    }
}
