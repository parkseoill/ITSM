package truebon.com.sta.req.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springmodules.validation.commons.DefaultBeanValidator;

import egovframework.com.cmm.EgovMessageSource;
import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.rte.fdl.property.EgovPropertyService;
import truebon.com.opm.srm.model.SrMasterVO;
import truebon.com.sta.req.service.RequestService;
import truebon.com.sys.chr.service.ChargerService;
/**
 * @Class Name : RequestMngController.java
 * @Description : Request Controller class
 * @Modification Information
 *
 * @author 김도아
 * @since 2022.10.20
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Controller
@SessionAttributes(types=Request.class)
public class RequestController {
	
	/* Validator */
	@Autowired
	private DefaultBeanValidator beanValidator;
	
	/** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	
	/** EgovMessageSource */
    @Resource(name="egovMessageSource")
    EgovMessageSource egovMessageSource;
    
    /** 공통코드 Service */
    @Resource(name = "EgovCmmUseService")
    private EgovCmmUseService cmmUseService;
    
    /** 담당자 Service */
    @Resource(name = "RequestService")
    private RequestService requestService;
    
    /** 담당자 Service */
    @Resource(name = "ChargerService")
    private ChargerService chargerService;
	
    /**
	 * 요청통계(담당자별)목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 RequestVO
	 * @exception Exception
	 */
    @RequestMapping(value="/sta/req/RequestMngList.do")
    public String RequestMngList(@ModelAttribute("searchVO") SrMasterVO searchVO, 
    		ModelMap model)
            throws Exception {
    	List<SrMasterVO> requestList = requestService.selectReqChrList(searchVO);
    	
		// 목록
    	if(searchVO.getSearchCondition().equals("1")) {
    		 requestList = (List<SrMasterVO>) requestService.selectReqChrList(searchVO);
    	}else if(searchVO.getSearchCondition().equals("2")) {
    		 requestList = requestService.selectReqList(searchVO);
    	}else if(searchVO.getSearchCondition().equals("3")) {
    		 requestList = (List<SrMasterVO>) requestService.selectReqDeptList(searchVO);
    	}else {
    		 requestList = (List<SrMasterVO>)requestService.selectReqChrList(searchVO);
    	}
		
        model.addAttribute("resultList", requestList);
        model.addAttribute("searchVO", searchVO);
        
        return "/truebon/com/sta/req/RequestMngList";
    } 

}
