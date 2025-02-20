package truebon.com.crm.swm.model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 전산자원관리 처리(SW자산)를 위한 VO 클래스를 정의한다
 * @author 이정하
 * @since 2023.09.19
 * @version 1.0
 * @see
 *  
  * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *  수정일               수정자            수정내용
 *  ----------   --------   ---------------------------
 *  2023.09.19   이정하           최초 생성
 *
 * </pre>
 */

@SuppressWarnings("serial")
public class SwMngVO extends SwMng implements Serializable {
	/** 검색조건 */
	private String searchCondition = "";

	/** 검색Keyword */
	private String searchKeyword = "";

	/** 검색사용여부 */
	private String searchUseYn = "";

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

	/** 멀티 삭제용(콤마로 이루어진 값) */
	private String checkedValueForDel ="";

	/** 네트워크구분  */
	private String searchNtwrkCd = "";
	private String[] searchNtwrkCdList;
	
	/** 업무시스템   */
	private String searchBizSytmCd = "";

	/** 자산상태   */
	private String searchAssetStatCd = "";
	private String[] searchAssetStatCdList;
	
	/** 자산소유  */
	private String searchAssetOwnCd = "";
	
	/** SW유형  */
	private String searchSwTypeCd = "";
	private String[] searchSwTypeCdList;
	
	/** 유지보수 계약   */
	private String searchMaintceCd = "";
	private String[] searchMaintceCdList;
	
	/** 점검주기   */
	private String searchMaintceInspCd = "";
	private String[] searchMaintceInspCdList;
	
	/** 검색Keyword - 제조사명  */
	private String searchMnftrNm = "";

	/** 검색Keyword - 제품명  */
	private String searchProdNm = "";
	
	/** 사용여부 */
	private String searchDelYn = "N";
	
	 /** 네트워크명  */
    private String ntwrkDstnctCdNm = "";
    
	/** SW유형명  */
    private String swTypeNm = "";

    /** 시스템명 */
    private String bizSytmNm = "";

    public String getNtwrkDstnctCdNm() {
		return ntwrkDstnctCdNm;
	}

	public void setNtwrkDstnctCdNm(String ntwrkDstnctCdNm) {
		this.ntwrkDstnctCdNm = ntwrkDstnctCdNm;
	}

	public String getSwTypeNm() {
		return swTypeNm;
	}

	public void setSwTypeNm(String swTypeNm) {
		this.swTypeNm = swTypeNm;
	}

	public String getBizSytmNm() {
		return bizSytmNm;
	}

	public void setBizSytmNm(String bizSytmNm) {
		this.bizSytmNm = bizSytmNm;
	}
    /************ 상세페이지 선택 설명 **************/
    /** 유지보수 코드 설명 */
    private String maintceCdDc = "";
    /** SW유형 코드 설명 */
    private String swTypeCdDc = "";
    /************ 담당자 선택 ******************/
    /* 회사명 */
    private String maintceChrCmpny="";
    /* 담당자명 */
    private String maintceChrNm="";

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

	public String getSearchUseYn() {
		return searchUseYn;
	}

	public void setSearchUseYn(String searchUseYn) {
		this.searchUseYn = searchUseYn;
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

	public String getCheckedValueForDel() {
		return checkedValueForDel;
	}

	public void setCheckedValueForDel(String checkedValueForDel) {
		this.checkedValueForDel = checkedValueForDel;
	}

	public String getSearchNtwrkCd() {
		return searchNtwrkCd;
	}

	public void setSearchNtwrkCd(String searchNtwrkCd) {
		this.searchNtwrkCd = searchNtwrkCd;
	}

	public String getSearchBizSytmCd() {
		return searchBizSytmCd;
	}

	public void setSearchBizSytmCd(String searchBizSytmCd) {
		this.searchBizSytmCd = searchBizSytmCd;
	}

	public String getSearchAssetStatCd() {
		return searchAssetStatCd;
	}

	public void setSearchAssetStatCd(String searchAssetStatCd) {
		this.searchAssetStatCd = searchAssetStatCd;
	}

	public String getSearchAssetOwnCd() {
		return searchAssetOwnCd;
	}

	public void setSearchAssetOwnCd(String searchAssetOwnCd) {
		this.searchAssetOwnCd = searchAssetOwnCd;
	}

	public String getSearchMaintceCd() {
		return searchMaintceCd;
	}

	public void setSearchMaintceCd(String searchMaintceCd) {
		this.searchMaintceCd = searchMaintceCd;
	}

	public String getSearchMaintceInspCd() {
		return searchMaintceInspCd;
	}

	public void setSearchMaintceInspCd(String searchMaintceInspCd) {
		this.searchMaintceInspCd = searchMaintceInspCd;
	}

	public String getSearchMnftrNm() {
		return searchMnftrNm;
	}

	public void setSearchMnftrNm(String searchMnftrNm) {
		this.searchMnftrNm = searchMnftrNm;
	}

	public String getSearchProdNm() {
		return searchProdNm;
	}

	public void setSearchProdNm(String searchProdNm) {
		this.searchProdNm = searchProdNm;
	}

	public String getSearchDelYn() {
		return searchDelYn;
	}

	public void setSearchDelYn(String searchDelYn) {
		this.searchDelYn = searchDelYn;
	}

	public String getSearchSwTypeCd() {
		return searchSwTypeCd;
	}

	public void setSearchSwTypeCd(String searchSwTypeCd) {
		this.searchSwTypeCd = searchSwTypeCd;
	}

	public String getMaintceCdDc() {
		return maintceCdDc;
	}

	public void setMaintceCdDc(String maintceCdDc) {
		this.maintceCdDc = maintceCdDc;
	}

	public String getSwTypeCdDc() {
		return swTypeCdDc;
	}

	public void setSwTypeCdDc(String swTypeCdDc) {
		this.swTypeCdDc = swTypeCdDc;
	}

	public String getMaintceChrCmpny() {
		return maintceChrCmpny;
	}

	public void setMaintceChrCmpny(String maintceChrCmpny) {
		this.maintceChrCmpny = maintceChrCmpny;
	}

	public String getMaintceChrNm() {
		return maintceChrNm;
	}

	public void setMaintceChrNm(String maintceChrNm) {
		this.maintceChrNm = maintceChrNm;
	}


	public String[] getSearchNtwrkCdList() {
		return searchNtwrkCdList;
	}

	public void setSearchNtwrkCdList(String[] searchNtwrkCdList) {
		this.searchNtwrkCdList = searchNtwrkCdList;
	}

	public String[] getSearchAssetStatCdList() {
		return searchAssetStatCdList;
	}

	public void setSearchAssetStatCdList(String[] searchAssetStatCdList) {
		this.searchAssetStatCdList = searchAssetStatCdList;
	}

	public String[] getSearchSwTypeCdList() {
		return searchSwTypeCdList;
	}

	public void setSearchSwTypeCdList(String[] searchSwTypeCdList) {
		this.searchSwTypeCdList = searchSwTypeCdList;
	}

	public String[] getSearchMaintceCdList() {
		return searchMaintceCdList;
	}

	public void setSearchMaintceCdList(String[] searchMaintceCdList) {
		this.searchMaintceCdList = searchMaintceCdList;
	}

	public String[] getSearchMaintceInspCdList() {
		return searchMaintceInspCdList;
	}

	public void setSearchMaintceInspCdList(String[] searchMaintceInspCdList) {
		this.searchMaintceInspCdList = searchMaintceInspCdList;
	}

	
	
}
