package truebon.com.crm.csc.dao;


import java.util.List;

import org.springframework.stereotype.Repository;
import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import truebon.com.crm.csc.model.CompuSytmVO;

/**
 * CompuSytm DAO 클래스 정의
 * @author 이미현
 * @since 2023.10.19
 * @version 1.0
 * @see
 *  
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *  수정일                        수정자                  수정내용
 *  ----------   --------   ---------------------------
 *  2023.10.19    이미현                 최초 생성
 *
 * </pre>
 */

@Repository("CompuSytmDAO")
public class CompuSytmDAO extends EgovComAbstractDAO {
	
	/**
	 * TB_BIZ_SYSTEM 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return TB_BIZ_SYSTEM 목록
	 * @exception Exception
	 */
	public List<CompuSytmVO> selectCompuSytmList(CompuSytmVO searchVO) throws Exception {
		return selectList("CompuSytmMapper.selectCompuSytmList", searchVO);
	}
	
	
	/**
	 * TB_BIZ_SYSTEM HW, SW 합계  목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return TB_BIZ_SYSTEM 목록
	 * @exception Exception
	 */
	public List<CompuSytmVO> selectCompuSytmSumList(CompuSytmVO searchVO) throws Exception {
		return selectList("CompuSytmMapper.selectCompuSytmSumList", searchVO);
	}
	
	
	/**
 	 * TB_BIZ_SYSTEM 목록을 조회한다. (엑셀 다운로드)
 	 * @param searchMap - 조회할 정보가 담긴 EgovMap
 	 * @return EgovMap 목록
 	 * @exception Exception
 	 */
	public List<EgovMap> selectCompuSytmEgoMap(CompuSytmVO searchVO) throws Exception {
		return selectList("CompuSytmMapper.selectCompuSytmEgoMap", searchVO);
	}

}
