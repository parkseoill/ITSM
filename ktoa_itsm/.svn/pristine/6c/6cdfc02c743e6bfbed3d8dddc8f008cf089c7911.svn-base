package truebon.com.rsm.wmr.model;

import java.io.Serializable;

/**
 * 업무상세보고서를 위한 VO 클래스르를 정의한다
 * @author 이태신
 * @since 2022.08.18
 * @version 1.0
 * @see
 *  
  * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *  수정일               수정자            수정내용
 *  ----------   --------   ---------------------------
 *  2022.08.18   이태신           최초 생성
 *
 * </pre>
 */
@SuppressWarnings("serial")
public class BizDetlReportVO extends BizDetlReport implements Serializable {

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
    
    /** 업무시스템명 */
    private String bizSytmNm = "";
    
    /** 업무보고서종류코드 */
    private String bizReportKindCd = "";
     

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
    
    public String getCheckedValueForDel() {
		return checkedValueForDel;
	}

	public void setCheckedValueForDel(String checkedValueForDel) {
		this.checkedValueForDel = checkedValueForDel;
	}

	public String getBizSytmNm() {
		return bizSytmNm;
	}

	public void setBizSytmNm(String bizSytmNm) {
		this.bizSytmNm = bizSytmNm;
	}

	public String getBizReportKindCd() {
		return bizReportKindCd;
	}

	public void setBizReportKindCd(String bizReportKindCd) {
		this.bizReportKindCd = bizReportKindCd;
	}

}
