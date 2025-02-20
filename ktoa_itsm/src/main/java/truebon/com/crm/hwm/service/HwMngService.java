package truebon.com.crm.hwm.service;

import java.util.List;

import egovframework.rte.psl.dataaccess.util.EgovMap;
import truebon.com.crm.hwm.model.HwMngVO;

/**
 * HW을 위한 서비스 인터페이스 클래스
 * @author 박서일
 * @since 2023.10.04
 * @version 1.0
 * @see
 *  
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *  수정일               수정자            수정내용
 *  ----------   --------   ---------------------------
 *  2023.10.04   박서일           최초 생성
 *  2023.10.13   이정하           appliHw 조회 추가
 *
 * </pre>
 */
public interface HwMngService {
	
    /**
	 * tb_hw_asset 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return tb_hw_asset 목록
	 * @exception Exception
	 */
    List<HwMngVO> selectHwMngList(HwMngVO searchVO) throws Exception;

    /**
	 * tb_hw_asset 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return tb_hw_asset 총 갯수
	 * @exception
	 */
	int selectHwMngListTotCnt(HwMngVO searchVO);
	
	/**
	 * tb_hw_asset을 조회한다.
	 * @param vo - 조회할 정보가 담긴 HwMngVO
	 * @return 조회한 tb_hw_asset
	 * @exception Exception
	 */
	HwMngVO selectHwMng(HwMngVO vo) throws Exception;
	
	 /**
	 * tb_hw_asset을 수정한다.
	 * @param vo - 수정할 정보가 담긴 HwMngVO
	 * @return void형
	 * @exception Exception
	 */
    void updateHwMng(HwMngVO vo) throws Exception;
    
    /**
   	 * tb_hw_asset 이력을 추가한다
   	 * @param vo - 등록할 정보가 담긴 HwMngVO
   	 * @return void형
   	 * @exception Exception
   	 */
    void registHwHstry(HwMngVO vo) throws Exception;
    
    /**
   	 * tb_hw_asset을 등록한다
   	 * @param vo - 등록할 정보가 담긴 HwMngVO
   	 * @return void형
   	 * @exception Exception
   	 */
    void registHwMng(HwMngVO vo) throws Exception;
    
    /**
	 * tb_hw_asset 이력 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return tb_hw_asset 목록
	 * @exception Exception
	 */
    List<HwMngVO> selectHwPopUpHstryList(HwMngVO searchVO) throws Exception;
    
	/**
	 * tb_hw_asset 이력 상세를 조회한다.
	 * @param vo - 조회할 정보가 담긴 HwMngVO
	 * @return 조회한 tb_hw_asset
	 * @exception Exception
	 */
	HwMngVO selectHwPopUpHstry(HwMngVO vo) throws Exception;
    
    /**
	 * tb_hw_asset POPUP 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return tb_hw_asset 목록
	 * @exception Exception
	 */
    List<HwMngVO> selectHwPopUpMngList(HwMngVO searchVO) throws Exception;

    /**
	 * tb_hw_asset POPUP 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return tb_hw_asset 총 갯수
	 * @exception
	 */
	int selectHwPopUpMngListTotCnt(HwMngVO searchVO);
	
    /**
	 * tb_appli_hw_asset 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return tb_hw_asset 목록
	 * @exception Exception
	 */
    List<HwMngVO> selectAppliHwMngList(HwMngVO searchVO) throws Exception;

    /**
	 * tb_appli_hw_asset 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return tb_hw_asset 총 갯수
	 * @exception
	 */
	int selectAppliHwMngListTotCnt(HwMngVO searchVO);
	
	 /**
     * HW 목록을 조회한다. (엑셀 다운로드)
     * @param searchVO - 조회할 정보가 담긴 VO
     * @return EgovMap 목록
     * @exception Exception
     */
	List<EgovMap> selectHwMngEgovMap(HwMngVO searchVO) throws Exception;

}
