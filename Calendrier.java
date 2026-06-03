public class Calendrier {
    private int taille;
    private Anniversaire[] anniversaires;
    private int nbElem;

    public Calendrier(int taille){
        this.taille = taille;
        this.anniversaires = new Anniversaire[taille];
        this.nbElem = 0;
    }

    private int indice(Anniversaire a){
        int i = -1;
        while (i < this.nbElem && !this.anniversaires[i].equals(a)){
            i++;
        }
        return i;
    }

    public void ajouter(Anniversaire a){
        if(this.indice(a) == -1){
            if (this.nbElem<this.taille){
                this.anniversaires[this.nbElem] = a;
                this.nbElem++;
            }else{
                Anniversaire[] newTab = new Anniversaire[this.taille*2];
                for (int i = 0; i < this.taille; i++){
                    newTab[i] = this.anniversaires[i];
                }
                this.anniversaires = newTab;
                this.taille = this.taille*2;
                this.anniversaires[this.nbElem] = a;
                this.nbElem++;
            }
        }
    }

    public boolean supprimer(Anniversaire a){
        if(this.indice(a) == -1) return false;
        this.anniversaires[this.indice(a)] = this.anniversaires[this.nbElem-1];
        this.anniversaires[this.nbElem-1] = null;
        this.nbElem--;
        if (this.nbElem < this.taille/3){
            Anniversaire[] newTab = new Anniversaire[this.taille/2];
            for (int k = 0; k < this.nbElem; k++){
                newTab[k] = this.anniversaires[k];
            }
            this.anniversaires = newTab;
            this.taille = this.taille/2;
        }
        return true;
    }

    public Anniversaire[] memeJour(int jour){
        Anniversaire[] resTemp = new Anniversaire[this.nbElem];
        int compteur = 0;
        for(int i = 0; i<this.nbElem; i++){
            if (this.anniversaires[i].getDate().getJour() == jour){
                resTemp[compteur] = this.anniversaires[i];
                compteur++;
            }
        }

        Anniversaire[] res = new Anniversaire[compteur];
        for (int j = 0; j<compteur; j++){
            res[j] = resTemp[j];
        }
        return res;
    }

    private Anniversaire premier(){
        if (this.nbElem == 0) return null;
        Anniversaire res = this.anniversaires[0];
        for (int i=0; i<this.nbElem; i++){
            if (this.anniversaires[i].getDate().compareTo(res.getDate()) < 0){
                res = this.anniversaires[i];    
            }
        }
        return res;
    }

    private Anniversaire suivantDansLannee(Anniversaire a) {
        if (a == null || this.nbElem == 0) return null;

        Anniversaire meilleurCandidat = null;

        for (int i = 0; i < this.nbElem; i++) {
            Anniversaire actuel = this.anniversaires[i];
            
            // Est-ce qu'il est après 'a' dans l'année ?
            if (actuel.getDate().compareTo(a.getDate()) == 1) {
                // Si c'est notre tout premier candidat trouvé, ou s'il est plus proche de 'a' que le précédent sélectionné
                if (meilleurCandidat == null || actuel.getDate().compareTo(meilleurCandidat.getDate()) == -1) {
                    meilleurCandidat = actuel;
                }
            }
        }

        return meilleurCandidat;
    }

    public Anniversaire anniversaireSuivant(Anniversaire a){
        Anniversaire suivant = this.suivantDansLannee(a);
        if (suivant != null) return suivant;
        return this.premier();
    }
}