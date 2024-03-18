package exercitiu;

import java.util.Objects;
import java.io.Serializable;

/**
 * Clasa EchipamenteElectronice este clasa de baza care contine denumirea, nr de inventar, pretul, zona magazinului si situatia tuturor echipamentelor
 * @author Brei Paul
 * @version 1
 * @since 2024
 */

public class EchipamenteElectronice implements Serializable{
    private String denumire;
    private int nr_inv;
    private float pret;
    private String zona_mag;
    private String situatie;

    enum Situatie{
    ACHZITIONAT,
        EXPUS,
        VANDUT
    }
    public String getDenumire()
    {
        return denumire;
    }
    public int getNrInv(){
        return nr_inv;
    }
    public float getPret(){
        return pret;
    }
    public String getZona_mag()
    {
        return zona_mag;
    }
    public String getSituatie()
    {
        return situatie;
    }
    public EchipamenteElectronice(String denumire, int nr_inv, float pret, String zona_mag, String sit)
    {
        this.denumire=denumire;
        this.nr_inv=nr_inv;
        this.pret=pret;
        this.zona_mag=zona_mag;
        if(Objects.equals(sit, "ACHIZITIONAT"))
        {
            Situatie var=Situatie.ACHZITIONAT;
            situatie= String.valueOf(var);
        }
        else if(Objects.equals(sit, "EXPUS"))
        {
            Situatie var=Situatie.EXPUS;
            situatie= String.valueOf(var);
        }
        else if(Objects.equals(sit, "VANDUT"))
        {
            Situatie var=Situatie.VANDUT;
            situatie= String.valueOf(var);
        }
    }

    public void setSitutaie(String sitNoua)
    {
        this.situatie=sitNoua;
    }

    @Override
    public String toString(){
        return denumire+" "+nr_inv+" "+pret+" "+zona_mag+" "+situatie;
    }
}
