import java.io.*;
import java.util.*;
public class Main {
    public static void main(String [] args) throws FileNotFoundException {
        File file = new File("movies.txt");
        Scanner sc = new Scanner(file); // file scanner
        Scanner w = new Scanner(System.in); // word scanner
        StringManipulator sm = new StringManipulator();
        System.out.println("Welcome 1 ");
        // choose a random movie
        // first create an array of movies
        String[] mov = new String[11];
        System.out.println("Welcome 2");
        // keep adding each line to the array using a loop
        for (int i = 0; sc.hasNextLine(); i++)
            mov[i] = sc.nextLine();
        sc.close(); // close file scanner
        System.out.println("Welcome 3");    
        // now choose a random movie
        String m = mov[(int)(Math.random() * 11)];
        
        System.out.println("I have chosen a movie.");
        
        // DEBUG BREAKPOINT
        System.out.println(m);
        
        int wrongs = 0; // wrong guesses
        int c = 0; // letters guessed
        
        // continue as long as all the letters are guessed
        // or as long as the number of wrong guesses is below 5
        String comb = sm.generateDash(m); // the string as a result of the combination
        int letters = 0; // letters in comb
        while (wrongs < 5) {
            System.out.println("Guess the movie: " + comb);
            char ch = w.next(".").charAt(0); // get one character from the console
            String n = sm.reveal(m, ch); // reveal the character
            if (m.contains(String.valueOf(ch))) { // if the letter is contained
                comb = sm.combine(comb, n); // combine it
                letters = findLetters(comb); // find the number of letters guessed
                if (letters == m.length()) { // if all letters are guessed
                    System.out.println(comb);
                    System.out.println("You win!");
                    System.exit(0);
                }
            } 
            else
                wrongs++;
            System.out.println("You guessed " + wrongs + " wrong letters");
        }
        if (wrongs > 4)
            System.out.println("You lose!");
    }
    
    public static int findLetters(String str) {
        int l = 0;
        char[] strarr = str.toCharArray();
        for (int i = 0; i < strarr.length; i++)
            if (Character.isLetterOrDigit(strarr[i]))
                l++;
        return l;
    }
    
    public static int getLines(File file) throws FileNotFoundException {
        int lines = 0;
        Scanner fs = new Scanner(file);
        while (fs.hasNextLine())
            lines++;
        fs.close();
        return lines;
    }
}
