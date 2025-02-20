package truebon.com.crm.slm.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import truebon.com.crm.slm.model.SvclifeMngVO;
import truebon.com.crm.swm.model.SwMngVO;

/**
 * Svclife DAO 클래스 정의
 * @author 이미현
 * @since 2023.10.04
 * @version 1.0
 * @see
 *  
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *  수정일                        수정자                  수정내용
 *  ----------   --------   ---------------------------
 *  2023.09.26    이미현                 최초 생성
 *
 * </pre>
 */

@Repository("SvclifeDAO")
public class SvclifeDAO extends EgovComAbstractDAO {
	

	/**
	 * tb_hw_asset 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return tb_hw_asset 목록
	 * @exception Exception
	 */
	public List<SvclifeMngVO> selectSvclifeList(SvclifeMngVO searchVO) throws Exception {
		return selectList("SvclifeMapper.selectSvclifeList", searchVO);
	}
	
	
	/**
 	 * tb_hw_asset 총 갯수 조회한다.
 	 * @param searchVO - 조회할 정보가 담긴 VO
 	 * @return tb_hw_asset 총 갯수
 	 * @exception Exception
 	 */
	public int selectSvclifeListTotCnt(SvclifeMngVO searchVO) {
		return (Integer)selectOne("SvclifeMapper.selectSvclifeListTotCnt", searchVO);
	}
	
	
	
	/**
 	 * TB_HW_ASSET 목록을 조회한다. (엑셀 다운로드)
 	 * @param searchMap - 조회할 정보가 담긴 EgovMap
 	 * @return EgovMap 목록
 	 * @exception Exception
 	 */
	public List<EgovMap> selectSvclifeEgoMap(SvclifeMngVO searchVO) throws Exception {
		return selectList("SvclifeMapper.selectSvclifeEgoMap", searchVO);
	}
	
	
	
}
