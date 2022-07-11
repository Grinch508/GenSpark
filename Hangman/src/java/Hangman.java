import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;
import java.util.Scanner;


public class Hangman {

    public static void main(String[] args){
        Head head = new Head();
        Body body = new Body();
        Legs legs = new Legs();
        Scanner sc = new Scanner(System.in);
        char guess;
        String missedLetters = "Missed letters: ";
        String getGuess = "Guess a letter.";

        ArrayList<String> wordList = new ArrayList<>();//create ArrayList
        wordList.add("apple");
        wordList.add("oranges");
        wordList.add("cat");
        wordList.add("car");
        wordList.add("add");
        wordList.add("store");
        wordList.add("five");
        wordList.add("candy");
        wordList.add("skittles");
        wordList.add("money");
        wordList.add("bank");
        wordList.add("stocks");
        wordList.add("finance");
        wordList.add("dog");
        wordList.add("cards");
        wordList.add("against");
        wordList.add("humanity");
        wordList.add("swift");
        wordList.add("java");
        wordList.add("genspark");
        wordList.add("public");
        wordList.add("speaking");
        wordList.add("four");
        wordList.add("roses");
        wordList.add("game");
        wordList.add("hangman");
        wordList.add("glade");
        wordList.add("glaze");
        wordList.add("ensure");
        wordList.add("echo");
        wordList.add("fun");

        Collections.shuffle(wordList);//shuffle wordList

        ListIterator<String>li = wordList.listIterator();//create list iterator

        //Setup
        String intro = "\n\nHANGMAN";
        String setup = "+---+\n"+
                "\t|\n"+
                "\t|\n"+
                "\t|\n"+
                "\t===";
        String word;
        String secretWord;
        String keepPlaying = "";

        while(li.hasNext()){
            word = wordList.get(li.nextIndex());
            secretWord = "_".repeat(word.length());

            //setup
            System.out.println(intro);
            System.out.println(setup);
            System.out.println(missedLetters);
            System.out.println(secretWord);
            System.out.println(getGuess);
            //get user's guess

            while(!keepPlaying.equals("no")){
                guess = sc.next().charAt(0);
                boolean wordBool = word.contains(Character.toString(guess));
                int count = 1;
                while(!wordBool){
                    if(wordBool) {
                        secretWord = secretWord.replaceAll(secretWord.substring(word.indexOf(guess)), String.valueOf(guess));

                    }else if (count == 1) {
                        System.out.println(head.head);
                        System.out.println(missedLetters + "\n" + secretWord + "\n" +  getGuess);
                        System.out.println("Wrong Try Again");

                        guess = sc.next().charAt(0);
                        count++;
                    }else if(count == 2){
                        System.out.println(body.body);
                        System.out.println(missedLetters + "\n" + secretWord + "\n" +  getGuess);
                        System.out.println("Wrong Try Again");
                        guess = sc.next().charAt(0);
                        count++;
                    }else if(count == 3){
                        System.out.println(legs.legs);
                        System.out.println(missedLetters + "\n" + secretWord + "\n" +  getGuess);
                        System.out.println("You Lose\nWould you like to play again");
                        keepPlaying = sc.nextLine();
                        if(keepPlaying.equals("no")){
                            sc.close();
                            break;
                        }
                        break;
                    }
                }
            }
        }


                /*
                //if the user is correct add the letter to its correct position in the dashed line
                while(!setupLegs.equals("|\t|\n")){
                    if(wordBool){//checks if guess is in the whole word
                        ch[secretWord.indexOf(guess)] = guess;
                    }else {//checks to see if the user was incorrect.
                        //If wrong add to the body
                        setupHead.replaceAll(setupHead.substring(1,2), "O");
                        //If user gets past the legs he loses

                    }
                    switch (i){
                        case 1:
                            setupHead.replaceAll(setupHead.substring(1,2),"O");

                        case 2:
                            setupBody.replaceAll(setupBody.substring(1,2), "|");

                        case 3:
                            setupLegs.replaceAll(setupLegs.substring(1,2), "|");
                            System.out.println("You Lose\n");
                            System.out.println("Would you like to play again?");
                            keepPlaying = sc.nextLine();
                            if(keepPlaying.equals("no")){
                                sc.close();
                                break;
                            }
                    }

                 */

    }
}
