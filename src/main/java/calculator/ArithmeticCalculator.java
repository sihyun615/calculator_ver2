package calculator;

import java.util.List;

//제네릭 클래스로 선언하여 다양한 변수 타입으로 사용가능
public class ArithmeticCalculator<T extends Number> extends Calculator<T> {  // Calculator클래스를 상속받음

    private T result;

    // Operator 인터페이스
    private final Operator<T> addOperator;
    private final Operator<T> subtractOperator;
    private final Operator<T> multiplyOperator;
    private final Operator<T> divideOperator;
    private final Operator<T> modOperator;


    // ArithmeticCalculator 생성자를 통해 사칙연산 클래스들 초기화
    public ArithmeticCalculator(Operator<T> addOperator,
                                Operator<T> subtractOperator,
                                Operator<T> multiplyOperator,
                                Operator<T> divideOperator,
                                Operator<T> modOperator){

        this.addOperator = addOperator;
        this.subtractOperator = subtractOperator;
        this.multiplyOperator = multiplyOperator;
        this.divideOperator = divideOperator;
        this.modOperator = modOperator;
    }


    /* 나눗셈에서 분모에 0이 들어오거나, 연산자 기호가 잘못 들어온 경우
      적합한 Exception 클래스를 생성하여 throw (매개변수로 해당 오류 내용을 전달)*/
    public T calculate(char operator, T num1, T num2) throws Exception {

        boolean validOperator = false;

        for (OperatorType type : OperatorType.values()) {
            if (type.getOperator() == operator) {
                validOperator = true; // 연산자를 발견했으므로 foundOperator를 true로 설정합니다.
                switch (type) {
                    case ADD:
                        result = addOperator.operate(num1,num2);
                        break;
                    case SUBTRACT:
                        result = subtractOperator.operate(num1,num2);
                        break;
                    case MULTIPLY:
                        result = multiplyOperator.operate(num1,num2);
                        break;
                    case DIVIDE:
                        if (num2.doubleValue() == 0){  //분모값으로 0이 입력된 경우 예외클래스로 throw
                            throw new BadInputException("분모값");  //예외처리
                        }
                        result = divideOperator.operate(num1,num2);
                        break;
                    case MOD:
                        if (num2.doubleValue() == 0){  //분모값으로 0이 입력된 경우 예외클래스로 throw
                            throw new BadInputException("나누는 값");  //예외처리
                        }
                        result = modOperator.operate(num1,num2);
                        break;
                }
            }
        }

        if (!validOperator) {
            throw new BadInputException("연산자값"); // enum값에 해당하는 연산자 외의 입력 시 예외처리
        }

        saveResults.add(result);  // Calculator클래스의 saveResults리스트에 연산결과 추가

        return result;
    }




    //가장 먼저 저장된 결과값 삭제 메서드
    public void removeResult() {
        if (!getResults().isEmpty()) {
            saveResults.remove(0);  // Calculator클래스의 saveResults리스트에서 값 삭제
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
