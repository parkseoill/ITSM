package truebon.com.dlm.dla.model;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 근태 처리를 위한 VO 클래스를 정의한다
 * @author 김도아
 * @since 2022.05.23
 * @version 1.0
 * @see
 *  
  * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *  수정일               수정자            수정내용
 *  ----------   --------   ---------------------------
 *  2022.05.23   김도아           최초 생성
 *  2022.05.31   이유리           수정
 * </pre>
 */

@SuppressWarnings("serial")
public class DlalzVO extends Dlalz implements Serializable{

   /** 검색조건  */
    private String searchCondition = "";
    
    /** 검색Keyword - 담당자 이름*/
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
    
    /** 검색Keyword -근태일자 */
    private String searchKeyword2 = "";
    
    /** 검색Keyword - 근무유형 */
    private String searchKeyword3 = "";
    
    /** 검색Keyword - 휴무유형 */
    private String searchKeyword4 = "";
    
    /** 검색Keyword - 반일휴무*/
    private String searchKeyword5 = "";
    
    /** 검색Keyword - 반일휴무*/
    private String searchKeyword6 = "";
    
    /** 담당자명 */
    private String chrgrNm = "";
    
    /** 회사명 */
    private String cmpnyNm = "";
    
    /** 출근 여부 */
    private String atendTimeYn = "";
    
    /** 퇴근 여부 */
    private String leofcTimeYn = "";
    
    /** 출근, 퇴근 구분 */
    private String atLeGubun = "";
    
    /** 수정자이름 */
    private String amndrNm;
    
    
    
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

   public String getSearchKeyword2() {
      return searchKeyword2;
   }

   public void setSearchKeyword2(String searchKeyword2) {
      this.searchKeyword2 = searchKeyword2;
   }

   public String getSearchKeyword3() {
      return searchKeyword3;
   }

   public void setSearchKeyword3(String searchKeyword3) {
      this.searchKeyword3 = searchKeyword3;
   }

   public String getSearchKeyword4() {
      return searchKeyword4;
   }

   public void setSearchKeyword4(String searchKeyword4) {
      this.searchKeyword4 = searchKeyword4;
   }

   public String getSearchKeyword5() {
      return searchKeyword5;
   }

   public void setSearchKeyword5(String searchKeyword5) {
      this.searchKeyword5 = searchKeyword5;
   }

   public String getSearchKeyword6() {
      return searchKeyword6;
   }

   public void setSearchKeyword6(String searchKeyword6) {
      this.searchKeyword6 = searchKeyword6;
   }
   
   public String getChrgrNm() {
      return chrgrNm;
   }

   public void setChrgrNm(String chrgrNm) {
      this.chrgrNm = chrgrNm;
   }
   
   public String getCmpnyNm() {
      return cmpnyNm;
   }

   public void setCmpnyNm(String cmpnyNm) {
      this.cmpnyNm = cmpnyNm;
   }
   
   public String getAtendTimeYn() {
      return atendTimeYn;
   }

   public void setAtendTimeYn(String atendTimeYn) {
      this.atendTimeYn = atendTimeYn;
   }

   public String getLeofcTimeYn() {
      return leofcTimeYn;
   }

   public void setLeofcTimeYn(String leofcTimeYn) {
      this.leofcTimeYn = leofcTimeYn;
   }
   
   public String getAtLeGubun() {
      return atLeGubun;
   }

   public void setAtLeGubun(String atLeGubun) {
      this.atLeGubun = atLeGubun;
   }

   public String getAmndrNm() {
      return amndrNm;
   }

   public void setAmndrNm(String amndrNm) {
      this.amndrNm = amndrNm;
   }
}