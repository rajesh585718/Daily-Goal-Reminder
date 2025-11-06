import java.util.ArrayList;
import java.util.Scanner;

// Class representing a single goal
class DailyGoal {
    String title;
    String time;

    DailyGoal(String title, String time) {
        this.title = title;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Goal: " + title + " | Time: " + time;
    }
}

// Main class
public class DailyGoalReminder {
    static ArrayList<DailyGoal> goals = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        System.out.println("=====================================");
        System.out.println("     🗓️ DAILY GOAL REMINDER TASK");
        System.out.println("=====================================");

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add Goal");
            System.out.println("2. View Goals");
            System.out.println("3. Delete Goal");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addGoal(sc);
                case 2 -> viewGoals();
                case 3 -> deleteGoal(sc);
                case 4 -> System.out.println("👋 Exiting... Stay productive!");
                default -> System.out.println("❌ Invalid choice, please try again!");
            }
        } while (choice != 4);
    }

    // Method to add a new goal
    static void addGoal(Scanner sc) {
        System.out.print("Enter goal title: ");
        String title = sc.nextLine();
        System.out.print("Enter reminder time (e.g., 7:00 PM): ");
        String time = sc.nextLine();

        goals.add(new DailyGoal(title, time));
        System.out.println("✅ Goal added successfully!");
    }

    // Method to view all goals
    static void viewGoals() {
        if (goals.isEmpty()) {
            System.out.println("📭 No goals added yet!");
        } else {
            System.out.println("\nToday's Goals:");
            System.out.println("-------------------------------------");
            for (int i = 0; i < goals.size(); i++) {
                System.out.println((i + 1) + ". " + goals.get(i));
            }
            System.out.println("-------------------------------------");
        }
    }

    // Method to delete a goal
    static void deleteGoal(Scanner sc) {
        viewGoals();
        if (!goals.isEmpty()) {
            System.out.print("Enter goal number to delete: ");
            int index = sc.nextInt();
            if (index > 0 && index <= goals.size()) {
                goals.remove(index - 1);
                System.out.println("🗑️ Goal deleted successfully!");
            } else {
                System.out.println("❌ Invalid goal number!");
            }
        }
    }
}
