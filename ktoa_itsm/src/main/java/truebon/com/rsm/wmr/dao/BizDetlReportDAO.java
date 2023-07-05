package truebon.com.rsm.wmr.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import truebon.com.rsm.wmr.model.BizDetlReport;
import truebon.com.rsm.wmr.model.BizDetlReportVO;

/**
 * 업무상세보고서에 대한 DAO 클래스를 정의한다
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

@Repository("BizDetlReportDAO")
public class BizDetlReportDAO extends EgovComAbstractDAO {

	/**
	 * tb_biz_detl_report를 등록한다.
	 * @param vo - 등록할 정보가 담긴 BizDetlReport
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void insertBizDetlReport(BizDetlReport vo) throws Exception {
        insert("BizDetlReportMapper.insertBizDetlReport", vo);
    }

    /**
	 * tb_biz_detl_report를 수정한다.
	 * @param vo - 수정할 정보가 담긴 BizDetlReport
	 * @return void형
	 * @exception Exception
	 */
    public void updateBizDetlReport(BizDetlReport vo) throws Exception {
        update("BizDetlReportMapper.updateBizDetlReport", vo);
    }

    /**
	 * tb_biz_detl_report를 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 BizDetlReport
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteBizDetlReport(BizDetlReport vo) throws Exception {
    	delete("BizDetlReportMapper.deleteBizDetlReport", vo);
    }

    /**
	 * tb_biz_detl_report를 조회한다.
	 * @param vo - 조회할 정보가 담긴 BizDetlReport
	 * @return 조회한 tb_biz_detl_report
	 * @exception Exception
	 */
    public BizDetlReportVO selectBizDetlReport(BizDetlReport vo) throws Exception {
        return (BizDetlReportVO)selectOne("BizDetlReportMapper.selectBizDetlReport", vo);
    }

    /**
	 * tb_biz_detl_report 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 BizDetlReportVO
	 * @return tb_biz_detl_report 목록
	 * @exception Exception
	 */
    public List<BizDetlReportVO> selectBizDetlReportList(BizDetlReportVO searchVO) throws Exception {
        return selectList("BizDetlReportMapper.selectBizDetlReportList", searchVO);
    }

    /**
	 * tb_biz_detl_report 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 BizDetlReportVO
	 * @return tb_biz_report 총 갯수
	 * @exception
	 */
    public int selectBizDetlReportListTotCnt(BizDetlReportVO searchVO) {
        return (Integer)selectOne("BizDetlReportMapper.selectBizDetlReportListTotCnt", searchVO);
    }
    
    /**
	 * tb_biz_detl_report 지난목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 BizDetlReportVO
	 * @return tb_biz_detl_report 목록
	 * @exception Exception
	 */
    public BizDetlReportVO RegBizDetlReport(BizDetlReportVO searchVO) throws Exception {
        return (BizDetlReportVO)selectOne("BizDetlReportMapper.RegBizDetlReport", searchVO);
    }
    
}
