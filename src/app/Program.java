package app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
    
        
        System.out.println("\u001B[32mösszes fuvar értéke:");
        kiiras(osszFuvarErteke(fuvarok));
        System.out.println("\u001B[32mlegdrágább fuvar rendszáma");
        kiiras(maxFuvarRenszama(fuvarok));
        System.out.println("\u001B[32mlegolcsóbb fuvar forintban");
        kiiras(legolcsobbFuvarFt(fuvarok));
        System.out.println("\u001B[32mhány kártyás fizu");
        kiiras(hanyKartyas(fuvarok));
        System.out.println("\u001B[32mminden fizetési mód meghatározott");
        kiiras(mindenFizModOk(fuvarok));
        System.out.println("\u001B[32mhány darab autó van a ");
        kiiras(hanyDbAuto(fuvarok));
        System.out.println("\u001B[32mhányféle fizetési mód van");
        kiiras(hanyFizMod(fuvarok));
        System.out.println("\u001B[32mmelyik autó összesen mennyi fuvart ");
        kiiras(melyikAutoMennyit(fuvarok));
        
    } //psvm
    
    //1      
    public static double osszFuvarErteke(List<Fuvar> fuvarok) {
        double osszErtek=0;
        //int i=0; while(i<fuvarok.size()){ osszErtek+=fuvarok.get(i).getOsszeg(); i++; } --> List, nem tömb!!! no[i]!!!           
        for (Fuvar f : fuvarok) {
            osszErtek += f.getOsszeg();
        }
        return osszErtek;
        }

    //2
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
    
    //3
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
    public static int hanyDbAuto(List<Fuvar> fuvarok) {
        Set<String> autok = new HashSet<>();
        for (Fuvar f : fuvarok) {
            autok.add(f.getRsz());
        }
        return autok.size();  
    }
    
    //7 (fapadosabb osszeszamolas)
    public static int hanyFizMod(List<Fuvar> fuvarok) {
        List<String> fizmodok = new ArrayList<>();
        for (Fuvar f : fuvarok) {
            if (!fizmodok.contains(f.getFizmod())){
            fizmodok.add(f.getFizmod());
            }
        }
        return fizmodok.size();   
    }
    //még fapadosabb:
/*  public static int hanyFele(List<Fuvar> fuvarok) {
        int db = 0;
        for (int i = 0; i < fuvarok.size(); i++) {
            boolean voltMar = false;
            for (int j = 0; j < i; j++) {
                if (fuvarok.get(i).getAdatTag().equals(fuvarok.get(j).getAdatTag())) {
                    voltMar = true;
                    break;
                }
            }
            if (!voltMar) {
                db++;
            }
        }
        return db;
    }
*/
    //8
    //-hoz segítség: (0. szintű belépés volt valaha a programozói állásoknál)
    //kulcs és értékpár (asszociatív tömbnek hívják PHP-ban), kulcs (key) → érték (value)
    //Map<Diak,List<Integer>>map
    //map lehet hashmap, treemap
    //Map<String,Integer> map
    //<Integer,Integer>
    //[1]=
    //["kulcs"]=ertek
    public static Map<String, Integer> melyikAutoMennyit(List<Fuvar> fuvarok){
        Map<String, Integer> menetekMap = new HashMap<>();
        for (Fuvar f : fuvarok) {
            String rsz = f.getRsz();
            if (menetekMap.containsKey(rsz)) {
                menetekMap.put(rsz, menetekMap.get(rsz) + 1);
            } else {
                menetekMap.put(rsz, 1);
            }
        }
        return menetekMap;
    }//melyikMennyi
    
    private static int feladat = 0;    
    public static void kiiras (Object adat) {
        feladat++;
        System.out.printf("\u001B[32m(%d)   \u001B[30m%s%n", feladat, adat);
        
        
    }

//-záró vizsga: webes szakdolgozat, elmélet, asztali alkalmas grafikus 3 konzolos valami
} //class
