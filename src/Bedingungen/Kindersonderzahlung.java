package Bedingungen;

import java.util.Scanner;

public class Kindersonderzahlung
{
    public static void main(String[] args)
    {
        int num = 0;
        Scanner input = new Scanner(System.in);

        System.out.println("Geben sie die Anzahl der Kinder an: ");
        num = input.nextInt();

        int money = 0;
        if(num == 1)
            money = 100;
        else if(num == 2)
            money = 250;
        else if(num >= 3)
            money = 500;

        System.out.println("Sie bekommen " + money + "€ Kindergeld!");
    }
}
