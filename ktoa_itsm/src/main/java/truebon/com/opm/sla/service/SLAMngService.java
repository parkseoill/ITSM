package truebon.com.opm.sla.service;

import truebon.com.opm.sla.model.SLAMngVO;


public interface SLAMngService {
	
	
	/**
	* Excel 데이터를 입력한다.
	* @param Excel row 
	* @exception Exception
	*/
    void insertExcel(SLAMngVO vo) throws Exception;
}
