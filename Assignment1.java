import java.util.Scanner;
public class Assignment1 {
    static class Coins {
        private int quantityOnHand;
        private float denomination, weight;

        public Coins(float Denomination, float Weight) {
            quantityOnHand = 0;
            denomination = Denomination;
            weight = Weight;
        }

        public float getTotalWeight() {
            return weight * quantityOnHand;
        }

        public float getTotalValue() {
            return denomination * quantityOnHand;
        }

        public void increaseQuantity(int quantity) {
            quantityOnHand += quantity;
        }

        public void decreaseQuantity(int quantity) {
            if ((quantityOnHand - quantity) >= 0) {
                quantityOnHand -= quantity;
            } else quantityOnHand = 0;
        }

        public int getQuantityOnHand() {
            return quantityOnHand;
        }

        public String printPretty(float amount) {
            return ("$" + String.format("%4.2f", amount));
        }

        @Override
        public String toString() {
            return printPretty(getTotalValue()) + " in $" + denomination + " coins";
        }
    }
        static class Notes{
            private int quantityOnHand, denomination;
            public Notes(int Denomination){
                quantityOnHand = 0;
                denomination = Denomination;
            }
            public float getTotalValue() {
                return denomination * quantityOnHand;
            }
            public void increaseQuantity(int quantity) {
                quantityOnHand += quantity;
            }
            public void decreaseQuantity(int quantity) {
                if ((quantityOnHand - quantity) >= 0) {
                    quantityOnHand -= quantity;
                } else quantityOnHand = 0;
            }
            public int getQuantityOnHand() {
                return quantityOnHand;
            }
            public String printPretty(float amount) {
                return ("$" + String.format("%4.2f", amount));
            }

            @Override
            public String toString() {
                return printPretty(getTotalValue()) + " in $" + denomination + " coins";
            }
        }
        public static void main(String[] args) {
        float totalMoney, totalWeight, amount_needed;
        Scanner scan = new Scanner(System.in);
            Notes twenties=new Notes(20);
            Notes tens=new Notes(10);
            Notes fives=new Notes(5);
            Notes ones=new Notes(1);
            Coins quarters=new Coins(0.25f,0.2f);
            Coins dimes=new Coins(0.10f,0.08f);
            Coins nickels=new Coins(0.05f,0.176f);
            Coins pennies=new Coins(0.01f,0.088f);
            dimes.increaseQuantity(41);
            nickels.increaseQuantity(17);
            pennies.increaseQuantity(132);
            ones.increaseQuantity(33);
            fives.increaseQuantity(12);
            tens.increaseQuantity(2);
            twenties.increaseQuantity(5);
            System.out.println(twenties);
            System.out.println(tens);
            System.out.println(fives);
            System.out.println(ones);
            System.out.println(quarters);
            System.out.println(dimes);
            System.out.println(nickels);
            System.out.println(pennies);
            totalMoney = twenties.getTotalValue() + tens.getTotalValue() + fives.getTotalValue() + ones.getTotalValue() + quarters.getTotalValue() + dimes.getTotalValue() + nickels.getTotalValue() + pennies.getTotalValue();
            totalWeight = quarters.getTotalWeight() + dimes.getTotalWeight() + nickels.getTotalWeight() + pennies.getTotalWeight();
            System.out.println("Total Money is $%.2f total weight is %.3foz".formatted(totalMoney, totalWeight));
            System.out.println("How much money do you need?");
            amount_needed = Float.parseFloat(scan.nextLine());
            while (amount_needed > 20 && twenties.getTotalValue() >= 20){
                twenties.decreaseQuantity(1);
                amount_needed -= 20;
                System.out.println("Give them a $20 note");
            }
            while (amount_needed > 10 && tens.getTotalValue() >= 10){
                tens.decreaseQuantity(1);
                amount_needed -= 10;
                System.out.println("Give them a $10 note");
            }
            while (amount_needed > 5 && fives.getTotalValue() >= 5){
                fives.decreaseQuantity(1);
                amount_needed -= 5;
                System.out.println("Give them a $5 note");
            }
            while (amount_needed > 1 && ones.getTotalValue() >= 1){
                ones.decreaseQuantity(1);
                amount_needed -= 1;
                System.out.println("Give them a $1 note");
            }
            while (amount_needed >= .25 && quarters.getTotalValue() >= .25){
                quarters.decreaseQuantity(1);
                amount_needed -= .25;
                System.out.println("Give them a quarter");
            }
            while (amount_needed >= .1 && dimes.getTotalValue() >= .1){
                dimes.decreaseQuantity(1);
                amount_needed -= .1;
                System.out.println("Give them a dime");
            }
            while (amount_needed >= .05 && nickels.getTotalValue() >= .05){
                nickels.decreaseQuantity(1);
                amount_needed -= .05;
                System.out.println("Give them a nickel");
            }
            while (amount_needed >= .01 && pennies.getTotalValue() >= .01){
                pennies.decreaseQuantity(1);
                amount_needed -= .01;
                System.out.println("Give them a penny");
            }
            totalMoney = twenties.getTotalValue() + tens.getTotalValue() + fives.getTotalValue() + ones.getTotalValue() + quarters.getTotalValue() + dimes.getTotalValue() + nickels.getTotalValue() + pennies.getTotalValue();
            totalWeight = quarters.getTotalWeight() + dimes.getTotalWeight() + nickels.getTotalWeight() + pennies.getTotalWeight();
            if (amount_needed >= .01){
                System.out.println("I don't have enough money. I still owe you $%.2f".formatted(amount_needed));
            }
            System.out.println("I have $%.2f left, it's total weight is %.3foz".formatted(totalMoney, totalWeight));
        }
    }
