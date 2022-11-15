package it.fi.meucci;

public class Persona 
{
    String nome;
    String cognome;
    String nazioneResidenza;
    
    public Persona() {
    }

    public Persona(String nome, String cognome, String nazioneResidenza) {
        this.nome = nome;
        this.cognome = cognome;
        this.nazioneResidenza = nazioneResidenza;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNazioneResidenza() {
        return nazioneResidenza;
    }

    public void setNazioneResidenza(String nazioneResidenza) {
        this.nazioneResidenza = nazioneResidenza;
    }

    
}
