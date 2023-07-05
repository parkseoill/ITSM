package truebon.com.dlm.dla.service;

import java.util.List;

import truebon.com.dlm.dla.model.Dlalz;
import truebon.com.dlm.dla.model.DlalzVO;



public interface DlalzQRService {

	 /**
	 * tb_dlalz을 수정한다.
	 * @param vo - 수정할 정보가 담긴 DlalzVO
	 * @return int형
	 * @exception Exception
	 */
	 int updateDlalzQR(Dlalz vo) throws Exception;
	 
	 /**
	 * tb_dlalz을 조회한다.
	 * @param vo - 조회할 정보가 담긴 DlalzVO
	 * @return 조회한 tb_dlalz
	 * @exception Exception
	 */
	 DlalzVO selectDlalzQR(DlalzVO vo) throws Exception;

	 /**
	 * tb_dlalz 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return tb_dlalz 목록
	 * @exception Exception
	 */
	 List<DlalzVO> selectDlalzQRList(DlalzVO searchVO) throws Exception;

	 /**
	 * tb_dlalz 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return tb_dlalz 총 갯수
	 * @exception
	 */
	 int selectDlalzQRListTotCnt(DlalzVO searchVO);
	 
	 
}

