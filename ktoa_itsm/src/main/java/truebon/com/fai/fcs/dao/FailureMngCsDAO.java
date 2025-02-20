package truebon.com.fai.fcs.dao;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import truebon.com.fai.fcs.model.FailureMngCsVO;

import java.util.List;
import org.springframework.stereotype.Repository;

@Repository("FailureMngCsDAO")
public class FailureMngCsDAO extends EgovComAbstractDAO {
	
	/**
	 * TB_FAIL 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return TB_FAIL 목록
	 * @exception Exception
	 */
  public List<FailureMngCsVO> selectFailureMngCsList(FailureMngCsVO searchVO) throws Exception {
    return selectList("FailureMngCsMapper.selectFailureMngCsList", searchVO);
  }
  
    /**
	 * TB_FAIL 목록을 조회한다. (엑셀 다운로드)
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return EgovMap 목록
	 * @exception Exception
	 */
  public List<EgovMap> selectFailureMngCsEgoMap(FailureMngCsVO searchVO) throws Exception {
    return selectList("FailureMngCsMapper.selectFailureMngCsEgoMap", searchVO);
  }
}
