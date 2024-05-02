package calculator;

public class DivideOperator<T extends Number> implements Operator<T> {

    public final Class<T> type;

    public DivideOperator(Class<T> type) {
        this.type = type;
    }


    @Override
    public T operate(T num1, T num2) {  //Operator 인터페이스를 구현
        // T타입변수로는 / 연산이 불가능하므로
        if (num2.doubleValue() == 0){
            throw new ArithmeticException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
        }

        double result = num1.doubleValue() / num2.doubleValue();

        return NumberConversionUtils.convertNumberToType(result, type);
    }
}
