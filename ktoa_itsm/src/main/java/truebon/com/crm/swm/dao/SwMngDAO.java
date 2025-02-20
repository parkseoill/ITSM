package truebon.com.crm.swm.dao;
import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import truebon.com.crm.swm.model.SwMng;
import truebon.com.crm.swm.model.SwMngVO;

@Repository("SwMngDAO")
public class SwMngDAO extends EgovComAbstractDAO {

	/**
	 * tb_sw_asset을 등록한다.
	 * @param vo - 등록할 정보가 담긴 SwAssetVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void insertSwAsset(SwMng vo) throws Exception {
        insert("SwMngMapper.insertSwAsset", vo);
    }

    /**
	 * tb_sw_asset을 수정한다.
	 * @param vo - 수정할 정보가 담긴 SwMngVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateSwAsset(SwMng vo) throws Exception {
        update("SwMngMapper.updateSwAsset", vo);
    }
    
    /**
	 * tb_sw_asset을 수정한다.(2)
	 * @param vo - 수정할 정보가 담긴 SwAsset
	 * @return void형
	 * @exception Exception
	 */
    public void updateSwAssetTargt(SwMng vo) throws Exception {
        update("SwMngMapper.updateSwAssetTargt", vo);
    }

    /**
	 * tb_sw_asset을 조회한다.
	 * @param vo - 조회할 정보가 담긴 SwAsset
	 * @return 조회한 tb_sw_asset
	 * @exception Exception
	 */
    public SwMngVO selectSwAsset(SwMng vo) throws Exception {
        return (SwMngVO)selectOne("SwMngMapper.selectSwAsset", vo);
    }

    /**
	 * tb_sw_asset 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return tb_sw_asset 목록
	 * @exception Exception
	 */
    public List<SwMngVO> selectSwAssetList(SwMngVO searchVO) throws Exception {
        return selectList("SwMngMapper.selectSwAssetList", searchVO);
    }

    /**
	 * tb_sw_asset 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return tb_sw_asset 총 갯수
	 * @exception
	 */
    public int selectSwAssetListTotCnt(SwMngVO searchVO) {
        return (Integer)selectOne("SwMngMapper.selectSwAssetListTotCnt", searchVO);
    }
    
    /**
	 * tb_sw_asset를 삭제한다.
	 * @param searchVO - 삭제할 정보가 담긴 SwAsset
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteSwAsset(SwMngVO searchVO) throws Exception {
    	delete("SwMngMapper.deleteSwAsset", searchVO);
    }
    
    /**
 	 * tb_sw_asset 목록을 조회한다.
 	 * @param searchMap - 조회할 정보가 담긴 EgovMap
 	 * @return EgovMap 목록
 	 * @exception Exception
 	 */
     public List<EgovMap> selectSwAssetEgovMap(SwMngVO searchVO) throws Exception {
         return selectList("SwMngMapper.selectSwAssetEgovMap", searchVO);
     }
    
}
