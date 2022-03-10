package week1.day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Student {
    private String name;
    private int id;
    private String subject;

    double percentage;

    public Student(String name, int id, String subject, double percentage) {
        this.name = name;
        this.id = id;
        this.subject = subject;
        this.percentage = percentage;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public double getPercentage() {
        return percentage;
    }

    @Override
    public String toString() {
        return name + "-" + id + "-" + subject + "-" + percentage;
    }
}

public class StudentStatisticsDriver {
    public static void main(String[] args) {
        Student student1 = new Student("Dinesh", 1, "Algorithms", 75);
        Student student2 = new Student("Arnav", 2, "Automata", 55);
        Student student3 = new Student("Anamika", 3, "Databases", 80);
        Student student4 = new Student("Vishal", 4, "Networking", 40);
        Student student5 = new Student("Deepak", 5, "Databases", 46);

        List<Student> studentList = Arrays.asList(student1,student2,student3,student4,student5);

        List<Student> above60Students = new ArrayList<>();
        List<Student> below60Students = new ArrayList<>();
        for (Student student : studentList) {
            if(student.getPercentage()>60)
                above60Students.add(student);
            
            else
                below60Students.add(student);
        }

        System.out.println("Above 60:"+above60Students);
        System.out.println("Below or equals to 60:"+below60Students);
        
        
        System.out.println();
        Collections.sort(studentList, (o1, o2) -> (int)(o2.getPercentage()-o1.getPercentage()));
        for (int i = 0; i < 3; i++) {
            System.out.println(studentList.get(i));
        }

        System.out.println();
        //Get the name and percentage of each student.
        for (Student student : studentList) {
            System.out.println("Name:"+student.getName()+" Percentage:"+student.getPercentage());
        }

        System.out.println();
        //Get the set of subjects offered in the college
        Set<String> subjectsOffered = new HashSet<>();
        for (Student student : studentList) {
            subjectsOffered.add(student.getSubject().toLowerCase());
        }
        System.out.println(subjectsOffered);



        System.out.println();
        //Get the highest, the lowest, and the average percentage of students
        double highestPercentage=0.0;
        double lowestPercentage=100.0;
        double total=0;
        int noOfPer=0;
        for (Student student : studentList) {
            double per = student.getPercentage();
            total+= per;
            noOfPer++;
            if(per>highestPercentage)highestPercentage=per;
            if(per<lowestPercentage)lowestPercentage=per;
        }
        System.out.println("Highest:"+highestPercentage+" Lowest:"+lowestPercentage+" Avg:"+(total/noOfPer));

        System.out.println();
        System.out.println("Total No of student:"+studentList.size());

        System.out.println();
        studentList.stream().collect(Collectors.groupingBy(Student::getSubject))
                .forEach((sub, list) -> System.out.println(sub + " = " + list));

    }
}
