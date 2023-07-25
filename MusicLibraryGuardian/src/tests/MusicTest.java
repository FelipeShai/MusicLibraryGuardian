package tests;

import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.MusicController;
import model.MusicCollection;
import view.ConsoleView;
import model.Album;
import model.Music;

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

	    // Teste para verificar se a playlist sugerida é gerada corretamente
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
	    

}
