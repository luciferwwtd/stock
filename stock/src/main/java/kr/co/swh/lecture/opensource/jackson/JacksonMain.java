package kr.co.swh.lecture.opensource.jackson;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * <pre>
 * kr.co.swh.lecture.opensource.jackson
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
	
	private ObjectMapper mapper = new ObjectMapper();
	private InputStream is;
	
	@SuppressWarnings("static-access")
	public JacksonMain(){
		is = Thread.currentThread().getContextClassLoader().getSystemResourceAsStream("json.json");
		mapper.setSerializationInclusion(Include.NON_NULL);		//	Serialize 시에 무시, Deserialize 시에 초기값
	}
	
	public void deserialize() throws Exception{
		StudentList value = mapper.readValue(is, StudentList.class);
		System.out.println(value);
	}
	
	public void serialize() throws Exception{
		StudentList list = new StudentList();
		List<Student> studentList = new ArrayList<Student>();
		
		Student s1 = new Student();
		s1.setName("돌쌤");
		s1.setAge(18);
		List<String> addressList = new ArrayList<String>();
		addressList.add("안흥");
		addressList.add("증포");
		s1.setAddresses(addressList);
		studentList.add(s1);
		
		Student s2 = new Student();
		s2.setName("하마쌤");
		s2.setAge(28);
		studentList.add(s2);
		
		list.setStudents(studentList);
		System.out.println(mapper.writeValueAsString(list));
	}
	
	public static void main(String[] args) throws Exception  {
		// TODO Auto-generated method stub
		JacksonMain jackson = new JacksonMain();
		jackson.deserialize();
		jackson.serialize();
	}
}