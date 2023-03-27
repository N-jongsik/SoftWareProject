package week3;

import java.util.Scanner;

public class ChangeMoneyVer2 {
    public static void main(String[] args)
    {
        int[] unit={50000,10000,1000,500,100,50,10,1};

        Scanner scanner=new Scanner(System.in);

        System.out.println("금액을 입력하시오>>");
        int money=scanner.nextInt();


        for (int number:unit)
        {
            int res=money/number;
            if(res>0)
            {
                System.out.println(number+"원 짜리:"+res+"개");
                money=money%number;
            }
        }



        scanner.close();
        }

    }
