import java.util.Scanner;
import CIE.*;
import SEE.*;

public class CalculateFinalMarks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of students:");
        int n = scanner.nextInt();

        Internals[] internalsArray = getInputForCIEStudents(scanner, n);
        External[] externalsArray = getInputForSEEStudents(scanner, n);

        int[][] finalMarks = calculateFinalMarks(internalsArray, externalsArray, n);

        displayFinalMarks(internalsArray, finalMarks, n);
    }

    private static Internals[] getInputForCIEStudents(Scanner scanner, int n) {
        Internals[] internalsArray = new Internals[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for CIE student " + (i + 1));
            System.out.print("USN: ");
            String usn = scanner.next();
            System.out.print("Name: ");
            String name = scanner.next();
            System.out.print("Semester: ");
            int sem = scanner.nextInt();
            System.out.println("Enter internal marks for 5 courses:");
            int[] internalMarks = new int[5];
            for (int j = 0; j < 5; j++) {
                System.out.print("Course " + (j + 1) + ": ");
                internalMarks[j] = scanner.nextInt();
            }
            internalsArray[i] = new Internals(usn, name, sem, internalMarks);
        }
        return internalsArray;
    }

    private static External[] getInputForSEEStudents(Scanner scanner, int n) {
        External[] externalsArray = new External[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for SEE student " + (i + 1));
            System.out.print("USN: ");
            String usn = scanner.next();
            System.out.print("Name: ");
            String name = scanner.next();
            System.out.print("Semester: ");
            int sem = scanner.nextInt();
            System.out.println("Enter SEE marks for 5 courses:");
            int[] seeMarks = new int[5];
            for (int j = 0; j < 5; j++) {
                System.out.print("Course " + (j + 1) + ": ");
                seeMarks[j] = scanner.nextInt();
            }
            externalsArray[i] = new External(usn, name, sem, seeMarks);
        }
        return externalsArray;
    }

    private static int[][] calculateFinalMarks(Internals[] internalsArray, External[] externalsArray, int n) {
        int[][] finalMarks = new int[n][5];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                finalMarks[i][j] = internalsArray[i].internalMarks[j] + externalsArray[i].seeMarks[j];
            }
        }
        return finalMarks;
    }

    private static void displayFinalMarks(Internals[] internalsArray, int[][] finalMarks, int n) {
        System.out.println("\nFinal Marks:");
        for (int i = 0; i < n; i++) {
            System.out.print("USN: " + internalsArray[i].usn + ", Name: " + internalsArray[i].name +
                    ", Semester: " + internalsArray[i].sem + ", Final Marks: ");
            for (int j = 0; j < 5; j++) {
                System.out.print(finalMarks[i][j] + " ");
            }
            System.out.println();
        }
    }
}
