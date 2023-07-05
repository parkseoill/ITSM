package truebon.com.opm.com.dao;


import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import truebon.com.opm.com.model.ComnCdNewVO;



@Repository("ComnCdNewDAO")
public class ComnCdNewDAO extends EgovComAbstractDAO {

	
	/**
	 * tb_comn_cd_new 목록을 조회한다.
	 * 
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return tb_comn_cd_new 목록
	 * @exception Exception
	 */
	public List<ComnCdNewVO> selectComnCdNewList(ComnCdNewVO searchVO) throws Exception {
		return selectList("ComnCdNewMapper.selectComnCdNew", searchVO);
	}
	
	

}
