import java.util.ArrayList;
import java.util.Scanner;
public class Assignment4 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int choice = 5, days;
        ArrayList<Tickets> tickets = new ArrayList<Tickets>();
        do{
            System.out.println("1. Sell a Ticket for a future gam\n2. Sell a Ticket for today’s game\n3. Sell a Discount Ticket\n4. Print All Tickets\n5. Exit");
            choice = Integer.parseInt(scan.nextLine());
            switch (choice){
                case 1:
                    System.out.println("How many days until the game?");
                    days = Integer.parseInt(scan.nextLine());
                    AdvanceBooking aticket = new AdvanceBooking(days);
                    tickets.add(aticket);
                    System.out.println(aticket);
                    break;
                case 2:
                    CurrentBooking cticket = new CurrentBooking();
                    tickets.add(cticket);
                    System.out.println(cticket);
                    break;
                case 3:
                    System.out.println("How many days until the game? [0 for today]");
                    days = Integer.parseInt(scan.nextLine());
                    DiscountBooking dticket = new DiscountBooking(days);
                    tickets.add(dticket);
                    System.out.println(dticket);
                    break;
                case 4:
                    int i=0;
                    for (Tickets s : tickets) {
                        System.out.println(tickets.get(i));
                        i++;
                    }
                    break;
                case 5:
                    break;
            }
        }while (choice != 5);
    }
}
abstract class Tickets{
    protected int ticketNumber;
protected static int nextTicketNumber = 1;
private int price;
public Tickets(){
    ticketNumber = nextTicketNumber++;
}
abstract public int getPrice();
public void setPrice(int Price){
    price = Price;
}
@Override
    public String toString(){
    return "Ticket number " + ticketNumber + " with a price of $" + price;
}
}
class CurrentBooking extends Tickets{
    public CurrentBooking(){
        super();
        super.setPrice(75);
    }
    @Override
    public int getPrice() {
        return 75;
    }
    @Override
    public String toString(){
        return super.toString() + " for today's game.\n";
    }
}
class AdvanceBooking extends Tickets{
    private int days;
    public AdvanceBooking(int numDaysUntilGame){
        super();
        if (numDaysUntilGame >= 15){
            super.setPrice(25);
        }
        else{
            super.setPrice(50);
        }
        days = numDaysUntilGame;
    }
    @Override
    public int getPrice() {
        if (days >= 15){
            return 25;
        }
        else{
            return 50;
        }
    }
    @Override
    public String toString(){
        return super.toString() + " for a game in " + days + " days.\n";
    }
}
class DiscountBooking extends Tickets{
    private int days;
    public DiscountBooking(int numDaysUntilGame){
        super();
        if (numDaysUntilGame == 0){
            super.setPrice(75);
        }
        else{
            super.setPrice(10);
        }
        days = numDaysUntilGame;
    }
    @Override
    public int getPrice() {
        if (days == 0){
            return 75;
        }
        else{
            return 10;
        }
    }
    @Override
    public String toString(){
        return super.toString() + " for a game in " + days + " days.\n";
    }
}