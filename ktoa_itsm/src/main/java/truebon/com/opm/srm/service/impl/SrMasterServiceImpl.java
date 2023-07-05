package truebon.com.opm.srm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import truebon.com.opm.srm.dao.SrMasterDAO;
import truebon.com.opm.srm.model.SrMaster;
import truebon.com.opm.srm.model.SrMasterVO;
import truebon.com.opm.srm.service.SrMasterService;



/**
 * 서비스요청를 위한 서비스 구현 클래스
 * @author 김도아
 * @since 2022.07.28
 * @version 1.0
 * @see
 *  
* <pre>
 * << 개정이력(Modification Information) >>
 *   
 *  수정일               수정자            수정내용
 *  ----------   --------   ---------------------------
 *  2022.07.28       김도아          	 최초 생성
 *
 * </pre>
 */

@Service("SrMasterService")
public class SrMasterServiceImpl extends EgovAbstractServiceImpl implements
		SrMasterService {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(SrMasterServiceImpl.class);

    @Resource(name="SrMasterDAO")
    private SrMasterDAO srMasterDAO;

	/**
	 * tb_sr_master을 등록한다.
	 * @param vo - 등록할 정보가 담긴 SrMaster
	 * @exception Exception
	 */
    public void insertSrMaster(SrMaster vo) throws Exception {
	
		// 로그인 객체 선언
    	LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
    	vo.setRegstrId(user.getId());
    	vo.setAmndrId(user.getId());
    	
    	srMasterDAO.insertSrMaster(vo);
    }

    /**
	 * tb_sr_master을 수정한다.
	 * @param vo - 수정할 정보가 담긴 SrMaster
	 * @return void형
	 * @exception Exception
	 */
    public void updateSrMaster(SrMaster vo) throws Exception {
    	// 로그인 객체 선언
    	LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
    	vo.setAmndrId(user.getId());
    	
    	srMasterDAO.updateSrMaster(vo);
    }
    
    /**
	 * tb_sr_master을 수정한다.(2)
	 * @param vo - 수정할 정보가 담긴 SrMaster
	 * @return void형
	 * @exception Exception
	 */
    public void updateSrMasterTargt(SrMaster vo) throws Exception {
    	// 로그인 객체 선언
    	LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
    	vo.setAmndrId(user.getId());
    	
    	srMasterDAO.updateSrMasterTargt(vo);
    }

    /**
	 * tb_sr_master을 조회한다.
	 * @param vo - 조회할 정보가 담긴 SrMasterVO
	 * @return 조회한 tb_sr_master
	 * @exception Exception
	 */
    public SrMasterVO selectSrMaster(SrMasterVO vo) throws Exception {
    	SrMasterVO resultVO = srMasterDAO.selectSrMaster(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * tb_sr_master 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return tb_sr_master 목록
	 * @exception Exception
	 */
    public List<SrMasterVO> selectSrMasterList(SrMasterVO searchVO) throws Exception {
    	LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
    	if(user.getAuthorCode().equals("ROLE_USER")) {
			if(searchVO.getSearchName() == "") {
				searchVO.setSearchName(user.getChrgrNo());
			}
		}
    	return srMasterDAO.selectSrMasterList(searchVO);
    }
   
    /**
	 * tb_sr_master 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return tb_sr_master 총 갯수
	 * @exception
	 */
    public int selectSrMasterListTotCnt(SrMasterVO searchVO) {
    	LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
    	if(user.getAuthorCode().equals("ROLE_USER")) {
			if(searchVO.getSearchName() == "") {
				searchVO.setSearchName(user.getChrgrNo());
			}
		}
		return srMasterDAO.selectSrMasterListTotCnt(searchVO);
	}
    
    /**
	 * tb_sr_master를 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 SrMasterVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteSrMaster(SrMasterVO vo) throws Exception {
    	// 로그인 객체 선언
    	LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
    	vo.setAmndrId(user.getId());
    	
    	srMasterDAO.deleteSrMaster(vo);
    }
    
    /**
     * 화면에 조회된 업무담당자 목록 정보를 데이터베이스에서 삭제
     * @param checkedValueForDel
     * @throws Exception
     */
    public void deleteSrMasterList(SrMasterVO srMasterVO) throws Exception {
    	SrMasterVO vo = new SrMasterVO();
		String [] delSr = srMasterVO.getCheckedValueForDel().split(",");
		
		for (int i=0; i<delSr.length ; i++){
			vo.setSrMngtNo(delSr[i]);
			deleteSrMaster(vo);
		}
	}
    
    /**
	 * tb_sr_master 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return EgovMap 목록
	 * @exception Exception
	 */
    public List<EgovMap> selectSrMasterEgovMap(SrMasterVO searchVO) throws Exception {
    	LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
    	if(user.getAuthorCode().equals("ROLE_USER")) {
			if(searchVO.getSearchName() == "") {
				searchVO.setSearchName(user.getChrgrNo());
			}
		}
    	return srMasterDAO.selectSrMasterEgovMap(searchVO);
    }
}
