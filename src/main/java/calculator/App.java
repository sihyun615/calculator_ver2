package calculator;

import java.util.Objects;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        // Calculator클래스를 상속받은 두 클래스의 각각의 인스턴스 생성

        //ArithmeticCalculator 제네릭 클래스 타입 설정
        ArithmeticCalculator<Double> arithmeticCal = new ArithmeticCalculator<>();
        CircleCalculator circleCal = new CircleCalculator();

        Scanner sc = new Scanner(System.in);


        while(true) {  //무한루프
            System.out.println("\n1. 사칙연산 진행");
            System.out.println("2. 원의 넓이 구하기");
            System.out.print("위의 메뉴 중 한 가지를 골라 숫자를 입력하세요: ");
            int menu = sc.nextInt();  //입력 정수 저장

            switch (menu) {
                case 1:  //1번 사칙연산 진행을 선택한 경우
                    while(true) {  //내부 무한루프를 생성하여 case1에서 숫자가 아닌 값 입력되면 case1의 다음 반복으로
                        System.out.print("\n첫 번째 숫자를 입력하세요: ");
                        if (!(sc.hasNextInt()||sc.hasNextLong()||sc.hasNextFloat()||sc.hasNextDouble())) {
                            System.out.println("숫자가 아닌 값이 입력되었습니다. 다시 입력하세요.");
                            sc.next();  // 잘못 입력된 값 여기서 쓰고버리기
                            continue;  // 다음 반복으로 (case1 첫부분)
                        }
                        double num1 = sc.nextDouble();  //입력받을 변수타입 설정

                        System.out.print("두 번째 숫자를 입력하세요: ");
                        if (!(sc.hasNextInt()||sc.hasNextLong()||sc.hasNextFloat()||sc.hasNextDouble())) {
                            System.out.println("숫자가 아닌 값이 입력되었습니다. 다시 입력하세요.");
                            sc.next();  // 잘못 입력된 값 여기서 쓰고버리기
                            continue;  // 다음 반복으로 (case1 첫부분)
                        }
                        double num2 = sc.nextDouble();  //입력받을 변수타입 설정

                        System.out.print("사칙연산 기호를 입력하세요: ");
                        //next()의 반환값이 string이므로 charAt(0)으로 char로 바꾼후 0번째 char 반환
                        char operator = sc.next().charAt(0);


                        // ArithmeticCalculator 클래스의 calculate 메서드 호출
                        try {
                            double result = arithmeticCal.calculate(operator, num1, num2);
                            System.out.println("결과 : " + result);
                            arithmeticCal.getResults().add(result);  //연산결과저장배열에 해당 결과 저장
                        } catch (Exception e) {  //예외처리
                            System.out.println("오류: " + e.getMessage());
                        }


                        System.out.println("\n가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
                        if (Objects.equals(sc.next(), "remove")) {  //입력받은 값이 "remove"이면
                            arithmeticCal.removeResult();  // ArithmeticCalculator 클래스의 removeResult메서드 사용
                        }


                        System.out.println("\n저장된 연산결과들을 조회하시겠습니까? (inquiry 입력 시 조회)");
                        if (Objects.equals(sc.next(), "inquiry")) {  //입력받은 값이 "inquiry"이면
                            System.out.println("\n저장된 연산결과들을 조회합니다.");
                            arithmeticCal.inquiryResults();  //Calculator 클래스의 inquiryResults메서드 상속받아 사용
                        }

                        System.out.println("\n저장된 연산결과들 중 현재 결과값보다 큰 값을 조회하시겠습니까? (inquiry 입력 시 조회)");
                        if (Objects.equals(sc.next(), "inquiry")) {  //입력받은 값이 "inquiry"이면
                            System.out.println("저장된 연산결과들 중 현재 결과값보다 큰 값들을 조회합니다.");
                            arithmeticCal.inquiryGreaterResults();  //ArithmeticCalculator 클래스의 inquiryGreaterResults메서드 사용
                        }

                        break;  //내부 while문에서 빠져나감
                    }
                    break;  //switch문에서 빠져나감



                case 2:  //2번 원의 넓이 구하기를 선택한 경우
                    while(true) {  //내부 무한루프를 생성하여 case2에서 숫자가 아닌 값 입력되면 case2의 다음 반복으로
                        System.out.print("\n원의 반지름을 입력하세요: ");
                        if (!(sc.hasNextInt() || sc.hasNextLong() || sc.hasNextFloat() || sc.hasNextDouble())) {
                            System.out.println("숫자가 아닌 값이 입력되었습니다. 다시 입력하세요.");
                            sc.next();  // 잘못 입력된 값 여기서 쓰고버리기
                            continue;  // 다음 반복으로 (case2 첫부분)
                        }
                        double radius = sc.nextDouble();  //입력 저장

                        // CircleCalculator 클래스의 calculateCircleArea 메서드 호출
                        try {
                            double areaResult = circleCal.calculateCircleArea(radius);
                            System.out.println("결과 : " + areaResult);
                        } catch (Exception e) {  //예외처리
                            System.out.println("오류: " + e.getMessage());
                        }


                        System.out.println("\n저장된 원의 넓이 값들을 조회합니다.");
                        circleCal.inquiryResults();  //Calculator 클래스의 inquiryResults메서드 상속받아 사용

                        break;  //내부 while문에서 빠져나감
                    }
                    break;  //switch문에서 빠져나감



                default:
                    System.out.println("잘못된 메뉴값을 입력하였습니다. 다시 입력하세요.\n");
                    continue;  //while문의 다음 반복으로 넘어감

            }




            System.out.println("\n더 계산하시겠습니까? (exit 입력 시 종료)");
            if (Objects.equals(sc.next(), "exit")) {  //입력받은 값이 "exit"이면 while문 종료
                break;  //while문에서 빠져나감
            }

        }
    }
}
