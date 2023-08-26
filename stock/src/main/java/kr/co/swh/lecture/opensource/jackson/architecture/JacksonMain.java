package kr.co.swh.lecture.opensource.jackson.architecture;

/**
 * <pre>
 * kr.co.swh.lecture.opensource.jackson.architecture
 * JacksonJsonMain.java
 *
 * 설명 :Jackson Json 예제
 * </pre>
 * 
 * @since : 2018. 1. 29.
 * @author : tobby48
 * @version : v1.0
 */
public class JacksonMain {
	
	public static void main(String[] args) throws Exception  {
		// TODO Auto-generated method stub
		IService service = new Jackson("json.json");
		
		service = new Jackson("xml.xml");
		service.deserialize();
		service.serialize();
	}

}