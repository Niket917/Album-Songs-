import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
   private String name;

   private String artish;

   private List<Song> songs;

    public Album() {
    }

    public Album(String name, String artish) {
        this.name = name;
        this.artish = artish;
        songs = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtish() {
        return artish;
    }

    public void setArtish(String artish) {
        this.artish = artish;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public boolean findSong(String title){
        for(Song s : songs){
            if(s.getTitle().equals(title)){
                return true;
            }
        }
        return false;
    }

    public boolean addSong(String title,Double duration){
        if(!findSong(title)){
            Song s = new Song(title,duration);
            songs.add(s);
            System.out.println("Song has been added");
            return true;
        }
        System.out.println("Song is Already Present");
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playList){
        if(findSong(title)){
            for(Song s : songs){
                if(s.getTitle().equals(title)){
                    playList.add(s);
                    System.out.println("COngrates! Song is add to your PlayList");
                    return true;
                }
            }
        }

        System.out.println("Soory! This song is not a present album" );
        return false;

    }
    public boolean addToPlayList(int idx, LinkedList<Song> playList){
        idx = idx -1;
        if(idx >=0 && idx < this.songs.size()){
            playList.add(this.songs.get(idx));
            System.out.println("Congrates! Sond has been added to Your PlayList");
            return true;
        }

        System.out.println("Invalid Song name");
        return false;
    }
    public boolean removeToPlayList(String title, LinkedList<Song> playList){
        if(findSong(title)){
            for(Song s : songs){
                if(s.getTitle().equals(title)){
                    playList.remove(title);
                    System.out.println("Congrase! You have remove this song to playList");
                    return true;
                }
            }
        }
        System.out.println("This song is not present ");
        return false;
    }

    public boolean removeToPlayList(int idx, LinkedList<Song> playList) {
        idx = idx -1;
        if (idx >=0 && idx < this.songs.size()) {
                    playList.remove(songs.get(idx));
                    System.out.println("Congrase! You have remove this song to playList");
                    return true;

        }
        System.out.println("This song is not present ");
        return false;
    }

    public void remove(String name, String artish){
        songs.clear();
        System.out.println("You have succcesful Delet this album");
    }
}
