import java.util.Scanner;


/**
 * Created by Luke on 20/11/2016.
 */
public class Menu {



    public static void main(String[] args) {
        Menu menu = new Menu();
        System.out.println("================================================");
        System.out.println("Data will not be stored when exiting the program");
        System.out.println("================================================\n");
        System.out.println("===============================================================================");
        System.out.println("Please Input Records without Spaces For Example 'Pulp Fiction' =  'PulpFiction'");
        System.out.println("===============================================================================\n");


        menu.MainMenu();
    }


    public void MainMenu() {
        System.out.println("*****************");
        System.out.println("* Media Archive *");
        System.out.println("*****************");

        System.out.println("\nWelcome to my Media Archive where you can Store Movies Music and TV Shows"); //welcome message

        System.out.println("Records. \n"); //output Menu to navigate to Movies/Music/TVShows
        System.out.println("[1]\tMovies");
        System.out.println("[2]\tMusic");
        System.out.println("[3]\tTV Shows");
        System.out.println("[4]\tExit");



        preformAction();

}

    private void preformAction() {
        System.out.println("\nPlease Make a Selection");
        int selection = getInput();
        switch (selection) { //Switch Case Statement
            case 1: // Movie
                Movies();
                break;
            case 2: // Music
                Music();
                break;
            case 3: // TV shows
                TvShows();
                break;
            case 4: //Exit

                System.out.println("Thank you for using the Media Archive");//Exit Message
                System.out.println("\nBye Bye");
                break;
            default:
                System.out.println("Not a valid selection");
                preformAction();
        }
    }


    private int getInput() { //input for switch Case Statement
        Scanner sc = new Scanner(System.in);
        int input = 0;
        while (true)
            try {
                input = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
               System.out.print("Try again: input is not valid");
            }

//        while (!sc.hasNextInt()) sc.next();
//        int num1 = sc.nextInt();

        return input;
    }

    private void Movies() { //Link to Movies Class
        Movies MoviesObject = new Movies();
        MoviesObject.Movie();
    }

    private void Music() { //Link to Music Class
        Music MusicObject = new Music();
        MusicObject.Music();
    }

    private void TvShows() { //Link to TvShows Class
        TvShows TvshowsObject = new TvShows();
        TvshowsObject.TvShows();
    }

    private void Exit() {
        System.out.println("Thank you for using the Media Archive");//Exit Message
        System.out.println("\nBye Bye");

    }
}







