package truebon.com.rsm.wmr.model;

import java.io.Serializable;

/**
 * 업무보고서를 위한 모델 클래스를 정의한다.
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
public class BizReport implements Serializable {
    
	/** 업무보고서ID */
    private String bizReportId;
    
    /** 업무보고서종류코드 */
    private String bizReportKindCd;
    
    /** 생성담당자번호 */
    private String creatChrgrNo;
    
    /** 업무보고서명 */
    private String bizReportNm;
    
    /** 사용여부 */
    private String useYn;
    
    /** 등록자ID */
    private String regstrId;
    
    /** 등록일 */
    private String rdtt;
    
    /** 수정자ID */
    private String amndrId;
    
    /** 수정일 */
    private String mdtt;
    
    public String getBizReportId() {
		return bizReportId;
	}

	public void setBizReportId(String bizReportId) {
		this.bizReportId = bizReportId;
	}

	public String getBizReportKindCd() {
		return bizReportKindCd;
	}

	public void setBizReportKindCd(String bizReportKindCd) {
		this.bizReportKindCd = bizReportKindCd;
	}

	public String getCreatChrgrNo() {
		return creatChrgrNo;
	}

	public void setCreatChrgrNo(String creatChrgrNo) {
		this.creatChrgrNo = creatChrgrNo;
	}

	public String getBizReportNm() {
		return bizReportNm;
	}

	public void setBizReportNm(String bizReportNm) {
		this.bizReportNm = bizReportNm;
	}

	public String getUseYn() {
		return useYn;
	}

	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}
    
    public String getRegstrId() {
        return this.regstrId;
    }
    
    public void setRegstrId(String regstrId) {
        this.regstrId = regstrId;
    }
    
    public String getRdtt() {
        return this.rdtt;
    }
    
    public void setRdtt(String rdtt) {
        this.rdtt = rdtt;
    }
    
    public String getAmndrId() {
        return this.amndrId;
    }
    
    public void setAmndrId(String amndrId) {
        this.amndrId = amndrId;
    }
    
    public String getMdtt() {
        return this.mdtt;
    }
    
    public void setMdtt(String mdtt) {
        this.mdtt = mdtt;
    }
    
}
