package truebon.com.cmm.jasper.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Jasper Reports 처리를 위한 VO 클래스를 정의한다
 * @author 이태신
 * @since 2022.07.15
 * @version 1.0
 * @see
 *  
  * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *  수정일               수정자            수정내용
 *  ----------   --------   ---------------------------
 *  2022.07.15   이태신           최초 생성
 *  
 * </pre>
 */

@SuppressWarnings("serial")
public class JasperVO implements Serializable{

	/** jr 파일 경로 Add */
	private String jrXmlFilePathAdd;
	
	/** jr 파일 명 */
	private String jrFileNm;
	
	/** jr Service 명 */
	private String jrServiceNm;
	
	/** paramFileType Export File Type */
	private String paramFileType;
	
	/** json JrParamList */
	private List<String> arrJrParamListJson = new ArrayList<String>();

	public String getJrXmlFilePathAdd() {
		return jrXmlFilePathAdd;
	}

	public void setJrXmlFilePathAdd(String jrXmlFilePathAdd) {
		this.jrXmlFilePathAdd = jrXmlFilePathAdd;
	}

	public String getJrFileNm() {
		return jrFileNm;
	}

	public void setJrFileNm(String jrFileNm) {
		this.jrFileNm = jrFileNm;
	}

	public String getJrServiceNm() {
		return jrServiceNm;
	}

	public void setJrServiceNm(String jrServiceNm) {
		this.jrServiceNm = jrServiceNm;
	}

	public String getParamFileType() {
		return paramFileType;
	}

	public void setParamFileType(String paramFileType) {
		this.paramFileType = paramFileType;
	}

	public List<String> getArrJrParamListJson() {
		return arrJrParamListJson;
	}

	public void setArrJrParamListJson(String pJrParam) throws ParseException {
		ArrayList<String> tmpJrParam = new ArrayList<String>();
		JSONParser parser = new JSONParser();
		// 큰따옴표가 '&quot;' 값으로 변경되어 들어와 치환
		String strJrParamList = pJrParam.toString().replaceAll("&quot;", "\"");
		JSONArray arrJrParam = (JSONArray)parser.parse(strJrParamList);
		tmpJrParam = arrJrParam;
		this.arrJrParamListJson = tmpJrParam;
	}
	
}
