package egovframework.com.cmm.dsb.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.dsb.dao.DashBoardDAO;
import egovframework.com.cmm.dsb.model.DashBoardOffdayVO;
import egovframework.com.cmm.dsb.model.DashBoardVO;
import egovframework.com.cmm.dsb.service.DashBoardService;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

/**
 * 대시보드를 위한 서비스 구현 클래스
 * @author 최호용
 * @since 2023.06.16
 * @version 1.0
 * @see
 *  
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *	수정일			수정자 		수정내용
 *  ----------	   ------      -----------------------
 *	2023.06.16		최호용		최초 생성
 *
 * </pre>
 */

@Service("DashBoardService")
public class DashBoardServiceImpl extends EgovAbstractServiceImpl implements DashBoardService {

	@Resource(name = "DashBoardDAO")
	private DashBoardDAO dashBoardDAO;

	
	/**
	 * 출퇴근 기록부 확인
	 * 
	 * @param vo - 등록할 정보가 담긴 DashBoardVO
	 * @exception Exception
	 */
	public List<DashBoardVO> dlalzList(DashBoardVO vo) throws Exception {		
	     LoginVO user = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
	     vo.setChrgrNm(user.getId());
	     LocalDate currentdate = LocalDate.now();
	     String date =(currentdate.format(DateTimeFormatter.ofPattern("yyyy-MM")));
	     vo.setDlalzDate(date);
		 return dashBoardDAO.dlalzList(vo);
	}

	
	/**
	 * tb_sr_master를 조회한다.
	 * 
	 * @param vo - 등록할 정보가 담긴 DashBoardVO
	 * @exception Exception
	 */
	public DashBoardVO serviceRequestProcessingStatistics(DashBoardVO vo) throws Exception {		
		DashBoardVO srpsVO = dashBoardDAO.serviceRequestProcessingStatistics(vo);
//		selectUserNo(srpsVO);
//		srpsVO.setUcn("0001");		
		return srpsVO;
	}
	
	public List<DashBoardOffdayVO> serviceOffday(DashBoardOffdayVO dashBoardOffdayVO) throws Exception {
		List<DashBoardOffdayVO> aaa = dashBoardDAO.serviceOffday(dashBoardOffdayVO);
		//System.out.println("serviceImpl" + aaa.getFirst_date());
		return aaa;
	}

//	public void selectUserNo(DashBoardVO dashBoardVO) throws Exception {
//		LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();	
//		System.out.println(user.getChrgrNo());
//		dashBoardVO.setUcn(user.getChrgrNo());					
//	}

}