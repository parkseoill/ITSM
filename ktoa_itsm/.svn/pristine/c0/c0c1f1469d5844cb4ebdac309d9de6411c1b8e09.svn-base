package truebon.com.fai.prd.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import truebon.com.fai.prd.model.FailPeriod;
import truebon.com.fai.prd.model.FailPeriodVO;
import truebon.com.opm.biz.model.BizSytmVO;

@Repository("FailPeriodCdDAO")
public class FailPeriodCdDAO extends EgovComAbstractDAO {
	/**
	 * tb_fail_grade 목록을 조회한다.
	 * 
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return tb_fail_grade 목록
	 * @exception Exception
	 */
	public List<FailPeriod> selectFailPeriodList(FailPeriod vo) throws Exception {
		return selectList("FailPeriodMapper.selectFailPeriodList", vo);
	}

	/**
	 * tb_fail_grade 총 개수를 조회한다.
	 * 
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return tb_fail_grade 목록 개수
	 * @exception Exception
	 */
	public int selectFailPeriodListTotCnt(FailPeriod vo) throws Exception {
		return (Integer) selectOne("FailPeriodMapper.selectFailPeriodListTotCnt", vo);
	}

	/**
	 * 장애등급을 상세항목을 조회한다.
	 * 
	 * @param FailPeriod
	 * @return FailPeriod
	 * @throws Exception
	 */
	public FailPeriodVO selectFailPeriod(FailPeriod searchVO) throws Exception {
		return (FailPeriodVO) selectOne("FailPeriodMapper.selectFailPeriod", searchVO);
	}

	/**
	 * 장애등급을 수정한다.
	 * 
	 * @param vo - 수정할 정보가 담긴 FailPeriod
	 * @return void형
	 * @exception Exception
	 */
	public void updateFailPeriod(FailPeriod vo) throws Exception {
		update("FailPeriodMapper.updateFailPeriod", vo);
	}

	/**
	 * 장애조치기한을 추가한다.
	 * 
	 * @param vo - 추가할 정보가 담긴 FailPeriod
	 * @return void형
	 * @exception Exception
	 */
	public void insertFailPeriod(FailPeriod vo) throws Exception {
		insert("FailPeriodMapper.insertFailPeriod", vo);
	}

	/**
	 * tb_biz_sytm 장애등급 없는 목록을 조회한다.
	 * 
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return tb_biz_sytm 목록
	 * @exception Exception
	 */
	public List<BizSytmVO> selectFailBizSytmList(BizSytmVO searchVO) throws Exception {
		return selectList("BizSytmMapper.selectFailBizSytmList", searchVO);
	}
}
