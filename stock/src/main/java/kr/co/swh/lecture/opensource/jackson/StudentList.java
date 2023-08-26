package kr.co.swh.lecture.opensource.jackson;

import java.util.List;

import lombok.Data;

/**
 * <pre>
 * kr.co.swh.lecture.opensource.jackson
 * StudentList.java
 *
 * 설명 :StudentList 예제
 * </pre>
 * 
 * @since : 2018. 1. 29.
 * @author : tobby48
 * @version : v1.0
 */
@Data
public class StudentList {
	private List<Student> students;
	private String academyName;
	private String location;
}