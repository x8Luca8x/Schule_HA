package Bedingungen;

import java.util.Scanner;

public class Waehrungsrechner
{
    private static class Waehrung
    {
        public Waehrung(int Id, String Name, double Mul)
        {
            m_Id = Id;
            m_Name = Name;
            m_Mul = Mul;
        }

        public int GetId() { return m_Id; }
        public String GetName() { return m_Name; }
        public double Calculate(double Money) { return Money * m_Mul; }

        private final int m_Id;
        private final String m_Name;
        private final double m_Mul;
    }

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        Waehrung[] waehrung = new Waehrung[4];

        waehrung[0] = new Waehrung(0, "US-Dollar", 1.13);
        waehrung[1] = new Waehrung(1, "Britische Pfund", 0.86);
        waehrung[2] = new Waehrung(2, "Australischer Dollar", 1.58);
        waehrung[3] = new Waehrung(3, "Japanischer Jen", 128.97);

        System.out.print("Geben Sie den Betrag in Euro ein: ");
        double money = input.nextDouble();

        System.out.println("In welche Währung soll es umgerechnet werden?");
        for(Waehrung element : waehrung)
            System.out.println((element.GetId() + 1) + " für " + element.GetName());

        int selectedId = input.nextInt();
        Waehrung selection = null;

        for(Waehrung element : waehrung)
        {
            if(element.GetId() == selectedId - 1)
            {
                selection = element;
                break;
            }
        }

        if(selection == null)
        {
            System.out.println("Die auswahl " + selectedId + " existiert nicht!");
            return;
        }

        System.out.println("Der Betrag in " + selection.GetName() + " ist " + (Math.round(selection.Calculate(money * 100.) / 100.)));
    }
}
