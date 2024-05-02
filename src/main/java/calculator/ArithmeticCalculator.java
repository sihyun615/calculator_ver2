package calculator;

import java.util.List;

//제네릭 클래스로 선언하여 다양한 변수 타입으로 사용가능
public class ArithmeticCalculator<T extends Number> extends Calculator {  // Calculator클래스를 상속받음

    public final Class<T> type;  //클래스를 통해 타입 파악위함

    public ArithmeticCalculator(List<Double> saveResults, Class<T> type) {
        super(saveResults);
        this.type = type;  //타입파악
    }

    public T calculate(char operator, T num1, T num2){

        return checkOperator(operator).operate(num1,num2);
    }

    private Operator<T> checkOperator (char operator) {  //Operator타입을 파악하여 해당하는 type의 객체 생성
        OperatorType operatorType = OperatorType.fromOperator(operator);
        return switch (operatorType){  //향상된 switch문
            case ADD -> new AddOperator(type);
            case SUBTRACT -> new SubtractOperator(type);
            case MULTIPLY -> new MultiplyOperator(type);
            case DIVIDE -> new DivideOperator(type);
            case MOD -> new ModOperator(type);
        };
    }




    //가장 먼저 저장된 결과값 삭제 메서드
    public void removeResult() {
        if (!getResults().isEmpty()) {
            getResults().remove(0);  // Calculator클래스의 saveResults리스트에서 값 삭제
            System.out.println("가장 먼저 저장된 결과가 삭제되었습니다.");
        } else {  //saveResults리스트가 비어있으면
            System.out.println("저장된 결과가 없습니다.");
        }
    }



    // 저장된 연산결과들 중 현재 입력된 값보다 큰 값들 출력 메서드
    public void inquiryGreaterResults(double num) {
        // Stream API 활용
        List<Double> greaterResults = getResults().stream()
                .filter(result -> result > num)  //람다 활용
                .toList();

        if (!greaterResults.isEmpty()) {  //저장된 연산결과들 중 현재 연산값보다 큰 값이 존재하면 출력
            greaterResults.forEach(System.out::println);  // Stream API 활용
        } else {
            System.out.println("현재 연산결과값보다 큰 값이 없습니다.");
        }
    }
}
