
import java.util.*;

public class GuessTheNumber {
    public static void main(String[] args){
        Number number = new Number();
        String yn;
        String getGuess;
        Scanner sc = new Scanner(System.in);//Create Scanner
        System.out.println("\n\n\nHello, What's your name?");
        String getName = sc.nextLine();//Get name
        try{
            int chances = 0;
            do{
                System.out.println("\nWell " + getName + ", I am thinking of a number between 1 and 20."+
                                    "\nTake a guess.");
                        
                getGuess = sc.nextLine();
                try{
                    if(getGuess==String.valueOf(number.ans)){
                        System.out.println("Congatulations " + getName + " You Won!!!\nWould you like to play again?"+
                                            "\t[yes]\t[no]");
                    }else{
                        System.out.println("Wrong.\tTry Again");
                        chances +=1;
                    }
                }catch(Exception e){
                    System.out.println("Catch Error: Value entered was not String");
                }
            }while(chances!=6);
            System.out.println("YOU LOSE\nWould you like to play again?\t[yes]\t[no]");
            yn = sc.nextLine();
        }catch(Exception e){
            System.out.println("Catch Error: Value entered was not String");
        }finally{
            sc.close();
        }
    }
}
