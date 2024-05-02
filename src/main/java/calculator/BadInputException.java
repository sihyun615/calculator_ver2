package calculator;

// 예외 클래스
public class BadInputException extends Exception {
    public BadInputException(String type) {
        super("잘못된 입력입니다! 알맞은 " + type + "을 입력해주세요!");
    }
}
