package test;

import java.util.Scanner;

import test.Song;

class Player{
	Song sg;
	public boolean addSong() {
		String sn,s;
		double t;
		@SuppressWarnings("resource")
		Scanner read=new Scanner(System.in);
		System.out.print("Please input the song'name:");
		sn=read.next();	
		System.out.print("Please input the song'singer:");
		s=read.next();
		System.out.print("Please input the song'time:");
		t=read.nextInt();
		sg=new Song(sn,s,t);
		return true;
	}
}