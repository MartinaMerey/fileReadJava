package app;

import app.Fuvar;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Program {

    private static List<String> sorok;
    private static List<Fuvar> fuvarok;
    //csak git linket lehet feltölteni, legyenek megadva a kivételek-->git ignore!!!
    public static void main(String[] args) throws IOException {
        
        
        Path path = Path.of("fuvarok.csv");
        String adatok = Files.readString(path);
        //elérés lehet realtív vagy abszolút cím
        System.out.println("Beolvasott tartalom: " + adatok);
        
    List<String> fuvaroksorai = Files.readAllLines(path);
        for (String sor: fuvaroksorai) {
            System.out.println(sor);}
    }
    
    
    sorok = Files.readAllLines(Path.of("fuvarok.csv"));
    fuvarok = new ArrayList<>();
    for (String sor : sorok) {
        fuvarok.add(new Fuvar(sor));
    }
    
    //tartalom saját típussal
    /*List<Fuvar> fuvarok = new ArrayList<>();
         for(String sor : fuvarok) {
            String[] s = sor.split(";");
            String rsz = s[0];
            int ido = Integer.parseInt(s[1]);
            double ossz = Double.ParseDouble(s[2]);      
            String fm = s[3];
            Fuvar fuvar = new Fuvar(rsz, ido, ossz, fm);
            System.out.println(sor);
    }*/

        //összes fuvar értéke
        osszFuvarErteke(fuvarok);
        //legdrágább fuvar rendszáma
        maxFuvarRenszama(fuvarok);
        //legolcsóbb fuvar forintban
        
        //hány kártyás fizu
        //minden fizetési mód meghatározott
        mindenFizModOk(fuvarok);
        //hány darab autó van a rendszerben
        //hányféle fizetési mód van
        //melyik autó összesen mennyi fuvart teljesített
        

    
        
        public int osszFuvarErteke(ArrayList fuvarok) {
            int osszes=0;
            int i=0;
            while (i < fuvarok.size()) {
                osszes += fuvarok.ossz;
                i++;
            }
        return osszes;
        }
       
        public String maxFuvarRenszama(ArrayList fuvarok) {
            String maxRsz = "";
            int maxFuvar = 0;
            for (int i = 0; i < fuvarok.size(); i++) {
                if (fuvarok.get(i).ido > maxFuvar){
                    maxFuvar = fuvarok.get(i).ido;
                    maxRsz = fuvarok.get(i).rsz;
                    }
            }

        return maxRsz;
    }
        
        public double legolcsobbFuvarFt(ArrayList fuvarok) {
            double maxOssz = 0;
            for (int i = 0; i < fuvarok.size; i++) {
                if (fuvarok.get(i).ossz > maxOssz){
                    maxOssz = fuvarok.get(i).ossz;
                    }
            }
            double minOssz = maxOssz;
            for (int i = 0; i < fuvarok.size(); i++) {
                if (fuvarok.get(i).ossz < minOssz){
                    minOssz = fuvarok.get(i).ossz;
                    }
            }
        return minOssz*400;
    }
    //4
        public int hanyKartyas(ArrayList fuvarok) {
            int hanyKartya = 0;
            for (int i = 0; i < fuvarok.size(); i++) {
                if (!fuvarok.get(i).fm.equals("kartya")){
                    hanyKartya ++;
                } 
            }
            return hanyKartya;
        }
        
        //5
        public Set[] mindenFizModOk(ArrayList fuvarok) {
            Set<String> fizModok = new HashSet<>();
        for (int i = 0; i< fuvarok.size(); i++){
            fizModok.push(fuvarok.get(i).fm);
        }
        return fizModok;
                
        
        //6
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
