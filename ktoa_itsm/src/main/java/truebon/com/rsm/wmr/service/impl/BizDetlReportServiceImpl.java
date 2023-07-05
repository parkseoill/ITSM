package truebon.com.rsm.wmr.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import truebon.com.rsm.wmr.service.BizDetlReportService;
import truebon.com.rsm.wmr.dao.BizDetlReportDAO;
import truebon.com.rsm.wmr.model.BizDetlReport;
import truebon.com.rsm.wmr.model.BizDetlReportVO;
/**
 * 업무상세보고서를 위한 서비스 구현 클래스
 * @author 이태신
 * @since 2022.08.19
 * @version 1.0
 * @see
 *  
* <pre>
 * << 개정이력(Modification Information) >>
 *   
 *  수정일               수정자            수정내용
 *  ----------   --------   ---------------------------
 *  2022.08.19   이태신           최초 생성
 *
 * </pre>
 */

@Service("BizDetlReportService")
public class BizDetlReportServiceImpl extends EgovAbstractServiceImpl implements
		BizDetlReportService {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(BizDetlReportServiceImpl.class);

    @Resource(name="BizDetlReportDAO")
    private BizDetlReportDAO bizDetlReportDAO;
    
    /**
	 * tb_biz_detl_report를 등록한다.
	 * @param vo - 등록할 정보가 담긴 BizDetlReport
	 * @exception Exception
	 */
    public void insertBizDetlReport(BizDetlReport vo) throws Exception {
		
		// 로그인 객체 선언
    	LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
    	vo.setRegstrId(user.getId());
    	vo.setAmndrId(user.getId());
    	
    	bizDetlReportDAO.insertBizDetlReport(vo);
    }

    /**
	 * tb_biz_detl_report를 수정한다.
	 * @param vo - 수정할 정보가 담긴 BizDetlReport
	 * @return void형
	 * @exception Exception
	 */
    public void updateBizDetlReport(BizDetlReport vo) throws Exception {
    	// 로그인 객체 선언
    	LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
    	vo.setAmndrId(user.getId());
    	
    	bizDetlReportDAO.updateBizDetlReport(vo);
    }

    /**
	 * tb_biz_detl_report를 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 BizDetlReport
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteBizDetlReport(BizDetlReport vo) throws Exception {
    	// 로그인 객체 선언
    	LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
    	vo.setAmndrId(user.getId());
    	
    	bizDetlReportDAO.deleteBizDetlReport(vo);
    }

    /**
	 * tb_biz_detl_report를 조회한다.
	 * @param vo - 조회할 정보가 담긴 BizDetlReportVO
	 * @return 조회한 tb_biz_report
	 * @exception Exception
	 */
    public BizDetlReportVO selectBizDetlReport(BizDetlReportVO vo) throws Exception {
    	BizDetlReportVO resultVO = bizDetlReportDAO.selectBizDetlReport(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * tb_biz_detl_report 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 BizDetlReportVO
	 * @return tb_biz_report 목록
	 * @exception Exception
	 */
    public List<BizDetlReportVO> selectBizDetlReportList(BizDetlReportVO searchVO) throws Exception {
        return bizDetlReportDAO.selectBizDetlReportList(searchVO);
    }
    
    /**
	 * tb_biz_detl_report 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 BizDetlReportVO
	 * @return tb_biz_report 총 갯수
	 * @exception
	 */
    public int selectBizDetlReportListTotCnt(BizDetlReportVO searchVO) {
		return bizDetlReportDAO.selectBizDetlReportListTotCnt(searchVO);
	}
    
    /**
	 * tb_biz_detl_report 지난목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 BizDetlReportVO
	 * @return tb_biz_report 목록
	 * @exception Exception
	 */
    public BizDetlReportVO RegBizDetlReport(BizDetlReportVO searchVO) throws Exception {
        return bizDetlReportDAO.RegBizDetlReport(searchVO);
    }
}
