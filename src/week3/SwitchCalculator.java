package week3;

import java.util.Scanner;

public class SwitchCalculator {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int num1=scanner.nextInt();
        String sign=scanner.next();
        int num2=scanner.nextInt();


        switch (sign){

            case ("+"):
            {
                System.out.println(num1+"+"+num2+"="+(num1+num2));
                break;
            }
            case("-"):
            {
                System.out.println(num1+"-"+num2+"="+(num1-num2));
                break;
            }
            case ("*"):
            {
                System.out.println(num1+"*"+num2+"="+(num1*num2));
                break;
            }
            case ("/"):
            {
                if((num1==0)||(num2==0)){
                    System.out.println("오류발생");
                }else {
                    System.out.println(num1+"/"+num2+"="+(double)(num1/num2));
                }
                break;

            }
            default:
            {
                System.out.println("정확한 문자를 입력해주세요");
            }


        }
        scanner.close();


    }
}
