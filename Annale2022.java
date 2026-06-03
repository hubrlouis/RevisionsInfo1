public class Camelide{
    private int espece;
    private String nom;
    private int charge;

    public Camelide(int e, String n, int p){
        this.espece = e;
        this.nom = n;
        this.charge = p;
    }

    public Camelide(int e, String n){
        this.espece = e;
        this.nom = n;
        this.charge = 1;
    }

    public int getCharge(){
        return this.charge;
    }
    public String toString(){           // Utiliser la méthode Switch
        String s = "";
        String esp == "Esp. inconnue";
        if(this.espece = 0){
            esp = "Chameau";
        }else if(this.espece == 1){
            esp = "Dromadaire";
        }else if(this.espece == 2){
            esp = "Lama";
        }else if(this.espece == 3){
            esp = "Alpaga";
        }

        s = "Camélidé: " + esp + " " + this.nom + " peut porter " + this.charge + " voyageur(s)";
        return s;
    }

    public boolean equals(Camelide c){
        return ((this.nom.equals(c.nom)) && (this.espece == c.espece));
    }

    public static void main(String[] args){
        Camelide syrrius = new Camelide(2, "Syrrius");
        Camelide grenadine = new Camelide(0, "Grenadine", 3);

        // Camélidé: Chameau Coro peut porter 3 voyageurs
        // Camélidé: Chameau Coro peut porter 3 voyageurs
    }
}




public class Caravane{
    public Caravane(String pays){
        this.identifiant = compteurCaravanes;
        compteurCaravanes ++;
        this.pays = pays;
        this.tailleConvoi = 0;
        this.convoi = new Camelide[Caravane.TAILLE_MAX];
    }

    public int getNbMaxVoyageurs(){
        int s = 0;
        if (this.tailleConvoi == 0) return s; // inutile
        for (int i =0; i<this.tailleConvoi; i++){
            s = s + this.convoi[i].getCharge();
        }
        return s;
    }

    public int index(Camelide c){
        for (int i = 0; i < this.tailleConvoi; i++){
            if (this.convoi[i].equals(c)) return i;
        }
        return -1;
    }

    public boolean ajoute(Camelide c){
        boolean r = false;
        if (this.index(c) == -1 && this.tailleConvoi < Caravane.TAILLE_MAX){
            this.convoi[this.tailleConvoi] = c;
            this.tailleConvoi ++;
            r = true;
        }
        return r;
    }

    public int retire(int espece){
        int r = 0;
        int i = 0;
        while(i<this.tailleConvoi){
            if (this.convoi[i].getEspece() == espece){
                this.convoi[i] = this.convoi[tailleConvoi -1];
                this.convoi[tailleConvoi - 1] = null;
                this.tailleConvoi --;
                r++;
            }else{
                i++;
            }
        }
        return r;
    }

    public boolean compatible(Caravane c){
        boolean comp = true;
        for (int i = 0; i<this.tailleConvoi; i++){
            for(int k = 0; k<c.tailleConvoi; k++){
                if(this.convoi[i].equals(c.convoi[k])) comp = false;
            }
        }

        return comp;
    }
}


public class Agence{
    public void supprimeCaravane(int id){
        int position = this.indexCaravane(id);
        if (position != -1){
            for (int k=0; k<this.caravanes[position].getConvoi().length; k++){
                this.camelidesLibres[this.nbCamelidesLibres] = this.caravanes[position].getConvoi()[k];
                this.nbCamelidesLibres++;
            }
            for (int i = position; i<this.nbCaravanes-1; i++){
                this.caravanes[i] = this.caravanes[i+1];
            }
            this.nbCaravanes--;
        }
    }

    public int[] getIdcaravanes(String pays){
        int[] caravanesDansPays = new int[this.nbCaravanes];
        int nbPays = 0;
        for (int i = 0; i<this.nbCaravanes ;i++){
            if (this.caravanes[i].getPays().equals(pays)){
                caravanesDansPays[nbPays] = this.caravanes[i].getIdentifiant();
                nbPays++;
            }
        }
        int[] resultat = new int[nbPays];
        for (int k=0; k<nbPays; k++){
            resultat[k] = caravanesDansPays[k];
        }
        return resultat;
    }


    public void retireEspeceCamelide(String pays, int espece){
        int[] idCaravanes = this.getIdcaravanes(pays);
        Caravane caravaneTemp;
        Camelide[] camelideTempTab;
        for(int i = 0; i<idCaravanes.length; i++){
            caravaneTemp = this.caravanes[this.indexCaravane(idCaravanes[i])];
            camelideTempTab = caravaneTemp.getConvoi();
            for (int k = 0; k<camelideTempTab.length; k++){
                if(camelideTempTab[k].getEspece() == espece){
                    this.camelidesLibres[this.nbCamelidesLibres] = camelideTempTab[k];
                    this.nbCamelidesLibres++;
                }
            }
            caravaneTemp.retire(espece);
        }
    }
}