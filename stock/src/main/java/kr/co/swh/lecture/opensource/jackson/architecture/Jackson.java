package kr.co.swh.lecture.opensource.jackson.architecture;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

/**
 * <pre>
 * kr.co.swh.lecture.opensource.jackson.architecture
 * Jackson.java
 *
 * 설명 :Jackson Json 예제
 * </pre>
 * 
 * @since : 2018. 1. 29.
 * @author : tobby48
 * @version : v1.0
 */
public class Jackson implements IService{
	
	private ObjectMapper mapper;
	private InputStream is;
	
	@SuppressWarnings("static-access")
	public Jackson(String fileName){
		String suffixName = fileName.substring(fileName.length()-4, fileName.length());
		if(suffixName.equalsIgnoreCase("json")) {
			mapper = new ObjectMapper();
		}else {
			mapper = new XmlMapper();
			mapper.enable(SerializationFeature.INDENT_OUTPUT);
		}
		is = Thread.currentThread().getContextClassLoader().getSystemResourceAsStream(fileName);
	}
	
	@Override
	public void deserialize() throws Exception {
		// TODO Auto-generated method stub
		StudentList value = mapper.readValue(is, StudentList.class);
		System.out.println(value);
	}
	
	@Override
	public void serialize() throws Exception {
		// TODO Auto-generated method stub
		StudentList list = new StudentList();
		List<Student> studentList = new ArrayList<Student>();
		
		Student s1 = new Student();
		s1.setN("돌쌤");
		s1.setAge(18);
		List<String> addressList = new ArrayList<String>();
		addressList.add("안흥");
		addressList.add("증포");
		s1.setAddresses(addressList);
		studentList.add(s1);
		
		Student s2 = new Student();
		s2.setN("하마쌤");
		s2.setAge(28);
		studentList.add(s2);
		
		list.setStudent(studentList);
		System.out.println(mapper.writeValueAsString(list));
	}
}