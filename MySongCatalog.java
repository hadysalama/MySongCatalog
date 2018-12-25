/** 
*Hady Salama
*Song Catalog Program
*2018 APCSP Create Task
*The MySongCatalog class contains the main method and necessary algorithms that run the program.
*Some parts of the options method in this class has been adopted and extensively modified for the purposes of this Song Catalog Program.
*Adopted structures of the options method are based on a lab completed for the Rocky River Highschool AP Computer Science A Class with Mrs. Christina Bright.
*Adopted code structures will be specified and credit will be given where credit is due.
*All uncredited code used in the Song Catalog Project are of my own creation and did not include teacher assistance. 
*/

import java.util.ArrayList; //Imports Java ArrayList Class.
import java.util.List; //Imports Java List Class.
import java.util.Scanner; //Imports Java Scanner Class.
import java.lang.Integer; //Imports Java Integer Class.
import java.lang.Double; //Imports Java Double Class.
import java.lang.Boolean; //Imports Java Boolean Class.

public class MySongCatalog {
    private List<Song> catalog; //Declares ArrayList of Song objects defined by the Song class. 

    //Constructor instantiates ArrayList of Song objects defined by the Song class which is the catalog.
    public MySongCatalog() {
        catalog = new ArrayList<Song>();
    }

    /* 
    * Searches for a song based on the song name.
    * @param catalog: the Array List of Songs that the method is searching through.
    * @param name: the name of the song as a string.
    * name is an example of abstraction used as a parameter.
    * @return: returns the index of the searched song.
    *This is an example of an abstraction that I have wrote.
    */
    public int findSong(List<Song> catalog, String name) {
        for (int i = 0; i < catalog.size(); i++) {
            if (catalog.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    /* 
     * Comapres all the song ratings in the catalog and outputs best song.
     * @param catalog: the Array List of songs that the method is using.
     * @return:  a string of the best song's name, artist and year of release.
     * This is an example of an algorithm that I have wrote.
     */
    public String bestSong(List<Song> catalog) {
        Double lowerBound = -0.01;
        String bestSong = " ";
        for (int j = 0; j < catalog.size(); j++) {
            if (lowerBound < catalog.get(j).getRating()) {
                lowerBound = catalog.get(j).getRating();
                bestSong = catalog.get(j).getName() + " by " + catalog.get(j).getArtist() + " released in "
                        + catalog.get(j).getYear() + ".";
            }
        }
        return bestSong;
    }

    /*
    *The code structure of this method is adopted from the aforementioned lab.
    *Adopted Structures include the usage of the do while loop and option conditional statements.
    *The options method allows for the 1. addition (through user input), 2. removal, 3. resetting of 
      ratings (through user input), and 4. printing of songs in the song catalog.
    *The options method also implements the bestSong abstraction in choice 5.
    */
    public void options() {
        //Method feilds define all variables that will be used in the options method.
        String songName;
        String songArtist;
        int songYear;
        boolean songType;
        double songRating;
        int option;
        int position;
        int rating;
        Scanner reader = new Scanner(System.in);

        do {
            //Displays options through line by line printing.
            System.out.println();
            System.out.println("Welcome to the Song Catalog, please enter option: ");
            System.out.println("1. Add Song to Catalog");
            System.out.println("2. Remove Song from Catalog");
            System.out.println("3. Reset Song Rating");
            System.out.println("4. Print Catalog");
            System.out.println("5. Calculate Best Song");
            System.out.println("6. Exit");
            System.out.println();

            option = Integer.parseInt(reader.nextLine()); //Takes in user input of option
            System.out.println();

            //Creates the song object through user input to each feild.
            if (option == 1) {
                System.out.println("Please enter the song name: ");
                songName = reader.nextLine();

                System.out.println("Please enter the song artist: ");
                songArtist = reader.nextLine();

                System.out.println("Please enter the song's year of release: ");
                songYear = Integer.parseInt(reader.nextLine());

                System.out.println("Is the song a single? (true or false): ");
                songType = Boolean.parseBoolean(reader.nextLine());

                System.out.println("Please enter your personal rating of the song on a scale of 0-10: ");
                songRating = Double.parseDouble(reader.nextLine());

                Song track = new Song(songName, songArtist, songYear, songType, songRating);
                catalog.add(track);
            }

            //Removes a song from the catalog.
            //Implements the findSong abstraction.
            else if (option == 2) {
                System.out
                        .println("Please enter the exact name of the song you would like to remove from the catalog: ");
                songName = reader.nextLine();
                position = findSong(catalog, songName);
                catalog.remove(position);

            }

            //Finds the designated song using the findsong method and resets the rating of the song based on user input.
            //Implements the findSong abstraction.
            else if (option == 3) {
                System.out.println("Please enter the exact name of the song you would like to re-rate: ");
                songName = reader.nextLine();
                position = findSong(catalog, songName);
                System.out.println("Please enter the new song rating: ");
                rating = Integer.parseInt(reader.nextLine());
                catalog.get(position).setRating(rating);
            }

            //Prints the catalog in a concise format.
            else if (option == 4) {
                System.out.println("Song Catalog:");
                for (int k = 0; k < catalog.size(); k++) {
                    System.out.println();
                    System.out.println("Song " + (k + 1) + ":");
                    System.out.println("Name: " + catalog.get(k).getName());
                    System.out.println("Artist: " + catalog.get(k).getArtist());
                    System.out.println("Year of Release: " + catalog.get(k).getYear());
                    if (catalog.get(k).isSingle() == true) {
                        System.out.println("This song is a single.");
                    } else {
                        System.out.println("This song is part of an album or extended play.");
                    }
                    System.out.println("User Generated Rating: " + catalog.get(k).getRating());
                    System.out.println();
                }

            }

            //Implements the bestSong algorithm.
            else if (option == 5) {
                System.out.println("The best song based on your ratings is " + bestSong(catalog));

            }

            else {
                break;
            }

        } while (option != 6);

        reader.close();
    }

    //Main Method
    public static void main(String[] args) {
        MySongCatalog newCatalog = new MySongCatalog(); //Creates and instantiates catalog object.
        newCatalog.options(); //Runs options method which enables catalog editing.
    }
}