import java.util.Arrays;

public class Club {
    private String nom;
    private int nbJoueurs;
    private Joueur[] joueurs;
    public static int NB_MAX_JOUEURS = 300;
    // Question 10
    public Club(String nom){
        this.nom = nom;
        this.nbJoueurs = 0;
        this.joueurs = new Joueur[NB_MAX_JOUEURS];
    }
    // Question 11
    public Club(String nom, Joueur[] joueurs){
        this.nom = nom;
        this.nbJoueurs = joueurs.length;
        this.joueurs = new Joueur[NB_MAX_JOUEURS];
        for (int i = 0; i<this.nbJoueurs; i++){
            this.joueurs[i] = joueurs[i];
        }
    }

    // Question 12
    public void creationJoueur(String nomJoueur){
        if (this.nbJoueurs < NB_MAX_JOUEURS){
            if(this.estPresent(nomJoueur) != -1){
                System.out.println("Le joueur " + nomJoueur + " est déjà présent dans le club " + this.nom + ".");
            } else {
                Joueur j = new Joueur(nomJoueur, this.nom);
                this.joueurs[this.nbJoueurs] = j;
                this.nbJoueurs++;
            }
        } else {
            System.out.println("Le club " + this.nom + " a atteint le nombre maximum de joueurs.");
        }
    }

    // Question 13
    public void suppressionJoueur(String nomJoueur){
        int position = this.estPresent(nomJoueur);
        if (position != -1){
            this.joueurs[position] = this.joueurs[this.nbJoueurs-1];
            this.joueurs[this.nbJoueurs-1] = null;
            this.nbJoueurs--;
        }
    }

    // Question 14
    public int meilleurClassement(){
        int meilleur = 0;
        for (int i = 0; i<this.nbJoueurs; i++){
            if (this.joueurs[i].getClassement() > meilleur){
                meilleur = this.joueurs[i].getClassement();
            }
        }
        return meilleur;
    }

    // Question 15
    public Joueur[] lesMeilleurs(){
        int meilleur = this.meilleurClassement();
        int nbMeilleurs = 0;
        Joueur[] meilleursTemp = new Joueur[this.nbJoueurs];
        for (int i = 0; i< this.nbJoueurs; i++){
            if (this.joueurs[i].getClassement() == meilleur){
                meilleursTemp[nbMeilleurs] = this.joueurs[i];
                nbMeilleurs++;

            }
        }
        return Arrays.copyOf(meilleursTemp, nbMeilleurs);
    }

    
}
