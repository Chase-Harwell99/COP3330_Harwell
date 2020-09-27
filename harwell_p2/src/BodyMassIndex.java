import java.lang.Math;

public class BodyMassIndex {

    public double height;
    public double weight;

    public BodyMassIndex(double height, double weight) {

        this.height = height;
        this.weight = weight;
    }

    public double calculateBMI(double height, double weight) {

        //Calculates the BMI and then rounds to the nearest tenth
        double BMI = 703*weight/(height*height);

        int integerbmi = (int) BMI;
        double decimal = BMI - integerbmi;
        double decimalTimesTen = decimal*10;
        int integerofDecimal = (int) decimalTimesTen;


        double roundedDecimalIntValue;
        double finalBMI;
        if(decimalTimesTen-integerofDecimal >= 0.5) {
            roundedDecimalIntValue = integerofDecimal + 1;
            double roundedDecimal = roundedDecimalIntValue/10;
            finalBMI = integerbmi + roundedDecimal;
        }
        else {

            double preRoundedBMI = (int) (BMI*10);
            finalBMI = preRoundedBMI/10;
        }

        return finalBMI;
    }

    public String category(double BMI) {

        if(BMI < 18.5)
            return "Underweight";

        if(BMI >= 18.5 && BMI <= 24.9)
            return "Normal";

        if(BMI >= 25 && BMI <= 29.9)
            return "Overweight";

        if(BMI >= 30)
            return "Obesity";

        else
            return "No range";
    }

}
