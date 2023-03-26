package Projektas;

public class PajamuIrasas extends Irasas{

    private boolean gautaISaskaita;

   public PajamuIrasas(){
       super();
       this.gautaISaskaita = gautaISaskaita;
   }


    public PajamuIrasas(double suma, String data, String papildomaInfo) {
        super(suma, data, papildomaInfo);
        this.gautaISaskaita = gautaISaskaita;
    }

    public boolean isGautaISaskaita() {
        return gautaISaskaita;
    }

    public  void setGautaISaskaita(boolean gautaISaskaita) {
        this.gautaISaskaita = gautaISaskaita;
    }

    @Override
    public String toString() {
        return  "Operacijos Nr.: " + getKategorijosIndeksas() +
                ", Suma: "+ getSuma() +
                ", Data: " + getData()+
                ", Papildoma informacija: " + getPapildomaInfo()+
                ", Gauta i banko saskaita: " + gautaISaskaita ;
    }

}

