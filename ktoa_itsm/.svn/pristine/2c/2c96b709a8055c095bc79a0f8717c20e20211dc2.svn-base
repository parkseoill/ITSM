package truebon.com.fai.prd.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import truebon.com.fai.prd.model.FailPeriod;
import truebon.com.fai.prd.model.FailPeriodVO;
import truebon.com.fai.prd.service.FailPeriodCdService;
import truebon.com.opm.biz.model.BizSytmVO;
import truebon.com.fai.prd.dao.FailPeriodCdDAO;

@Service("FailPeriodCdService")
public class FailPeriodCdServiceImpl extends EgovAbstractServiceImpl implements FailPeriodCdService {

	@Resource(name = "FailPeriodCdDAO")
	private FailPeriodCdDAO failPeriodDAO;
	/**
	 * tb_fail_grade 목록을 조회한다.
	 * 
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return tb_fail_grade 목록
	 * @exception Exception
	 */
	public List<FailPeriod> selectFailPeriodList(FailPeriodVO vo) throws Exception {
		return failPeriodDAO.selectFailPeriodList(vo);
	}
	
	/**
	 * tb_fail_grade 총 개수를 조회한다.
	 * 
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return tb_fail_grade 목록 개수
	 * @exception Exception
	 */
	public int selectFailPeriodListTotCnt(FailPeriodVO vo) throws Exception {
		return failPeriodDAO.selectFailPeriodListTotCnt(vo);
	}
	
	/**
	  * 장애등급을 상세항목을 조회한다.
	  * @param FailPeriod
	  * @return FailPeriod
	  *  @throws Exception
	  */
	public FailPeriodVO selectFailPeriod(FailPeriodVO searchVO) throws Exception {
		return failPeriodDAO.selectFailPeriod(searchVO);
	}
	
    /**
   	 * 장애등급을 수정한다.
   	 * @param vo - 수정할 정보가 담긴 FailPeriod
   	 * @return void형
   	 * @exception Exception
   	 */
	public void updateFailPeriod(FailPeriodVO vo) throws Exception {
    	// 로그인 객체 선언
    	LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
    	vo.setAmndrId(user.getId());
    	
		failPeriodDAO.updateFailPeriod(vo);
	}
	
	/**
   	 * 장애조치기한을 추가한다.
   	 * @param vo - 추가할 정보가 담긴 FailPeriod
   	 * @return void형
   	 * @exception Exception
   	 */
	public void insertFailPeriod(FailPeriodVO vo) throws Exception {
		// 로그인 객체 선언
    	LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
    	vo.setRegstrId(user.getId());
    	
    	failPeriodDAO.insertFailPeriod(vo);
	}
    
    /**
	 * tb_biz_sytm 장애등급 없는 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return tb_biz_sytm 목록
	 * @exception Exception
	 */
    public List<BizSytmVO> selectFailBizSytmList(BizSytmVO searchVO) throws Exception {
		return failPeriodDAO.selectFailBizSytmList(searchVO);
	}
}
