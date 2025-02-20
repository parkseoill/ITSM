package truebon.com.crm.slm.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import truebon.com.crm.slm.dao.SvclifeDAO;
import truebon.com.crm.slm.model.SvclifeMngVO;
import truebon.com.crm.slm.service.SvclifeService;


/**
 * 대개체관리 을 위한 서비스 구현 클래스
 * @author 이미현
 * @since 2023.10.04
 * @version 1.0
 * @see
 *  
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *  수정일                      수정자                   수정내용
 *  ----------   --------   ---------------------------
 *  2023.10.04   이미현                   최초 생성
 *
 * </pre>
 */

@Service("SvclifeService")
public class SvclifeServiceImpl extends EgovAbstractServiceImpl implements SvclifeService{
	
	@Resource(name = "SvclifeDAO" )
	private SvclifeDAO svcLifeDAO;

	/**
	 * TB_HW_ASSET 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return TB_HW_ASSET 목록
	 * @exception Exception
	 */
	public List<SvclifeMngVO> selectSvclifeList(SvclifeMngVO searchVO)throws Exception{
		return svcLifeDAO.selectSvclifeList(searchVO);
	}
	
	
	
	/**
	 * TB_HW_ASSET 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return TB_HW_ASSET 총 갯수
	 * @exception
	 */
	public int selectSvclifeListTotCnt(SvclifeMngVO searchVO) {
		return svcLifeDAO.selectSvclifeListTotCnt(searchVO);
	}
	
	
	
	/**
	 * TB_HW_ASSET 목록을 조회한다.  (엑셀 다운로드)
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return EgovMap 목록
	 * @exception Exception
	 */
	public List<EgovMap> selectSvclifeEgoMap(SvclifeMngVO searchVO) throws Exception {
		return svcLifeDAO.selectSvclifeEgoMap(searchVO);
	}

	

}
