package truebon.com.opm.com.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import truebon.com.opm.com.dao.ComnCdNewDAO;
import truebon.com.opm.com.model.ComnCdNewVO;
import truebon.com.opm.com.service.ComnCdNewService;

@Service("ComnCdNewService")
public class ComnCdNewServiceImpl extends EgovAbstractServiceImpl implements ComnCdNewService {

	@Resource(name = "ComnCdNewDAO")
	private ComnCdNewDAO comnCdNewDAO;

    /**
	 * tb_comn_cd_new 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return tb_comn_cd_new 목록
	 * @exception Exception
	 */
    public List<ComnCdNewVO> selectComnCdNewList(ComnCdNewVO searchVO) throws Exception {
        return comnCdNewDAO.selectComnCdNewList(searchVO);
    }



}
