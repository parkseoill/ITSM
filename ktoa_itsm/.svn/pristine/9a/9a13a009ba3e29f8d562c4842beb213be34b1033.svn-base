package truebon.com.crm.lcm.service;

import java.util.List;

import truebon.com.crm.lcm.model.LcnVO;

public interface LcnService {

	 /**
	 * 라이센스 목록을 조회한다.
	 * @param vo - 조회할 정보가 담긴 LcnVO
	 * @return 조회한 라이센스 목록
	 * @exception Exception
	 */
	List<LcnVO> selectLcnList(LcnVO searchVO) throws Exception;
	
    /**
	 * 라이센스 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return 라이센스 총 갯수
	 * @exception
	 */
    int selectLcnListTotCnt(LcnVO searchVO);
    
	/**
	 * 라이센스를 등록한다.
	 * @param vo - 등록할 정보가 담긴 LcnVO
	 * @exception Exception
	 */
    void insertLcn(LcnVO vo) throws Exception;
    
    /**
	 * 라이센스를 조회한다.
	 * @param vo - 조회할 정보가 담긴 LcnVO
	 * @return 조회한 라이센스
	 * @exception Exception
	 */
    LcnVO selectLcn(LcnVO vo) throws Exception;
    
    /**
	 * 라이센스를 수정한다.
	 * @param vo - 수정할 정보가 담긴 LcnVO
	 * @return void형
	 * @exception Exception
	 */
    void updateLcn(LcnVO vo) throws Exception;
    
    /**
	 * 라이센스를 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 LcnVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteLcn(LcnVO vo) throws Exception;
    
    /**
     * 라이센스를 멀티 삭제 한다. (화면에 조회된 라이센스 목록 정보를 데이터베이스에서 삭제)
     * @param checkedLcnMngForDel
     */
    void deleteLcnMngList(LcnVO lcnVO) throws Exception;
}
