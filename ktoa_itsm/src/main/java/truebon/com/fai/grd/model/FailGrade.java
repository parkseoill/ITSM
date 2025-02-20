package truebon.com.fai.grd.model;

import java.io.Serializable;

/**
 * 장애등급 코드 클래스르를 정의한다
 * @author 이정하
 * @since 2023.10.26
 * @version 1.0
 * @see
 *  
  * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *  수정일               수정자            수정내용
 *  ----------   --------   ---------------------------
 *  2023.10.26       이정하          	 최초 생성
 *
 * </pre>
 */
@SuppressWarnings("serial")
public class FailGrade implements Serializable {
	
	/* 장애영향도 코드 */
	private String failrInfldgCd;
	
	/* 장애긴급도 코드 */
	private String failrEmgdgrCd;
	
	/* 장애등급 코드 */
	private String failrGrdCd;
	
	/* 비고내용 */
	private String rmarkText;
	
	/** 등록자ID */
    private String regstrId;
    
	/** 등록일 */
    private String rdtt;
    
    /** 수정자ID */
    private String amndrId;
    
    /** 수정일 */
    private String mdtt;
    
    public String getFailrInfldgCd() {
		return failrInfldgCd;
	}

	public void setFailrInfldgCd(String failrInfldgCd) {
		this.failrInfldgCd = failrInfldgCd;
	}

	public String getFailrEmgdgrCd() {
		return failrEmgdgrCd;
	}

	public void setFailrEmgdgrCd(String failrEmgdgrCd) {
		this.failrEmgdgrCd = failrEmgdgrCd;
	}

	public String getFailrGrdCd() {
		return failrGrdCd;
	}

	public void setFailrGrdCd(String failrGrdCd) {
		this.failrGrdCd = failrGrdCd;
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
