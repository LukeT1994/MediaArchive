import java.util.Scanner; //Libraries
import java.util.ArrayList;
import java.lang.String;

/**
 * Created by Luket on 28/11/2016.
 */
public class Movies {

    public static Scanner in = new Scanner(System.in); //Setting Scanner to "in"
    public static ArrayList<Movies> myMovies = new ArrayList<Movies>(); //Starting the array

    private String Title;
//    private String Title = ""; //Declaring Variables
    private String Duration = "";
    private String Studio = "";
    private String Director = "";
    private String Release = "";
    private String Rating = "";
    int MovieID = 0;

    public void setMovie(int MovieID, String Title, String Release, String Duration, String Studio, String Director, String Rating) { //Displaying order of Variables
        this.MovieID = MovieID;
        this.Title = Title;
        this.Release = Release;
        this.Duration = Duration;
        this.Studio = Studio;
        this.Director = Director;
        this.Rating = Rating;
    }


    public void Movie() {

        int selection = 0;

        loop:
        do {

            System.out.println("*****************");
            System.out.println("*     Movies    *"); // the Main Menu for the Movies Class
            System.out.println("*****************");

            System.out.println("[1]\tView All Movies");
            System.out.println("[2]\tAdd Movie");
            System.out.println("[3]\tDelete Movie");
            System.out.println("[4]\tSearch Movie");
            System.out.println("[5]\tRandom Movie");
            System.out.println("[6]\tBack");
            System.out.println("\nPlease Make a Selection");

            selection = in.nextInt();
            switch (selection) { //Switch Case Statement for Main Menu
                case 1: // view all Movies
                    listMovies();
                    break;
                case 2: // Add Movie
                    AddMovie();
                    break;
                case 3: // Delete Movie
                    DeleteMovie();
                    break;
                case 4: // Search Movie
                    Search();
                    break;
                case 5: // Random Movie
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



    public static void AddMovie() {

        Movies newMovie = new Movies();

        int MovieID = myMovies.size();
        in.nextLine();

        System.out.println("Title:"); // Enter Title of Film
        String Title = in.nextLine();

        System.out.println("Year of Release:"); //Enter year of Release
        String Release = in.nextLine();


        System.out.println("Duration e.g. 2h30, 40m:"); //Enter Length of Film
        String Duration = in.nextLine();

        System.out.println("Studio:"); // Enter Studio
        String Studio = in.nextLine();

        System.out.println("Director:"); // Enter Director
        String Director = in.nextLine();

        System.out.println("Star Rating:"); // Enter Star Rating
        String Rating = in.nextLine();

        System.out.println("\n**Film Added to the archive**\n"); //Conformation That Film has been added to the array

        newMovie.setMovie(MovieID, Title, Release, Duration, Studio, Director, Rating); //film being added to the myMovies array
        myMovies.add(newMovie);

    }

    private static void listMovies() { // Display All films

        for (int i = 0; i < myMovies.size(); i++) {
            System.out.println(myMovies.get(i).MovieID + "\t" +
                    myMovies.get(i).Title + "\t" +
                    myMovies.get(i).Release + "\t" +
                    myMovies.get(i).Duration + "\t" +
                    myMovies.get(i).Studio + "\t" +
                    myMovies.get(i).Director + "\t" +
                    myMovies.get(i).Rating);
        }
        if (myMovies.size() == 0) {
            System.out.println("No movies");
        }

    }

    private static void Search() { //Display the Search Menu

        int selection;

        loop:
        do {

            System.out.println("=================");
            System.out.println("      Search     "); // the Search Menu for the Movies Class
            System.out.println("=================");

            System.out.println("[1] Search by Movie ID");
            System.out.println("[2] Search by Title");
            System.out.println("[3] Search by Director");
            System.out.println("[4] Search by Studio");
            System.out.println("[5] Search by Release");
            System.out.println("[6] back");

            System.out.println("\nPlease Make a Selection");

            selection = in.nextInt();
            switch (selection) { //Switch Case Statement for Search Menu
                case 1: // Search By ID
                    SearchID();
                    break;
                case 2: // Search by Title
                    SearchTitle();
                    break;
                case 3: // Search by Director
                    SearchDirector();
                    break;
                case 4: // Search by Studio
                    SearchStudio();
                    break;
                case 5: // Search by Release
                    searchRelease();
                    break;
                case 6: //  Back
                    break loop;
                default:
                    System.out.println("Not a valid selection");
            }
        } while (selection != 0);

    }

    private static void SearchID() {

        System.out.println("Enter Search Movie ID:"); // Search by ID
        int Criteria = in.nextInt();

        for (int i = 0; i < myMovies.size(); i++) {

            if (myMovies.get(i).MovieID == Criteria) {
                System.out.println(myMovies.get(i).MovieID + "\t" +
                          myMovies.get(i).Title + "\t" +
                         myMovies.get(i).Release + "\t" +
                         myMovies.get(i).Duration + "\t" +
                         myMovies.get(i).Studio + "\t" +
                         myMovies.get(i).Director + "\t" +
                         myMovies.get(i).Rating + "\n");
            }
        }
    }

    private static void SearchTitle() {

        System.out.println("Enter Search Movie Title:"); //Search by Title
        String Criteria = in.next();

        for (int i = 0; i < myMovies.size(); i++) {

            if (myMovies.get(i).Title.equals(Criteria))  {
                System.out.println(myMovies.get(i).MovieID + "\t" +
                        myMovies.get(i).Title + "\t" +
                        myMovies.get(i).Release + "\t" +
                        myMovies.get(i).Duration + "\t" +
                        myMovies.get(i).Studio + "\t" +
                        myMovies.get(i).Director + "\t" +
                        myMovies.get(i).Rating );
            }
        }
    }

    private  static  void SearchDirector() {

        System.out.println("Enter Name of Director:"); //Search by Director
        String Criteria = in.next();

        for (int i = 0; i < myMovies.size(); i++) {

            if (myMovies.get(i).Director.equals(Criteria))  {
                System.out.println(myMovies.get(i).MovieID + "\t" +
                        myMovies.get(i).Title + "\t" +
                        myMovies.get(i).Release + "\t" +
                        myMovies.get(i).Duration + "\t" +
                        myMovies.get(i).Studio + "\t" +
                        myMovies.get(i).Director + "\t" +
                        myMovies.get(i).Rating + "\n");
            }
        }
    }

    private  static void SearchStudio() {

        System.out.println("Enter Movie Studio:"); //Search by Studio
        String Criteria = in.next();

        for (int i = 0; i < myMovies.size(); i++) {

            if (myMovies.get(i).Studio.equals(Criteria))  {
                System.out.println(myMovies.get(i).MovieID + "\t" +
                        myMovies.get(i).Title + "\t" +
                        myMovies.get(i).Release + "\t" +
                        myMovies.get(i).Duration + "\t" +
                        myMovies.get(i).Studio + "\t" +
                        myMovies.get(i).Director + "\t" +
                        myMovies.get(i).Rating + "\n");
            }
        }

    }

    private  static void searchRelease() {

        System.out.println("Enter Year of Movie Release:"); //Search By Release Year
        String Criteria = in.next();

        for (int i = 0; i < myMovies.size(); i++) {

            if (myMovies.get(i).Release.equals(Criteria))  {
                System.out.println(myMovies.get(i).MovieID + "\t" +
                        myMovies.get(i).Title + "\t" +
                        myMovies.get(i).Release + "\t" +
                        myMovies.get(i).Duration + "\t" +
                        myMovies.get(i).Studio + "\t" +
                        myMovies.get(i).Director + "\t" +
                        myMovies.get(i).Rating + "\n");
            }
        }

    }

    private static void DeleteMovie() { //Delete Movie by ID

        System.out.println("Enter ID Of film to be Deleted:");
        int Criteria = in.nextInt();

        for (int i = 0; i < myMovies.size(); i++) {

            if (myMovies.get(i).MovieID == Criteria) {
                System.out.println(myMovies.get(i).MovieID + "\t" +
                        myMovies.get(i).Title + "\t" +
                        myMovies.get(i).Release + "\t" +
                        myMovies.get(i).Duration + "\t" +
                        myMovies.get(i).Studio + "\t" +
                        myMovies.get(i).Director + "\t" +
                        myMovies.get(i).Rating + "\n");

                myMovies.remove(i);
            }
        }
    }

    private static void Random() { //Picks a random Movie
        int Criteria = (int)(Math.random() * myMovies.size() +1);

        for (int i = 0; i < myMovies.size(); i++) {

            if (myMovies.get(i).MovieID == Criteria) {
                System.out.println(myMovies.get(i).MovieID + "\t" +
                        myMovies.get(i).Title + "\t" +
                        myMovies.get(i).Release + "\t" +
                        myMovies.get(i).Duration + "\t" +
                        myMovies.get(i).Studio + "\t" +
                        myMovies.get(i).Director + "\t" +
                        myMovies.get(i).Rating + "\n");
            }
        }
    }

    private void back() { //Go Back function to go back to Menu Class
        Menu MenuObject = new Menu();
        MenuObject.MainMenu();
    }

}