package truebon.com.dlm.vis.service.impl;

import java.time.LocalDate;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.com.cop.tpl.service.TemplateInfVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import truebon.com.dlm.vis.dao.VisitDAO;
import truebon.com.dlm.vis.model.Visit;
import truebon.com.dlm.vis.model.VisitVO;
import truebon.com.dlm.vis.service.VisitService;

@Service("VisitService")
public class VisitServiceImpl extends EgovAbstractServiceImpl implements
		VisitService{
	
    private static final Logger LOGGER = LoggerFactory.getLogger(VisitServiceImpl.class);

    @Resource(name="VisitDAO")
    private VisitDAO visitDAO;
    
    
    /**
	 * tb_visit 입실 등록한다.
	 * @param vo - 등록할 정보가 담긴 Visit
	 * @exception Exception
	 */
    public void insertVisit(Visit vo) throws Exception {
		// 로그인 객체 선언
    	LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
    	
    	if(user != null) {
    		vo.setRegstrId(user.getId());
        	vo.setAmndrId(user.getId());	
    	} else {
    		vo.setRegstrId("guest");
        	vo.setAmndrId("guest");
    	}
    	
    	visitDAO.insertVisit(vo);
    }

    /**
	 * tb_visit을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Visit
	 * @return void형
	 * @exception Exception
	 */
    public void updateVisit(Visit vo) throws Exception {
    	// 로그인 객체 선언
    	LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
    	
    	if(user != null) {
    		vo.setAmndrId(user.getId());	
    	} else {
    		vo.setAmndrId("guest");
    	}
    	
    	visitDAO.updateVisit(vo);
    }
    
	/**
	 * 확인자를 수정한다.
	 * @param vo - 조회할 정보가 담긴 Visit
	 * @exception Exception
	 */
    public void updateConfrSign(Visit vo) throws Exception {
    	// 로그인 객체 선언
    	LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
    	
    	if(user != null) {
    		vo.setAmndrId(user.getId());	
    	} else {
    		vo.setAmndrId("guest");
    	}
    	
    	visitDAO.updateConfrSign(vo);
    }
    
    /**
     * tb_visit 퇴실 등록한다.
     * @param vo - 등록 정보가 담긴 Visit
     * @return void형
     * @exception Exception
     */
    public int updateVisitExit(Visit vo) throws Exception {
    	// 로그인 객체 선언
    	LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
    	
    	if(user != null) {
    		vo.setAmndrId(user.getId());	
    	} else {
    		vo.setAmndrId("guest");
    	}
    	
    	return visitDAO.updateVisitExit(vo);
    }
    
    /**
	 * tb_visit을 조회한다.
	 * @param vo - 조회할 정보가 담긴 VisitVO
	 * @return 조회한 tb_visit
	 * @exception Exception
	 */
    public VisitVO selectVisit(VisitVO vo) throws Exception {
    	VisitVO resultVO = visitDAO.selectVisit(vo);
        if (resultVO == null) {
        	throw processException("info.nodata.msg");
        } else {
        	// 사인이 있는경우와 없는 경우
    		if(resultVO.getUserSign() != null && resultVO.getUserSign().length != 0) {
    			// byte[] 사인 값 String값으로 저장
    			String strUserSign = new String(resultVO.getUserSign(),"UTF-8");
    			resultVO.setStrUserSign(strUserSign);
    		}else {
    			String strUserSign = resultVO.getConfrNm();
    			resultVO.setStrUserSign(strUserSign);
    		}
        }
            
        return resultVO;
    }

    /**
	 * tb_visit 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return tb_visit 목록
	 * @exception Exception
	 */
    public List<VisitVO> selectVisitList(VisitVO searchVO) throws Exception {
    	LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
    		LocalDate currentdate = LocalDate.now();
    		if(searchVO.getStartDate().equals("s")  && searchVO.getEndDate().equals("e")) {
    			if(user == null) {
    				searchVO.setStartDate(currentdate.toString());
    	    		searchVO.setEndDate(currentdate.toString());
    			}else{
    				searchVO.setStartDate("");
    	    		searchVO.setEndDate("");
    			}
    		}
    		
    	List<VisitVO> visitList = visitDAO.selectVisitList(searchVO);
    	
    	for(VisitVO visitVO : visitList){
    		// 사인이 있는경우와 없는 경우
    		if(visitVO.getUserSign() != null && visitVO.getUserSign().length != 0) {
    			Decoder decoder = Base64.getDecoder();
    			// 복호화(쿼리에서 SUBSTRING(uc.USER_SIGN, 27) 으로 앞부분 잘라낸 SVG base64 정보)
    			byte[] bUserSign = decoder.decode(visitVO.getUserSign());
    			// byte[] 사인 값 String값으로 저장
    			String strUserSign = new String(bUserSign,"UTF-8");
    			
    			visitVO.setStrUserSign(strUserSign);
    		}else {
    			String strUserSign = visitVO.getConfrNm();
    			visitVO.setStrUserSign(strUserSign);
    		}
    	}
    	
    	return visitList;
    }


    /**
	 * tb_visit 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return tb_visit 총 갯수
	 * @exception
	 */
    public int selectVisitListTotCnt(VisitVO searchVO) {
		return visitDAO.selectVisitListTotCnt(searchVO);
	}

}
