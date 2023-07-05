package truebon.com.dlm.dla.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import truebon.com.dlm.dla.model.Dlalz;
import truebon.com.dlm.dla.model.DlalzVO;
import truebon.com.sys.chr.model.ChargerVO;



@Repository("DlalzDAO")
public class DlalzDAO extends EgovComAbstractDAO{

   /**
    * tb_dlalz을 등록한다.
    * @param vo - 등록할 정보가 담긴 DlalzVO
    * @return 등록 결과
    * @exception Exception
    */
    public void insertDlalz(Dlalz vo) throws Exception {
        insert("DlalzMapper.insertDlalz", vo);
    }

    /**
    * tb_dlalz을 수정한다.
    * @param vo - 수정할 정보가 담긴 DlalzVO
    * @return void형
    * @exception Exception
    */
    public void updateDlalz(Dlalz vo) throws Exception {
    	System.out.println("dao");
        update("DlalzMapper.updateDlalz", vo);
    }
    
    
    /**
    * tb_dlalz을 조회한다.
    * @param vo - 조회할 정보가 담긴 DlalzVO
    * @return 조회한 tb_dlalz
    * @exception Exception
    */
    public DlalzVO selectDlalz(Dlalz vo) throws Exception {
        return (DlalzVO)selectOne("DlalzMapper.selectDlalz", vo);
    }
    
    /**
    * tb_dlalz 목록을 조회한다.
    * @param searchMap - 조회할 정보가 담긴 Map
    * @return tb_dlalz 목록
    * @exception Exception
    */
    public List<DlalzVO> selectDlalzList(DlalzVO searchVO) throws Exception {
        return selectList("DlalzMapper.selectDlalzList", searchVO);
    }
    
    /**
    * tb_dlalz 총 갯수를 조회한다.
    * @param searchMap - 조회할 정보가 담긴 Map
    * @return tb_dlalz 총 갯수
    * @exception
    */
    public int selectDlalzListTotCnt(DlalzVO searchVO) {
        return (Integer)selectOne("DlalzMapper.selectDlalzListTotCnt", searchVO);
    }
    
    /**
      * tb_dlalz 목록을 조회한다.
      * @param searchMap - 조회할 정보가 담긴 Map
      * @return tb_dlalz 목록
      * @exception Exception
      */
      public List<ChargerVO> selectNotExistChargerList(DlalzVO searchVO) throws Exception {
          return selectList("DlalzMapper.selectNotExistChargerList", searchVO);
      }
    
    /**
       * 입력한 년도와 월의 날짜가 이미 추가되어 있는지 체크하여 등록가능여부 확인.
       * @param checkDate 체크대상 년도와 월의 첫번째 날짜 
       * @return int 등록가능여부(등록횟수)
       */
       public int selectNotExistChargerListTotCnt(DlalzVO searchVO) {
          return (Integer)selectOne("DlalzMapper.selectNotExistChargerListTotCnt", searchVO);
       }
       
       
    /**
     * tb_replaceOffday 대휴를 등록한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return 등록 결과
     * @exception Exception
     */
     public void insertReOffday(DlalzVO vo) throws Exception {
          insert("DlalzMapper.insertReOffday", vo);
     } 
     
     /**
     * tb_replaceOffday 대휴를 수정한다.
     * @param vo - 수정할 정보가 담긴 DlalzVO
     * @return void형
     * @exception Exception
     */
     public void updateReOffday(Dlalz vo) throws Exception {
         update("DlalzMapper.updateReOffday", vo);
     }
     
     /**
     * tb_replaceOffday 대휴를 삭제한다.
     * @param vo - 수정할 정보가 담긴 DlalzVO
     * @return void형
     * @exception Exception
     */
     public void deleteReOffday(Dlalz vo) throws Exception {
         delete("DlalzMapper.deleteReOffday", vo);
     }
}