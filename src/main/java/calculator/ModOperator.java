package calculator;

public class ModOperator<T extends Number> implements Operator<T> {

    public final Class<T> type;

    public ModOperator(Class<T> type) {
        this.type = type;
    }


    @Override
    public T operate(T num1, T num2) {  //Operator 인터페이스를 구현
        if (num2.doubleValue() == 0){
            throw new ArithmeticException("나머지 연산에서 두번째 정수에 0이 입력될 수 없습니다.");
        }

        double result = num1.doubleValue() % num2.doubleValue();

        return NumberConversionUtils.convertNumberToType(result, type);
    }
}
