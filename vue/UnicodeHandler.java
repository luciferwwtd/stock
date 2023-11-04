package DBPackage;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Base64;

import org.apache.commons.io.IOUtils;

import static spark.Spark.get;

import static spark.Spark.*;

import org.json.JSONObject;

public class UnicodeHandler {
    private static final String URL = "jdbc:mysql://183.99.87.90:3306/Munchan";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "swhacademy!";
    private static final String[] CHO = {"ㄱ", "ㄲ", "ㄴ", "ㄷ", "ㄸ", "ㄹ", "ㅁ", "ㅂ", "ㅃ", "ㅅ", "ㅆ", "ㅇ", "ㅈ", "ㅉ", "ㅊ", "ㅋ", "ㅌ", "ㅍ", "ㅎ"};
	private static final String[] JOONG = {"ㅏ", "ㅐ", "ㅑ", "ㅒ", "ㅓ", "ㅔ", "ㅕ", "ㅖ", "ㅗ", "ㅘ", "ㅙ", "ㅚ", "ㅛ", "ㅜ", "ㅝ", "ㅞ", "ㅟ", "ㅠ", "ㅡ", "ㅢ", "ㅣ"};
	private static final String[] JONG = {"", "ㄱ", "ㄲ", "ㄳ", "ㄴ", "ㄵ", "ㄶ", "ㄷ", "ㄹ", "ㄺ", "ㄻ", "ㄼ", "ㄽ", "ㄾ", "ㄻ", "ㅀ", "ㅁ", "ㅂ", "ㅄ", "ㅅ", "ㅆ", "ㅇ", "ㅈ", "ㅊ", "ㅋ", "ㅌ", "ㅍ", "ㅎ"};
    private static final String[] wordList = {"ㄱ", "ㄲ", "ㄴ", "ㄷ", "ㄸ", "ㄹ", "ㅁ", "ㅂ", "ㅃ", "ㅅ", "ㅆ", "ㅇ", "ㅈ", "ㅉ", "ㅊ", "ㅋ", "ㅌ", "ㅍ", "ㅎ", "ㅏ", "ㅐ", "ㅑ", "ㅒ", "ㅓ", "ㅔ", "ㅕ", "ㅖ", "ㅗ", "ㅘ", "ㅙ", "ㅚ", "ㅛ", "ㅜ", "ㅝ", "ㅞ", "ㅟ", "ㅠ", "ㅡ", "ㅢ", "ㅣ", "ㄳ", "ㄵ", "ㄶ", "ㄺ", "ㄻ", "ㄼ", "ㄽ", "ㄻ", "ㅀ", "ㅄ"};
//
    public static void main(String args[]) throws IOException {
    	port(4567);
    	get("/play/:sentance", (request, response) -> {
    		String s;
    		String result;
    		for(int index=0; index<a.length(); index++){
				
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
    		return 0;
    	});
    	
		get("/hello", (request, response) -> {
			JSONObject st = new JSONObject();
	    	
	    	
			
			for(int i = 0; i < wordList.length; i++) {
				try (Connection conn =
	                DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

					String sql = "SELECT text, file FROM BLOL_IMG WHERE text = '" + wordList[i] + "';";

					PreparedStatement stmt = conn.prepareStatement(sql);
					ResultSet rs = stmt.executeQuery();
					while (rs.next()) {
						InputStream is = rs.getBinaryStream("file");
						byte[] bytes = IOUtils.toByteArray(is);
						String encoded = Base64.getEncoder().encodeToString(bytes);
						
						st.put(wordList[i], encoded);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
	        return st;
	    });
    }
}
