package Projektas;

import java.util.Objects;

public class Irasas {
private static int count = 0;
    private double suma;
    private int kategorijosIndeksas;
    private String data;

    private String papildomaInfo;

    public Irasas(double suma, String data, String papildomaInfo) {
        this.suma = suma;
        this.kategorijosIndeksas = count++;
        this.data = data;
        this.papildomaInfo = papildomaInfo;
    }

    public Irasas() {
        this.suma = suma;
        this.data = data;
        this.papildomaInfo = papildomaInfo;
    }


    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Irasas.count = count;
    }

    public double getSuma() {
        return suma;
    }

    public void setSuma(double suma) {
        this.suma = suma;
    }

    public int getKategorijosIndeksas() {
        return kategorijosIndeksas;
    }

    public void setKategorijosIndeksas(int kategorijosIndeksas) {
        this.kategorijosIndeksas = kategorijosIndeksas;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getPapildomaInfo() {
        return papildomaInfo;
    }

    public void setPapildomaInfo(String papildomaInfo) {
        this.papildomaInfo = papildomaInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Irasas irasas = (Irasas) o;
        return Double.compare(irasas.suma, suma) == 0 &&
                kategorijosIndeksas == irasas.kategorijosIndeksas &&
                data.equals(irasas.data) && papildomaInfo.equals(irasas.papildomaInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(suma, kategorijosIndeksas, data, papildomaInfo);
    }
}
