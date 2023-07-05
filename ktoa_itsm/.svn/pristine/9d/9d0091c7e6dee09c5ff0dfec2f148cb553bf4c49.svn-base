package truebon.com.dlm.dla.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import truebon.com.dlm.dla.dao.DlalzQRDAO;
import truebon.com.dlm.dla.model.Dlalz;
import truebon.com.dlm.dla.model.DlalzVO;
import truebon.com.dlm.dla.service.DlalzQRService;


@Service("DlalzQRService")
public class DlalzQRServiceImpl extends EgovAbstractServiceImpl implements DlalzQRService {

	private static final Logger LOGGER = LoggerFactory.getLogger(DlalzQRServiceImpl.class);

	@Resource(name = "DlalzQRDAO")
	private DlalzQRDAO dlalzQRDAO;

	/**
	 * tb_dlalz을 수정한다.
	 * 
	 * @param vo - 수정할 정보가 담긴 Dlalz
	 * @return int형
	 * @exception Exception
	 */
	public int updateDlalzQR(Dlalz vo) throws Exception {

		return dlalzQRDAO.updateDlalzQR(vo);
	}


	/**
	 * tb_dlalz을 조회한다.
	 * 
	 * @param vo - 조회할 정보가 담긴 DlalzVO
	 * @return 조회한 tb_dlalz
	 * @exception Exception
	 */
	public DlalzVO selectDlalzQR(DlalzVO vo) throws Exception {
		DlalzVO resultVO = dlalzQRDAO.selectDlalzQR(vo);
		
		return resultVO;
	}

	/**
	 * tb_dlalz 목록을 조회한다.
	 * 
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return tb_dlalz 목록
	 * @exception Exception
	 */
	public List<DlalzVO> selectDlalzQRList(DlalzVO searchVO) throws Exception {
		return dlalzQRDAO.selectDlalzQRList(searchVO);
	}

	/**
	 * tb_dlalz 총 갯수를 조회한다. @param searchVO - 조회할 정보가 담긴 VO @return tb_dlalz 총
	 * 갯수 @exception
	 */
	public int selectDlalzQRListTotCnt(DlalzVO searchVO) {
		return dlalzQRDAO.selectDlalzQRListTotCnt(searchVO);
	}

	
	
}
