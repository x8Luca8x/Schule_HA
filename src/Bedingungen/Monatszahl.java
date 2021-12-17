package Bedingungen;

import java.util.Scanner;

public class Monatszahl
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        String monthName = input.next();
        String monthNameLower = monthName.toLowerCase();

        int month = switch (monthNameLower)
                {
                    case "januar"           -> 1;
                    case "februar"          -> 2;
                    case "märz", "maerz"    -> 3;
                    case "april"            -> 4;
                    case "mai"              -> 5;
                    case "juni"             -> 6;
                    case "juli"             -> 7;
                    case "august"           -> 8;
                    case "septemper"        -> 9;
                    case "oktober"          -> 10;
                    case "november"         -> 11;
                    case "dezember"         -> 12;
                    default -> -1;
                };

        System.out.println(monthName + " ist der " + month + " Monat.");
    }
}
