/*  Laavanya Thiagalingam
    Course Code: ICS3U0
    Assignment Title: Final Project
    Date Completed: January 17, 2022
    Program Description: An escape room game based on an intruder lockdown in a school where the user is the only student left behind in the class.
*/
import java.util.Random;
import java.util.Scanner;

public class MyGame {
  
  String [] game1Answers = new String [5]; //answers for game1
  String [][] game2Answers = new String [3][2]; //answers for game2
  String [] game3Options = new String [3]; //options for game3
  String [] game1Hints = new String [5]; //hints for game1
  String [] game2Qs = new String [3]; //qs for game2
  Random rand = new Random();
  Scanner scanner = new Scanner (System.in);
  
  int random;
  int game3Score;
  int game3cpu;
  String cpuChoice;
  boolean complete1;
  boolean gamesComplete1;
  boolean passcode1;
  boolean userKey1;
  boolean ventOpen1; 
  boolean compAccess1;
  String choiceLook1;
  int game3Score1;
  int game3cpu1; //variables to return to main
  
  public MyGame () {
  game1Answers[0] = "12";
  game1Answers[1] = "5";
  game1Answers[2] = "1";
  game1Answers[3] = "18";
  game1Answers[4] = "14"; //answers for game1
  game2Answers[0][0] = "Carbon dioxide";
  game2Answers[0][1] = "CO2";
  game2Answers[1][0] = "Carbon monoxide";
  game2Answers[1][1] = "CO"; 
  game2Answers[2][0] = "Oxygen";
  game2Answers[2][1] = "O2"; //answers for game2
  game3Options [0] = "XX";
  game3Options [1] = "XY";
  game3Options [2] = "YX"; //options for game3
  random = rand.nextInt(3); //generates random number between 0-2
  cpuChoice = game3Options[random];
  game3Score = 0;
  game3cpu = 0;
  game1Hints [0] = "It is a factor of 48. Guess the number: ";
  game1Hints [1] = "It is the number of minutes between each tick on a clock. Guess the number: ";
  game1Hints [2] = "It is the number everyone wants to be at the end of a race. Guess the number: ";
  game1Hints [3] = "It is the legal age for a person to be charged with a crime as an adult. Guess the number: ";
  game1Hints [4] = "It is a two digit number and the two digits in the number add up to 5. Guess the number: "; //hints for game1
  game2Qs [0] = "1) What compound in a fire extinguisher is used to put out a fire? ";
  game2Qs [1] = "2) What compound created in a fire kills humans?";
  game2Qs [2] = "3) What gas found in air feeds a fire? "; //questions for game2
  complete1 = false;
  gamesComplete1 = false;
  passcode1 = false;
  userKey1 = false;
  ventOpen1 = false;
  compAccess1 = false;
  game3Score1 = 0;
  game3cpu1 = 0; //initializing
  }


  public String choiceDirection (String choiceLook, boolean gamesComplete, boolean passcode, boolean userKey, boolean ventOpen, boolean compAccess) { //functional method to return message based off choice of direction
    if (choiceLook.equalsIgnoreCase("left")) { //if user chooses to look left
      if (gamesComplete == false) {  //if user has not completed games
        return "You look to your left and see a laptop open to the online meeting for your class. Would you like to interact with it? "; //run interact with laptop
      }
      else if (gamesComplete == true) { //if user has completed games
        return "Nothing left to interact with here. Choose a direction to look in, right, left, up or behind. "; //choose new direction
      }
    }
    if (choiceLook.equalsIgnoreCase("right")) { //if user chooses to look right
      if (passcode == false) { //if user does not have the passcode to door
        return "You look to your right. You find the door to a storage room, your best escape method since that room leads directly to the stairwell. Would you like to interact with the door? "; //run interact with door
      }
      if (passcode == true) { //if user has passcode to door
        return "You look to your right. You find the door to a storage room, your best escape method since that room leads directly to the stairwell. You come to realize before opening the door that the intruder is likely to be in there, but you have to have a way to protect yourself, or else you might die. Would you like to open the door? "; //run open door
      }
    }
    if (choiceLook.equalsIgnoreCase("up")) { //if user chooses to look up
      if (ventOpen == true) { //if the user has opened the vent
        return "Nothing left to interact with here. Choose a direction to look in, right, left, up or behind. "; //run choice of direction
      } 
      if (userKey == false) { //if user does not have the key to vent
        return "You look up and find a vent with a spot for a key. Would you like to interact with the vent? "; //run open vent
      }
      if (userKey == true) { //if user has the key to vent
        return "You look up and find a vent with a spot for a key. You get up onto a desk and try to open the vent, only to find that it is locked. Would you like to use your key to open the vent now? "; //run open vent
      }
    }
    if (choiceLook.equalsIgnoreCase("behind")) { //if user chooses to look left
      if (userKey == false) { //if user does not have the key to vent
        return "You turn around and find rows of computers, numbered from 1-25, all turned off. Would you like to turn one on? You could risk losing the game."; //run choice to guess computer
      }  
      if (userKey == true) { //if user has the key to vent
        return "Nothing left to interact with here. Choose a direction to look in, right, left, up or behind. "; //run choice to guess computer
      }
    }
    return "Choose a direction to look in, right, left, up or behind. "; //only prints if user chooses invalid direction
  }
//left
public String laptop (String choiceLaptop) { //functional method to interact with laptop
  if (choiceLaptop.equalsIgnoreCase("yes")) { //if user chooses to interact with laptop
    return "You walk over to the laptop “Hello there!” … You hear from the laptop where usually your classmates are logged in. You come to realize it is the intruder in the meet. The intruder says: I have a game prepared for you. If you win, I’ll give you some important information, but if I win, I’ll come into the room to meet you. Would you like to play? "; //run user plays game
    }
  else { //if user chooses not to interact with laptop
    return "Choose a direction to look in, right, left, up or behind. "; //run choice of direction
    }
  }

public String userGame1 (String choiceGame) { //functional method to play game
  if (choiceGame.equalsIgnoreCase("yes")) { //if user wants to play the game
    return "The first game I have prepared for you is to guess 5 numbers based on 5 hints. Here’s your first hint, it is a factor of 48. Guess the number: "; //start game
  }
  else { //if user does not want to play the game
    return "Choose a direction to look in, right, left, up or behind. "; //run choice of direction
   }
}

public String game1 (String numGuess, int cntGame1) { //functional method for game1
      if ((!numGuess.equals(game1Answers[(cntGame1)])) && (!numGuess.equalsIgnoreCase("quit"))) { //if user is incorrect and does not want to quit
        return ("Incorrect. Try again. If you would like to quit, type \"quit\". \n"); //message to tell user they are incorrect
      }
      else if (numGuess.equalsIgnoreCase("quit")) { //if user wants to quit
        return ("I see you :)"); //message before the game ends
      }
      else { //if the user is correct
        return ("Correct. Here’s your next hint; "); //message to show they are correct
      }
}

public String game2 (String triviaGuess, int cntGame2) { //functional method to play game2
  String answer1 = game2Answers[cntGame2][0];
  boolean isCarbonDioxide = triviaGuess.equalsIgnoreCase(answer1); //guess is the answer
  String answer2 = game2Answers[cntGame2][1];
  boolean isCO2 = triviaGuess.equalsIgnoreCase(answer2); //guess is second answer
  if (!(isCarbonDioxide || isCO2) && (!triviaGuess.equalsIgnoreCase("quit"))) { //if the user's guess is not correct and they do not want to quit
    return ("Incorrect. Try again. If you would like to quit, type \"quit\".\n"); //message to say they are incorrect
  }
  else if (triviaGuess.equalsIgnoreCase("quit")) { //if they want to quit
    return ("I see you :)"); //message before game ends
  }
  else { //user is correct
    return ("Correct.\n"); //message to say they are correct
  }
}

  public String game3 (String game3Choice) { //functional method to play game3
    if (game3Choice.equals("YX")) { //if user chooses YX
      random = rand.nextInt(3); //generate random num between 0-2
      cpuChoice = game3Options[random]; //new choice for intruder
      switch (random) { //switch using variable random
        case 0: //if random = 0 / XX
          game3Score++; //user gets 1 point
          game3Score1 = game3Score;
          return ("You win, I chose XX. YX beats XX."); //message that user wins and why
        case 1: //if random = 1 / XY
          game3cpu++; //intruder gets 1 point
          game3cpu1 = game3cpu;
          return cpuChoice; //return intruder's choice
        case 2: //if random = 2 / YX
          return "tie"; //tie
      }
    }
    if (game3Choice.equals("XX")) { //if user chooses XX
      random = rand.nextInt(3); //generate random num between 1-2
      cpuChoice = game3Options[random]; //new choice for intruder
      switch (random) { //switch using variable random
        case 0: //if random = 0 / XX
         return "tie"; //tie
        case 1: //if random = 1 / XY
           game3Score++; //user gets 1 point
           game3Score1 = game3Score;
          return ("You win, I chose XY. XX beats XY."); //message that user wins and why
        case 2: //if random = 2 / YX
          game3cpu++; //intruder gets 1 point
          game3cpu1 = game3cpu;
          return cpuChoice; //return intruder's choice
      }
    }
    if (game3Choice.equals("XY")) { //if user chooses XY
      random = rand.nextInt(3); //generate random num between 1-2
      cpuChoice = game3Options[random]; //new choice for intruder
      switch (random) { //switch using variable random
        case 0: //if random = 0 / XX
          game3cpu++; //intruder gets 1 point
          game3cpu1 = game3cpu;
          return cpuChoice; //return intruder's choice
        case 1: //if random = 1 / XY
          return "tie"; //tie
        case 2: //if random = 2 / YX
          game3Score++; //user gets 1 point
          game3Score1 = game3Score;
          return ("You win, I chose YX. XY beats YX."); //message that user wins and why
      }
    }
    return "Please enter a valid option, follow the rules of the game or else."; //message for if the user does not enter a valid option
  }

  public String game3pt2 (String game3Result, String game3Choice) { //functional method for game3 part 2
    boolean win1 = game3Result.equals("You win, I chose XX. YX beats XX.");
    boolean win2 = game3Result.equals("You win, I chose XY. XX beats XY.");
    boolean win3 = game3Result.equals("You win, I chose YX. XY beats YX."); //user wins
    boolean tie = game3Result.equals("tie"); //tie
    boolean invalid = game3Result.equals("Please enter a valid option, follow the rules of the game or else."); //invalid entry
      if ((win1 || win2 || win3) && !(tie && invalid)) { //if user wins and it is not a tie or invalid entry
        return (game3Result +  " My score is " + game3cpu + " and your score is " + game3Score + ". Onto the next round, enter your choice:"); //returns message saying they won and scores, moving onto next round
      }
      if (tie) { //if it's a tie
        return ("It's a tie. Onto the next round, enter your choice:"); //return message saying tie, moving onto next round
      }
      if (invalid) { //if user entered an invalid entry
        return (game3Result + " Enter your choice:"); //return message saying invalid entry, moving onto next round
      }
      if (!(win1 || win2 || win3)) { //if user does not win and intruder does
        return ("I win, " + game3Result + " beats " + game3Choice + "  My score is " + game3cpu + " and your score is " + game3Score + ". Onto the next round, enter your choice:"); //returns message saying intruder won and scores, moving onto next round
      }
      else { //none of the above
        return ""; //methods used in the wrong order
      }
  }
  
public void resetGame3 () { //procedural method to reset game3 scores
  game3Score = 0;
  game3cpu = 0;
  game3Score1 = 0;
  game3cpu1 = 0; //resets scores in main and object class to 0
}

//right
public String door (String doorChoice) { //functional method to interact with door
  if (doorChoice.equalsIgnoreCase("yes")) { //if user chooses to interact with door
    return "You walk over to the door and try to turn the handle. The door is locked with a keypad lock and you don’t know the password to open it.\nChoose a direction to look in, right, left, up or behind. "; //message when they have no code and try to interact door
  }
  else { //user does not want to interact with door
    return "Choose a direction to look in, right, left, up or behind. "; //run choice of direction
  }
}

public String openDoor (String doorChoice) { //functional method when user can open door
  if (doorChoice.equalsIgnoreCase("yes")) { //if user wants to open door
    return "";
  }
  else { //user does not want to open door
    return "Choose a direction to look in, right, left, up or behind. "; //run choice of direction
  }
}

//up
public String openVent (String choiceVent, boolean userKey) { //functional method to interact with vent
  if (choiceVent.equalsIgnoreCase("yes") && userKey == true) { //if user wants to interact with vent and has key
    userKey = true; //they have the key
    userKey1 = userKey;
    return "You insert the key into the spot left for it, slowly turning. The vent door falls and reveals, what seems to be, emergency supplies. Using this bat, fire proximity suit and gas mask, you can defend yourself against the intruder. Choose a direction to look in, right, left, up or behind. "; //message once they open the vent
  }
  else if (choiceVent.equalsIgnoreCase("yes") && userKey == false) { //if user wants to open vent but does not have key
    return "You get up onto a desk and try to open the vent, only to find that it is locked. Choose a direction to look in, right, left, up or behind. "; //message when they cannot open vent
  }
  else { //user does not want to open vent
    return "Choose a direction to look in, right, left, up or behind. "; //run choice of direction
  }
}

//behind 
public String choiceComp (String choiceComp) { //functional method to interact with computer
  if (choiceComp.equalsIgnoreCase("yes")) { //if user wants to interact with comp
    return "The computer turns on and directs you straight to the online meet that used to have all your classmates in it. Suddenly, you look around and find that all the computers have turned on, doing the same thing. With this, the intruder suddenly starts speaking through all the computers collectively. The intruder begins to say: “Hello there! The only way to defeat me is to find the computer with a key’s location, but you can only check one computer, or else I’ll come out of hiding :) If you choose the computer number incorrectly you may or may not die, depending on my mood. You think to yourself, did the intruder give me a significant number that might help me here? Which computer would you like to check from 1-25? "; //message once a computer is turned on
  }
  else { //user does not want to interact with comp
    return "Choose a direction to look in, right, left, up or behind. "; //run choice of direction
  }
}

public String checkGuess (String compGuess) { //functional method when user guesses comp number
  if (compGuess.equals("7")) { //if user guesses 7
    return "You walk up to the computer with a sticky note that says 7 on it. You turn it on, it asks for a passcode to unlock it. You think to yourself again, was there a significant word the intruder gave me? Enter the passcode. "; //message that says they have chosen the correct comp
  }
  else { //if user chooses any other number
    return "Sorry, that was the wrong computer. The room is currently full of methane. The intruder steps out of the storage room and sets the room on fire. Sorry, you’ve lost the game. Better luck next time..."; //message that says they have lost the game
  }
}

public String compPWCheck (String compPWGuess) { //functional method to check user comp password guess
  if (compPWGuess.equalsIgnoreCase("learn")) { //if their guess is correct
    return "The computer unlocks! It displays a message, it says:\nThe key is located at the back of the monitor. Using this, open the vent.\nYou reach behind the monitor and find the key, hurrah! Suddenly, all the computers turn off.\nChoose a direction to look in, right, left, up or behind. "; //message displayed once computer is unlocked
  }
  else { //user password guess is incorrect
    return "Incorrect. Try again: "; //message to say guess was incorrect, try again
  }
}

public void left (boolean gamesComplete, String choiceLook, String direction, boolean passcode, boolean userKey, boolean ventOpen, boolean compAccess, String choiceLaptop, String laptop, String choiceGame, String userGame, String numGuess, String game1Result, int cntGame1, int iGame1, String triviaGuess, String game2Result, int cntGame2, String game3Choice, String game3Result, String game3pt2Result, int game3Score, int game3cpu) { //procedural method to look left
    if ((gamesComplete == false) && (choiceLook.equalsIgnoreCase("left"))) { //if games have not been completed and user chooses to look left
      choiceLaptop = scanner.nextLine(); //stores if user wants to interact with laptop
      choiceLook = "";
      laptop = laptop(choiceLaptop); //returns message according to response
      System.out.println (laptop); //outputs message accordingly 
      direction = laptop;
    }
    if ((choiceLaptop.equalsIgnoreCase("yes")) && (choiceLook.equalsIgnoreCase(""))) { //if user wants to interact with laptop and last if has been run so choiceLook is ""
      choiceGame = scanner.nextLine(); //user choice to play
      choiceLook = "left"; 
      userGame = userGame1(choiceGame); //returns message according to response
      System.out.println (userGame);
      direction = userGame;
    }
    //game1
    if (choiceGame.equalsIgnoreCase("yes") && (choiceLook.equalsIgnoreCase("left"))) { //if user wants to play and they want to look left
      numGuess = scanner.nextLine(); //store game1 guess
      game1Result = game1(numGuess, iGame1); //returns if guess is right or not
       while (game1Result.equals("Incorrect. Try again. If you would like to quit, type \"quit\". \n")) { //while guess is wrong
          System.out.println(game1Result + game1Hints[cntGame1]); 
          numGuess = scanner.nextLine();
          game1Result = game1(numGuess, iGame1); //output result, repeat q and check if new guess is right
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
            game1Result = game1(numGuess, iGame1);
          } //outputs message + next q
        }
        else if (game1Result.equals("Incorrect. Try again. If you would like to quit, type \"quit\". \n")) { //if user guess is incorrect
          System.out.println(game1Result + game1Hints[cntGame1]);
          numGuess = scanner.nextLine();
          game1Result = game1(numGuess, iGame1);
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
    game2Result = game2(triviaGuess, cntGame2); //checks user guess for trivia
       while (game2Result.equals("Incorrect. Try again. If you would like to quit, type \"quit\".\n")) { //while user guess is wrong
          System.out.println(game2Result + game2Qs[cntGame2]); //output result and repeats q
          triviaGuess = scanner.nextLine(); //get new guess
          game2Result = game2(triviaGuess, cntGame2); //check new guess
        if (game2Result.equals("I see you :)")) { //if user quits
          System.out.println(game2Result);
          System.exit(0); //end game
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
            game2Result = game2(triviaGuess, cntGame2);
          } //outputs result, next q, and checks new guess
        }
        else if (game2Result.equals("Incorrect. Try again. If you would like to quit, type \"quit\".\n")) { //if user guess is wrong
          System.out.println(game2Result + game2Qs[cntGame2]);
          triviaGuess = scanner.nextLine();
          game2Result = game2(triviaGuess, cntGame2);
        } //outputs result, repeats q, and checks new guess
        else if (game2Result.equals("I see you :)")) { //if user wants to quit
          System.out.println(game2Result);
          System.exit(0); //ends game
        }
      }
    game3Choice = scanner.nextLine();
    game3Result = game3(game3Choice); //determines if user wants to play
    game3pt2Result = game3pt2 (game3Result, game3Choice);
    while (game3cpu < 3 && game3Score < 3) { //while neither intruder or user has won with 3 points
      System.out.println(game3pt2Result);
      game3Choice = scanner.nextLine();
      game3Result = game3(game3Choice); //check who wins
      game3Score = game3Score1;
      game3cpu = game3cpu1; //return value from main to object class
      game3pt2Result = game3pt2 (game3Result, game3Choice); //outputs result of round
    }
    while (game3cpu == 3) { //while comp wins, restart game
      System.out.println("I win the game :)\nLet's play again with the scores reset. Enter your choice:");
      resetGame3(); //method to reset scores
      game3Score = game3Score1;
      game3cpu = game3cpu1;
      while (game3cpu < 3 && game3Score < 3) { //while no one has won yet
        game3Choice = scanner.nextLine();
        game3Result = game3(game3Choice); //checks if user wins
        game3Score = game3Score1;
        game3cpu = game3cpu1; //update scores
        game3pt2Result = game3pt2(game3Result, game3Choice); //if user loses, says that, if they win, says that 
        if (game3cpu1 == 3 || game3Score1 == 3) { //if either intruder or user wins
          game3pt2Result = game3pt2Result.substring(0, game3pt2Result.length() - 39); //slices off 
          System.out.println(game3pt2Result);
        }
        else { //no one has won yet
          System.out.println(game3pt2Result);
        }
      } //outputs result for each q
    }
    if (game3Score1 == 3) { //if user wins
      gamesComplete = true; //games are done
      gamesComplete1 = gamesComplete;
      passcode = true; //user has passcode
      passcode1 = passcode;
      compAccess = true; //they have access to the computers
      compAccess1 = compAccess;
      System.out.println("Your score is 3, you win.\nI believe you’ve earned the passcode to open the door, the passcode is “invasive”. Proceed with caution though :)))\nYou find that all the computers suddenly shut down. Choose a direction to look in, right, left, up or behind. "); //run choice of direction
    }
    }
}

public void right (boolean passcode, String choiceLook, String doorChoice, String doorResult, String direction, boolean gamesComplete, boolean userKey, boolean ventOpen, boolean compAccess, boolean complete) { //procedural method to look right
    if (passcode == false && (choiceLook.equalsIgnoreCase("right"))) { //if user does not have code to door and chooses to look right
       doorChoice = scanner.nextLine();
       doorResult = door(doorChoice);
       System.out.println(doorResult); //output if user can open door
       }
    if (passcode == true && (choiceLook.equalsIgnoreCase("right"))) { //if user has passcode and wants to look right
       doorChoice = scanner.nextLine(); //choice to open door
       doorResult = openDoor(doorChoice);
       System.out.println(doorResult); //result of interaction
    if ((doorChoice.equalsIgnoreCase("yes")) && complete == false) { //if user chooses to open the door and they have not completed the game
       System.out.println("The room is currently full of methane.");
       for (int cnt = 3; cnt>0; cnt--) { //countdown for loss that decreses by 1 from 3 each time
        System.out.println(cnt); //prints cnt
       }
       System.out.println("The intruder steps out of the storage room and sets the room on fire. Sorry, you’ve lost the game. Better luck next time…"); //message for loss
       System.exit(0); //ends game
       }
       if ((doorChoice.equalsIgnoreCase("yes")) && complete == true) { //if user chooses to open door and has completed the game
        System.out.print("What is the code to the door? "); //asks for code to door
        String doorCode = scanner.nextLine(); //gets passcode
        while (!doorCode.equalsIgnoreCase("invasive")) { //while code is not correct
          System.out.println("Try again. Enter the code: ");
          doorCode = scanner.nextLine(); //gets new passcode guess
        }
        System.out.println("You slowly enter the passcode, you hear a beep and see the door swing open. A tall figure is sitting in a chair behind a dual monitor computer, open to the meet you were just using. You soon realize it’s your teacher. What are they doing here? You have successfully found the intruder, you knock them out with your bat and are protected against any possible fires with your gas mask and fire proximity suit. You successfully exit the building and find help for your other classmates. You have completed the game. Congratulations and thank you for participating!"); //outputs message for win
        System.exit(0); //ends game
       }
       }
}

public void up (boolean ventOpen, String choiceLook, String direction, boolean gamesComplete, boolean passcode, boolean userKey, boolean compAccess, String choiceVent, String ventOpenResult, boolean complete) { //procedural method to look up
  if ((ventOpen == false) && (choiceLook.equalsIgnoreCase("up"))) { //if user has not opened vent and chooses to look up
      choiceVent = scanner.nextLine(); //get choice to open vent
      ventOpenResult = openVent(choiceVent, userKey);
      System.out.println(ventOpenResult); //result of user's choice to open vent
      if (choiceVent.equalsIgnoreCase("yes") && userKey == true) { //if user chooses to open vent and has key to do so
        complete = true; //everything complete to escape
        complete1 = true;
        ventOpen = true; //vent has been opened
        ventOpen1 = ventOpen;
      }
    }
}

public void behind (String choiceLook, String choiceComp, String choiceCompResult, String direction, boolean gamesComplete, boolean passcode, boolean userKey, boolean ventOpen, boolean compAccess, String compGuess, String compGuessResult, String compPWGuess, String compPWCheck) { //procedural method to look behind
  if (choiceLook.equalsIgnoreCase("behind") && userKey == false) { //if user chooses to look behind and does not have key
      choiceComp = scanner.nextLine(); //get choice to turn on comp
      choiceCompResult = choiceComp(choiceComp);
      System.out.println(choiceCompResult); //result of user's choice to turn on computer
      if (!choiceCompResult.equals("Choose a direction to look in, right, left, up or behind. ")) { //if user chooses to turn on computer
        compGuess = scanner.nextLine(); //get guess for number of comp
        compGuessResult = checkGuess(compGuess);
        System.out.println(compGuessResult); //result of guess
        if (compGuessResult.equals("Sorry, that was the wrong computer. The room is currently full of methane. The intruder steps out of the storage room and sets the room on fire. Sorry, you’ve lost the game. Better luck next time...")) { //if user chose the wrong comp and method returns corresponding message
          System.exit(0); //ends game
        }
        else { //user chose correct comp
          compPWGuess = scanner.nextLine(); //get guess for comp PW
          compPWCheck = compPWCheck(compPWGuess); //checks PW guess
          System.out.println(compPWCheck);
          while (compPWCheck.equals("Incorrect. Try again: ")) { //while password guess is wrong
            compPWGuess = scanner.nextLine(); //get new guess
            compPWCheck = compPWCheck(compPWGuess); //checks new PW guess
            System.out.println(compPWCheck);
          } //until PW is correct
          userKey = true; //user now has key
        }
      }
    }
    gamesComplete1 = gamesComplete;
    userKey1 = userKey;
    passcode1 = passcode; //updates variables in object class
}

public String gamesCompleted () { //functional method for once games are completed
  return "Your score is 3, you win.\nI believe you’ve earned the passcode to open the door, the passcode is “invasive”. Proceed with caution though :)))\nYou find that all the computers suddenly shut down. Choose a direction to look in, right, left, up or behind. "; //returns message for when games are completed
}

public void allDirections (boolean gamesComplete, String choiceLook, String direction, boolean passcode, boolean userKey, boolean ventOpen, boolean compAccess, boolean complete, String choiceLaptop, String laptop, String choiceGame, String userGame, String numGuess, String game1Result, int cntGame1, int iGame1, String triviaGuess, String game2Result, int cntGame2, String game3Choice, String game3Result, String game3pt2Result, int game3Score, int game3cpu, String doorChoice, String doorResult, String compGuess, String compGuessResult, String compPWGuess, String compPWCheck, String choiceVent, String ventOpenResult, String choiceCompResult, String choiceComp) { //procedural method that supports all possible choices of direction
  boolean lookRight = choiceLook.equalsIgnoreCase("right");
  boolean lookLeft = choiceLook.equalsIgnoreCase("left");
  boolean lookUp = choiceLook.equalsIgnoreCase("up");
  boolean lookBehind = choiceLook.equalsIgnoreCase("behind");
  boolean ventOpened = direction.equals("Nothing left to interact with here. Choose a direction to look in, right, left, up or behind. ");
  boolean ventUnlock = direction.equals("You insert the key into the spot left for it, slowly turning. The vent door falls and reveals, what seems to be, emergency supplies. Using this bat, fire proximity suit and gas mask, you can defend yourself against the intruder. Choose a direction to look in, right, left, up or behind. ");
  boolean doorLock = direction.equals("You walk over to the door and try to turn the handle. The door is locked with a keypad lock and you don’t know the password to open it.\nChoose a direction to look in, right, left, up or behind. ");
  boolean ventCantOpen = direction.equals("You get up onto a desk and try to open the vent, only to find that it is locked. Choose a direction to look in, right, left, up or behind. ");
  boolean compDone = direction.equals("The computer unlocks! It displays a message, it says:\nThe key is located at the back of the monitor. Using this, open the vent.\nYou reach behind the monitor and find the key, hurrah! Suddenly, all the computers turn off.\nChoose a direction to look in, right, left, up or behind. ");
  boolean game3Done = direction.equals("Your score is 3, you win.\nI believe you’ve earned the passcode to open the door, the passcode is “invasive”. Proceed with caution though :)))\nYou find that all the computers suddenly shut down. Choose a direction to look in, right, left, up or behind. ");
  boolean invalidEntry = direction.equals("Choose a direction to look in, right, left, up or behind. "); //possible messages that ask to choose new direction
  while (ventOpened || invalidEntry || ventCantOpen || doorLock || ventUnlock || compDone || game3Done) { //while user is asked to choose direction to look in
    choiceLook = scanner.nextLine(); //gets new direction
    direction = choiceDirection(choiceLook,gamesComplete, passcode, userKey, ventOpen, compAccess);
    System.out.println(direction); //outputs appropriate message
    while (direction.equals("Nothing left to interact with here. Choose a direction to look in, right, left, up or behind. ")) { //while asked to choose new direction again
      choiceLook = scanner.nextLine(); //gets new direction
      direction = choiceDirection(choiceLook,gamesComplete, passcode, userKey, ventOpen, compAccess);
      System.out.println(direction); //outputs appropriate message
    }
    if (choiceLook.equalsIgnoreCase("left")) { //if user chooses to look left
      left(gamesComplete, choiceLook, direction, passcode, userKey, ventOpen, compAccess, choiceLaptop, laptop, choiceGame, userGame, numGuess, game1Result, cntGame1, iGame1, triviaGuess, game2Result, cntGame2, game3Choice, game3Result, game3pt2Result, game3Score, game3cpu); //runs method for when user looks left
    }
    if (choiceLook.equalsIgnoreCase("right")) { //if user chooses to look right
      right(passcode, choiceLook, doorChoice, doorResult, direction, gamesComplete, userKey, ventOpen, compAccess, complete); //runs method for when user looks right
    }
    if (choiceLook.equalsIgnoreCase("up")) { //if user chooses to look up
      up(ventOpen, choiceLook, direction,  gamesComplete, passcode, userKey, compAccess, choiceVent, ventOpenResult,  complete); //runs method for when user looks up
    }
    if (choiceLook.equalsIgnoreCase("behind")) { //if user chooses to look behind
      behind(choiceLook, choiceComp, choiceCompResult, direction, gamesComplete, passcode, userKey, ventOpen, compAccess, compGuess, compGuessResult, compPWGuess, compPWCheck); //runs method for when user looks behind
    }
    if (!lookRight && !lookLeft && !lookUp && !lookBehind) { //if user does not look in a valid direction
    System.out.println(direction); //asked to choose direction again
    }
    if (complete == false) { //if game is not completed yet
      complete = complete(); //update variable to match status of object class and main
    }
    if (gamesComplete == false) { //if games are not completed yet
      gamesComplete = gamesComplete(); //update variable to match status of object class and main
    }
    if (passcode == false) { //if user does not have passcode yet
      passcode = passcode(); //update variable to match status of object class and main
    }
    if (userKey == false) { //if user does not have key yet
      userKey = userKey(); //update variable to match status of object class and main
    }
    if (compAccess == false) { //if user does not have access to computers yet
      compAccess = compAccess(); //update variable to match status of object class and main
    }
    if (ventOpen == false) { //if vent is not open yet
      ventOpen = ventOpen(); //update variable to match status of object class and main
    }
  }
}

public boolean complete () { //method to return copy of complete variable
  return complete1; //returns copy
}
public boolean gamesComplete () { //method to return copy of gamesComplete variable
  return gamesComplete1; //returns copy
}
public boolean passcode () { //method to return copy of passcode variable
  return passcode1; //returns copy
}
public boolean userKey () { //method to return copy of userKey variable
  return userKey1; //returns copy
}
public boolean ventOpen () { //method to return copy of ventOpen variable
  return ventOpen1; //returns copy
}
public boolean compAccess () { //method to return copy of compAccess variable
  return compAccess1; //returns copy
}
}