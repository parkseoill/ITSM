package truebon.com.dlm.rep.service;

import java.util.List;

import truebon.com.dlm.rep.model.ReplaceVO;

public interface ReplaceService {

    List<ReplaceVO> selectReplaceList(ReplaceVO searchVO) throws Exception;
    
    List<ReplaceVO> selectReplaceUseList(ReplaceVO ReplaceVO) throws Exception;
    
    void insertReOffday(ReplaceVO searchVO)throws Exception;
    
}