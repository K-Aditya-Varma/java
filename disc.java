import java.util.Scanner;
import java.lang.Math;
class disc 
{
    public static void main(String xx[]) 
    {
        System.out.println("Enter values of a,b,c");
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();
        int c = s.nextInt();
        int D = (b*b) - (4*a*c);
        if (a==0 || b==0 ||c==0)
        {
            System.out.println("Invalid coefficients");
        }
        else if(D>0)
        {
            System.out.println("It has two distinct real roots");
            double r1 = (-b+Math.sqrt(D))/(2*a);
            double r2 = (-b-Math.sqrt(D))/(2*a);
            System.out.println("The roots are " +r1+ "and " +r2); 
        }
        else if(D==0)
        {
            System.out.println("It has one real root");
            double r1 = -b/(2*a);
            System.out.println("The root is  "+r1);
        }
        else if(D<0)
        {
            System.out.println("It has real and imaginary roots ");
            double r1 = -b/(2*a);
            double r2 = (Math.sqrt(Math.abs(D)))/(2*a);
            System.out.println("The roots are " +r1+ " and " +r2);
        }
    }
}