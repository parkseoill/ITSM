package truebon.com.opm.biz.service;

import java.util.List;

import truebon.com.opm.biz.model.BizSytm;
import truebon.com.opm.biz.model.BizSytmVO;

/**
 * 업무시스템을 위한 서비스 인터페이스 클래스
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
public interface BizSytmService {
	
    /**
	 * tb_biz_sytm 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return tb_biz_sytm 목록
	 * @exception Exception
	 */
    List<BizSytmVO> selectBizSytmList(BizSytmVO searchVO) throws Exception;
    
    /**
	 * tb_biz_sytm 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return tb_biz_sytm 총 갯수
	 * @exception
	 */
    int selectBizSytmListTotCnt(BizSytmVO searchVO);
    
    /**
	 * tb_biz_sytm을 등록한다.
	 * @param vo - 등록할 정보가 담긴 BizSytmVO
	 * @exception Exception
	 */
    void insertBizSytm(BizSytm vo) throws Exception;
    
    /**
	 * tb_biz_sytm을 수정한다.
	 * @param vo - 수정할 정보가 담긴 BizSytmVO
	 * @return void형
	 * @exception Exception
	 */
    void updateBizSytm(BizSytm vo) throws Exception;
    
    /**
	 * tb_biz_sytm을 조회한다.
	 * @param vo - 조회할 정보가 담긴 BizSytmVO
	 * @return 조회한 tb_biz_sytm
	 * @exception Exception
	 */
    BizSytmVO selectBizSytm(BizSytmVO vo) throws Exception;
    
    /**
	 * tb_biz_sytm 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return tb_biz_sytm 목록
	 * @exception Exception
	 */
    List<BizSytmVO> selectBizSytmNmList(BizSytmVO searchVO) throws Exception;
}