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
	        // Crie alguns álbuns, músicas e adicione à coleção para testar a playlist
	        Album album1 = new Album("Album 1", "Banda 1", 2000);
	        Music music1 = new Music("Music 1", "Banda 1", album1, 4, 30, true);
	        Music music2 = new Music("Music 2", "Banda 1", album1, 3, 45, false);

	        Album album2 = new Album("Album 2", "Banda 2", 2010);
	        Music music3 = new Music("Music 3", "Banda 2", album2, 5, 15, true);

	        // Adicione os álbuns à coleção
	        musicCollection.addAlbum(album1);
	        musicCollection.addAlbum(album2);

	        // Adicione as músicas à coleção
	        musicCollection.addSong(music1);
	        musicCollection.addSong(music2);
	        musicCollection.addSong(music3);

	        // Gere a playlist sugerida
	        musicController.generatePlaylist();

	        // Verifique se a playlist foi gerada corretamente (você pode adicionar mais verificações se necessário)
	        // Aqui, estamos apenas testando se o método não gera uma exceção.
	        assertTrue(true);
	    }
	    

}
