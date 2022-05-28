import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class P3_DDL {
    /*
                 A) CREATE TABLE, DROP TABLE, ALTER TABLE gibi DDL ifadeleri icin sonuc kümesi (ResultSet)
                    dondurmeyen metotlar kullanilmalidir. Bunun icin JDBC’de 2 alternatif bulunmaktadir.
                       1) execute() metodu
                       2) excuteUpdate() metodu.

                 B)   - execute() metodu her tur SQL ifadesiyle kullanibilen genel bir komuttur.
                      - execute(), Boolean bir deger dondurur.
                      - DDL islemlerin false dondururken, DML islemlerinde true deger dondurur.(ResultSet olusturur)
                      - Ozellikle hangi tip SQL ifadesinin kullanilmasinin gerektiginin belli olmadigi
                        durumlarda tercih edilmektedir.

                 C) - executeUpdate() metodu ise INSERT, Update gibi DML islemlerinde yaygin kullanilir.
                    -  bu islemlerde islemden etkilenen satir sayisini dondurur.
                    - Ayrıca, DDL islemlerinde de kullanilabilir ve bu islemlerde 0 dondurur.

                  execute() her turlu SQL kjomutuyla kullanilir .......  DDL ---> False    DML----> True
                  executeUpdate()  DDL ----> 0           DML ----->etkilenen satir sayisini verir
             */

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.
                getConnection("jdbc:mysql://localhost:3306/batch60_61", "root", "1234");

        Statement st = con.createStatement();

        // SORU: markalar adında bir tablo oluşturunuz. marka_id int, marka_isim VARCHAR(15), calisan_sayisi int

        //1.yontem : execute () methodu ile

        // String query1 = "create table markalar3 (marka_id int, marka_isim VARCHAR(15), calisan_sayisi int)";
        // boolean bl = st.execute(query1);
        // System.out.println("Tablo oluşturuldu -> "+bl);
        // execute(), Boolean bir deger dondurur.
        //- DDL islemlerin false dondururken(ResultSet olusturmadigi icin),  DML islemlerinde true deger dondurur.(ResultSet olusturur)

        //2.yontem : executeUpdate() methodu ile
        // int a = st.executeUpdate(query1);
        // System.out.println("Markalar3 tablosu oluşturuldu -> "+a);

        // SORU: markalar tablosunu siliniz
        // String query2 = "drop table markalar3";
        // st.execute(query2);
        // System.out.println("Markalar3 tablosu silindi...");


        // SORU : markalar tablosuna yeni bir sutun {sube_sayisi int} ekleyiniz
        // String query3 =     "alter table markalar2 add sube_sayisi int";
        // st.execute(query3);

        // SORU : markalar tablosuna yeni bir sutun {sube_sayisi int} ekleyiniz, ancak bu sutunun yeri marka_id den sonra olsun
        // String query4="ALTER table markalar2 add sube_sayisi2 int after marka_id";
        // st.execute(query4);


        // SORU : markalar tablosunun adini  brands olarak degistiriniz
        // String query5="ALTER table markalar2 rename to brands";
        // st.execute(query5);

        // SORU : markalar tablosunda marka_isim sutununu isim olarak degistiriniz
        // String query6="ALTER table brands rename column sube_sayisi2 to sube2";
        // st.execute(query6);


        // SORU : markalar tablosunda marka_isim sutununun data type ini char(20) olarak degistiriniz
        String query6="ALTER table brands modify sube2 varchar(20)";
        st.execute(query6);

    }

}
