package truebon.com.rsm.wmr.service;

import java.util.List;

import truebon.com.rsm.wmr.model.BizReport;
import truebon.com.rsm.wmr.model.BizReportVO;

/**
 * 업무보고서를 위한 서비스 인터페이스 클래스
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
public interface BizReportService {
	
	/**
	 * tb_biz_report를 등록한다.
	 * @param vo - 등록할 정보가 담긴 BizReport
	 * @return String형
	 * @exception Exception
	 */
    String insertBizReport(BizReportVO vo) throws Exception;
    
    /**
	 * tb_biz_report를 수정한다.
	 * @param vo - 수정할 정보가 담긴 BizReportVO
	 * @return void형
	 * @exception Exception
	 */
    void updateBizReport(BizReportVO vo) throws Exception;
    
    /**
	 * tb_biz_report를 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 BizReport
	 * @return void형 
	 * @exception Exception
	 */
    void deleteBizReport(BizReport vo) throws Exception;
    
    /**
	 * tb_biz_report를 조회한다.
	 * @param vo - 조회할 정보가 담긴 BizReportVO
	 * @return 조회한 tb_biz_report
	 * @exception Exception
	 */
    BizReportVO selectBizReport(BizReportVO vo) throws Exception;
    
    /**
	 * tb_biz_report 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 BizReportVO
	 * @return tb_biz_report 목록
	 * @exception Exception
	 */
    List<BizReportVO> selectBizReportList(BizReportVO searchVO) throws Exception;
    
    /**
	 * tb_biz_report 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 BizReportVO
	 * @return tb_biz_report 총 갯수
	 * @exception
	 */
    int selectBizReportListTotCnt(BizReportVO searchVO);
    
    /**
     * 화면에 조회된 업무담당자 목록 정보를 데이터베이스에서 삭제
     * @param checkedValueForDel
     * @throws Exception
     */
    void deleteBizReportList(BizReportVO bizReportVO) throws Exception;
}
