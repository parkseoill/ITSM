package truebon.com.crm.lcm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import truebon.com.crm.lcm.dao.LcnDAO;
import truebon.com.crm.lcm.model.LcnVO;
import truebon.com.crm.lcm.service.LcnService;

@Service("LcnService")
public class LcnServiceImpl extends EgovAbstractServiceImpl implements LcnService{

    @Resource(name="LcnDAO")
    private LcnDAO lcnDAO;

    /** ID Generation */
	@Resource(name="egovLcnMngIdGnrService")
	private EgovIdGnrService egovLcnMngIdGnrService;
	
	 /**
	 * 라이센스 목록을 조회한다.
	 * @param vo - 조회할 정보가 담긴 LcnVO
	 * @return 조회한 라이센스 목록
	 * @exception Exception
	 */
	public List<LcnVO> selectLcnList(LcnVO searchVO) throws Exception{
		return lcnDAO.selectLcnList(searchVO);
	}
	
    /**
	 * 라이센스 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return 라이센스 총 갯수
	 * @exception
	 */
    public int selectLcnListTotCnt(LcnVO searchVO) {
		return lcnDAO.selectLcnListTotCnt(searchVO);
	}
    
	/**
	 * 라이센스를 등록한다.
	 * @param vo - 등록할 정보가 담긴 LcnVO
	 * @exception Exception
	 */
    public void insertLcn(LcnVO vo) throws Exception	{
    	
    	/** ID Generation Service */
    	String uniqId = egovLcnMngIdGnrService.getNextStringId();
    	vo.setLcnId(uniqId);
    	
    	// 로그인 객체 선언
    	LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
    	if(user == null) {
    		vo.setRegstrId("guest");
    		vo.setAmndrId("guest");
    	}else {
    		vo.setRegstrId(user.getId());
    		vo.setAmndrId(user.getId());
    	}
    	lcnDAO.insertLcn(vo);
    }
    
    /**
	 * 라이센스를 조회한다.
	 * @param vo - 조회할 정보가 담긴 LcnVO
	 * @return 조회한 라이센스
	 * @exception Exception
	 */
    public LcnVO selectLcn(LcnVO vo) throws Exception {
    	LcnVO resultVO = lcnDAO.selectLcn(vo);
    	if (resultVO == null)
    		throw processException("info.nodata.msg");
    	return resultVO;
    }
    
    /**
	 * 라이센스를 수정한다.
	 * @param vo - 수정할 정보가 담긴 LcnVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateLcn(LcnVO vo) throws Exception{
    	// 로그인 객체 선언
    	LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
    	vo.setAmndrId(user.getId());
    	
    	lcnDAO.updateLcn(vo);
    }
    
    /**
	 * 라이센스를 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 LcnVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteLcn(LcnVO vo) throws Exception{
    	// 로그인 객체 선언
    	LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
    	vo.setAmndrId(user.getId());
    	
    	lcnDAO.deleteLcn(vo);
    }
    
    /**
     * 라이센스를 멀티 삭제 한다. (화면에 조회된 라이센스 목록 정보를 데이터베이스에서 삭제)
     * @param checkedLcnMngForDel
     */
    public void deleteLcnMngList(LcnVO lcnVO) throws Exception{
    	LcnVO vo = new LcnVO();
    	String [] delLcnId = lcnVO.getCheckedValueForDel().split(",");
		
		for (int i=0; i<delLcnId.length ; i++){
			vo.setLcnId(delLcnId[i]);
			deleteLcn(vo);
		}
    }
}
