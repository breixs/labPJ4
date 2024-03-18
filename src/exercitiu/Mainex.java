package exercitiu;
import java.io.*;
import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class Mainex {

    static int findIndex(String sir,int nr)
    {
        if(nr==1)
            return sir.indexOf(";");
        else
            return sir.indexOf(";", findIndex(sir, nr-1)+";".length());
    }

    static void scrieBin(Object o, String fis)
    {
        try{
            FileOutputStream f=new FileOutputStream(fis);
            ObjectOutputStream oos=new ObjectOutputStream(f);
            oos.writeObject(o);
            oos.close();
            f.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    static Object citesteBin(String fis)
    {
        try{
            FileInputStream f=new FileInputStream(fis);
            ObjectInputStream ois=new ObjectInputStream(f);
            Object o=ois.readObject();
            ois.close();
            f.close();
            return o;
        }
        catch(IOException|ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        String nume_fis = "src/exercitiu/echipamente.txt";
        BufferedReader flux_in = new BufferedReader(new InputStreamReader(new FileInputStream(nume_fis)));
        String line;
        List<EchipamenteElectronice> echipamente = new ArrayList<EchipamenteElectronice>();

        while ((line=flux_in.readLine()) != null) {
            String denumire;
            int nr_inv;
            float pret;
            String zona_mag;
            String situatie;
            String tip;
            int index1, index2;
            index1=line.indexOf(";");
            denumire=line.substring(0, index1);
            //System.out.println(denumire);

            index2=findIndex(line, 2);
            nr_inv= Integer.parseInt(line.substring(index1+1, index2));
            //System.out.println(nr_inv);

            index1=findIndex(line,3);
            pret=Float.parseFloat(line.substring(index2+1, index1));
            //System.out.println(pret);

            index2=findIndex(line, 4);
            zona_mag=line.substring(index1+1, index2);
            //System.out.println(zona_mag);

            index1=findIndex(line, 5);
            situatie=line.substring(index2+1, index1);
            situatie=situatie.toUpperCase();
            //System.out.println(situatie);

            index2=findIndex(line, 6);
            tip=line.substring(index1+1, index2);
            //System.out.println(tip);
            if(tip.equals("imprimanta"))
            {
                int ppm, p_car;
                String rezolutie, mod_tiparitre;

                index1=findIndex(line, 7);
                ppm=Integer.parseInt(line.substring(index2+1, index1));
                //System.out.println(ppm);

                index2=findIndex(line, 8);
                rezolutie=line.substring(index1+1, index2);
                //System.out.println(rezolutie);

                index1=findIndex(line, 9);
                p_car=Integer.parseInt(line.substring(index2+1, index1));
                //System.out.println(p_car);

                index2=line.length();
                mod_tiparitre=line.substring(index1+1, index2);
                mod_tiparitre=mod_tiparitre.toUpperCase();
                //System.out.println(mod_tiparitre);

                echipamente.add(new Imprimanta(denumire, nr_inv, pret, zona_mag, situatie, ppm, rezolutie, p_car, mod_tiparitre));
            }
            else if(tip.equals("copiator"))
            {
                int p_ton;
                String format;

                index1=findIndex(line, 7);
                p_ton=Integer.parseInt(line.substring(index2+1, index1));

                index2=line.length();
                format=line.substring(index1+1, index2);
                format=format.toUpperCase();

                echipamente.add(new Copiatoare(denumire, nr_inv, pret, zona_mag, situatie, p_ton, format));

            }
            else if(tip.equals("sistem de calcul"))
            {
                String tip_mon, sist;
                int c_hdd;
                float vit_proc;

                index1=findIndex(line,7);
                tip_mon=line.substring(index2+1, index1);

                index2=findIndex(line, 8);
                vit_proc=Float.parseFloat(line.substring(index1+1, index2));

                index1=findIndex(line,9);
                c_hdd=Integer.parseInt(line.substring(index2+1, index1));

                index2=line.length();
                sist=line.substring(index1+1, index2);
                sist=sist.toUpperCase();

                echipamente.add(new SistemeDeCalcul(denumire, nr_inv, pret, zona_mag, situatie, tip_mon, vit_proc, c_hdd, sist ));
            }
        }
        int opt, obiect, modNou;
        //String sitNoua;
        Scanner scan=new Scanner(System.in);

        do{
            System.out.println("alegeti optiunea: ");
            opt=scan.nextInt();
            switch(opt)
            {
                case 1:
                    for(int i=0;i<echipamente.size();i++)
                        System.out.println(echipamente.get(i));
                    break;
                case 2:
                    for(EchipamenteElectronice e:echipamente)
                    {
                        if(e instanceof Imprimanta)
                            System.out.println(e);
                    }
                    break;
                case 3:
                    for(EchipamenteElectronice e:echipamente)
                    {
                        if(e instanceof Copiatoare)
                            System.out.println(e);
                    }
                    break;
                case 4:
                    for(EchipamenteElectronice e:echipamente)
                    {
                        if(e instanceof SistemeDeCalcul)
                            System.out.println(e);
                    }
                    break;
                case 5:
                    System.out.println("introduceti numarul obiectului care va fi modificat: ");
                    obiect=scan.nextInt();
                    for(int i=0;i<echipamente.size();i++)
                        if(i==obiect) {
                            String finalSitNoua;
                            System.out.println("introduceti sitNoua: 1-ACHIZITIONAT, 2-VANDUT, 3-EXPUS");
                            modNou = scan.nextInt();
                            if(modNou==1)
                            finalSitNoua = "ACHIZITIONAT";
                            else if(modNou==2)
                                finalSitNoua="VANDUT";
                            else if(modNou==3)
                                finalSitNoua="EXPUS";
                            else {
                                System.out.println("alegere proasta");
                                break;
                            }
                            int finalI = i;
                            echipamente.forEach(e -> echipamente.get(finalI).setSitutaie(finalSitNoua));
                            System.out.println(echipamente.get(i));
                        }
                    break;
                case 6:
                    System.out.println("introduceti numarul obiectului care va fi modificat: ");
                    obiect=scan.nextInt();
                    for(int i=0;i<echipamente.size();i++)
                    {
                        if(i==obiect)
                        {
                            if(echipamente.get(i) instanceof Imprimanta)
                            {
                                String finalModNou;
                                System.out.println("introduceti mod nou 1-COLOR, 2-ALB-NEGRU");
                                modNou=scan.nextInt();
                                if(modNou==1)
                                    finalModNou="COLOR";
                                else if(modNou==2)
                                    finalModNou="ALB-NEGRU";
                                else {
                                    System.out.println("prosta alegere");
                                    break;
                                }
                                int finalI = i;
                                echipamente.forEach(e-> ((Imprimanta) echipamente.get(finalI)).setMod(finalModNou));
                                System.out.println(echipamente.get(i));
                            }
                        }
                    }
                    break;
                case 7:
                    System.out.println("introduceti numarul obiectului care va fi modificat: ");
                    obiect=scan.nextInt();
                    for(int i=0;i<echipamente.size();i++)
                    {
                        if(i==obiect)
                        {
                            if(echipamente.get(i) instanceof Copiatoare)
                            {
                                String finalModNou;
                                System.out.println("introduceti mod nou 1-COLOR, 2-ALB-NEGRU");
                                modNou=scan.nextInt();
                                if(modNou==1)
                                    finalModNou="A3";
                                else if(modNou==2)
                                    finalModNou="A4";
                                else {
                                    System.out.println("prosta alegere");
                                    break;
                                }
                                int finalI = i;
                                echipamente.forEach(e-> ((Copiatoare) echipamente.get(finalI)).setForm(finalModNou));
                                System.out.println(echipamente.get(i));
                            }
                        }
                    }
                    break;
                case 8:
                    System.out.println("introduceti numarul obiectului care va fi modificat: ");
                    obiect=scan.nextInt();
                    for(int i=0;i<echipamente.size();i++)
                    {
                        if(i==obiect)
                        {
                            if(echipamente.get(i) instanceof SistemeDeCalcul)
                            {
                                String finalModNou;
                                System.out.println("introduceti mod nou 1-LINUX, 2-WINDOWS");
                                modNou=scan.nextInt();
                                if(modNou==1)
                                    finalModNou="LINUX";
                                else if(modNou==2)
                                    finalModNou="WINDOWS";
                                else {
                                    System.out.println("prosta alegere");
                                    break;
                                }
                                int finalI = i;
                                echipamente.forEach(e-> ((SistemeDeCalcul) echipamente.get(finalI)).setSist(finalModNou));
                                System.out.println(echipamente.get(i));
                            }
                        }
                    }
                    break;
                case 9:
                    for(EchipamenteElectronice e:echipamente)
                    {
                        if(Objects.equals(e.getSituatie(), "VANDUT"))
                            System.out.println(e);
                    }
                    break;
                case 10:
                    scrieBin(echipamente, "echipamente.bin");

                    List<EchipamenteElectronice> i;
                    i=(List<EchipamenteElectronice>) citesteBin("echipamente.bin");
                    assert i != null;
                    for(EchipamenteElectronice e:i)
                        System.out.println(e);
                    break;
                case 0:
                    break;
            }
        }while(opt!=0);
    }
}
