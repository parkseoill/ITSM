package truebon.com.dlm.cod.service.impl;

import java.time.LocalDate;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import truebon.com.dlm.cod.service.ComnDateService;
import truebon.com.dlm.cod.model.ComnDate;
import truebon.com.dlm.cod.model.ComnDateVO;
import truebon.com.dlm.cod.dao.ComnDateDAO;

/**
 * 공통일자를 위한 서비스 구현 클래스
 * @author 이유리
 * @since 2022.05.23
 * @version 1.0
 * @see
 *  
* <pre>
 * << 개정이력(Modification Information) >>
 *   
 *  수정일               수정자            수정내용
 *  ----------   --------   ---------------------------
 *  2022.05.23   이유리           최초 생성
 *
 * </pre>
 */

@Service("ComnDateService")
public class ComnDateServiceImpl extends EgovAbstractServiceImpl implements ComnDateService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ComnDateServiceImpl.class);
	
    @Resource(name="ComnDateDAO")
    private ComnDateDAO comnDateDAO;
    
    /**
	 * tb_comn_date를 조회한다.
	 * @param vo - 조회할 정보가 담긴 ComnDateVO
	 * @return 조회한 tb_comn_date
	 * @exception Exception
	 */
    public ComnDateVO selectComnDate(ComnDateVO vo) throws Exception {
    	ComnDateVO resultVO = comnDateDAO.selectComnDate(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * tb_comn_date 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return tb_comn_date 목록
	 * @exception Exception
	 */
    public List<ComnDateVO> selectComnDateList(ComnDateVO searchVO) throws Exception {
    	
    	if(searchVO.getSearchKeyword().equals("init")) {
    		 LocalDate currentdate = LocalDate.now();
    		 String year = String.valueOf(currentdate.getYear());
    		 String month = String.format("%02d", currentdate.getMonthValue());
    		 searchVO.setSearchKeyword(year + "-" + month);
    	}
        return comnDateDAO.selectComnDateList(searchVO);
    }

    /**
	 * tb_comn_date 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return tb_comn_date 총 갯수
	 * @exception
	 */
    public int selectComnDateListTotCnt(ComnDateVO searchVO) {
		return comnDateDAO.selectComnDateListTotCnt(searchVO);
	}
    
	/**
	 * tb_comn_date를 등록한다.
	 * @param vo - 등록할 정보가 담긴 ComnDate
	 * @exception Exception
	 */
    public void insertComnDate(ComnDate vo) throws Exception {
		ComnDate cdVo = null;
		String strUserId = "";
		
		// 로그인 객체 선언
    	LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
    	strUserId = user.getId();
    	
    	String checkDate = vo.getCheckDate(); //데이터를 생성할 날짜
    	String [] dayOfCheckDate = vo.getDayOfCheckDate().split(","); //해당 월의 1일 요일 정보
    	String [] lastDate = vo.getLastDate().split(","); //해당 월의 마지막 일자
    	
    	int checkDateToInt = Integer.valueOf(checkDate);
    	for(int month=0;month<12;month++) {
    		int lastDateToInt = Integer.valueOf(lastDate[month]);
    		int dayOfCheckDateToInt = Integer.valueOf(dayOfCheckDate[month]);
    		for(int day=1;day<=lastDateToInt;day++) {
    			cdVo = new ComnDate();
        		cdVo.setStdrDate(Integer.toString(checkDateToInt));
        		cdVo.setDyweekDstnctCd(Integer.toString(dayOfCheckDateToInt % 7 + 1));
        		cdVo.setHdayDstnctCd("2");
        		if(checkDateToInt % 10000 == 101) {
        			cdVo.setHdayNm("신정");
        		}else if(checkDateToInt % 10000 == 301){
        			cdVo.setHdayNm("삼일절");
        		}else if(checkDateToInt % 10000 == 505){
        			cdVo.setHdayNm("어린이날");
        		}else if(checkDateToInt % 10000 == 606){
        			cdVo.setHdayNm("현충일");
        		}else if(checkDateToInt % 10000 == 815){
        			cdVo.setHdayNm("광복절");
        		}else if(checkDateToInt % 10000 == 1003){
        			cdVo.setHdayNm("개천절");
        		}else if(checkDateToInt % 10000 == 1009){
        			cdVo.setHdayNm("한글날");
        		}else if(checkDateToInt % 10000 == 1225){
        			cdVo.setHdayNm("성탄절");
        		}else {
        			if(dayOfCheckDateToInt % 7 == 0) {
    	    			cdVo.setHdayNm("일요일");
    	    		}else if(dayOfCheckDateToInt  % 7 == 6){
    	    			cdVo.setHdayNm("토요일");
    	    		}else {
    	    			cdVo.setHdayDstnctCd("1");
    	    		}
        		}
        		checkDateToInt++;
        		dayOfCheckDateToInt++;
        		cdVo.setRegstrId(strUserId);
        		comnDateDAO.insertComnDate(cdVo);
    		}
    		checkDateToInt += (100 - lastDateToInt);
    	}
    }

    /**
	 * tb_comn_date를 수정한다.
	 * @param vo - 수정할 정보가 담긴 ComnDate
	 * @return void형
	 * @exception Exception
	 */
    public void updateComnDate(ComnDate vo) throws Exception {
    	// 로그인 객체 선언
    	LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
    	vo.setAmndrId(user.getId());
    	
    	comnDateDAO.updateComnDate(vo);
    }

    /**
	 * tb_comn_date에 checkDate가 있는지 체크한다.
	 * @param checkDate - 조회할 날짜
	 * @return 등록 여부 값 (0이면 등록가능)
	 * @exception
	 */
    public int checkComnDate(String checkDate) {
    	return comnDateDAO.checkComnDate(checkDate);
    }
    
    /**
  	 * tb_comn_date에서 공휴일인지 아닌지 체크한다.
  	 * @param searchVO - 조회할 정보가 담긴 VO
  	 * @return tb_comn_date 목록
  	 * @exception Exception
  	 */
      public List<ComnDateVO> selectHdayCd(ComnDateVO searchVO) throws Exception {
          return comnDateDAO.selectHdayCd(searchVO);
      }
}
