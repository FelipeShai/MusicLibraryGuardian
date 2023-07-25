package view;
//ConsoleView.java
import java.util.Scanner;

public class ConsoleView {
 private Scanner scanner = new Scanner(System.in);

 public void displayMessage(String message) {
     System.out.println(message);
 }

 public String getInput() {
     return scanner.nextLine();
 }
}

