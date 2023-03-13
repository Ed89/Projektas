package Projektas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    static int PajamuIndeksas = 1;
    static int IslaiduIndeksas = 1;
    static byte pasirinkimas;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Biudzetas biudzetas = new Biudzetas();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = date.format(formatter);
        boolean veiksmas = true;

       while (veiksmas){
           System.out.print("""
                   Programa yra interaktyvi...
                   1 - Ivesti pajamos
                   2 - Ivesti islaidos
                   3 - Gauti pajamos info
                   4 - Gauti islados info
                   5 - baigti programa
                   Koks Jusu pasirinkimas: \s """);
           pasirinkimas = scanner.nextByte();
           switch (pasirinkimas){
               case 1 -> PajamuIndeksas = pajamuIrasymas(scanner, PajamuIndeksas, biudzetas, formattedDate);
               case 2 ->IslaiduIndeksas = islaiduIrasymas(scanner, IslaiduIndeksas, biudzetas, formattedDate);
               case 3 -> gautiPajamosInfo(biudzetas);
               case 4 -> gautiIslaiduInfo(biudzetas);
               case 5 -> veiksmas=false;
           }
       }



    }




    private static int islaiduIrasymas(Scanner scanner, int islaiduIndeksas, Biudzetas biudzetas, String formattedDate) {
        System.out.print("Iveskite suma: ");
        double suma = scanner.nextDouble();
        boolean veiksmas =true;
        String atsiskaitymoBudas = "";
        while (veiksmas){
                System.out.print("""
                Atsiskaitymo budas: 
                1 -banko kortele
                2 -grynais
                Jusu varintas: \s""");
        pasirinkimas = scanner.nextByte();
        switch (pasirinkimas){
            case 1-> {
                atsiskaitymoBudas = "Banko kortele";
                veiksmas = false;
            }
            case 2-> {
                atsiskaitymoBudas = "Grynais";
                veiksmas = false;
            }
            default -> System.out.println("Blogas pasirinkimas");
        }
        }
        System.out.print("Iveskite islaidu paskirtis: ");
        scanner.nextLine();
        String info = scanner.nextLine();
        biudzetas.pridetiIslaiduIrasa(new IslaiduIrasas(islaiduIndeksas++, suma, formattedDate, atsiskaitymoBudas, info));
        return islaiduIndeksas;
    }

    private static int pajamuIrasymas(Scanner scanner, int PajamuIndeksas, Biudzetas biudzetas, String formattedDate) {
        System.out.print("Iveskite suma: ");
        double suma = scanner.nextDouble();
        System.out.print("Iveskite papildoma info: ");
        scanner.nextLine();
        String info = scanner.nextLine();
        biudzetas.pridetiPajamuIrasa(new PajamuIrasas(PajamuIndeksas++, suma, formattedDate, true, info));
        return PajamuIndeksas;
    }

    private static void gautiPajamosInfo(Biudzetas biudzetas) {
        for (int i = 0; i < biudzetas.gautiPajamuIrasa().length; i++) {
            if (biudzetas.gautiPajamuIrasa()[i] != null) {
                System.out.println(biudzetas.gautiPajamuIrasa()[i]);
            }
    }

    }
    private static void gautiIslaiduInfo(Biudzetas biudzetas) {
        for (int i = 0; i < biudzetas.gautiIslaiduIrasa().length; i++) {
            if (biudzetas.gautiIslaiduIrasa()[i] != null) {
                System.out.println(biudzetas.gautiIslaiduIrasa()[i]);
            }
        }
    }

}
