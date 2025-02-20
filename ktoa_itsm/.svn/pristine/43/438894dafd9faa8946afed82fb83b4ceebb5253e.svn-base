package truebon.com.crm.csc.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import truebon.com.crm.csc.dao.CompuSytmDAO;
import truebon.com.crm.csc.model.CompuSytmVO;
import truebon.com.crm.csc.service.CompuSytmService;

/**
 * 전산시스템현황 을 위한 서비스 구현 클래스
 * @author 이미현
 * @since 2023.10.19
 * @version 1.0
 * @see
 *  
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *  수정일                      수정자                   수정내용
 *  ----------   --------   ---------------------------
 *  2023.10.19   이미현                   최초 생성
 *
 * </pre>
 */

@Service("CompuSytmService")
public class CompuSytmServiceImpl extends EgovAbstractServiceImpl implements CompuSytmService{
	
	@Resource(name = "CompuSytmDAO")
	private CompuSytmDAO compuSytmDAO;
	
	/**
	 * TB_BIZ_SYSTEM 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return TB_BIZ_SYSTEM 목록
	 * @exception Exception
	 */
	public List<CompuSytmVO> selectCompuSytmList(CompuSytmVO searchVO) throws Exception{
		return compuSytmDAO.selectCompuSytmList(searchVO);
	}
	
	
	/**
	 * TB_BIZ_SYSTEM HW, SW 합계  목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return TB_BIZ_SYSTEM 목록
	 * @exception Exception
	 */
	public List<CompuSytmVO> selectCompuSytmSumList(CompuSytmVO searchVO) throws Exception {
		return compuSytmDAO.selectCompuSytmSumList(searchVO);
	}
	
	
	/**
	 * TB_BIZ_SYSTEM 목록을 조회한다.  (엑셀 다운로드)
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return EgovMap 목록
	 * @exception Exception
	 */
	public List<EgovMap> selectCompuSytmEgoMap(CompuSytmVO searchVO) throws Exception {
		return compuSytmDAO.selectCompuSytmEgoMap(searchVO);
	}
	
	

}
