package truebon.com.opm.biz.model;

import java.io.Serializable;

/**
 * 업무시스템을 위한 모델 클래스를 정의한다.
 * @author 이유리
 * @since 2022.07.26
 * @version 1.0
 * @see
 *  
  * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *  수정일               수정자            수정내용
 *  ----------   --------   ---------------------------
 *  2022.07.26   이유리           최초 생성
 *
 * </pre>
 */

@SuppressWarnings("serial")
public class BizSytm implements Serializable {
	/** 업무시스템코드 */
	private String bizSytmCd;
	
	/** 업무시스템코드명 */
	private String bizSytmNm;
	
	/** 업무시스템코드레벨 */
	private String bizSytmCdLvl;
	
	/** 상위 업무시스템코드 */
	private String upprBizSytmCd;
	
	/** 사용여부 */
	private String useYn;
	
	/** 우선순위 */
	private String frstRank;
	
    /** 등록자ID */
    private String regstrId;
    
    /** 등록일 */
    private String rdtt;
    
    /** 수정자ID */
    private String amndrId;
    
    /** 수정일 */
    private String mdtt;

	public String getBizSytmCd() {
		return bizSytmCd;
	}

	public void setBizSytmCd(String bizSytmCd) {
		this.bizSytmCd = bizSytmCd;
	}

	public String getBizSytmNm() {
		return bizSytmNm;
	}

	public void setBizSytmNm(String bizSytmNm) {
		this.bizSytmNm = bizSytmNm;
	}

	public String getBizSytmCdLvl() {
		return bizSytmCdLvl;
	}

	public void setBizSytmCdLvl(String bizSytmCdLvl) {
		this.bizSytmCdLvl = bizSytmCdLvl;
	}

	public String getUpprBizSytmCd() {
		return upprBizSytmCd;
	}

	public void setUpprBizSytmCd(String upprBizSytmCd) {
		this.upprBizSytmCd = upprBizSytmCd;
	}

	public String getUseYn() {
		return useYn;
	}

	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}

	public String getFrstRank() {
		return frstRank;
	}

	public void setFrstRank(String frstRank) {
		this.frstRank = frstRank;
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
}