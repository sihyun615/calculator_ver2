package calculator;

//연산자 인터페이스
public interface Operator<T> {
    T operate(T num1, T num2);
}
