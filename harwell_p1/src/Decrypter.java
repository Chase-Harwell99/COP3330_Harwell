public class Decrypter {

    public Integer convertStringtoInteger(String code){
        int intval = Integer.parseInt(code);
        return intval;
    }

    public String convertIntegerToString(Integer digit) {
        String digitCharacter;
        digitCharacter = String.valueOf(digit);

        return digitCharacter;
    }

    public Integer getDigit(Integer inputNum) {
        int digit = inputNum % 10;
        return digit;
    }

    public Integer decryptNumber(Integer inputDigit) {
        int convertedNum = (inputDigit+3)%10;
        return convertedNum;
    }

    public String decrypt(String code) {

        int number = convertStringtoInteger(code);
        Integer[] intArray = new Integer[4];

        //seperates each number in the 4 digit number to form an integer array
        for(int i=0; i<4; i++){
            intArray[3-i] = getDigit(number); //uses 3-i because algorithm gets digits from right to left
            number = number/10;
        }

        //swaps integers 1 and 3
        int temp = intArray[0];
        intArray[0] = intArray[2];
        intArray[2] = temp;

        //swaps integers 2 and 4
        int temp2 = intArray[1];
        intArray[1] = intArray[3];
        intArray[3] = temp2;

        //decrypts each number in the integer array
        for(int j=0; j<4; j++){
            intArray[j] = decryptNumber(intArray[j]);
        }


        //converts the integers into strings and combines them to form the final 4 digit encrypted code
        String finalCode = convertIntegerToString(intArray[0]) + convertIntegerToString(intArray[1]) +
                convertIntegerToString(intArray[2]) + convertIntegerToString(intArray[3]);


        return finalCode;
    }
}
