package truebon.com.dlm.vis.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import truebon.com.dlm.vis.model.Visit;
import truebon.com.dlm.vis.model.VisitVO;


@Repository("VisitDAO")
public class VisitDAO extends EgovComAbstractDAO {

	/**
	 * tb_visit을 등록한다.
	 * 
	 * @param vo - 등록할 정보가 담긴 VisitVO
	 * @return 등록 결과
	 * @exception Exception
	 */
	public void insertVisit(Visit vo) throws Exception {
		insert("VisitMapper.insertVisit", vo);
	}

	/**
	 * tb_visit을 수정한다.
	 * 
	 * @param vo - 수정할 정보가 담긴 VisitVO
	 * @return void형
	 * @exception Exception
	 */
	public void updateVisit(Visit vo) throws Exception {
		update("VisitMapper.updateVisit", vo);
	}
	
	/**
	 * 확인자를 수정한다.
	 * @param vo - 조회할 정보가 담긴 VisitVO
	 * @exception Exception
	 */
	public void updateConfrSign(Visit vo) throws Exception {
		update("VisitMapper.updateConfrSign", vo);
	}

	/**
	 * tb_visit을 퇴실 등록한다.
	 * 
	 * @param vo - 수정할 정보가 담긴 VisitVO
	 * @return void형
	 * @exception Exception
	 */
	public int updateVisitExit(Visit vo) throws Exception {
		return update("VisitMapper.updateVisitExit", vo);
	}

	/**
	 * tb_visit을 조회한다.
	 * 
	 * @param vo - 조회할 정보가 담긴 VisitVO
	 * @return 조회한 tb_visit
	 * @exception Exception
	 */
	public VisitVO selectVisit(Visit vo) throws Exception {
		return (VisitVO) selectOne("VisitMapper.selectVisit", vo);
	}

	/**
	 * tb_visit 목록을 조회한다.
	 * 
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return tb_visit 목록
	 * @exception Exception
	 */
	public List<VisitVO> selectVisitList(VisitVO searchVO) throws Exception {
		return selectList("VisitMapper.selectVisitList", searchVO);
	}


	/**
	 * tb_visit 총 갯수를 조회한다. 
	 * @param searchMap - 조회할 정보가 담긴 Map 
	 * @return tb_visit 총
	 * 갯수 @exception
	 */
	public int selectVisitListTotCnt(VisitVO searchVO) {
		return (Integer)selectOne("VisitMapper.selectVisitListTotCnt", searchVO);
	}

}
