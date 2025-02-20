package truebon.com.fai.fcs.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import truebon.com.fai.fcs.dao.FailureMngCsDAO;
import truebon.com.fai.fcs.model.FailureMngCsVO;
import truebon.com.fai.fcs.service.FailureMngCsService;


/**
 * 장애관리현황을 위한 서비스 구현 클래스
 * @author 이미현
 * @since 2023.10.26
 * @version 1.0
 * @see
 *  
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *  수정일                      수정자                   수정내용
 *  ----------   --------   ---------------------------
 *  2023.10.26   이미현                   최초 생성
 *
 * </pre>
 */

@Service("FailureMngCsService")
public class FailureMngCsServiceImpl extends EgovAbstractServiceImpl implements FailureMngCsService{
	
	@Resource(name = "FailureMngCsDAO")
	private FailureMngCsDAO failureMngCsDAO;

	/**
	 * TB_FAIL 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return TB_FAIL 목록
	 * @exception Exception
	 */
	 public List<FailureMngCsVO> selectFailureMngCsList(FailureMngCsVO searchVO) throws Exception {
		return this.failureMngCsDAO.selectFailureMngCsList(searchVO);
	}	
	
	 
	/**
	 * TB_FAIL 목록을 조회한다. (엑셀 다운로드)
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return EgovMap 목록
	 * @exception Exception
	 */
	 public List<EgovMap> selectFailureMngCsEgoMap(FailureMngCsVO searchVO) throws Exception {
		return this.failureMngCsDAO.selectFailureMngCsEgoMap(searchVO);
	 } 
}