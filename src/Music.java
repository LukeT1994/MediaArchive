import java.util.Scanner; //Libraries
import java.util.ArrayList;
import java.lang.String;

/**
 * Created by Luket on 03/12/2016.
 */
public class Music {

    public static Scanner in = new Scanner (System.in); //Setting Scanner to "in"
    public static ArrayList<Music> myMusic = new ArrayList<Music>(); //Starting the array

    private String Title = ""; //Declaring Variables
    private String Duration = "";
    private String rLabel = "";
    private String Artist = "";
    private String Release = "";
    private String Rating = "";
    private String Album = "" ;
    int TrackID = 0;

    public void setMusic(int TrackID, String Title, String Album, String Release, String Duration,String rLabel, String Director, String Rating) { //Displaying order of Variables
        this.TrackID = TrackID;
        this.Title = Title;
        this.Album = Album;
        this.Release = Release;
        this.Duration = Duration;
        this.rLabel = rLabel;
        this.Artist = Director;
        this.Rating = Rating;
    }

    public void Music() {

        int selection = 0;

        loop: do {

            System.out.println("*****************");
            System.out.println("*     Music     *"); // the Main Menu for the Music Class
            System.out.println("*****************");

            System.out.println("[1]\tView All Tracks");
            System.out.println("[2]\tAdd Track");
            System.out.println("[3]\tDelete Track");
            System.out.println("[4]\tSearch Track");
            System.out.println("[5]\tRandom Track");
            System.out.println("[6]\tBack");
            System.out.println("\nPlease Make a Selection");

            selection = in.nextInt();
            switch (selection) { //Switch Case Statement for Main Menu
                case 1: // view all tracks
                    listTrack();
                    break;
                case 2: // Add track
                    AddTrack();
                    break;
                case 3: // Delete track
                    DeleteTrack();
                    break;
                case 4: // Search track
                    Search();
                    break;
                case 5: // Random track
                    Random();
                    break;
                case 6: //  Back
                    back();
                    break loop;
                default:
                    System.out.println("Not a valid selection");
            }
        } while (selection != 0);
        }

    private void back() { //Go Back function to go back to Menu Class
        Menu MenuObject = new Menu();
        MenuObject.MainMenu();
    }

    private static void AddTrack() {

        Music newMusic = new Music();
        System.out.println("Track ID:"); //Enter Track ID
        int TrackID  = in.nextInt();
        in.nextLine();

        System.out.println("Track Name:"); //Enter Track Name
        String Title = in.nextLine();

        System.out.println("Album Name:"); // Enter Album Name
        String Album = in.nextLine();

        System.out.println("Year of Release:"); //Enter Year of Release Date
        String Release = in.nextLine();

        System.out.println("Duration e.g. 2m30 :"); //Enter Length of Track
        String Duration = in.nextLine();

        System.out.println("Record Label"); // Enter Record Label
        String rLabel = in.nextLine();

        System.out.println("Artist/Band"); // Enter Band or Artist
        String Artist = in.nextLine();

        System.out.println("Star Rating"); // Enter Star Rating
        String Rating = in.nextLine();

        System.out.println("\n**Track Added to the archive**\n"); //Conformation That Track has been added to the array

        newMusic.setMusic(TrackID, Title, Album, Release, Duration, rLabel, Artist, Rating); //Track being added to the myMusic array
        myMusic.add(newMusic);
    }

    private static void listTrack() { // Display All Tracks


        for (int i = 0; i < myMusic.size(); i++) {
            System.out.println(myMusic.get(i).TrackID + "\t" +
                    myMusic.get(i).Title + "\t" +
                    myMusic.get(i).Album + "\t" +
                    myMusic.get(i).Release + "\t" +
                    myMusic.get(i).Duration + "\t" +
                    myMusic.get(i).rLabel + "\t" +
                    myMusic.get(i).Artist + "\t" +
                    myMusic.get(i).Rating);
        }
        if (myMusic.size() == 0) {
            System.out.println("No music");
        }
    }


    private static void Search() {//Display the Search Menu

        int selection = 0;

        loop:
        do {

            System.out.println("=================");
            System.out.println("      Search     "); // the Search Menu for the Music Class
            System.out.println("=================");

            System.out.println("[1] Search by Track ID");
            System.out.println("[2] Search by Track");
            System.out.println("[3] Search by Album");
            System.out.println("[4] Search by Band/Artist");
            System.out.println("[5] Search by Record Label");
            System.out.println("[6] Search by Release");
            System.out.println("[7] back");
            System.out.println("\nPlease Make a Selection");

            selection = in.nextInt();
            switch (selection) {
                case 1: // Search By ID
                    SearchID();
                    break;
                case 2: // Search by Title
                    SearchTitle();
                    break;
                case 3: // Search by Director
                    SearchAlbum();
                    break;
                case 4: // Search by Studio
                    SearchArtist();
                    break;
                case 5: // Search by Release
                    SearchrLabel();
                    break;
                case 6: //  Back
                    searchRelease();
                case 7: //  Back
                    break loop;
                default:
                    System.out.println("Not a valid selection");
            }
        } while (selection != 0);

    }

    private static void SearchID() { //Search By ID

        System.out.println("Enter Track ID:");
        int Criteria = in.nextInt();

        for (int i = 0; i < myMusic.size(); i++) {

            if (myMusic.get(i).TrackID == Criteria) {
                System.out.println(myMusic.get(i).TrackID + "\t" +
                        myMusic.get(i).Title + "\t" +
                        myMusic.get(i).Album + "\t" +
                        myMusic.get(i).Release + "\t" +
                        myMusic.get(i).Duration + "\t" +
                        myMusic.get(i).rLabel + "\t" +
                        myMusic.get(i).Artist + "\t" +
                        myMusic.get(i).Rating);
            }
        }
    }

    private static void SearchTitle() { //Search By Track Name

        System.out.println("Enter Song Name:");
        String Criteria = in.next();

        for (int i = 0; i < myMusic.size(); i++) {

            if (myMusic.get(i).Title.equals(Criteria))  {
                System.out.println(myMusic.get(i).TrackID + "\t" +
                        myMusic.get(i).Title + "\t" +
                        myMusic.get(i).Album + "\t" +
                        myMusic.get(i).Release + "\t" +
                        myMusic.get(i).Duration + "\t" +
                        myMusic.get(i).rLabel + "\t" +
                        myMusic.get(i).Artist + "\t" +
                        myMusic.get(i).Rating);
            }
            }
        }

    private static void SearchAlbum() { // Search By Album

        System.out.println("Enter Album Name:");
        String Criteria = in.next();

        for (int i = 0; i < myMusic.size(); i++) {

            if (myMusic.get(i).Album.equals(Criteria))  {
                System.out.println(myMusic.get(i).TrackID + "\t" +
                        myMusic.get(i).Title + "\t" +
                        myMusic.get(i).Album + "\t" +
                        myMusic.get(i).Release + "\t" +
                        myMusic.get(i).Duration + "\t" +
                        myMusic.get(i).rLabel + "\t" +
                        myMusic.get(i).Artist + "\t" +
                        myMusic.get(i).Rating);
            }
        }
    }

    private static void SearchArtist() { //Search by Band or Artist

        System.out.println("Enter Band or Artist:");
        String Criteria = in.next();

        for (int i = 0; i < myMusic.size(); i++) {

            if (myMusic.get(i).Artist.equals(Criteria))  {
                System.out.println(myMusic.get(i).TrackID + "\t" +
                        myMusic.get(i).Title + "\t" +
                        myMusic.get(i).Album + "\t" +
                        myMusic.get(i).Release + "\t" +
                        myMusic.get(i).Duration + "\t" +
                        myMusic.get(i).rLabel + "\t" +
                        myMusic.get(i).Artist + "\t" +
                        myMusic.get(i).Rating);
            }
        }
    }

    private static void SearchrLabel() { // Search By record Label

        System.out.println("Enter Record Label:");
        String Criteria = in.next();

        for (int i = 0; i < myMusic.size(); i++) {

            if (myMusic.get(i).rLabel.equals(Criteria))  {
                System.out.println(myMusic.get(i).TrackID + "\t" +
                        myMusic.get(i).Title + "\t" +
                        myMusic.get(i).Album + "\t" +
                        myMusic.get(i).Release + "\t" +
                        myMusic.get(i).Duration + "\t" +
                        myMusic.get(i).rLabel + "\t" +
                        myMusic.get(i).Artist + "\t" +
                        myMusic.get(i).Rating);
            }
        }
    }

    private static void searchRelease() { //Search By year

        System.out.println("Enter Year of Release:");
        String Criteria = in.next();

        for (int i = 0; i < myMusic.size(); i++) {

            if (myMusic.get(i).Release.equals(Criteria))  {
                System.out.println(myMusic.get(i).TrackID + "\t" +
                        myMusic.get(i).Title + "\t" +
                        myMusic.get(i).Album + "\t" +
                        myMusic.get(i).Release + "\t" +
                        myMusic.get(i).Duration + "\t" +
                        myMusic.get(i).rLabel + "\t" +
                        myMusic.get(i).Artist + "\t" +
                        myMusic.get(i).Rating);
            }
        }
    }

    private static void DeleteTrack() { //Delete Movie by ID

        System.out.println("Enter ID Of Track to be Deleted:");
        int Criteria = in.nextInt();

        for (int i = 0; i < myMusic.size(); i++) {

            if (myMusic.get(i).TrackID == Criteria) {
                System.out.println(myMusic.get(i).TrackID + "\t" +
                        myMusic.get(i).Title + "\t" +
                        myMusic.get(i).Album + "\t" +
                        myMusic.get(i).Release + "\t" +
                        myMusic.get(i).Duration + "\t" +
                        myMusic.get(i).rLabel + "\t" +
                        myMusic.get(i).Artist + "\t" +
                        myMusic.get(i).Rating);

                myMusic.remove(i);
            }
        }
    }

    private static void Random() { //Selects random Track
        int Criteria = (int)(Math.random() * myMusic.size() +1);

        for (int i = 0; i < myMusic.size(); i++) {

            if (myMusic.get(i).TrackID == Criteria) {
                System.out.println(myMusic.get(i).TrackID + "\t" +
                        myMusic.get(i).Title + "\t" +
                        myMusic.get(i).Album + "\t" +
                        myMusic.get(i).Release + "\t" +
                        myMusic.get(i).Duration + "\t" +
                        myMusic.get(i).rLabel + "\t" +
                        myMusic.get(i).Artist + "\t" +
                        myMusic.get(i).Rating);
            }
        }
    }
}
