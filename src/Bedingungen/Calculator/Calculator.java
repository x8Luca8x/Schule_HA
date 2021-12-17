package Bedingungen.Calculator;

import java.util.ArrayList;
import java.util.Scanner;

public class Calculator
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();

        ArrayList<MathOperator> operators = CalculatorParser.Parse(line);
        if(operators != null)
        {
            float value = 0.f;
            for(int i = 0; i < operators.size(); i++)
            {
                if(i + 1 < operators.size())
                    value = operators.get(i).Calculate();
            }

            System.out.println(value);
        }
    }
}
