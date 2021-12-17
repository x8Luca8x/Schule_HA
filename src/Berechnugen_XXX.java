import java.text.DecimalFormat;
import java.util.Scanner;

public class Berechnugen_XXX
{
    public static double WaitForInput(Scanner scanner)
    {
        while(true)
        {
            if(scanner.hasNextDouble())
                return scanner.nextDouble();
            else
            {
                System.out.print("Geben sie bitte eine Fließkommazahlen ein: ");
                scanner.next();
            }
        }
    }

    public static void PrintDose(double u, double h)
    {
        double dBoden = u / Math.PI;
        double fBoden = Math.PI * Math.pow(dBoden / 2, 2);
        double fMantel = u * h;
        double fGesamt = 2 * fBoden + fMantel;
        double v = fBoden * h;

        System.out.println("\n");
        System.out.println("Boden Durchmesser:\t" + dBoden);
        System.out.println("Boden fläche\t\t" + fBoden);
        System.out.println("Mantelfläche:\t\t" + fMantel);
        System.out.println("Gesamtfläche:\t\t" + fGesamt);
        System.out.println("Volumen:\t\t\t" + v);
    }
    public static void PrintRechteck(double a, double b)
    {
        DecimalFormat format = new DecimalFormat("0.00");

        String rA = format.format(a * b);
        String u  = format.format(2 * a + 2 * b);
        String d  = format.format(Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2)));

        System.out.println("\n");
        System.out.println("Flächeninhalt:\t\t" + rA);
        System.out.println("Umfang:\t\t\t\t" + u);
        System.out.println("Diagonalenlänge:\t" + d);
    }

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Geben sie die Nummer des zu berechnenden objektes ein");
        System.out.println("1: Dose");
        System.out.println("2: Rechteck");
        System.out.print("Nummer: ");

        int selection = (int)WaitForInput(input);
        System.out.println("\n");

        if(selection == 1)
        {
            //Nach Durchmesser fragen
            System.out.print("Geben sie den durchmesser ein: ");
            double u = WaitForInput(input);
            //Nach höhe fragen
            System.out.print("Geben sie bitte die höhe ein: ");
            double h = WaitForInput(input);

            //Fragen welches objekt ausgerechnet werden soll
            System.out.println("Geben sie die Nummer des objektes an, welches ausgerechnet werden soll");
            System.out.println("1: Dose");
            System.out.println("2: Rechteck");

            PrintDose(u, h);
        }
        else
        {
            //Nach Seitenlänge a fragen
            System.out.print("Seitenlänge a: ");
            double a = WaitForInput(input);
            //Nach Seitenlänge b fragen
            System.out.print("Seitenlänge b: ");
            double b = WaitForInput(input);

            PrintRechteck(a, b);
        }
    }
}
