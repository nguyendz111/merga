import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager studentManager = new StudentManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. Add student");
            System.out.println("2. Remove student");
            System.out.println("3. Display student list");
            System.out.println("4. Find student");
            System.out.println("5. Edit student information");
            System.out.println("6. Sort students by score (Merge Sort)");
            System.out.println("7. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter student ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student score: ");
                    double score = scanner.nextDouble();
                    studentManager.addStudent(new Student(id, name, score));
                    break;
                case 2:
                    System.out.print("Enter the ID of the student to remove: ");
                    String removeId = scanner.nextLine();
                    studentManager.removeStudent(removeId);
                    break;
                case 3:
                    studentManager.displayStudents();
                    break;
                case 4:
                    System.out.print("Enter the ID of the student to find: ");
                    String findId = scanner.nextLine();
                    Student foundStudent = studentManager.findStudent(findId);
                    if (foundStudent != null) {
                        System.out.println(foundStudent);
                    } else {
                        System.out.println("Student not found with ID: " + findId);
                    }
                    break;
                case 5:
                    System.out.print("Enter the ID of the student to edit: ");
                    String editId = scanner.nextLine();
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new score: ");
                    double newScore = scanner.nextDouble();
                    studentManager.editStudent(editId, newName, newScore);
                    break;
                case 6:
                    studentManager.sortByScoreMergeSort();  // Chọn thuật toán sắp xếp Merge Sort
                    break;
                case 7:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
