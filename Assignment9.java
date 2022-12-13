import java.util.Scanner;
public class Assignment9 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String Title, Director;
        int choice = 0, YOR;
        float Cost;
        boolean removed;
        BlueRayCollection newCollection = new BlueRayCollection();
        do{
            System.out.println("0. Quit\n1. Add BlueRay to collection\n2. See collection\n3. Search collection\n4. Remove BlueRay from collection");
            choice = Integer.parseInt(scan.nextLine());
            switch (choice){
                case 0:
                    break;
                case 1:
                    System.out.println("What is the title?");
                    Title = scan.nextLine();
                    System.out.println("What is the director?");
                    Director = scan.nextLine();
                    System.out.println("What is the year of release?");
                    YOR = Integer.parseInt(scan.nextLine());
                    System.out.println("What is the cost?");
                    Cost = Float.parseFloat(scan.nextLine());
                    newCollection.add(Title, Director, YOR, Cost);
                    break;
                case 2:
                    newCollection.show_all();
                    break;
                case 3:
                    System.out.println("What title to search for?");
                    Title = scan.nextLine();
                    System.out.println(newCollection.Search(Title));
                    break;
                case 4:
                    System.out.println("What title to remove?");
                    Title = scan.nextLine();
                    removed = newCollection.Remove(Title);
                    if (removed == false){
                        System.out.println("Not Found");
                    }
                    else{
                        System.out.println(Title + " deleted");
                    }
                    break;
            }
        } while (choice != 0);
    }
}
class BlueRayDisk{
    public String title, director;
    public int yor;
    public float cost;
    BlueRayDisk(String Title, String Director, int YOR, float Cost){
        title = Title;
        director = Director;
        yor = YOR;
        cost = Cost;
    }
    @Override
    public String toString(){
        return "$" + cost + " " + yor + " " + title + ", " + director;
    }
}
class Node{
    public BlueRayDisk BlueRay;
    public Node next;
}
class BlueRayCollection{
    private Node first = null;
    public void add(String Title, String Director, int YOR, float Cost){
        Node newNode = new Node();
        Node current = first;
        newNode.BlueRay = new BlueRayDisk(Title, Director, YOR, Cost);
        if (current == null){
            first = newNode;
            return;
        }
        if (current.next == null){
            first.next = newNode;
            return;
        }
        while (current.next != null){
            current = current.next;
        }
        current.next = newNode;
    }
    public void show_all(){
        Node current = first;
        if (current == null){
            System.out.println("No BlueRays in Collection");
            return;
        }
        if (current != null){
            System.out.println(current.BlueRay);
        }
        while (current.next != null){
            current = current.next;
            System.out.println(current.BlueRay);
        }
    }
    public String Search(String Title){
        Node current = first;
            while (current != null){
                if (current.BlueRay.title.equals(Title)) {
                    return current.BlueRay.toString();
                }
                else {
                    current = current.next;
                }
            }
        return "Not Found";
    }
    public Boolean Remove(String Title){
        Node current = first;
        if (current == null){
            return false;
        }
        if (current != null && current.next == null){
            if (current.BlueRay.title.equals(Title)) {
                first = null;
                return true;
            }
        }
        if (current != null){
            if (current.BlueRay.title.equals(Title)) {
                first = current.next;
                return true;
            }
        }
        while (current.next != null){
            if (current.next.BlueRay.title.equals(Title)) {
                current.next = current.next.next;
                return true;
            }
            else {
                current = current.next;
            }
        }
        return false;
    }
}