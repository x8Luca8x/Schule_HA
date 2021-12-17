package Bedingungen;

import java.util.Locale;
import java.util.Scanner;

public class Schueler
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Bist du Schueler?");
        String strIsSchueler = input.next().toLowerCase();

        boolean bIsSchueler = strIsSchueler.equals("true") || strIsSchueler.equals("yes") || strIsSchueler.equals("ja") || strIsSchueler.equals("y") || strIsSchueler.equals("j");
        if(bIsSchueler)
            System.out.println("Du erhältst eine vergünstigte Fahrkarte");
        else
            System.out.println("Leider musst du den vollen Preis bezahlen");
    }
}
