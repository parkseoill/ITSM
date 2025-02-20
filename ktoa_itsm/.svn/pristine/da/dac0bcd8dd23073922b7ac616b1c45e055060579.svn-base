package truebon.com.crm.slc.service;

import java.util.List;

import truebon.com.crm.slc.model.SvclifeCodeMngVO;

/**
 * 내용연수 관리 목록 을 위한 서비스 구현 클래스
 * @author 이미현
 * @since 2023.11.06
 * @version 1.0
 * @see
 *  
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *  수정일                      수정자                   수정내용
 *  ----------   --------   ---------------------------
 *  2023.11.06   이미현                   최초 생성
 *
 * </pre>
 */
public interface SvclifeCodeService {
	/**
	 * TB_DUR_YEAR 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return TB_DUR_YEAR 목록
	 * @exception Exception
	 */
	List<SvclifeCodeMngVO> selectSvclifeCodeList(SvclifeCodeMngVO searchVO) throws Exception;

	
	/**
	 * TB_DUR_YEAR 총 갯수 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return TB_DUR_YEAR 총 갯수
	 * @exception 
	 */
	int selectSvclifeCodeListTotCnt(SvclifeCodeMngVO searchVO);
	
	
	/**
	 * TB_DUR_YEAR을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return TB_DUR_YEAR 
	 * @exception Exception
	 */
	SvclifeCodeMngVO selectSvclifeCode(SvclifeCodeMngVO vo) throws Exception;
	
	
	/**
	 * TB_DUR_YEAR을 수정한다.
	 * @param vo - 수정할 정보가 담긴  SvclifeCodeMngVO
	 * @return void형
	 * @exception Exception
	 */
	void updateSvclifeCode(SvclifeCodeMngVO vo) throws Exception;
	
	
	/**
   	 * TB_DUR_YEAR을 등록한다
   	 * @param vo - 등록할 정보가 담긴 SvclifeCodeMngVO
   	 * @return void형
   	 * @exception Exception
   	 */
	void registSvclifeCode(SvclifeCodeMngVO vo) throws Exception;
}
