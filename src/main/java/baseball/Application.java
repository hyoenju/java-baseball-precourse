package baseball;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.stream.Collectors;
import nextstep.utils.Randoms;
import nextstep.utils.Console;

public class Application {

    public static void main(String[] args) {
        int[] resultArr = {0, 0};
        String userInput;

        String randomNumber = generateRandomNumber();
        while (resultArr[0] < 3) {
            userInput = getUserInputNumber();

            String[] randomArr = randomNumber.split("");
            String[] userArr = userInput.split("");

            resultArr = countStrikesAndBalls(randomArr, userArr);
            printStrikesAndBalls(resultArr[0], resultArr[1]);
        }

        String replayInput = getInputReplayGameOrNot();
        if (replayInput.equals("1")) {
            main(new String[]{});
        }
    }

    static String generateRandomNumber() {
        List<Integer> numList = new ArrayList<>();
        while (numList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            while (numList.contains(randomNumber)) {
                randomNumber = Randoms.pickNumberInRange(0, 9);
            }
            numList.add(randomNumber);
        }
        return numList.stream().map(String::valueOf).collect(Collectors.joining(""));
    }

    static String getUserInputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();

        if (!isValidateNumber(userInput)) {
            System.out.print("[ERROR] 잘못된 값을 입력했습니다. ");
            userInput = getUserInputNumber();
        }
        return userInput;
    }

    static boolean isThreeDigits(String strNum) {
        return strNum.length() == 3;
    }

    static boolean isNumeric(String strNum) {
        try {
            Integer.parseInt(strNum);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    static boolean isNotDuplicateNumbers(String strNum) {
        Set<String> numSet = new HashSet<>(Arrays.asList(strNum.split("")));
        return numSet.toArray(new String[0]).length == strNum.length();
    }

    static boolean isValidateNumber(String strNum) {
        if (!isNumeric(strNum)) {
            return false;
        } else if (!isThreeDigits(strNum)) {
            return false;
        } else
            return isNotDuplicateNumbers(strNum);
    }

    static int[] countStrikesAndBalls(String[] RandomArr, String[] UserArr) {
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

    static void printStrikesAndBalls(int strikes, int balls) {
        if ((strikes == 0) && (balls == 0)) {
            System.out.println("낫싱");
        } else {
            if (strikes > 0) {
                System.out.print(strikes + "스트라이크 ");
            }
            if (balls > 0) {
                System.out.print(balls + "볼 ");
            }
            System.out.println();
        }
        if (strikes == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
        }
    }

    static String getInputReplayGameOrNot() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput = Console.readLine();
        if (!userInput.equals("1") && !userInput.equals("2")) {
            getInputReplayGameOrNot();
        }
        return userInput;
    }
}
