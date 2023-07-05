package truebon.com.dlm.dla.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import truebon.com.dlm.cod.dao.ComnDateDAO;
import truebon.com.dlm.cod.model.ComnDateVO;
import truebon.com.dlm.dla.dao.DlalzDAO;
import truebon.com.dlm.dla.model.Dlalz;
import truebon.com.dlm.dla.model.DlalzVO;
import truebon.com.dlm.dla.service.DlalzService;
import truebon.com.sys.chr.dao.ChargerDAO;
import truebon.com.sys.chr.model.ChargerVO;



@Service("DlalzService")
public class DlalzServiceImpl extends EgovAbstractServiceImpl implements DlalzService {

   private static final Logger LOGGER = LoggerFactory.getLogger(DlalzServiceImpl.class);

   @Resource(name = "DlalzDAO")
   private DlalzDAO dlalzDAO;

   @Resource(name="ChargerDAO")
    private ChargerDAO chargerDAO;
   
   @Resource(name="ComnDateDAO")
   private ComnDateDAO comnDateDAO;
   
   /**
    * tb_dlalz을 등록한다.
    * 
    * @param vo - 등록할 정보가 담긴 Dlalz
    * @exception Exception
    */
   public void insertDlalz(Dlalz vo) throws Exception {
      Dlalz dvo = null;
      // 로그인 객체 선언
      LoginVO user = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
      
      //공통일자 날짜와 공휴일 코드 불러오기
      ComnDateVO cDVo = new ComnDateVO();
      cDVo.setSelectedDate(vo.getSelectedDate());
      List<ComnDateVO> comnDateList = comnDateDAO.selectHdayCd(cDVo);
      
      //담당자 리스트 불러오기 
      List<ChargerVO> nameList = dlalzDAO.selectNotExistChargerList(((DlalzVO) vo));
       
      
      for(int i=0;i<nameList.size();i++) {
         dvo = new Dlalz();
         dvo.setRegstrId(user.getId());
         dvo.setChrgrNo(nameList.get(i).getChrgrNo());
         if(nameList.get(i).getChrgrRoleCd().equals("04")) { //OP의 경우
            dvo.setOffdayTypeCd("2");  //대휴
            dvo.setDlalzDstnctCd("2"); //전일 휴무
            dvo.setWrkTypeCd(null);
            dvo.setWrkTimeCd(null);
            for(int j=0;j<comnDateList.size();j++) {
               dvo.setDlalzDate(comnDateList.get(j).getStdrDate());
               dlalzDAO.insertDlalz(dvo);
            }
         }else {
            
            for(int z=0;z<comnDateList.size();z++) {
               if(comnDateList.get(z).getHdayDstnctCd().equals("1")) {
                  dvo.setDlalzDstnctCd("1"); //전일 근무
                  dvo.setWrkTypeCd("1"); //사무실 근무
                  dvo.setWrkTimeCd("1"); //주간 근무
                  dvo.setOffdayTypeCd(null);
               }else {
                  dvo.setDlalzDstnctCd("2"); //전일 휴무
                  dvo.setOffdayTypeCd("4"); //공휴일 
                  dvo.setWrkTypeCd(null);
                  dvo.setWrkTimeCd(null);
               }
               dvo.setDlalzDate(comnDateList.get(z).getStdrDate());
               dlalzDAO.insertDlalz(dvo);
            }
         }
      }
   }

   /**
    * tb_dlalz을 수정한다.
    * 
    * @param vo - 수정할 정보가 담긴 Dlalz
    * @return void형
    * @exception Exception
    */
   public void updateDlalz(Dlalz vo) throws Exception {
      // 로그인 객체 선언
      LoginVO user = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
      vo.setAmndrId(user.getId());
      System.out.println("service1");
      dlalzDAO.updateDlalz(vo);
   }


   /**
    * tb_dlalz을 조회한다.
    * 
    * @param vo - 조회할 정보가 담긴 DlalzVO
    * @return 조회한 tb_dlalz
    * @exception Exception
    */
   public DlalzVO selectDlalz(DlalzVO vo) throws Exception {
      DlalzVO resultVO = dlalzDAO.selectDlalz(vo);
      if (resultVO == null)
         throw processException("info.nodata.msg");
      return resultVO;
   }

   /**
    * tb_dlalz 목록을 조회한다.
    * 
    * @param searchVO - 조회할 정보가 담긴 VO
    * @return tb_dlalz 목록
    * @exception Exception
    */
   public List<DlalzVO> selectDlalzList(DlalzVO searchVO) throws Exception {
   
      LoginVO user = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
      if(user.getAuthorCode().equals("ROLE_USER")) {
         if(searchVO.getSearchKeyword() == "")
            searchVO.setSearchKeyword(user.getChrgrNo()); 
      }
      LocalDate currentdate = LocalDate.now();
       if(searchVO.getSelectedDate() == "") {
       searchVO.setSelectedDate(currentdate.format(DateTimeFormatter.ofPattern("yyyy-MM")));
          }
       
      return dlalzDAO.selectDlalzList(searchVO);
   }

   /**
    * tb_dlalz 총 갯수를 조회한다. @param searchVO - 조회할 정보가 담긴 VO @return tb_dlalz 총
    * 갯수 @exception
    */
   public int selectDlalzListTotCnt(DlalzVO searchVO) {
      return dlalzDAO.selectDlalzListTotCnt(searchVO);
   }
   
   /**
    * tb_dlalz 목록을 조회한다.
    * 
    * @param searchVO - 조회할 정보가 담긴 VO
    * @return tb_dlalz 목록
    * @exception Exception
    */
   public List<ChargerVO> selectNotExistChargerList(DlalzVO searchVO) throws Exception {
      return dlalzDAO.selectNotExistChargerList(searchVO);
   }

    /**
       * tb_dlalz에 checkDate가 있는지 체크한다.
       * @param checkDate - 조회할 날짜
       * @return 등록 여부 값 (0이면 등록가능)
       * @exception
    */
    public int selectNotExistChargerListTotCnt(DlalzVO searchVO) {
       return dlalzDAO.selectNotExistChargerListTotCnt(searchVO);
    }
    
    
   /**
    * tb_replaceOffday 대휴를 등록한다.
    * 
    * @param vo - 등록할 정보가 담긴 Dlalz
    * @exception Exception
    */
    public void insertReOffday(DlalzVO vo) throws Exception {
       dlalzDAO.insertReOffday(vo);
    }
    
   /**
    * tb_replaceOffday 대휴를 수정한다.
    * 
    * @param vo - 수정할 정보가 담긴 Dlalz
    * @return void형
    * @exception Exception
    */
   public void updateReOffday(Dlalz vo) throws Exception {
      dlalzDAO.updateReOffday(vo);
   }
   
   /**
    * tb_replaceOffday 대휴를 수정한다.
    * 
    * @param vo - 수정할 정보가 담긴 Dlalz
    * @return void형
    * @exception Exception
    */
   public void deleteReOffday(Dlalz vo) throws Exception {
      dlalzDAO.deleteReOffday(vo);
   }
   
}