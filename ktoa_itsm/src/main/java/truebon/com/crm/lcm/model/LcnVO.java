package truebon.com.crm.lcm.model;
/**
 * 변경관리 처리를 위한 VO 클래스를 정의한다
 * @author 박서일
 * @since 2023.09.22
 * @version 1.0
 * @see
 *  
  * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *  수정일               수정자            수정내용
 *  ----------   --------   ---------------------------
 *  2023.09.22   박서일                최초 생성
 *
 * </pre>
 */

public class LcnVO {

	/** 라이센스 ID  */
	private String lcnId;

	/** 제품명  */
	private String prodNm;
	
	/** 제품명  */
	private String lcnNo;
	
	/** 제품명  */
	private String lcnText;
	
	/** 제품명  */
	private String lcnFileNm;
	
    /** 등록자ID */
    private String regstrId;
    
    /** 등록일 */
    private String rdtt;
    
    /** 수정자ID */
    private String amndrId;
    
    /** 수정자 이름 */
    private String amndrNm;
    
    /** 수정일 */
    private String mdtt;
    
	/** 검색조건 */
    private String searchCondition = "";
    
    /** 검색Keyword */
    private String searchKeyword = "";
    
    /** 멀티 삭제용(콤마로 이루어진 값) */
    private String checkedValueForDel ="";
	
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
    
	public String getLcnId() {
		return lcnId;
	}

	public void setLcnId(String lcnId) {
		this.lcnId = lcnId;
	}
	
	public String getProdNm() {
		return prodNm;
	}

	public void setProdNm(String prodNm) {
		this.prodNm = prodNm;
	}

	public String getLcnNo() {
		return lcnNo;
	}

	public void setLcnNo(String lcnNo) {
		this.lcnNo = lcnNo;
	}

	public String getLcnText() {
		return lcnText;
	}

	public void setLcnText(String lcnText) {
		this.lcnText = lcnText;
	}

	public String getLcnFileNm() {
		return lcnFileNm;
	}

	public void setLcnFileNm(String lcnFileNm) {
		this.lcnFileNm = lcnFileNm;
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

	public String getAmndrId() {
		return amndrId;
	}

	public void setAmndrId(String amndrId) {
		this.amndrId = amndrId;
	}

	public String getAmndrNm() {
		return amndrNm;
	}

	public void setAmndrNm(String amndrNm) {
		this.amndrNm = amndrNm;
	}

	public String getMdtt() {
		return mdtt;
	}

	public void setMdtt(String mdtt) {
		this.mdtt = mdtt;
	}

	public String getSearchCondition() {
		return searchCondition;
	}

	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	public String getCheckedValueForDel() {
		return checkedValueForDel;
	}

	public void setCheckedValueForDel(String checkedValueForDel) {
		this.checkedValueForDel = checkedValueForDel;
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

}
