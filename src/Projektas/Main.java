package Projektas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    static int PajamuIndeksas = 0;
    static int IslaiduIndeksas = 0;
    static int pasirinkimas;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {



        Biudzetas biudzetas = new Biudzetas();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = date.format(formatter);
        boolean veiksmas = true;

        biudzetas.pridetiIslaiduIrasa(new IslaiduIrasas(IslaiduIndeksas++, 2.2, formattedDate, "Banko kortele", "skola"));
        biudzetas.pridetiIslaiduIrasa(new IslaiduIrasas(IslaiduIndeksas++, 12.2, formattedDate, "Banko kortele", "skola"));
        biudzetas.pridetiIslaiduIrasa(new IslaiduIrasas(IslaiduIndeksas++, 122.2, formattedDate, "Banko kortele", "skola"));
        biudzetas.pridetiIslaiduIrasa(new IslaiduIrasas(IslaiduIndeksas++, 1.2, formattedDate, "Banko kortele", "skola"));
        biudzetas.pridetiIslaiduIrasa(new IslaiduIrasas(IslaiduIndeksas++, 16.2, formattedDate, "Banko kortele", "skola"));

        biudzetas.pridetiPajamuIrasa(new PajamuIrasas(PajamuIndeksas++, 2.3, formattedDate, true, "uz darba"));
        biudzetas.pridetiPajamuIrasa(new PajamuIrasas(PajamuIndeksas++, 12.3, formattedDate, true, "uz darba"));
        biudzetas.pridetiPajamuIrasa(new PajamuIrasas(PajamuIndeksas++, 33.1, formattedDate, true, "uz darba"));
        biudzetas.pridetiPajamuIrasa(new PajamuIrasas(PajamuIndeksas++, 10.5, formattedDate, true, "uz darba"));
        biudzetas.pridetiPajamuIrasa(new PajamuIrasas(PajamuIndeksas++, 30.7, formattedDate, true, "uz darba"));


        while (veiksmas) {
            System.out.print("""
                    Programa yra interaktyvi...
                    1 - Ivesti pajamos
                    2 - Ivesti islaidos
                    3 - Gauti pajamos info
                    4 - Gauti islados info
                    5 - jusu balansas
                    6 - pasalinti irasa
                    7 - baigti programa
                    Koks Jusu pasirinkimas: \s """);

            pasirinkimas = (int)pasirinkti();
            switch (pasirinkimas) {
                case 1 -> PajamuIndeksas = pajamuIrasymas(scanner, PajamuIndeksas, biudzetas, formattedDate);
                case 2 -> IslaiduIndeksas = islaiduIrasymas(scanner, IslaiduIndeksas, biudzetas, formattedDate);
                case 3 -> gautiPajamosInfo(biudzetas);
                case 4 -> gautiIslaiduInfo(biudzetas);
                case 5 -> System.out.printf("%.2f ",biudzetas.balansas());
                case 6 -> istrintiIrasa(biudzetas);
                case 7 -> veiksmas = false;
            }
        }

    }

    private static double pasirinkti() {


        while (true) {
            if (scanner.hasNextInt()) {
              return scanner.nextInt();

            }
            else if(scanner.hasNextDouble()){
                return scanner.nextDouble();
            }
            else {
                scanner.next();
                System.out.println("Klaida, blogas ivedimas, bandikyte dar karta");
            }
        }

    }

    private static void istrintiIrasa( Biudzetas biudzetas) {
        System.out.println("""
                Ka norite pasalinti?
                1 - pajamos
                2 - islaidos:\s""");
        pasirinkimas = (int) pasirinkti();
        switch (pasirinkimas){
            case 1 -> istrintiIrasaPajamos(biudzetas);
            case 2 -> istrintiIrasaIslaidos(biudzetas);
            default -> System.out.println("Klaida");
        }
    }



    private static void istrintiIrasaPajamos(Biudzetas biudzetas) {
        gautiPajamosInfo(biudzetas);
        System.out.println("Pasirinkite ka istrinsite (trinimas vyksta pagal ID)");
        pasirinkimas = (int)pasirinkti();
        for (int i = 0; i < biudzetas.gautiPajamuIrasa().size(); i++) {
            if (biudzetas.gautiPajamuIrasa().get(i).getKategorijosIndeksas() == pasirinkimas) {
                biudzetas.gautiPajamuIrasa().remove(i);
                break;
            }
        }

    }

    private static void istrintiIrasaIslaidos(Biudzetas biudzetas) {
        gautiIslaiduInfo(biudzetas);
        System.out.println("Pasirinkite ka istrinsite (trinimas vyksta pagal ID)");
        pasirinkimas = (int)pasirinkti();

        for (int i = 0; i < biudzetas.gautiIslaiduIrasa().size(); i++) {
            if (biudzetas.gautiIslaiduIrasa().get(i).getKategorijosIndeksas() == pasirinkimas) {
                biudzetas.gautiIslaiduIrasa().remove(i);
                break;
            }
        }

    }


    private static int islaiduIrasymas(Scanner scanner, int islaiduIndeksas, Biudzetas biudzetas, String formattedDate) {
        System.out.print("Iveskite suma: ");
        double suma = pasirinkti();
        boolean veiksmas = true;
        String atsiskaitymoBudas = "";
        while (veiksmas) {
            System.out.print("""
                    Atsiskaitymo budas: 
                    1 -banko kortele
                    2 -grynais
                    Jusu varintas: \s""");

            pasirinkimas = (int)pasirinkti();
            switch (pasirinkimas) {
                case 1 -> {
                    atsiskaitymoBudas = "Banko kortele";
                    veiksmas = false;
                }
                case 2 -> {
                    atsiskaitymoBudas = "Grynais";
                    veiksmas = false;
                }

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
        double suma = pasirinkti();
        System.out.print("Iveskite papildoma info: ");
        scanner.nextLine();
        String info = scanner.nextLine();
        biudzetas.pridetiPajamuIrasa(new PajamuIrasas(PajamuIndeksas++, suma, formattedDate, true, info));
        return PajamuIndeksas;
    }

    private static void gautiPajamosInfo(Biudzetas biudzetas) {
        System.out.println("Jusu pajamu informacija: ");
        for (var pajmos : biudzetas.gautiPajamuIrasa()) {
            System.out.println(pajmos);
        }

    }

    private static void gautiIslaiduInfo(Biudzetas biudzetas) {
        System.out.println("Jusu islaidu informacija: ");
        for (var islaidos : biudzetas.gautiIslaiduIrasa()) {
            System.out.println(islaidos);
        }
    }


}
