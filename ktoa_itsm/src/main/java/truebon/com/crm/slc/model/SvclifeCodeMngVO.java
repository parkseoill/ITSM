package truebon.com.crm.slc.model;

import java.io.Serializable;

/**
 * 내용연수 관리 목록 처리를 위한 VO 클래스를 정의한다
 * @author 이미현
 * @since 2023.11.06
 * @version 1.0
 * @see
 *  
  * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *  수정일                       수정자                 수정내용
 *  ----------   --------   ---------------------------
 *  2023.11.06   이미현                   최초 생성
 *
 * </pre>
 */
@SuppressWarnings("serial")
public class SvclifeCodeMngVO implements Serializable {

	/** 내용연수ID */
    private String svcLifeId = "";
    
    /** HW유형코드 */
    private String hwType = "";
    
    /** HW유형상세코드 */
    private String hwTypeDtl = "";
    
    /** 조달청품명 */
    private String pblprSrvcPdctNm = "";
    
    /** 내용연수 */
    private String textYearCo = "";
    
    /** 비고내용 */
    private String rmarkText = "";
    
    /** 검색  HW유형*/
    private String searchKeyword1;
    
    /** 현재페이지 */
    private int pageIndex = 1;
    
    /** 페이지갯수 */
    private int pageUnit = 10;
    
    /** 페이지사이즈 */
    private int pageSize = 10;

    /** firstIndex */
    private int firstIndex = 1;

    /** lastIndex */
    private int lastIndex = 1;

    /** recordCountPerPage */
    private int recordCountPerPage = 10;
    
    /** 수정자ID */
    private String amndrId;
    
    /** 수정일 */
    private String mdtt;
    
    /** 등록자ID */
    private String regstrId;
   
    /** 등록일 */
    private String rdtt;
    

	public String getSvcLifeId() {
		return svcLifeId;
	}

	public void setSvcLifeId(String svcLifeId) {
		this.svcLifeId = svcLifeId;
	}

	public String getHwType() {
		return hwType;
	}

	public void setHwType(String hwType) {
		this.hwType = hwType;
	}

	public String getHwTypeDtl() {
		return hwTypeDtl;
	}

	public void setHwTypeDtl(String hwTypeDtl) {
		this.hwTypeDtl = hwTypeDtl;
	}

	public String getPblprSrvcPdctNm() {
		return pblprSrvcPdctNm;
	}

	public void setPblprSrvcPdctNm(String pblprSrvcPdctNm) {
		this.pblprSrvcPdctNm = pblprSrvcPdctNm;
	}

	public String getTextYearCo() {
		return textYearCo;
	}

	public void setTextYearCo(String textYearCo) {
		this.textYearCo = textYearCo;
	}

	public String getRmarkText() {
		return rmarkText;
	}

	public void setRmarkText(String rmarkText) {
		this.rmarkText = rmarkText;
	}

	public String getSearchKeyword1() {
		return searchKeyword1;
	}

	public void setSearchKeyword1(String searchKeyword1) {
		this.searchKeyword1 = searchKeyword1;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageUnit() {
		return pageUnit;
	}

	public void setPageUnit(int pageUnit) {
		this.pageUnit = pageUnit;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getFirstIndex() {
		return firstIndex;
	}

	public void setFirstIndex(int firstIndex) {
		this.firstIndex = firstIndex;
	}

	public int getLastIndex() {
		return lastIndex;
	}

	public void setLastIndex(int lastIndex) {
		this.lastIndex = lastIndex;
	}

	public int getRecordCountPerPage() {
		return recordCountPerPage;
	}

	public void setRecordCountPerPage(int recordCountPerPage) {
		this.recordCountPerPage = recordCountPerPage;
	}

	public String getAmndrId() {
		return amndrId;
	}

	public void setAmndrId(String amndrId) {
		this.amndrId = amndrId;
	}

	public String getMdtt() {
		return mdtt;
	}

	public void setMdtt(String mdtt) {
		this.mdtt = mdtt;
	}

	public String getRegstrId() {
		return regstrId;
	}

	public void setRegstrId(String regstrId) {
		this.regstrId = regstrId;
	}

	public String getRdtt() {
		return rdtt;
	}

	public void setRdtt(String rdtt) {
		this.rdtt = rdtt;
	}
}
