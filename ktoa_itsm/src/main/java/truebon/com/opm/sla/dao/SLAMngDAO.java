package truebon.com.opm.sla.dao;

import org.springframework.stereotype.Repository;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import truebon.com.opm.sla.model.SLAMngVO;

@Repository("SLAMngDAO")
public class SLAMngDAO extends EgovComAbstractDAO{

	 
    /**
    * EXCEL 값 넣기
    * @param EXCEL row
    * @return void형
    * @exception Exception
    */
    public void insertExcel(SLAMngVO vo) throws Exception {
        insert("SLAMngMapper.insertExcel", vo);
    }
}
