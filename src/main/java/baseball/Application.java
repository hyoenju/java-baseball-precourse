package baseball;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import nextstep.utils.Randoms;
import nextstep.utils.Console;

public class Application {

    public static void main(String[] args) {
        String randomNumber = generateRandomNumber();
        String userInput;
        int[] resultArr = {0, 0};

        System.out.println(randomNumber);
        while (resultArr[0] < 3) {
            userInput = getUserInputNumber();

            String[] randomArr = randomNumber.split("");
            String[] userArr = userInput.split("");

            resultArr = countStrikesAndBalls(randomArr, userArr);
            printStrikesAndBalls(resultArr[0], resultArr[1]);

            if (resultArr[0] == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            }
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
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();

        if (!isValidateNumber(userInput)) {
            System.out.print("[ERROR] 잘못된 값을 입력했습니다. ");
            userInput = getUserInputNumber();
        }
        return userInput;
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

    public static int[] countStrikesAndBalls(String[] RandomArr, String[] UserArr) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i <= 2; i++) {
            if (RandomArr[i].equals(UserArr[i])) {
                strikes++;
            } else if (Arrays.asList(RandomArr).contains(UserArr[i])) {
                balls++;
            }
        }

        return new int[]{strikes, balls};
    }

    public static void printStrikesAndBalls(int strikes, int balls) {
        if (strikes > 0) {
            System.out.print(strikes + " 스트라이크 ");
        }
        if (balls > 0) {
            System.out.print(balls + " 볼 ");
        }
        System.out.println();
    }
}
