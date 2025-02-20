package truebon.com.crm.slm.model;

import java.io.Serializable;

/**
 * 변경관리 처리를 위한 VO 클래스를 정의한다
 * @author 이미현
 * @since 2023.09.22
 * @version 1.0
 * @see
 *  
  * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *  수정일                       수정자                 수정내용
 *  ----------   --------   ---------------------------
 *  2023.09.22   이미현                   최초 생성
 *
 * </pre>
 */
@SuppressWarnings("serial")
public class SvclifeMngVO implements Serializable {
	
	/** HW자산ID */
    private String hwAssetId = "";
    
	/** 네트워크구분 */
    private String ntwrkDstnct = "";
    
	/** 가상화구분 */
    private String vrtlzDstnct = "";
    
	/** HW유형코드 */
    private String hwType = "";
    
    /** HW유형상세코드 */
    private String hwTypeDtl = "";
    
    /** 가상화유형코드 */
    private String vrtlzType = "";
    
    /** 상위HW자산ID */
    private String upprHwAssetId = "";
    
    /** 업무시스템 */
    private String bizSytm = "";
    
    /** 제품용도 */
    private String prodPurp = "";  
    
    /** 호스트이름 */
    private String hostNm = "";
    
    /** IP주소 */
    private String ipAddr = "";
    
    /** 제조회사명 */
    private String mnftrNm = "";
    
    /** 제품명 */
    private String prodNm = "";
    
    /** 제품수량 */
    private float prodCoQty;
    
    /** 자산소유 */
    private String assetOwn = "";
    
    /** 시리얼넘버 */
    private String serialno = "";
    
    /** 제품위치 */
    private String prodlocat = "";
    
    /** 자산상태 */
    private String assetStat = "";
    
    /** 관제여부 */
    private String ctrlYn = "";
    
    /** 유지보수계약코드 */
    private String maintceCntr = "";
    
    /** 유지보수계약시작일자 */
    private String maintceCntrBeginDate = "";
    
    /** 유지보수계약종료일자 */
    private String maintceCntrEndDate = "";
    
    /** 유지보수점검주기 */
    private String maintceInspCycle = "";
    
    /** 유지보수담당자번호 */
    private String maintceChrgrNo = "";
    
    /** 입고일자 */
    private String entrngDate = "";
    
    /** 검수일자 */
    private String exanDate = "";
    
    /** EOSL일자 */
    private String eoslDate = "";
    
    /** 어플라이언스여부 */
    private String appliYn = "";
    
    /** 정전보상시간 */
    private String blcktRwrdTime = "";
    
    /** 비고내용 */
    private String rmarkText = "";
    
    /** OS내용 */
    private String osText = "";
    
    /** CPU내용 */
    private String cpuText = "";
    
    /** 메모리내용 */
    private String mmryText = "";
    
    /** 디스크내용 */
    private String diskText = "";
    
    /** 서비스이중화구성여부 */
    private String svcDupCnvrConfgYn = "";
    
    /** 이중화내용 */
    private String dplctText = "";
    
    /** KTOA자산번호 */
    private String ktoaAssetNo = "";
    
    /** 삭제여부 */
    private String delYn;
    
    /** 등록자ID */
    private String regstrId;
   
    /** 등록일 */
    private String rdtt;
    
    /** 수정자ID */
    private String amndrId;
    
    /** 수정일 */
    private String mdtt;
    
    /** 검색1 업무시스템 */
    private String searchKeyword1;
    
    /** 검색2 HW유형 */
    private String searchKeyword2;
    
    /** 검색3 자산상태 */
    private String searchKeyword3;
    
    /** 검색4 초과(년) */
    private String searchKeyword4;  
    
    /** 검색5 가상화구분 */
    private String searchKeyword5; 
    
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
    
    /** 내용연수   */
    private String textYearCo = "";
    
    /** 사용연수 */
    private String useYear = "";
    
    /** 초과(년) */
    private String excessYear = "";
    

	public String getHwAssetId() {
		return hwAssetId;
	}

	public void setHwAssetId(String hwAssetId) {
		this.hwAssetId = hwAssetId;
	}

	public String getNtwrkDstnct() {
		return ntwrkDstnct;
	}

	public void setNtwrkDstnct(String ntwrkDstnct) {
		this.ntwrkDstnct = ntwrkDstnct;
	}

	public String getVrtlzDstnct() {
		return vrtlzDstnct;
	}

	public void setVrtlzDstnct(String vrtlzDstnct) {
		this.vrtlzDstnct = vrtlzDstnct;
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

	public String getVrtlzType() {
		return vrtlzType;
	}

	public void setVrtlzType(String vrtlzType) {
		this.vrtlzType = vrtlzType;
	}

	public String getUpprHwAssetId() {
		return upprHwAssetId;
	}

	public void setUpprHwAssetId(String upprHwAssetId) {
		this.upprHwAssetId = upprHwAssetId;
	}

	public String getBizSytm() {
		return bizSytm;
	}

	public void setBizSytm(String bizSytm) {
		this.bizSytm = bizSytm;
	}

	public String getProdPurp() {
		return prodPurp;
	}

	public void setProdPurp(String prodPurp) {
		this.prodPurp = prodPurp;
	}

	public String getHostNm() {
		return hostNm;
	}

	public void setHostNm(String hostNm) {
		this.hostNm = hostNm;
	}

	public String getIpAddr() {
		return ipAddr;
	}

	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}

	public String getMnftrNm() {
		return mnftrNm;
	}

	public void setMnftrNm(String mnftrNm) {
		this.mnftrNm = mnftrNm;
	}

	public String getProdNm() {
		return prodNm;
	}

	public void setProdNm(String prodNm) {
		this.prodNm = prodNm;
	}

	public float getProdCoQty() {
		return prodCoQty;
	}

	public void setProdCoQty(float prodCoQty) {
		this.prodCoQty = prodCoQty;
	}

	public String getAssetOwn() {
		return assetOwn;
	}

	public void setAssetOwn(String assetOwn) {
		this.assetOwn = assetOwn;
	}

	public String getSerialno() {
		return serialno;
	}

	public void setSerialno(String serialno) {
		this.serialno = serialno;
	}

	public String getProdlocat() {
		return prodlocat;
	}

	public void setProdlocat(String prodlocat) {
		this.prodlocat = prodlocat;
	}

	public String getAssetStat() {
		return assetStat;
	}

	public void setAssetStat(String assetStat) {
		this.assetStat = assetStat;
	}

	public String getCtrlYn() {
		return ctrlYn;
	}

	public void setCtrlYn(String ctrlYn) {
		this.ctrlYn = ctrlYn;
	}

	public String getMaintceCntr() {
		return maintceCntr;
	}

	public void setMaintceCntr(String maintceCntr) {
		this.maintceCntr = maintceCntr;
	}

	public String getMaintceCntrBeginDate() {
		return maintceCntrBeginDate;
	}

	public void setMaintceCntrBeginDate(String maintceCntrBeginDate) {
		this.maintceCntrBeginDate = maintceCntrBeginDate;
	}

	public String getMaintceCntrEndDate() {
		return maintceCntrEndDate;
	}

	public void setMaintceCntrEndDate(String maintceCntrEndDate) {
		this.maintceCntrEndDate = maintceCntrEndDate;
	}

	public String getMaintceInspCycle() {
		return maintceInspCycle;
	}

	public void setMaintceInspCycle(String maintceInspCycle) {
		this.maintceInspCycle = maintceInspCycle;
	}

	public String getMaintceChrgrNo() {
		return maintceChrgrNo;
	}

	public void setMaintceChrgrNo(String maintceChrgrNo) {
		this.maintceChrgrNo = maintceChrgrNo;
	}

	public String getEntrngDate() {
		return entrngDate;
	}

	public void setEntrngDate(String entrngDate) {
		this.entrngDate = entrngDate;
	}

	public String getExanDate() {
		return exanDate;
	}

	public void setExanDate(String exanDate) {
		this.exanDate = exanDate;
	}

	public String getEoslDate() {
		return eoslDate;
	}

	public void setEoslDate(String eoslDate) {
		this.eoslDate = eoslDate;
	}

	public String getAppliYn() {
		return appliYn;
	}

	public void setAppliYn(String appliYn) {
		this.appliYn = appliYn;
	}

	public String getBlcktRwrdTime() {
		return blcktRwrdTime;
	}

	public void setBlcktRwrdTime(String blcktRwrdTime) {
		this.blcktRwrdTime = blcktRwrdTime;
	}

	public String getRmarkText() {
		return rmarkText;
	}

	public void setRmarkText(String rmarkText) {
		this.rmarkText = rmarkText;
	}

	public String getOsText() {
		return osText;
	}

	public void setOsText(String osText) {
		this.osText = osText;
	}

	public String getCpuText() {
		return cpuText;
	}

	public void setCpuText(String cpuText) {
		this.cpuText = cpuText;
	}

	public String getMmryText() {
		return mmryText;
	}

	public void setMmryText(String mmryText) {
		this.mmryText = mmryText;
	}

	public String getDiskText() {
		return diskText;
	}

	public void setDiskText(String diskText) {
		this.diskText = diskText;
	}

	public String getSvcDupCnvrConfgYn() {
		return svcDupCnvrConfgYn;
	}

	public void setSvcDupCnvrConfgYn(String svcDupCnvrConfgYn) {
		this.svcDupCnvrConfgYn = svcDupCnvrConfgYn;
	}

	public String getDplctText() {
		return dplctText;
	}

	public void setDplctText(String dplctText) {
		this.dplctText = dplctText;
	}

	public String getKtoaAssetNo() {
		return ktoaAssetNo;
	}

	public void setKtoaAssetNo(String ktoaAssetNo) {
		this.ktoaAssetNo = ktoaAssetNo;
	}

	public String getDelYn() {
		return delYn;
	}

	public void setDelYn(String delYn) {
		this.delYn = delYn;
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

	public String getMdtt() {
		return mdtt;
	}

	public void setMdtt(String mdtt) {
		this.mdtt = mdtt;
	}

	public String getSearchKeyword1() {
		return searchKeyword1;
	}

	public void setSearchKeyword1(String searchKeyword1) {
		this.searchKeyword1 = searchKeyword1;
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

	public String getTextYearCo() {
		return textYearCo;
	}

	public void setTextYearCo(String textYearCo) {
		this.textYearCo = textYearCo;
	}

	public String getUseYear() {
		return useYear;
	}

	public void setUseYear(String useYear) {
		this.useYear = useYear;
	}

	public String getExcessYear() {
		return excessYear;
	}

	public void setExcessYear(String excessYear) {
		this.excessYear = excessYear;
	}
}
