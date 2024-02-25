import java.util.Scanner;
class WrongAge extends Exception {
  public WrongAge() {
    super("Invalid age! Age cannot be negative nor zero.");
  }
  public WrongAge(String message) {
    super(message);
  }
}
class Father {
  private int age;
  public Father(int age) throws WrongAge {
    if (age <= 0) {
      throw new WrongAge();
    }
    this.age = age;
  }
  public int getAge() {
    return age;
  }
}
class Son extends Father {
  private int sonAge;
  public Son(int fatherAge, int sonAge) throws WrongAge {
    super(fatherAge);
    if (sonAge >= fatherAge) {
      throw new WrongAge("Son's age should be less than Father's age.");
    }
    this.sonAge = sonAge;
  }
  public int getSonAge() {
    return sonAge;
  }
}
public class InheritanceException {
  public static void main(String[] args) {
    try {
      Scanner s1 = new Scanner(System.in);
      System.out.print("Enter Father's age: ");
      int fatherAge = s1.nextInt();
      Father f = new Father(fatherAge);
      System.out.print("Enter Son's age: ");
      int sonAge = s1.nextInt();
      Son s = new Son(f.getAge(), sonAge);
      System.out.println("Father's age: " + f.getAge());
      System.out.println("Son's age: " + s.getSonAge());
    } catch (WrongAge e) {
      System.out.println("Exception: " + e);
    } catch (Exception e) {
      System.out.println(
          "Exception: Invalid input. Please enter valid integer values.");
    }
  }
}
