package com.example.zeytinyilmaz.myapplication;

import java.util.ArrayList;

/**
 * Created by ZEYTIN YILMAZ on 23.12.2017.
 */

public class veritabanina_eklenecekler {

    public ArrayList<String> anlam;
    public ArrayList<String> kelime;

    public veritabanina_eklenecekler() {
        anlam=new ArrayList<>();
        kelime=new ArrayList<>();
        /*kelime.add("murat");
        anlam.add("ermek");
        kelime.add("zeytin");
        anlam.add("kahvaltılık");
        kelime.add("yılmaz");
        anlam.add("yılmamak");

*/
        // A

        kelime.add("abacı");//1
        anlam.add("abadan giyecek yapan veya satan kimse");
        kelime.add("abasız");//2
        anlam.add("aba giymemiş olan");
        kelime.add("acılı");//3
        anlam.add("acı katılmış olan, acısı olan, kederli");
        kelime.add("acımasız");//4
        anlam.add("acıma duygusu olmadan, merhametsizce");
        kelime.add("acımtırak");//5
        anlam.add("acımsı");
        kelime.add("acısızlık");//6
        anlam.add("acısız olma durumu");
        kelime.add("acıtmak");//7
        anlam.add("acı vermek");
       // kelime.add("");//8
        //kelime.add("");


        // A

        ekle("abanozlaşmak","Ağaç gibi maddelerin suda uzun süre kalarak kararması.");//1
        ekle("abartılış","Abartılma durumu.");//2
        ekle("abdallık","Abdal olma durumu. ");//3
        ekle("abdest almak","Müslümanların, belli ibadetleri yapabilmek için bir düzen içerisinde bazı organları yıkayıp bazılarını mesh ederek arınması");//4
        ekle("abes kaçmak","Uygun düşmemek");//5
        ekle("abide","Anıt");//6
        ekle("ablacı","Sevici");//7
        ekle("avcılık","Avcı olma durumu veya işi.");//8
        ekle("avdet","dönüş,geri gelmeme");//9
        ekle("avlayabilmek","Avlama imkanı veya olasılığı bulunmak");//10
        ekle("avuç","Elin iç tarafı");//11

                // B
        /*
        ekle("bağdamak","Birkaç şeyi biririne geçirerek bağlamak");//1










        //test



        // buralar da bir sorun  var galiba
/*

        ekle("abanozlaşmak","Ağaç gibi maddelerin suda uzun süre kalarak kararması.");//1
        ekle("abartılış","Abartılma durumu.");//2
        ekle("abdallık","Abdal olma durumu. ");//3
        ekle("abdest almak","Müslümanların, belli ibadetleri yapabilmek için bir düzen içerisinde bazı organları yıkayıp bazılarını mesh ederek arınması");//4
        ekle("abes kaçmak","Uygun düşmemek");//5
        ekle("abide","Anıt");//6
        ekle("ablacı","Sevici");//7
        ekle("avcılık","Avcı olma durumu veya işi.");//8
        ekle("avdet","dönüş,geri gelmeme");//9
        ekle("avlayabilmek","Avlama imkanı veya olasılığı bulunmak");//10
        ekle("avuç","Elin iç tarafı");//11
// B
        ekle("bağdamak","Birkaç şeyi biririne geçirerek bağlamak");//1
        ekle("baba diyarı","Soyun, kökenin bulunduğu yer.");//2
        ekle("babacanca","Sevgi ve sevecenlikle, cana yakın olarak");//3
        ekle("bedence","Beden bakımından.");//4
        ekle("buat","Elektrik akımı devrelerinde birleştirme yapmak veya akımı bir veya daha fazla kola ayırmak için kullanılan kutu.");//5
        ekle("bucak bucak","Her yerde, her yanda, her tarafta.");//6
        ekle("buçuklu","Kesirli");//7
        ekle("budala","Zekâca geri olan (kimse), alık");//8
        ekle("budizm","Budistlik.");//9
        ekle("Budistlik","Doğaüstü kişileşmiş bir tanrı düşüncesi yerine, salt varlığı koyarak onun insanda arzu biçiminde belirdiğini, bundan da ızdırabın doğduğunu, ızdıraptan kurtulmak için var olmaktan vazgeçmek gerektiğini ileri süren, Hindistan ve Çin'de yaygın olan, Buddha'nın ileri sürdüğü mistik dünya görüşü ve din, Budizm");//10
        ekle("büzüşmek","Büzülerek alan hacmini küçültmek, kırışmak.");//11
*/
















    }
    private void ekle(String Kelime,String Anlam){
        this.kelime.add(Kelime.toString());
        this.anlam.add(Anlam.toString());
    }
}
