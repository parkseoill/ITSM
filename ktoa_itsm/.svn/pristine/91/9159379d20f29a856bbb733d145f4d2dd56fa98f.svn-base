package truebon.com.opm.wrk.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springmodules.validation.commons.DefaultBeanValidator;

import egovframework.com.cmm.EgovMessageSource;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import truebon.com.opm.cmp.model.CompuResrcMngVO;
import truebon.com.opm.wrk.model.WrkMngVO;

/**
 * @Class Name : WrkMngController.java
 * @Description : WrkMng Controller class
 * @Modification Information
 *
 * @author 김승현
 * @since 2023.08.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Controller

public class WrkMngController {

	/**
	 * 작업 목록화면 (paging)
	 * @param searchVO - 조회할 정보가 담긴 WrkMngVO
	 * @exception Exception
	 */
    @RequestMapping(value="/opm/wrk/WrkMngList.do")
    public String WrkMngList(@ModelAttribute("searchVO") WrkMngVO searchVO, ModelMap model) throws Exception {
    	
        return "/truebon/com/opm/wrk/WrkMngList";
    } 
   
    /**
     * 작업관리 대장
     * @param WrkMngVO
     * @param WrkMngVO
     * @param status
     * @return
     * @throws Exception
     */
   @RequestMapping("/opm/wrk/WrkLedger.do")
   public String WrkLedger(@ModelAttribute("WrkMngVO") WrkMngVO WrkMngVO, ModelMap model) throws Exception {
      
      return "/truebon/com/opm/wrk/WrkLedger";
   }
}
