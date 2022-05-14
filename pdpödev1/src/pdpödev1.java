
/*
*
*
BERK TUNÇ      B171200016  berk.tunc@ogr.sakarya.edu.tr
RIFAT İLHAN    B181200551  rifat.ilhan@ogr.sakarya.edu.tr
*
*
@Since  05.03.2020
*
*
<p>
Programlama dillerinin prensipleri ÖDEV 1 (2 KİŞİLİK GRUP ÇALIŞMASI ŞEKLİNDE YAPILMIŞTIR.)
İçerik.txt dosyası klasörün içinde bulunmaktadır.(Ödevde dosya kullanıcıdan istenmemektedir dediği için.)
Eğer dosya yolu manuel olarak elle girilmek istenirse diye yorum satırları içinde ek olarak o kodlarda bulunmaktadır.
<p

*/



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class pdpödev1 {

    public static void main(String[] args) throws IOException {
        
        int sesliharf = 0;
        int cümle = 0;
        int mail = 0;
        int web = 0;
        int kelime = 0;
        
        
        /* System.out.print("Dosya Yolunu Giriniz: "); 
        Scanner scan =new Scanner(System.in);                     //EĞER DOSYA YOLU MANUEL OLARAK KULLANICIDAN İSTENMİŞ OLSAYDI BU KISMI KULLANACAKTIK.
        dosyayolu = scan.next();
        FileReader dosya = new FileReader(dosyayolu);
        BufferedReader myreader = new BufferedReader(dosya);
       */
        
        

        FileReader dosya = new FileReader("içerik.txt");                 //Klasörün hemen bir alt dizinine koyduğumuz içerik.txt dosyasına direk erişilir.
        try (BufferedReader myreader = new BufferedReader(dosya))        //Dosya işlemleri yapılır.
       
        {
            String str;
            while ((str = myreader.readLine()) != null) {    //Metnin sonuna kadar okuma işlemi devam etmesi için .
                for (int i = 0; i < str.length(); i++) {
                    char c = str.charAt(i);                       //ifadeler char char ilerletilir.
                    
                    if ((c == 'a') || (c == 'e') || (c == 'i') || (c == 'ı') || (c == 'o') || (c == 'ö') || (c == 'u')                            
                            || (c == 'ü') || (c == 'A') || (c == 'E') || (c == 'İ') || (c == 'I') || (c == 'O') || (c == 'Ö') || (c == 'U') || (c == 'Ü')) {
                        sesliharf++;
                        
                                         //Türkçe bazlı sesli harfler görüldüğü zaman sayaç 1 arttırılır.
                        
                    }
                    
                }
                
                String[] Dizi = str.split(" ");  //İfadelerin hepsi split fonksiyonu kullanılarak kelimelere ayrılmış olur.
                kelime = kelime + Dizi.length;  //Kelime sayısı bulunur.
                
                for (int i = 0; i < Dizi.length; i++) {
                    
                    if (Dizi[i].endsWith(".") || Dizi[i].endsWith("!") || Dizi[i].endsWith("?")) {
                        
                        cümle = cümle + 1;       //Diziye attığımız kelimelerin sonu nokta ünlem veya soru işareti ile bitiyorsa cümle sayacı 1 artar.
                    }
                    if(Dizi[i].contains("@"))   //Eğer @ işareti içeriyorsa mail sayacı 1 artar.
                        mail++;
                    if(( !Dizi[i].contains("@")&& (Dizi[i].contains(".com")|| Dizi[i].contains(".edu")|| Dizi[i].contains(".net") || Dizi[i].contains(".org")|| Dizi[i].contains(".gov")  )))
                        web++;
                    //Eğer kelime içinde @ işareti yoksa com gov edu net kelimelerini kelime içinde tekrar aratır eğer bunlardan birini bulursa sayacı 1 arttırır.
                    
                }
            }
            //Okuyucu kapatılır.
        }
        
        System.out.println(" Toplam Sesli Harf sayısı : " + (sesliharf));           //Yazdırma işlemleri yapılır.
        System.out.println(" Toplam Kelime Sayısı: " + kelime);
        System.out.println("Toplam Cümle Sayısi : " + cümle);
        System.out.println("Toplam Web Sitesi Sayısı = " + web);
        System.out.println("Toplam Mail Sayısı = " + mail);
        
    }
}