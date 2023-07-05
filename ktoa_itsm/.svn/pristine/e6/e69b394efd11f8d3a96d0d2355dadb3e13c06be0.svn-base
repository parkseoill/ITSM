package truebon.com.sta.req.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import truebon.com.opm.srm.model.SrMasterVO;

/**
 * 요청통계에 대한 DAO 클래스를 정의한다
 * @author 김도아
 * @since 2022.10.20
 * @version 1.0
 * @see
 *  
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *  수정일               수정자            수정내용
 *  ----------   --------   ---------------------------
 *  2022.10.20   김도아           최초 생성
 *
 * </pre>
 */

@Repository("RequestDAO")
public class RequestDAO extends EgovComAbstractDAO {

    /**
	 * tb_srMaster을 조회한다.
	 * @param vo - 조회할 정보가 담긴 SrMasterVO
	 * @return 조회한 tb_srMaster
	 * @exception Exception
	 */
    public SrMasterVO selectRequest(SrMasterVO vo) throws Exception {
        return (SrMasterVO)selectOne("RequestMapper.selectRequest", vo);
    }

    /**
	 * tb_srMaster 요청통계(담당자별)목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return tb_srMaster 목록
	 * @exception Exception
	 */
    public List<SrMasterVO> selectReqChrList(SrMasterVO searchVO) throws Exception {
        return selectList("RequestMapper.selectReqChrList", searchVO);
    }
    
    /**
	 * tb_srMaster 요청통계(요청구분별)목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return tb_srMaster 목록
	 * @exception Exception
	 */
    public List<SrMasterVO> selectReqList(SrMasterVO searchVO) throws Exception {
        return selectList("RequestMapper.selectReqList", searchVO);       
    }
    
    /**
	 * tb_srMaster 요청통계(부서별)목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return tb_srMaster 목록
	 * @exception Exception
	 */
    public List<SrMasterVO> selectReqDeptList(SrMasterVO searchVO) throws Exception {
        return selectList("RequestMapper.selectReqDeptList", searchVO);
    }
    
    /**
	 * tb_srMaster 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return tb_srMaster 총 갯수
	 * @exception
	 */
    public int selectReqListTotCnt(SrMasterVO searchVO) {
        return (Integer)selectOne("RequestMapper.selectReqListTotCnt", searchVO);
    }
    
}
