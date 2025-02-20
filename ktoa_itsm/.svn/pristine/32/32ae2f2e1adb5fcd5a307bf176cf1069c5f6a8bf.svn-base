package truebon.com.crm.swm.service;
import java.util.List;

import egovframework.rte.psl.dataaccess.util.EgovMap;
import truebon.com.crm.swm.model.SwMng;
import truebon.com.crm.swm.model.SwMngVO;


public interface SwMngService {
	
	/**
	 * tb_sw_asset을 등록한다.
	 * @param vo - 등록할 정보가 담긴 SwAssetMngVO
	 * @exception Exception
	 */
    void insertSwAsset(SwMng vo) throws Exception;
    
    /**
	 * tb_sw_asset을 수정한다.
	 * @param vo - 수정할 정보가 담긴 SwAssetVO
	 * @return void형
	 * @exception Exception
	 */
    void updateSwAsset(SwMng vo) throws Exception;
    
    /**
	 * tb_sw_asset을 수정한다.(2)
	 * @param vo - 수정할 정보가 담긴 SwAssetVO
	 * @return void형
	 * @exception Exception
	 */
    void updateSwAssetTargt(SwMng vo) throws Exception;
    
    /**
	 * tb_sw_asset을 조회한다.
	 * @param vo - 조회할 정보가 담긴 SwAssetVO
	 * @return 조회한 tb_sw_asset
	 * @exception Exception
	 */
    SwMngVO selectSwAsset(SwMngVO vo) throws Exception;
    
    /**
	 * tb_sw_asset 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return tb_sw_asset 목록
	 * @exception Exception
	 */
    List<SwMngVO> selectSwAssetList(SwMngVO searchVO) throws Exception;
    
    /**
	 * tb_sw_asset 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return tb_sw_asset 총 갯수
	 * @exception
	 */
    int selectSwAssetListTotCnt(SwMngVO searchVO);
    
    
    /**
	 * tb_sw_asset를 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 SwAssetVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteSwAsset(SwMngVO searchVO) throws Exception;
    
    /**
     * 화면에 조회된 업무담당자 목록 정보를 데이터베이스에서 삭제
     * @param checkedValueForDel
     * @throws Exception
     */
    void deleteSwAssetList(SwMngVO searchVO) throws Exception;

    /**
  	 * tb_sw_asset 목록을 조회한다.
  	 * @param searchVO - 조회할 정보가 담긴 VO
  	 * @return EgovMap 목록
  	 * @exception Exception
  	 */
      List<EgovMap> selectSwAssetEgovMap(SwMngVO searchVO) throws Exception;
}
