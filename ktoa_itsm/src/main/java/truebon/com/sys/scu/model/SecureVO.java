package truebon.com.sys.scu.model;

import java.io.Serializable;
import java.util.Date;

import com.ibm.icu.text.SimpleDateFormat;


/**
 * 담당자 처리를 위한 VO 클래스르를 정의한다
 * @author 조경민
 * @since 2022.07.29
 * @version 1.0
 * @see
 *  
  * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *  수정일 		수정자	수정내용
 *  ----------   --------   ---------------------------
 *  2022.07.29	조경민	최초 생성
 *
 * </pre>
 */

@SuppressWarnings("serial")
public class SecureVO extends Secure implements Serializable {

	/** 위치검색 */
    private String inspLocatSearch = "";
    
    Date nowDate = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("YYYYMM");
    
    /** 날짜검색 */
    private String dateSearch = sdf.format(nowDate);
    
    /** 확인자 사인 */
    private byte[] userSign;
    
    /** String 사인 */
    private String strUserSign;
    
    /** 수정자 이름 */
    private String amndrNm;
    
    public byte[] getUserSign() {
		return userSign;
	}

	public void setUserSign(byte[] userSign) {
		this.userSign = userSign;
	}

	public String getStrUserSign() {
		return strUserSign;
	}

	public void setStrUserSign(String strUserSign) {
		this.strUserSign = strUserSign;
	}

    
    public String getInspLocatSearch() {
		return inspLocatSearch;
	}

	public void setInspLocatSearch(String inspLocatSearch) {
		this.inspLocatSearch = inspLocatSearch;
	}

	public String getDateSearch() {
		return dateSearch;
	}

	public void setDateSearch(String dateSearch) {
		this.dateSearch = dateSearch;
	}

	public String getAmndrNm() {
		return amndrNm;
	}

	public void setAmndrNm(String amndrNm) {
		this.amndrNm = amndrNm;
	}
}