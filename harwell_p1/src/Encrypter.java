import java.util.Arrays;
import java.util.Scanner;

public class Encrypter{

    public Integer convertStringtoInteger(String code){
        int intval = Integer.parseInt(code);
        return intval;
    }

    public String convertIntegerToString(Integer digit) {
        String digitCharacter = new String();
        digitCharacter = String.valueOf(digit);

        return digitCharacter;
    }

    public Integer getDigit(Integer inputNum) {
        int digit = inputNum % 10;
        return digit;
    }

    public Integer encryptNumber(Integer inputDigit) {
        int convertedNum = (inputDigit+7)%10;
        return convertedNum;
    }

    public String encrypt(String code) {

        Scanner encryptScanner = new Scanner(code);
        int number = convertStringtoInteger(code);
        Integer[] integerArray;
        integerArray = new Integer[4];

        for(int i=0; i<4; i++){
            integerArray[3-i] = getDigit(number);
            number = number/10;
        }

        for(int j=0; j<4; j++){
            integerArray[j] = encryptNumber(integerArray[j]);
        }

        int temp = integerArray[0];
        integerArray[0] = integerArray[2];
        integerArray[2] = temp;

        int temp2 = integerArray[1];
        integerArray[1] = integerArray[3];
        integerArray[3] = temp2;

        String finalCode;
        finalCode = convertIntegerToString(integerArray[0]) + convertIntegerToString(integerArray[1]) +convertIntegerToString(integerArray[2]) + convertIntegerToString(integerArray[3]);


        //System.out.println(integerArray[0] + " " + integerArray[1] + " " + integerArray[2] + " " +integerArray[3]);
        //System.out.println(finalCode);
        return finalCode;
    }
}
