import java.sql.*;

public class P4_DML_Insert {
    //MySql de day6 da..
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.
                getConnection("jdbc:mysql://localhost:3306/batch60_61", "root", "1234");

        Statement st = con.createStatement();

        //SORU: Calisanlar tablosuna yeni bir kayit ((10005, 'Muhammet Yenice' , 15000)  ekleyelim ve eklenen kaydi teyit icin sorgulayalim.
        String query1 = "INSERT INTO calisanlar VALUES (10005, 'Muhammet Yenice' , 'Adana', 15000, 'Nike')";
        int a = st.executeUpdate(query1);
        System.out.println(a+" satır eklendi.");


        //SORU: Calisanlar tablosuna birden fazla yeni kayıt ekleyelim.

        // 1.YONTEM
        // Ayri ayri sorgular ile veritabanina tekrar tekrar ulasmak islemlerin yavas yapilmasina yol acar.
        // 10000 tane veri kaydi yapildigi dusunuldugunde  bu kotu bir yaklasimdir.

        String queries[] = {"INSERT INTO calisanlar VALUES (10006, 'Kadir Yıldız' , 'Malatya', 12000, 'Adidas')",
                "INSERT INTO calisanlar VALUES (10007, 'Betül Kayhan' , 'Uşak', 12000, 'Nike')",
                "INSERT INTO calisanlar VALUES (10008, 'Onur Değirmen' , 'Kütahya', 13500, 'Vakko')",
                "INSERT INTO calisanlar VALUES (10009, 'Sinem Karaca' , 'Afyon', 14250, 'Puma')",
                "INSERT INTO calisanlar VALUES (10010, 'Esra Coşkun' , 'Isparta', 11500, 'LCWaikiki')"};

        int data =0;
        for (String q : queries) {
            data+=st.executeUpdate(q);
        }

        System.out.println(data+ " data eklendi");

        // 2.YONTEM (addBath ve excuteBatch() metotlari ile)
        // addBatch metodu ile SQL ifadeleri gruplandirilabilir ve
        // exucuteBatch()  metodu ile veritabanina bir kere gonderilebilir.
        // ***!!!!**** excuteBatch() metodu bir int [] dizi dondurur.
        // Bu dizi her bir ifade sonucunda etkilenen satir sayisini gosterir.


        // 3. YONTEM
        //-----------------------------------------------------
        // batch metoduyla birlikte PreparedStatement kullanmak en efektif yontemdir.
        // SQL de guvenligi icin basvurulan bir yontemdir. Unutulmamalidir...
    }

}