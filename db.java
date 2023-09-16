package DBPackage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;

public class UnicodeHandler {
    private static final String URL = "jdbc:mysql://183.99.87.90:3306/SeanLee";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "swhacademy!";

    public static void main(String[] args) {
    	String[] CHO = {"ㄱ", "ㄲ", "ㄴ", "ㄷ", "ㄸ", "ㄹ", "ㅁ", "ㅂ", "ㅃ", "ㅅ", "ㅆ", "ㅇ", "ㅈ", "ㅉ", "ㅊ", "ㅋ", "ㅌ", "ㅍ", "ㅎ"};
		String[] JOONG = {"ㅏ", "ㅐ", "ㅑ", "ㅒ", "ㅓ", "ㅔ", "ㅕ", "ㅖ", "ㅗ", "ㅘ", "ㅙ", "ㅚ", "ㅛ", "ㅜ", "ㅝ", "ㅞ", "ㅟ", "ㅠ", "ㅡ", "ㅢ", "ㅣ"};
		String[] JONG = {"", "ㄱ", "ㄲ", "ㄳ", "ㄴ", "ㄵ", "ㄶ", "ㄷ", "ㄹ", "ㄺ", "ㄻ", "ㄼ", "ㄽ", "ㄾ", "ㄻ", "ㅀ", "ㅁ", "ㅂ", "ㅄ", "ㅅ", "ㅆ", "ㅇ", "ㅈ", "ㅊ", "ㅋ", "ㅌ", "ㅍ", "ㅎ"};
		String word = "나는 바보다 고로 바보다";
		String a = "";
		String result = "";
		
		for(int i = 0; i < word.length(); i++) {
			if(word.charAt(i) != ' ')
				a += word.charAt(i);
		}
		
		String[] split = a.split("");
		String s;
		
		
		for(int index=0; index<a.length(); index++){
			s = split[index];
			
			// 초성
			char unicho = s.charAt(0);
			char cho = (char)((unicho-0xAC00)/28/21);
			result += CHO[(int)cho];
			
			// 중성
			char unijoong = s.charAt(0);
			char joong = (char)((unijoong-0xAC00)/28%21);
			result += JOONG[(int)joong];
			
			// 종성
			char unijong = s.charAt(0);
			char jong = (char)((unijong-0xAC00)%28);
			result += JONG[(int)jong];
		}
		
		for(int i = 0; i < result.length(); i++) {
			try (Connection conn =
                    DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

				String sql = "SELECT tag, img FROM image WHERE tag = '" + result.charAt(i) + "';";

				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					String name = rs.getString("tag");
//               	System.out.println(name);

					File image = new File(name);
					try (FileOutputStream fos = new FileOutputStream(image)) {
						byte[] buffer = new byte[1024];

						// Get the binary stream of our BLOB data
						InputStream is = rs.getBinaryStream("img");
						System.out.println(name);
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
}

/*
ㄴ
java.io.ByteArrayInputStream@20398b7c
ㅏ
java.io.ByteArrayInputStream@18eed359
ㄴ
java.io.ByteArrayInputStream@6f1fba17
ㅡ
java.io.ByteArrayInputStream@335eadca
ㄴ
java.io.ByteArrayInputStream@2b2948e2
ㅂ
java.io.ByteArrayInputStream@3b0143d3
ㅏ
java.io.ByteArrayInputStream@731a74c
ㅂ
java.io.ByteArrayInputStream@7d907bac
ㅗ
java.io.ByteArrayInputStream@6325a3ee
ㄷ
java.io.ByteArrayInputStream@2b9627bc
ㅏ
java.io.ByteArrayInputStream@61f8bee4
ㄱ
java.io.ByteArrayInputStream@7fac631b
ㅗ
java.io.ByteArrayInputStream@5bc79255
ㄹ
java.io.ByteArrayInputStream@3dd4520b
ㅗ
java.io.ByteArrayInputStream@43814d18
ㅂ
java.io.ByteArrayInputStream@578486a3
ㅏ
java.io.ByteArrayInputStream@1dfe2924
ㅂ
java.io.ByteArrayInputStream@50b494a6
ㅗ
java.io.ByteArrayInputStream@3d99d22e
ㄷ
java.io.ByteArrayInputStream@3a883ce7
ㅏ
java.io.ByteArrayInputStream@79be0360
*/
