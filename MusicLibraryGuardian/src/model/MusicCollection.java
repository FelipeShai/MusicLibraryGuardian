package model;

import java.util.ArrayList;
import java.util.List;

public class MusicCollection {
    private List<Album> albums;
    private List<Music> songs;

    public MusicCollection() {
        albums = new ArrayList<>();
        songs = new ArrayList<>();
    }

    public void addAlbum(Album album) {
        albums.add(album);
    }

    public void addSong(Music song) {
        songs.add(song);
    }
    
    public List<Music> getAllSongs() {
        return songs;
    }

    public List<Album> searchAlbums(String searchTerm) {
        List<Album> results = new ArrayList<>();
        for (Album album : albums) {
            if (album.getTitle().toLowerCase().contains(searchTerm.toLowerCase()) ||
                album.getArtist().toLowerCase().contains(searchTerm.toLowerCase()) ||
                String.valueOf(album.getYear()).contains(searchTerm)) {
                results.add(album);
            }
        }
        return results;
    }

    public List<Music> searchSongs(String searchTerm) {
        List<Music> results = new ArrayList<>();
        for (Music song : songs) {
            if (song.getTitle().toLowerCase().contains(searchTerm.toLowerCase()) ||
                song.getArtist().toLowerCase().contains(searchTerm.toLowerCase())) {
                results.add(song);
            }
        }
        return results;
    }
}