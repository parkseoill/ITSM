package truebon.com.dlm.dla.service;

import java.util.List;

import truebon.com.dlm.dla.model.Dlalz;
import truebon.com.dlm.dla.model.DlalzVO;
import truebon.com.sys.chr.model.ChargerVO;



public interface DlalzService {

   /**
    * tb_dlalz을 등록한다.
    * @param vo - 등록할 정보가 담긴 DlalzVO
    * @return 등록 결과
    * @exception Exception
    */
    void insertDlalz(Dlalz vo) throws Exception;
    
    /**
    * tb_dlalz을 수정한다.
    * @param vo - 수정할 정보가 담긴 DlalzVO
    * @return void형
    * @exception Exception
    */
    void updateDlalz(Dlalz vo) throws Exception;
    
    /**
    * tb_dlalz을 조회한다.
    * @param vo - 조회할 정보가 담긴 DlalzVO
    * @return 조회한 tb_dlalz
    * @exception Exception
    */
    DlalzVO selectDlalz(DlalzVO vo) throws Exception;

    /**
    * tb_dlalz 목록을 조회한다.
    * @param searchMap - 조회할 정보가 담긴 Map
    * @return tb_dlalz 목록
    * @exception Exception
    */
    List<DlalzVO> selectDlalzList(DlalzVO searchVO) throws Exception;

    /**
    * tb_dlalz 총 갯수를 조회한다.
    * @param searchMap - 조회할 정보가 담긴 Map
    * @return tb_dlalz 총 갯수
    * @exception
    */
    int selectDlalzListTotCnt(DlalzVO searchVO);
    
    /**
       * tb_dlalz 목록을 조회한다.
       * @param searchMap - 조회할 정보가 담긴 Map
       * @return tb_dlalz 목록
       * @exception Exception
       */
   List<ChargerVO> selectNotExistChargerList(DlalzVO searchVO) throws Exception;
    
    /**
       * 입력한 날짜의 등록여부를 체크하여 등록가능여부를 확인
       * @param checkDate 등록여부 확인대상 아이디
       * @return 등록가능여부(날짜 등록회수 int)
       * @throws Exception
       */
    int selectNotExistChargerListTotCnt(DlalzVO searchVO) throws Exception;
    
   /**
       * tb_replaceOffday 대휴를 등록한다.
       * @param vo - 등록할 정보가 담긴 DlalzVO
       * @return 등록 결과
       * @exception Exception
       */
    void insertReOffday(DlalzVO vo) throws Exception;
    
    /**
    * tb_replaceOffday 대휴를 수정한다.
    * @param vo - 수정할 정보가 담긴 DlalzVO
    * @return void형
    * @exception Exception
    */
    void updateReOffday(Dlalz vo) throws Exception;
    
    /**
    * tb_replaceOffday 대휴를 삭제한다.
    * @param vo - 수정할 정보가 담긴 DlalzVO
    * @return void형
    * @exception Exception
    */
    void deleteReOffday(Dlalz vo) throws Exception;
}
