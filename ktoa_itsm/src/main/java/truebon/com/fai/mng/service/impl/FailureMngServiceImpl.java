package truebon.com.fai.mng.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import truebon.com.fai.mng.dao.FailureMngDAO;
import truebon.com.fai.mng.model.FailureMngVO;
import truebon.com.fai.mng.service.FailureMngService;

/**
 * 장애관리을 위한 서비스 구현 클래스
 * 
 * @author 박서일
 * @since 2023.10.04
 * @version 1.0
 * @see
 * 
 *      <pre>
 * << 개정이력(Modification Information) >>
 *   
 *  수정일               수정자            수정내용
 *  ----------   --------   ---------------------------
 *  2023.10.19   박서일           최초 생성
 *
 *      </pre>
 */
@Service("FailureMngService")
public class FailureMngServiceImpl extends EgovAbstractServiceImpl implements FailureMngService {

	/** ID Generation */
	@Resource(name = "egovFailureMngIdGnrService")
	private EgovIdGnrService egovFailureMngIdGnrService;

	@Resource(name = "FailureMngDAO")
	private FailureMngDAO failureMngDAO;

	/**
	 * 장애 목록을 조회한다.
	 * 
	 * @param vo - 조회할 정보가 담긴 FailureMngVO
	 * @return 조회한 라이센스 목록
	 * @exception Exception
	 */
	public List<FailureMngVO> selectFailureMngList(FailureMngVO searchVO) throws Exception {
		return failureMngDAO.selectFailureMngList(searchVO);
	}

	/**
	 * 장애 총 갯수를 조회한다. 
	 * @param searchVO - 조회할 정보가 담긴 VO 
	 * @return 장애 총 갯수 @exception
	 */
	public int selectFailureListTotCnt(FailureMngVO searchVO) {
		return failureMngDAO.selectFailureListTotCnt(searchVO);
	}

	public FailureMngVO selectFailureMng(FailureMngVO vo) throws Exception {
		FailureMngVO resultVO = failureMngDAO.selectFailureMng(vo);
		if (resultVO == null)
			throw processException("info.nodata.msg");
		return resultVO;
	}

	/**
	 * 장애 조치기한 가이드를 조회한다.
	 * 
	 * @exception Exception
	 */
	public List<Map<String, Object>> selectMngmntPeriodGuide() throws Exception {
		return failureMngDAO.selectMngmntPeriodGuide();
	}

	/**
	 * 장애 등급을 조회한다.
	 * 
	 * @param vo - 조회할 정보가 담긴 FailureMngVO
	 * @exception Exception
	 */
	public FailureMngVO selectFailureGrd(FailureMngVO failureMngVO) throws Exception {
		return failureMngDAO.selectFailureGrd(failureMngVO);
	}

	/**
	 * 장애관리를 업데이트 한다.
	 * 
	 * @param vo - 업데이트할 정보가 담긴 FailureMngVO
	 * @exception Exception
	 */
	public void updateFailureMng(FailureMngVO vo) throws Exception {
		LoginVO user = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
		vo.setAmndrId(user.getId());
		failureMngDAO.updateFailureMng(vo);
	}

	/**
	 * 장애관리를 등록 한다.
	 * 
	 * @param vo - 등록할 정보가 담긴 FailureMngVO
	 * @exception Exception
	 */
	public void registFailureMng(FailureMngVO vo) throws Exception {

		String uniqId = egovFailureMngIdGnrService.getNextStringId();
		vo.setFailrMngtId((vo.getFailrOccurDt().replaceAll("-", "")).substring(0, 8) + uniqId);

		LoginVO user = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
		vo.setRegstrId(user.getId());
		vo.setAmndrId(user.getId());
		failureMngDAO.registFailureMng(vo);
	}

	/**
	 * 장애 목록을 조회한다. (엑셀 다운로드)
	 * 
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return EgovMap 목록
	 * @exception Exception
	 */
	public List<EgovMap> selectFailureEgovMap(FailureMngVO searchVO) throws Exception {
		return failureMngDAO.selectFailureEgovMap(searchVO);
	}

}
