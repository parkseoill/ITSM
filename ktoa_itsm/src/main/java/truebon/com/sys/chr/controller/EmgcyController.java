package truebon.com.sys.chr.controller;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import egovframework.com.cmm.EgovMessageSource;
import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.rte.fdl.property.EgovPropertyService;
import truebon.com.sys.chr.model.Charger;
import truebon.com.sys.chr.model.ChargerVO;
import truebon.com.sys.chr.service.ChargerService;

/**
 * @Class Name : EmgcyController.java
 * @Description : EmgcyContactList Controller class
 * @Modification Information
 *
 * @author 이정하
 * @since 2023.08.23
 * @version 1.0
 * @see
 * 
 *      Copyright (C) All right reserved.
 */

@Controller
@SessionAttributes(types = Charger.class)
public class EmgcyController {
	/** EgovMessageSource */
	@Resource(name = "egovMessageSource")
	EgovMessageSource egovMessageSource;

	/** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
    
	
    /** 담당자 Service */
    @Resource(name = "ChargerService")
    private ChargerService chargerService;
	
    /** 공통코드 Service */
	@Resource(name = "EgovCmmUseService")
	private EgovCmmUseService cmmUseService;
	
	/**
	 * 비상연락망 파일 (jasper)
	 * @param searchVO - 조회할 정보가 담긴 VisitVO
	 * @exception Exception
	 */
	@RequestMapping(value = "/sys/chr/EmgcyContListJH.do")
	public String EmgcyContListJH(@ModelAttribute("chargerVO") ChargerVO chargerVO,
			ModelMap model) throws Exception {
		
		return "/truebon/com/sys/chr/EmgcyContListJH";
	}
}
