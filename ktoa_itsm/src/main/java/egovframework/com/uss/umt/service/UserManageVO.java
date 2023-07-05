package egovframework.com.uss.umt.service;

/**
 * 업무사용자VO클래스로서 업무사용자관리 비지니스로직 처리용 항목을 구성한다.
 * @author 공통서비스 개발팀 조재영
 * @since 2009.04.10
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2009.04.10  조재영          최초 생성
 *   2017.07.21  장동한 			로그인인증제한 작업
 *
 * </pre>
 */
public class UserManageVO extends UserDefaultVO{

	private static final long serialVersionUID = 3640820362821490939L;

	/** 이전비밀번호 - 비밀번호 변경시 사용*/
    private String oldPassword = "";

	/**
	 * 사용여부
	 */
	private String useYn;
	/**
	 * 사용자 ID
	 */
	private String userId;
	/**
	 * 담당자 이름
	 */
	private String chrgrNm;
	/**
	 * 담당자 유선번호
	 */
	private String chrgrWirelnTelNo;
	/**
	 * 사용자고유아이디
	 */
	private String uniqId="";
	/**
	 * 그룹 ID
	 */
	private String chargerNo;
	/**
	 * 최종수정자
	 */
	private String amndrId;
	/**
	 * 최초수정자
	 */
	private String regstrId;
	/**
	 * 비밀번호
	 */
	private String password;
	/**
	 * 선택된값
	 */
	private String selectedId;
	/**
	 * 사용자 사인(페이지에서 받아오거나 출력 시 사용)
	 */
	private String strUserSign;
	/**
	 * 사용자 사인
	 */
	private byte[] userSign;
	
	
	private String lockAt;
	public String getLockAt() {return lockAt;}
	public void setLockAt(String lockAt) {this.lockAt = lockAt;}
	
	/**
	 * oldPassword attribute 값을  리턴한다.
	 * @return String
	 */
	public String getOldPassword() {
		return oldPassword;
	}
	/**
	 * oldPassword attribute 값을 설정한다.
	 * @param oldPassword String
	 */
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	/**
	 * uniqId attribute 값을  리턴한다.
	 * @return String
	 */
	public String getUniqId() {
		return uniqId;
	}
	/**
	 * uniqId attribute 값을 설정한다.
	 * @param uniqId String
	 */
	public void setUniqId(String uniqId) {
		this.uniqId = uniqId;
	}
	/**
	 * chargerNo attribute 값을  리턴한다.
	 * @return String
	 */
	public String getChargerNo() {
		return chargerNo;
	}
	/**
	 * groupId attribute 값을 설정한다.
	 * @param groupId String
	 */
	public void setChargerNo(String chargerNo) {
		this.chargerNo = chargerNo;
	}
	/**
	 * regstrId attribute 값을  리턴한다.
	 * @return String
	 */
	public String getRegstrId() {
		return regstrId;
	}
	/**
	 * regstrId attribute 값을 설정한다.
	 * @param regstrId String
	 */
	public void setRegstrId(String regstrId) {
		this.regstrId = regstrId;
	}
	/**
	 * password attribute 값을  리턴한다.
	 * @return String
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * password attribute 값을 설정한다.
	 * @param password String
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUseYn() {
		return useYn;
	}
	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}
	public String getChrgrNm() {
		return chrgrNm;
	}
	public void setChrgrNm(String chrgrNm) {
		this.chrgrNm = chrgrNm;
	}
	public String getChrgrWirelnTelNo() {
		return chrgrWirelnTelNo;
	}
	public void setChrgrWirelnTelNo(String chrgrWirelnTelNo) {
		this.chrgrWirelnTelNo = chrgrWirelnTelNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getSelectedId() {
		return selectedId;
	}
	public void setSelectedId(String selectedId) {
		this.selectedId = selectedId;
	}
	/**
	 * amndrId attribute 값을  리턴한다.
	 * @return String
	 */
	public String getAmndrId() {
		return amndrId;
	}
	/**
	 * amndrId attribute 값을 설정한다.
	 * @param amndrId String
	 */
	public void setAmndrId(String amndrId) {
		this.amndrId = amndrId;
	}
	public String getStrUserSign() {
		return strUserSign;
	}
	public void setStrUserSign(String strUserSign) {
		this.strUserSign = strUserSign;
	}
	public byte[] getUserSign() {
		return userSign;
	}
	public void setUserSign(byte[] userSign) {
		this.userSign = userSign;
	}

}