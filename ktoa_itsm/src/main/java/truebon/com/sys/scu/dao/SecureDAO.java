package truebon.com.sys.scu.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import truebon.com.sys.scu.model.Secure;
import truebon.com.sys.scu.model.SecureVO;

/**
 * 보안관리에 대한 DAO 클래스를 정의한다
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
 *  2022.07.29	조경민	최초 생성
 *
 * </pre>
 */

@Repository("SecureDAO")
public class SecureDAO extends EgovComAbstractDAO {

	/**
	 * tb_secure 보안점검목록을 조회한다.
	 * @param vo - 조회할 정보가 담긴 secureVO
	 * @return  tb_secure 목록
	 * @exception Exception
	 */
	public List<SecureVO> selectSecureList(SecureVO vo) throws Exception {
		return selectList("SecureMapper.selectSecureList", vo);
	}

	/*
	 * tb_secure 등록
	 * @param vo - 등록할 정보가 담긴 Secure
	 * @exception Exception
	 * */
	public void insertSecure(Secure vo) throws Exception {
		insert("SecureMapper.insertSecure", vo);
	}

	/**
	 * tb_secure을 조회한다.
	 * @param secureVO - 조회할 정보가 담긴 SecureVO
	 * @return 조회한 tb_secure
	 * @exception Exception
	 */
	public SecureVO selectSecure(SecureVO vo) throws Exception {
			return (SecureVO)selectOne("SecureMapper.selectSecure", vo);
	}

	/**
	 * tb_secure을 삭제한다.
	 * @param secureVO - 조회할 정보가 담긴 SecureVO
	 * @exception Exception
	 */
	public void deleteSecure(Secure vo) throws Exception {
		delete("SecureMapper.deleteSecure", vo);
	}

	/**
	 * tb_secure을 수정한다.
	 * @param secureVO - 조회할 정보가 담긴 SecureVO
	 * @exception Exception
	 */
	public void updateSecure(SecureVO vo) throws Exception {
		update("SecureMapper.updateSecure", vo);
	}
	
	/**
	 * 확인자를 수정한다.
	 * @param secureVO - 조회할 정보가 담긴 SecureVO
	 * @exception Exception
	 */
	public void updateConfrSign(SecureVO vo) throws Exception {
		update("SecureMapper.updateConfrSign", vo);
	}
	
	/**
	 * 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map 
	 * 갯수 @exception
	 */
	public int selectSecureCnt(SecureVO vo) {
		return (Integer)selectOne("SecureMapper.selectSecureCnt", vo);
	}
	
}
