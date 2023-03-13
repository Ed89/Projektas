package Projektas;

import java.util.Arrays;

public class Biudzetas {
    PajamuIrasas[] pajamos = new PajamuIrasas[100];
    IslaiduIrasas[] islaidos = new IslaiduIrasas[100];


    void pridetiPajamuIrasa(PajamuIrasas pajamuIrasas) {
        for (int i = 0; i < pajamos.length; i++) {
            if (pajamos[i] == null) {
                pajamos[i] = pajamuIrasas;
                break;
            }
        }
    }

    void pridetiIslaiduIrasa(IslaiduIrasas islaiduIrasas) {
        for (int i = 0; i < islaidos.length; i++) {
            if (islaidos[i] == null) {
                islaidos[i] = islaiduIrasas;
                break;
            }
        }
    }

    public PajamuIrasas[] gautiPajamuIrasa() {
        return pajamos;
    }

    public IslaiduIrasas[] gautiIslaiduIrasa() {
        return islaidos;
    }

    @Override
    public String toString() {
        return //"Biudzetas{" +
                "Pajamos=" + Arrays.toString(pajamos) +
                        ", Islaidos=" + Arrays.toString(islaidos);
    }
}
