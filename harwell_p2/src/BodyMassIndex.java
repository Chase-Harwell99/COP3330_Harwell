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

        int BMIasInt = (int) BMI;
        double decimalValue = BMI - BMIasInt;
        double decimalTimesTen = decimalValue*10;
        int newDecimalAsInt = (int) decimalTimesTen;


        double decimalAsIntRounded;
        double finalBMI;

        if(decimalTimesTen-newDecimalAsInt >= 0.5) {
            decimalAsIntRounded = newDecimalAsInt + 1;
            double roundedDecimal = decimalAsIntRounded/10;
            finalBMI = BMIasInt + roundedDecimal;
        }
        else {

            double preRoundedBMI = (int) (BMI*10);
            finalBMI = preRoundedBMI/10;
        }

        return finalBMI;
    }


    public String category(double height, double weight) {

        //Calculates the BMI and then rounds to the nearest tenth
        double BMI = 703*weight/(height*height);

        int BMIasInt = (int) BMI;
        double decimalValue = BMI - BMIasInt;
        double decimalTimesTen = decimalValue*10;
        int newDecimalAsInt = (int) decimalTimesTen;


        double decimalAsIntRounded;
        double finalBMI;

        if(decimalTimesTen-newDecimalAsInt >= 0.5) {
            decimalAsIntRounded = newDecimalAsInt + 1;
            double roundedDecimal = decimalAsIntRounded/10;
            finalBMI = BMIasInt + roundedDecimal;
        }
        else {

            double preRoundedBMI = (int) (BMI*10);
            finalBMI = preRoundedBMI/10;
        }

        if(finalBMI < 18.5)
            return "Underweight";

        if(finalBMI >= 18.5 && BMI <= 24.9)
            return "Normal";

        if(finalBMI >= 25 && BMI <= 29.9)
            return "Overweight";

        else
            return "Obesity";

    }

}
