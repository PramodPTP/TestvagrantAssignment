package Programme;

import java.util.*;

class SongStore {
	private int capacity;
	private Map<String, LinkedList<String>> userSongs;

	public SongStore(int capacity) {
		this.capacity = capacity;
		this.userSongs = new HashMap<>();

	}

	public void addSong(String user, String song) {
		userSongs.putIfAbsent(user, new LinkedList<>());
		LinkedList<String> playlist = userSongs.get(user);

		if (playlist.contains(song)) {
			playlist.remove(song);
		} else if (playlist.size() >= capacity) {
			playlist.removeLast();

		}

		playlist.addFirst(song);

	}

	public List<String> getRecentSongs(String user) {
		return userSongs.getOrDefault(user, new LinkedList<>());
	}

	public String printReverseOrder(String user) {
		List<String> playlist = getRecentSongs(user);
		for (int i = playlist.size() - 1; i >= 0; i--) {
			System.out.print(" "+playlist.get(i)+" ");
		}
		return user;
	}
}

public class PlaylistExample {
	public static void main(String[] args) {
		int initialCapacity = 3;
		SongStore store = new SongStore(initialCapacity);

		store.addSong("user1", "S1");
		store.addSong("user1", "S2");
		store.addSong("user1", "S3");

		System.out.println(store.printReverseOrder("user1")+"\n"+"Playlist would Look like");

		store.addSong("user1", "S4");
		System.out.println(store.printReverseOrder("user1")+"\n"+"When S4 song is played");

		store.addSong("user1", "S2");
		System.out.println(store.printReverseOrder("user1")+"\n"+"When S2 song is played");

		store.addSong("user1", "S1");
		System.out.println( store.printReverseOrder("user1")+"\n"+"When S1 song is played ");
		
		
		
		
		
		
		
		
		
		
	}
}

