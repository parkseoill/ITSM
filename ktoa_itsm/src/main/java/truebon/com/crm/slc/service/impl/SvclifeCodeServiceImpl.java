package truebon.com.crm.slc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import truebon.com.crm.hwm.model.HwMngVO;
import truebon.com.crm.slc.dao.SvclifeCodeDAO;
import truebon.com.crm.slc.model.SvclifeCodeMngVO;
import truebon.com.crm.slc.service.SvclifeCodeService;

/**
 * 내용연수 관리 목록 을 위한 서비스 구현 클래스
 * @author 이미현
 * @since 2023.11.07
 * @version 1.0
 * @see
 *  
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *  수정일                      수정자                   수정내용
 *  ----------   --------   ---------------------------
 *  2023.11.07   이미현                   최초 생성
 *
 * </pre>
 */
@Service("SvclifeCodeService")
public class SvclifeCodeServiceImpl extends EgovAbstractServiceImpl implements SvclifeCodeService  {

	/** ID Generation */
    @Resource(name="egovSvclifeMngIdGnrService")
    private EgovIdGnrService egovSvclifeMngIdGnrService;
	
	@Resource(name = "SvclifeCodeDAO")
	private SvclifeCodeDAO svcLifeCodeDAO;
	
	/**
	 * TB_DUR_YEAR 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return TB_DUR_YEAR 목록
	 * @exception Exception
	 */
	public List<SvclifeCodeMngVO> selectSvclifeCodeList(SvclifeCodeMngVO searchVO)throws Exception{
		return svcLifeCodeDAO.selectSvclifeCodeList(searchVO);
	}
	
	/**
	 * TB_DUR_YEAR 총 갯수 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return TB_DUR_YEAR 총 갯수
	 * @exception 
	 */
	public int selectSvclifeCodeListTotCnt(SvclifeCodeMngVO searchVO) {
		return svcLifeCodeDAO.selectSvclifeCodeListTotCnt(searchVO);
	}
	
	/**
	 * TB_DUR_YEAR을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return TB_DUR_YEAR 
	 * @exception Exception
	 */
	public SvclifeCodeMngVO selectSvclifeCode(SvclifeCodeMngVO vo) throws Exception{
		SvclifeCodeMngVO resultVO = svcLifeCodeDAO.selectSvclifeCode(vo);
		if (resultVO == null)
            throw processException("info.nodata.msg");
		return resultVO;
	}
	
	/**
	 * TB_DUR_YEAR을 수정한다.
	 * @param vo - 수정할 정보가 담긴  SvclifeCodeMngVO
	 * @return void형
	 * @exception Exception
	 */
	public void updateSvclifeCode(SvclifeCodeMngVO vo) throws Exception {
		LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
		vo.setAmndrId(user.getId());
		svcLifeCodeDAO.updateSvclifeCode(vo);
	}
	
	
	/**
	 * TB_DUR_YEAR을 등록한다.
	 * @param vo - 등록할 정보가 담긴 SvclifeCodeMngVO
	 * @return void형
	 * @exception Exception
	 */	
	public void registSvclifeCode(SvclifeCodeMngVO vo) throws Exception {  
    	String uniqId = egovSvclifeMngIdGnrService.getNextStringId();
    	vo.setSvcLifeId(uniqId);
    	
    	LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
    	vo.setRegstrId(user.getId());
    	vo.setAmndrId(user.getId());
    	
    	svcLifeCodeDAO.registSvclifeCode(vo);
    }
	
}
