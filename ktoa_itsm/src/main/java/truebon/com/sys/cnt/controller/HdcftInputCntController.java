package truebon.com.sys.cnt.controller;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import truebon.com.sys.cnt.model.HdcftInputCntVO;
import truebon.com.sys.cnt.service.HdcftInputCntService;

@Controller
public class HdcftInputCntController {

	  @Resource(name = "HdcftInputCntService")
	    private HdcftInputCntService hdcftInputCntService;
	/**
	 * 근무편성 수정
	 *  
	 * @param WorkVO
	 */
	@RequestMapping("/sys/cnt/HdcftInputCnt.do")
	public String hdcftInputCnt(@ModelAttribute("HdcftInputCntVO") HdcftInputCntVO hdcftInputCntVO, BindingResult bindingResult,
			ModelMap model) throws Exception {

		List<HdcftInputCntVO> HdcftInputCntList = hdcftInputCntService.selectHdcftInputCntList(hdcftInputCntVO);
		
		model.addAttribute("HdcftInputCntList", HdcftInputCntList);
		return "/truebon/com/sys/cnt/HdcftInputCnt";
	}

}
