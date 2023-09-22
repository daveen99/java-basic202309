package day08.collection.song;

public class Test {
    public static void main(String[] args) {

        ArtistRepository ar = new ArtistRepository();

        ar.setSong("르세라핌", "미스포차");
        ar.setSong2("르세라핌", "포장마차");
        ar.setSong("에스퍼", "앗차차차");

        System.out.println(ArtistRepository.getArtistList());
    }
}
