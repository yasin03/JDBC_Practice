import java.sql.*;
import java.util.Arrays;

public class P1_ReadData {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.
                getConnection("jdbc:mysql://localhost:3306/batch60_61", "root", "1234");

        Statement st = con.createStatement();
        // SORU1: Talebeler tablosundan tum kayitları listeleyiniz.
        ResultSet rs1 = st.executeQuery("select * from talebeler");
        while (rs1.next()) {
            System.out.printf("%-6d %-20.20s %-8s %-8d\n",
                    rs1.getInt(1), rs1.getString(2), rs1.getString(3), rs1.getInt(4));
        }
        System.out.println("=============================================");

        // SORU2: Talebeler tablosunda notları 90 uzeri olan kayitları listeleyiniz.
        ResultSet rs2 = st.executeQuery("select * from talebeler where yazili_notu >90");
        while (rs2.next()) {
            System.out.printf("%-6d %-20.20s %-8s %-8d\n",
                    rs2.getInt(1), rs2.getString(2), rs2.getString(3), rs2.getInt(4));
        }
        System.out.println("=============================================");

        // SORU3: Talebeler tablosunda id'si 124 olan öğrencilerin tüm bilgilerini listeleyiniz.

        ResultSet rs3 = st.executeQuery("select * from talebeler where id =124");
        while (rs3.next()) {
            System.out.printf("%-6d %-20.20s %-8s %-8d\n",
                    rs3.getInt(1), rs3.getString(2), rs3.getString(3), rs3.getInt(4));
        }
        System.out.println("=============================================");

        // SORU4: Talebeler tablosunda notu 70 ile 90 arasindaki kisilerin isimlerini listeleyiniz.

        ResultSet rs4 = st.executeQuery("select * from talebeler where yazili_notu between '70' and '90'");
        while (rs4.next()) {
            System.out.printf("%-6d %-20.20s %-8s %-8d\n",
                    rs4.getInt(1), rs4.getString(2), rs4.getString(3), rs4.getInt(4));
        }
        System.out.println("=============================================");

        // SORU5: Talebeler tablosunda isminin 2. harfi e olan kisilerin veli_isimleri ile birlikte listeleyiniz.

        ResultSet rs5 = st.executeQuery("select * from talebeler where isim like '_e%'");
        while (rs5.next()) {
            System.out.printf("%-6d %-20.20s %-8s %-8d\n",
                    rs5.getInt(1), rs5.getString(2), rs5.getString(3), rs5.getInt(4));
        }

        con.close();
        st.close();
    }
    //MySql de day3 de..

}


