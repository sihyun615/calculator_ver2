package calculator;

import java.util.List;

//제네릭 클래스로 선언하여 다양한 변수 타입으로 사용가능
public abstract class Calculator{
    /* 연산 결과를 저장하는 컬렉션 타입 필드 선언*/
    // ArrayList : 동적 배열이라 크기를 지정하지 않아도 됨
    // private : Calculator 클래스 내부에서만 접근 가능
    private final List<Double> saveResults;

    public Calculator(List<Double> saveResults) {
        this.saveResults = saveResults;
    }

    // getter
    public List<Double> getResults(){
        return saveResults;
    }




    // 저장된 값들을 조회하는 메서드
    public void inquiryResults() {
        if (!saveResults.isEmpty()) {
            for (Double value : saveResults) {  //향상된 for-each문
                System.out.println(value);  //저장된 결과들 출력
            }
        } else {  //saveResults리스트가 비어있으면
            System.out.println("저장되어 있는 결과값이 없습니다.");
        }
    }

}


