package truebon.com.cmm.jasper.service;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.ModelAndView;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import truebon.com.cmm.jasper.model.JasperVO;

/**
 * Jasper Reports를 위한 서비스 인터페이스 클래스
 * @author 이태신
 * @since 2022.08.02
 * @version 1.0
 * @see
 *  
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *  수정일               수정자            수정내용
 *  ----------   --------   ---------------------------
 *  2022.08.02   이태신           최초 생성
 *
 * </pre>
 */
public interface JasperService {
	
	/**
	 * Jasper Reports 결과(HEADER VIEW용)
	 * @param jasperVO - 정보가 담긴 JasperVO
	 * @return ResponseEntity<byte[]>형 
	 * @throws JRException
	 */
	ResponseEntity<byte[]> resultJasperReportHeader(JasperVO jasperVO) throws JRException;
	
	/**
	 * Jasper Reports 결과(PDF 파일 생성 후 IFRAME VIEW용)
	 * @param jasperVO - 정보가 담긴 JasperVO
	 * @return ModelAndView형 
	 * @throws JRException
	 * @throws IOException
	 * @throws Exception 
	 */
	ModelAndView resultJasperReport(JasperVO jasperVO) throws Exception;
	
	/**
	 * Jasper Reports 결과(파일 다운로드용)
	 * @param jasperVO - 정보가 담긴 JasperVO
	 * @return ModelAndView형 
	 * @throws JRException
	 * @throws IOException
	 */
	void resultJasperReport(JasperVO jasperVO, HttpServletResponse response) throws Exception;
	
	/**
	 * JasperPrint 생성
	 * @param jasperVO
	 * @return
	 * @throws Exception
	 */
	JasperPrint getJasperPrint(JasperVO jasperVO) throws Exception;
	
	/**
	 * 하루(pMinusDays=1)가 지난 파일 삭제(0시 기준)
	 * @param pMinusDays
	 */
	void deleteFilePeriod(long pMinusDays) throws Exception;
}