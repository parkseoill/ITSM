package truebon.com.opm.ins.controller;

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
import truebon.com.opm.ins.model.InspcMngVO;

/**
 * @Class Name : InspcMngController.java
 * @Description : InspcMng Controller class
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

public class InspcMngController {

	/**
	 * 점검 목록화면 (paging)
	 * @param searchVO - 조회할 정보가 담긴 InspcMngVO
	 * @exception Exception
	 */
    @RequestMapping(value="/opm/ins/InspcMngList.do")
    public String InspcMngList(@ModelAttribute("searchVO") InspcMngVO searchVO, ModelMap model) throws Exception {
    	
        return "/truebon/com/opm/ins/InspcMngList";
    } 
   
}
