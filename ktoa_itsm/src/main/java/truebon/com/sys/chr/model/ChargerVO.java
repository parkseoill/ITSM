package truebon.com.sys.chr.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 담당자 처리를 위한 VO 클래스르를 정의한다
 * @author 이태신
 * @since 2022.05.04
 * @version 1.0
 * @see
 *  
  * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *  수정일               수정자            수정내용
 *  ----------   --------   ---------------------------
 *  2022.05.04   이태신           최초 생성
 *
 * </pre>
 */
@SuppressWarnings("serial")
public class ChargerVO extends Charger implements Serializable {

	/** 검색조건 */
    private String searchCondition = "";
    
    /** 검색Keyword */
    private String searchKeyword = "";
    
    /** 검색사용여부 */
    private String searchUseYn = "";
    
    /** 검색코드 */
    private String searchCode;
       
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
    
	/** 소속회사명 */
    private String positCmpnyNm ="";
    
	/** 소속부서명 */
    private String positDeptNm = "";
    
    /** 위탁회사명 */
    private String cosnCmpnyNm = "";
    
    /** 위탁부서명 */
    private String cosnDeptNm = "";
    
    /** 담당자구분코드 Array */
    private List<String> arrChrgrDstnctCd = new ArrayList<String>();
    
    /** 담당자역할명 */
    private String chrgrRoleNm = "";

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

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
    
    public String getCheckedValueForDel() {
		return checkedValueForDel;
	}

	public void setCheckedValueForDel(String checkedValueForDel) {
		this.checkedValueForDel = checkedValueForDel;
	}
	
    public String getPositCmpnyNm() {
		return positCmpnyNm;
	}

	public void setPositCmpnyNm(String positCmpnyNm) {
		this.positCmpnyNm = positCmpnyNm;
	}

	public String getPositDeptNm() {
		return positDeptNm;
	}

	public void setPositDeptNm(String positDeptNm) {
		this.positDeptNm = positDeptNm;
	}

	public String getCosnCmpnyNm() {
		return cosnCmpnyNm;
	}

	public void setCosnCmpnyNm(String cosnCmpnyNm) {
		this.cosnCmpnyNm = cosnCmpnyNm;
	}

	public String getCosnDeptNm() {
		return cosnDeptNm;
	}

	public void setCosnDeptNm(String cosnDeptNm) {
		this.cosnDeptNm = cosnDeptNm;
	}
	
	public List<String> getArrChrgrDstnctCd() {
		return arrChrgrDstnctCd;
	}

	public void setArrChrgrDstnctCd(List<String> arrChrgrDstnctCd) {
		this.arrChrgrDstnctCd = arrChrgrDstnctCd;
	}

	public String getChrgrRoleNm() {
		return chrgrRoleNm;
	}

	public void setChrgrRoleNm(String chrgrRoleNm) {
		this.chrgrRoleNm = chrgrRoleNm;
	}

	public String getSearchCode() {
		return searchCode;
	}

	public void setSearchCode(String searchCode) {
		this.searchCode = searchCode;
	}

}
