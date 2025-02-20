package truebon.com.opm.cmp.controller;

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
import truebon.com.dlm.dla.model.DlalzVO;
import truebon.com.opm.cmp.model.CompuResrcMngVO;

/**
 * @Class Name : CompuResrcMngController.java
 * @Description : CompuResrcMng Controller class
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

public class CompuResrcMngController {

	/**
	 * 전산자원 목록화면 (paging)
	 * @param searchVO - 조회할 정보가 담긴 CompuResrcMngVO
	 * @exception Exception
	 */
    @RequestMapping(value="/opm/cmp/CompuResrcMngList.do")
    public String CompuResrcMngList(@ModelAttribute("searchVO") CompuResrcMngVO searchVO, ModelMap model) throws Exception {
    	
        return "/truebon/com/opm/cmp/CompuResrcMngList";
    } 
   
    /**
     * 전산자원관리 대장
     * @param CompuResrcMngVO
     * @param CompuResrcMngVO
     * @param status
     * @return
     * @throws Exception
     */
   @RequestMapping("/opm/cmp/CompuResrcLedger.do")
   public String CompuResrcLedger(@ModelAttribute("CompuResrcMngVO") CompuResrcMngVO CompuResrcMngVO, ModelMap model) throws Exception {
      
      return "/truebon/com/opm/cmp/CompuResrcLedger";
   }
}
