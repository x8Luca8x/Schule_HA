import java.util.Scanner;

public class Aufgabe_2
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        //Name
        System.out.print("Bitte geben sie ihren Namen ein: ");
        String name = input.next();

        //Grundlohn
        System.out.print("Bitte geben sie ihren Grundlohn ein (€): ");
        int grundlohn = -1;
        while(grundlohn < 0)
        {
            if(input.hasNextInt())
            {
                int num = input.nextInt();
                if(num > 0)
                    grundlohn = num;
                else
                    System.out.println("Der grund lohn muss größer als oder 0 sein");
            }
            else
                System.out.println("Bitte geben sie eine Nummer ein");
        }

        //Osterfan
        System.out.print("Sind sie Osterfan?");

        String rIn = input.next();
        String in = rIn.toLowerCase();

        boolean bIsOsterfan = in.equals("true") || in.equals("ja") || in.equals("j") || in.equals("1");

        //Eier gefärbt
        System.out.print("Wie viele Eier haben sie gefärbt?");

        int eier = -1;
        while(eier < 0)
        {
            if(input.hasNextInt())
                eier = input.nextInt();
            else
                System.out.println("Bitte geben sie eine Nummer ein");
        }

        System.out.println("\n\nHallo " + name + "! Hier ein Überblick über deine Daten:\n" +
                "------------------------------------------------- ");

        System.out.println("Grundlohn:\t\t\t\t\t" + grundlohn + " EUR");
        System.out.println("Du bist ein Osterfan?\t\t" + (bIsOsterfan ? "Ja" : "Nein"));
        System.out.println("Anzahl der gefärbten Eier:\t" + eier + " Stück");
    }
}
