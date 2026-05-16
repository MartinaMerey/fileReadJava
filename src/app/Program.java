package app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Program {

    //csak git linket lehet feltölteni, legyenek megadva a kivételek-->git ignore!!!
    public static void main(String[] args) throws IOException {
    
        //Sorok beolvasása
        List<String> sorok = Files.readAllLines(Path.of("fuvarok.csv"));
        //Fuvar objektumokat tároló lista
        List<Fuvar> fuvarok = new ArrayList<>();

        //Sorok feldolgozása
        for (String sor : sorok) {
            //darabolás
            String[] soradatok = sor.split(";");
            //megcimkezes
            String rsz = soradatok[0];
            int ido = Integer.parseInt(soradatok[1]);
            double osszeg = Double.parseDouble(soradatok[2]);
            String fizmod = soradatok[3];
            //Objektum létrehozása konstruktorral
            Fuvar fuvar = new Fuvar(rsz, ido, osszeg, fizmod);
            //listához adás
            fuvarok.add(fuvar);
        }
    
    
        //összes fuvar értéke
        System.out.println(osszFuvarErteke(fuvarok));
        //legdrágább fuvar rendszáma
        System.out.println(maxFuvarRenszama(fuvarok));
        //legolcsóbb fuvar forintban
        System.out.println(legolcsobbFuvarFt(fuvarok));
        //hány kártyás fizu
        System.out.println(hanyKartyas(fuvarok));
        //minden fizetési mód meghatározott
        System.out.println(mindenFizModOk(fuvarok));
        //hány darab autó van a rendszerben
        //hányféle fizetési mód van
        //melyik autó összesen mennyi fuvart teljesített
        
}
    
        
    public static double osszFuvarErteke(List<Fuvar> fuvarok) {
        double osszErtek=0;
        //int i=0; while(i<fuvarok.size()){ osszErtek+=fuvarok.get(i).getOsszeg(); i++; } --> List, nem tömb!!! no[i]!!!           
        for (Fuvar f : fuvarok) {
            osszErtek += f.getOsszeg();
        }
        return osszErtek;
        }
       
    public static String maxFuvarRenszama(List<Fuvar> fuvarok) {
        String maxRsz = "";
        int maxFuvar = 0;
        for (Fuvar f : fuvarok) {       
            if (f.getIdo()>maxFuvar){
                maxFuvar = f.getIdo();
                maxRsz = f.getRsz();
            }
        }
        return maxRsz;
    }
        
    public static double legolcsobbFuvarFt(List<Fuvar> fuvarok) {
        double min = fuvarok.get(0).getOsszeg();

        for (Fuvar f : fuvarok) {
            if (f.getOsszeg() < min) {
                min = f.getOsszeg();
            }
        }
        return min * 400;
    }

    //4
    public static int hanyKartyas(List<Fuvar> fuvarok) {
        int hanyKartya = 0;
        for (Fuvar f : fuvarok) {
            if (f.getFizmod().equals("kartya")) {
                hanyKartya ++;
            }
        }
        return hanyKartya;
    }
        
    //5
    public static boolean mindenFizModOk(List<Fuvar> fuvarok) {
        Set<String> fizModok = new HashSet<>();
        for (Fuvar f : fuvarok) {
            fizModok.add(f.getFizmod());
        }
        if (fizModok.contains("-")||fizModok.contains("")||fizModok.contains(" ")){
            return false;
        }
        return true;
    }
                
        
        //6
    /*    public static boolean mindenFizModOk(List<Fuvar> fuvarok) {
        boolean isMindenOk = true;
        Set<String> fizModok = new HashSet<>();
        for (Fuvar f : fuvarok) {
            fizModok.add(f.getFizmod());
        }
        if (fizModok.size()< fuvarok.size()){
            return !isMindenOk;
        }
        return isMindenOk;
    }
       */
        //8-as hz segítség
        //kulcs és értékpár (asszociatív tömb PHP-ban)
        //Map<Diak,List<Integer>>map
        // map lehet hashmap, treemap
        //Map<String,Integer>m
        //<Integer,Integer>
        //[1]=
        //["kulcs"]=ertek
        
        //8-as 0. szintű belépés volt valaha a programozói állásoknaál
        
        //-záró vizsga: webes szakdolgozat, elmélet, asztali alkalmas grafikus 3 konzolos valami
                 
            
            
            
        
}
