package truebon.com.fai.grd.service;

import java.util.List;

import truebon.com.fai.grd.model.FailGrade;
import truebon.com.fai.grd.model.FailGradeVO;
import truebon.com.opm.biz.model.BizSytmVO;
import truebon.com.opm.com.model.ComnCdNewVO;


public interface FailGradeCdService {
	
	/**
	 * tb_fail_grade 목록을 조회한다.
	 * 
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return tb_fail_grade 목록
	 * @exception Exception
	 */
	List<FailGrade> selectFailGradeList(FailGrade vo) throws Exception;
	
	/**
	 * tb_fail_grade 총 개수를 조회한다.
	 * 
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return tb_fail_grade 목록 개수
	 * @exception Exception
	 */
	int selectFailGradeListTotCnt(FailGrade vo) throws Exception;
	
	/**
	  * 장애등급을 상세항목을 조회한다.
	  * @param FailGrade
	  * @return FailGrade
	  *  @throws Exception
	  */
	FailGradeVO selectFailGrade(FailGrade searchVO) throws Exception;
	
    /**
   	 * 장애등급을 수정한다.
   	 * @param vo - 수정할 정보가 담긴 FailGrade
   	 * @return void형
   	 * @exception Exception
   	 */
	void updateFailGrade(FailGrade vo) throws Exception;

	/**
	 * tb_comn_cd_new grade 목록을 조회한다.
	 * 
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return tb_comn_cd_new 목록
	 * @exception Exception
	 */
	List<ComnCdNewVO> selectGradeList(ComnCdNewVO vo) throws Exception;

}
