package exercitiu;

import java.io.Serializable;
import java.util.Objects;

public class SistemeDeCalcul extends EchipamenteElectronice implements Serializable {
    private String tip_mon;
    private float vit_proc;
    private int c_hdd;
    private String sist;
    enum SistemeDeOperare
    {
        LINUX,
        WINDOWS
    }
    public void setSist(String newSist)
    {
        this.sist=newSist;
    }
    public SistemeDeCalcul(String denumire, int nr_inv, float pret, String zona_mag, String sit, String tip_mon, float vit_proc, int c_hdd, String sist) {
        super(denumire, nr_inv, pret, zona_mag, sit);
        this.tip_mon=tip_mon;
        this.vit_proc=vit_proc;
        this.c_hdd=c_hdd;
        if(Objects.equals(sist, "LINUX")) {
            SistemeDeOperare var = SistemeDeOperare.LINUX;
            this.sist= String.valueOf(var);
        }
        else
        {
            SistemeDeOperare var=SistemeDeOperare.WINDOWS;
            this.sist= String.valueOf(var);
        }

    }
    public String toString()
    {
        return getDenumire()+" "+getNrInv()+" "+getPret()+" "+getZona_mag()+" "+getSituatie()+" "+tip_mon+" "+vit_proc+" "+c_hdd+" "+sist;
    }
}
