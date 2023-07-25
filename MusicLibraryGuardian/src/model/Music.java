package model;

public class Music {
    private String title;
    private String artist;
    private Album album;
    private int minutesDuration;
    private int secondsDuration;
    
    private boolean isFavorite;

    public Music(String title, String artist, Album album, int minutesDuration, int secondsDuration, boolean isFavorite) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.minutesDuration = minutesDuration;
        this.secondsDuration = secondsDuration;
        this.isFavorite = isFavorite;
    }
    // Getters e setters

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public int getMinutesDuration() {
		return minutesDuration;
	}

	public void setMinutesDuration(int duration) {
		this.minutesDuration = duration;
	}
	
	public int getSecondsDuration() {
		return secondsDuration;
	}
	
	public void setSecondsDuration(int duration) {
		this.secondsDuration = duration;
	}

	public boolean isFavorite() {
		return isFavorite;
	}

	public void setFavorite(boolean isFavorite) {
		this.isFavorite = isFavorite;
	}

    
    
}
