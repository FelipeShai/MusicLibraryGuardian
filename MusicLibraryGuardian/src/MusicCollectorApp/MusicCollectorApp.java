package MusicCollectorApp;

import model.MusicCollection;
import view.ConsoleView;
import controller.MusicController;

public class MusicCollectorApp {
    
	public static void main(String[] args) {
        MusicCollection collection = new MusicCollection();
        ConsoleView view = new ConsoleView();
        MusicController controller = new MusicController(collection, view);

        controller.Execute();
    }
}
