import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private List<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(String id) {
        students.removeIf(student -> student.getId().equals(id));
    }

    public void displayStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public Student findStudent(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    public void editStudent(String id, String newName, double newScore) {
        Student student = findStudent(id);
        if (student != null) {
            Student updatedStudent = new Student(id, newName, newScore);
            removeStudent(id);
            addStudent(updatedStudent);
        } else {
            System.out.println("Student not found with ID: " + id);
        }
    }

    // Sắp xếp danh sách sinh viên theo điểm (Merge Sort)
    public void sortByScoreMergeSort() {
        students = mergeSort(students);
        System.out.println("Students sorted by score (Merge Sort):");
        displayStudents();
    }

    private List<Student> mergeSort(List<Student> list) {
        if (list.size() <= 1) {
            return list;
        }
        int middle = list.size() / 2;
        List<Student> left = mergeSort(list.subList(0, middle));
        List<Student> right = mergeSort(list.subList(middle, list.size()));
        return merge(left, right);
    }

    private List<Student> merge(List<Student> left, List<Student> right) {
        List<Student> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < left.size() && j < right.size()) {
            if (left.get(i).getScore() <= right.get(j).getScore()) {
                result.add(left.get(i));
                i++;
            } else {
                result.add(right.get(j));
                j++;
            }
        }
        while (i < left.size()) {
            result.add(left.get(i));
            i++;
        }
        while (j < right.size()) {
            result.add(right.get(j));
            j++;
        }
        return result;
    }
}
