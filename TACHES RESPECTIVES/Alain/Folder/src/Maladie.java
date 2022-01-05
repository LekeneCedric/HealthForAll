public class Maladie {

    private String nom_maladie;
    private int count = 0 ;

    public Maladie(String nommaladie)
    {
        this.nom_maladie = nommaladie;
    }
    public  Maladie()
    {
        this.nom_maladie = "Maladie INCONNU";
    }

    public void setNom_maladie(String maladie)
    {
        this.nom_maladie = maladie;
    }

    public void setcount(int count)
    {
        this.count = count;
    }
    public String getNom_maladie()
    {
        return this.nom_maladie;
    }

    public  int getcount()
    {
        return this.count;
    }

}
