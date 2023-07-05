package egovframework.com.sec.drm.service;

import java.util.List;


/**
 * 부서권한에 대한 Vo 클래스를 정의한다.
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

public class DeptAuthorVO extends DeptAuthor {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 부서권한목록
	 */
	List <DeptAuthorVO> deptAuthorList;
	/**
	 * 부서목록
	 */
	List <DeptAuthorVO> deptList;	
	/**
	 * 부서코드
	 */
	private String deptNo;
	/**
	 * 부서 명
	 */
	private String deptNm;
	
	/**
	 * deptAuthorList attribute 를 리턴한다.
	 * @return List<DeptAuthorVO>
	 */
	public List<DeptAuthorVO> getDeptAuthorList() {
		return deptAuthorList;
	}
	/**
	 * deptAuthorList attribute 값을 설정한다.
	 * @param deptAuthorList List<DeptAuthorVO> 
	 */
	public void setDeptAuthorList(List<DeptAuthorVO> deptAuthorList) {
		this.deptAuthorList = deptAuthorList;
	}
	/**
	 * deptList attribute 를 리턴한다.
	 * @return List<DeptAuthorVO>
	 */
	public List<DeptAuthorVO> getDeptList() {
		return deptList;
	}
	/**
	 * deptList attribute 값을 설정한다.
	 * @param deptList List<DeptAuthorVO> 
	 */
	public void setDeptList(List<DeptAuthorVO> deptList) {
		this.deptList = deptList;
	}
	/**
	 * deptNo attribute 를 리턴한다.
	 * @return String
	 */
	public String getDeptNo() {
		return deptNo;
	}
	/**
	 * deptNo attribute 값을 설정한다.
	 * @param deptNo String 
	 */
	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}
	/**
	 * deptNm attribute 를 리턴한다.
	 * @return String
	 */
	public String getDeptNm() {
		return deptNm;
	}
	/**
	 * deptNm attribute 값을 설정한다.
	 * @param deptNm String 
	 */
	public void setDeptNm(String deptNm) {
		this.deptNm = deptNm;
	}
	
}