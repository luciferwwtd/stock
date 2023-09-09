package DBPackage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;

public class InsertingImageToDatabase {
    private static final String URL = "jdbc:mysql://183.99.87.90:3306/SeanLee";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "swhacademy!";

    public static void main(String[] args) {
        try (Connection conn =
                     DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

            String sql = "SELECT tag, img FROM image";

            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString("tag");
//                System.out.println(name);

                File image = new File(name);
                try (FileOutputStream fos = new FileOutputStream(image)) {
                    byte[] buffer = new byte[1024];

                    // Get the binary stream of our BLOB data
                    InputStream is = rs.getBinaryStream("img");
                    System.out.println(is);
                    while (is.read(buffer) > 0) {
                        fos.write(buffer);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
