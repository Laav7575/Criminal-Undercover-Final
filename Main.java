/*  Laavanya Thiagalingam
    Course Code: ICS3U0
    Assignment Title: Final Project
    Date Completed: January 17, 2022
    Program Description: An escape room game based on an intruder lockdown in a school where the user is the only student left behind in the class.
*/
import java.util.Scanner;

class Main {

  static Scanner scanner; //global variable for scanner
  public static void main(String[] args) { 
    scanner = new Scanner (System.in);
    MyGame mg = new MyGame (); //instantiate MyGame object
    boolean gamesComplete = false; //left games complete
    boolean passcode = false; //acquired passcode
    boolean userKey = false; //acquired key
    boolean ventOpen = false; //acquired safety equip
    boolean compAccess = false; //computer has been accessed
    boolean complete = false; //door can open successfully
    int cntGame1 = 0; //count for game1
    int cntGame2 = 0; //count for game2
    int iGame1 = 0; //count for game1 that is used for method
    int game3Score = 0; //score for game3
    int game3cpu = 0; //score for game3 intruder 
    String direction = ""; //outputs message for chosen direction
    String choiceLaptop = ""; //choice of interact with laptop
    String choiceVent = ""; //choice to interact with vent
    String choiceGame = ""; //choice to play game
    String choiceComp = ""; //choice to check computer
    String choiceCompResult = ""; //return of method choiceComp
    String doorChoice = ""; //choice to interact with door
    String doorResult = ""; //return of method door
    String ventOpenResult = ""; //return of method openVent
    String numGuess = ""; //user's guess for game1
    String compPWGuess = ""; //user's guess for computer PW
    String compPWCheck = ""; //return for method compPWCheck
    String compGuess = ""; //user's guess for computer#
    String compGuessResult = ""; //return for method compGuess
    String laptop = ""; //return of method laptop
    String userGame = ""; //choice to play game
    String game1Result = ""; //return of method game1
    String triviaGuess = ""; //user's guess for game2
    String game2Result = ""; //return of method game2
    String game3Choice = ""; //choice for game3
    String game3Result = ""; //return of method game3
    String game3pt2Result = ""; //return of method game3pt2
    String [] game1Hints = new String [5]; //includes hints for game1
    String [] game2Qs = new String [3]; //questions for game2
    game1Hints [0] = "It is a factor of 48. Guess the number: ";
    game1Hints [1] = "It is the number of minutes between each tick on a clock. Guess the number: ";
    game1Hints [2] = "It is the number everyone wants to be at the end of a race. Guess the number: ";
    game1Hints [3] = "It is the legal age for a person to be charged with a crime as an adult. Guess the number: ";
    game1Hints [4] = "It is a two digit number and the two digits in the number add up to 5. Guess the number: "; //hints for game1
    game2Qs [0] = "1) What compound in a fire extinguisher is used to put out a fire? ";
    game2Qs [1] = "2) What compound created in a fire kills humans?";
    game2Qs [2] = "3) What gas found in air feeds a fire? "; //questions for game2

    System.out.println("Welcome to Criminal Undercover. We begin now. \nYou are alone in a dimly lit classroom under lockdown. There is an intruder in the school building. All your classmates had gone down to the library while you were in the washroom, leaving you behind by mistake. \nWould you like to look around? Choose a direction to look in, right, left, up or behind. "); //intro
    String choiceLook = scanner.nextLine(); //variable for user choice on where to look
    direction = mg.choiceDirection(choiceLook,gamesComplete, passcode, userKey, ventOpen, compAccess); //return of method choiceDirection
    System.out.println(direction);
    while (direction.equals("Choose a direction to look in, right, left, up or behind. ")) { //while user types in an invalid direction
      choiceLook = scanner.nextLine(); //stores direction they want to look
      direction = mg.choiceDirection(choiceLook, gamesComplete, passcode, userKey, ventOpen, compAccess);
      System.out.println(direction); //outputs message accordingly 
    }
    //left
    while ((gamesComplete == false) && (choiceLook.equalsIgnoreCase("left"))) { //while user looks left and games are not complete
      choiceLaptop = scanner.nextLine(); //stores if user wants to interact with laptop
      choiceLook = ""; //ends loop if user says yes
     laptop = mg.laptop(choiceLaptop); //returns message according to response
     System.out.println (laptop); //outputs message accordingly 
     while (laptop.equals("Choose a direction to look in, right, left, up or behind. ")) { //while user does not want to interact with laptop, method returns this
       choiceLook = scanner.nextLine();
       direction = mg.choiceDirection(choiceLook, gamesComplete, passcode, userKey, ventOpen, compAccess);
       System.out.println(direction); //asks user for direction again and outputs message accordingly
       laptop = direction;
     }
    while ((choiceLaptop.equalsIgnoreCase("yes")) && (choiceLook.equalsIgnoreCase(""))) { //while user wants to interact with laptop and last loop has been run so choiceLook is ""
      choiceGame = scanner.nextLine(); //user choice to play
      choiceLook = "left"; //allows previous loop to run
      userGame = mg.userGame1(choiceGame); //returns message according to response
      System.out.println (userGame); 
      if (userGame.equals("Choose a direction to look in, right, left, up or behind. ")) { //if user does not want to play
        choiceLook = scanner.nextLine();
        direction = mg.choiceDirection(choiceLook, gamesComplete, passcode, userKey, ventOpen, compAccess);
        System.out.println(direction); //asks user for direction again and outputs message accordingly
        while (direction.equals("Choose a direction to look in, right, left, up or behind. ")) { //while user doesn't enter valid direction
          choiceLook = scanner.nextLine();
          direction = mg.choiceDirection(choiceLook, gamesComplete, passcode, userKey, ventOpen, compAccess);
          System.out.println(direction); //asks user for direction again and outputs message accordingly
       }
     }
     else { //user wants to play
       gamesComplete = true; //ends loop
     }
    }
    }
    gamesComplete = false; //start games
    //game1
    if (choiceGame.equalsIgnoreCase("yes") && (choiceLook.equalsIgnoreCase("left"))) { //if user wants to play and they want to look left
      numGuess = scanner.nextLine(); //store game1 guess
      game1Result = mg.game1(numGuess, iGame1); //returns if guess is right or not
       while (game1Result.equals("Incorrect. Try again. If you would like to quit, type \"quit\". \n")) { //while guess is wrong
          System.out.println(game1Result + game1Hints[cntGame1]);
          numGuess = scanner.nextLine();
          game1Result = mg.game1(numGuess, iGame1); //output result, repeat q and check if new guess is right
        if (game1Result.equals("I see you :)")) { //if user quits
          System.out.println(game1Result);
          System.exit(0); //end game
        }
       }
       if (choiceGame.equalsIgnoreCase("yes")) { //if user chooses to play game
      while (cntGame1 < 5) { //while user hasn't done all 5 questions
        if (game1Result.equals("Correct. Here’s your next hint; ")) { //if user's guess is correct
          cntGame1++; //next q
          if (cntGame1 < 5) { //if user hasn't done all 5 questions
            iGame1 = cntGame1;
            System.out.println(game1Result + game1Hints[cntGame1]);
            numGuess = scanner.nextLine();
            game1Result = mg.game1(numGuess, cntGame1);
          } //outputs message + next q
        }
        else if (game1Result.equals("Incorrect. Try again. If you would like to quit, type \"quit\". \n")) { //if user guess is incorrect
          System.out.println(game1Result + game1Hints[cntGame1]);
          numGuess = scanner.nextLine();
          game1Result = mg.game1(numGuess, iGame1);
        } //outputs result and question again
        else if (game1Result.equals("I see you :)")) { //if user quits
          System.out.println(game1Result);
          System.exit(0); //ends game
        }
      }
      //game2
      System.out.println("Good job, you’ve passed the first game. Each number represents a letter. Let’s test your memory and see if you can remember the word it creates for later.\nNow onto the second game :) I have three trivia questions for you, you have unlimited guesses. Let’s begin…\n1) What compound in a fire extinguisher is used to put out a fire? ");
    }
    triviaGuess = scanner.nextLine();
    game2Result = mg.game2(triviaGuess, cntGame2); //checks user guess for trivia
       while (game2Result.equals("Incorrect. Try again. If you would like to quit, type \"quit\".\n")) { //while user guess is wrong
          System.out.println(game2Result + game2Qs[cntGame2]); //output result and repeats q
          triviaGuess = scanner.nextLine(); //get new guess
          game2Result = mg.game2(triviaGuess, cntGame2); //check new guess
        if (game2Result.equals("I see you :)")) { //if user quits
          System.out.println(game2Result);
          System.exit(0); //ends game
        }
       }
      while (cntGame2 < 3) { //while not all questions have been answered
        if (game2Result.equals("Correct.\n")) { //if user answer is correct
          if (cntGame2 == 2) { //if user has won game2
            System.out.print(game2Result);
            System.out.println("You have completed my second game too, good job.\nThe sum of the number of atoms in all three answers is an important number to me, in fact it is my favourite number. The room will soon start filling with a flammable gas called methane, you should get out soon, if you don’t want it to infiltrate the building :)\nOur final game is a game of luck like rock, paper, scissors, choose between XX, XY and YX. XY beats YX and YX beats XX and XX beats XY. We’ll play three rounds and whoever gets the most points wins. \nEnter your choice:");
            cntGame2++; //ends loop
          }
          else { //correct answer and not done game
            cntGame2++; //onto next q
            System.out.println(game2Result + game2Qs[cntGame2]);
            triviaGuess = scanner.nextLine();
            game2Result = mg.game2(triviaGuess, cntGame2);
          } //outputs result, next q, and checks new guess
        }
        else if (game2Result.equals("Incorrect. Try again. If you would like to quit, type \"quit\".\n")) { //if user guess is wrong
          System.out.println(game2Result + game2Qs[cntGame2]);
          triviaGuess = scanner.nextLine();
          game2Result = mg.game2(triviaGuess, cntGame2);
        } //outputs result, repeats q, and checks new guess
        else if (game2Result.equals("I see you :)")) { //if user wants to quit
          System.out.println(game2Result);
          System.exit(0); //ends game
        }
      }
      //game3 
    game3Choice = scanner.nextLine();
    game3Result = mg.game3(game3Choice); //determines if user wants to play
    game3pt2Result = mg.game3pt2 (game3Result, game3Choice);
    while (game3cpu <= 2 && game3Score <= 2) { //while neither intruder or user has won with 3 points
      System.out.println(game3pt2Result);
      game3Choice = scanner.nextLine();
      game3Result = mg.game3(game3Choice); //check who wins
      game3Score = mg.game3Score;
      game3cpu = mg.game3cpu; //return value from object class to update scores
      game3pt2Result = mg.game3pt2 (game3Result, game3Choice); //outputs result of round
    }
    while (game3cpu == 3) { //while comp wins, restart game
      System.out.println("I win the game :)\nLet's play again with the scores reset. Enter your choice:");
      mg.resetGame3(); //method to reset scores
      game3Score = mg.game3Score;
      game3cpu = mg.game3cpu; //update scores
      while (game3cpu < 3 && game3Score < 3) { //while no one has won yet
        game3Choice = scanner.nextLine();
        game3Result = mg.game3(game3Choice); //checks if user wins
        game3pt2Result = mg.game3pt2(game3Result, game3Choice); //if user loses, says that, if they win, says that 
        game3Score = mg.game3Score;
        game3cpu = mg.game3cpu;
        if (game3cpu == 3 || game3Score == 3) { //if either intruder or user wins
          game3pt2Result = game3pt2Result.substring(0, game3pt2Result.length() - 39); //slices off 
          System.out.println(game3pt2Result);
        }
        else { //no one has won yet
          System.out.println(game3pt2Result);
        }
      } //outputs result for each q
    } 
    if (game3Score == 3) { //if user wins
      gamesComplete = true; //games are done
      passcode = true; //user has passcode
      compAccess = true; //they have access to the computers
      direction = mg.gamesCompleted();
      System.out.println(direction); //done all games, choose direction to look in
      mg.allDirections(gamesComplete, choiceLook, direction, passcode, userKey, ventOpen, compAccess, complete, choiceLaptop, laptop, choiceGame, userGame, numGuess, game1Result, cntGame1, iGame1, triviaGuess, game2Result, cntGame2, game3Choice, game3Result, game3pt2Result, game3Score, game3cpu, doorChoice, doorResult, compGuess, compGuessResult, compPWGuess, compPWCheck, choiceVent, ventOpenResult, choiceCompResult, choiceComp); //outputs according message for any direction user chooses
    }
    }

    //right 
     if (passcode == false &&(choiceLook.equalsIgnoreCase("right"))) { //if user does not have code to door and chooses to look right
       doorChoice = scanner.nextLine();
       doorResult = mg.door(doorChoice);
       System.out.println(doorResult); //output that user cannot open door, choose direction to look in
       direction = doorResult;
       mg.allDirections(gamesComplete, choiceLook, direction, passcode, userKey, ventOpen, compAccess, complete, choiceLaptop, laptop, choiceGame, userGame, numGuess, game1Result, cntGame1, iGame1, triviaGuess, game2Result, cntGame2, game3Choice, game3Result, game3pt2Result, game3Score, game3cpu, doorChoice, doorResult, compGuess, compGuessResult, compPWGuess, compPWCheck, choiceVent, ventOpenResult, choiceCompResult, choiceComp); //outputs according message for any direction user chooses
       }
    
    //up
    if ((ventOpen == false) && (choiceLook.equalsIgnoreCase("up"))) { //if user has not opened vent and chooses to look up
      choiceVent = scanner.nextLine(); //get choice to open vent
      ventOpenResult = mg.openVent(choiceVent, userKey);
      System.out.println(ventOpenResult); //result of user's choice to open vent
      direction = ventOpenResult;
      if (choiceVent.equalsIgnoreCase("yes") && userKey == true) { //if user chooses to open vent and has key to do so
        complete = true; //everything complete to escape
        ventOpen = true; //vent has been opened
      }
      mg.allDirections(gamesComplete, choiceLook, direction, passcode, userKey, ventOpen, compAccess, complete, choiceLaptop, laptop, choiceGame, userGame, numGuess, game1Result, cntGame1, iGame1, triviaGuess, game2Result, cntGame2, game3Choice, game3Result, game3pt2Result, game3Score, game3cpu, doorChoice, doorResult, compGuess, compGuessResult, compPWGuess, compPWCheck, choiceVent, ventOpenResult, choiceCompResult, choiceComp);
      //outputs according message for any direction user chooses
    }

    //behind 
    if (choiceLook.equalsIgnoreCase("behind")) { //if user chooses to look behind
      choiceComp = scanner.nextLine(); //get choice to turn on comp
      choiceCompResult = mg.choiceComp(choiceComp);
      System.out.println(choiceCompResult); //result of user's choice to turn on computer
      direction = choiceCompResult;
      boolean compDone = direction.equals("The computer unlocks! It displays a message, it says:\nThe key is located at the back of the monitor. Using this, open the vent.\nYou reach behind the monitor and find the key, hurrah! Suddenly, all the computers turn off.\nChoose a direction to look in, right, left, up or behind. ");
      boolean invalidEntry = direction.equals("Choose a direction to look in, right, left, up or behind. ");
      if (compDone == true) { //if they unlocked the comp
        userKey = true; //they have the key
      }
      if (invalidEntry) { //if asked to choose direction again
      mg.allDirections(gamesComplete, choiceLook, direction, passcode, userKey, ventOpen, compAccess, complete, choiceLaptop, laptop, choiceGame, userGame, numGuess, game1Result, cntGame1, iGame1, triviaGuess, game2Result, cntGame2, game3Choice, game3Result, game3pt2Result, game3Score, game3cpu, doorChoice, doorResult, compGuess, compGuessResult, compPWGuess, compPWCheck, choiceVent, ventOpenResult, choiceCompResult, choiceComp);
      } //outputs according message for any direction user chooses
      else { //user wants to check a comp
        compGuess = scanner.nextLine(); //get guess for number of comp
        compGuessResult = mg.checkGuess(compGuess);
        System.out.println(compGuessResult); //result of guess
        if (compGuessResult.equals("Sorry, that was the wrong computer. The room is currently full of methane. The intruder steps out of the storage room and sets the room on fire. Sorry, you’ve lost the game. Better luck next time...")) { //if user chose the wrong comp and method returns corresponding message
          System.exit(0); //ends game
        }
        else { //user chose correct comp
          compPWGuess = scanner.nextLine(); //get guess for comp PW
          compPWCheck = mg.compPWCheck(compPWGuess); //checks PW guess
          System.out.println(compPWCheck);
          while (compPWCheck.equals("Incorrect. Try again: ")) { //while password guess is wrong
            compPWGuess = scanner.nextLine(); //get new guess
            compPWCheck = mg.compPWCheck(compPWGuess); //checks new PW guess
            System.out.println(compPWCheck);
          } //until PW is correct
          userKey = true; //user now has key
          choiceLook = scanner.nextLine();
          direction = mg.choiceDirection(choiceLook,gamesComplete, passcode, userKey, ventOpen, compAccess);
          System.out.println(direction);
          mg.allDirections(gamesComplete, choiceLook, direction, passcode, userKey, ventOpen, compAccess, complete, choiceLaptop, laptop, choiceGame, userGame, numGuess, game1Result, cntGame1, iGame1, triviaGuess, game2Result, cntGame2, game3Choice, game3Result, game3pt2Result, game3Score, game3cpu, doorChoice, doorResult, compGuess, compGuessResult, compPWGuess, compPWCheck, choiceVent, ventOpenResult, choiceCompResult, choiceComp); //outputs according message for any direction user chooses
        }
      } 
    
    }
}
}