package week2;

import java.util.Scanner;

public class Money {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("금액을 입력하시오>>");
        int money=scanner.nextInt();

        int [] changeMoney = new int[8];
        int [] arr={50000,10000,5000,1000,500,100,50,1};

        for(int i=0;i<changeMoney.length;i++){
            changeMoney[i]=money/arr[i];
            money=money%arr[i];
        }
        String [] arr1={"오만원권","만원권","오천원권","천원권","오백원","백원","오십원","일원"};
        for (int i=0;i<changeMoney.length;i++){
            System.out.println(arr1[i]+" "+changeMoney[i]+"개");
        }


        scanner.close();
    }
}
