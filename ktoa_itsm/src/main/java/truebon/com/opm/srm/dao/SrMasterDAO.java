package truebon.com.opm.srm.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import truebon.com.opm.srm.model.SrMaster;
import truebon.com.opm.srm.model.SrMasterVO;

@Repository("SrMasterDAO")
public class SrMasterDAO extends EgovComAbstractDAO {

	/**
	 * tb_sr_master을 등록한다.
	 * @param vo - 등록할 정보가 담긴 SrMasterVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void insertSrMaster(SrMaster vo) throws Exception {
        insert("SrMasterMapper.insertSrMaster", vo);
    }

    /**
	 * tb_sr_master을 수정한다.
	 * @param vo - 수정할 정보가 담긴 SrMasterVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateSrMaster(SrMaster vo) throws Exception {
        update("SrMasterMapper.updateSrMaster", vo);
    }
    
    /**
	 * tb_sr_master을 수정한다.(2)
	 * @param vo - 수정할 정보가 담긴 SrMaster
	 * @return void형
	 * @exception Exception
	 */
    public void updateSrMasterTargt(SrMaster vo) throws Exception {
        update("SrMasterMapper.updateSrMasterTargt", vo);
    }

    /**
	 * tb_sr_master을 조회한다.
	 * @param vo - 조회할 정보가 담긴 SrMaster
	 * @return 조회한 tb_sr_master
	 * @exception Exception
	 */
    public SrMasterVO selectSrMaster(SrMaster vo) throws Exception {
        return (SrMasterVO)selectOne("SrMasterMapper.selectSrMaster", vo);
    }

    /**
	 * tb_sr_master 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return tb_sr_master 목록
	 * @exception Exception
	 */
    public List<SrMasterVO> selectSrMasterList(SrMasterVO searchVO) throws Exception {
        return selectList("SrMasterMapper.selectSrMasterList", searchVO);
    }

    /**
	 * tb_sr_master 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return tb_sr_master 총 갯수
	 * @exception
	 */
    public int selectSrMasterListTotCnt(SrMasterVO searchVO) {
        return (Integer)selectOne("SrMasterMapper.selectSrMasterListTotCnt", searchVO);
    }
    
    /**
	 * tb_sr_master를 삭제한다.
	 * @param searchVO - 삭제할 정보가 담긴 SrMaster
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteSrMaster(SrMasterVO searchVO) throws Exception {
    	delete("SrMasterMapper.deleteSrMaster", searchVO);
    }
    
    /**
 	 * tb_sr_master 목록을 조회한다.
 	 * @param searchMap - 조회할 정보가 담긴 EgovMap
 	 * @return EgovMap 목록
 	 * @exception Exception
 	 */
     public List<EgovMap> selectSrMasterEgovMap(SrMasterVO searchVO) throws Exception {
         return selectList("SrMasterMapper.selectSrMasterEgovMap", searchVO);
     }
    
}
