package truebon.com.crm.swm.model;
import java.io.Serializable;

/**
 * 전산자원관리 처리(SW자산)를 위한 클래스를 정의한다
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
public class SwMng implements Serializable {
	/** SW자산ID */
	private String swAssetId = "";

	/** SW유형코드 */
	private String swTypeCd = "";
	/** 네트워크 구분코드 */
	private String ntwrkDstnctCd = "";
	/** 자산상태 코드*/
	private String assetStatCd = "";
	/** 자산소유코드 */
	private String assetOwnCd = "";
	/** 업무시스템코드 */
	private String bizSytmCd = "";
	/** KTOA 자산번호 */
	private String ktoaAssetNo = "";
	/** 제품용도 */
	private String prodPurp = "";
	/** 제조사명 */
	private String mnftrNm = "";
	/** 제품명 */
	private String prodNm = "";
	/** 제품수량 */
	private String prodCoQty = "";
	/** 입고일자 */
	private String entrngDate = "";
	/** 검수일자 */
	private String exanDate = "";
	/** 호스트명 */
	private String hostNm = "";
	/** EOSL 일자 */
	private String eoslDate = "";
	/** 서비스이중화여부 */
	private String svcDupCnvrConfgYn = "";
	/** 관제여부 */
	private String ctrlYn = "";
	/** 유지보수 계약코드 */
	private String maintceCntrCd = "";
	/** 유지보수 점검주기 코드 */
	private String maintceInspCycleCd = "";
	/** 유지보수 담당자 번호 */
	private String maintceChrgrNo = "";
	/** 비고내용 */
	private String rmarkText = "";
	/** 유지보수 계약시작일자 */
	private String maintceCntrBeginDate = "";
	/** 유지보수 계약종료일자 */
	private String maintceCntrEndDate = "";
	/** 라이센스 ID */
	private String lcnId = "";
	/** 어플라이언스 HW ID */
	private String appliHwAssetId = "";
	/** 이중화내용 */
	private String dplctText = "";
	/** 삭제 여부 */
	private String delYn = "";
	/** 등록자ID */
	private String regstrId;

	/** 등록일 */
	private String rdtt;

	/** 수정자ID */
	private String amndrId;

	/** 수정일 */
	private String mdtt;
	public String getSwAssetId() { return swAssetId; }

    public void setSwAssetId(String swAssetId) { this.swAssetId = swAssetId; }

    public String getSwTypeCd() {
        return swTypeCd;
    }

    public void setSwTypeCd(String typeCd) {
        this.swTypeCd = typeCd;
    }

    public String getNtwrkDstnctCd() {
        return ntwrkDstnctCd;
    }

    public void setNtwrkDstnctCd(String ntwrkDstnctCd) {
        this.ntwrkDstnctCd = ntwrkDstnctCd;
    }

    public String getAssetStatCd() {
        return assetStatCd;
    }

    public void setAssetStatCd(String assetStatCd) {
        this.assetStatCd = assetStatCd;
    }

    public String getAssetOwnCd() {
        return assetOwnCd;
    }

    public void setAssetOwnCd(String assetOwnCd) {
        this.assetOwnCd = assetOwnCd;
    }

    public String getBizSytmCd() {
        return bizSytmCd;
    }

    public void setBizSytmCd(String bizSytmCd) {
        this.bizSytmCd = bizSytmCd;
    }

    public String getKtoaAssetNo() {
        return ktoaAssetNo;
    }

    public void setKtoaAssetNo(String ktoaAssetNo) {
        this.ktoaAssetNo = ktoaAssetNo;
    }

    public String getProdPurp() {
        return prodPurp;
    }

    public void setProdPurp(String prodPurp) {
        this.prodPurp = prodPurp;
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

    public String getProdCoQty() {
        return prodCoQty;
    }

    public void setProdCoQty(String prodCoQty) {
        this.prodCoQty = prodCoQty;
    }

    public String getEntrngDate() {
        return entrngDate;
    }

    public void setEntrngDate(String enterDate) {
        this.entrngDate = enterDate;
    }

    public String getExanDate() {
        return exanDate;
    }

    public void setExanDate(String exanDate) {
        this.exanDate = exanDate;
    }

    public String getHostNm() {
        return hostNm;
    }

    public void setHostNm(String hostNm) {
        this.hostNm = hostNm;
    }

    public String getEoslDate() {
        return eoslDate;
    }

    public void setEoslDate(String eoslDate) {
        this.eoslDate = eoslDate;
    }

    public String getCtrlYn() {
        return ctrlYn;
    }

    public void setCtrlYn(String ctrlYn) {
        this.ctrlYn = ctrlYn;
    }

    public String getMaintceCntrCd() {
        return maintceCntrCd;
    }

    public void setMaintceCntrCd(String maintceCntrCd) {
        this.maintceCntrCd = maintceCntrCd;
    }

    public String getMaintceInspCycleCd() {
        return maintceInspCycleCd;
    }

    public void setMaintceInspCycleCd(String maintceInspCycleCd) {
        this.maintceInspCycleCd = maintceInspCycleCd;
    }

    public String getMaintceChrgrNo() {
        return maintceChrgrNo;
    }

    public void setMaintceChrgrNo(String maintceChrgrNo) {
        this.maintceChrgrNo = maintceChrgrNo;
    }

    public String getSvcDupCnvrConfgYn() {
        return svcDupCnvrConfgYn;
    }

    public void setSvcDupCnvrConfgYn(String svcDupCnvrConfgYn) {
        this.svcDupCnvrConfgYn = svcDupCnvrConfgYn;
    }

    public String getRmarkText() {
        return rmarkText;
    }

    public void setRmarkText(String rmarkText) {
        this.rmarkText = rmarkText;
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

    public String getLcnId() {
        return lcnId;
    }

    public void setLcnId(String lcnId) {
        this.lcnId = lcnId;
    }

    public String getAppliHwAssetId() {
        return appliHwAssetId;
    }

    public void setAppliHwAssetId(String appliHwAssetId) {
        this.appliHwAssetId = appliHwAssetId;
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

	public String getDelYn() {
		return delYn;
	}

	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}

	public String getDplctText() {
		return dplctText;
	}

	public void setDplctText(String dplctText) {
		this.dplctText = dplctText;
	}



}
