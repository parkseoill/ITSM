package truebon.com.dlm.dla.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import truebon.com.dlm.dla.model.Dlalz;
import truebon.com.dlm.dla.model.DlalzVO;



@Repository("DlalzQRDAO")
public class DlalzQRDAO extends EgovComAbstractDAO{

	/**
	 * tb_dlalz을 수정한다.
	 * @param vo - 수정할 정보가 담긴 DlalzVO
	 * @return void형
	 * @exception Exception
	 */
    public int updateDlalzQR(Dlalz vo) throws Exception {
        return update("DlalzQRMapper.updateDlalzQR", vo);
    }
    
    
    /**
	 * tb_dlalz을 조회한다.
	 * @param vo - 조회할 정보가 담긴 DlalzVO
	 * @return 조회한 tb_dlalz
	 * @exception Exception
	 */
    public DlalzVO selectDlalzQR(Dlalz vo) throws Exception {
        return (DlalzVO)selectOne("DlalzQRMapper.selectDlalzQR", vo);
    }
    
    /**
	 * tb_dlalz 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return tb_dlalz 목록
	 * @exception Exception
	 */
    public List<DlalzVO> selectDlalzQRList(DlalzVO searchVO) throws Exception {
        return selectList("DlalzQRMapper.selectDlalzQRList", searchVO);
    }
    
    /**
	 * tb_dlalz 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return tb_dlalz 총 갯수
	 * @exception
	 */
    public int selectDlalzQRListTotCnt(DlalzVO searchVO) {
        return (Integer)selectOne("DlalzQRMapper.selectDlalzQRListTotCnt", searchVO);
    }
    
    
}
