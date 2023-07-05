package truebon.com.rsm.wmr.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import truebon.com.rsm.wmr.model.BizReport;
import truebon.com.rsm.wmr.model.BizReportVO;

/**
 * 업무보고서에 대한 DAO 클래스를 정의한다
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

@Repository("BizReportDAO")
public class BizReportDAO extends EgovComAbstractDAO {

	/**
	 * tb_biz_report를 등록한다.
	 * @param vo - 등록할 정보가 담긴 BizReport
	 * @return int형
	 * @exception Exception
	 */
    public int insertBizReport(BizReport vo) throws Exception {
        return insert("BizReportMapper.insertBizReport", vo);
    }

    /**
	 * tb_biz_report를 수정한다.
	 * @param vo - 수정할 정보가 담긴 BizReport
	 * @return void형
	 * @exception Exception
	 */
    public void updateBizReport(BizReport vo) throws Exception {
        update("BizReportMapper.updateBizReport", vo);
    }

    /**
	 * tb_biz_report를 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 BizReport
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteBizReport(BizReport vo) throws Exception {
        delete("BizReportMapper.deleteBizReport", vo);
    }

    /**
	 * tb_biz_report를 조회한다.
	 * @param vo - 조회할 정보가 담긴 BizReport
	 * @return 조회한 tb_biz_report
	 * @exception Exception
	 */
    public BizReportVO selectBizReport(BizReport vo) throws Exception {
        return (BizReportVO)selectOne("BizReportMapper.selectBizReport", vo);
    }

    /**
	 * tb_biz_report 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 BizReportVO
	 * @return tb_biz_report 목록
	 * @exception Exception
	 */
    public List<BizReportVO> selectBizReportList(BizReportVO searchVO) throws Exception {
        return selectList("BizReportMapper.selectBizReportList", searchVO);
    }

    /**
	 * tb_biz_report 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 BizReportVO
	 * @return tb_biz_report 총 갯수
	 * @exception
	 */
    public int selectBizReportListTotCnt(BizReportVO searchVO) {
        return (Integer)selectOne("BizReportMapper.selectBizReportListTotCnt", searchVO);
    }
}
