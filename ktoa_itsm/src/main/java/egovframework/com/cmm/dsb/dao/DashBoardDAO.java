package egovframework.com.cmm.dsb.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.dsb.model.DashBoardOffdayVO;
import egovframework.com.cmm.dsb.model.DashBoardVO;
import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import egovframework.com.cmm.util.EgovUserDetailsHelper;

@Repository("DashBoardDAO")
public class DashBoardDAO extends EgovComAbstractDAO {

	/**
	 * tb_sr_master를 조회한다.
	 * @param vo - 조회할 정보가 담긴 DashBoardVO
	 * @return 조회한 tb_sr_master
	 * @exception Exception
	 */
	public DashBoardVO serviceRequestProcessingStatistics(DashBoardVO vo) throws Exception{						
		selectUserNo(vo);
//		vo.setUcn("0002");
		
		return selectOne("DashBoardMapper.serviceRequestProcessingStatistics", vo);
	}
	
	
	/**
	 * tb_dlalz 조회
	 * @param vo - 조회할 정보가 담긴 DashBoardVO
	 * @return 조회한 사람 이름
	 * @exception Exception
	 */
	public List<DashBoardVO> dlalzList(DashBoardVO vo) throws Exception{				
		return selectList("DashBoardMapper.dlalzList", vo);
	}
	
	/**
	 * LoginVO의 chrgrNo 정보를 담는다.
	 * @param dashBoardVO - ucn 정보를 담은 DashBoardVO
	 * @return 조회한 DashBoardVO
	 * @exception Exception
	 */
	public void selectUserNo(DashBoardVO dashBoardVO) throws Exception {
		LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();	
		dashBoardVO.setUcn(user.getChrgrNo());					
	}
	
	public List<DashBoardOffdayVO> serviceOffday(DashBoardOffdayVO dashBoardOffdayVO) throws Exception{
        
		
//		return selectOne("DashBoardMapper.serviceOffday", dashBoardOffdayVO);
		
		List<DashBoardOffdayVO> results = selectList("DashBoardMapper.serviceOffday", dashBoardOffdayVO);
		
//		for (int i = 0; i < results.size(); i++) {
//			if(results.get(i).getOffday_cd().equals("2")) {
//				System.out.println(results.get(i).getOffday_date() + "\t" + results.get(i).getChrgr_nm() + "\t" + "전일휴무");
//			}
//			else if(results.get(i).getOffday_cd().equals("3")) {
//				System.out.println(results.get(i).getOffday_date() + "\t" + results.get(i).getChrgr_nm() + "\t" + "반일휴무");
//			}
//			else {
//				System.out.println("변순데?" + i);
//			}
//			
//		}
		return results;
	}
}