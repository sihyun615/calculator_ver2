package calculator;

import java.util.List;

public class CircleCalculator extends Calculator {  // Calculator클래스를 상속받음

    //static: 클래스 멤버 선언
    //final: 수정 불가
    //static final : 상수 (유일하며 불변인 값)
    static final double PI = 3.14;  //PI는 3.14로 고정된 값임

    public CircleCalculator(List<Double> saveResults) {
        super(saveResults);
    }

    //원의 넓이를 구하는 메서드
    public double calculateCircleArea (double radius) throws Exception {
        if (radius < 0){
            throw new BadInputException("원지름값");  //예외처리
        }

        double area = PI * radius * radius;  //원의 넓이 구함
        getResults().add(area);
        return area;
    }

}
