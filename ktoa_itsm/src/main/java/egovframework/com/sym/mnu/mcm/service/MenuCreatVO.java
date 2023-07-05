package egovframework.com.sym.mnu.mcm.service;
 
/** 
 * 메뉴생성 처리를 위한 VO 클래스르를 정의한다
 * @author 개발환경 개발팀 이용
 * @since 2009.06.01
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2009.03.20  이  용          최초 생성
 *
 * </pre>
 */
public class MenuCreatVO{


   /** 메뉴번호 */
   private   int      menuNo;
   /** 맵생성ID */
   private   String   mapCreatId;
   /** 권한코드 */
   private   String   authorCode;

   /** 권한정보설정 */
   /** 권한명 */
   private   String   authorNm;
   /** 권한설명 */
   private   String   authorDc;
   /** 권한생성일자 */
   private   String   authorCreatDe;

   /** 기타VO변수 */
   /** 생성자ID **/
   private   String   creatPersonId;
   
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

   
	
	/**
	 * menuNo attribute를 리턴한다.
	 * @return int
	 */
	public int getMenuNo() {
		return menuNo;
	}
	/**
	 * menuNo attribute 값을 설정한다.
	 * @param menuNo int
	 */
	public void setMenuNo(int menuNo) {
		this.menuNo = menuNo;
	}
	/**
	 * mapCreatId attribute를 리턴한다.
	 * @return String
	 */
	public String getMapCreatId() {
		return mapCreatId;
	}
	/**
	 * mapCreatId attribute 값을 설정한다.
	 * @param mapCreatId String
	 */
	public void setMapCreatId(String mapCreatId) {
		this.mapCreatId = mapCreatId;
	}
	/**
	 * authorCode attribute를 리턴한다.
	 * @return String
	 */
	public String getAuthorCode() {
		return authorCode;
	}
	/**
	 * authorCode attribute 값을 설정한다.
	 * @param authorCode String
	 */
	public void setAuthorCode(String authorCode) {
		this.authorCode = authorCode;
	}
	/**
	 * authorNm attribute를 리턴한다.
	 * @return String
	 */
	public String getAuthorNm() {
		return authorNm;
	}
	/**
	 * authorNm attribute 값을 설정한다.
	 * @param authorNm String
	 */
	public void setAuthorNm(String authorNm) {
		this.authorNm = authorNm;
	}
	/**
	 * authorDc attribute를 리턴한다.
	 * @return String
	 */
	public String getAuthorDc() {
		return authorDc;
	}
	/**
	 * authorDc attribute 값을 설정한다.
	 * @param authorDc String
	 */
	public void setAuthorDc(String authorDc) {
		this.authorDc = authorDc;
	}
	/**
	 * authorCreatDe attribute를 리턴한다.
	 * @return String
	 */
	public String getAuthorCreatDe() {
		return authorCreatDe;
	}
	/**
	 * authorCreatDe attribute 값을 설정한다.
	 * @param authorCreatDe String
	 */
	public void setAuthorCreatDe(String authorCreatDe) {
		this.authorCreatDe = authorCreatDe;
	}
	/**
	 * creatPersonId attribute를 리턴한다.
	 * @return String
	 */
	public String getCreatPersonId() {
		return creatPersonId;
	}
	/**
	 * creatPersonId attribute 값을 설정한다.
	 * @param creatPersonId String
	 */
	public void setCreatPersonId(String creatPersonId) {
		this.creatPersonId = creatPersonId;
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


}