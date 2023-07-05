package truebon.com.sys.chr.service;

import java.util.List;
import truebon.com.sys.chr.model.ChargerVO;
import truebon.com.sys.chr.model.Charger;

/**
 * 담당자를 위한 서비스 인터페이스 클래스
 * @author 이태신
 * @since 2022.05.04
 * @version 1.0
 * @see
 *  
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *  수정일               수정자            수정내용
 *  ----------   --------   ---------------------------
 *  2022.05.04   이태신           최초 생성
 *
 * </pre>
 */
public interface ChargerService {
	
	/**
	 * tb_charger을 등록한다.
	 * @param vo - 등록할 정보가 담긴 ChargerVO
	 * @exception Exception
	 */
    void insertCharger(Charger vo) throws Exception;
    
    /**
	 * tb_charger을 수정한다.
	 * @param vo - 수정할 정보가 담긴 ChargerVO
	 * @return void형
	 * @exception Exception
	 */
    void updateCharger(Charger vo) throws Exception;
    
    /**
	 * tb_charger을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 ChargerVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteCharger(Charger vo) throws Exception;
    
    /**
	 * tb_charger을 조회한다.
	 * @param vo - 조회할 정보가 담긴 ChargerVO
	 * @return 조회한 tb_charger
	 * @exception Exception
	 */
    ChargerVO selectCharger(ChargerVO vo) throws Exception;
    
    /**
	 * tb_charger 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return tb_charger 목록
	 * @exception Exception
	 */
    List<ChargerVO> selectChargerList(ChargerVO searchVO) throws Exception;
    
    /**
	 * tb_charger 협력업체 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return tb_charger 목록
	 * @exception Exception
	 */
    List<ChargerVO> selectChargerVisitList(ChargerVO searchVO) throws Exception;
    
    /**
	 * tb_charger 협력업체 목록 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return tb_charger 총 갯수
	 * @exception
	 */
    int ChargerListPopTotCnt(ChargerVO searchVO);
    
    /**
	 * tb_charger 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return tb_charger 총 갯수
	 * @exception
	 */
    int selectChargerListTotCnt(ChargerVO searchVO);
    
    /**
     * 화면에 조회된 담당자 목록 정보를 데이터베이스에서 삭제
     * @param checkedChargerMngForDel
     */
    void deleteChargerMngList(ChargerVO chargerVO) throws Exception;
    
    /**
	 * tb_charger 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return tb_charger 목록
	 * @exception Exception
	 */
    List<ChargerVO> selectNameList(ChargerVO searchVO) throws Exception;
      
    /**
	 * tb_charger ktoa,위탁운영자 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return tb_charger 목록
	 * @exception Exception
	 */
    List<ChargerVO> selectChargerSrList(ChargerVO searchVO) throws Exception;
    
    /**
	 * tb_charger ktoa,위탁운영자 목록 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return tb_charger 총 갯수
	 * @exception
	 */
    int ChargerSrListPopTotCnt(ChargerVO searchVO);
    
    /**
	 * tb_charger 등록하려는 방문자 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return tb_charger 총 갯수
	 * @exception
	 */
    int CheckVisitorsNmCmpny(ChargerVO searchVO);
    
    /**
	 * tb_charger sr요청부서목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return tb_charger 목록
	 * @exception Exception
	 */
    List<ChargerVO> selectSrDeptList(ChargerVO searchVO) throws Exception;
}
