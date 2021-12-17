import java.util.Random;
import java.util.Scanner;

public class Aufgabe_1
{
    static class Product
    {
        Product(String name, float price, int count)
        {
            m_Name = name;
            m_Price = price;
            m_Count = count;
        }

        public String GetName() { return m_Name; }
        public float GetPrice() {return m_Price;}
        public int GetCount() { return m_Count; }

        private final String m_Name;
        private final float m_Price;
        private final int m_Count;
    }
    public static void main(String[] args) {
        //Produkte deklarieren
        Product[] products = new Product[5];
        products[0] = new Product("Produkt_1", 9.99f, new Random().nextInt(50));
        products[1] = new Product("Produkt_2", 4.99f, new Random().nextInt(50));
        products[2] = new Product("Produkt_3", 8.49f, new Random().nextInt(50));
        products[3] = new Product("Produkt_4", 20.99f, new Random().nextInt(50));
        products[4] = new Product("Produkt_5", 0.99f, new Random().nextInt(50));

        Scanner input = new Scanner(System.in);

        //Nach Produkt fragen
        Product selectedProduct = null;
        System.out.println("Geben sie die Nummer des Produktes ein:");
        StringBuilder stringBuilder = new StringBuilder("1: " + products[0].GetName()
                + "(Menge: " + products[0].GetCount() + ", Preis: " + products[0].GetPrice() + ")");
        for(int i = 1; i < products.length; i++)
            stringBuilder.append(", ").append(i + 1).append(": ").append(products[i].GetName()).append("(Menge: ").append(products[i].GetCount())
                    .append(", Preis: ").append(products[i].GetPrice()).append(")");

        System.out.println(stringBuilder);
        while(selectedProduct == null)
        {
            if(input.hasNextInt())
            {
                int index = input.nextInt();
                if(index > 0 && index <= products.length)
                    selectedProduct = products[index - 1];
                else
                    System.out.println("Bitte wählen sie ein Produkt das existiert(1 - " + products.length + ")");
            }
            else
                System.out.println("Bitte geben sie eine Nummer ein");
        }

        //Fragen wie oft das Produkt gekauft werden soll
        System.out.print("Menge des Produktes: ");
        int productCount = 0;
        while(productCount <= 0)
        {
            if(input.hasNextInt())
            {
                int num = input.nextInt();
                if(num > 0)
                    productCount = num;
                else
                    System.out.println("Geben sie eine größere Menge an");
            }
            else
                System.out.println("Bitte geben sie eine Nummer ein");
        }

        //Fragen, ob das produkt gekauft werden soll
        System.out.println("Soll das Produkt " + selectedProduct.GetName() + " für " + selectedProduct.GetPrice() * productCount + " gekauft werden?");

        String rIn = input.next();
        String in = rIn.toLowerCase();

        boolean bBuyProduct = in.equals("true") || in.equals("ja") || in.equals("j") || in.equals("1");
        if(bBuyProduct)
            System.out.println("Das Produkt wurde gekauft");
        else
            System.out.println("Der Kauf wurde abgebrochen");
    }
}
