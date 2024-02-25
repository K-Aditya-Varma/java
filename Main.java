import java.util.Scanner;

class Student 
{
    String usn;
    String name;
    int credits[];
    int marks[];
    int n;
    void acc() 
    {
        Scanner s1 = new Scanner(System.in);
        System.out.print("Enter USN: ");
        usn = s1.nextLine();
        System.out.print("Enter Name: ");
        name = s1.nextLine();
        System.out.println("Enter the number of subjects : ");
        n = s1.nextInt();
        credits = new int[n];
        marks = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter credits for subject " + (i + 1) + ": ");
            credits[i] = s1.nextInt();
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            marks[i] = s1.nextInt();
        }
    }
    void disp() 
    {
        System.out.println("USN: " + usn);
        System.out.println("Name: " + name);
        System.out.println("Credits:");
        for (int i = 0; i < n; i++) 
        {
            System.out.println("  Subject " + (i + 1) + ": " + credits[i]);
        }
        System.out.println("Marks:");
        for (int i = 0; i < n; i++) 
        {
            System.out.println("  Subject " + (i + 1) + ": " + marks[i]);
        }
    }
    double sgpa() 
    {
        int totalCredits = 0;
        double weightedSum = 0;

        for (int i = 0; i < n; i++) 
        {
            totalCredits += credits[i];
            weightedSum += calculateGradePoint(marks[i]) * credits[i];
        }
        return weightedSum / totalCredits;
    }
    double calculateGradePoint(int marks)
    {
        if (marks >= 90) return 10.0;
        else if (marks >= 80) return 9.0;
        else if (marks >= 70) return 8.0;
        else if (marks >= 60) return 7.0;
        else if (marks >= 50) return 6.0;
        else return 0.0;
    }
}
class Main 
{
    public static void main(String[] args) 
    {
        Student s = new Student();
        s.acc();
        System.out.println("\nStudent Details:");
        s.disp();
        double sgpa = s.sgpa();
        System.out.println("\nSGPA: " + sgpa);
    }
}