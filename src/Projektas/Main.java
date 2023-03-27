package Projektas;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;



public class Main {

    static int pasirinkimas;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        Biudzetas biudzetas = new Biudzetas();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String formattedDate = date.format(formatter);
        boolean veiksmas = true;


        while (veiksmas) {
            System.out.print("""
                    Programa yra interaktyvi...
                    1 - Ivesti pajamos
                    2 - Ivesti islaidos
                    3 - Gauti pajamu informacija
                    4 - Gauti islaidu informacija
                    5 - Jusu balansas
                    6 - Pasalinti irasa
                    7 - Redauoti irasa
                    8 - Darbas su failu
                    9 - Baigti programa
                    Koks Jusu pasirinkimas: \s """);

            pasirinkimas = (int) pasirinkti();
            switch (pasirinkimas) {

                case 1 -> PridetiPajamos(biudzetas, formattedDate);
                case 2 -> PridetiIslaidu(biudzetas, formattedDate);
                case 3 -> gautiPajamuInfo(biudzetas);
                case 4 -> gautiIslaiduInfo(biudzetas);
                case 5 -> System.out.printf("Jusu balansas: %.2f eu\n", biudzetas.balansas());
                case 6 -> istrintiIrasa(biudzetas);
                case 7 -> redagavimas(biudzetas);
                case 8 -> darbasSuFailu(biudzetas);
                case 9 -> veiksmas = false;
            }
        }

    }

    private static void darbasSuFailu(Biudzetas biudzetas) {
        System.out.print("""
                Koki veiksma norite atlikti:
                1 - irasyti i faila
                2 - nuskaityti is failo
                Jusu variantas: \s""");
        pasirinkimas = (int) pasirinkti();
        switch (pasirinkimas){
            case 1 -> irasymas(biudzetas);
            case 2 -> nuskaitymas();
        }
    }

    private static void nuskaitymas() {
        try {
            File myObj = new File("text.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Nepavyko nuskaityti is failo");
            e.printStackTrace();
        }
    }

    private static void irasymas(Biudzetas biudzetas) {
     biudzetas.irasymasFailas();
    }


    private static void redagavimas(Biudzetas biudzetas) {
        gautiPajamuInfo(biudzetas);
        gautiIslaiduInfo(biudzetas);
        biudzetas.reduogtiIrasa();
    }


    private static void PridetiIslaidu(Biudzetas biudzetas, String formattedDate) {

        System.out.print("Iveskite suma: ");
        double suma = pasirinkti();

        System.out.print("Iveskite islaidu paskirtis: ");
        scanner.nextLine();
        String info = scanner.nextLine();
        biudzetas.pridetiIslaiduIrasa(suma, formattedDate, info);

    }

    private static void PridetiPajamos(Biudzetas biudzetas, String formattedDate) {
        System.out.print("Iveskite suma: ");
        double suma = pasirinkti();
        System.out.print("Iveskite papildoma info: ");
        scanner.nextLine();
        String info = scanner.nextLine();
        biudzetas.pridetiPajamuIrasa(suma, formattedDate, info);
    }

    private static void gautiPajamuInfo(Biudzetas biudzetas) {
        System.out.println("Pajamu irasai: ");
        for (var pajamos : biudzetas.gautiPajamuIrasus()) {
            System.out.println(pajamos);
        }
    }

    private static void gautiIslaiduInfo(Biudzetas biudzetas) {
        System.out.println("Islaidu irasai: ");
        for (var islaidai : biudzetas.gautiIslaiduIrasa()) {
            System.out.println(islaidai);
        }
    }

    public static double pasirinkti() {
        while (true) {
            if (scanner.hasNextInt()) {
                return scanner.nextInt();

            } else if (scanner.hasNextDouble()) {
                return scanner.nextDouble();
            } else {
                scanner.next();
                System.out.println("Klaida, blogas ivedimas, bandikyte dar karta");
            }
        }
    }

    private static void istrintiIrasa( Biudzetas biudzetas) {
        gautiPajamuInfo(biudzetas);
        gautiIslaiduInfo(biudzetas);
        biudzetas.Trinimas();
    }


}
