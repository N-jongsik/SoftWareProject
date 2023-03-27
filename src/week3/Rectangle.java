package week3;

import java.util.Scanner;

public class Rectangle {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int x1=scanner.nextInt();
        int y1=scanner.nextInt();
        int x2=scanner.nextInt();
        int y2=scanner.nextInt();

        if(((x1>=100 && x1<=200)&&(y1>=100&&y1<=200))||((x2>=100 && x2<=200)&&(y2>=100&&y2<=200))){
            System.out.println("사각형이 겹칩니다.");
        }else {
            System.out.println("사각형이 겹치지 않습니다.");
        }

        scanner.close();
    }
}
