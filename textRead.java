package DBPackage;

public class test {
	public static void main(String[] args) {
		String[] CHO = {"ㄱ", "ㄲ", "ㄴ", "ㄷ", "ㄸ", "ㄹ", "ㅁ", "ㅂ", "ㅃ", "ㅅ", "ㅆ", "ㅇ", "ㅈ", "ㅉ", "ㅊ", "ㅋ", "ㅌ", "ㅍ", "ㅎ"};
		String[] JOONG = {"ㅏ", "ㅐ", "ㅑ", "ㅒ", "ㅓ", "ㅔ", "ㅕ", "ㅖ", "ㅗ", "ㅘ", "ㅙ", "ㅚ", "ㅛ", "ㅜ", "ㅝ", "ㅞ", "ㅟ", "ㅠ", "ㅡ", "ㅢ", "ㅣ"};
		String[] JONG = {"", "ㄱ", "ㄲ", "ㄳ", "ㄴ", "ㄵ", "ㄶ", "ㄷ", "ㄹ", "ㄺ", "ㄻ", "ㄼ", "ㄽ", "ㄾ", "ㄻ", "ㅀ", "ㅁ", "ㅂ", "ㅄ", "ㅅ", "ㅆ", "ㅇ", "ㅈ", "ㅊ", "ㅋ", "ㅌ", "ㅍ", "ㅎ"};
		String word = "나는 바보다 고로 바보다";
		String a = "";
		
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
			System.out.println(CHO[(int)cho]);
			
			// 중성
			char unijoong = s.charAt(0);
			char joong = (char)((unijoong-0xAC00)/28%21);
			System.out.println(JOONG[(int)joong]);
			
			// 종성
			char unijong = s.charAt(0);
			char jong = (char)((unijong-0xAC00)%28);
			System.out.println(JONG[(int)jong]);
			
		}
		
		
		
	}
}
