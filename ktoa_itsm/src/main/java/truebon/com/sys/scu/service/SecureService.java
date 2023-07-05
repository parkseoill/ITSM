package truebon.com.sys.scu.service;

import java.util.List;

import truebon.com.sys.scu.model.Secure;
import truebon.com.sys.scu.model.SecureVO;

/**
 * 보안관리를 위한 서비스 인터페이스 클래스
 * @author 조경민
 * @since 2022.07.29
 * @version 1.0
 * @see
 *  
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *  수정일		수정자	 수정내용
 *  ----------   --------   ---------------------------
 *  2022.07.29	조경민	최초 생성
 *
 * </pre>
 */

public interface SecureService {

	/**
	 * tb_secure을 조회한다.
	 * @param secureVO - 조회할 정보가 담긴 SecureVO
	 * @return 조회한 tb_secureList
	 * @exception Exception
	 */
	List<SecureVO> selectSecureList(SecureVO vo) throws Exception;
	
	/*
	 * tb_secure 등록
	 * @param vo - 등록할 정보가 담긴 Secure
	 * @exception Exception
	 * */
	void insertSecure(Secure vo) throws Exception;
	
	/**
	 * tb_secure을 조회한다.
	 * @param secureVO - 조회할 정보가 담긴 SecureVO
	 * @return 조회한 tb_secure
	 * @exception Exception
	 */
	SecureVO selectSecure(SecureVO secureVO) throws Exception;
	
	/**
	 * tb_secure을 삭제한다.
	 * @param secureVO - 조회할 정보가 담긴 SecureVO
	 * @exception Exception
	 */
	void deleteSecure(Secure secureVO) throws Exception;
	
	/**
	 * tb_secure을 수정한다.
	 * @param secureVO - 조회할 정보가 담긴 SecureVO
	 * @exception Exception
	 */
	void updateSecure(SecureVO secureVO) throws Exception;
	
	/**
	 * 확인자를 수정한다.
	 * @param secureVO - 조회할 정보가 담긴 SecureVO
	 * @exception Exception
	 */
	void updateConfrSign(SecureVO secureVO) throws Exception;
	
    /**
	 * 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 SecureVO
	 * @exception
	 */
    int selectSecureCnt(SecureVO vo);
}
