import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char userInput;
        Player player1;
        Player player2;
        int totalMoves = 1;
        int x;
        int y;
        TicTacToeLogic play=new TicTacToeLogic();
        play.display();
        Map<Integer,Player> whoplays1st= new HashMap<>();
        Scanner cin = new Scanner(System.in);
        System.out.println("Is 'X' your lucky card today or '0'? Input (X/0)");
        userInput = cin.next().toLowerCase().charAt(0);
        if(userInput=='x') {
            player1 = new Player("",'x');
            player2 = new Player("",'0');
            whoplays1st.put(1,player1);
            whoplays1st.put(0,player2);
        }
        else {
            player1 = new Player("",'0');
            player2 = new Player("",'x');
            whoplays1st.put(1,player2);
            whoplays1st.put(0,player1);
        }
        System.out.println("So player " + whoplays1st.get(1).getName() + " plays 1st");
        while(true){
            System.out.println(whoplays1st.get(totalMoves%2).getName() + " to place your card enter x and y co-ordinates each entry followed by pressing enter.\nFor example to place card in 1st box type 1 then \'Enter\' then again 1 and then \'Enter\'");
            x = cin.nextInt();
            y = cin.nextInt();
            if(play.placeTheCard(whoplays1st.get(totalMoves%2),x - 1,y - 1)){
                play.display();
            }else{
                System.out.println("Cannot be placed!!! Retry ...");
                continue;
            }
            if(totalMoves > 4){
                if(play.checkIfWin()){
                    System.out.println( whoplays1st.get(totalMoves%2).getName() + " - Wins!!!");
                    break;
                }else if(totalMoves == 9){
                    System.out.println("Well played Guys.... Sadly it's a draw!!");
                    break;
                }
            }
            totalMoves++;
        }
    }
}