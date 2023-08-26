
package kr.co.swh.lecture.opensource.jackson.bus;

/**
 * <pre>
 * kr.co.swh.lecture.opensource.jackson 
 * MessageHeader.java
 *
 * 설명 :
 * </pre>
 * 
 * @since : 2020. 10. 4.
 * @author : tobby48
 * @version : v1.0
 */
public class MessageHeader {

	private String queryTime;
	private String resultCode;
	private String resultMessage;
	public MessageHeader() {
		// TODO Auto-generated constructor stub
	}
	public String getQueryTime() {
		return queryTime;
	}
	public void setQueryTime(String queryTime) {
		this.queryTime = queryTime;
	}
	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	public String getResultMessage() {
		return resultMessage;
	}
	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}

}