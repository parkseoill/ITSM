package truebon.com.opm.biz.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import truebon.com.opm.biz.model.BizSytm;
import truebon.com.opm.biz.model.BizSytmVO;

/**
 * 업무시스템에 대한 DAO 클래스를 정의한다
 * @author 이유리
 * @since 2022.07.26
 * @version 1.0
 * @see
 *  
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *  수정일               수정자            수정내용
 *  ----------   --------   ---------------------------
 *  2022.07.26   이유리           최초 생성
 *
 * </pre>
 */

@Repository("BizSytmDAO")
public class BizSytmDAO extends EgovComAbstractDAO {
	
	/**
	 * tb_biz_sytm 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return tb_biz_sytm 목록
	 * @exception Exception
	 */
    public List<BizSytmVO> selectBizSytmList(BizSytmVO searchVO) throws Exception {
        return selectList("BizSytmMapper.selectBizSytmList", searchVO);
    }

    /**
	 * tb_biz_sytm 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return tb_biz_sytm 총 갯수
	 * @exception
	 */
    public int selectBizSytmListTotCnt(BizSytmVO searchVO) {
        return (Integer)selectOne("BizSytmMapper.selectBizSytmListTotCnt", searchVO);
    }
    
	/**
	 * tb_biz_sytm을 등록한다.
	 * @param vo - 등록할 정보가 담긴 BizSytmVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void insertBizSytm(BizSytm vo) throws Exception {
        insert("BizSytmMapper.insertBizSytm", vo);
    }
    
    /**
   	 * tb_biz_sytm을 수정한다.
   	 * @param vo - 수정할 정보가 담긴 BizSytmVO
   	 * @return void형
   	 * @exception Exception
   	 */
	 public void updateBizSytm(BizSytm vo) throws Exception {
	     update("BizSytmMapper.updateBizSytm", vo);
	 }
       
	/**
	 * tb_biz_sytm을 조회한다.
	 * @param vo - 조회할 정보가 담긴 BizSytmVO
	 * @return 조회한 tb_biz_sytm
	 * @exception Exception
	 */
	public BizSytmVO selectBizSytm(BizSytm vo) throws Exception {
	    return (BizSytmVO)selectOne("BizSytmMapper.selectBizSytm", vo);
	}
	
	/**
	 * tb_biz_sytm 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return tb_biz_sytm 목록
	 * @exception Exception
	 */
    public List<BizSytmVO> selectBizSytmNmList(BizSytmVO searchVO) throws Exception {
        return selectList("BizSytmMapper.selectBizSytmNmList", searchVO);
    }
}