package calculator;

import java.util.*;
import java.lang.*;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Double> list = new ArrayList<>(); // 연산된 값을 list에 저장
        Calculator calculator = new Calculator();

        while (true) {

            System.out.println("첫 번째 숫자를 입력하세요:");
            double num1 = sc.nextDouble();

            System.out.println("두 번째 숫자를 입력하세요:");
            double num2 = sc.nextDouble();

            sc.nextLine(); // num1, num2 뒤의 줄 바꿈 문자 처리
            System.out.println("사칙연산의 기호를 입력하세요 (+, -, *, /)");
            String operator = sc.nextLine();

            if(operator.length() !=1){
                System.out.println("유효하지 않은 연산자입니다. 다시 입력하세요");
                continue;
            }


            double result = calculator.calculate(operator, num1, num2);

            if (Double.isNaN(result)) {
                continue; // 오류가 발생했으므로 루프의 시작으로 돌아감
            }

            list.add(result); //결과는 list로 추가됨
            System.out.println("결과는 : " + result);

            // 추가 명령어 처리
            System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력)");
            String std = sc.nextLine();
            if (std.equalsIgnoreCase("remove")) {
                if (!list.isEmpty()) {
                    list.remove(0); // 처음 저장된 결과를 삭제
                    System.out.println("처음 저장된 연산 결과가 삭제되었습니다.");
                } else {
                    System.out.println("삭제할 결과가 없습니다.");
                }
            }

            // 저장된 연산결과 조회
            System.out.println("저장된 연산결과를 조회 (inquiry 입력 시 조회)");
            String stf = sc.nextLine();
            if (stf.equalsIgnoreCase("inquiry")) {
                if (list.isEmpty()) {
                    System.out.println("저장된 결과가 없습니다.");
                } else {
                    System.out.println("저장된 연산결과:"); //list에서 값을 불러온다
                    for (Double item : list) {
                        System.out.println(item);
                    }
                }
            }

            // 종료 여부 확인
            System.out.println("계산기 종료(exit 입력 시 종료)");
            String str = sc.nextLine();
            if (str.equalsIgnoreCase("exit")) {
                System.out.println("계산 종료");
                break; // 루프 종료
            } else {
                System.out.println("계산 계속");
            }
        }

        sc.close(); // Scanner 자원 해제
    }
}
