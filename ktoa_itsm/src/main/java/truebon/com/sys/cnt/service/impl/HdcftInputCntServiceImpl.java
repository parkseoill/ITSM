package truebon.com.sys.cnt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import truebon.com.sys.cnt.dao.HdcftInputCntDAO;
import truebon.com.sys.cnt.model.HdcftInputCntVO;
import truebon.com.sys.cnt.service.HdcftInputCntService;

@Service("HdcftInputCntService")
public class HdcftInputCntServiceImpl  extends EgovAbstractServiceImpl implements HdcftInputCntService {

	
	@Resource(name = "HdcftInputCntDAO")
	private HdcftInputCntDAO hdcftInputCntDAO;

	public List<HdcftInputCntVO> selectHdcftInputCntList(HdcftInputCntVO hdcftInputCntVO) throws Exception {
		return hdcftInputCntDAO.selectHdcftInputCnt(hdcftInputCntVO);
	}
	


}
