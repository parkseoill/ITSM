package truebon.com.sta.req.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import truebon.com.opm.srm.model.SrMasterVO;
import truebon.com.sta.req.dao.RequestDAO;
import truebon.com.sta.req.service.RequestService;
/**
 * 요청통계를 위한 서비스 구현 클래스
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

@Service("RequestService")
public class RequestServiceImpl extends EgovAbstractServiceImpl implements
	RequestService {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(RequestServiceImpl.class);

    @Resource(name="RequestDAO")
    private RequestDAO requestDAO;
    
    /**
	 * tb_srMaster을 조회한다.
	 * @param vo - 조회할 정보가 담긴 SrMasterVO
	 * @return 조회한 tb_srMaster
	 * @exception Exception
	 */
    public SrMasterVO selectRequest(SrMasterVO vo) throws Exception {
    	SrMasterVO resultVO = requestDAO.selectRequest(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * tb_srMaster 요청통계(담당자별)목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return tb_srMaster 목록
	 * @exception Exception
	 */
    public List<SrMasterVO> selectReqChrList(SrMasterVO searchVO) throws Exception {
    	LocalDate currentdate = LocalDate.now();
    	if(searchVO.getStartDate() == "" && searchVO.getEndDate() == "") {
    	searchVO.setStartDate(currentdate.format(DateTimeFormatter.ofPattern("yyyy-MM-01")));
       	}
    	return requestDAO.selectReqChrList(searchVO);
    }
    
    /**
	 * tb_srMaster 요청통계(요청구분별)목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return tb_srMaster 목록
	 * @exception Exception
	 */
    public List<SrMasterVO> selectReqList(SrMasterVO searchVO) throws Exception {
    	LocalDate currentdate = LocalDate.now();
    	if(searchVO.getStartDate() == "" && searchVO.getEndDate() == "") {
    	searchVO.setStartDate(currentdate.format(DateTimeFormatter.ofPattern("yyyy-MM-01")));
       	}
    	return requestDAO.selectReqList(searchVO);
    }
    
    /**
	 * tb_srMaster 요청통계(부서별)목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return tb_srMaster 목록
	 * @exception Exception
	 */
    public List<SrMasterVO> selectReqDeptList(SrMasterVO searchVO) throws Exception {
    	LocalDate currentdate = LocalDate.now();
    	if(searchVO.getStartDate() == "" && searchVO.getEndDate() == "") {
    	searchVO.setStartDate(currentdate.format(DateTimeFormatter.ofPattern("yyyy-MM-01")));
       	}
    	return requestDAO.selectReqDeptList(searchVO);
    }
    
    /**
	 * tb_srMaster 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return tb_charger 총 갯수
	 * @exception
	 */
    public int selectReqListTotCnt(SrMasterVO searchVO) {
		return requestDAO.selectReqListTotCnt(searchVO);

	}

}
