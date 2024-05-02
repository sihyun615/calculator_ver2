package calculator;

public class MultiplyOperator<T extends Number> implements Operator<T> {
    @Override
    public T operate(T num1, T num2) {  //Operator 인터페이스를 구현
        // T타입변수로는 * 연산이 불가능하므로
        // 1. 일단 double타입으로 형변환하여 연산 (Number클래스(Double) 내 doubleValue() 사용)

        // T extends Number로 선언해도 컴파일러가 이를 감지 못함
        // (T가 실제로 어떤 클래스인지를 알 수 없으므로) double을 T로 형변환불가!
        // 2. (Number를 상속하는 클래스 중 하나인) Double로 형변환 후 다시 T로 형변환
        return (T) (Double) (num1.doubleValue() * num2.doubleValue());
    }
}
