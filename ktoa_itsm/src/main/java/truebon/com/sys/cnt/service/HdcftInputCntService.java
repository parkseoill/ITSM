package truebon.com.sys.cnt.service;

import java.util.List;

import truebon.com.sys.cnt.model.HdcftInputCntVO;

public interface HdcftInputCntService {

    /**
    * tb_work를 조회한다.
    * @param searchMap - 조회할 정보가 담긴 Map
    * @return tb_work 목록
    * @exception Exception
    */
    List<HdcftInputCntVO> selectHdcftInputCntList(HdcftInputCntVO hdcftInputCntVO)throws Exception;
}
