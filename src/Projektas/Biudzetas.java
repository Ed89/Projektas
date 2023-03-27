package Projektas;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

import static Projektas.Main.pasirinkti;
import static Projektas.Main.scanner;

public class Biudzetas {

    private ArrayList<Irasas> irasas = new ArrayList<>();
    static double isVisoBalansas = 0;

    public double balansas() {
        double pajamuBalansas = 0;
        double islaiduBalansas = 0;
        for (var irasai : irasas) {
            if (irasai instanceof PajamuIrasas) {
                pajamuBalansas += irasai.getSuma();
            } else if (irasai instanceof IslaiduIrasas) {
                islaiduBalansas += irasai.getSuma();
            }
        }

        return isVisoBalansas = pajamuBalansas - islaiduBalansas;
    }


    void pridetiPajamuIrasa(double suma, String data, String papildomaInfo) {
        PajamuIrasas pajamuIrasas = new PajamuIrasas(suma, data, papildomaInfo);
        System.out.println("""
                Gauta i banko saskaita?
                 1- Taip
                 2- Ne\s""");
        int pasirinkimas = (int) pasirinkti();
        switch (pasirinkimas) {
            case 1 -> pajamuIrasas.setGautaISaskaita(true);
            case 2 -> pajamuIrasas.setGautaISaskaita(false);
        }
        irasas.add(pajamuIrasas);


    }

    void pridetiIslaiduIrasa(double suma, String data, String papildomaInfo) {
        IslaiduIrasas islaiduIrasas = new IslaiduIrasas(suma, data, papildomaInfo);
        boolean veiksmas = true;
        while (veiksmas) {
            System.out.print("""
                    Atsiskaitymo budas: 
                    1 -banko kortele
                    2 -grynais
                    Jusu varintas: \s""");

            int pasirinkimas = (int) pasirinkti();
            switch (pasirinkimas) {
                case 1 -> {
                    islaiduIrasas.setAtsiskaitymoBudas("Banko kortele");
                    veiksmas = false;
                }
                case 2 -> {
                    islaiduIrasas.setAtsiskaitymoBudas("Grynais");
                    veiksmas = false;
                }
            }
        }
        irasas.add(islaiduIrasas);
    }

    void Trinimas() {
        System.out.print("Pasirinkite ka istrinsite (trinimas vyksta pagal ID): ");
        int pasirinkimas = (int) pasirinkti();
        for (var irasai : irasas) {
            if (irasai.getKategorijosIndeksas() == pasirinkimas) {
                if (irasai instanceof PajamuIrasas) {
                    isVisoBalansas += irasai.getSuma();
                } else if (irasai instanceof IslaiduIrasas) {
                    isVisoBalansas -= irasai.getSuma();
                }
                irasas.remove(irasai);
            }

        }
    }

    void reduogtiIrasa() {
        System.out.print("Koki irasa norite redaguoti: ");
        int number = (int) pasirinkti();
        for (var irasai : irasas) {
            if (irasai.getKategorijosIndeksas() == number) {

                System.out.println("""
                        Ka norite pakesti: 
                        1 - Suma
                        2 - Data
                        3 - Papildoma informacija
                        4 - Pakeisti irasa, banko saskaita ar grynais""");

                switch ((int) pasirinkti()) {
                    case 1 -> {
                        System.out.println("Iveskite suma");
                        irasai.setSuma(pasirinkti());
                    }
                    case 2 -> {
                        System.out.println("Iveskite data, formatas dd.MM.yyyy");
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy"); //?? output date: yyyy-MM-dd
                        scanner.nextLine();
                        String input = scanner.nextLine();
                        try {
                            LocalDate date = LocalDate.parse(input, formatter);
                            irasai.setData(String.valueOf(date));
                        } catch (DateTimeParseException e) {
                            System.out.println("Netinkamas formatas");
                        }

                    }
                    case 3 -> {
                        System.out.println("Iveskite informacija: ");
                        scanner.nextLine();
                        String text = scanner.nextLine();
                        irasai.setPapildomaInfo(text);

                    }
                    case 4 -> {
                        if (irasai instanceof PajamuIrasas) {
                            PajamuIrasas pajamuIrasas = (PajamuIrasas) irasai;
                            System.out.println("""
                                    Gauta i banko saskaita?
                                    1- Taip
                                    2- Ne\s""");
                            switch ((int) pasirinkti()) {
                                case 1 -> pajamuIrasas.setGautaISaskaita(true);
                                case 2 -> pajamuIrasas.setGautaISaskaita(false);
                            }
                        }
                        if (irasai instanceof IslaiduIrasas) {
                            IslaiduIrasas islaiduIrasas = (IslaiduIrasas) irasai;
                            boolean veiksmas = true;
                            while (veiksmas) {
                                System.out.print("""
                                        Atsiskaitymo budas: 
                                        1 -banko kortele
                                        2 -grynais
                                        Jusu varintas: \s""");

                                int pasirinkimas = (int) pasirinkti();
                                switch (pasirinkimas) {
                                    case 1 -> {
                                        islaiduIrasas.setAtsiskaitymoBudas("Banko kortele");
                                        veiksmas = false;
                                    }
                                    case 2 -> {
                                        islaiduIrasas.setAtsiskaitymoBudas("Grynais");
                                        veiksmas = false;
                                    }
                                }
                            }

                        }
                    }
                }

            }
        }
    }

    public ArrayList<Irasas> gautiPajamuIrasus() {
        ArrayList<Irasas> pajamuIrasai = new ArrayList<>();
        for (Irasas irasai : irasas) {
            if (irasai instanceof PajamuIrasas) {
                pajamuIrasai.add(irasai);
            }
        }
        return pajamuIrasai;
    }

    public ArrayList<Irasas> gautiIslaiduIrasa() {
        ArrayList<Irasas> islaiduIrasai = new ArrayList<>();
        for (Irasas irasai : irasas) {
            if (irasai instanceof IslaiduIrasas) {
                islaiduIrasai.add(irasai);
            }
        }
        return islaiduIrasai;
    }


    public void irasymasFailas() {
        try {
            FileWriter myWriter = new FileWriter("text.txt");

            for (Irasas irasai : irasas) {
                if (irasai instanceof PajamuIrasas) {
                    PajamuIrasas pajamos = (PajamuIrasas) irasai;
                    myWriter.write("P, ID: " + pajamos.getKategorijosIndeksas() + ", Suma: " + pajamos.getSuma() + ", Data: " + pajamos.getData()
                            + ", Informacija: " + pajamos.getPapildomaInfo() + ", Gauta i banka: " + pajamos.isGautaISaskaita()+"\n");
                } else if (irasai instanceof IslaiduIrasas) {
                    IslaiduIrasas islaidos = (IslaiduIrasas) irasai;
                    myWriter.write("I, ID: " + islaidos.getKategorijosIndeksas() + ", Suma: " + islaidos.getSuma() + ", Data: " + islaidos.getData()
                            + ", Informacija: " + islaidos.getPapildomaInfo() + ", Atsiskaitymo budas: " + islaidos.getAtsiskaitymoBudas()+"\n");
                }
            }



            myWriter.close();
            System.out.println("I failo pavyko irasyti.");
        } catch (IOException e) {
            System.out.println("Ivyko irasymo klaida");
            e.printStackTrace();
        }
    }
}

