import java.util.Scanner;

public class BMICalculator {

    public static double bmiCalculator(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Input weight in kilogram: ");
        double weight = sc.nextDouble();
        System.out.print("\nInput height in meters: ");
        double height = sc.nextDouble();
        double BMI = weight / (height * height);

        if (BMI<18.5)
            System.out.println("You are underweight");
        else if(18.5<=BMI && BMI<24.9)
            System.out.println("Your weight is normal");
        else if (25<BMI && BMI<29.9)
            System.out.println("You are overweight");
        else
            System.out.println("You are obese");
        return BMI;
    }

}
