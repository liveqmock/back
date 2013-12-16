package com.ihk.customer.collection.action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import com.ihk.customer.collection.pojo.*;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.SessionUser;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.customer.collection.IVipCustImpMapper;
import com.ihk.customer.collection.IVipCustItemMapper;
import com.ihk.customer.collection.IVipCustMapper;
import com.ihk.customer.collection.IVipCustdealMapper;
import com.ihk.customer.collection.IVipCustomerMapper;
import com.ihk.customer.collection.XLSExport;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.SupperAction;
@SuppressWarnings("serial")
public class AnalysisOriginalDataAction extends SupperAction{
    private final Logger logger = Logger.getLogger(AnalysisOriginalDataAction.class);

    @Autowired IVipCustImpMapper iVipCustImpMapper;
    @Autowired IVipCustMapper iVipCustMapper;
    @Autowired IVipCustdealMapper iVipCustdealMapper;
    @Autowired IVipCustomerMapper iVipCustomerMapper;
    @Autowired IVipCustItemMapper iVipCustItemMapper;
    VipCustImpCond vipCustImpCond;
    VipCustCond vipCustCond;
    private JSONObject result;
    private JSONObject details;

    public JSONObject getDetails() {
        return details;
    }

    public void setDetails(JSONObject details) {
        this.details = details;
    }

    //统计详细人员
    List<Integer> on_1 = new ArrayList<Integer>();
    List<Integer> on_2 = new ArrayList<Integer>();
    List<Integer> tw_1 = new ArrayList<Integer>();
    List<Integer> tw_2 = new ArrayList<Integer>();
    List<Integer> tw_3 = new ArrayList<Integer>();
    List<Integer> th_1 = new ArrayList<Integer>();
    List<Integer> th_2 = new ArrayList<Integer>();
    List<Integer> th_3 = new ArrayList<Integer>();
    List<Integer> mr_1 = new ArrayList<Integer>();
    List<Integer> mr_2 = new ArrayList<Integer>();
    List<Integer> mr_3 = new ArrayList<Integer>();

    List<Integer> on = new ArrayList<Integer>();
    List<Integer> tw = new ArrayList<Integer>();
    List<Integer> th = new ArrayList<Integer>();
    List<Integer> mr = new ArrayList<Integer>();

    List<Integer> tw_11 = new ArrayList<Integer>();
    List<Integer> tw_12 = new ArrayList<Integer>();
    List<Integer> tw_21 = new ArrayList<Integer>();
    List<Integer> tw_22 = new ArrayList<Integer>();
    List<Integer> tw_31 = new ArrayList<Integer>();
    List<Integer> tw_32 = new ArrayList<Integer>();
    List<Integer> tw_41 = new ArrayList<Integer>();
    List<Integer> tw_42 = new ArrayList<Integer>();

    /**
     * 整理原始表vip_cust_imp的数据
     * @return
     * @throws Exception
     */
    public String analysisData() throws Exception {
        if(vipCustImpCond == null){
            vipCustImpCond = new VipCustImpCond();
        }

        vipCustImpCond.setCompanyId(SessionUser.getCompanyId());
        vipCustImpCond.setIsArrange("T");
        vipCustImpCond.setIsDeleted("0");
        vipCustImpCond.setFlag(0);
        List<VipCustImp> vips = iVipCustImpMapper.findVipCustImp(vipCustImpCond);

        if(vips.size() > 0){
            splitVipCustImp(vips);
        }
        return SUCCESS;
    }

    /**
     * 根据不同情况的分割符 将字符分割
     * @param str
     * @return
     */
    public static String[] splitFullStr(String str)
    {
        String[] result = new String[]{};
        String idcardNo = "";

        //将所有分割符改为逗号隔开

        //中文逗号替换
        idcardNo = str.replaceAll("，", ",");
        //顿号分割
        idcardNo = idcardNo.replaceAll("、", ",");
        //空格分割
        idcardNo = idcardNo.replaceAll(" ", ",");
        String cnt[] = idcardNo.split(",");

        //用StringBuffer来存放数组中的非空元素，用“;”分隔
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<cnt.length; i++) {
            if("".equals(cnt[i].trim())) {
                continue;
            }
            sb.append(cnt[i]);
            if(i != cnt.length - 1) {
                sb.append(";");
            }
        }
        //用String的split方法分割，得到数组
        result = sb.toString().split(";");

        return result;
    }

    public static void main(String args[]){
        String a = "440106196510092017     44010196707021261、   128912012,234249，  234820348";
        String aa[] = splitFullStr(a);
        for(int i=0;i<aa.length;i++){
            System.out.println("."+aa[i]+".");
        }
    }

    /**
     * 将原始表的数据拆分到每个表中
     * @param vipCustImpList
     */
    @SuppressWarnings({ "unchecked", "rawtypes", "unused" })
    public void splitVipCustImp(List<VipCustImp> vipCustImpList){
        if(vipCustImpList == null) vipCustImpList = new ArrayList();

        List<VipCust> vipCustList = new ArrayList();

        List<VipCustdeal> vipCustDealList = new ArrayList();
        for(int i=0; i<vipCustImpList.size();i++){
            VipCustImp vipCustImp = vipCustImpList.get(i);
            //交易表vipcustdeal
            VipCustdeal vipCustdeal = new VipCustdeal();

            //基础客户表vipcust
            String[] customerName = vipCustImp.getCustomerName().split(",");
            String[] phone = splitFullStr(vipCustImp.getPhone());
            VipCust vipCust = new VipCust();

            //判断客户身份证
            if(vipCustImp.getIdcardNo()!=null && vipCustImp.getIdcardNo().length()>0){
                String[] idcardNo = vipCustImp.getIdcardNo().split(",");
                for(int j=0; j<idcardNo.length; j++){
                    if(idcardNo[j] == null||idcardNo[j].equals("")){
                        continue;
                    }
                    //if(vipCustCond == null)
                    vipCustCond = new VipCustCond();
                    vipCustCond.setIdcardNo(idcardNo[j]);
                    vipCustCond.setCustomerName(null);
                    vipCustCond.setCompanyId(vipCustImp.getCompanyId());

                    List<VipCust> cust = iVipCustMapper.findVipCust(vipCustCond);
                    if(cust.size() > 0){
                        vipCustdeal.setRefId(cust.get(0).getId());
                    }else{

                        //基础客户表
                        vipCust.setCompanyId(SessionUser.getCompanyId());
                        vipCust.setContactAddr(vipCustImp.getContactAddr());
                        if(j < customerName.length) {
                            vipCust.setCustomerName(customerName[j]);
                        }
                        vipCust.setCustomerNo(vipCustImp.getCustomerNo());
                        vipCust.setIdcardNo(idcardNo[j]);
                        vipCust.setnatives(vipCustImp.getNatives());

                        vipCust.setResidArea(vipCustImp.getResideArea());
                        vipCust.setWordArea(vipCustImp.getWordArea());
                        vipCust.setAd_area(vipCustImp.getAdArea());
                        vipCust.setSource(vipCustImp.getSource());
                        vipCust.setCreatedate(new Date());
                        vipCust.setDeal_date(vipCustImp.getDealDate());
                        vipCust.setCustomerNo(vipCustImp.getId()+"");   //按imp id 定义一个客户ID
                        if(j<phone.length)
                            vipCust.setPhone(phone[j]);
                        iVipCustMapper.addVipCust(vipCust);
                        vipCustdeal.setRefId(vipCust.getId());

                    }

                    vipCustdeal.setAreaSize(vipCustImp.getAreaSize());
                    vipCustdeal.setCreatedate(new Date());
                    vipCustdeal.setDealDate(vipCustImp.getDealDate());
                    vipCustdeal.setProjectName(vipCustImp.getProjectName());
                    vipCustdeal.setTotal(vipCustImp.getTotal());
                    vipCustdeal.setAdArea(vipCustImp.getAdArea());
                    vipCustdeal.setBusinesscircle(vipCustImp.getBusinesscircle());
                    vipCustdeal.setPaymethod(vipCustImp.getPaymethod());
                    vipCustdeal.setCustImpId(vipCustImp.getId());
                    vipCustdeal.setConstructtype(vipCustImp.getConstructtype());
                    vipCustdeal.setArea(vipCustImp.getArea());
                    vipCustdeal.setBuilding(vipCustImp.getBuilding());
                    vipCustdeal.setFloor(vipCustImp.getFloor());
                    vipCustdeal.setRoom_no(vipCustImp.getRoom_no());
                    vipCustdeal.setConstruction_area(vipCustImp.getConstruction_area());
                    iVipCustdealMapper.addVipCustdeal(vipCustdeal);

                    vipCustImp.setIsArrange("F");
                    iVipCustImpMapper.updateVipCustImp(vipCustImp);
                }
            } else {
                //身份证为空 ，按客户姓名查

                vipCustCond = new VipCustCond();
                vipCustCond.setCustomerName(vipCustImp.getCustomerName());

                List<VipCust> cust = iVipCustMapper.findVipCust(vipCustCond);
                if(cust.size() > 0){
                    vipCustdeal.setRefId(cust.get(0).getId());
                }else{
                    //基础客户表
                    vipCust.setCompanyId(SessionUser.getCompanyId());
                    vipCust.setContactAddr(vipCustImp.getContactAddr());

                    vipCust.setCustomerName(vipCustImp.getCustomerName());

                    vipCust.setCustomerNo(vipCustImp.getCustomerNo());
                    vipCust.setIdcardNo(vipCustImp.getIdcardNo());
                    vipCust.setnatives(vipCustImp.getNatives());

                    vipCust.setResidArea(vipCustImp.getResideArea());
                    vipCust.setWordArea(vipCustImp.getWordArea());
                    vipCust.setAd_area(vipCustImp.getAdArea());
                    vipCust.setSource(vipCustImp.getSource());
                    vipCust.setCreatedate(new Date());
                    vipCust.setDeal_date(vipCustImp.getDealDate());

                    vipCust.setCustomerNo(vipCustImp.getId()+"");  //按imp id 定义一个客户ID

                    vipCust.setPhone(vipCustImp.getPhone());
                    iVipCustMapper.addVipCust(vipCust);
                    vipCustdeal.setRefId(vipCust.getId());
                }
                vipCustdeal.setAreaSize(vipCustImp.getAreaSize());
                vipCustdeal.setCreatedate(new Date());
                vipCustdeal.setDealDate(vipCustImp.getDealDate());
                vipCustdeal.setProjectName(vipCustImp.getProjectName());
                vipCustdeal.setTotal(vipCustImp.getTotal());
                vipCustdeal.setAdArea(vipCustImp.getAdArea());
                vipCustdeal.setBusinesscircle(vipCustImp.getBusinesscircle());
                vipCustdeal.setPaymethod(vipCustImp.getPaymethod());
                vipCustdeal.setCustImpId(vipCustImp.getId());
                vipCustdeal.setConstructtype(vipCustImp.getConstructtype());
                vipCustdeal.setArea(vipCustImp.getArea());
                vipCustdeal.setBuilding(vipCustImp.getBuilding());
                vipCustdeal.setFloor(vipCustImp.getFloor());
                vipCustdeal.setRoom_no(vipCustImp.getRoom_no());
                vipCustdeal.setConstruction_area(vipCustImp.getConstruction_area());
                iVipCustdealMapper.addVipCustdeal(vipCustdeal);


                vipCustImp.setIsArrange("F");
                iVipCustImpMapper.updateVipCustImp(vipCustImp);
            }

        }
    }

    /**
     * 统计
     * @return
     * @throws Exception
     */
    @SuppressWarnings({ "rawtypes", "unused", "unchecked"})
    public String statistics() throws Exception{
        VipCustdealCond vipCustdealCond = new VipCustdealCond();
		/**/
        int Ocount = 0,Tcount = 0,Hcount = 0,Mcount = 0;
        int Odcount = 0,Tdcount = 0,Hdcount = 0,Mdcount = 0;
        int Tmcount = 0,Hmcount = 0,Mmcount = 0;

        //maoNdate 查询所有次数的统计结果
        String date1 = request.getParameter("date1");
        String date2 = request.getParameter("date2");
        if (!CommonUtils.isStrEmpty(date1)){
            vipCustdealCond.setDate1(date1);
        }
        if (!CommonUtils.isStrEmpty(date2)){
            vipCustdealCond.setDate2(CommonUtils.getAfterDate(CommonUtils.getDateFromString(date2),1));
        }
        vipCustdealCond.setCompanyId(SessionUser.getCompanyId());
        List<Map> mapNdate = iVipCustdealMapper.findVipCustdealgroup(vipCustdealCond);

        //分别按照次数拆分
        for(int i=0;i<mapNdate.size();i++){
            //一次购买宗数
            if(Integer.parseInt(String.valueOf(mapNdate.get(i).get("count"))) == 1){

                Ocount++; //购买一个代理项目的数量累加
                on_1.add(Integer.parseInt(String.valueOf(mapNdate.get(i).get("refId"))));
            }
            //两次购买
            if(Integer.parseInt(String.valueOf(mapNdate.get(i).get("count"))) == 2){
                Tcount ++; //购买总数
                if(Integer.parseInt(String.valueOf(mapNdate.get(i).get("discount"))) == 1)
                {
                    Tdcount++; //购买一个代理项目的数量累加
                    tw_1.add(Integer.parseInt(String.valueOf(mapNdate.get(i).get("refId"))));
                }
                else
                {
                    Tmcount++; //购买两个以上(包含两个)代理项目的数量累加
                    tw_2.add(Integer.parseInt(String.valueOf(mapNdate.get(i).get("refId"))));
                }
            }
            //三次购买
            if(Integer.parseInt(String.valueOf(mapNdate.get(i).get("count"))) == 3){
                Hcount++; //购买总数
                if(Integer.parseInt(String.valueOf(mapNdate.get(i).get("discount"))) == 1)
                {
                    Hdcount++; //购买一个代理项目的数量累加
                    th_1.add(Integer.parseInt(String.valueOf(mapNdate.get(i).get("refId"))));
                }
                else
                {
                    Hmcount++; //购买两个以上(包括两个)代理项目的数量累加
                    th_2.add(Integer.parseInt(String.valueOf(mapNdate.get(i).get("refId"))));
                }
            }
            //三次以上购买
            if(Integer.parseInt(String.valueOf(mapNdate.get(i).get("count"))) > 3){
                Mcount++; //购买总数
                if(Integer.parseInt(String.valueOf(mapNdate.get(i).get("discount"))) == 1)
                {
                    Mdcount++; //购买一个代理项目的数量累加
                    mr_1.add(Integer.parseInt(String.valueOf(mapNdate.get(i).get("refId"))));
                }
                else
                {
                    Mmcount++; //购买两个以上(包括两个)代理项目的数量累加
                    mr_2.add(Integer.parseInt(String.valueOf(mapNdate.get(i).get("refId"))));
                }
            }

        }

        List<Integer> adlist = new ArrayList<Integer>();
        List<Map> map = new ArrayList<Map>();
        int Ots = 0, Tts = 0, Hts = 0, Mts = 0; //一次，二次，三次，三次以上
        //套数统计方案一
        for(int m=0;m<mapNdate.size();m++){
            Map mN = mapNdate.get(m);
            VipCustdealCond dealcond = new VipCustdealCond();
            dealcond.setRefId(Integer.parseInt(mN.get("refId").toString()));
            List<VipCustdeal> deal = iVipCustdealMapper.findVipCustdeal(dealcond); //获取交易楼盘
            if(deal != null&&!deal.isEmpty()){
                for(int i=0;i<deal.size();i++) {
                    //要对联合购买的用户进行删除
                    VipCustdealCond cnd = new VipCustdealCond();
                    cnd.setCustImpId(deal.get(i).getCustImpId()); //与原始表id一致（导入时生成）
                    List<VipCustdeal> mapImp = iVipCustdealMapper.findVipCustdeal(cnd);    //通过导入id获取联合购买交易
                    if(mapImp != null && mapImp.size()>1) {
                        // >1 有重复的数据
                        for(int j=0;j<mapImp.size();j++) {
                            VipCustdeal vcdImp = mapImp.get(j);
                            if (vcdImp.getRefId()==deal.get(i).getRefId()){
                                //nothing
                            } else {
                                for(int n=m+1;n<mapNdate.size();n++) {
                                    Map nN = mapNdate.get(n);
                                    if(vcdImp.getRefId() == Integer.parseInt(nN.get("refId").toString())){
                                        //找出重复
                                        adlist.add(n); //将所有重复需要减掉的n值放入集合

                                    }
                                }
                            }
                        }
                    }
                }

            }
        }


        if(!adlist.isEmpty()){

            for(int m=0;m<mapNdate.size();m++){
                Map mp = mapNdate.get(m);
                for(int n=0;n<adlist.size();n++){ //循环需要减1的客户
                    if(m == adlist.get(n)){
                        if(Integer.parseInt(mp.get("count").toString())>0){
                            mp.put("count", Integer.parseInt(mp.get("count").toString())-1);
                        }
                    }
                }
                map.add(mp);
            }
        }

        int Tts_11=0,Tts_12 = 0,Tts_21=0,Tts_22 = 0,Tts_31=0,Tts_32 = 0,Tts_41=0,Tts_42 = 0;

        //按套数统计
        for(int m=0;m<map.size(); m++) { //重新统计套数
            //一次购买宗数
            if(Integer.parseInt(String.valueOf(map.get(m).get("count"))) == 1){

                Ots++;
                on.add(Integer.parseInt(String.valueOf(map.get(m).get("refId"))));//一次购买客户表vip_cust的id集合
                if(Integer.parseInt(String.valueOf(mapNdate.get(m).get("discount"))) == 1){
                    //购买1个代理项目
                    Tts_11 = Tts_11 + 1;
                    tw_11.add(Integer.parseInt(String.valueOf(map.get(m).get("refId"))));
                } else {
                    //购买2个或多个代理项目
                    Tts_12 = Tts_12 + 1;
                    tw_12.add(Integer.parseInt(String.valueOf(map.get(m).get("refId"))));
                }

            }
            //两次购买
            else if(Integer.parseInt(String.valueOf(map.get(m).get("count"))) == 2){
                Tts = Tts + 2;
                tw.add(Integer.parseInt(String.valueOf(map.get(m).get("refId"))));//二次购买客户表的id集合
                if(Integer.parseInt(String.valueOf(mapNdate.get(m).get("discount"))) == 1){
                    //购买1个代理项目
                    Tts_21 = Tts_21 + 2;
                    tw_21.add(Integer.parseInt(String.valueOf(map.get(m).get("refId"))));
                } else {
                    //购买2个或多个代理项目
                    Tts_22 = Tts_22 + 2;
                    tw_22.add(Integer.parseInt(String.valueOf(map.get(m).get("refId"))));
                }

            }
            //三次购买
            else if(Integer.parseInt(String.valueOf(map.get(m).get("count"))) == 3){
                Hts = Hts + 3;
                th.add(Integer.parseInt(String.valueOf(map.get(m).get("refId"))));//三次购买客户表的id集合
                if(Integer.parseInt(String.valueOf(mapNdate.get(m).get("discount"))) == 1){
                    //购买1个代理项目
                    Tts_31 = Tts_31 + 3;
                    tw_31.add(Integer.parseInt(String.valueOf(map.get(m).get("refId"))));
                } else {
                    //购买2个或多个代理项目
                    Tts_32 = Tts_32 + 3;
                    tw_32.add(Integer.parseInt(String.valueOf(map.get(m).get("refId"))));
                }
            }
            //三次以上购买
            else if(Integer.parseInt(String.valueOf(map.get(m).get("count"))) > 3){
                Mts = Mts + Integer.parseInt(String.valueOf(map.get(m).get("count"))); //购买总数
                mr.add(Integer.parseInt(String.valueOf(map.get(m).get("refId"))));//三次以上够吗客户的id集合

                if(Integer.parseInt(String.valueOf(mapNdate.get(m).get("discount"))) == 1){
                    //购买1个代理项目
                    Tts_41 = Tts_41 + Integer.parseInt(String.valueOf(map.get(m).get("count")));
                    tw_41.add(Integer.parseInt(String.valueOf(map.get(m).get("refId"))));
                } else {
                    //购买2个或多个代理项目
                    Tts_42 = Tts_42 + Integer.parseInt(String.valueOf(map.get(m).get("count")));
                    tw_42.add(Integer.parseInt(String.valueOf(map.get(m).get("refId"))));
                }
            }
        }


        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        calendar.set(Calendar.YEAR, year - 3);

        //1次，2次，3次，3次以上
        int Docount = 0,Dtcount = 0, Dhcount = 0,Dmcount = 0;
        int Tts_13 =0 ,Tts_23 = 0, Tts_33 = 0,Tts_43 = 0;

        vipCustdealCond.setDealDate(calendar.getTime());
        //近三年内购买
        List<Map> mapNdatelimit = iVipCustdealMapper.findVipCustdealgroup(vipCustdealCond);

        List<Integer> adlist_ts = new ArrayList<Integer>();
        List<Map> map_ts = new ArrayList<Map>();

        for(int m=0;m<mapNdatelimit.size();m++){
            Map mN = mapNdatelimit.get(m);
            VipCustdealCond dealcond = new VipCustdealCond();
            dealcond.setRefId(Integer.parseInt(mN.get("refId").toString()));
            dealcond.setDate1(CommonUtils.getDateString(calendar.getTime()));
            List<VipCustdeal> deal = iVipCustdealMapper.findVipCustdeal(dealcond); //获取交易楼盘
            if(deal != null&&!deal.isEmpty()){
                for(int i=0;i<deal.size();i++) {
                    //要对联合购买的用户进行删除

                    VipCustdealCond cnd = new VipCustdealCond();
                    cnd.setCustImpId(deal.get(i).getCustImpId()); //与原始表id一致（导入时生成）
                    cnd.setDate1(CommonUtils.getDateString(calendar.getTime()));
                    List<VipCustdeal> mapImp = iVipCustdealMapper.findVipCustdeal(cnd);    //通过导入id获取联合购买交易
                    if(mapImp != null && mapImp.size()>1) {
                        // >1 有重复的数据
                        for(int j=0;j<mapImp.size();j++) {
                            VipCustdeal vcdImp = mapImp.get(j);
                            if (vcdImp.getRefId()==deal.get(i).getRefId()){
                                //nothing
                            } else {
                                for(int n=m+1;n<mapNdatelimit.size();n++) {
                                    Map nN = mapNdatelimit.get(n);
                                    if(vcdImp.getRefId() == Integer.parseInt(nN.get("refId").toString())){
                                        //找出重复
                                        adlist_ts.add(n); //将所有重复需要减掉的n值放入集合

                                    }
                                }
                            }
                        }
                    }
                }

            }
        }

        if(!adlist_ts.isEmpty()){
            for(int m=0;m<mapNdatelimit.size();m++){
                Map mp = mapNdatelimit.get(m);
                for(int n=0;n<adlist_ts.size();n++){ //循环需要减1的客户
                    if(m == adlist_ts.get(n)){
                        if(Integer.parseInt(mp.get("count").toString())==1){
                            mp.put("count", Integer.parseInt(mp.get("count").toString())-1);

                        } else if(Integer.parseInt(mp.get("count").toString())==2){
                            mp.put("count", Integer.parseInt(mp.get("count").toString())-1);

                        } else if(Integer.parseInt(mp.get("count").toString())==3){
                            mp.put("count", Integer.parseInt(mp.get("count").toString())-1);

                        } else if(Integer.parseInt(mp.get("count").toString())>3){
                            mp.put("count", Integer.parseInt(mp.get("count").toString())-1);

                        }
                    }
                }
                map_ts.add(mp);
            }
        }


        for(int i=0;i<map_ts.size();i++){
            int refId = Integer.parseInt(String.valueOf(map_ts.get(i).get("refId")));
            int icount = Integer.parseInt(String.valueOf(map_ts.get(i).get("count")));

            VipCustdealCond cnd = new VipCustdealCond();
            cnd.setDate1(CommonUtils.getDateString(calendar.getTime()));
            cnd.setRefId(refId);
            List<VipCustdeal> vipdeal = iVipCustdealMapper.findVipCustdeal(cnd);
            int ts =0;
            if(vipdeal != null && vipdeal.size()>0) {
                for(int j=0;j<vipdeal.size();j++) {
                    VipCustdeal vipCustdeal = vipdeal.get(j);
                    if (vipCustdeal.getRefId()==refId){
                        ts++;
                    }
                }
            }
            if(icount == 1){
                Docount++;
                on_2.add(refId);
                Tts_13 = Docount; //Tts_13 + ts;
            }

            if(icount == 2){
                Dtcount ++;
                tw_3.add(refId);
                Tts_23 = Tts_23 + ts;
            }
            if(icount == 3){
                Dhcount++;
                th_3.add(refId);
                Tts_33 = Tts_33 + ts;
            }
            if(icount > 3){
                Dmcount++;
                mr_3.add(refId);
                Tts_43 = Tts_43 + ts;
            }

        }

        //设置缓存
        request.getSession().setAttribute("on_1", on_1);
        request.getSession().setAttribute("on_2", on_2);
        request.getSession().setAttribute("tw_1", tw_1);
        request.getSession().setAttribute("tw_2", tw_2);
        request.getSession().setAttribute("tw_3", tw_3);
        request.getSession().setAttribute("th_1", th_1);
        request.getSession().setAttribute("th_2", th_2);
        request.getSession().setAttribute("th_3", th_3);
        request.getSession().setAttribute("mr_1", mr_1);
        request.getSession().setAttribute("mr_2", mr_2);
        request.getSession().setAttribute("mr_3", mr_3);
        request.getSession().setAttribute("on", on);
        request.getSession().setAttribute("tw", tw);
        request.getSession().setAttribute("th", th);
        request.getSession().setAttribute("mr", mr);
        request.getSession().setAttribute("tw_11", tw_11);
        request.getSession().setAttribute("tw_12", tw_12);
        request.getSession().setAttribute("tw_21", tw_21);
        request.getSession().setAttribute("tw_22", tw_22);
        request.getSession().setAttribute("tw_31", tw_31);
        request.getSession().setAttribute("tw_32", tw_32);
        request.getSession().setAttribute("tw_41", tw_41);
        request.getSession().setAttribute("tw_42", tw_42);

        JSONArray jsonArray = new JSONArray();
        JSONObject jsonobj = new JSONObject();
        jsonobj.put("itemid", "一次购买");
        jsonobj.put("countid", Ocount);
        jsonobj.put("liitem", Ocount);
        jsonobj.put("uitem", "--");
        jsonobj.put("aitem", Docount);
        jsonobj.put("ts", Ots);
        jsonobj.put("Tts_1", Tts_11);
        jsonobj.put("Tts_2", Tts_12);
        jsonobj.put("Tts_3", Tts_13);
        jsonArray.add(jsonobj);

        jsonobj.put("itemid", "两次购买");
        jsonobj.put("countid", Tcount);
        jsonobj.put("liitem", Tdcount);
        jsonobj.put("uitem", Tmcount);
        jsonobj.put("aitem", Dtcount);
        jsonobj.put("ts", Tts);
        jsonobj.put("Tts_1", Tts_21);
        jsonobj.put("Tts_2", Tts_22);
        jsonobj.put("Tts_3", Tts_23);
        jsonArray.add(jsonobj);

        jsonobj.put("itemid", "三次购买");
        jsonobj.put("countid", Hcount);
        jsonobj.put("liitem", Hdcount);
        jsonobj.put("uitem", Hmcount);
        jsonobj.put("aitem", Dhcount);
        jsonobj.put("ts", Hts);
        jsonobj.put("Tts_1", Tts_31);
        jsonobj.put("Tts_2", Tts_32);
        jsonobj.put("Tts_3", Tts_33);
        jsonArray.add(jsonobj);

        jsonobj.put("itemid", "三次以上购买");
        jsonobj.put("countid", Mcount);
        jsonobj.put("liitem", Mdcount);
        jsonobj.put("uitem", Mmcount);
        jsonobj.put("aitem", Dmcount);
        jsonobj.put("ts", Mts);
        jsonobj.put("Tts_1", Tts_41);
        jsonobj.put("Tts_2", Tts_42);
        jsonobj.put("Tts_3", Tts_43);
        jsonArray.add(jsonobj);

        jsonobj.put("itemid", "合计");
        jsonobj.put("countid", Ocount+Tcount+Hcount+Mcount);
        jsonobj.put("liitem", Ocount+Tdcount+Hdcount+Mdcount);
        jsonobj.put("uitem", Tmcount+Hmcount+Mmcount);
        jsonobj.put("aitem", Docount+Dtcount+Dhcount+Dmcount);
        jsonobj.put("ts", Ots+Tts+Hts+Mts);
        jsonobj.put("Tts_1", Tts_11+Tts_21+Tts_31+Tts_41);
        jsonobj.put("Tts_2", Tts_12+Tts_22+Tts_32+Tts_42);
        jsonobj.put("Tts_3", Tts_13+Tts_23+Tts_33+Tts_43);
        jsonArray.add(jsonobj);

        Map<String, Object> json = new HashMap<String, Object>();
        json.put("rows", jsonArray);
        result = JSONObject.fromObject(json);
        return SUCCESS;
    }

    public JSONObject getResult() {
        return result;
    }

    public void setResult(JSONObject result) {
        this.result = result;
    }

    /**
     * 点击统计结果 显示详细客户
     * @return
     * @throws Exception
     */
    @SuppressWarnings({ "unchecked", "rawtypes", "rawtypes" })
    public String analysisDetail() throws Exception{

        String row = request.getParameter("row");
        String index = request.getParameter("index");

        VipCustdealCond conds = new VipCustdealCond();
        if("0".equals(row)&&"0".equals(index))
            conds.setRefList((List<Integer>)request.getSession().getAttribute("on_1"));
        if("1".equals(row)&&"0".equals(index))
            conds.setRefList((List<Integer>)request.getSession().getAttribute("on_1"));
        if("3".equals(row)&&"0".equals(index))
            conds.setRefList((List<Integer>)request.getSession().getAttribute("on_2"));
        if("0".equals(row)&&"1".equals(index)){
            List<Integer> list = new ArrayList();
            list.addAll((List<Integer>)request.getSession().getAttribute("tw_1"));
            list.addAll((List<Integer>)request.getSession().getAttribute("tw_2"));
            conds.setRefList(list);
        }
        if("1".equals(row)&&"1".equals(index))
            conds.setRefList((List<Integer>)request.getSession().getAttribute("tw_1"));
        if("2".equals(row)&&"1".equals(index))
            conds.setRefList((List<Integer>)request.getSession().getAttribute("tw_2"));
        if("3".equals(row)&&"1".equals(index))
            conds.setRefList((List<Integer>)request.getSession().getAttribute("tw_3"));
        if("0".equals(row)&&"2".equals(index)){
            List<Integer> list = new ArrayList();
            list.addAll((List<Integer>)request.getSession().getAttribute("th_1"));
            list.addAll((List<Integer>)request.getSession().getAttribute("th_2"));
            conds.setRefList(list);
        }
        if("1".equals(row)&&"2".equals(index))
            conds.setRefList((List<Integer>)request.getSession().getAttribute("th_1"));
        if("2".equals(row)&&"2".equals(index))
            conds.setRefList((List<Integer>)request.getSession().getAttribute("th_2"));
        if("3".equals(row)&&"2".equals(index))
            conds.setRefList((List<Integer>)request.getSession().getAttribute("th_3"));
        if("0".equals(row)&&"3".equals(index)){
            List<Integer> list = new ArrayList();
            list.addAll((List<Integer>)request.getSession().getAttribute("mr_1"));
            list.addAll((List<Integer>)request.getSession().getAttribute("mr_2"));
            conds.setRefList(list);
        }
        if("1".equals(row)&&"3".equals(index))
            conds.setRefList((List<Integer>)request.getSession().getAttribute("mr_1"));
        if("2".equals(row)&&"3".equals(index))
            conds.setRefList((List<Integer>)request.getSession().getAttribute("mr_2"));
        if("3".equals(row)&&"3".equals(index))
            conds.setRefList((List<Integer>)request.getSession().getAttribute("mr_3"));

        if("4".equals(row)&&"0".equals(index))
            conds.setRefList((List<Integer>)request.getSession().getAttribute("on"));
        if("4".equals(row)&&"1".equals(index))
            conds.setRefList((List<Integer>)request.getSession().getAttribute("tw"));
        if("4".equals(row)&&"2".equals(index))
            conds.setRefList((List<Integer>)request.getSession().getAttribute("th"));
        if("4".equals(row)&&"3".equals(index))
            conds.setRefList((List<Integer>)request.getSession().getAttribute("mr"));

        if("5".equals(row)&&"0".equals(index))
            conds.setRefList((List<Integer>)request.getSession().getAttribute("tw_11"));
        if("5".equals(row)&&"1".equals(index))
            conds.setRefList((List<Integer>)request.getSession().getAttribute("tw_21"));
        if("5".equals(row)&&"2".equals(index))
            conds.setRefList((List<Integer>)request.getSession().getAttribute("tw_31"));
        if("5".equals(row)&&"3".equals(index))
            conds.setRefList((List<Integer>)request.getSession().getAttribute("tw_41"));

        if("6".equals(row)&&"0".equals(index))
            conds.setRefList((List<Integer>)request.getSession().getAttribute("tw_12"));
        if("6".equals(row)&&"1".equals(index))
            conds.setRefList((List<Integer>)request.getSession().getAttribute("tw_22"));
        if("6".equals(row)&&"2".equals(index))
            conds.setRefList((List<Integer>)request.getSession().getAttribute("tw_32"));
        if("6".equals(row)&&"3".equals(index))
            conds.setRefList((List<Integer>)request.getSession().getAttribute("tw_42"));

        //将条件设置到缓存
        request.getSession().setAttribute("cond", conds);
        int recordCount = 0;
        List<Map> map = new ArrayList();
        if(conds.getRefList().size() > 0){
            recordCount = iVipCustdealMapper.findVipCustdealCount(conds);
            HttpServletRequest re = ServletActionContext.getRequest();
            int rows = Integer.parseInt((re.getParameter("rows") == null) ? "10" : re.getParameter("rows"));
            int page = Integer.parseInt((re.getParameter("page") == null) ? "1" : re.getParameter("page"));
            conds.pageSize = rows;
            conds.startLine = (page - 1) * rows;

            String sort = request.getParameter("sort") ;
            String order = request.getParameter("order") ;
            if(sort!=null && sort.length()>0) {
                conds.setSort(sort);
                conds.setOrder(order);
            }
            conds.setCompanyId(SessionUser.getCompanyId());
            map = iVipCustdealMapper.findVipCustAndDeal(conds);
        }
        try{
            JSONArray jsonArray = new JSONArray();
            JSONObject jsonobj = new JSONObject();
            for(int i=0; i<map.size(); i++){
                jsonobj.put("projectName", map.get(i).get("projectName"));
                jsonobj.put("total", map.get(i).get("total"));
                jsonobj.put("areaSize", map.get(i).get("areaSize"));
                jsonobj.put("customerNo", map.get(i).get("customerNo"));
                jsonobj.put("customer_name", map.get(i).get("customerName"));
                jsonobj.put("idcard_no", map.get(i).get("idcardNo"));
                jsonobj.put("tel", map.get(i).get("tel"));
                jsonobj.put("phone", map.get(i).get("phone"));
                jsonobj.put("contactAddr", map.get(i).get("contactAddr"));
                jsonobj.put("resid_area", map.get(i).get("residArea"));
                jsonobj.put("word_area", map.get(i).get("wordArea"));
                jsonobj.put("natives", map.get(i).get("natives"));
                jsonobj.put("area", map.get(i).get("area"));
                jsonobj.put("building", map.get(i).get("building"));
                jsonobj.put("floor", map.get(i).get("floor"));
                jsonobj.put("room_no", map.get(i).get("room_no"));
                jsonobj.put("construction_area", map.get(i).get("construction_area"));
                jsonobj.put("deal_date", CommonUtils.getDateString((Date) map.get(i).get("dealDate")));
                jsonArray.add(jsonobj);
            }
            Map<String, Object> json = new HashMap<String, Object>();
            json.put("total", recordCount);// total键 存放总记录数，必须的
            json.put("rows", jsonArray);// rows键 存放每页记录 list
            details = JSONObject.fromObject(json);// 格式化details一定要是JSONObject
        }catch(Exception e){
            e.printStackTrace();
        }
        return SUCCESS;
    }
    //下载文件原始存放路径
    private final static String DOWNLOADFILEPATH="/upload/";
    //文件名参数变量
    private String fileName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    //如果下载文件名为中文，进行字符编码转换
    public String getDownloadChineseFileName() {
        String downloadChineseFileName = fileName;
        try {
            downloadChineseFileName = new String(downloadChineseFileName.getBytes(),"ISO8859-1");
        } catch(UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return downloadChineseFileName;
    }

    //导出  写入excel
    public InputStream getDownloadFile(){
        XLSExport export  =   new  XLSExport();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try{
            List<Map> map = new ArrayList();
            VipCustdealCond cond = (VipCustdealCond) request.getSession().getAttribute("cond");
            cond.setCompanyId(SessionUser.getCompanyId());
            cond.pageSize = 0;
            boolean flag = cond.getRefList().isEmpty();
            Iterator it = cond.getRefList().iterator();
            if(it.hasNext()){
                map = iVipCustdealMapper.findVipCustAndDeal(cond);
            }

            export.createRow( 0 );
            export.setCell(0,  "客户编号 ");
            export.setCell(1,  "客户姓名");
            export.setCell(2,  "身份证号");
            export.setCell(3,  "固话");
            export.setCell(4,  "移动电话");
            export.setCell(5,  "联系地址");
            export.setCell(6,  "居住区域");
            export.setCell(7,  "工作区域");
            export.setCell(8,  "户籍");
            export.setCell(9,  "项目名称");
            export.setCell(10,  "楼栋");
            export.setCell(11,  "组团");
            export.setCell(12,  "楼层");
            export.setCell(13,  "房号");
            export.setCell(14, "购买总价");
            export.setCell(15, "套内面积");
            export.setCell(16, "导入id");
            if(map.isEmpty()){
                return null;
            }
            for(int i=0;i<map.size();i++){
                export.createRow(i+1);
                export.setCell(0,  (String) map.get(i).get("customerNo"));
                export.setCell(1,  (String) map.get(i).get("customerName"));
                export.setCell(2,  (String) map.get(i).get("idcardNo"));
                export.setCell(3,  (String) map.get(i).get("tel"));
                export.setCell(4,  (String) map.get(i).get("phone"));
                export.setCell(5,  (String) map.get(i).get("contactAddr"));
                export.setCell(6,  (String) map.get(i).get("residArea"));
                export.setCell(7,  (String) map.get(i).get("wordArea"));
                export.setCell(8,  (String) map.get(i).get("natives"));
                export.setCell(9,  (String) map.get(i).get("projectName"));
                export.setCell(10, (String) map.get(i).get("building"));
                export.setCell(11, (String) map.get(i).get("area"));
                export.setCell(12, (String) map.get(i).get("floor"));
                export.setCell(13, (String) map.get(i).get("room_no"));
                export.setCell(14, ((Double) map.get(i).get("total")).doubleValue());
                export.setCell(15, ((Double)map.get(i).get("areaSize")).doubleValue());
                export.setCell(16, (Long)map.get(i).get("id") + "");  //字符方式保存
            }

            export.workbook.write(baos);
            map.clear();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        byte[] ba = baos.toByteArray();
        ByteArrayInputStream bais = new ByteArrayInputStream(ba);
        return bais;
    }

    //导出
    @SuppressWarnings("rawtypes")
    public String exportData() throws Exception{
        String fileName = "download-" + CustomerUtils.getNowForString() + "-.xls";
        setFileName(fileName);
        return SUCCESS;
    }

    /**
     * 一键转化为vip客户
     * @return
     * @throws Exception
     */
    public String analysisVipCustomer() throws Exception {

        List<VipCust> cust = new ArrayList<VipCust>();
        List<VipCustdeal> deal = new ArrayList<VipCustdeal>();
        int i_update = 0;
        int i_add = 0;
        try{
            //vipCust  vipCustdeal
            VipCustdealCond condition = new VipCustdealCond();
            VipCustImpCond vipcustimpcond =new VipCustImpCond();
            if(request.getSession().getAttribute("cond") != null)
                condition = (VipCustdealCond) request.getSession().getAttribute("cond");

            condition.setFlag(0);
            //查询到已选择的项目
            deal = iVipCustdealMapper.findVipCustdeal(condition);
            VipCustCond custCond = new VipCustCond();
            custCond.setRefList(condition.getRefList());

            if(custCond.getRefList() == null)   return SUCCESS;
            custCond.setCompanyId(SessionUser.getCompanyId());
            cust = iVipCustMapper.findVipCust(custCond);

            for(VipCust ct:cust){
                //判断vip管理的客户表是否含有这条记录
                VipCustomerCond cd = new VipCustomerCond();

                List<VipCustomer> customer ;

                //在vip用户里面查找
                cd.setCustomerName(ct.getCustomerName());
                cd.setCompanyId(SessionUser.getCompanyId());
                customer = iVipCustomerMapper.findVipCustomer(cd);

                //vip管理的客户表记录为空的情况,添加客户
                if(customer.size() > 0){
                    //已存在客户资料
                    for(VipCustdeal dl:deal){
                        if(dl.getRefId() == ct.getId()){
                            //判断是否存在交易记录
                            VipCustItemCond cond = new VipCustItemCond();
                            cond.setProjectName(dl.getProjectName());
                            cond.setArea(dl.getArea());
                            cond.setBuilding(dl.getBuilding());
                            cond.setFloor(dl.getFloor());
                            cond.setRoom_no(dl.getRoom_no());
                            cond.setCompanyId(SessionUser.getCompanyId());

                            //取原始表
                            vipcustimpcond.setCompanyId(SessionUser.getCompanyId());
                            vipcustimpcond.setId(dl.getCustImpId());
                            VipCustImp vipCustImp = iVipCustImpMapper.findVipCustImpById(vipcustimpcond);

                            cond.setCustomer_name(vipCustImp.getCustomerName());
                            int itemCount = iVipCustItemMapper.findVipCustItemCount(cond);
                            if(itemCount==0){
                                VipCustItem item = new VipCustItem();
                                item.setAreaSize(dl.getAreaSize());
                                item.setProjectName(dl.getProjectName());
                                item.setArea(dl.getArea());
                                item.setBuilding(dl.getBuilding());
                                item.setFloor(dl.getFloor());
                                item.setRoom_no(dl.getRoom_no());
                                item.setRefId(customer.get(0).getId());
                                item.setBusinesscircle(dl.getBusinesscircle());
                                item.setConstruction_area(dl.getConstruction_area());
                                item.setAdArea(dl.getAdArea());
                                item.setPaymethod(dl.getPaymethod());
                                item.setConstructtype(dl.getConstructtype());
                                item.setTotal(dl.getTotal());
                                //item.setCustomerNo(dl.getCustImpId()+"");

                                //取原始表
                                vipcustimpcond.setCompanyId(SessionUser.getCompanyId());
                                vipcustimpcond.setId(dl.getCustImpId());
                                VipCustImp vi = iVipCustImpMapper.findVipCustImpById(vipcustimpcond);

                                item.setSource(vi.getSource());
                                item.setCustomer_name(vi.getCustomerName());
                                item.setIdcard_no(vi.getIdcardNo());
                                item.setTel(vi.getTel());
                                item.setPhone(vi.getPhone());
                                item.setAttribute(vi.getAttribute());
                                item.setNatives(vi.getNatives());
                                item.setReside_area(vi.getResideArea());
                                item.setWord_area(vi.getWordArea());
                                item.setDeal_date(vi.getDealDate());
                                item.setCreatedate(vi.getCreatedate());

                                item.setCompanyId(SessionUser.getCompanyId());
                                iVipCustItemMapper.addVipCustItem(item);

                                i_update++;
                            }
                            //标记vipcustdeal(购买记录表) 已经转化为vip客户的购买记录 0未转化 1已转化
                            //dl.setFlag(1);
                            //iVipCustdealMapper.updateVipCustdeal(dl);
                        }
                    }
                } else {
                    //新增客户
                    VipCustomer cst = new VipCustomer();
                    cst.setContactAddr(ct.getContactAddr());
                    cst.setCreateTime(new Date());
                    cst.setCustomerName(ct.getCustomerName());
                    cst.setCustomerNo(ct.getCustomerNo());
                    cst.setFollowDate(new Date());
                    cst.setIdcardNo(ct.getIdcardNo());
                    cst.setNatives(ct.getnatives());
                    cst.setPhone(ct.getPhone());
                    cst.setResideArea(ct.getResidArea());
                    cst.setTel(ct.getTel());
                    cst.setWorkArea(ct.getWordArea());
                    cst.setSource(ct.getSource());
                    cst.setAd_area(ct.getAd_area());
                    cst.setDeal_date(ct.getDeal_date());
                    cst.setCompanyId(SessionUser.getCompanyId());
                    iVipCustomerMapper.addVipCustomer(cst);

                    for(VipCustdeal dl:deal){

                        if(dl.getRefId() == ct.getId()){
                            VipCustItemCond cond = new VipCustItemCond();
                            cond.setProjectName(dl.getProjectName());
                            cond.setArea(dl.getArea());
                            cond.setBuilding(dl.getBuilding());
                            cond.setFloor(dl.getFloor());
                            cond.setRoom_no(dl.getRoom_no());

                            //取原始表
                            vipcustimpcond.setCompanyId(SessionUser.getCompanyId());
                            vipcustimpcond.setId(dl.getCustImpId());
                            VipCustImp vipCustImp = iVipCustImpMapper.findVipCustImpById(vipcustimpcond);

                            cond.setCustomer_name(vipCustImp.getCustomerName());
                            cond.setRefId(ct.getId());
                            //判断同一客户下是否有重复的楼盘
                            int itemCount = iVipCustItemMapper.findVipCustItemCount(cond);
                            if(itemCount==0){
                                //是该客户下的交易
                                VipCustItem item = new VipCustItem();
                                item.setAreaSize(dl.getAreaSize());
                                item.setProjectName(dl.getProjectName());
                                item.setArea(dl.getArea());
                                item.setBuilding(dl.getBuilding());
                                item.setFloor(dl.getFloor());
                                item.setRoom_no(dl.getRoom_no());
                                item.setRefId(cst.getId());
                                item.setTotal(dl.getTotal());
                                item.setBusinesscircle(dl.getBusinesscircle());
                                item.setConstruction_area(dl.getConstruction_area());
                                item.setAdArea(dl.getAdArea());
                                item.setPaymethod(dl.getPaymethod());
                                item.setConstructtype(dl.getConstructtype());
                                item.setCustomerNo(dl.getCustImpId()+"");

                                //取原始表
                                vipcustimpcond.setCompanyId(SessionUser.getCompanyId());
                                vipcustimpcond.setId(dl.getCustImpId());
                                VipCustImp vi = iVipCustImpMapper.findVipCustImpById(vipcustimpcond);

                                item.setSource(vi.getSource());
                                item.setCustomer_name(vi.getCustomerName());
                                item.setIdcard_no(vi.getIdcardNo());
                                item.setTel(vi.getTel());
                                item.setPhone(vi.getPhone());
                                item.setAttribute(vi.getAttribute());
                                item.setReside_area(vi.getResideArea());
                                item.setWord_area(vi.getWordArea());
                                item.setDeal_date(vi.getDealDate());
                                item.setCreatedate(vi.getCreatedate());
                                item.setCompanyId(SessionUser.getCompanyId());

                                iVipCustItemMapper.addVipCustItem(item);
                                i_update++;
                            }
                            //标记vipcustdeal(购买记录表) 已经转化为vip客户的购买记录 0未转化 1已转化
                            //dl.setFlag(1);
                            //iVipCustdealMapper.updateVipCustdeal(dl);
                        }
                    }
                    i_add++;
                }
            }

            CustomerUtils.writeResponse(response, "转换结果：新增（"+i_add+"人）已有客户更新（"+i_update+"套）");
        }catch(Exception ex){
            ex.printStackTrace();
            CustomerUtils.writeResponse(response, "转换结果：新增（"+i_add+"人）已有客户更新（"+i_update+"套）出错信息："+ ex.getMessage());
        }
        return null;
    }

    /**
     * List 去重
     * @param list
     * @return
     */
    /*private Set filterList(List list){
        Set set = new HashSet();
        set.addAll(list);
        return set;
    }*/
}
