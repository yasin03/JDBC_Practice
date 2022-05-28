import java.sql.*;

public class P2_ReadData_Different {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.
                getConnection("jdbc:mysql://localhost:3306/batch60_61", "root", "1234");

        Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        // ilk satirdaki ilk objeyi yazdiralim
        String s = "select * from personel";
        ResultSet rs = st.executeQuery(s);
        System.out.println(rs.getRow());

        rs.first();  // ilk satır seçildi
        Object o = rs.getObject(1); // ilk hücre objeye atandı
        System.out.println("ilk satırdaki ilk hücre = " + o.toString());

        // ikinci satirdaki ilk objeyi yazdiralim
        // ilk sutundaki 5.degeri yazdiralim
        rs.absolute(5);
        Object besincideger = rs.getObject(1);
        System.out.println("besincideger.toString() = " + besincideger.toString());

        System.out.println("---------------------------------------");
        rs.absolute(0);
        while (rs.next()) {
            Object id = rs.getObject(1);
            System.out.println(id.toString());
        }
        System.out.println("---------------------------------------");

        rs.absolute(0);
        while (rs.next()) {
            Object name = rs.getObject(2);
            System.out.println(name.toString());
        }
        System.out.println("---------------------------------------");

    }

        // ilk sutundaki 5.degeri yazdiralim


        // 0.satira gitmemizin sebebi while sorgusu icerisinde bulunan resultSet.next() in bizi
        // birinci kayda goturmesi icindir. Eger 1.satira gidecek olsak while icindeki kod yuzunden yazdirmaya
        // 2.satirdan baslar, tum listeyi alamayiz

        // Tum listeyi yazdirmak istersek;


}

