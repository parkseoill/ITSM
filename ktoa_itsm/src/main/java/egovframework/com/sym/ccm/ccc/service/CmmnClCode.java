package egovframework.com.sym.ccm.ccc.service;

import java.io.Serializable;

/**
 * 공통분류코드 모델 클래스
 * @author 공통서비스 개발팀 이중호
 * @since 2009.04.01
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2009.04.01  이중호          최초 생성
 *
 * </pre>
 */
public class  CmmnClCode implements Serializable {

	private static final long serialVersionUID = 4861619118930452502L;

	/*
	 * 공통코드ID
	 */
	private String comnCdId = "";

	/*
	 * 공통코드ID명
	 */
    private String comnCdIdNm = "";

    /*
     * 공통코드ID설명
     */
    private String comnCdIdDc = "";

    /*
     * 사용여부
     */
    private String useYn = "";

    /*
     * 최초등록자ID
     */
    private String frstRegisterId = "";

    /*
     * 최종수정자ID
     */
    private String lastUpdusrId   = "";

	/**
	 * clCode attribute 를 리턴한다.
	 * @return String
	 */
	public String getComnCdId() {
		return comnCdId;
	}

	/**
	 * clCode attribute 값을 설정한다.
	 * @param clCode String
	 */
	public void setComnCdId(String comnCdId) {
		this.comnCdId = comnCdId;
	}

	/**
	 * clCodeNm attribute 를 리턴한다.
	 * @return String
	 */
	public String getComnCdIdNm() {
		return comnCdIdNm;
	}

	/**
	 * clCodeNm attribute 값을 설정한다.
	 * @param clCodeNm String
	 */
	public void setComnCdIdNm(String comnCdIdNm) {
		this.comnCdIdNm = comnCdIdNm;
	}

	/**
	 * clCodeDc attribute 를 리턴한다.
	 * @return String
	 */
	public String getComnCdIdDc() {
		return comnCdIdDc;
	}

	/**
	 * clCodeDc attribute 값을 설정한다.
	 * @param clCodeDc String
	 */
	public void setComnCdIdDc(String comnCdIdDc) {
		this.comnCdIdDc = comnCdIdDc;
	}

	/**
	 * useAt attribute 를 리턴한다.
	 * @return String
	 */
	public String getUseYn() {
		return useYn;
	}

	/**
	 * useAt attribute 값을 설정한다.
	 * @param useAt String
	 */
	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}

	/**
	 * frstRegisterId attribute 를 리턴한다.
	 * @return String
	 */
	public String getFrstRegisterId() {
		return frstRegisterId;
	}

	/**
	 * frstRegisterId attribute 값을 설정한다.
	 * @param frstRegisterId String
	 */
	public void setFrstRegisterId(String frstRegisterId) {
		this.frstRegisterId = frstRegisterId;
	}

	/**
	 * lastUpdusrId attribute 를 리턴한다.
	 * @return String
	 */
	public String getLastUpdusrId() {
		return lastUpdusrId;
	}

	/**
	 * lastUpdusrId attribute 값을 설정한다.
	 * @param lastUpdusrId String
	 */
	public void setLastUpdusrId(String lastUpdusrId) {
		this.lastUpdusrId = lastUpdusrId;
	}


}
