package calculator;

public class ModOperator<T extends Number> implements Operator<T> {

    public final Class<T> type;

    public ModOperator(Class<T> type) {
        this.type = type;
    }


    @Override
    public T operate(T num1, T num2) {  //Operator 인터페이스를 구현
        if (num2.doubleValue() == 0){
            throw new ArithmeticException("두번째 정수에 0을 입력 시 나머지 연산이 불가합니다.");
        }

        double result = num1.doubleValue() % num2.doubleValue();

        return NumberConversionUtils.convertNumberToType(result, type);
    }
}
