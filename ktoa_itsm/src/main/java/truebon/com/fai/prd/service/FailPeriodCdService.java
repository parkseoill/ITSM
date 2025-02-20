package truebon.com.fai.prd.service;
import java.util.List;

import truebon.com.fai.prd.model.FailPeriod;
import truebon.com.fai.prd.model.FailPeriodVO;
import truebon.com.opm.biz.model.BizSytmVO;

public interface FailPeriodCdService {
	/**
	 * tb_fail_period 목록을 조회한다.
	 * 
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return tb_fail_period 목록
	 * @exception Exception
	 */
	List<FailPeriod> selectFailPeriodList(FailPeriodVO vo) throws Exception;
	
	/**
	 * tb_fail_period 총 개수를 조회한다.
	 * 
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return tb_fail_period 목록 개수
	 * @exception Exception
	 */
	int selectFailPeriodListTotCnt(FailPeriodVO vo) throws Exception;
	
	/**
	  * 장애조치기한을 상세항목을 조회한다.
	  * @param FailPeriod
	  * @return FailPeriod
	  *  @throws Exception
	  */
	FailPeriodVO selectFailPeriod(FailPeriodVO searchVO) throws Exception;
	
    /**
   	 * 장애조치기한을 수정한다.
   	 * @param failGradeVO - 수정할 정보가 담긴 FailPeriod
   	 * @return void형
   	 * @exception Exception
   	 */
	void updateFailPeriod(FailPeriodVO failPeriodVO) throws Exception;
	
	/**
   	 * 장애조치기한을 추가한다.
   	 * @param vo - 추가할 정보가 담긴 FailPeriod
   	 * @return void형
   	 * @exception Exception
   	 */
	void insertFailPeriod(FailPeriodVO vo) throws Exception;
	
	/**
	 * tb_biz_sytm 장애등급 없는 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return tb_biz_sytm 목록
	 * @exception Exception
	 */
    List<BizSytmVO> selectFailBizSytmList(BizSytmVO searchVO) throws Exception;


}
