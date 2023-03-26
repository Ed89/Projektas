package Projektas;

import java.util.ArrayList;
import java.util.Arrays;

public class Biudzetas {
    //PajamuIrasas[] pajamos = new PajamuIrasas[100];
    ArrayList<PajamuIrasas> pajamos = new ArrayList<>();
    //IslaiduIrasas[] islaidos = new IslaiduIrasas[100];
    ArrayList<IslaiduIrasas> islaidos = new ArrayList<>();

    public double balansas() {
        double pajamuBalansas = 0;
        double islaiduBalansas = 0;
        for (var pajamuIrasas : pajamos) {
            pajamuBalansas += pajamuIrasas.getSuma();
        }
        for (var islaiduIrasas : islaidos) {
            islaiduBalansas += islaiduIrasas.getSuma();
        }
        return (float)pajamuBalansas - islaiduBalansas;
    }

    void pridetiPajamuIrasa(PajamuIrasas pajamuIrasas) {
        pajamos.add(pajamuIrasas);
    }

    void pridetiIslaiduIrasa(IslaiduIrasas islaiduIrasas) {
        islaidos.add(islaiduIrasas);
    }

    public ArrayList<PajamuIrasas> gautiPajamuIrasa() {
        return pajamos;
    }

    public ArrayList<IslaiduIrasas> gautiIslaiduIrasa() {
        return islaidos;
    }


    @Override
    public String toString() {
        return "Pajamos=" + pajamos + ", Islaidos=" + islaidos;
    }

}
