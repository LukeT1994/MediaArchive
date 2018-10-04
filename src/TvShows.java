import java.util.ArrayList; //Libraries
import java.util.Scanner;
import java.lang.String;

public class TvShows {

    public static Scanner in = new Scanner(System.in); //Setting Scanner to "in"
    public static ArrayList<TvShows> myShows = new ArrayList<>(); //Starting the array

    private String ShowName = ""; //Declaring Variables
    private String EpisodeTitle = "";
    private String Duration = "";
    int Season = 0;
    private String Release = "";
    private String Studio = "";
    private String Channel = "";
    private String Rating = "";
    int ShowID = 0;

    public void setShows(int ShowID, String Title, String EpisodeTitle, String Duration, int Season, String Release, String Channel, String Studio, String Rating) { //Displaying order of Variables
        this.ShowName = Title;
        this.EpisodeTitle = EpisodeTitle;
        this.Duration = Duration;
        this.Season = Season;
        this.Studio = Studio;
        this.Channel = Channel;
        this.Release = Release;
        this.Rating = Rating;
        this.ShowID = ShowID;
    }


    public void TvShows() {

        int selection = 0;

        loop:
        do {
            System.out.println("*****************");
            System.out.println("*    Tv Shows   *"); // the Main Menu for the Music Class
            System.out.println("*****************");

            System.out.println("[1]\tView All Shows");
            System.out.println("[2]\tAdd Show");
            System.out.println("[3]\tDelete Show");
            System.out.println("[4]\tSearch Show");
            System.out.println("[5]\tRandom Show");
            System.out.println("[6]\tBack");
            System.out.println("\nPlease Make a Selection");

            selection = in.nextInt();
            switch (selection) { //Switch Case Statement for Main Menu
                case 1: // view all tracks
                    listShows();
                    break;
                case 2: // Add track
                    AddShow();
                    break;
                case 3: // Delete track
                    DeleteShow();
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

    public void AddShow() {

        TvShows newShows = new TvShows();

        System.out.println("Episode ID:"); // Enter Episode ID
        int ShowID = in.nextInt();
        in.nextLine();

        System.out.println("Show Name:"); // Enter Show Name
        String Title = in.nextLine();

        System.out.println("Episode Name:"); // Episode Title
        String EpisodeTitle = in.nextLine();

        System.out.println("Duration e.g. 1h20 or 40m:"); // Enter Length of Episode
        String Duration = in.nextLine();

        System.out.println("Season:"); // Enter Season
        int Season = in.nextInt();
        in.nextLine();

        System.out.println("Studio:"); // Enter Studio Name
        String Studio = in.nextLine();

        System.out.println("Channel:"); // Enter Channel
        String Channel = in.nextLine();

        System.out.println("Year of Release:"); // Enter Year of Release
        String Release = in.nextLine();

        System.out.println("Star Rating:"); //  Enter Rating
        String Rating = in.nextLine();

        System.out.println("\n**Show Added to the archive**\n"); //Conformation That Show has been added to the array

        newShows.setShows(ShowID, Title, EpisodeTitle, Duration, Season, Studio, Channel, Release, Rating); //Show being added to the myShows array
        myShows.add(newShows);
    }

    private static void listShows() {// Display All films


        for (int i = 0; i < myShows.size(); i++) {
            System.out.println(myShows.get(i).ShowID + "\t" +
                    myShows.get(i).ShowName + "\t" +
                    myShows.get(i).EpisodeTitle + "\t" +
                    myShows.get(i).Duration + "\t" +
                    myShows.get(i).Season + "\t" +
                    myShows.get(i).Release + "\t" +
                    myShows.get(i).Channel + "\t" +
                    myShows.get(i).Studio + "\t" +
                    myShows.get(i).Rating);
        }
        if (myShows.size() == 0) {
            System.out.println("No shows");
        }
    }



    private static void Search() {//Display the Search Menu

        int selection = 0;

        loop:
        do {

            System.out.println("=================");
            System.out.println("      Search     "); // the Search Menu for the TvShows Class
            System.out.println("=================");

            System.out.println("[1] Search by Show ID");
            System.out.println("[2] Search by Show");
            System.out.println("[3] Search by Episode Title");
            System.out.println("[4] Search by Season");
            System.out.println("[5] Search by Release");
            System.out.println("[6] Search by Channel");
            System.out.println("[7] Search by Studio");
            System.out.println("[8] back");
            System.out.println("\nPlease Make a Selection");

            selection = in.nextInt();
            switch (selection) {
                case 1: // Search By ID
                    SearchID();
                    break;
                case 2: // Search by Title
                    SearchShow();
                    break;
                case 3: // Search by Director
                    SearchEpisode();
                    break;
                case 4: // Search by Studio
                    SearchSeason();
                    break;
                case 5:
                    SearchRelease();
                case 6: // Search by Release
                    SearchChannel();
                    break;
                case 7:
                    SearchStudio();
                case 8: //  Back
                    break loop;
                default:
                    System.out.println("Not a valid selection");
            }
        } while (selection != 0);

    }

    private static void SearchID() { //Search By ID

        System.out.println("Enter The show ID:");
        int Criteria = in.nextInt();

        for (int i = 0; i < myShows.size(); i++) {

            if (myShows.get(i).ShowID == Criteria) {
                System.out.println(myShows.get(i).ShowID + "\t" +
                        myShows.get(i).ShowName + "\t" +
                        myShows.get(i).EpisodeTitle + "\t" +
                        myShows.get(i).Duration + "\t" +
                        myShows.get(i).Season + "\t" +
                        myShows.get(i).Release + "\t" +
                        myShows.get(i).Channel + "\t" +
                        myShows.get(i).Studio + "\t" +
                        myShows.get(i).Rating);
            }
        }
    }

    private static void SearchShow() { //Search By Show Name

        System.out.println("Enter Show's Name:");
        String Criteria = in.next();

        for (int i = 0; i < myShows.size(); i++) {

            if (myShows.get(i).ShowName.equals(Criteria))  {
                System.out.println(myShows.get(i).ShowID + "\t" +
                        myShows.get(i).ShowName + "\t" +
                        myShows.get(i).EpisodeTitle + "\t" +
                        myShows.get(i).Duration + "\t" +
                        myShows.get(i).Season + "\t" +
                        myShows.get(i).Release + "\t" +
                        myShows.get(i).Channel + "\t" +
                        myShows.get(i).Studio + "\t" +
                        myShows.get(i).Rating);
            }
        }
    }

    private static void SearchEpisode() { //Search By Episode Name

        System.out.println("Enter Episode Title:");
        String Criteria = in.next();

        for (int i = 0; i < myShows.size(); i++) {

            if (myShows.get(i).EpisodeTitle.equals(Criteria))  {
                System.out.println(myShows.get(i).ShowID + "\t" +
                        myShows.get(i).ShowName + "\t" +
                        myShows.get(i).EpisodeTitle + "\t" +
                        myShows.get(i).Duration + "\t" +
                        myShows.get(i).Season + "\t" +
                        myShows.get(i).Release + "\t" +
                        myShows.get(i).Channel + "\t" +
                        myShows.get(i).Studio + "\t" +
                        myShows.get(i).Rating);
            }
        }
    }

    private static void SearchSeason() {// Search By Season

        System.out.println("Enter Season:"); //This Needs a second Look
        int Criteria = in.nextInt();

        for (int i = 0; i < myShows.size(); i++) {

            if (myShows.get(i).Season == Criteria)   {
                System.out.println(myShows.get(i).ShowID + "\t" +
                        myShows.get(i).ShowName + "\t" +
                        myShows.get(i).EpisodeTitle + "\t" +
                        myShows.get(i).Duration + "\t" +
                        myShows.get(i).Season + "\t" +
                        myShows.get(i).Release + "\t" +
                        myShows.get(i).Channel + "\t" +
                        myShows.get(i).Studio + "\t" +
                        myShows.get(i).Rating);
            }
        }
    }

    private static void SearchRelease() {// Search by Year of Release
        System.out.println("Enter Year of Release:");
        String Criteria = in.next();

        for (int i = 0; i < myShows.size(); i++) {

            if (myShows.get(i).Release.equals(Criteria))  {
                System.out.println(myShows.get(i).ShowID + "\t" +
                        myShows.get(i).ShowName + "\t" +
                        myShows.get(i).EpisodeTitle + "\t" +
                        myShows.get(i).Duration + "\t" +
                        myShows.get(i).Season + "\t" +
                        myShows.get(i).Release + "\t" +
                        myShows.get(i).Channel + "\t" +
                        myShows.get(i).Studio + "\t" +
                        myShows.get(i).Rating);
            }
        }
    }


    private static void SearchChannel() { // Search by Channel

        System.out.println("Enter Original Broadcast Channel:");
        String Criteria = in.next();

        for (int i = 0; i < myShows.size(); i++) {

            if (myShows.get(i).EpisodeTitle.equals(Criteria))  {
                System.out.println(myShows.get(i).ShowID + "\t" +
                        myShows.get(i).ShowName + "\t" +
                        myShows.get(i).EpisodeTitle + "\t" +
                        myShows.get(i).Duration + "\t" +
                        myShows.get(i).Season + "\t" +
                        myShows.get(i).Release + "\t" +
                        myShows.get(i).Channel + "\t" +
                        myShows.get(i).Studio + "\t" +
                        myShows.get(i).Rating);
            }
        }
    }

    private static void SearchStudio() { //Search by Studio

        System.out.println("Enter Studio:");
        String Criteria = in.next();

        for (int i = 0; i < myShows.size(); i++) {

            if (myShows.get(i).Studio.equals(Criteria))  {
                System.out.println(myShows.get(i).ShowID + "\t" +
                        myShows.get(i).ShowName + "\t" +
                        myShows.get(i).EpisodeTitle + "\t" +
                        myShows.get(i).Duration + "\t" +
                        myShows.get(i).Season + "\t" +
                        myShows.get(i).Release + "\t" +
                        myShows.get(i).Channel + "\t" +
                        myShows.get(i).Studio + "\t" +
                        myShows.get(i).Rating);
            }
        }
    }

private static void DeleteShow() {  //Delete Movie by ID
    System.out.println("Enter ID Of Show to be Deleted:");
    int Criteria = in.nextInt();

    for (int i = 0; i < myShows.size(); i++) {

        if (myShows.get(i).ShowID == Criteria) {
            System.out.println(myShows.get(i).ShowID + "\t" +
                    myShows.get(i).ShowName + "\t" +
                    myShows.get(i).EpisodeTitle + "\t" +
                    myShows.get(i).Duration + "\t" +
                    myShows.get(i).Season + "\t" +
                    myShows.get(i).Release + "\t" +
                    myShows.get(i).Channel + "\t" +
                    myShows.get(i).Studio + "\t" +
                    myShows.get(i).Rating);

            myShows.remove(i);
        }
    }
}

    private static void Random() { //Selects random Show
        int Criteria = (int)(Math.random() * myShows.size() +1);

        for (int i = 0; i < myShows.size(); i++) {

            if (myShows.get(i).ShowID == Criteria) {
                System.out.println(myShows.get(i).ShowID + "\t" +
                        myShows.get(i).ShowName + "\t" +
                        myShows.get(i).EpisodeTitle + "\t" +
                        myShows.get(i).Duration + "\t" +
                        myShows.get(i).Season + "\t" +
                        myShows.get(i).Release + "\t" +
                        myShows.get(i).Channel + "\t" +
                        myShows.get(i).Studio + "\t" +
                        myShows.get(i).Rating);
            }
        }
    }


}



