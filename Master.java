package test;

import java.util.ArrayList;
import java.util.List;

import test.Song;

class Master{
	static List<Song> listSong=new ArrayList<>();
	public Master() {}
	public boolean play(){
		if(listSong.isEmpty()==false)
 		{
			if(listSong.get(0).songName==null) {
				System.out.println("There is no song");
				return false;}
 			System.out.println("The name of playing song£º"+listSong.get(0).songName);
 			System.out.println("The singer of playing song£º"+listSong.get(0).singer);
 			System.out.println("The time of playing song£º"+listSong.get(0).time);
 			listSong.remove(0);
 			return true;
 		}
		else return false;
	}
}