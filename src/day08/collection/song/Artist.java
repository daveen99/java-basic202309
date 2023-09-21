package day08.collection.song;

import java.util.List;
import java.util.Set;

import static util.Utility.makeLine;

public class Artist {

    private String name; // 가수명
    private Set<String> songList; // 노래목록

    public Artist(String name, Set<String> songList) {
        this.name = name;
        this.songList = songList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getSongList() {
        return songList;
    }

    public void setSongList(Set<String> songList) {
        this.songList = songList;
    }

    // 가수 정보 출력
    public void info() {
        System.out.println("\n# " + name + "님의 노래목록");
        makeLine();
        int i = 1;
        for (String s : songList) {
            System.out.printf("* %d. %s\n", i, s);
            i++;
        }
    }


}
