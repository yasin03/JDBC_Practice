import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class P5_CRUD {
    // Cok miktarda kayit eklemek icin PreparedStatement metodu kullanilabilir.
    // PreparedStatement hem hizli hem de daha guvenli (SQL injection saldirilari icin) bir yontemdir.
    // ResultSet tum sonucları bellekte tutuyor..  ama guvenli degil..banka hesaplarını dusunun..siber saldırıya ugrasa..
    // bu yuzden database in guvrnligi acisindan PreparedStatement onemlidir..
    // Bunun icin;
    // 	1) Veri girisine uygun bir POJO(Plain Old Java Object) sinifi olusturulur.
    // 	2) POJO Class nesnelerini saklayacak bir collection olusturulur
    // 	3) bir dongu ile kayitlar eklenir.

    // PreparedStatement hizli ve guvenli yontem, bu yontemle cozecegiz
    // POJO class : plain old java object class, bu class calistirilmaz main i yok..
    // bu class private degisken + constructor() + getter() + setter() ve toString() ler iceren class


        // SORU: Dersler adında bir tablo olusturalım (id int, ders_isim varchar(15), egitim_suresi int)

    }
