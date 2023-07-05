package truebon.com.rsm.wmr.model;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 업무보고서를 위한 VO 클래스르를 정의한다
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
public class BizReportVO extends BizReport implements Serializable {

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
    
    /** 생성담당자명 */
    private String creatChrgrNm = "";
    
    /** 업무보고서 종류 명 */
    private String bizReportKindNm = "";
    
    /** 업무시스템코드(TB_BIZ_DETL_REPORT 테이블 컬럼) */
    private String bizSytmCd = "";
    
    /** 업무처리담당자번호(TB_BIZ_DETL_REPORT 테이블 컬럼) */
    private String bizDlngChrgrNo = "";
    
    /** 실적내용(TB_BIZ_DETL_REPORT 테이블 컬럼) */
    private String acrsltText = "";
    
    /** 계획내용(TB_BIZ_DETL_REPORT 테이블 컬럼) */
    private String plnText = "";
        
    /** 업무시스템코드(TB_BIZ_DETL_REPORT 테이블 컬럼) */
    private String[] arrBizSytmCd;

    /** 실적내용(TB_BIZ_DETL_REPORT 테이블 컬럼) */
    private String[] arrAcrsltText;
    
    /** 계획내용(TB_BIZ_DETL_REPORT 테이블 컬럼) */
    private String[] arrPlnText;
    
    /** 작성일자 검색 시작일 */
    private String startDate = "";
    
    /** 작성일자 검색 마지막일  */
    private String endDate = "";
    
    /** Jasper Reports 업무보고서용 담당자   */
    private String repoChrgrNm = "";
    
    /** Jasper Reports 업무보고서용 회사명   */
    private String repoChrgrCmpnyNm = "";
    
    /** Jasper Reports 업무보고서용 담당업무   */
    private String repoChrgrRoleNm = "";
    
    /** Jasper Reports 업무보고서용 작성일자   */
    private String repoCurrDate = "";

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

	public String getCreatChrgrNm() {
		return creatChrgrNm;
	}

	public void setCreatChrgrNm(String creatChrgrNm) {
		this.creatChrgrNm = creatChrgrNm;
	}

	public String getBizReportKindNm() {
		return bizReportKindNm;
	}

	public void setBizReportKindNm(String bizReportKindNm) {
		this.bizReportKindNm = bizReportKindNm;
	}

	public String getBizSytmCd() {
		return bizSytmCd;
	}

	public void setBizSytmCd(String bizSytmCd) {
		this.bizSytmCd = bizSytmCd;
	}

	public String getBizDlngChrgrNo() {
		return bizDlngChrgrNo;
	}

	public void setBizDlngChrgrNo(String bizDlngChrgrNo) {
		this.bizDlngChrgrNo = bizDlngChrgrNo;
	}

	public String getAcrsltText() {
		return acrsltText;
	}

	public void setAcrsltText(String acrsltText) {
		this.acrsltText = acrsltText;
	}

	public String getPlnText() {
		return plnText;
	}

	public void setPlnText(String plnText) {
		this.plnText = plnText;
	}

	public String[] getArrBizSytmCd() {
		return arrBizSytmCd;
	}

	public void setArrBizSytmCd(String[] arrBizSytmCd) {
		this.arrBizSytmCd = arrBizSytmCd;
	}

	public String[] getArrAcrsltText() {
		return arrAcrsltText;
	}

	public void setArrAcrsltText(String[] arrAcrsltText) {
		this.arrAcrsltText = arrAcrsltText;
	}

	public String[] getArrPlnText() {
		return arrPlnText;
	}

	public void setArrPlnText(String[] arrPlnText) {
		this.arrPlnText = arrPlnText;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getRepoChrgrNm() {
		return repoChrgrNm;
	}

	public void setRepoChrgrNm(String repoChrgrNm) {
		this.repoChrgrNm = repoChrgrNm;
	}

	public String getRepoChrgrCmpnyNm() {
		return repoChrgrCmpnyNm;
	}

	public void setRepoChrgrCmpnyNm(String repoChrgrCmpnyNm) {
		this.repoChrgrCmpnyNm = repoChrgrCmpnyNm;
	}

	public String getRepoChrgrRoleNm() {
		return repoChrgrRoleNm;
	}

	public void setRepoChrgrRoleNm(String repoChrgrRoleNm) {
		this.repoChrgrRoleNm = repoChrgrRoleNm;
	}

	public String getRepoCurrDate() {
		return repoCurrDate;
	}

	public void setRepoCurrDate(String repoCurrDate) {
		this.repoCurrDate = repoCurrDate;
	}

}
