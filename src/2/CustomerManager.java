import java.util.HashMap;
import java.util.Scanner;

public class CustomerManager {
    private HashMap<String, Integer> customerPoints;

    public CustomerManager() {
        customerPoints = new HashMap<>();
    }

    public void addPoints(String name, int points) {
        customerPoints.put(name, customerPoints.getOrDefault(name, 0) + points);
    }

    public void displayCustomers() {
        customerPoints.forEach((name, points) -> System.out.print("(" + name + "," + points + ")"));
        System.out.println();
    }

    public static void main(String[] args) {
        CustomerManager manager = new CustomerManager();
        Scanner scanner = new Scanner(System.in);

        System.out.println("** 포인트 관리 프로그램입니다 **");
        while (true) {
            System.out.print("이름과 포인트 입력>> ");
            String input = scanner.nextLine();
            
            String[] parts = input.split(" ");
            String name = parts[0];
            int points = Integer.parseInt(parts[1]);

            manager.addPoints(name, points);
            manager.displayCustomers();
        }
    }
}
