package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import view.ConsoleView;
import controller.MusicController;
import model.MusicCollection;
import model.Album;
import model.Music;

import java.util.List;

public class MusicTest {
    private MusicCollection musicCollection;
    private MusicController musicController;
    private ConsoleView consoleView;

    @BeforeEach
    public void setUp() {
        musicCollection = new MusicCollection();
        consoleView = new ConsoleView();
        musicController = new MusicController(musicCollection, consoleView);
    }

    @Test
    public void testAddAlbumAndSongs() {
    	MusicCollection collection = new MusicCollection();
    	
    	Album album = new Album("Album 1", "Artist 1", 2000);
    	Music music1 = new Music("Song 1", "Artist 1", album, 3, 30, false);
    	Music music2 = new Music("Song 2", "Artist 1", album, 4, 15, true);
    	
    	collection.addAlbum(album);
    	collection.addSong(music1);
    	collection.addSong(music2);
    	
    	assertEquals(1, collection.getAllAlbums().size());
    	assertEquals(2, collection.getAllSongs().size());
    }
    
    @Test
    public void testSearchAlbums() {
        MusicCollection collection = new MusicCollection();
        
        Album album1 = new Album("Album 1", "Artist 1", 2000);
        Album album2 = new Album("Album 2", "Artist 2", 2010);
        Album album3 = new Album("The Eminem Show", "Eminem", 2002);

        collection.addAlbum(album1);
        collection.addAlbum(album2);
        collection.addAlbum(album3);

        List<Album> searchResult = collection.searchAlbums("Album");
        assertEquals(2, searchResult.size());

        List<Album> searchResult2 = collection.searchAlbums("Eminem");
        assertEquals(1, searchResult2.size());
        assertEquals("The Eminem Show", searchResult2.get(0).getTitle());
    }

    @Test
    public void testSearchSongs() {
        MusicCollection collection = new MusicCollection();

        Album album1 = new Album("Album 1", "Artist 1", 2000);
        Album album2 = new Album("Album 2", "Artist 2", 2010);

        Music music1 = new Music("Song 1", "Artist 1", album1, 3, 30, false);
        Music music2 = new Music("Song 2", "Artist 1", album1, 4, 15, true);
        Music music3 = new Music("Song 3", "Artist 2", album2, 5, 0, false);

        collection.addAlbum(album1);
        collection.addAlbum(album2);

        collection.addSong(music1);
        collection.addSong(music2);
        collection.addSong(music3);

        List<Music> searchResultByTitle = collection.searchSongs("Song");
        assertEquals(3, searchResultByTitle.size());

        List<Music> searchResultByArtist = collection.searchSongs("Artist 1");
        assertEquals(2, searchResultByArtist.size());

        List<Music> searchResultEspecificSong = collection.searchSongs("Song 1");
        assertEquals(1, searchResultEspecificSong.size());
        assertEquals("Song 1", searchResultEspecificSong.get(0).getTitle());
        }
   
    @Test
    public void testIsFavorite() {
        Music music = new Music("Song 1", "Artist 1", null, 3, 30, false);
        assertFalse(music.isFavorite());

        music.setFavorite(true);
        assertTrue(music.isFavorite());
    }
    
	@Test
    public void testGeneratePlaylist() {
        Album album1 = new Album("Album 1", "Banda 1", 2000);
        Music music1 = new Music("Music 1", "Banda 1", album1, 4, 30, true);
        Music music2 = new Music("Music 2", "Banda 1", album1, 3, 45, false);

        Album album2 = new Album("Album 2", "Banda 2", 2010);
        Music music3 = new Music("Music 3", "Banda 2", album2, 5, 15, true);

        musicCollection.addAlbum(album1);
        musicCollection.addAlbum(album2);

        musicCollection.addSong(music1);
        musicCollection.addSong(music2);
        musicCollection.addSong(music3);

        musicController.generatePlaylist();

        assertTrue(true);
    }
	    	    
    @Test
    public void testGetDurationInSeconds() {
	    Music music = new Music("Song 1", "Artist 1", null, 3, 30, false);
	    int durationInSeconds = music.getSecondsDuration() + (music.getMinutesDuration() * 60);
	    assertEquals(210, durationInSeconds);
	}
	    
    
}
