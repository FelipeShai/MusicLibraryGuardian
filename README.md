# MusicLibraryGuardian
#### Music Library Guardian is a simple program to manage a collection of albums and songs. The program allows the user to register new albums and songs, perform searches within the collection, and generate suggested playlists based on favorite songs.
------------------
## Design decisions
* The program was implemented in Java, using the object-oriented programming paradigm.
* The program follows the Model-View-Controller (MVC) architecture to ensure separation of concerns and maintainability.
> <p> Model: The model represents the core data entities in the program, such as Album and Music. It provides methods to add and search albums and songs in the MusicCollection.</p>
> <p> View: The view, represented by the ConsoleView class, handles the interaction with the user through the command-line interface. It displays prompts, messages, and receives user input.</p>
> <p> Controller: The MusicController class acts as the controller, serving as an intermediary between the model and the view. It receives user input from the view, processes it, and invokes the corresponding methods in the model.</p>
* Input validation is minimal and assumes that the user will provide valid input in the specified format.
## Instructions to run the system
* Clone the repository to your local machine.
* Open a command prompt or terminal and navigate to the project directory.
* Compile the source files using the following command:
javac application/Program.java
* Run the system using the following command:
java application.Program
* Follow the on-screen instructions to input the required information, such as the date, number of small dogs, and number of large dogs.
* The system will display the name of the best pet shop and the total price of the baths.
* To the unit tests I advise using Eclipse IDE by the possibility of debugging. Just add jUnit to the project library. I used the current version. 
<br>junit-jupiter-api-5.9.2
<br><br><br>Note: Make sure you have the [Java JDK](https://www.oracle.com/java/technologies/downloads/#jdk20-windows) installed on your machine and properly configured to run the program.<br>


Author
Felipe Shai
