package Projektas;

public class IslaiduIrasas {
    private double suma;
    private int kategorijosIndeksas;
    private String data;
    private String atsiskaitymoBudas;

    private String papildomaInfo;
    public IslaiduIrasas(){

    }
    public IslaiduIrasas(int kategorijosIndeksas,double suma, String data, String atsiskaitymoBudas, String papildomaInfo) {
        this.suma = suma;
        this.kategorijosIndeksas = kategorijosIndeksas;
        this.data = data;
        this.atsiskaitymoBudas = atsiskaitymoBudas;

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

    public String getAtsiskaitymoBudas() {
        return atsiskaitymoBudas;
    }

    public void setAtsiskaitymoBudas(String atsiskaitymoBudas) {
        this.atsiskaitymoBudas = atsiskaitymoBudas;
    }


    public String getPapildomaInfo() {
        return papildomaInfo;
    }

    public void setPapildomaInfo(String papildomaInfo) {
        this.papildomaInfo = papildomaInfo;
    }

    @Override
    public String toString() {
        return  "Operacijos Nr.:= " + kategorijosIndeksas +
                ", Suma= " + suma +
                ", Data= " + data + '\'' +
                ", Atsiskaitymo budas= " + atsiskaitymoBudas + '\'' +
                ", Paskirtis= " + papildomaInfo + '\'';
    }
}
