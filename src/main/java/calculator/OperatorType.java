package calculator;

public enum OperatorType {
    ADD('+'),
    SUBTRACT('-'),
    MULTIPLY('*'),
    DIVIDE('/'),
    MOD('%');

    private final char symbol;  //필드

    OperatorType(char symbol) {  //생성자
        this.symbol = symbol;
    }

    public static OperatorType fromOperator(char operator) {  //전달받은 연산자기호에 따른 enum타입 반환
        for (OperatorType type : OperatorType.values()) {
            if(type.symbol == operator) {
                return type;
            }
        }
        throw new UnsupportedOperationException("올바른 연산자값이 입력되지 않았습니다.");
    }
}
