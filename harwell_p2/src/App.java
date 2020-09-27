import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static double getUserHeight() {

        Scanner heightScan = new Scanner(System.in);
        System.out.println("Please enter your height in inches...");

        double height = heightScan.nextDouble();
        while(height <= 0) {
            System.out.println("Negative values are not valid. Please enter your height in inches...");
            height = heightScan.nextDouble();
        }
        heightScan.nextLine();
        return height;
    }

    public static double getUserWeight() {

        Scanner weightScan = new Scanner(System.in);
        System.out.println("Please enter your weight in pounds...");

        double weight = weightScan.nextDouble();
        while(weight < 0) {
            System.out.println("Negative values are not valid. Please enter you weight in pounds...");
            weight = weightScan.nextDouble();
        }
        weightScan.nextLine();
        return weight;
    }

    public static boolean moreInput(){

        boolean input;
        System.out.println("Would you like to calculate a new BMI? Type Y for yes and N for no...");
        Scanner answerScan = new Scanner(System.in);

        while(true) {

            String answer = answerScan.nextLine();

            if(answer.equals("Y") || answer.equals("y")) {
                input = true;
                break;
            }

            else if(answer.equals("N") || answer.equals("n")){
                input = false;
                break;
            }
            else {
                System.out.println("Please enter Y for yes or N for no.");
            }
        }

        //^^^come back to handling if the user doesn't answer with a y or n
        return input;
    }

    public static void displayBmiInfo(BodyMassIndex bmi){

        System.out.println("BMI is: " + bmi.calculateBMI(bmi.height,bmi.weight));
        System.out.println("Category: " + bmi.category(bmi.height, bmi.weight));
    }

    public static void displayBmiStatistics(ArrayList bmiData) {

        double totalBMI = 0;

        for(int i=0;i<bmiData.size();i++) {

            BodyMassIndex e = (BodyMassIndex) bmiData.get(i);
            double BMIofObject = e.calculateBMI(e.height, e.weight);
            totalBMI = totalBMI + BMIofObject;

        }

        double avgBMI = totalBMI/bmiData.size();
        double roundedBMIint = (int) (avgBMI*100);
        double roundedBMI = roundedBMIint/100;
        System.out.println("The average BMI is: "  + roundedBMI);
    }

    public static void main(String[] args) {
        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput()) {
            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);

            displayBmiInfo(bmi);
        }

        displayBmiStatistics(bmiData);
    }
}
