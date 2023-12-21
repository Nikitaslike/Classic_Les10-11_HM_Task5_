package org.example;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Student> students = new ArrayList<>();
    private static ArrayList<Course> courses = new ArrayList<>();

    public static void main(String[] args) {
        int choice = 0;
        Student student = new Student("name", "lastname", 5);
        Course course = new Course("nameC");

        do {
            System.out.print("Введіть номер операції: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Введіть ім'я: ");
                    String firstName = scanner.next();
                    System.out.print("Введіть прізвище: ");
                    String lastName = scanner.next();
                    int groupNumber = scanner.nextInt();
                    student = new Student(firstName, lastName, groupNumber);
                    students.add(student);
                    break;
                case 2:
                    students.remove(student);
                    break;
                case 3:
                    student.printInfo();
                    break;
                case 4:
                    course.printStudentsAtCourse();
                    break;
                case 5:
                    courses.add(course);
                    break;
                case 6:
                    courses.remove(course);
                    break;
                case 7:
                    System.out.println("Дякую. Гарного дня!");
                    break;
                default:
                    System.out.println("Невірний вибір. Спробуйте ще раз.");
                    break;
            }
        } while (choice != 7);
    }

    public static class Student {
        private String firstName;
        private String lastName;
        private int groupNumber;
        private ArrayList<Course> courses;

        public Student(String firstName, String lastName, int groupNumber) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.groupNumber = groupNumber;
            this.courses = new ArrayList<>();
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public int getGroupNumber() {
            return groupNumber;
        }

        public ArrayList<Course> getCourses() {
            return courses;
        }

        public void addCourse(Course course) {
            courses.add(course);
            course.addStudent(this);
        }

        public void removeCourse(Course course) {
            courses.remove(course);
            course.removeStudent(this);
        }

        public void printInfo() {
            System.out.println("Ім'я: " + getFirstName());
            System.out.println("Прізвище: " + getLastName());
            System.out.println("Номер групи: " + getGroupNumber());
            System.out.println("Курси, на які записаний студент: ");
            for (Course course : courses) {
                System.out.println(course.getNameC());
            }
        }
    }

    static class Course {
        private String nameC;
        private ArrayList<Student> students;

        public Course(String nameC) {
            this.nameC = nameC;
            this.students = new ArrayList<>();
        }

        public String getNameC() {
            return nameC;
        }

        public void addStudent(Student student) {
            students.add(student);
        }

        public void removeStudent(Student student) {
            students.remove(student);
        }

        public void printStudentsAtCourse() {
            System.out.println("Список студентів, які відвідують курс " + getNameC() + ":");
            for (Student student : students) {
                System.out.println(student.getFirstName() + " " + student.getLastName());
            }
        }
    }
}
