package truebon.com.opm.biz.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import truebon.com.opm.biz.dao.BizSytmDAO;
import truebon.com.opm.biz.model.BizSytm;
import truebon.com.opm.biz.model.BizSytmVO;
import truebon.com.opm.biz.service.BizSytmService;
import truebon.com.sys.chr.service.impl.ChargerServiceImpl;

/**
 * 업무시스템을 위한 서비스 구현 클래스
 * @author 이유리
 * @since 2022.07.26
 * @version 1.0
 * @see
 *  
* <pre>
 * << 개정이력(Modification Information) >>
 *   
 *  수정일               수정자            수정내용
 *  ----------   --------   ---------------------------
 *  2022.07.26   이유리           최초 생성
 *
 * </pre>
 */

@Service("BizSytmService")
public class BizSytmServiceImpl extends EgovAbstractServiceImpl implements
BizSytmService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ChargerServiceImpl.class);

    @Resource(name="BizSytmDAO")
    private BizSytmDAO bizSytmDAO;
    
    /**
	 * tb_biz_sytm 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return tb_biz_sytm 목록
	 * @exception Exception
	 */
    public List<BizSytmVO> selectBizSytmList(BizSytmVO searchVO) throws Exception {
        return bizSytmDAO.selectBizSytmList(searchVO);
    }
    
    /**
	 * tb_biz_sytm 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return tb_biz_sytm 총 갯수
	 * @exception
	 */
    public int selectBizSytmListTotCnt(BizSytmVO searchVO) {
		return bizSytmDAO.selectBizSytmListTotCnt(searchVO);
	}
    
	/**
	 * tb_biz_sytm을 등록한다.
	 * @param vo - 등록할 정보가 담긴 BizSytm
	 * @exception Exception
	 */
    public void insertBizSytm(BizSytm vo) throws Exception {

		// 로그인 객체 선언
    	LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
    	vo.setRegstrId(user.getId());
    	bizSytmDAO.insertBizSytm(vo);
    	
    }
    
    /**
	 * tb_biz_sytm을 수정한다.
	 * @param vo - 수정할 정보가 담긴 BizSytm
	 * @return void형
	 * @exception Exception
	 */
    public void updateBizSytm(BizSytm vo) throws Exception {
    	// 로그인 객체 선언
    	LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
    	vo.setAmndrId(user.getId());
    	
    	bizSytmDAO.updateBizSytm(vo);
    }

    /**
	 * tb_biz_sytm을 조회한다.
	 * @param vo - 조회할 정보가 담긴 BizSytmVO
	 * @return 조회한 tb_biz_sytm
	 * @exception Exception
	 */
    public BizSytmVO selectBizSytm(BizSytmVO vo) throws Exception {
    	BizSytmVO resultVO = bizSytmDAO.selectBizSytm(vo);
        
        return resultVO;
    }
    
    /**
	 * tb_biz_sytm 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return tb_biz_sytm 목록
	 * @exception Exception
	 */
    public List<BizSytmVO> selectBizSytmNmList(BizSytmVO searchVO) throws Exception {
        return bizSytmDAO.selectBizSytmNmList(searchVO);
    }
}