package truebon.com.opm.sla.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import truebon.com.opm.sla.dao.SLAMngDAO;
import truebon.com.opm.sla.model.SLAMngVO;
import truebon.com.opm.sla.service.SLAMngService;

@Service("SLAMngService")
public class SLAMngServiceImpl  extends EgovAbstractServiceImpl implements SLAMngService{

	@Resource(name = "SLAMngDAO")
	private SLAMngDAO slaMngDAO;
	
	/**
	* Excel 값 넣기
	* 
	* @param vo - Excel row
	* @return void형
	* @exception Exception
	*/
	public void insertExcel(SLAMngVO vo) throws Exception {
		slaMngDAO.insertExcel(vo);
	      
	}
}
