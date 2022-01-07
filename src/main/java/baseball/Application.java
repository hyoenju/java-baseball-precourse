package baseball;

import java.util.Scanner;
import nextstep.utils.Randoms;

public class Application {

    public static void main(String[] args) {
        // TODO 숫자 야구 게임 구현
        String randomNumber = generateRandomNumber();
        String userInput = getUserInputNumber();
    }

    public static String generateRandomNumber() {
        int randomNumber = Randoms.pickNumberInRange(100, 999);
        return Integer.toString(randomNumber);
    }

    public static String getUserInputNumber() {
        Scanner sc = new Scanner(System.in);

        System.out.print("숫자를 입력해주세요 : ");
        return sc.next();
    }
}
