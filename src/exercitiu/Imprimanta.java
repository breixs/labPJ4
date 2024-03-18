package exercitiu;

import java.io.Serializable;
import java.util.Objects;

class Imprimanta extends EchipamenteElectronice implements Serializable {
    private int ppm;
    private String rezolutie;
    private int p_car;
    private String mod;
    enum Mod_tiparire
    {
        COLOR,
        ALB_NEGRU
    }

    public void setMod(String modNou)
    {
        this.mod=modNou;
    }


    Imprimanta(String denumire, int nr_inv, float pret, String zona_mag, String situatie, int ppm, String rezolutie, int p_car, String mod_tip)
    {
        super(denumire, nr_inv, pret, zona_mag, situatie);
        this.ppm=ppm;
        this.rezolutie=rezolutie;
        this.p_car=p_car;
        if(Objects.equals(mod_tip, "COLOR"))
        {
            Mod_tiparire var=Mod_tiparire.COLOR;
            mod= String.valueOf(var);
        }
        if(Objects.equals(mod_tip, "ALB_NEGRU"))
        {
            Mod_tiparire var=Mod_tiparire.ALB_NEGRU;
            mod= String.valueOf(var);
        };
    }

    public String toString()
    {
        return getDenumire()+" "+getNrInv()+" "+getPret()+" "+getZona_mag()+" "+getSituatie()+" "+ppm+" "+rezolutie+" "+p_car+" "+mod;
    }

}
