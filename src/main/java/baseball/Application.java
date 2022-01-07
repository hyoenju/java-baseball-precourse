package baseball;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import nextstep.utils.Randoms;

public class Application {

    public static void main(String[] args) {
        String randomNumber = generateRandomNumber();
        String userInput = getUserInputNumber();

        while (!isValidateNumber(userInput)) {
            System.out.println("[ERROR] 잘못된 값을 입력했습니다. 다시 입력해주세요.");
            userInput = getUserInputNumber();
        }
    }

    public static String generateRandomNumber() {
        int randomNumber;
        while (true) {
            randomNumber = Randoms.pickNumberInRange(100, 999);
            if (isValidateNumber(Integer.toString(randomNumber))) {
                break;
            }
        }
        return Integer.toString(randomNumber);
    }

    public static String getUserInputNumber() {
        Scanner sc = new Scanner(System.in);

        System.out.print("숫자를 입력해주세요 : ");
        return sc.next();
    }

    public static boolean isThreeDigits(String strNum) {
        return strNum.length() == 3;
    }

    public static boolean isNumeric(String strNum) {
        try {
            Integer.parseInt(strNum);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isDuplicateNumbers(String[] numArr) {
        Set<String> numSet = new HashSet<>(Arrays.asList(numArr));
        String[] resultArr = numSet.toArray(new String[0]);

        return resultArr.length == numArr.length;
    }

    public static boolean isValidateNumber(String strNum) {
        if (!isNumeric(strNum)) {
            return false;
        } else if (!isThreeDigits(strNum)) {
            return false;
        } else if (!isDuplicateNumbers(strNum.split(""))) {
            return false;
        } else {
            return true;
        }
    }
}
