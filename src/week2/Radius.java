package week2;

import java.util.Scanner;

public class Radius {
    public static void main(String[] args) {
        final double PI=3.14;//원주율 고정
        Scanner scanner=new Scanner(System.in);
        System.out.println("반지름의 길이를 입력해주세요:");//사용자에게 입력받기
        double radius=scanner.nextDouble();

        double circumference=2*PI*radius;//원의 둘레
        double area=PI*radius*radius;//원의 넓이

        System.out.println("원의 둘레:"+circumference);
        System.out.println("원의 넓이:"+area);

        scanner.close();
    }
}
