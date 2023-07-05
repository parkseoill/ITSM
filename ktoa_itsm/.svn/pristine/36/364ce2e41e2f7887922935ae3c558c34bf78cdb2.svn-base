package truebon.com.sys.scu.service.impl;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Base64;
import java.util.List;
import java.util.Base64.Decoder;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import truebon.com.sys.scu.dao.SecureDAO;
import truebon.com.sys.scu.model.Secure;
import truebon.com.sys.scu.model.SecureVO;
import truebon.com.sys.scu.service.SecureService;

/**
 * 담당자를 위한 서비스 구현 클래스
 * @author 조경민
 * @since 2022.07.29
 * @version 1.0
 * @see
 *  
* <pre>
 * << 개정이력(Modification Information) >>
 *   
 *  수정일               수정자            수정내용
 *  ----------   --------   ---------------------------
 *  2022.07.29   조경민           최초 생성
 *
 * </pre>
 */

@Service("SecureService")
public class SecureServiceImpl extends EgovAbstractServiceImpl implements SecureService{

	private static final Logger LOGGER = LoggerFactory.getLogger(SecureServiceImpl.class);

	@Resource(name = "SecureDAO")
	private SecureDAO secureDAO;
	
	
	 /**
	 * tb_secure목록을 조회한다.
	 * @param vo - 조회할 정보가 담긴 SecureVO
	 * @return 조회한 tb_secure
	 * @exception Exception
	 */
	@Override
	public List<SecureVO> selectSecureList(SecureVO vo) throws Exception{
		List<SecureVO> SecureList = secureDAO.selectSecureList(vo);
		for(SecureVO secureVO : SecureList){
			  // 사인이 있는경우와 없는 경우
			  if(secureVO.getUserSign() != null && secureVO.getUserSign().length != 0) {
				  Decoder decoder = Base64.getDecoder(); 
				  // 복호화(쿼리에서 SUBSTRING(uc.USER_SIGN,27) 으로 앞부분 잘라낸 SVG base64 정보) 
				  byte[] bUserSign = decoder.decode(secureVO.getUserSign()); 
				  // byte[] 사인 값 String값으로 저장
				  String strUserSign = new String(bUserSign,"UTF-8");
				  
				  secureVO.setStrUserSign(strUserSign); 
			  }else { 
				  String strUserSign = secureVO.getConfrName(); 
				  secureVO.setStrUserSign(strUserSign); 
			  }
		  }
		return SecureList;
	}
	
	/*
	 * tb_secure 등록
	 * @param vo - 등록할 정보가 담긴 Secure
	 * @exception Exception
	 * */
	@Override
	public void insertSecure(Secure vo) throws Exception{
		LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
		vo.setRegstrId(user.getId());
		vo.setAmndrId(user.getId());
		secureDAO.insertSecure(vo);
	}
	
	/**
	 * tb_secure을 조회한다.
	 * @param secureVO - 조회할 정보가 담긴 SecureVO
	 * @return 조회한 tb_secure
	 * @exception Exception
	 */
	@Override
	public SecureVO selectSecure(SecureVO vo) throws Exception{
		
		SecureVO resultVO = secureDAO.selectSecure(vo);
			try {
				if (resultVO.getUserSign() != null && resultVO.getUserSign().length != 0) {
					String strUserSign = new String(resultVO.getUserSign(), "UTF-8");
					resultVO.setStrUserSign(strUserSign);
				} else {
					String strUserSign = resultVO.getConfrName();
					resultVO.setStrUserSign(strUserSign);
				}
			} catch (NullPointerException e) {
				// insert시 중복되는 값이 없으면 실행
			}
			
		return resultVO;
		
	}
	
	/**
	 * tb_secure을 삭제한다.
	 * @param secureVO - 조회할 정보가 담긴 SecureVO
	 * @exception Exception
	 */
	@Override
	public void deleteSecure(Secure vo) throws Exception{
		System.out.println(vo.getInspDate());
		System.out.println(vo.getSecurInspLoacatCd());
    	secureDAO.deleteSecure(vo);
	}
	
	/**
	 * tb_secure을 수정한다.
	 * @param secureVO - 조회할 정보가 담긴 SecureVO
	 * @exception Exception
	 */
	@Override
	public void updateSecure(SecureVO vo) throws Exception{
		LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
    	vo.setAmndrId(user.getId());
    	
    	secureDAO.updateSecure(vo);
	}
	
	/**
	 * tb_secure을 수정한다.
	 * @param secureVO - 조회할 정보가 담긴 SecureVO
	 * @exception Exception
	 */
	@Override
	public void updateConfrSign(SecureVO vo) throws Exception{
		// 로그인 객체 선언
		LoginVO user = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
		vo.setAmndrId(user.getId());
		
		secureDAO.updateConfrSign(vo);
	}
	
    /**
	 * tb_secure 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 SecureVO
	 * @return tb_secure 갯수
	 * @exception
	 */
    public int selectSecureCnt(SecureVO vo) {
		return secureDAO.selectSecureCnt(vo);
	}
	
}
