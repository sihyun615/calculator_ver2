package calculator;

public enum OperatorType {
    ADD('+'),
    SUBTRACT('-'),
    MULTIPLY('*'),
    DIVIDE('/'),
    MOD('%');

    private final char operator;  //필드

    OperatorType(char operator) {  //생성자
        this.operator = operator;
    }

    public char getOperator() {  //getter
        return operator;
    }
}
