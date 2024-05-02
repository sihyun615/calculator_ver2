package calculator;

import java.util.List;

//제네릭 클래스로 선언하여 다양한 변수 타입으로 사용가능
public class ArithmeticCalculator<T extends Number> extends Calculator<T> {  // Calculator클래스를 상속받음

    private T result;


    /* 나눗셈에서 분모에 0이 들어오거나, 연산자 기호가 잘못 들어온 경우
      적합한 Exception 클래스를 생성하여 throw (매개변수로 해당 오류 내용을 전달)*/
    public T calculate(char operator, T num1, T num2) throws Exception {

        return checkOperator(operator).operate(num1,num2);
    }

    private Operator<T> checkOperator (char operator) {
        OperatorType operatorType = OperatorType.fromOperator(operator);
        return switch (operatorType){
            case ADD -> new AddOperator<T>();
            case SUBTRACT -> new SubtractOperator();
            case MULTIPLY -> new MultiplyOperator();
            case DIVIDE -> new DivideOperator();
            case MOD -> new ModOperator();
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



    // 저장된 연산결과들 중 현재 연산값보다 큰 값들 출력 메서드
    public void inquiryGreaterResults() {
        // Stream API 활용
        List<T> greaterResults = getResults().stream()
                .filter((saveResults) -> compare(saveResults,result) > 0)  //람다 활용
                .toList();

        if (!greaterResults.isEmpty()) {  //저장된 연산결과들 중 현재 연산값보다 큰 값이 존재하면 출력
            greaterResults.forEach(System.out::println);  // Stream API 활용
        } else {
                System.out.println("현재 연산결과값보다 큰 값이 없습니다.");
        }
    }

    private int compare(T a, T b) {
        //a가 b보다 작으면 음수, 같으면 0, 크면 양수를 반환
        return Double.compare(a.doubleValue(), b.doubleValue());
    }

}
