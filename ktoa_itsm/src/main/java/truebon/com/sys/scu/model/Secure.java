package truebon.com.sys.scu.model;

import java.io.Serializable;

/**
 * 보안 관리를 위한 모델 클래스를 정의한다.
 * @author 조경민
 * @since 2022.07.28
 * @version 1.0
 * @see
 *  
  * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *  수정일               수정자            수정내용
 *  ----------   --------   ---------------------------
 *  2022.07.28	조경민	최초 생성
 *
 * </pre>
 */
@SuppressWarnings("serial")
public class Secure implements Serializable {

	/** 점검일자 */
	private String inspDate;
	/** 보안점검위치코드 */
	private String securInspLoacatCd;
	/** 점검시간 */
	private String inspTime;
	/** 점검자ID */
	private String isprId;
	/** 확인자ID */
	private String confrId;
	/** PC전원보안점검결과코드*/
	private String pcPwrSecurInspResltCd;
	/** 기타전원보안점검결과코드 */
	private String etcPwrSecurInspResltCd;
	/** 서류보안점검결과코드 */
	private String paperSecurInspResltCd;
	/** 화기단속보안점검결과코드 */
	private String frcntlSecurInspResltCd;
	/** 소등문단속보안점검결과코드*/
	private String ltoutLckdSecurInspResltCd;
	/** 점검자이름 */
	private String isprName;
	/** 확인자이름 */
	private String confrName;
	/** 보안점검위치 */
	private String silc;
	/** PC전원보안점검결과 */
	private String ppsirc;
	/** 서류보안점검결과 */
	private String psirc;
	/** 기타전원보안점검결과 */
	private String epsirc;
	/** 화기단속보안점검결과 */
	private String fsirc;
	/** 소등문단속보안점검결과 */
	private String lsirc;
	/** 비고내용*/
	private String rmarkText;
	
	private String regstrId;
	
	private String rdtt;
	
	private String amndrId;
	
	private String mdtt;
	
	public String getSilc() {
		return silc;
	}
	public void setSilc(String silc) {
		this.silc = silc;
	}
	public String getPpsirc() {
		return ppsirc;
	}
	public void setPpsirc(String ppsirc) {
		this.ppsirc = ppsirc;
	}
	public String getPsirc() {
		return psirc;
	}
	public void setPsirc(String psirc) {
		this.psirc = psirc;
	}
	public String getEpsirc() {
		return epsirc;
	}
	public void setEpsirc(String epsirc) {
		this.epsirc = epsirc;
	}
	public String getFsirc() {
		return fsirc;
	}
	public void setFsirc(String fsirc) {
		this.fsirc = fsirc;
	}
	public String getLsirc() {
		return lsirc;
	}
	public void setLsirc(String lsirc) {
		this.lsirc = lsirc;
	}
	
	public String getInspDate() {
		return inspDate;
	}
	public void setInspDate(String inspDate) {
		this.inspDate = inspDate;
	}
	public String getSecurInspLoacatCd() {
		return securInspLoacatCd;
	}
	public void setSecurInspLoacatCd(String securInspLoacatCd) {
		this.securInspLoacatCd = securInspLoacatCd;
	}
	public String getInspTime() {
		return inspTime;
	}
	public void setInspTime(String inspTime) {
		this.inspTime = inspTime;
	}
	public String getIsprId() {
		return isprId;
	}
	public void setIsprId(String isprId) {
		this.isprId = isprId;
	}
	public String getConfrId() {
		return confrId;
	}
	public void setConfrId(String confrId) {
		this.confrId = confrId;
	}
	public String getPcPwrSecurInspResltCd() {
		return pcPwrSecurInspResltCd;
	}
	public void setPcPwrSecurInspResltCd(String pcPwrSecurInspResltCd) {
		this.pcPwrSecurInspResltCd = pcPwrSecurInspResltCd;
	}
	public String getEtcPwrSecurInspResltCd() {
		return etcPwrSecurInspResltCd;
	}
	public void setEtcPwrSecurInspResltCd(String etcPwrSecurInspResltCd) {
		this.etcPwrSecurInspResltCd = etcPwrSecurInspResltCd;
	}
	public String getPaperSecurInspResltCd() {
		return paperSecurInspResltCd;
	}
	public void setPaperSecurInspResltCd(String paperSecurInspResltCd) {
		this.paperSecurInspResltCd = paperSecurInspResltCd;
	}
	public String getFrcntlSecurInspResltCd() {
		return frcntlSecurInspResltCd;
	}
	public void setFrcntlSecurInspResltCd(String frcntlSecurInspResltCd) {
		this.frcntlSecurInspResltCd = frcntlSecurInspResltCd;
	}
	public String getLtoutLckdSecurInspResltCd() {
		return ltoutLckdSecurInspResltCd;
	}
	public void setLtoutLckdSecurInspResltCd(String ltoutLckdSecurInspResltCd) {
		this.ltoutLckdSecurInspResltCd = ltoutLckdSecurInspResltCd;
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
	public String getIsprName() {
		return isprName;
	}
	public void setIsprName(String isprName) {
		this.isprName = isprName;
	}
	public String getConfrName() {
		return confrName;
	}
	public void setConfrName(String confrName) {
		this.confrName = confrName;
	}
	public String getRmarkText() {
		return rmarkText;
	}
	public void setRmarkText(String rmarkText) {
		this.rmarkText = rmarkText;
	}
	
}
