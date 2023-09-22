package day08.collection.song;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ArtistRepository {

    // key: 가수이름,   value: 가수객체
    private static Map<String, Artist> artistList;

    static {
        artistList = new HashMap<>();
    }

    // 가수 중복 체크
    public boolean artistCheck(String artist) {
        for (String s : artistList.keySet()) {
            if (s.equals(artist)) {
                return true;
            }
        }
        return false;

        // artistList.containsKey(artist)   키값 체크하는 메서드
    }

    // 노래 중복 체크
    public boolean songCheck(String name, String song) {
        for (String s : artistList.keySet()) {
            if (s.equals(name)) {
                for (String ss : artistList.get(s).getSongList()) {
                    if (ss.equals(song)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }



    /**
     * 노래 등록하기
     * @param name - 사용자의 입력 가수이름
     * @param song - 사용자의 입력 노래이름
     */
    public void setSong(String name, String song) {
        Set<String> songList = new HashSet<>();
        songList.add(song);
        Artist artist = new Artist(name, songList);
        artistList.put(name, artist);
    }
    // 가수가 등록되어있는 상태에서 노래추가등록
    public void setSong2(String name, String song) {
        Set<String> songList = artistList.get(name).getSongList();
        songList.add(song);
        artistList.get(name).setSongList(songList);
    }
    // Ctrl + Alt + M << 메서드 리팩토링 단축 커맨드


    public void songInfo(String name) {
        Artist art = artistList.get(name);
        art.info();
    }

    public static int counter() {
        int countNum = 0;
        for (String s : artistList.keySet()) {
            countNum += 1;
        }
        return countNum;

        // artistList.size()  <<<<
    }

    public static Map<String, Artist> getArtistList() {
        return artistList;
    }
}
