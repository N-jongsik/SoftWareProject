package week4;

import java.util.Scanner;

public class Divide_with_Exception {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        int a=0, b=0;

        System.out.println("첫 번째 숫자를 입력해주세요: ");
        sc.nextInt();
        System.out.println("두 번째 숫자를 입력해주세요: ");
        sc.nextInt();

        try {
            divide(a,b);
        }catch (ArithmeticException e){
            e.printStackTrace();
        }
    }
    public static int divide(int a,int b) throws ArithmeticException{
        if(b==0){
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
        return a/b;
    }
}
