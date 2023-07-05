package egovframework.com.cmm.dsb.service;

import java.util.List;

import egovframework.com.cmm.dsb.model.DashBoardOffdayVO;
import egovframework.com.cmm.dsb.model.DashBoardVO;


public interface DashBoardService {
	
	DashBoardVO serviceRequestProcessingStatistics(DashBoardVO vo) throws Exception;
	
	List<DashBoardOffdayVO> serviceOffday(DashBoardOffdayVO dashBoardOffdayVO) throws Exception;
	
	List<DashBoardVO> dlalzList(DashBoardVO vo) throws Exception;

//	void selectUserNo(DashBoardVO dashBoardVO) throws Exception;
}