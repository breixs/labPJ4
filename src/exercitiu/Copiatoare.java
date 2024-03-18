package exercitiu;

import java.io.Serializable;
import java.util.Objects;

public class Copiatoare extends EchipamenteElectronice implements Serializable {
    private int p_ton;
    private String form;
    enum Format{
        A3,
        A4
    }

    public void setForm(String newForm)
    {
        this.form=newForm;
    }
    public Copiatoare(String denumire, int nr_inv, float pret, String zona_mag, String sit, int p_ton, String form) {
        super(denumire, nr_inv, pret, zona_mag, sit);
        this.p_ton=p_ton;
        if(Objects.equals(form, "A3"))
        {
            Format var=Format.A3;
            this.form= String.valueOf(var);
        }
        else if(Objects.equals(form,"A4")) {
            Format var = Format.A4;
            this.form= String.valueOf(var);
        };
    }
    public String toString()
    {
        return getDenumire()+" "+getNrInv()+" "+getPret()+" "+getZona_mag()+" "+getSituatie()+" "+p_ton+" "+form;
    }
}
