package dataStructures.serveStudents;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;


public class Solution {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st/*.getName()*/);
            }
        }
    }

/* ==================================== */
static class Priorities {
        public List<Student> getStudents(List<String> events) {
            PriorityQueue<Student> queue = new PriorityQueue<Student>((s1, s2) -> {
                if (s1.getCGPA() != s2.getCGPA()) return -(s1.getCGPA() > s2.getCGPA()? 1 : -1);
                if (s1.getName() != s2.getName()) return s1.getName().compareTo(s2.getName());
                return -(s1.getId() - s2.getId());
            });

            events.forEach(event -> {
                String[] arr = event.split(" ");
                String command = arr[0];
                if (command.equals("ENTER")) {
                    Student student = new Student(Integer.parseInt(arr[3]), arr[1], Double.parseDouble(arr[2]));
                    queue.add(student);
                }
                if (command.equals("SERVED")) {
                    if (!queue.isEmpty()) queue.remove();
                }
            });


            List<Student> list = new ArrayList<>();
            while (queue.size() != 0)
            {
                list.add(queue.remove());
            }

            return list;
        }
    }

static class Student {
        private int id;
        private String name;
        private double cgpa;

        public String toString() {
            return getName() + " : " + getCGPA() + " : " + getId();
        }

        public Student(int id, String name, double cgpa) {
            super();
            this.id = id;
            this.name = name;
            this.cgpa = cgpa;
        }

        public String getName() {
            return name;
        }

        public int getId() {
            return id;
        }

        public double getCGPA() {
            return cgpa;
        }
    }
}
