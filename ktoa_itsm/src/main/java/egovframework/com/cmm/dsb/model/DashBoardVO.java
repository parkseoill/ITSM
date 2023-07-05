package egovframework.com.cmm.dsb.model;

import java.io.Serializable;

/**
 * 대시보드를 위한 VO 클래스를 정의한다
 * @author 최호용
 * @since 2023.06.16
 * @version 1.0
 * @see
 *  
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *	수정일			수정자 		수정내용
 *  ----------	   ------      -----------------------
 *	2023.06.16		최호용		최초 생성
 *
 * </pre>
 */

@SuppressWarnings("serial")
public class DashBoardVO extends DashBoard implements Serializable{
	
	/** 처리 담당자 번호  */
	private String ucn;
	
	/** 전월 */
	private String previous_month = "";
	
	/** 당월 */
	private String current_month = "";
	
	/** 전월 이월 건수 */
	private String previous_month_carry = "";
	
	/** 당월 이월 건수 */
	private String current_month_carry = "";
	
	/** 전월 접수 건수 */
	private String previous_month_all = "";
	
	/** 당월  접수 건수 */
	private String current_month_all = "";
	
	/** 전월 이월 건수 */
	private String previous_all = "";
	
	/** 당월 이월 건수 */
	private String current_all = "";
	
	/** 전월 접수 건수 */
	private String previous_success = "";
	
	/** 당월  접수 건수 */
	private String current_success = "";
	
	/** 전월 sr 전체 접수 건수 */
	private String my_previous_month_all = "";
	
	/** 당월 sr 전체 접수 건수 */
	private String my_current_month_all = "";
	
	/** 전월 sr 처리 건수 */
	private String my_previous_month_process = "";
	
	/** 당월 sr 처리 건수 */
	private String my_current_month_process = "";
	
	/** 전월 이월 건수 */
	private String my_previous_month_carry = "";
	
	/** 당월 이월 건수 */
	private String my_current_month_carry = "";
	
	/** 전월 이월 처리 건수 */
	private String my_previous_month_process_carry = "";
	
	/** 당월 이월 처리 건수 */
	private String my_current_month_process_carry = "";

	/** 근태 날자 */
	private String dlalzDate = "";
	
	/** 근태  이름 */
	private String chrgrNm = "";
	
	public String getPrevious_month() {
		return previous_month;
	}

	public void setPrevious_month(String previous_month) {
		this.previous_month = previous_month;
	}

	public String getCurrent_month() {
		return current_month;
	}

	public void setCurrent_month(String current_month) {
		this.current_month = current_month;
	}
	
	public String getPrevious_month_carry() {
		return previous_month_carry;
	}

	public void setPrevious_month_carry(String previous_month_carry) {
		this.previous_month_carry = previous_month_carry;
	}

	public String getCurrent_month_carry() {
		return current_month_carry;
	}

	public void setCurrent_month_carry(String current_month_carry) {
		this.current_month_carry = current_month_carry;
	}

	public String getPrevious_month_all() {
		return previous_month_all;
	}

	public void setPrevious_month_all(String previous_month_all) {
		this.previous_month_all = previous_month_all;
	}

	public String getCurrent_month_all() {
		return current_month_all;
	}

	public void setCurrent_month_all(String current_month_all) {
		this.current_month_all = current_month_all;
	}

	public String getPrevious_all() {
		return previous_all;
	}

	public void setPrevious_all(String previous_all) {
		this.previous_all = previous_all;
	}

	public String getCurrent_all() {
		return current_all;
	}

	public void setCurrent_all(String current_all) {
		this.current_all = current_all;
	}

	public String getPrevious_success() {
		return previous_success;
	}

	public void setPrevious_success(String previous_success) {
		this.previous_success = previous_success;
	}

	public String getCurrent_success() {
		return current_success;
	}

	public void setCurrent_success(String current_success) {
		this.current_success = current_success;
	}

	public String getMy_previous_month_all() {
		return my_previous_month_all;
	}

	public void setMy_previous_month_all(String my_previous_month_all) {
		this.my_previous_month_all = my_previous_month_all;
	}

	public String getMy_current_month_all() {
		return my_current_month_all;
	}

	public void setMy_current_month_all(String my_current_month_all) {
		this.my_current_month_all = my_current_month_all;
	}

	public String getMy_previous_month_process() {
		return my_previous_month_process;
	}

	public void setMy_previous_month_process(String my_previous_month_process) {
		this.my_previous_month_process = my_previous_month_process;
	}

	public String getMy_current_month_process() {
		return my_current_month_process;
	}

	public void setMy_current_month_process(String my_current_month_process) {
		this.my_current_month_process = my_current_month_process;
	}

	public String getMy_previous_month_carry() {
		return my_previous_month_carry;
	}

	public void setMy_previous_month_carry(String my_previous_month_carry) {
		this.my_previous_month_carry = my_previous_month_carry;
	}

	public String getMy_current_month_carry() {
		return my_current_month_carry;
	}

	public void setMy_current_month_carry(String my_current_month_carry) {
		this.my_current_month_carry = my_current_month_carry;
	}

	public String getMy_previous_month_process_carry() {
		return my_previous_month_process_carry;
	}

	public void setMy_previous_month_process_carry(String my_previous_month_process_carry) {
		this.my_previous_month_process_carry = my_previous_month_process_carry;
	}

	public String getMy_current_month_process_carry() {
		return my_current_month_process_carry;
	}

	public void setMy_current_month_process_carry(String my_current_month_process_carry) {
		this.my_current_month_process_carry = my_current_month_process_carry;
	}

	public String getUcn() {
		return ucn;
	}

	public void setUcn(String ucn) {
		this.ucn = ucn;
	}

	public String getDlalzDate() {
		return dlalzDate;
	}

	public void setDlalzDate(String dlalzDate) {
		this.dlalzDate = dlalzDate;
	}

	public String getChrgrNm() {
		return chrgrNm;
	}

	public void setChrgrNm(String chrgrNm) {
		this.chrgrNm = chrgrNm;
	}

	
	 
}