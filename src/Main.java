import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {
        Album a1 = new Album(" Zara Hatke Zara Bachke", "Arjit Singh");
        Album a2 = new Album("Doorie","Atif Aslaam");

        a1.addSong("Tu Hai To Mujhe Fir Aur Kya Chahiye",5.6);
        a1.addSong("Tere Vaste",3.0);

        a2.addSong("Mahi ve", 4.1);
        a2.addSong("Doorie", 2.9);
        a2.addSong("Kuch is tarah", 3.6);

        a2.addSong("Kuch is tarah", 3.9);

        LinkedList<Song> playList = new LinkedList<>();
        a2.addToPlayList("Mahi ve", playList);


       a2.addToPlayList(2,playList);
       a2.addToPlayList(3,playList);

       a1.addToPlayList(1,playList);
        a1.addToPlayList(2,playList);



//        a2.removeToPlayList(2, playList);
//
//        System.out.println(a2.getSongs().get(1));
//
//       a2.remove("Zara Hatke Zara Bachke","Arjit Singh");
       System.out.println(playList);

       play(playList);



    }
    public static void play(LinkedList<Song> playList){
        ListIterator<Song> itr = playList.listIterator();

        if(!itr.hasNext()){
            System.out.println("Your PlayList is Empty");
            return;
        }
        System.out.println("Now Playing");
        System.out.println(itr.next());



       printMenu();

        Scanner sc = new Scanner(System.in);

        boolean wasNext = true;

        while(true){

            System.out.println("Please Enter Your option");

            int option = sc.nextInt();


            switch (option){
                case 1:
                   if(wasNext == false){
                       itr.next();
                       wasNext = true;
                   }
                    if(itr.hasNext()){
                        System.out.println("Now Playing");
                        System.out.println(itr.next());
                    } else {
                        System.out.println("You have Reached the End of PlayList");
                    }
                    break;
                case 2:
                    if(wasNext == true){
                        itr.previous();
                        wasNext = false;
                    }
                    if(itr.hasPrevious()){
                        System.out.println("Now Playing");
                        System.out.println(itr.previous());
                    } else {
                        System.out.println("You are Reaching the Startint point of Playist");
                    }
                    break;
                case 3:
                    if(wasNext == true){
                        System.out.println("Now Playing repeat song");
                        System.out.println(itr.previous());
                        wasNext = false;
                    } else {
                        System.out.println("Now Playing repeat song");
                        System.out.println(itr.next());
                        wasNext = true;
                    }
                    break;
                case 4:
                    printSongs(playList);
                    break;
                case 5:
                    System.out.println("You are Delet this song ");
                    itr.remove();
                    break;
                case 6:
                    printMenu();
                    break;
                case 7:
                    exit(0);
            }
        }
    }

    public static void printSongs(LinkedList<Song> playList){
        for (Song s : playList){
            System.out.println(s);
        }
        return;
    }

    public static void printMenu(){
        System.out.println("1. Play Next Song ");
        System.out.println("2. Play Previous Song");
        System.out.println("3. Repeat Current Song");
        System.out.println("4. Show all Song in PlayList");
        System.out.println("5. Delet the current song");
        System.out.println("6. Show the Menu Again");
        System.out.println("7. Exit");
    }


}