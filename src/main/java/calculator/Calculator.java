package calculator;

import java.util.ArrayList;

//제네릭 클래스로 선언하여 다양한 변수 타입으로 사용가능
public abstract class Calculator<T> {
    /* 연산 결과를 저장하는 컬렉션 타입 필드 선언*/
    // ArrayList : 동적 배열이라 크기를 지정하지 않아도 됨
    // protected : 같은 패키지 내에서, 다른 패키지의 자손 클래스에서 접근이 가능 (상속관계에 많이 사용)
    protected ArrayList<T> saveResults;


    // 생성자
    public Calculator(){
        this.saveResults = new ArrayList<>();
    }

    // getter
    public ArrayList<T> getResults(){
        return saveResults;
    }

    // setter
    public void setResults (ArrayList<T> saveResults){
        this.saveResults = saveResults;
    }



    // 저장된 값들을 조회하는 메서드
    public void inquiryResults() {
        if (!saveResults.isEmpty()) {
            for (T value : saveResults) {  //향상된 for-each문
                System.out.println(value);  //저장된 결과들 출력
            }
        } else {  //saveResults리스트가 비어있으면
            System.out.println("저장된 결과가 없습니다.");
        }
    }

}


