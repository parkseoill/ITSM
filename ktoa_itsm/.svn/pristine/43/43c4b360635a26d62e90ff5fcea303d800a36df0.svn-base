package truebon.com.crm.lcm.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import truebon.com.crm.lcm.model.LcnVO;

@Repository("LcnDAO")
public class LcnDAO extends EgovComAbstractDAO{

    /**
	 * 라이센스 목록을 조회한다.
	 * @param vo - 조회할 정보가 담긴 LcnVO
	 * @return 조회한 라이센스 목록
	 * @exception Exception
	 */
    public List<LcnVO> selectLcnList(LcnVO searchVO) throws Exception {
    	return selectList("LcnMapper.selectLcnList", searchVO);
    }
    
    /**
	 * 라이센스 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return 라이센스 총 갯수
	 * @exception
	 */
    public int selectLcnListTotCnt(LcnVO searchVO) {
        return (Integer)selectOne("LcnMapper.selectLcnListTotCnt", searchVO);
    }
    
	/**
	 * 라이센스를 등록한다.
	 * @param vo - 등록할 정보가 담긴 LcnVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void insertLcn(LcnVO vo) throws Exception {
    	insert("LcnMapper.insertLcn", vo);
    }
    
    /**
	 * 라이센스를 조회한다.
	 * @param vo - 조회할 정보가 담긴 LcnVO
	 * @return 조회한 라이센스
	 * @exception Exception
	 */
    public LcnVO selectLcn(LcnVO vo) throws Exception {
        return (LcnVO)selectOne("LcnMapper.selectLcn", vo);
    }
    
    /**
	 * 라이센스를 수정한다.
	 * @param vo - 수정할 정보가 담긴 LcnVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateLcn(LcnVO vo) throws Exception{
    	update("LcnMapper.updateLcn", vo);
    }
    
    /**
	 * 라이센스를 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 LcnVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteLcn(LcnVO vo) throws Exception{
    	delete("LcnMapper.deleteLcn", vo);
    }
}
