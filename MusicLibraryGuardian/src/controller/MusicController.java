package controller;

import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

import model.Album;
import model.Music;
import model.MusicCollection;
import view.ConsoleView;

public class MusicController {
    private MusicCollection collection;
    private ConsoleView view;

    public MusicController(MusicCollection collection, ConsoleView view) {
        this.collection = collection;
        this.view = view;
    }

    public void Execute() {
        boolean exit = false;

        while (!exit) {
        	view.displayMessage("------ Menu ------");
        	view.displayMessage("1 - Register Album");
        	view.displayMessage("2 - Search Album");
        	view.displayMessage("3 - Search Song");
        	view.displayMessage("4 - Generate Playlist");
        	view.displayMessage("5 - Exit");
        	view.displayMessage("------------------");
        	view.displayMessage("Choose an option:");


            try {
                int option = Integer.parseInt(view.getInput());
                switch (option) {
                    case 1:
                        addAlbumAndSongs();
                        break;
                    case 2:
                        searchAlbum();
                        break;
                    case 3:
                        searchMusic();
                        break;
                    case 4:
                        generatePlaylist();
                        break;
                    case 5:
                        exit = true;
                        view.displayMessage("Exiting...");
                        break;
                    default:
                        view.displayMessage("Invalid option. Please choose a valid option from the menu.");
                        break;
                }
            } catch (NumberFormatException e) {
                view.displayMessage("Invalid input. Please enter a valid integer option from the menu.");
            } catch (Exception e) {
                view.displayMessage("An unexpected error occurred: " + e.getMessage());
                // You may log the exception here for further investigation if needed.
            }
    }
}

    public void addAlbumAndSongs() {
    	view.displayMessage("Enter album information: <Album Title>, <Artist/Band Name>, <Release Year>");
        view.displayMessage("Ex: The Eminem Show, Eminem, 2002");
        
        String albumInformation = view.getInput();
        String[] albumInformationArray = albumInformation.split(", ");
        String albumTitle = albumInformationArray[0];
        String artist = albumInformationArray[1];
        int year = Integer.parseInt(albumInformationArray[2]);
        
        while (year <= 0 || year > getCurrentYear()) {
        	view.displayMessage("Invalid year. Please enter a valid year.");
        	year = Integer.parseInt(view.getInput());
        }
        
        if (albumTitle.trim().isEmpty() || artist.trim().isEmpty()) {
            view.displayMessage("Album title and artist name cannot be empty.");
            return;
        }
        
        Album album = new Album(albumTitle, artist, year);
        collection.addAlbum(album);
        view.displayMessage("Album registered.");
        view.displayMessage("------------------");
        view.displayMessage("Do you want to register songs for this album? y/n");
        
        String addMusicQuestionResult = view.getInput().toLowerCase();
        boolean addMoreSongs = false;
        
        if(addMusicQuestionResult.contains("y")) {
        	addMoreSongs = true;
        }
        
        while (addMoreSongs) {
        	view.displayMessage("Song Information: <song title>, <duration in minutes>");
        	view.displayMessage("Ex: The Eminem Show, 5:51");
            String musicInformation = view.getInput();
            
            String[] musicInformationArray = musicInformation.split(", ");
            
            String songTitle = musicInformationArray[0];
            String[] duration = musicInformationArray[1].split(":");
            
            int minutes = Integer.parseInt(duration[0]);
            int seconds = Integer.parseInt(duration[1]);
            
            if (minutes < 0 || minutes > 59 || seconds < 0 || seconds > 59) {
                view.displayMessage("Invalid duration. Please enter valid minutes (0-59) and seconds (0-59).");
                return;
            }
            		            
            boolean isFavorite;
            do {
                view.displayMessage("Favorite this song? (y/n):");
                String input = view.getInput().trim().toLowerCase();
                if (input.equals("y")) {
                    isFavorite = true;
                    break;
                } else if (input.equals("n")) {
                    isFavorite = false;
                    break;
                } else {
                    view.displayMessage("Invalid input. Please enter 'y' for yes or 'n' for no.");
                }
            } while (true);

            
            Music song = new Music(songTitle, artist, album, minutes, seconds, isFavorite);
            collection.addSong(song);

            view.displayMessage("Song successfully registered!");
            view.displayMessage("Do you want to register more songs for this album? (y/n):");

            addMoreSongs = view.getInput().equalsIgnoreCase("y");
        }
    }
        
    private int getCurrentYear() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.YEAR);
    }
    
    public void searchAlbum() {
    	view.displayMessage("Enter the search term:");
        
        String searchTerm = view.getInput();

        List<Album> results = collection.searchAlbums(searchTerm);
        
        if (results.isEmpty()) {
        	view.displayMessage("No albums found with the search term.");
        } else {
        	view.displayMessage("Search results:");
            for (Album album : results) {
                view.displayMessage(album.getTitle() + " - " + album.getArtist() + " (" + album.getYear() + ")");
            }
        }
    }

    private void searchMusic() {
    	view.displayMessage("Enter the search term:");
        String searchTerm = view.getInput();

        List<Music> results = collection.searchSongs(searchTerm);
        
        if (results.isEmpty()) {
        	view.displayMessage("No songs found with the search term.");
        } else {
        	view.displayMessage("Search results:");
            for (Music song : results) {
                view.displayMessage(song.getTitle() + " - " + song.getArtist() +
                        " (Album: " + song.getAlbum().getTitle() + ", Duration: " + song.getMinutesDuration() + ":" + song.getSecondsDuration() + ")");
            }
        }
    }

    public void generatePlaylist() {
        List<Music> allSongs = collection.getAllSongs();
        List<Music> favoriteSongs = new ArrayList<>();
        List<Music> randomSongs = new ArrayList<>();

        for (Music song : allSongs) {
            if (song.isFavorite()) {
                favoriteSongs.add(song);
            } else {
                randomSongs.add(song);
            }
        }

        Collections.shuffle(randomSongs); 
        Collections.shuffle(favoriteSongs);
        
        int maxDuration = 60;
        int currentDuration = 0;

        List<Music> playlist = new ArrayList<>();

        int favoriteSongsCount = favoriteSongs.size();
        int randomSongsCount = randomSongs.size();

        
        int i = 0;
        while (i < favoriteSongsCount && currentDuration + favoriteSongs.get(i).getMinutesDuration() <= maxDuration / 2) {
            playlist.add(favoriteSongs.get(i));
            currentDuration += favoriteSongs.get(i).getMinutesDuration();
            i++;
        }

        int j = 0;
        while (j < randomSongsCount && currentDuration + randomSongs.get(j).getMinutesDuration() <= maxDuration) {
            playlist.add(randomSongs.get(j));
            currentDuration += randomSongs.get(j).getMinutesDuration();
            j++;
        }
        
        if (playlist.isEmpty()) {
            view.displayMessage("No songs found to create the playlist. Please add more songs to the collection.");
            return;
        }
        
        view.displayMessage("Playlist Sugerida:");
        for (Music song : playlist) {
            view.displayMessage(song.getTitle() + " - " + song.getArtist() +
                    " (Album: " + song.getAlbum().getTitle() + ", Duration: " +
                    song.getMinutesDuration() + "m" + song.getSecondsDuration() + "s)");
        }
    }

}

