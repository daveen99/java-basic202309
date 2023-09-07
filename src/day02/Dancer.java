package day02;

// 라이브러리 클래스: 메인 메서드를 만들지 않음
public class Dancer {
    // 객체의 속성(필드)
    String dancerName; // 댄서이름
    String crewName; // 팀이름
    Genre genre; // 장르
    DanceLevel danceLevel; // 댄스 난이도 ( 0:초보, 1:중수, 2:고수 )

    // 생성자 선언: 객체의 초기값을 세팅한다.
    // 생성자도 함수의 일종, 리턴데이터가 주소값으로 고정
    // 따라서 리턴 타입을 적지 않음.
    Dancer() {
        dancerName = "김뽀비";
        crewName = "헬로우";
        danceLevel = DanceLevel.AMATEUR;
        genre = Genre.URBAN;
    }
    Dancer(String dname) {
        this.dancerName = dname;
        this.crewName = "굿바이";
        this.danceLevel = DanceLevel.BEGINNER;
        this.genre =  Genre.HIPHOP;

    }
    Dancer(String dname, String cname) {
        this.dancerName = dname;
        this.crewName = cname;
        this.danceLevel = DanceLevel.PRO;
        this.genre = Genre.KPOP;
    }

    public Dancer(String dancerName, String crewName, Genre genre, DanceLevel danceLevel) {
        this.dancerName = dancerName;
        this.crewName = crewName;
        this.genre = genre;
        this.danceLevel = danceLevel;
    }

    // 객체의 기능 (메서드) // static을 붙이지 말 것
    // 춤추는 기능
    void dance() {
        System.out.println(genre.getGenreName() + "댄스를 열정적으로 춥니다.");
    }
    // 스트레칭 기능
    void stretch() {
        System.out.println(dancerName + "님이 몸을 풉니다.");
    }
    // 자기소개 기능
    void introduce() {
        System.out.printf("저는 %s팀의 %s입니다.\n", crewName, dancerName);
    }

}
