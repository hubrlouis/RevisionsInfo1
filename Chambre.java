public class Chambre {
    private int numero;
    private boolean libre;
    // Question 1
    public Chambre(int numero){
        this.numero = numero;
        this.libre = true;
    }
    // Question 2
    public int getNumero(){
        return this.numero;
    }
    public boolean getLibre(){
        return this.libre;
    }
    public void setOccupe(){
        this.libre = false;
    }
}
