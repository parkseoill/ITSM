package truebon.com.dlm.rep.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import truebon.com.dlm.rep.dao.ReplaceDAO;
import truebon.com.dlm.rep.model.ReplaceVO;

import truebon.com.dlm.rep.service.ReplaceService;

@Service("ReplaceService")
public  class ReplaceServiceImpl  extends EgovAbstractServiceImpl implements ReplaceService{

      
     @Resource(name = "ReplaceDAO")
     private ReplaceDAO replaceDAO;
      

      /**
       * tb_replac_offday를 조회한다.
       * 
       * @param searchVO - 조회할 정보가 담긴 VO
       */
      
      public List<ReplaceVO> selectReplaceList(ReplaceVO searchVO) throws Exception {
      
      LoginVO user = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
      searchVO.setName(user.getName());
          
      LocalDate currentdate = LocalDate.now();
      if (searchVO.getSelectedDate() == "") {
         searchVO.setSelectedDate(currentdate.format(DateTimeFormatter.ofPattern("yyyy")));
      }
         return replaceDAO.selectReplaceList(searchVO);
      }
     

      /**
       * tb_replac_offday를 조회한다.
       * 
       * @param searchVO - 조회할 정보가 담긴 VO
       */
      
      public List<ReplaceVO> selectReplaceUseList(ReplaceVO ReplaceVO) throws Exception {
      
      LocalDate currentdate = LocalDate.now();
      if (ReplaceVO.getSelectedDate() == "") {
         ReplaceVO.setSelectedDate(currentdate.format(DateTimeFormatter.ofPattern("yyyy")));
      }
         return replaceDAO.selectReplaceUseList(ReplaceVO);
      }


      /**
       * tb_replac_offday를  생성한다
       * 
       * @param searchVO - 생성할 정보가 담긴 VO
       */
	 public void insertReOffday(ReplaceVO searchVO) throws Exception {
	     replaceDAO.insertReOffday(searchVO);
	 }	
    
	 
}