import java.text.DecimalFormat;
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


        int chance = (int) (Math.random()*100);
        if (chance > 5){
            System.out.println("products ->");
            System.out.println("--------------");
            for (int i = 0; i < products[0].length; i++){
                System.out.println(i+1 + ": " +products[0][i] + " " + products[1][i]);
                System.out.println("--------------");
            }
            Scanner myObj = new Scanner(System.in);
            System.out.println("Witam w naszym sklepie");
            System.out.print("Ile produktów chcesz wybrać: "); int productCount = Integer.parseInt(myObj.nextLine());
            if (productCount > 0 ){
                float cena = 0;
                int[] cart = new int[productCount];
                System.out.println("Wypisz id przedmiotow, ktore chcesz kupić");
                for (int i = 0; i < productCount; i++){
                    System.out.print(i+1 + ": "); cart[i] = Integer.parseInt(myObj.nextLine()) -1;
                    cena+= Float.parseFloat(products[1][cart[i]]);
                }
                System.out.println("Do zapłaty " + cena + " zł");
                System.out.println(":::::::::::::::::");
                System.out.println("Wybierz formę płatności");

               // do {
                    System.out.print("1 -> gotowka ||"); System.out.print(" 2 -> karta ||"); System.out.print(" 3 -> BLIK: ");
                int formaPlatnosci = Integer.parseInt(myObj.nextLine());
               // }while (formaPlatnosci == 1 || formaPlatnosci == 2 || formaPlatnosci == 3);
                switch (formaPlatnosci){
                    case 1:
                        System.out.print("Wpisz ile dałeś kasierowi: "); var banknoty = myObj.nextLine();
                        String gotowkaSplit[] = banknoty.split(",");
                        float gotowka = 0;
                        for (int i = 0; i<gotowkaSplit.length; i++){
                            gotowka += Float.parseFloat(gotowkaSplit[i]);
                        }
                        float reszta = gotowka - cena;
                        if (gotowka >= cena) {
                            if (reszta != 0) {
                                System.out.println("Twoja reszta " + reszta);
                                System.out.println("Miłego dnia!");
                            }else{
                                System.out.println("Dziękuję");
                                System.out.println("Miłego dnia!");
                            }
                        }else {
                            do {
                                DecimalFormat f = new DecimalFormat("##.00");
                                //System.out.println("Niestety "+gotowka+" nie wystarczy, musisz dopłacić "+ f.format((cena - gotowka)));
                                System.out.println("Niestety "+gotowka+" nie wystarczy, musisz dopłacić "+ Math.round(((cena - gotowka) * 100)) / 100.0);
                                System.out.print("Wpisz jakie banknoty dałes (wypisz po przecinku): "); var doplata = myObj.nextLine();
                                System.out.println("");
                                String[] doplataSplit = doplata.split(",");
                                for (int i = 0; i< doplataSplit.length; i++){
                                    gotowka += Float.parseFloat(doplataSplit[i]);
                                }
                                if (reszta == 0){
                                    System.out.println("Dałeś: " + gotowka + "zł");
                                    System.out.println("");
                                }else if (reszta < 0 ){
                                    System.out.println("Dałeś: " + gotowka + "zł jeszcze brakuje: " + doplata + " zł");
                                    System.out.println("");
                                }else if (reszta > 0){
                                    System.out.println("Dałeś: " + gotowka + "zł twoja reszta: " + reszta + " zł");
                                    System.out.println("");
                                }

                            }while (gotowka < cena);
                            System.out.println("Miłego dnia!");
                        }
                        break;
                    case 2:
                        System.out.print("Podaj numer karty: ");
                        var cardNumber = myObj.nextLine();
                        for (int i = 0; i < cards[0].length; i++){
                            if (cards[0][i] == cardNumber){
                                System.out.print("Podaj PIN: "); var pin = myObj.nextLine();
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
                        System.out.print("Podaj kod blik(6 cyfr): ");
                        var blikCode = myObj.nextLine();
                        for (int i = 0; i < blikCodes.length; i++){
                            if (blikCodes[i] == blikCode){
                                System.out.println("Dziękuję za zakupy, miłego dnia!");
                            }else {
                                System.out.println("Error, twój kod blik jest niepoprawny");
                            }
                        }break;
                }

            }
        }else{
            System.out.println("Niestety, ale nie ma zasilania w kasie, zapraszamy jutro");
        }

        }
    }
