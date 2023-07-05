package truebon.com.opm.srm.service;

import java.util.List;

import egovframework.rte.psl.dataaccess.util.EgovMap;
import truebon.com.opm.srm.model.SrMaster;
import truebon.com.opm.srm.model.SrMasterVO;

public interface SrMasterService {
	
	/**
	 * tb_sr_master을 등록한다.
	 * @param vo - 등록할 정보가 담긴 SrMasterVO
	 * @exception Exception
	 */
    void insertSrMaster(SrMaster vo) throws Exception;
    
    /**
	 * tb_sr_master을 수정한다.
	 * @param vo - 수정할 정보가 담긴 SrMaster
	 * @return void형
	 * @exception Exception
	 */
    void updateSrMaster(SrMaster vo) throws Exception;
    
    /**
	 * tb_sr_master을 수정한다.(2)
	 * @param vo - 수정할 정보가 담긴 SrMaster
	 * @return void형
	 * @exception Exception
	 */
    void updateSrMasterTargt(SrMaster vo) throws Exception;
    
    /**
	 * tb_sr_master을 조회한다.
	 * @param vo - 조회할 정보가 담긴 SrMasterVO
	 * @return 조회한 tb_sr_master
	 * @exception Exception
	 */
    SrMasterVO selectSrMaster(SrMasterVO vo) throws Exception;
    
    /**
	 * tb_sr_master 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return tb_sr_master 목록
	 * @exception Exception
	 */
    List<SrMasterVO> selectSrMasterList(SrMasterVO searchVO) throws Exception;
    
    /**
	 * tb_sr_master 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return tb_sr_master 총 갯수
	 * @exception
	 */
    int selectSrMasterListTotCnt(SrMasterVO searchVO);
    
    
    /**
	 * tb_sr_master를 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 SrMasterVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteSrMaster(SrMasterVO searchVO) throws Exception;
    
    /**
     * 화면에 조회된 업무담당자 목록 정보를 데이터베이스에서 삭제
     * @param checkedValueForDel
     * @throws Exception
     */
    void deleteSrMasterList(SrMasterVO searchVO) throws Exception;

    /**
  	 * tb_sr_master 목록을 조회한다.
  	 * @param searchVO - 조회할 정보가 담긴 VO
  	 * @return EgovMap 목록
  	 * @exception Exception
  	 */
      List<EgovMap> selectSrMasterEgovMap(SrMasterVO searchVO) throws Exception;
}
