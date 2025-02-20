package truebon.com.crm.csc.service;

import java.util.List;

import egovframework.rte.psl.dataaccess.util.EgovMap;
import truebon.com.crm.csc.model.CompuSytmVO;

/**
 * 전산시스템현황 을 위한 서비스 구현 클래스
 * @author 이미현
 * @since 2023.10.19
 * @version 1.0
 * @see
 *  
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *  수정일                      수정자                   수정내용
 *  ----------   --------   ---------------------------
 *  2023.10.19   이미현                   최초 생성
 *
 * </pre>
 */

public interface CompuSytmService {
	/**
	 * TB_BIZ_SYSTEM 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return TB_BIZ_SYSTEM 목록
	 * @exception Exception
	 */
	List<CompuSytmVO> selectCompuSytmList(CompuSytmVO searchVO) throws Exception;
	
	
	/**
	 * TB_BIZ_SYSTEM HW, SW 합계  목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return TB_BIZ_SYSTEM 목록
	 * @exception Exception
	 */
	List<CompuSytmVO> selectCompuSytmSumList(CompuSytmVO searchVO) throws Exception;
	
	
	/**
	 * TB_BIZ_SYSTEM 목록을 조회한다.  (엑셀 다운로드)
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return EgovMap 목록
	 * @exception Exception
	 */
	List<EgovMap> selectCompuSytmEgoMap(CompuSytmVO searchVO) throws Exception;
	

}
