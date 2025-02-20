package truebon.com.sys.cnt.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import truebon.com.sys.cnt.model.HdcftInputCntVO;

@Repository("HdcftInputCntDAO")
public class HdcftInputCntDAO  extends EgovComAbstractDAO{

    /**
    * tb_work를 조회한다.
    * @param searchMap - 조회할 정보가 담긴 Map
    * @return tb_work 목록
    * @exception Exception
    */

	public List<HdcftInputCntVO> selectHdcftInputCnt(HdcftInputCntVO hdcftInputCntVO) throws Exception  {
		 return selectList("HdcftInputCntMapper.selectHdcftInputCntList", hdcftInputCntVO);
	}
}
