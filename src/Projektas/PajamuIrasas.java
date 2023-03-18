package Projektas;

public class PajamuIrasas {
    private double suma;
    private int kategorijosIndeksas;
    private String data;
    private boolean gautaISaskaita;
    private String papildomaInfo;
    public PajamuIrasas(){

    }
    public PajamuIrasas(int kategorijosIndeksas, double suma, String data, boolean gautaISaskaita, String papildomaInfo) {
        this.suma = suma;
        this.kategorijosIndeksas = kategorijosIndeksas;
        this.data = data;
        this.gautaISaskaita = gautaISaskaita;
        this.papildomaInfo = papildomaInfo;
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

    public boolean isGautaISaskaita() {
        return gautaISaskaita;
    }

    public void setGautaISaskaita(boolean gautaISaskaita) {
        this.gautaISaskaita = gautaISaskaita;
    }

    public String getPapildomaInfo() {
        return papildomaInfo;
    }

    public void setPapildomaInfo(String papildomaInfo) {
        this.papildomaInfo = papildomaInfo;
    }

    @Override
    public String toString() {
        return "Operacijos Nr.:= " + kategorijosIndeksas  +
                ", Suma= " + suma +
                ", Data= " + data +
                ", Operacijos paskirtis= " + papildomaInfo;
    }
}

