package truebon.com.dlm.wrk.model;

import java.io.Serializable;

/**
 * 근무편성표를 위한 모델 클래스를 정의한다
 * 
 * @author 김승현
 * @since 2023.04.13
 * @version 1.0
 * @see
 *  
  * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *  수정일               수정자            수정내용
 *  ----------   --------   ---------------------------
 *  2023.04.13   김승현           최초 생성
 * </pre>
 */

@SuppressWarnings("serial")
public class Work implements Serializable{
   
   /** 근태일자 */
    private String dlalzDate;
    
    /** 담당자번호 */
    private String chrgrNo;
    
    /** 근태구분코드 */
    private String dlalzDstnctCd;
    
    /** 근무유형구분 */
    private String wrkTypeCd;
    
    /** 근무시간코드 */
    private String wrkTimeCd;
    
    /** 대휴 특이사항 목록 */
    private String sumOffdayRmark;
    
    /** 휴무유형코드 */
    private String offdayTypeCd;
    
    /** 휴일 근무 사유 */
    private String offdayWrkRsnCd;
    
    /** 반일휴무유형코드 */
    private String hlfdayOffdayDstnctCd;
   
    /** 보안당직여부 */
    private String securBonduYn;
    
    /** 비고내용 */
    private String rmarkText;
    
    /** 대휴 특이사항 목록 */
    private String sumPlnOffdayRmark;
    
    /** 등록자ID */
    private String regstrId;
    
    /** 수정자ID */
    private String amndrId;
    
    /** 담당자명 */
    private String chrgrNm;
    
    /** 검사할 날짜 */
    private String checkDate;
    
    /** 담당자역할코드 */
    private String chrgrRoleCd;
    
    /** 조회할 년월 날짜 */
    private String selectedDate = "";
    
    /** OP 일괄 수정 년월 날짜 */
    private String selectedOpDate = "";
    
    /** 담당자 구분*/
    private String comnCdNm;
    
    /**요일 구분*/
    private String dyweekDstnctCd;
    
    /** 공통 날짜  */
    private String stdrDate;
    
    /** 공통 휴무 코드 */
    private String hdayDstinctCd;
    
    /** OP 일괄 입력 날짜 체크 1일 or2일 */
    private String opDatechk;
    
    /** OP 근무 코드  */
    private String opWrkTimeCd;   
    
    /** 계획 대휴 특이사항  */
    private String plnOffdayRmark;    
    
    /** 계획 휴무유형코드 */
    private String plnOffdayTypeCd;
    
    /** 계획 반일휴무유형코드 */
    private String plnHlfdayOffdayDstnctCd;   
    
    /** 계획 휴일 근무 사유 */
    private String plnOffdayWrkRsnCd;
  
    /** 계획 OP 근무 코드  */
    private String plnOpWrkTimeCd;
    
 
    
   public String getDlalzDate() {
      return dlalzDate;
   }
   public void setDlalzDate(String dlalzDate) {
      this.dlalzDate = dlalzDate;
   }
   
   public String getChrgrNo() {
      return chrgrNo;
   }
   public void setChrgrNo(String chrgrNo) {
      this.chrgrNo = chrgrNo;
   }
   
   public String getHlfdayOffdayDstnctCd() {
      return hlfdayOffdayDstnctCd;
   }
   public void setHlfdayOffdayDstnctCd(String hlfdayOffdayDstnctCd) {
      this.hlfdayOffdayDstnctCd = hlfdayOffdayDstnctCd;
   }
   
   public String getDlalzDstnctCd() {
      return dlalzDstnctCd;
   }
   public void setDlalzDstnctCd(String dlalzDstnctCd) {
      this.dlalzDstnctCd = dlalzDstnctCd;
   }
   
   public String getWrkTypeCd() {
      return wrkTypeCd;
   }
   public void setWrkTypeCd(String wrkTypeCd) {
      this.wrkTypeCd = wrkTypeCd;
   }
   
   public String getWrkTimeCd() {
      return wrkTimeCd;
   }
   public void setWrkTimeCd(String wrkTimeCd) {
      this.wrkTimeCd = wrkTimeCd;
   }
   
   public String getOffdayTypeCd() {
      return offdayTypeCd;
   }
   public void setOffdayTypeCd(String offdayTypeCd) {
      this.offdayTypeCd = offdayTypeCd;
   }
   
   public String getSecurBonduYn() {
      return securBonduYn;
   }
   public void setSecurBonduYn(String securBonduYn) {
      this.securBonduYn = securBonduYn;
   }
   
   public String getRmarkText() {
      return rmarkText;
   }
   public void setRmarkText(String rmarkText) {
      this.rmarkText = rmarkText;
   }
   
   public String getRegstrId() {
      return regstrId;
   }
   public void setRegstrId(String regstrId) {
      this.regstrId = regstrId;
   }
   
   public String getAmndrId() {
      return amndrId;
   }
   public void setAmndrId(String amndrId) {
      this.amndrId = amndrId;
   }
   
   public String getChrgrNm() {
      return chrgrNm;
   }
   public void setChrgrNm(String chrgrNm) {
      this.chrgrNm = chrgrNm;
   }
   
   public String getCheckDate() {
      return checkDate;
   }
   public void setCheckDate(String checkDate) {
      this.checkDate = checkDate;
   }
   
   public String getChrgrRoleCd() {
      return chrgrRoleCd;
   }
   public void setChrgrRoleCd(String chrgrRoleCd) {
      this.chrgrRoleCd = chrgrRoleCd;
   }
   
   public String getSelectedDate() {
      return selectedDate;
   }
   public void setSelectedDate(String selectedDate) {
      this.selectedDate = selectedDate;
   }
   
   public String getComnCdNm() {
      return comnCdNm;
   }
   public void setComnCdNm(String comnCdNm) {
      this.comnCdNm = comnCdNm;
   }
   
   public String getPlnOffdayTypeCd() {
      return plnOffdayTypeCd;
   }
   public void setPlnOffdayTypeCd(String plnOffdayTypeCd) {
      this.plnOffdayTypeCd = plnOffdayTypeCd;
   }
   
   public String getPlnHlfdayOffdayDstnctCd() {
      return plnHlfdayOffdayDstnctCd;
   }
   public void setPlnHlfdayOffdayDstnctCd(String plnHlfdayOffdayDstnctCd) {
      this.plnHlfdayOffdayDstnctCd = plnHlfdayOffdayDstnctCd;
   }
   
   public String getDyweekDstnctCd() {
      return dyweekDstnctCd;
   }
   public void setDyweekDstnctCd(String dyweekDstnctCd) {
      this.dyweekDstnctCd = dyweekDstnctCd;
   }
   
	public String getPlnOffdayRmark() {
		return plnOffdayRmark;
	}
	public void setPlnOffdayRmark(String plnOffdayRmark) {
		this.plnOffdayRmark = plnOffdayRmark;
	}
	
	public String getSumPlnOffdayRmark() {
		return sumPlnOffdayRmark;
	}
	public void setSumPlnOffdayRmark(String sumPlnOffdayRmark) {
		this.sumPlnOffdayRmark = sumPlnOffdayRmark;
	}
	
	public String getPlnOffdayWrkRsnCd() {
		return plnOffdayWrkRsnCd;
	}
	public void setPlnOffdayWrkRsnCd(String plnOffdayWrkRsnCd) {
		this.plnOffdayWrkRsnCd = plnOffdayWrkRsnCd;
	}
	
	public String getOffdayWrkRsnCd() {
		return offdayWrkRsnCd;
	}
	public void setOffdayWrkRsnCd(String offdayWrkRsnCd) {
		this.offdayWrkRsnCd = offdayWrkRsnCd;
	}
	
	public String getPlnOpWrkTimeCd() {
		return plnOpWrkTimeCd;
	}
	public void setPlnOpWrkTimeCd(String plnOpWrkTimeCd) {
		this.plnOpWrkTimeCd = plnOpWrkTimeCd;
	}
	
	public String getOpWrkTimeCd() {
		return opWrkTimeCd;
	}
	public void setOpWrkTimeCd(String opWrkTimeCd) {
		this.opWrkTimeCd = opWrkTimeCd;
	}
	
	public String getSumOffdayRmark() {
		return sumOffdayRmark;
	}
	public void setSumOffdayRmark(String sumOffdayRmark) {
		this.sumOffdayRmark = sumOffdayRmark;
	}
	
	public String getStdrDate() {
		return stdrDate;
	}
	public void setStdrDate(String stdrDate) {
		this.stdrDate = stdrDate;
	}
	
	public String getHdayDstinctCd() {
		return hdayDstinctCd;
	}
	public void setHdayDstinctCd(String hdayDstinctCd) {
		this.hdayDstinctCd = hdayDstinctCd;
	}
	public String getOpDatechk() {
		return opDatechk;
	}
	public void setOpDatechk(String opDatechk) {
		this.opDatechk = opDatechk;
	}
	public String getSelectedOpDate() {
		return selectedOpDate;
	}
	public void setSelectedOpDate(String selectedOpDate) {
		this.selectedOpDate = selectedOpDate;
	}
		
	
         
}
