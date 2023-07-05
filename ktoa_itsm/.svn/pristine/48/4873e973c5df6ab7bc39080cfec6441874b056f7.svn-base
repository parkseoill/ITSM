package truebon.com.rsm.wmr.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;

import truebon.com.rsm.wmr.service.BizReportService;
import truebon.com.sys.chr.model.ChargerVO;
import truebon.com.rsm.wmr.dao.BizDetlReportDAO;
import truebon.com.rsm.wmr.dao.BizReportDAO;
import truebon.com.rsm.wmr.model.BizDetlReport;
import truebon.com.rsm.wmr.model.BizReport;
import truebon.com.rsm.wmr.model.BizReportVO;
/**
 * 업무보고서를 위한 서비스 구현 클래스
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

@Service("BizReportService")
public class BizReportServiceImpl extends EgovAbstractServiceImpl implements
		BizReportService {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(BizReportServiceImpl.class);

    @Resource(name="BizReportDAO")
    private BizReportDAO bizReportDAO;
    
    @Resource(name="BizDetlReportDAO")
    private BizDetlReportDAO bizDetlReportDAO;
    
    /** ID Generation */
	@Resource(name="bizReportIdGnrService")
	private EgovIdGnrService idgenService;

	/**
	 * tb_biz_report를 등록한다.
	 * @param vo - 등록할 정보가 담긴 BizReportVO
	 * @exception Exception
	 */
    public String insertBizReport(BizReportVO vo) throws Exception {
    	String sResultCd = "0";
    	BizDetlReport bizDetlReport = new BizDetlReport();
    	
    	/** ID Generation Service */
    	String uniqId = idgenService.getNextStringId();
		vo.setBizReportId(uniqId);
		
		// 로그인 객체 선언
    	LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
    	vo.setRegstrId(user.getId());
    	vo.setAmndrId(user.getId());
    	
    	int iResult = bizReportDAO.insertBizReport(vo);
    	
    	// 업무보고서 정상 저장이라면...
    	if(iResult > 0) {
    		if(vo.getArrBizSytmCd().length > 0) {
    			bizDetlReport.setBizReportId(uniqId);
    			bizDetlReport.setBizDlngChrgrNo(vo.getCreatChrgrNo());
    			bizDetlReport.setRegstrId(user.getId());
				bizDetlReport.setAmndrId(user.getId());
    			
    			for(int i = 0; vo.getArrBizSytmCd().length > i; i++) {
    				bizDetlReport.setBizSytmCd(vo.getArrBizSytmCd()[i].toString());
    				bizDetlReport.setAcrsltText(vo.getArrAcrsltText()[i].toString());
    				bizDetlReport.setPlnText(vo.getArrPlnText()[i].toString());
    				
    				bizDetlReportDAO.insertBizDetlReport(bizDetlReport);
    			};
    		}
    		
    		sResultCd="1";
    	}
    	
    	return sResultCd;
    }

    /**
	 * tb_biz_report(tb_biz_detl_report)를 수정한다.
	 * @param vo - 수정할 정보가 담긴 BizReportVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateBizReport(BizReportVO vo) throws Exception {
    	BizDetlReport bizDetlReport = new BizDetlReport();
    	
    	// 로그인 객체 선언
    	LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
    	vo.setAmndrId(user.getId());
    	bizReportDAO.updateBizReport(vo);
    	// 업무시스템 코드가 있는 경우...
    	if(vo.getArrBizSytmCd().length > 0) {
    		bizDetlReport.setBizReportId(vo.getBizReportId());
    		bizDetlReport.setBizDlngChrgrNo(vo.getCreatChrgrNo());
    		bizDetlReport.setRegstrId(user.getId());
			bizDetlReport.setAmndrId(user.getId());
			
			// 업무시스템 전체 삭제
			bizDetlReportDAO.deleteBizDetlReport(bizDetlReport);
    		
			for(int i = 0; vo.getArrBizSytmCd().length > i; i++) {
				bizDetlReport.setBizSytmCd(vo.getArrBizSytmCd()[i].toString());
				bizDetlReport.setAcrsltText(vo.getArrAcrsltText()[i].toString());
				bizDetlReport.setPlnText(vo.getArrPlnText()[i].toString());
				
				bizDetlReportDAO.insertBizDetlReport(bizDetlReport);
			};
		}
    }

    /**
	 * tb_biz_report를 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 BizReport
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteBizReport(BizReport vo) throws Exception {
    	// 로그인 객체 선언
    	LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
    	vo.setAmndrId(user.getId());
    	
    	bizReportDAO.deleteBizReport(vo);
    }
    
    /**
     * 화면에 조회된 업무담당자 목록 정보를 데이터베이스에서 삭제
     * @param checkedValueForDel
     * @throws Exception
     */
    public void deleteBizReportList(BizReportVO bizReportVO) throws Exception {
    	BizReportVO vo = new BizReportVO();
		String [] delId = bizReportVO.getCheckedValueForDel().split(",");
		
		for (int i=0; i<delId.length ; i++){
			vo.setBizReportId(delId[i]);
			deleteBizReport(vo);
		}
	}

    /**
	 * tb_biz_report를 조회한다.
	 * @param vo - 조회할 정보가 담긴 BizReportVO
	 * @return 조회한 tb_biz_report
	 * @exception Exception
	 */
    public BizReportVO selectBizReport(BizReportVO vo) throws Exception {
    	BizReportVO resultVO = bizReportDAO.selectBizReport(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * tb_biz_report 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 BizReportVO
	 * @return tb_biz_report 목록
	 * @exception Exception
	 */
    public List<BizReportVO> selectBizReportList(BizReportVO searchVO) throws Exception {
    	LoginVO user = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
    	// 관리자 권한이 아니라면...
    	if(!"ROLE_ADMIN".equals(user.getAuthorCode())) {
    		// 담당자가 최조 들어온 경우...
    		if(searchVO.getCreatChrgrNo() == null) {
    			searchVO.setCreatChrgrNo(user.getChrgrNo());	
    		}
    	}
    	
    	return bizReportDAO.selectBizReportList(searchVO);
    }
    
    /**
	 * tb_biz_report 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 BizReportVO
	 * @return tb_biz_report 총 갯수
	 * @exception
	 */
    public int selectBizReportListTotCnt(BizReportVO searchVO) {
		return bizReportDAO.selectBizReportListTotCnt(searchVO);
	}
}
