package it.fi.meucci;

import java.util.ArrayList;

public class Messaggio 
{
    String nazioneRichiesta;
    ArrayList <Persona> listaPersone = new ArrayList<>();
    

    public Messaggio() {
    }

    public Messaggio(String stringRecived, Class<Messaggio> class1) {
    }

    public Messaggio(ArrayList<Persona> listaPersone) {
        
        this.listaPersone = listaPersone;
    }

    public String getNazioneRichiesta() {
        return nazioneRichiesta;
    }

    public void setNazioneRichiesta(String nazioneRichiesta) {
        this.nazioneRichiesta = nazioneRichiesta;
    }

    public ArrayList<Persona> getListaPersone() {
        return listaPersone;
    }

    public void setListaPersone(ArrayList<Persona> listaPersone) {
        this.listaPersone = listaPersone;
    }

}
