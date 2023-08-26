package kr.co.swh.lecture.opensource.jackson.architecture; 


/**
 * <pre>
 * kr.co.swh.lecture.opensource.jackson.architecture 
 * IService.java
 *
 * 설명 :
 * </pre>
 * 
 * @since : 2019. 3. 29.
 * @author : tobby48
 * @version : v1.0
 */
public interface IService {
	public void deserialize() throws Exception;
	public void serialize() throws Exception;
}