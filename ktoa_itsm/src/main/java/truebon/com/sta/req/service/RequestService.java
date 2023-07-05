package truebon.com.sta.req.service;

import java.util.List;
import truebon.com.opm.srm.model.SrMasterVO;

/**
 * 요청통계를 위한 서비스 인터페이스 클래스
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
 *  2022.10.20       김도아		 최초 생성
 *
 * </pre>
 */

public interface RequestService {
    
    /**
	 * tb_srMaster을 조회한다.
	 * @param vo - 조회할 정보가 담긴 SrMasterVO
	 * @return 조회한 tb_srMaster
	 * @exception Exception
	 */
	SrMasterVO selectRequest(SrMasterVO vo) throws Exception;
    
    /**
	 * tb_srMaster 담당자별 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return tb_srMaster 목록
	 * @exception Exception
	 */
    List<SrMasterVO> selectReqChrList(SrMasterVO searchVO) throws Exception;
    
    
    /**
	 * tb_srMaster 요청구분별 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return tb_srMaster 목록
	 * @exception Exception
	 */
    List<SrMasterVO> selectReqList(SrMasterVO searchVO) throws Exception;
    
    /**
	 * tb_srMaster 부서별 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return tb_srMaster 목록
	 * @exception Exception
	 */
    List<SrMasterVO> selectReqDeptList(SrMasterVO searchVO) throws Exception;
    
    /**
	 * tb_srMaster 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return tb_srMaster 총 갯수
	 * @exception
	 */
    int selectReqListTotCnt(SrMasterVO searchVO);
}
