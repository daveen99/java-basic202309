package day07.inter;

public class Main {
    public static void main(String[] args) {

        // 인터페이스도 상속과 같이 타입으로 쓸수있다.
        Animal duck = new Duck();
        BadAnimal bullDog = new BullDog();
        Huntable shark = new Shark();
        Violent rabbit = new Rabbit();

        // 인터페이스도 배열을 만들 수 있다.
        // 캐스팅(변환)을 할때는 변환 가능한 관계인지 확인한다.
        Animal[] animals = {duck, (Animal) bullDog, (Animal) rabbit};

        for (Animal animal : animals) {
            animal.feed("개맛도리똥내나는사료");
        }
    }
}
