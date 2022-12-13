import java.util.Scanner;
public class Assignment6 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        ConnectFour game = new ConnectFour();
        int choice = 9;
        do{
            System.out.println(game);
            System.out.println("Which column would " + game.getPlayer_turn() + " like to go in (9 to quit)");
            choice = Integer.parseInt(scan.nextLine());
            if(choice == 9) break;
            else {
                try{
                    game.dropPiece(choice, game.getToken());
                    game.nextTurn();
                }
               catch (ColumnFull e) {
                   System.out.println(e);
                }
            }
        }while (choice != 9);
    }
}
class ColumnFull extends Exception{
    public ColumnFull(){}
    public ColumnFull(String message){
        super(message);
    }
}
class ConnectFour {
    private char[][] board = new char[6][7];
    private String player_turn;
    private char token;

    public ConnectFour() {
        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j <= 6; j++) {
                board[i][j] = ' ';
            }
        }
        player_turn = "Red";
        token = 'R';
    }
    public String getPlayer_turn(){
        return player_turn;
    }
    public char getToken(){
        return token;
    }
    public void nextTurn() {
        if (player_turn == "Red") {
            player_turn = "Yellow";
            token = 'Y';
        } else {
            player_turn = "Red";
            token = 'R';
        }
    }

    public int nextAvailablePosition(int column) {
        for (int i = 5; i >= 0; i--) {
            if (board[i][column] == ' ') {
                return i;
            }
        }
        return -1;
    }

    public void dropPiece(int column, char token) throws ColumnFull {
        if (nextAvailablePosition(column) != -1) {
            board[nextAvailablePosition(column)][column] = token;
        }
        else {
            throw new ColumnFull("Column " + column + " is full please try another");
        }
    }
    @Override
    public String toString() {
        String to_return="  0   1   2   3   4   5   6";
        for(int i=0;i<6;i++) {
            to_return+="\n-----------------------------\n";
            to_return+="| ";
            for(int j=0;j<7;j++) {
                to_return+=board[i][j]+" | ";
            }
        }
        to_return+="\n-----------------------------\n";
        return to_return;
    }
}