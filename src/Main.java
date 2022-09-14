import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String[][] products = new String[5][5];
        products[0][0] = "Milk"; products[1][0] = "7.2";
        products[0][1] = "Sugar"; products[1][1] = "5";
        products[0][2] = "Water"; products[1][2] = "2.5";
        products[0][3] = "Bread"; products[1][3] = "6.5";
        products[0][4] = "Ketchup"; products[1][4] = "8.7";

        String[][] cards = new String[3][3];
        cards[0][0] = "1234567891234567"; cards[0][0] = "1234";
        cards[0][1] = "4444444444444444"; cards[1][1] = "4444";
        cards[0][2] = "1221122112211221"; cards[1][2] = "1221";

        String[] blikCodes = new String[5];
        blikCodes[0] = "111111";
        blikCodes[1] = "222222";
        blikCodes[2] = "333333";
        blikCodes[3] = "444444";
        blikCodes[4] = "555555";

        System.out.println("products ->");
        System.out.println("--------------");
        for (int i = 0; i < products[0].length; i++){
            System.out.println(i+1 + ": " +products[0][i] + " " + products[1][i]);
            System.out.println("--------------");
        }
        Scanner myObj = new Scanner(System.in);
        System.out.println("Witam w naszym sklepie");
        System.out.print("Ile produktów chcesz wybrać: "); int productCount = myObj.nextInt();
        if (productCount > 0 ){
            float cena = 0;
            int[] cart = new int[productCount];
            System.out.println("Wypisz id przedmiotow, ktore chcesz kupić");
            for (int i = 0; i < productCount; i++){
                System.out.print(i+1 + ": "); cart[i] = myObj.nextInt() - 1;
                cena+= Float.parseFloat(products[1][i]);
            }
            System.out.println("Do zapłaty " + cena + " zł");
            System.out.println(":::::::::::::::::");
            System.out.println("Wybierz formę płatności");
            System.out.print("1 -> gotowka ||"); System.out.print(" 2 -> karta ||"); System.out.print(" 3 -> BLIK: "); int formaPlatnosci = myObj.nextInt();

            switch (formaPlatnosci){
                case 1:
                    System.out.print("Wpisz ile dałeś kasierowi: "); float gotowka = myObj.nextFloat();
                    float reszta = gotowka - cena;
                    if (gotowka > cena) {
                    System.out.println("Twoja reszta " + reszta);
                    System.out.println("Miłego dnia!");
                }else if(gotowka == cena){

                }else {
                        do {
                            System.out.println("Niestety to nie wystarczy, musisz dopłacić");
                            System.out.print("Wpisz ile dałeś kasierowi: "); float doplata = myObj.nextFloat();
                            gotowka += doplata;
                        }while (gotowka >= cena);
                        System.out.println("Miłego dnia!");
                    }
                    break;
                case 2:
                    System.out.print("Podaj numer karty: "); String cardNumber = myObj.nextLine();
                    for (int i = 0; i < cards[0].length; i++){
                        if (cards[0][i] == cardNumber){
                            System.out.print("Podaj PIN: "); String pin = myObj.nextLine();
                            for (int j = 0; j < cards[1].length; j++){
                                if (cards[1][j] == pin){
                                    System.out.println("Zaakceptowano kartę, miłego dnia! ");
                                }else {
                                    System.out.println("Error, twój pin jest niepoprawny");
                                }
                            }
                        }else {
                            System.out.println("ErrorError, twój numer karty jest niepoprawny");
                        }
                    }
                    break;
                case 3:
                    System.out.print("Podaj kod blik(6 cyfr): "); String blikCode = myObj.nextLine();
                    for (int i = 0; i < blikCodes.length; i++){
                        if (blikCodes[i] == blikCode){
                            System.out.println("Dziękuję za zakupy, miłego dnia!");
                        }else {
                            System.out.println("Error, twój kod blik jest niepoprawny");
                        }
                    }break;
                }

            }
        }
    }
