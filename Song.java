package test;

class Song {
	String songName;
	String singer;
	double time;
	public Song(String n) 
	{
		songName=n;
	}
	public Song(String n,String s,double t)
	{
		songName=n;
		singer=s;
		time=t;
	}
}