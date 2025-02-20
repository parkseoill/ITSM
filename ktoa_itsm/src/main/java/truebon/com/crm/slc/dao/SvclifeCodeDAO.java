package truebon.com.crm.slc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import truebon.com.crm.slc.model.SvclifeCodeMngVO;

/**
 * SvclifeCode DAO 클래스 정의
 * @author 이미현
 * @since 2023.11.07
 * @version 1.0
 * @see
 *  
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *  수정일                      수정자                   수정내용
 *  ----------   --------   ---------------------------
 *  2023.11.07   이미현                   최초 생성
 *
 * </pre>
 */
@Repository("SvclifeCodeDAO")
public class SvclifeCodeDAO extends EgovComAbstractDAO {
	
	
	/**
	 * TB_DUR_YEAR 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return TB_DUR_YEAR 목록
	 * @exception Exception
	 */
	public List<SvclifeCodeMngVO> selectSvclifeCodeList(SvclifeCodeMngVO searchVO) throws Exception{
		return selectList("SvclifeCodeMapper.selectSvclifeCodeList", searchVO);
	}
	
	/**
	 * TB_DUR_YEAR 총 갯수 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return TB_DUR_YEAR 총 갯수
	 * @exception 
	 */
	public int selectSvclifeCodeListTotCnt(SvclifeCodeMngVO searchVO) {
		return (Integer)selectOne("SvclifeCodeMapper.selectSvclifeCodeListTotCnt", searchVO);
	}
	
	/**
	 * TB_DUR_YEAR을 조회한다.
	 * @param vo - 조회할 정보가 담긴 VO
	 * @return 조회한 TB_DUR_YEAR 
	 * @exception Exception
	 */
	public SvclifeCodeMngVO selectSvclifeCode(SvclifeCodeMngVO vo) throws Exception {
		return (SvclifeCodeMngVO)selectOne("SvclifeCodeMapper.selectSvclifeCode", vo);
	}
	
	
	/**
	 * TB_DUR_YEAR을 수정한다.
	 * @param vo - 수정할 정보가 담긴  SvclifeCodeMngVO
	 * @return void형
	 * @exception Exception
	 */
	public void updateSvclifeCode(SvclifeCodeMngVO vo) throws Exception {
		update("SvclifeCodeMapper.updateSvclifeCode", vo);
	}
	
	
	/**
	 * TB_DUR_YEAR을 등록한다.
	 * @param vo - 등록할 정보가 담긴  SvclifeCodeMngVO
	 * @return void형
	 * @exception Exception
	 */
	public void registSvclifeCode(SvclifeCodeMngVO vo) {
		insert("SvclifeCodeMapper.registSvclifeCode", vo);
	}

}
