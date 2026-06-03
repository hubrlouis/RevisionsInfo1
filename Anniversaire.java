public class Anniversaire {
    private Date date;
    private String nom;
    private String prenom;

    public Date getDate() { return this.date; }
    
    public String toString(){
        return this.prenom + " " + this.nom + " est né(e) le " + this.date;
    }

    public boolean equals(Anniversaire a){
        return (this.prenom == a.prenom && this.nom == a.nom && this.date.equals(a.date));
    }
}
