package de.tobias_moeller.jpm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Section8 extends Section {
	public Section8() {
		super(8);
		this.methods = new String[]{"Challenge 100", "Challenge 119"};
	}
	
	@Override
	public boolean executeMethod(int chosen) {
		switch (chosen) {
			case 1:
				challenge100();
				return true;
			case 2:
				challenge119();
				return true;
			default:
				return false;
		}		
	}
	
	/*
	 * 	Challenge 100
	 */

	public void challenge100() {
		MyArray test = new MyArray();
		test.getIntegers();
		test.printArray();
		test.sortArray();
		test.printArray();
	}
	
	class MyArray {
		private int[] array;
		
		public MyArray() {
			
		}
		
		public void getIntegers() {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Wie viele Zahlen?");
			int[] tempArray;
			if (scanner.hasNextInt()) {
				tempArray = new int[scanner.nextInt()];
				scanner.nextLine();
				for (int i = 0; i < tempArray.length; i++) {
					if (scanner.hasNextInt()) tempArray[i] = scanner.nextInt();
					scanner.nextLine();
				}
				array = tempArray;
			}
//			scanner.close();
		}
		
		public void printArray() {
			for (int i = 0; i < array.length; i++) {
				System.out.println(i + ": " + array[i]);
			}
		}
		
		public void sortArray() {
			while (true) {
				boolean switched = false;
				for (int i = 0; i < array.length - 1; i++) {
					if (array[i] < array[i + 1]) {
						int temp = array[i];
						array[i] = array[i + 1];
						array[i + 1] = temp;
						switched = true;
					}
				}
				if (switched == false) break;
			}
		}
	}
	
	/*
	 * 	Challenge 119 - Linked List
	 */
	public void challenge119() {
		ArrayList<Album> albums = new ArrayList<>();

		Album album = new Album("Stormbringer", "Deep Purple");
		album.addSong("Stormbringer", 4.6);
		album.addSong("Love don't mean a thing", 4.22);
		album.addSong("Holy man", 4.3);
		album.addSong("Hold on", 5.6);
		album.addSong("Lady double dealer", 3.21);
		album.addSong("You can't do it right", 6.23);
		album.addSong("High ball shooter", 4.27);
		album.addSong("The gypsy", 4.2);
		album.addSong("Soldier of fortune", 3.13);
		albums.add(album);

		album = new Album("For those about to rock", "AC/DC");
		album.addSong("For those about to rock", 5.44);
		album.addSong("I put the finger on you", 3.25);
		album.addSong("Lets go", 3.45);
		album.addSong("Inject the venom", 3.33);
		album.addSong("Snowballed", 4.51);
		album.addSong("Evil walks", 3.45);
		album.addSong("C.O.D.", 5.25);
		album.addSong("Breaking the rules", 5.32);
		album.addSong("Night of the long knives", 5.12);
		albums.add(album);

		LinkedList<Song> playList = new LinkedList<Song>();
		albums.get(0).addToPlayList("You can't do it right", playList);
		albums.get(0).addToPlayList("Holy man", playList);
		albums.get(0).addToPlayList("Speed king", playList);  // Does not exist
		albums.get(0).addToPlayList(9, playList);
		albums.get(1).addToPlayList(3, playList);
		albums.get(1).addToPlayList(2, playList);
		albums.get(1).addToPlayList(24, playList);  // There is no track 24
		
		for (Song song : playList) {
			System.out.println(song);
		}
	}
	
	class Album {
		private String name;
		private String artist;
		private ArrayList<Song> songs;
		
		public Album(String name, String artist) {
			this.name = name;
			this.artist = artist;
			songs = new ArrayList<Song>();
		}
		
		public boolean addSong(String title, double duration) {
			try {
				if (findSong(title) == null) {
					songs.add(new Song(title, duration));
					return true;
				} else return false;
			} catch (Exception e) {
				return false;
			}
		}
		
		private Song findSong(String title) {
			for (Song song : songs) {
				if (song.getTitle().compareTo(title) == 0) return song;
			}
			return null;
		}
		
		public boolean addToPlayList(int trackNumber, LinkedList<Song> playList) {
			if (trackNumber <= this.songs.size() && trackNumber > 0) {
//				System.out.println("Add: " + this.songs.get(trackNumber-1) + " length " + this.songs.size());
				String title = songs.get(trackNumber-1).getTitle();
				if (addToPlayList(title, playList)) return true;
			}
			
//			try {
//				playList.add(songs.get(trackNumber));
//				return true;
//			} catch (Exception e) {
//				return false;
//			}
			
			return false;
		}
		
		public boolean addToPlayList(String songTitle, LinkedList<Song> playList) {
			ListIterator<Song> li = playList.listIterator();
			Song song = findSong(songTitle);
			while (li.hasNext()) {
				if (li.next().getTitle().compareTo(songTitle) == 0) return false;				
			}
			
			if (song != null) {
				playList.add(song);
				return true;
			} else return false;
		}
	}
	
	class Song {
		private String title;
		private double duration;
		
		public Song(String title, double duration) {
			this.title = title;
			this.duration = duration;
		}
		
		public String getTitle() {
			return this.title;
		}
		
		@Override
		public String toString() {
			return title + ": " + duration;
		}
	}
}
