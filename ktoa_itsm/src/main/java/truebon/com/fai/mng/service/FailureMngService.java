package truebon.com.fai.mng.service;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.util.EgovMap;
import truebon.com.fai.mng.model.FailureMngVO;

public interface FailureMngService {

	/**
	 * 장애 목록을 조회한다.
	 * 
	 * @param vo - 조회할 정보가 담긴 FailureMngVO
	 * @return 조회한 라이센스 목록
	 * @exception Exception
	 */
	List<FailureMngVO> selectFailureMngList(FailureMngVO searchVO) throws Exception;

	/**
	 * 장애 총 갯수를 조회한다. @param searchVO - 조회할 정보가 담긴 VO @return 장애 총 갯수 @exception
	 */
	int selectFailureListTotCnt(FailureMngVO searchVO);

	/**
	 * TB_FAIL을 조회한다.
	 * 
	 * @param vo - 조회할 정보가 담긴 FailureMngVO
	 * @return 조회한 TB_FAIL
	 * @exception Exception
	 */
	FailureMngVO selectFailureMng(FailureMngVO failureMngVO) throws Exception;

	/**
	* 장애 조치기한 가이드를 조회한다.
	* 
	* @exception Exception
	*/
	List<Map<String, Object>> selectMngmntPeriodGuide() throws Exception;
	   
    /**
     * 장애 등급을 조회한다.
     * 
     * @param vo - 조회할 정보가 담긴 FailureMngVO
     * @exception Exception
     */
    FailureMngVO selectFailureGrd(FailureMngVO failureMngVO) throws Exception;

	   
	/**
	 * TB_FAIL을 수정한다.
	 * 
	 * @param vo - 수정할 정보가 담긴 FailureMngVO
	 * @return void형
	 * @exception Exception
	 */
	void updateFailureMng(FailureMngVO failureMngVO) throws Exception;

	/**
	 * TB_FAIL을 등록한다.
	 * 
	 * @param vo - 등록할 정보가 담긴 FailureMngVO
	 * @return void형
	 * @exception Exception
	 */
	void registFailureMng(FailureMngVO failureMngVO) throws Exception;

	/**
	 * 장애 목록을 조회한다. (엑셀 다운로드)
	 * 
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return EgovMap 목록
	 * @exception Exception
	 */
	List<EgovMap> selectFailureEgovMap(FailureMngVO searchVO) throws Exception;
}
