package truebon.com.cmm.jasper.service.impl;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import egovframework.com.cmm.EgovWebUtil;
import egovframework.com.cmm.service.EgovProperties;
import egovframework.com.utl.fcc.service.EgovStringUtil;
import egovframework.com.utl.sim.service.EgovFileTool;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleWriterExporterOutput;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;
import truebon.com.cmm.jasper.model.JasperVO;
import truebon.com.cmm.jasper.service.JasperService;
import truebon.com.dlm.vis.model.VisitVO;
import truebon.com.dlm.vis.service.VisitService;

/**
 * Jasper Reports를  위한 서비스 구현 클래스
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
@Service("JasperService")
public class JasperServiceImpl extends EgovAbstractServiceImpl implements
        JasperService {
	
	@Autowired
	private BasicDataSource dataSource;
	
	/** 방문 Service */
	@Resource(name = "VisitService")
	private VisitService visitService;
	
	/** 로그설정 */
	private static final Logger LOGGER = LoggerFactory.getLogger(JasperServiceImpl.class);
	
	/** jrxml 파일 위치 지정  => globals.properties */
	private final String jrXmlFilePath = EgovProperties.getProperty("Globals.jrXmlFilePath");
	/** pdf 파일 위치 지정  => globals.properties */
	private final String jrPdfFilePath = EgovProperties.getProperty("Globals.jrPdfFilePath");
	/** src 상대 경로 파일 위치 지정  => globals.properties */
	private final String jrSrcFilePath = EgovProperties.getProperty("Globals.jrSrcFilePath");
	
	/**
	 * Jasper Reports 결과(HEADER VIEW용)
	 * @param jasperVO - 정보가 담긴 JasperVO
	 * @return ResponseEntity<byte[]>형 
	 * @throws JRException
	 */
	public ResponseEntity<byte[]> resultJasperReportHeader(JasperVO jasperVO) throws JRException {
		JasperPrint jasperPrint = null;
		byte[] dataPdf = null;
		HttpHeaders headers = new HttpHeaders();
		
		try {
			// JasperPrint
			jasperPrint = this.getJasperPrint(jasperVO);
			// PDF를 byte로 변환
			dataPdf = JasperExportManager.exportReportToPdf(jasperPrint);
			// Headers 세팅
			headers.set(HttpHeaders.CONTENT_DISPOSITION,"inline;filename=viewRepo.pdf");
			
		} catch (Exception e) {
			LOGGER.error("에러메시지:"+e.getMessage());
		}
		
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(dataPdf);
	}

	/**
	 * Jasper Reports 결과(PDF 파일 생성 후 IFRAME VIEW용)
	 * @param jasperVO - 정보가 담긴 JasperVO
	 * @return ModelAndView형 
	 * @throws Exception 
	 */
	public ModelAndView resultJasperReport(JasperVO jasperVO) throws Exception {
		String jrFileNm = jasperVO.getJrFileNm();
		String resultMsg = "성공";
		// 현재 시간으로 파일명을 만들어 중복 제거
		long lCurrentTime = System.currentTimeMillis();
    	
		JasperPrint jasperPrint = null;
    	
		ModelAndView mav = new ModelAndView("jsonView");
		File jrPdfFileFolder = new File(EgovWebUtil.filePathBlackList(jrPdfFilePath));
    	
		try {
			// JasperPrint
			jasperPrint = this.getJasperPrint(jasperVO);
			// PDF 파일 생성
			JasperExportManager.exportReportToPdfFile(jasperPrint, jrPdfFileFolder + File.separator + jrFileNm + Long.toString(lCurrentTime) + ".pdf");
			// 등록된 파일 경로
			mav.addObject("filePath", jrSrcFilePath + jrFileNm + Long.toString(lCurrentTime) + ".pdf");
			
		} catch (Exception e) {
			LOGGER.error("에러메시지:"+e.getMessage());
			resultMsg = "관리자 확인이 필요합니다.\n에러메시지:" + e.getMessage();
		}
		
		// 메시지
		mav.addObject("resultMsg", resultMsg);
		
		return mav;
	}
	
	/**
	 * Jasper Reports 결과(파일 다운로드용)
	 * @param jasperVO - 정보가 담긴 JasperVO
	 * @param response - HttpServletResponse
	 * @throws Exception
	 */
	public void resultJasperReport(JasperVO jasperVO, HttpServletResponse response) throws Exception {
		String jrFileNm = jasperVO.getJrFileNm();
		String paramFileType = jasperVO.getParamFileType();
		// 현재 시간으로 파일명을 만들어 중복 제거
		long lCurrentTime = System.currentTimeMillis();
		
		JasperPrint jasperPrint = null;
		ServletOutputStream outputStream = null;
		
		// JasperPrint
		jasperPrint = this.getJasperPrint(jasperVO);
		
		if(paramFileType.equals("PDF")) {
			JRPdfExporter exporter = new JRPdfExporter();
			exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
			exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(response.getOutputStream()));
			response.setContentType("application/pdf");
			response.setHeader(
				HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + jrFileNm + Long.toString(lCurrentTime) + ".pdf;");
			exporter.exportReport();
	    } else if (paramFileType.equals("EXCEL")) {
			JRXlsxExporter exporter = new JRXlsxExporter();
			SimpleXlsxReportConfiguration reportConfigXLS = new SimpleXlsxReportConfiguration();
			reportConfigXLS.setSheetNames(new String[]{"Excel Sheet"});
			reportConfigXLS.setDetectCellType(true);
			reportConfigXLS.setCollapseRowSpan(false);
			exporter.setConfiguration(reportConfigXLS);
			exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
			exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(response.getOutputStream()));
			response.setHeader(
			    HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + jrFileNm + Long.toString(lCurrentTime) + ".xlsx;");
			response.setContentType("application/octet-stream");
	        exporter.exportReport();
	    } else if (paramFileType.equals("CSV")) {
			JRCsvExporter exporter = new JRCsvExporter();
			exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
			outputStream = response.getOutputStream();
			exporter.setExporterOutput((new SimpleWriterExporterOutput(outputStream)));
			response.setHeader(
				HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + jrFileNm + Long.toString(lCurrentTime) + ".csv;");
			response.setContentType("text/csv");
			exporter.exportReport();
	    } else if (paramFileType.equals("DOC")) {
			JRDocxExporter exporter = new JRDocxExporter();
			exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
			exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(response.getOutputStream()));
			response.setHeader(
				HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + jrFileNm + Long.toString(lCurrentTime) + ".docx;");
			response.setContentType("application/octet-stream");
			exporter.exportReport();
	    } else {
	        throw new RuntimeException("File Format isn't supported!");
	    }
	}
	
	/**
	 * JasperPrint 생성
	 */
	public JasperPrint getJasperPrint(JasperVO jasperVO) throws Exception {
		String jrXmlFilePathAdd = jasperVO.getJrXmlFilePathAdd();
		String jrFileNm = jasperVO.getJrFileNm();
		String jrServiceNm = jasperVO.getJrServiceNm();
		
		JasperReport jasperReport = null;
		Connection conn = null;
		JasperPrint jasperPrint = null;
		JRDataSource jrDataSource = null;
		// parameters 값을 사용할 경우 사용.
		Map<String, Object> parameters = new HashMap<>();
		File jrXmlFileFolder = new File(EgovWebUtil.filePathBlackList(jrXmlFilePath+jrXmlFilePathAdd));
		
		try {
			// 하루가 지난 PDF 파일 삭제(0시 기준)
			deleteFilePeriod(1);
		
			jasperReport = JasperCompileManager.compileReport(jrXmlFileFolder + File.separator + jrFileNm + ".jrxml");
			
			int jrParamCnt = 1;
			// jrParam1, jrParam2 ... 등 파라미터값을 자동 저장
			if (jasperVO.getArrJrParamListJson() != null) {
				for (String jrParam : jasperVO.getArrJrParamListJson()){ 
					System.out.println("jrParam"+jrParamCnt+":"+jrParam);
					parameters.put("jrParam" + Integer.toString(jrParamCnt), jrParam);
					++jrParamCnt;
				} 
			}
			
			/* jrServiceNm 값이 없으면 jrxml 쿼리 사용
			 *  jrServiceNm 값이 있으면 DB에서 조회하여 사용.
			 */
			if(EgovStringUtil.isEmpty(jrServiceNm)) {
				conn = dataSource.getConnection();
				jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, conn);
			} else { // Service를 이용하여 데이터를 가져 올 경우 사용.
				jrDataSource = this.getJRDataSource(jrServiceNm, parameters);
				jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, jrDataSource);
			}
			
		} catch (Exception e) {
			LOGGER.error("에러메시지:"+e.getMessage());
		} finally {
			if(conn != null) {
				try {
					conn.close();
				}catch(SQLException e) {
					LOGGER.error("에러메시지:"+e.getMessage());
				}
			}
		}
		
		return jasperPrint;
	}
	
	/**
	 * 서비스 명칭에 해당하는 정보를 DB에서 조회하여 jrDataSource 로 리턴
	 * @param pJrServiceNm
	 * @param pParameters
	 * @return JRDataSource
	 * @throws Exception
	 */
	public JRDataSource getJRDataSource(String pJrServiceNm, Map<String, Object> pParameters) throws Exception {
		JRDataSource jrDataSource = null;
		
		// 방문자 출입관리 목록
		if("selectVisitList".equals(pJrServiceNm)) {
			List<VisitVO> visitList = new ArrayList<VisitVO>();
			VisitVO visitVO = new VisitVO();
			visitVO.setRecordCountPerPage(0); // 초기값 0으로 지정하여 사용 안함.
			visitVO.setStartDate(pParameters.get("jrParam1").toString());
			visitVO.setEndDate(pParameters.get("jrParam2").toString());
			visitList = visitService.selectVisitList(visitVO);
			jrDataSource = new JRBeanCollectionDataSource(visitList);
		}
	
		return jrDataSource;
	}
	
	/**
	 * 하루(pMinusDays=1)가 지난  파일 삭제(0시 기준)
	 * @throws Exception
	 */
	public void deleteFilePeriod(long pMinusDays) throws Exception {
		// 현재 시간 생성
    	LocalDateTime currDateTime = LocalDateTime.now();
    	LocalDateTime oneDaysAgo = currDateTime.minusDays(pMinusDays); // 1일 전
    	String formatedOneDaysAgo = oneDaysAgo.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
		
    	try {
			// 기간에 해당하는 파일 목록
			List<String> deleteFilePathList = EgovFileTool.getFileListByUpdtPd(jrPdfFilePath, "20220701", formatedOneDaysAgo);
			// 조회된 파일 삭제
			for (String deleteFilePath : deleteFilePathList) {
				EgovFileTool.deleteFile(deleteFilePath);
			}
		} catch (NullPointerException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}