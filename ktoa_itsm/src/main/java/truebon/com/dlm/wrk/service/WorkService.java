package truebon.com.dlm.wrk.service;

import java.util.List;
import truebon.com.dlm.wrk.model.*;

public interface WorkService {

    /**
    * tb_work를 조회한다.
    * @param searchMap - 조회할 정보가 담긴 Map
    * @return tb_work 목록
    * @exception Exception
    */
    List<WorkVO> selectWorkList(WorkVO searchVO) throws Exception;
    
    
    /**
    * tb_rework를 조회한다.
    * @param searchMap - 조회할 정보가 담긴 Map
    * @return tb_work 목록
    * @exception Exception
    */
    List<WorkVO> selectRmark(WorkVO searchVO) throws Exception;
    
    
    /**
    * tb_work을 수정한다.
    */
    void updateWork(Work vo) throws Exception;
    
    
    /**
     * tb_rework을 수정한다.
     */ 
    void updateResWork(Work vo) throws Exception;
    

   /**
    * 마감
    */
    void closing(Work vo) throws Exception; 
    void insertClosing(Work vo) throws  Exception; 
    
    
    /**
     * OP 일괄 입력
     */ 
    void updateOp(Work vo) throws Exception;
    
    
}