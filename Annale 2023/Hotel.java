public class Hotel {
    // Question 3
    private String nom;
    private String lieu;
    private Chambre[] chambres;

    public Hotel(String nom, String lieu, Chambre[] chambres){
        this.nom = nom;
        this.lieu = lieu;
        this.chambres = chambres;
    }
    // Question 4
    public int trouverChambre(int numero){
        int r = -1;
        for (int i = 0; i<this.chambres.length; i++){
            if (this.chambres[i].getNumero() == numero){
                r = i;
            }
        }
        return r;
    }

    // Question 5
    public void reserver(int numero){
        int i = trouverChambre(numero);
        if (i != -1){
            if (this.chambres[i].getLibre()){
                this.chambres[i].setOccupe();
            } else {
                System.out.println("La chambre n°" + numero + " n'est pas disponible");
            }
        } else {
            System.out.println("La chambre n°" + numero + " n'a pas été trouvée");
        }
    }
}
