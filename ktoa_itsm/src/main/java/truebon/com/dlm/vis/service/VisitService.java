package truebon.com.dlm.vis.service;

import java.util.List;

import truebon.com.dlm.vis.model.Visit;
import truebon.com.dlm.vis.model.VisitVO;

public interface VisitService {
	
	/**
	 * tb_visit을 등록한다.
	 * @param vo - 등록할 정보가 담긴 VisitVO
	 * @exception Exception
	 */
    void insertVisit(Visit vo) throws Exception;
    
    /**
	 * tb_visit을 수정한다.
	 * @param vo - 수정할 정보가 담긴 VisitVO
	 * @return void형
	 * @exception Exception
	 */
    void updateVisit(Visit vo) throws Exception;
    
	/**
	 * 확인자를 수정한다.
	 * @param vo - 조회할 정보가 담긴 VisitVO
	 * @exception Exception
	 */
    void updateConfrSign(Visit vo) throws Exception;

    /**
	 * tb_visit을 조회한다.
	 * @param vo - 조회할 정보가 담긴 VisitVO
	 * @return 조회한 tb_visit
	 * @exception Exception
	 */
    VisitVO selectVisit(VisitVO vo) throws Exception;
    
    /**
	 * tb_visit 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return tb_visit 목록
	 * @exception Exception
	 */
    List<VisitVO> selectVisitList(VisitVO searchVO) throws Exception;
    
    /**
	 * tb_visit 퇴실 등록 한다.
	 * @param vo - 수정할 정보가 담긴 VisitVO
	 * @return void형
	 * @exception Exception
	 */
    int updateVisitExit(Visit vo) throws Exception;

    /**
	 * tb_visit 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return tb_visit 총 갯수
	 * @exception
	 */
    int selectVisitListTotCnt(VisitVO searchVO);
   
}
