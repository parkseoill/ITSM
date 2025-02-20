package truebon.com.opm.fix.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import truebon.com.opm.fix.dao.FixedInspMngDAO;
import truebon.com.opm.fix.model.FixedInspMngVO;
import truebon.com.opm.fix.service.FixedInspMngService;

@Service("FixedInspMngService")
public class FixedInspMngServiceImpl extends EgovAbstractServiceImpl implements FixedInspMngService {

	@Resource(name = "FixedInspMngDAO")
	private FixedInspMngDAO fixedInspMngDAO;

	/**
	 * tb_sw_asset 목록을 조회한다.
	 * 
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return tb_sw_asset 목록
	 * @exception Exception
	 */
	public List<FixedInspMngVO> selectFixedInspList(FixedInspMngVO searchVO) throws Exception {
		return fixedInspMngDAO.selectFixedInspList(searchVO);
	}

	/**
	 * 정기점검 목록의 총 갯수를 조회한다.
	 * 
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return 정기점검 목록의 총 갯수
	 * @exception Exception
	 */
	public int selectFixedInspListTotCnt(FixedInspMngVO searchVO) throws Exception {
		return fixedInspMngDAO.selectFixedInspListTotCnt(searchVO);
	}

	/**
	 * 정기점검을 멀티 삭제 한다.
	 * 
	 * @param checkedLcnMngForDel
	 */
	public void deleteFixedInspList(FixedInspMngVO searchVO) throws Exception {
		FixedInspMngVO vo = new FixedInspMngVO();
		String[] delFixedInsp = searchVO.getCheckedValueForDel().split(",");

		for (int i = 0; i < delFixedInsp.length; i++) {

			String[] delFixedInspArr = delFixedInsp[i].split(":");
			vo.setAssetId(delFixedInspArr[0]);
			vo.setFixedInspPlnMon(delFixedInspArr[1]);

			fixedInspMngDAO.deleteFixedInsp(vo);
		}
	}

	/**
	 * 정기점검을 조회한다.
	 * 
	 * @param vo - 조회할 정보가 담긴 FixedInspMngVO
	 * @return 조회한 정기점검
	 * @exception Exception
	 */
	public FixedInspMngVO selectFixedInsp(FixedInspMngVO vo) throws Exception {
		FixedInspMngVO resultVO = fixedInspMngDAO.selectFixedInsp(vo);
		if (resultVO == null)
			throw processException("info.nodata.msg");
		return resultVO;
	}

	/**
	 * 정기점검을 수정한다.
	 * 
	 * @param vo - 수정할 정보가 담긴 FixedInspMngVO
	 * @return void형
	 * @exception Exception
	 */
	public void updateFixedInsp(FixedInspMngVO vo) throws Exception {
		// 로그인 객체 선언
		LoginVO user = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
		vo.setAmndrId(user.getId());

		fixedInspMngDAO.updateFixedInsp(vo);
	}

	/**
	 * 정기점검을 삭제한다.
	 * 
	 * @param vo - 삭제할 정보가 담긴 FixedInspMngVO
	 * @return void형
	 * @exception Exception
	 */
	public void deleteFixedInsp(FixedInspMngVO vo) throws Exception {
		// 로그인 객체 선언
		LoginVO user = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
		vo.setAmndrId(user.getId());

		fixedInspMngDAO.deleteFixedInsp(vo);
	}

	/**
	 * 정기점검을 멀티 수정 한다.
	 * 
	 * @param checkedLcnMngForDel
	 */
	public void fixedInspMltplUpdt(FixedInspMngVO searchVO) throws Exception {

		// 로그인 객체 선언
		LoginVO user = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
		searchVO.setAmndrId(user.getId());

		String[] updtFixedInsp = searchVO.getCheckedValueForDel().split(",");

		for (int i = 0; i < updtFixedInsp.length; i++) {

			String[] delFixedInspArr = updtFixedInsp[i].split(":");
			searchVO.setAssetId(delFixedInspArr[0]);
			searchVO.setFixedInspPlnMon(delFixedInspArr[1]);

			fixedInspMngDAO.updateFixedInsp(searchVO);
		}
	}

	/**
	 * 회사 목록을 조회한다.
	 * 
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return 회사 목록
	 * @exception Exception
	 */
	public List<FixedInspMngVO> selectCmpnyList(FixedInspMngVO searchVO) throws Exception {
		return fixedInspMngDAO.selectCmpnyList(searchVO);
	}
	
	/**
	 * 전체 회사 목록을 조회한다.
	 * 
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return 회사 목록
	 * @exception Exception
	 */
	public List<FixedInspMngVO> selectAllCmpnyList(FixedInspMngVO searchVO) throws Exception {
		return fixedInspMngDAO.selectAllCmpnyList(searchVO);
	}

	/**
	 * tb_sw_asset 현황을 조회한다.
	 * 
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return tb_sw_asset 목록
	 * @exception Exception
	 */
	public List<Map<String, Object>> selectFixedInspStus(FixedInspMngVO searchVO) throws Exception {
		return fixedInspMngDAO.selectFixedInspStus(searchVO);
	}

	/**
	 * 정기점검 계획을 생성한다
	 * 
	 * @param searchVO - 생성할 정보가 담긴 VO
	 * @exception Exception
	 */
	public void insertFixedInspStus(FixedInspMngVO searchVO) throws Exception {
		LoginVO user = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
		searchVO.setAmndrId(user.getId());
		searchVO.setRegstrId(user.getId());
		fixedInspMngDAO.insertFixedInspStus(searchVO);
	}
	
    /**
  	 * 정기점검 목록을 조회한다. (엑셀 다운로드)
  	 * @param searchVO - 조회할 정보가 담긴 VO
  	 * @return EgovMap 목록
  	 * @exception Exception
  	 */
	public List<EgovMap> selectFixedInspMngEgovMap(FixedInspMngVO searchVO) throws Exception{
    	return fixedInspMngDAO.selectFixedInspMngEgovMap(searchVO);
    }
}
