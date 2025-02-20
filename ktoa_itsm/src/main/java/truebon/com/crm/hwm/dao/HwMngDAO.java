package truebon.com.crm.hwm.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import truebon.com.crm.hwm.model.HwMngVO;
import truebon.com.opm.srm.model.SrMaster;
import truebon.com.opm.srm.model.SrMasterVO;

/**
 * HW DAO 클래스 정의
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

@Repository("HwMngDAO")
public class HwMngDAO extends EgovComAbstractDAO {

    /**
	 * tb_hw_asset 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return tb_hw_asset 목록
	 * @exception Exception
	 */
    public List<HwMngVO> selectHwMngList(HwMngVO searchVO) throws Exception {
        return selectList("HwMngMapper.selectHwMngList", searchVO);
    }

    /**
 	 * tb_hw_asset 총 갯수 조회한다.
 	 * @param searchVO - 조회할 정보가 담긴 VO
 	 * @return tb_hw_asset 총 갯수
 	 * @exception Exception
 	 */
	public int selectHwMngListTotCnt(HwMngVO searchVO) {
		 return (Integer)selectOne("HwMngMapper.selectHwMngListTotCnt", searchVO);
	}
	
	 /**
	 * tb_hw_asset을 조회한다.
	 * @param vo - 조회할 정보가 담긴 HwMngVO
	 * @return 조회한 tb_hw_asset
	 * @exception Exception
	 */
    public HwMngVO selectHwMng(HwMngVO vo) throws Exception {
        return (HwMngVO)selectOne("HwMngMapper.selectHwMng", vo);
    }
    
    /**
	 * tb_hw_asset을 수정한다.
	 * @param vo - 수정할 정보가 담긴 HwMngVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateHwMng(HwMngVO vo) throws Exception {
        update("HwMngMapper.updateHwMng", vo);
    }

    /**
	 * tb_hw_asset 이력을 추가한다
	 * @param vo - 등록할 정보가 담긴 HwMngVO
	 * @return void형
	 * @exception Exception
	 */
	public void registHwHstry(HwMngVO vo) {
		insert("HwMngMapper.registHwHstry", vo);
	}
	

    /**
	 * tb_hw_asset을 등록한다
	 * @param vo - 등록할 정보가 담긴 HwMngVO
	 * @return void형
	 * @exception Exception
	 */
	public void registHwMng(HwMngVO vo) {
		insert("HwMngMapper.registHwMng", vo);
		
	}
	
	/**
	 * tb_hw_asset 이력 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return tb_hw_asset 목록
	 * @exception Exception
	 */
    public List<HwMngVO> selectHwPopUpHstryList(HwMngVO searchVO) throws Exception {
        return selectList("HwMngMapper.selectHwPopUpHstryList", searchVO);
    }

    /**
 	 * tb_hw_asset 이력 목록 상세를 조회한다.
 	 * @param searchVO - 조회할 정보가 담긴 VO
 	 * @return tb_hw_asset 총 갯수
 	 * @exception Exception
 	 */
	public HwMngVO selectHwPopUpHstry(HwMngVO searchVO) {
		 return selectOne("HwMngMapper.selectHwPopUpHstry", searchVO);
	}
	
	/**
	 * tb_hw_asset POPUP 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return tb_hw_asset 목록
	 * @exception Exception
	 */
    public List<HwMngVO> selectHwPopUpMngList(HwMngVO searchVO) throws Exception {
        return selectList("HwMngMapper.selectHwPopUpMngList", searchVO);
    }

    /**
 	 * tb_hw_asset POPUP 총 갯수 조회한다.
 	 * @param searchVO - 조회할 정보가 담긴 VO
 	 * @return tb_hw_asset 총 갯수
 	 * @exception Exception
 	 */
	public int selectHwPopUpMngListTotCnt(HwMngVO searchVO) {
		 return (Integer)selectOne("HwMngMapper.selectHwPopUpMngListTotCnt", searchVO);
	}
	
	/**
	 * tb_appli_hw_asset 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return tb_hw_asset 목록
	 * @exception Exception
	 */
    public List<HwMngVO> selectAppliHwMngList(HwMngVO searchVO) throws Exception {
        return selectList("HwMngMapper.selectAppliHwMngList", searchVO);
    }

    /**
 	 * tb_appli_hw_asset 총 갯수 조회한다.
 	 * @param searchVO - 조회할 정보가 담긴 VO
 	 * @return tb_hw_asset 총 갯수
 	 * @exception Exception
 	 */
	public int selectAppliHwMngListTotCnt(HwMngVO searchVO) {
		 return (Integer)selectOne("HwMngMapper.selectAppliHwMngListTotCnt", searchVO);
	}
	
    /**
     * HW 목록을 조회한다. (엑셀 다운로드)
     * @param searchVO - 조회할 정보가 담긴 VO
     * @return EgovMap 목록
     * @exception Exception
     */
	public List<EgovMap> selectHwMngEgovMap(HwMngVO searchVO) throws Exception{
	   return selectList("HwMngMapper.selectHwMngEgovMap", searchVO);
	}

    
}
