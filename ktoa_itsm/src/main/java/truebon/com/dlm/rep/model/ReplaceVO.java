package truebon.com.dlm.rep.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ReplaceVO implements Serializable{
	
    /** 검색 날짜  */
    private String selectedDate = "";
   
    /** 대휴 날짜  */
    private String replacOffdayDate; 
   
    /** 대휴 검색 이름  */
    private String name;
   
    /** NO  */
    private String chrgrNo;
   
    /** 이름  */
    private String chrgrNm;
   
    /** 대휴 수  */
    private String replacOffdayCnt;
   
    /** 대휴 사유  */
    private String replacOffdayRsnCd;
   
    /** 대휴 날짜  */
    private String dlalzDate;
   
    /** 대휴 입력수 */
    private String insertCnt;
   
    /** 대휴 입력 선택 날짜 */
    private String selectedDate2 = "";
    
    /** 대휴 합계  */
    private float repSum;
   
    /** 휴가 사용 수  */
    private float useCnt;
   
    /** 대휴 사용 수  */
    private float useRep;
   
    /** 휴가 사용 수  - 대휴 사용 수  */
    private float useSum;
    
    /** 휴일 근무 사유 코드  */
    private String offdayWrkRsnCd;
   
   
	public String getSelectedDate() {
		return selectedDate;
	}
	
	public void setSelectedDate(String selectedDate) {
		this.selectedDate = selectedDate;
	}
	
	public String getReplacOffdayDate() {
		return replacOffdayDate;
	}
	
	public void setReplacOffdayDate(String replacOffdayDate) {
		this.replacOffdayDate = replacOffdayDate;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getChrgrNo() {
		return chrgrNo;
	}
	
	public void setChrgrNo(String chrgrNo) {
		this.chrgrNo = chrgrNo;
	}
	
	public String getChrgrNm() {
		return chrgrNm;
	}
	
	public void setChrgrNm(String chrgrNm) {
		this.chrgrNm = chrgrNm;
	}
	
	public String getReplacOffdayCnt() {
		return replacOffdayCnt;
	}
	
	public void setReplacOffdayCnt(String replacOffdayCnt) {
		this.replacOffdayCnt = replacOffdayCnt;
	}
	
	public String getReplacOffdayRsnCd() {
		return replacOffdayRsnCd;
	}
	
	public void setReplacOffdayRsnCd(String replacOffdayRsnCd) {
		this.replacOffdayRsnCd = replacOffdayRsnCd;
	}
	
	public String getDlalzDate() {
		return dlalzDate;
	}
	
	public void setDlalzDate(String dlalzDate) {
		this.dlalzDate = dlalzDate;
	}
	
	public String getInsertCnt() {
		return insertCnt;
	}
	
	public void setInsertCnt(String insertCnt) {
		this.insertCnt = insertCnt;
	}
	
	public String getSelectedDate2() {
		return selectedDate2;
	}
	
	public void setSelectedDate2(String selectedDate2) {
		this.selectedDate2 = selectedDate2;
	}
	
	public float getRepSum() {
		return repSum;
	}
	
	public void setRepSum(float repSum) {
		this.repSum = repSum;
	}
	
	public float getUseCnt() {
		return useCnt;
	}
	
	public void setUseCnt(float useCnt) {
		this.useCnt = useCnt;
	}
	
	public float getUseRep() {
		return useRep;
	}
	
	public void setUseRep(float useRep) {
		this.useRep = useRep;
	}
	
	public float getUseSum() {
		return useSum;
	}
	
	public void setUseSum(float useSum) {
		this.useSum = useSum;
	}

	public String getOffdayWrkRsnCd() {
		return offdayWrkRsnCd;
	}

	public void setOffdayWrkRsnCd(String offdayWrkRsnCd) {
		this.offdayWrkRsnCd = offdayWrkRsnCd;
	}


}
   