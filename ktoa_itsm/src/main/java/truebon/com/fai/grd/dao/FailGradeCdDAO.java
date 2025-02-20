package truebon.com.fai.grd.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import truebon.com.fai.grd.model.FailGrade;
import truebon.com.fai.grd.model.FailGradeVO;
import truebon.com.opm.biz.model.BizSytmVO;
import truebon.com.opm.com.model.ComnCdNewVO;

@Repository("FailGradeCdDAO")
public class FailGradeCdDAO extends EgovComAbstractDAO {
	/**
	 * tb_fail_grade 목록을 조회한다.
	 * 
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return tb_fail_grade 목록
	 * @exception Exception
	 */
	public List<FailGrade> selectFailGradeList(FailGrade vo) throws Exception {
		return selectList("FailGradeMapper.selectFailGradeList", vo);
	}
	
	/**
	 * tb_fail_grade 총 개수를 조회한다.
	 * 
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return tb_fail_grade 목록 개수
	 * @exception Exception
	 */
	public int selectFailGradeListTotCnt(FailGrade vo) throws Exception {
		return (Integer)selectOne("FailGradeMapper.selectFailGradeListTotCnt", vo);
	}
	
	/**
	  * 장애등급을 상세항목을 조회한다.
	  * @param FailGrade
	  * @return FailGrade
	  *  @throws Exception
	  */
	public FailGradeVO selectFailGrade(FailGrade searchVO) throws Exception {
		return (FailGradeVO)selectOne("FailGradeMapper.selectFailGrade", searchVO);
	}
	
    /**
   	 * 장애등급을 수정한다.
   	 * @param vo - 수정할 정보가 담긴 FailGrade
   	 * @return void형
   	 * @exception Exception
   	 */
	public void updateFailGrade(FailGrade vo) throws Exception {
		update("FailGradeMapper.updateFailGrade", vo);
	}
	/**
	 * 공통코드NEW grade 목록을 조회한다.
	 */
  
    public List<ComnCdNewVO> selectGradeList(ComnCdNewVO vo) throws Exception {
        return selectList("FailGradeMapper.selectGradeList", vo);
    }
    
   
}
