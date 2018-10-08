package test;
import java.util.Scanner;

import test.Master;
import test.Player;
import test.SongDrive;

public class SongDrive {
	static Master master=new Master();
	static Player player=new Player();
	public SongDrive(){}
	public static void main(String[] args){
		@SuppressWarnings("unused")
		SongDrive song=new SongDrive();
		@SuppressWarnings("resource")
		Scanner read=new Scanner(System.in);
		System.out.println("Welcome to the Song system:");
		System.out.println("If you are the master,please input 1");
		System.out.println("If you are the player,please input 2");
		int a;
		do {
			a = read.nextInt();
		switch(a)
		{
		case 1: 
		{
			master.play();
			System.out.println("If you want to exit,please input 3");
		}; break;
		case 2: 
		{
			System.out.println("The song list:");
			player.addSong();
			Master.listSong.add(player.sg);
			System.out.println("You can go on if you input 2");
			System.out.println("If you want to exit,please input 3");
		} break;
		case 3:break;
		default:System.out.println("ERROR!");break;
		}
		}while(a!=3);
	}		
}