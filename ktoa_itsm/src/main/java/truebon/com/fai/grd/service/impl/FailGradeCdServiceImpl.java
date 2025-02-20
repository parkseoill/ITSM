package truebon.com.fai.grd.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import truebon.com.fai.grd.dao.FailGradeCdDAO;
import truebon.com.fai.grd.model.FailGrade;
import truebon.com.fai.grd.model.FailGradeVO;
import truebon.com.fai.grd.service.FailGradeCdService;
import truebon.com.opm.biz.dao.BizSytmDAO;
import truebon.com.opm.biz.model.BizSytmVO;
import truebon.com.opm.com.model.ComnCdNewVO;

@Service("FailGradeCdService")
public class FailGradeCdServiceImpl extends EgovAbstractServiceImpl implements FailGradeCdService {
	@Resource(name = "FailGradeCdDAO")
	private FailGradeCdDAO failGradeCdDAO;
	
	/**
	 * tb_fail_grade 목록을 조회한다.
	 * 
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return tb_fail_grade 목록
	 * @exception Exception
	 */
	public List<FailGrade> selectFailGradeList(FailGrade vo) throws Exception {
		return failGradeCdDAO.selectFailGradeList(vo);
	}
	
	/**
	 * tb_fail_grade 총 개수를 조회한다.
	 * 
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return tb_fail_grade 목록 개수
	 * @exception Exception
	 */
	public int selectFailGradeListTotCnt(FailGrade vo) throws Exception {
		return failGradeCdDAO.selectFailGradeListTotCnt(vo);
	}
	
	/**
	  * 장애등급을 상세항목을 조회한다.
	  * @param FailGrade
	  * @return FailGrade
	  *  @throws Exception
	  */
	public FailGradeVO selectFailGrade(FailGrade searchVO) throws Exception {
		return failGradeCdDAO.selectFailGrade(searchVO);
	}
	
    /**
   	 * 장애등급을 수정한다.
   	 * @param vo - 수정할 정보가 담긴 FailGrade
   	 * @return void형
   	 * @exception Exception
   	 */
	public void updateFailGrade(FailGrade vo) throws Exception {
	   	// 로그인 객체 선언
    	LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
    	vo.setAmndrId(user.getId());
    	
    	failGradeCdDAO.updateFailGrade(vo);
	}
    /**
	 * 공통코드NEW 목록을 조회한다.
	 */
  
    public List<ComnCdNewVO> selectGradeList(ComnCdNewVO vo) throws Exception {
        return failGradeCdDAO.selectGradeList(vo);
    }


}
