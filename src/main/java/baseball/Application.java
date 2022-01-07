package baseball;

import nextstep.utils.Randoms;

public class Application {
    public static void main(String[] args) {
        // TODO 숫자 야구 게임 구현
        String randomNumber = generateRandomNumber();
    }

    public static String generateRandomNumber() {
        int randomNumber = Randoms.pickNumberInRange(100, 999);
        return Integer.toString(randomNumber);
    }
}
