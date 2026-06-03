public class Joueur {
    private String nom;
    private String club;
    private int classement;

    public Joueur(String nom, String club){
        this.nom = nom;
        this.club = club;
        this.classement = 40;
    }

    public void gagneMatch(Joueur j){
        int classementGagnant = this.classement;
        int classementPerdant = j.classement;
        int diff = classementGagnant - classementPerdant;
        int points = 0;
        if (diff < -30){ points = 5;}
        if (diff >= -30 && diff < -10){ points = 4;}
        if (diff >= -10 && diff < 10){ points = 3;}
        if (diff >= 10 && diff < 30){ points = 2;}
        if (diff >= 30){ points = 1;}
        this.classement += points;
    }

    public String toString(){
        return "Joueur: " + this.nom + " club: " + this.club + " classement: " + this.classement;
    }

    public boolean equals(Joueur j){
        return this.nom.equals(j.nom) && this.club.equals(j.club);
    }
}
