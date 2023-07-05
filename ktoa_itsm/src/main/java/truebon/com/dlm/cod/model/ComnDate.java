package truebon.com.dlm.cod.model;

import java.io.Serializable;

/**
 * 공통일자를 위한 모델 클래스를 정의한다.
 * @author 이유리
 * @since 2022.05.23
 * @version 1.0
 * @see
 *  
  * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *  수정일               수정자            수정내용
 *  ----------   --------   ---------------------------
 *  2022.05.23   이유리           최초 생성
 *  
 * </pre>
 */

@SuppressWarnings("serial")
public class ComnDate implements Serializable {

	/** 기준일자 */
	private String stdrDate;
	
	/** 요일구분코드 */
	private String dyweekDstnctCd;
	
	/** 공휴일구분코드 */
	private String hdayDstnctCd;
	
	/** 공휴일명 */
	private String hdayNm;
	
	/** 등록자ID */
	private String regstrId;
	
	/** 등록일 */
	private String rdtt;	
	
	/** 수정자ID */
	private String amndrId;	
	
	/** 수정일 */
	private String mdtt;
	
	/** 요일 */
	private String dayOfCheckDate;
	
	/** 월의 마지막 날짜 */
	private String lastDate;
	
	/** 검사할 날짜 */
	private String checkDate;

	
	/** 기준일자 */
	public String getStdrDate() {
		return stdrDate;
	}

	public void setStdrDate(String stdrDate) {
		this.stdrDate = stdrDate;
	}

	/** 요일구분코드 */
	public String getDyweekDstnctCd() {
		return dyweekDstnctCd;
	}

	public void setDyweekDstnctCd(String dyweekDstnctCd) {
		this.dyweekDstnctCd = dyweekDstnctCd;
	}

	/** 공휴일구분코드 */
	public String getHdayDstnctCd() {
		return hdayDstnctCd;
	}

	public void setHdayDstnctCd(String hdayDstnctCd) {
		this.hdayDstnctCd = hdayDstnctCd;
	}

	/** 공휴일명 */
	public String getHdayNm() {
		return hdayNm;
	}

	public void setHdayNm(String hdayNm) {
		this.hdayNm = hdayNm;
	}

	/** 등록자ID */
	public String getRegstrId() {
		return regstrId;
	}

	public void setRegstrId(String regstrId) {
		this.regstrId = regstrId;
	}

	/** 등록일 */
	public String getRdtt() {
		return rdtt;
	}

	public void setRdtt(String rdtt) {
		this.rdtt = rdtt;
	}

	/** 수정자ID */
	public String getAmndrId() {
		return amndrId;
	}

	public void setAmndrId(String amndrId) {
		this.amndrId = amndrId;
	}

	/** 수정일 */
	public String getMdtt() {
		return mdtt;
	}

	public void setMdtt(String mdtt) {
		this.mdtt = mdtt;
	}

	/** 요일 */
	public String getDayOfCheckDate() {
		return dayOfCheckDate;
	}

	public void setDayOfCheckDate(String dayOfCheckDate) {
		this.dayOfCheckDate = dayOfCheckDate;
	}

	/** 월의 마지막 날짜 */
	public String getLastDate() {
		return lastDate;
	}

	public void setLastDate(String lastDate) {
		this.lastDate = lastDate;
	}

	/** 검사할 날짜 */
	public String getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(String checkDate) {
		this.checkDate = checkDate;
	}
	
}
