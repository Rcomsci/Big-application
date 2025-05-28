import java.util.ArrayList;
import java.util.Scanner;

public class Bigproject {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> todoList = new ArrayList<>();
        ArrayList<Boolean> completed = new ArrayList<>();

        while (true) {
            System.out.println("\n--- TO-DO LIST ---");
            for (int i = 0; i < todoList.size(); i++) {
                String status = completed.get(i) ? "[X]" : "[ ]";
                System.out.println((i + 1) + ". " + status + " " + todoList.get(i));
            }
            System.out.println("\nOptions:");
            System.out.println("1. Add item");
            System.out.println("2. Check off item");
            System.out.println("3. Remove item");
            System.out.println("4. Add preset tasks for today");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = 0;
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
            } else {
                scanner.nextLine();
                System.out.println("Invalid input. Try again.");
                continue;
            }

            if (choice == 1) {
                System.out.print("Enter new to-do item: ");
                String item = scanner.nextLine();
                todoList.add(item);
                completed.add(false);

            } else if (choice == 2) {
                System.out.print("Enter item number to check off: ");
                int num = scanner.nextInt();
                scanner.nextLine(); // consume newline
                if (num >= 1 && num <= todoList.size()) {
                    completed.set(num - 1, true);
                } else {
                    System.out.println("Invalid item number.");
                }

            } else if (choice == 3) {
                System.out.print("Enter item number to remove: ");
                int num = scanner.nextInt();
                scanner.nextLine(); // consume newline
                if (num >= 1 && num <= todoList.size()) {
                    todoList.remove(num - 1);
                    completed.remove(num - 1);
                } else {
                    System.out.println("Invalid item number.");
                }

            } else if (choice == 5) {
                System.out.println("Goodbye!");
                break;

            } else if (choice == 4) {
                System.out.println("What do you want to do today?");
                System.out.println("a. Do homework");
                System.out.println("b. Clean the house");
                System.out.println("c. Prepare for a test");
                System.out.print("Choose an option (a/b/c): ");
                String answer = scanner.nextLine();

                if (answer.equals("a")) {
                    todoList.add("Math homework");
                    completed.add(false);
                    todoList.add("Science reading");
                    completed.add(false);
                    todoList.add("English essay");
                    completed.add(false);
                    System.out.println("Homework tasks added!");
                } else if (answer.equals("b")) {
                    todoList.add("Vacuum the house");
                    completed.add(false);
                    todoList.add("Do dishes");
                    completed.add(false);
                    todoList.add("Fold laundry");
                    completed.add(false);
                    System.out.println("Cleaning tasks added!");
                } else if (answer.equals("c")) {
                    todoList.add("Review notes");
                    completed.add(false);
                    todoList.add("Practice problems");
                    completed.add(false);
                    todoList.add("Make flashcards");
                    completed.add(false);
                    System.out.println("Test prep tasks added!");
                } else {
                    System.out.println("Invalid option.");
                }
            } else {
                System.out.println("Invalid option. Try again.");
            }
        }
    }
}
