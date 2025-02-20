package truebon.com.crm.hwm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import truebon.com.crm.hwm.dao.HwMngDAO;
import truebon.com.crm.hwm.model.HwMngVO;
import truebon.com.crm.hwm.service.HwMngService;
/**
 * HW을 위한 서비스 구현 클래스
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
@Service("HwMngService")
public class HwMngServiceImpl extends EgovAbstractServiceImpl implements HwMngService{
	
    /** ID Generation */
    @Resource(name="egovHwMngIdGnrService")
    private EgovIdGnrService egovHwMngIdGnrService;
    
	@Resource(name="HwMngDAO")
	private HwMngDAO hwMngDAO;
	   
	public List<HwMngVO> selectHwMngList(HwMngVO searchVO) throws Exception {
        return hwMngDAO.selectHwMngList(searchVO);
    }
	
	 /**
	 * tb_hw_asset 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return tb_hw_asset 총 갯수
	 * @exception
	 */
    public int selectHwMngListTotCnt(HwMngVO searchVO) {
		return hwMngDAO.selectHwMngListTotCnt(searchVO);
	}
    
    /**
	 * tb_hw_asset을 조회한다.
	 * @param vo - 조회할 정보가 담긴 HwMngVO
	 * @return 조회한 tb_hw_asset
	 * @exception Exception
	 */
    public HwMngVO selectHwMng(HwMngVO vo) throws Exception {
    	HwMngVO resultVO = hwMngDAO.selectHwMng(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }
    
    /**
	 * tb_hw_asset을 수정한다.
	 * @param vo - 수정할 정보가 담긴 HwMngVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateHwMng(HwMngVO vo) throws Exception {  
    	LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
    	vo.setAmndrId(user.getId());
    	hwMngDAO.updateHwMng(vo);
    }
	
    /**
	 * tb_hw_asset 이력을 추가한다 
	 * @param vo - 추가 할 정보가 담긴 HwMngVO
	 * @return void형
	 * @exception Exception
	 */
    public void registHwHstry(HwMngVO vo) throws Exception {  
    	hwMngDAO.registHwHstry(vo);
    }
	
    /**
	 * tb_hw_asset을 등록한다.
	 * @param vo - 등록할 정보가 담긴 HwMngVO
	 * @return void형
	 * @exception Exception
	 */	
    public void registHwMng(HwMngVO vo) throws Exception {  
    	String uniqId = egovHwMngIdGnrService.getNextStringId();
    	vo.setHwAssetId(uniqId);
    	
    	LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
    	vo.setRegstrId(user.getId());
    	vo.setAmndrId(user.getId());
    	
    	hwMngDAO.registHwMng(vo);
    }
	
	 /**
	 * tb_hw_asset 이력 목록 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return tb_hw_asset 
	 * @exception
	 */
	public List<HwMngVO> selectHwPopUpHstryList(HwMngVO searchVO) throws Exception {
		return hwMngDAO.selectHwPopUpHstryList(searchVO);
	}
   
    /**
	 * tb_hw_asset 이력 상세를 조회한다.
	 * @param vo - 조회할 정보가 담긴 HwMngVO
	 * @return 조회한 tb_hw_asset
	 * @exception Exception
	 */
    public HwMngVO selectHwPopUpHstry(HwMngVO vo) throws Exception {
    	HwMngVO resultVO = hwMngDAO.selectHwPopUpHstry(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }
	
	 /**
	 * tb_hw_asset POPUP 목록 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return tb_hw_asset 총 갯수
	 * @exception
	 */
    public List<HwMngVO> selectHwPopUpMngList(HwMngVO searchVO) throws Exception {
        return hwMngDAO.selectHwPopUpMngList(searchVO);
    }
    
	 /**
	 * tb_hw_asset POPUP 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return tb_hw_asset 총 갯수
	 * @exception
	 */
    public int selectHwPopUpMngListTotCnt(HwMngVO searchVO) {
		return hwMngDAO.selectHwPopUpMngListTotCnt(searchVO);
	}
    
    public List<HwMngVO> selectAppliHwMngList(HwMngVO searchVO) throws Exception {
        return hwMngDAO.selectAppliHwMngList(searchVO);
    }
	
	 /**
	 * tb_hw_asset 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return tb_hw_asset 총 갯수
	 * @exception
	 */
    public int selectAppliHwMngListTotCnt(HwMngVO searchVO) {
		return hwMngDAO.selectAppliHwMngListTotCnt(searchVO);
	}
    
    /**
     * HW 목록을 조회한다. (엑셀 다운로드)
     * @param searchVO - 조회할 정보가 담긴 VO
     * @return EgovMap 목록
     * @exception Exception
     */
	public List<EgovMap> selectHwMngEgovMap(HwMngVO searchVO) throws Exception{
	   return hwMngDAO.selectHwMngEgovMap(searchVO);
	}
   
}