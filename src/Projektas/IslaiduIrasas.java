package Projektas;

public class IslaiduIrasas extends Irasas {

    private String atsiskaitymoBudas;

    public IslaiduIrasas(double suma, String data, String papildomaInfo) {
        super(suma, data, papildomaInfo);
        this.atsiskaitymoBudas = atsiskaitymoBudas;
    }

    public String getAtsiskaitymoBudas() {
        return atsiskaitymoBudas;
    }

    public void setAtsiskaitymoBudas(String atsiskaitymoBudas) {
        this.atsiskaitymoBudas = atsiskaitymoBudas;
    }

  /*  @Override
    public String toString() {
        return "atsiskaitymoBudas='" + atsiskaitymoBudas;
    }*/
       @Override
    public String toString() {
        return  "Operacijos Nr.: " + getKategorijosIndeksas() +
                ", Suma: " + getSuma() +
                ", Data: " + getData()  +
                ", Paskirtis: " + getPapildomaInfo()+
                ", Atsiskaitymo budas: " + atsiskaitymoBudas;

    }
}
