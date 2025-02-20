package truebon.com.crm.swm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import truebon.com.crm.swm.dao.SwMngDAO;
import truebon.com.crm.swm.model.SwMng;
import truebon.com.crm.swm.model.SwMngVO;
import truebon.com.crm.swm.service.SwMngService;


/**
 * SW전산자원 관리를 위한 서비스 구현 클래스
 * @author 이정하
 * @since 2023.09.20
 * @version 1.0
 * @see
 *  
* <pre>
 * << 개정이력(Modification Information) >>
 *   
 *  수정일               수정자            수정내용
 *  ----------   --------   ---------------------------
 *  2023.09.20       이정하          	 최초 생성
 *
 * </pre>
 */

@Service("SwMngService")
public class SwMngServiceImpl extends EgovAbstractServiceImpl implements
		SwMngService {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(SwMngServiceImpl.class);

    @Resource(name="SwMngDAO")
    private SwMngDAO swMngDAO;

	/**
	 * tb_sw_asset을 등록한다.
	 * @param vo - 등록할 정보가 담긴 SwAsset
	 * @exception Exception
	 */
    public void insertSwAsset(SwMng vo) throws Exception {
	
		// 로그인 객체 선언
    	LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
    	vo.setRegstrId(user.getId());
    	vo.setAmndrId(user.getId());

    	swMngDAO.insertSwAsset(vo);
    }

    /**
	 * tb_sw_asset을 수정한다.
	 * @param vo - 수정할 정보가 담긴 SwAssetVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateSwAsset(SwMng vo) throws Exception {
    	// 로그인 객체 선언
    	LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
    	vo.setAmndrId(user.getId());
    	swMngDAO.updateSwAsset(vo);
    }
    
    /**
	 * tb_sw_asset을 수정한다.(2)
	 * @param vo - 수정할 정보가 담긴 SwAssetVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateSwAssetTargt(SwMng vo) throws Exception {
    	// 로그인 객체 선언
    	LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
    	vo.setAmndrId(user.getId());

    	swMngDAO.updateSwAssetTargt(vo);
    }

    /**
	 * tb_sw_asset을 조회한다.
	 * @param vo - 조회할 정보가 담긴 SwAssetVO
	 * @return 조회한 tb_sw_asset
	 * @exception Exception
	 */
    public SwMngVO selectSwAsset(SwMngVO vo) throws Exception {
    	SwMngVO resultVO = swMngDAO.selectSwAsset(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * tb_sw_asset 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return tb_sw_asset 목록
	 * @exception Exception
	 */
    public List<SwMngVO> selectSwAssetList(SwMngVO searchVO) throws Exception {
    	LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
//    	if(user.getAuthorCode().equals("ROLE_USER")) {
//			if(searchVO.getSearchName() == "") {
//				searchVO.setSearchName(user.getChrgrNo());
//			}
//		}
    	return swMngDAO.selectSwAssetList(searchVO);
    }
   
    /**
	 * tb_sw_asset 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return tb_sw_asset 총 갯수
	 * @exception
	 */
    public int selectSwAssetListTotCnt(SwMngVO searchVO) {
    	
		return swMngDAO.selectSwAssetListTotCnt(searchVO);
	}
    
    /**
	 * tb_sw_asset를 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 SwAssetVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteSwAsset(SwMngVO vo) throws Exception {
    	// 로그인 객체 선언
    	LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
    	vo.setAmndrId(user.getId());

    	swMngDAO.deleteSwAsset(vo);
    }
    
    /**
     * 화면에 조회된 SW전산자원 목록 정보를 데이터베이스에서 삭제
     * @param checkedValueForDel
     * @throws Exception
     */
    public void deleteSwAssetList(SwMngVO swMngVO) throws Exception {
    	SwMngVO vo = new SwMngVO();
		String [] delSw = swMngVO.getCheckedValueForDel().split(",");
		
		for (int i=0; i<delSw.length ; i++){
			//vo.setSrMngtNo(delSw[i]);
			vo.setSwAssetId(delSw[i]);
			deleteSwAsset(vo);
		}
	}
    
    /**
	 * tb_sw_asset 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return EgovMap 목록
	 * @exception Exception
	 */
    public List<EgovMap> selectSwAssetEgovMap(SwMngVO searchVO) throws Exception {
    	LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
//    	if(user.getAuthorCode().equals("ROLE_USER")) {
//			if(searchVO.getSearchName() == "") {
//				searchVO.setSearchName(user.getChrgrNo());
//			}
//		}
    	return swMngDAO.selectSwAssetEgovMap(searchVO);
    }

}
