package truebon.com.dlm.cod.service;

import java.util.List;

import org.springframework.stereotype.Service;

import truebon.com.dlm.cod.model.ComnDate;
import truebon.com.dlm.cod.model.ComnDateVO;

/**
 * 공통일자를 위한 서비스 인터페이스 클래스
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

public interface ComnDateService {
	
    /**
	 * tb_comn_date를 조회한다.
	 * @param vo - 조회할 정보가 담긴 ComnDateVO
	 * @return 조회한 tb_comn_date
	 * @exception Exception
	 */
	ComnDateVO selectComnDate(ComnDateVO vo) throws Exception;
    
    /**
	 * tb_comn_date 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return tb_comn_date 목록
	 * @exception Exception
	 */
    List<ComnDateVO> selectComnDateList(ComnDateVO searchVO) throws Exception;
    
    /**
	 * tb_comn_date 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return tb_comn_date 총 갯수
	 * @exception
	 */
    int selectComnDateListTotCnt(ComnDateVO searchVO);
    
	/**
	 * tb_comn_date를 등록한다.
	 * @param vo - 등록할 정보가 담긴 ComnDateVO
	 * @exception Exception
	 */
    void insertComnDate(ComnDate vo) throws Exception;
    
    /**
	 * tb_comn_date를 수정한다.
	 * @param vo - 수정할 정보가 담긴 ComnDateVO
	 * @return void형
	 * @exception Exception
	 */
    void updateComnDate(ComnDate vo) throws Exception;

    /**
	 * 입력한 날짜의 등록여부를 체크하여 등록가능여부를 확인
	 * @param checkDate 등록여부 확인대상 아이디
	 * @return 등록가능여부(날짜 등록회수 int)
	 * @throws Exception
	 */
    public int checkComnDate(String checkDate) throws Exception;

    /**
   	 * tb_comn_date 목록을 조회한다.
   	 * @param searchVO - 조회할 정보가 담긴 VO
   	 * @return tb_comn_date 목록
   	 * @exception Exception
   	 */
    List<ComnDateVO> selectHdayCd(ComnDateVO searchVO) throws Exception;
       
}
