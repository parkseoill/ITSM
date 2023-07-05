package egovframework.com.cmm;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 *  클래스
 * @author 공통서비스개발팀 이삼섭
 * @since 2009.06.01
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *   수정일      수정자           수정내용
 *  -------       --------    ---------------------------
 *   2009.3.11   이삼섭          최초 생성
 *
 * </pre>
 */
@SuppressWarnings("serial")
public class ComDefaultCodeVO implements Serializable {
    /** 코드 ID */
    private String comnCdId = "";
    
    /** 상세코드 */
    private String comnCd = "";
    
    /** 코드명 */
    private String comnCdNm = "";
    
    /** 코드설명 */
    private String comnCdDc = "";
    
    /** 특정테이블명 */
    private String tableNm = "";	//특정테이블에서 코드정보를추출시 사용
    
    /** 상세 조건 여부 */
    private String haveDetailCondition = "N";
    
    /** 상세 조건 */
    private String detailCondition = "";
    
    /**
     * comnCdId attribute를 리턴한다.
     * 
     * @return the comnCdId
     */
    public String getComnCdId() {
	return comnCdId;
    }

    /**
     * comnCdId attribute 값을 설정한다.
     * 
     * @param comnCdId
     *            the comnCdId to set
     */
    public void setComnCdId(String comnCdId) {
	this.comnCdId = comnCdId;
    }

    /**
     * comnCd attribute를 리턴한다.
     * 
     * @return the comnCd
     */
    public String getComnCd() {
	return comnCd;
    }

    /**
     * comnCd attribute 값을 설정한다.
     * 
     * @param comnCd
     *            the code to set
     */
    public void setComnCd(String comnCd) {
	this.comnCd = comnCd;
    }

    /**
     * ComnCdNm attribute를 리턴한다.
     * 
     * @return the ComnCdNm
     */
    public String getComnCdNm() {
	return comnCdNm;
    }

    /**
     * ComnCdNm attribute 값을 설정한다.
     * 
     * @param ComnCdNm
     *            the ComnCdNm to set
     */
    public void setComnCdNm(String comnCdNm) {
	this.comnCdNm = comnCdNm;
    }

    /**
     * comnCd attribute를 리턴한다.
     * 
     * @return the comnCd
     */
    public String getComnCdDc() {
	return comnCdDc;
    }

    /**
     * comnCd attribute 값을 설정한다.
     * 
     * @param comnCd
     *            the comnCd to set
     */
    public void setComnCdDc(String comnCd) {
	this.comnCd = comnCd;
    }

    /**
     * tableNm attribute를 리턴한다.
     * 
     * @return the tableNm
     */
    public String getTableNm() {
	return tableNm;
    }

    /**
     * tableNm attribute 값을 설정한다.
     * 
     * @param tableNm
     *            the tableNm to set
     */
    public void setTableNm(String tableNm) {
	this.tableNm = tableNm;
    }

    /**
     * haveDetailCondition attribute를 리턴한다.
     * 
     * @return the haveDetailCondition
     */
    public String getHaveDetailCondition() {
	return haveDetailCondition;
    }

    /**
     * haveDetailCondition attribute 값을 설정한다.
     * 
     * @param haveDetailCondition
     *            the haveDetailCondition to set
     */
    public void setHaveDetailCondition(String haveDetailCondition) {
	this.haveDetailCondition = haveDetailCondition;
    }

    /**
     * detailCondition attribute를 리턴한다.
     * 
     * @return the detailCondition
     */
    public String getDetailCondition() {
	return detailCondition;
    }

    /**
     * detailCondition attribute 값을 설정한다.
     * 
     * @param detailCondition
     *            the detailCondition to set
     */
    public void setDetailCondition(String detailCondition) {
	this.detailCondition = detailCondition;
    }

    /**
     * toString 메소드를 대치한다.
     */
    public String toString() {
	return ToStringBuilder.reflectionToString(this);
    }
}
