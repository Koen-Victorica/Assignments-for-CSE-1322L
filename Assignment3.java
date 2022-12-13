import java.util.ArrayList;
import java.util.Scanner;

class Vehicle{
    private String make, model, color;
    private int current_mileage, original_cost;
    private boolean rented = false;
    public void setMake(String Make){
        make = Make;
    }
    public void setModel(String Model){
        model = Model;
    }
    public void setColor(String Color){
        color = Color;
    }
    public void setCurrent_mileage(int Current_Mileage){
        current_mileage = Current_Mileage;
    }
    public void setOriginal_cost(int Original_Cost){
        original_cost = Original_Cost;
    }
    public void setRented(boolean Rented){
        rented = Rented;
    }
    public String getMake(){
        return make;
    }
    public String getModel(){
        return model;
    }
    public String getColor(){
        return color;
    }
    public int getCurrent_mileage(){
        return current_mileage;
    }
    public int getOriginal_cost(){
        return original_cost;
    }
    public boolean getRented(){
        return rented;
    }
    public Vehicle(String Make, String Model, String Color, int Current_Mileage, int Original_Cost){
        make = Make;
        model = Model;
        color = Color;
        current_mileage = Current_Mileage;
        original_cost =  Original_Cost;
    }
    @Override
    public String toString(){
        if (rented == true)
        return "Rented: " + color + " " + make + " " + model + " with " + current_mileage + " miles";
        else
            return "Available: " + color + " " + make + " " + model + " with " + current_mileage + " miles";
    }
}
class Economy_Car extends Vehicle {
    private int daily_rental_rate;
    public Economy_Car(String Make, String Model, String Color, int Current_Mileage, int Original_Cost, int Daily_Rental_Rate) {
        super(Make, Model, Color, Current_Mileage, Original_Cost);
        daily_rental_rate = Daily_Rental_Rate;
    }
    @Override
    public String toString(){
        return "Economy Car: " + super.toString();
    }
}
class Midsize_Car extends Vehicle {
    private int daily_rental_rate;
    public Midsize_Car(String Make, String Model, String Color, int Current_Mileage, int Original_Cost, int Daily_Rental_Rate) {
        super(Make, Model, Color, Current_Mileage, Original_Cost);
        daily_rental_rate = Daily_Rental_Rate;
    }
    @Override
    public String toString(){
        return "Midsized Car: " + super.toString();
    }
}
class SUV extends Vehicle {
    private int daily_rental_rate;
    public SUV(String Make, String Model, String Color, int Current_Mileage, int Original_Cost, int Daily_Rental_Rate) {
        super(Make, Model, Color, Current_Mileage, Original_Cost);
        daily_rental_rate = Daily_Rental_Rate;
    }
    @Override
    public String toString(){
        return "SUV: " + super.toString();
    }
}
public class Assignment3 {
    public static void main(String[] args){
        int choice = 3;
        Scanner scan = new Scanner(System.in);
        ArrayList<Vehicle> cars = new ArrayList<Vehicle>();
        cars.add(new Economy_Car("Nissan", "Versa", "Blue", 105, 14500, 25));
        cars.add(new Economy_Car("Toyota", "Yaris", "White", 8422, 17500, 25));
        cars.add(new Midsize_Car("Dodge", "Avenger", "Green", 15720, 15000, 45));
        cars.add(new Midsize_Car("Ford", "Focus", "Yellow", 2368, 14500, 45));
        cars.add(new SUV("Toyota", "Rav4", "Silver", 432, 26150, 80));
        do{
            System.out.println("1. Rent cars\n2. Return cars\n3. Quit");
            choice = Integer.parseInt(scan.nextLine());
            switch (choice){
                case 1:
                    rent_cars(cars);
                    break;
                case 2:
                    return_cars(cars);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Invalid Input");
                    break;
            }
        } while (choice != 3);
    }
    public static void show_cars(ArrayList<Vehicle> Cars){
        int i = 1;
        System.out.println("0. Return");
        for (Vehicle vehicle : Cars) {
        System.out.println(i + ". " + vehicle.toString());
        i++;
        }
    }
    public static void rent_cars(ArrayList<Vehicle> Cars){
        Scanner scan = new Scanner(System.in);
        int choice = 0;
        do{
            System.out.println("Choose a car to rent:");
            show_cars(Cars);
            choice = Integer.parseInt(scan.nextLine());
            switch (choice){
                case 0:
                    break;
                case 1:
                    Cars.get(0).setRented(true);
                    break;
                case 2:
                    Cars.get(1).setRented(true);
                    break;
                case 3:
                    Cars.get(2).setRented(true);
                    break;
                case 4:
                    Cars.get(3).setRented(true);
                    break;
                case 5:
                    Cars.get(4).setRented(true);
                    break;
                default:
                    System.out.println("Invalid Input");
                    break;
            }
        } while (choice != 0);
    }
    public static void return_cars(ArrayList<Vehicle> Cars){
        Scanner scan = new Scanner(System.in);
        int choice = 0;
        do{
            System.out.println("Choose a car to return:");
            show_cars(Cars);
            choice = Integer.parseInt(scan.nextLine());
            switch (choice){
                case 0:
                    break;
                case 1:
                    Cars.get(0).setRented(false);
                    break;
                case 2:
                    Cars.get(1).setRented(false);
                    break;
                case 3:
                    Cars.get(2).setRented(false);
                    break;
                case 4:
                    Cars.get(3).setRented(false);
                    break;
                case 5:
                    Cars.get(4).setRented(false);
                    break;
                default:
                    System.out.println("Invalid Input");
                    break;
            }
        } while (choice != 0);
    }
}
