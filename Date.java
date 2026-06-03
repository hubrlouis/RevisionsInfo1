public class Date {
    private int jour;
    private int mois;
    private int annee;
    private static final String[] MOIS_NOMS = { 
        "janvier", "fevrier", "mars", "avril", "mai", "juin", 
        "juillet", "aout", "septembre", "octobre", "novembre", "decembre" 
    };
    private static final int[] MOIS_NB_JOURS = { 
        31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
    };

    public Date(int jour, int mois, int annee){
        this.jour = jour;
        this.mois = mois;
        this.annee = annee;
    }

    public int getJour() { return this.jour; }
    public int getMois() { return this.mois; }
    public int getAnnee() { return this.annee; }

    public boolean equals(Date d){
        return (this.jour == d.jour && this.mois == d.mois && this.annee == d.annee);
    }

    public int compareTo(Date d){
        int r = 0;
        if (this.mois < d.mois){
            r = -1;
        }else if (this.mois > d.mois){
            r = 1;
        }else{
            if (this.jour < d.jour) r = -1;
            if (this.jour > d.jour) r = 1;
        }
        return r;
    }
    public String toString() {
        // Si this.mois vaut 12, on cherche MOIS_NOMS[11] qui est "decembre"
        String stringMois = Date.MOIS_NOMS[this.mois - 1];
        
        return this.jour + " " + stringMois + " " + this.annee;
    }

    public boolean estValide(){
        if(this.mois > 12 || this.mois < 1) return false;
        if (this.jour > Date.MOIS_NB_JOURS[this.mois - 1] || this.jour < 1) return false;
        return true;
    }

    /* Réponse à la Q6
    D1 : 7 juin 2025
    D2 7 juin 2025

    Imprimera : 
    Date 1: 7 juin 2025
    Comparaison A : false
    Comparaison B:  true
    Comparaison C: true
    Comparaison D: true
    */

    public static void main(String[] args){
        Date d1 = new Date(7,6,2026);
        System.out.println(d1);
        System.out.println("Date 1: " + d1);
    }
}
