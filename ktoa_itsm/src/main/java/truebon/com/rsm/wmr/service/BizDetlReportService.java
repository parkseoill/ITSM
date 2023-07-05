package truebon.com.rsm.wmr.service;

import java.util.List;

import truebon.com.rsm.wmr.model.BizDetlReport;
import truebon.com.rsm.wmr.model.BizDetlReportVO;

/**
 * 업무상세보고서를 위한 서비스 인터페이스 클래스
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
public interface BizDetlReportService {
	
	/**
	 * tb_biz_detl_report를 등록한다.
	 * @param vo - 등록할 정보가 담긴 BizDetlReport
	 * @exception Exception
	 */
    void insertBizDetlReport(BizDetlReport vo) throws Exception;
    
    /**
	 * tb_biz_detl_report를 수정한다.
	 * @param vo - 수정할 정보가 담긴 BizDetlReport
	 * @return void형
	 * @exception Exception
	 */
    void updateBizDetlReport(BizDetlReport vo) throws Exception;
    
    /**
	 * tb_biz_detl_report를 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 BizDetlReport
	 * @return void형 
	 * @exception Exception
	 */
    void deleteBizDetlReport(BizDetlReport vo) throws Exception;
    
    /**
	 * tb_biz_detl_report를 조회한다.
	 * @param vo - 조회할 정보가 담긴 BizDetlReportVO
	 * @return 조회한 tb_biz_detl_report
	 * @exception Exception
	 */
    BizDetlReportVO selectBizDetlReport(BizDetlReportVO vo) throws Exception;
    
    /**
	 * tb_biz_detl_report 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 BizDetlReportVO
	 * @return tb_biz_detl_report 목록
	 * @exception Exception
	 */
    List<BizDetlReportVO> selectBizDetlReportList(BizDetlReportVO searchVO) throws Exception;
    
    /**
	 * tb_biz_detl_report 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 BizDetlReportVO
	 * @return tb_biz_detl_report 총 갯수
	 * @exception
	 */
    int selectBizDetlReportListTotCnt(BizDetlReportVO searchVO);
    
    /**
	 * tb_biz_detl_report 지난목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 BizDetlReportVO
	 * @return tb_biz_detl_report 목록
	 * @exception Exception
	 */
    BizDetlReportVO RegBizDetlReport(BizDetlReportVO searchVO) throws Exception;
    
}
