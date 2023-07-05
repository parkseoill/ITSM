package truebon.com.dlm.cod.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import truebon.com.dlm.cod.model.ComnDate;
import truebon.com.dlm.cod.model.ComnDateVO;

/**
 * 공통일자에 대한 DAO 클래스를 정의한다
 * @author 이유리
 * @since 2022.05.23
 * @version 1.0
 * @see
 *  
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *  수정일               수정자            수정내용
 *  ----------   --------   ---------------------------
 *  2022.05.23   이유리           최초 생성
 *
 * </pre>
 */

@Repository("ComnDateDAO")
public class ComnDateDAO extends EgovComAbstractDAO {
	
    /**
	 * tb_comn_date를 조회한다.
	 * @param vo - 조회할 정보가 담긴 ComnDateVO
	 * @return 조회한 tb_comn_date
	 * @exception Exception
	 */
    public ComnDateVO selectComnDate(ComnDate vo) throws Exception {
        return (ComnDateVO)selectOne("ComnDateMapper.selectComnDate", vo);
    }

    /**
	 * tb_comn_date 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return tb_comn_date 목록
	 * @exception Exception
	 */
    public List<ComnDateVO> selectComnDateList(ComnDateVO searchVO) throws Exception {
        return selectList("ComnDateMapper.selectComnDateList", searchVO);
    }

    /**
	 * tb_comn_date 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return tb_comn_date 총 갯수
	 * @exception
	 */
    public int selectComnDateListTotCnt(ComnDateVO searchVO) {
        return (Integer)selectOne("ComnDateMapper.selectComnDateListTotCnt", searchVO);
    }

	/**
	 * tb_comn_date를 등록한다.
	 * @param vo - 등록할 정보가 담긴 ComnDateVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void insertComnDate(ComnDate vo) throws Exception {
        insert("ComnDateMapper.insertComnDate", vo);
    }
    
    /**
	 * tb_comn_date를 수정한다.
	 * @param vo - 수정할 정보가 담긴 ComnDateVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateComnDate(ComnDate vo) throws Exception {
        update("ComnDateMapper.updateComnDate", vo);
    }
    
    /**
	 * 입력한 년도와 월의 날짜가 이미 추가되어 있는지 체크하여 등록가능여부 확인.
	 * @param checkDate 체크대상 년도와 월의 첫번째 날짜 
	 * @return int 등록가능여부(등록횟수)
	 */
    public int checkComnDate(String checkDate) {
    	return (Integer)selectOne("ComnDateMapper.checkComnDate", checkDate);
    }
    
    /**
   	 * tb_comn_date 목록을 조회한다.
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return tb_comn_date 목록
   	 * @exception Exception
   	 */
   public List<ComnDateVO> selectHdayCd(ComnDateVO searchVO) throws Exception {
       return selectList("ComnDateMapper.selectHdayCd", searchVO);
   }
}
