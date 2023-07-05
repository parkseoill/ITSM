package egovframework.com.sec.gmt.service;

import egovframework.com.cmm.ComDefaultVO;

/**
 * 그룹관리에 대한 model 클래스를 정의한다.
 * @author 공통서비스 개발팀 이문준
 * @since 2009.06.01
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2009.03.20  이문준          최초 생성
 *
 * </pre>
 */

public class GroupManage extends ComDefaultVO {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 그룹 관리
	 */
	private GroupManage groupManage;
	/**
	 * 그룹설명
	 */
	private String groupDc;
	/**
	 * 회사번호
	 */
	private String cmpnyNo;
	/**
	 * 회사명
	 */
	private String cmpnyNm;
	/**
	 * 대표자명
	 */
	private String rpsntvNm;
	/**
	 * 회사주소
	 */
	private String cmpnyAddr;
	/**
	 * 회사전화번호
	 */
	private String cmpnyTelNo;
	/**
	 * 최초등록일
	 */
	private String rdtt;
	/**
	 * 등록자
	 */
	private String regstrId;
	/**
	 * 담당자
	 */
	private String amndrId;
	/**
	 *  최종등록일
	 */
	private String mdtt;
	/**
	 *  사용 여부
	 */
	private String useYn;
	
	
	/**
	 * groupManage attribute 를 리턴한다.
	 * @return GroupManage
	 */
	public GroupManage getGroupManage() {
		return groupManage;
	}
	/**
	 * groupManage attribute 값을 설정한다.
	 * @param groupManage GroupManage 
	 */
	public void setGroupManage(GroupManage groupManage) {
		this.groupManage = groupManage;
	}
	/**
	 * groupId attribute 를 리턴한다.
	 * @return String
	 */
	/*
	 * public String getGroupId() { return groupId; }
	 */
	/**
	 * groupId attribute 값을 설정한다.
	 * @param groupId String 
	 */
	/*
	 * public void setGroupId(String groupId) { this.groupId = groupId; }
	 */
	/**
	 * groupDc attribute 를 리턴한다.
	 * @return String
	 */
	public String getGroupDc() {
		return groupDc;
	}
	/**
	 * groupDc attribute 값을 설정한다.
	 * @param groupDc String 
	 */
	public void setGroupDc(String groupDc) {
		this.groupDc = groupDc;
	}
	public String getCmpnyNo() {
		return cmpnyNo;
	}
	public void setCmpnyNo(String cmpnyNo) {
		this.cmpnyNo = cmpnyNo;
	}
	public String getCmpnyNm() {
		return cmpnyNm;
	}
	public void setCmpnyNm(String cmpnyNm) {
		this.cmpnyNm = cmpnyNm;
	}
	public String getCmpnyTelNo() {
		return cmpnyTelNo;
	}
	public void setCmpnyTelNo(String cmpnyTelNo) {
		this.cmpnyTelNo = cmpnyTelNo;
	}
	public String getMdtt() {
		return mdtt;
	}
	public void setMdtt(String mdtt) {
		this.mdtt = mdtt;
	}
	public String getRpsntvNm() {
		return rpsntvNm;
	}
	public void setRpsntvNm(String rpsntvNm) {
		this.rpsntvNm = rpsntvNm;
	}
	public String getCmpnyAddr() {
		return cmpnyAddr;
	}
	public void setCmpnyAddr(String cmpnyAddr) {
		this.cmpnyAddr = cmpnyAddr;
	}
	public String getRdtt() {
		return rdtt;
	}
	public void setRdtt(String rdtt) {
		this.rdtt = rdtt;
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
	public String getUseYn() {
		return useYn;
	}
	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}
	


}