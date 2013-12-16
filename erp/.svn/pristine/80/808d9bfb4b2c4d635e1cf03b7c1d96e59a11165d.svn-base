package com.ihk.customer.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.article.data.pojo.Article;
import com.ihk.article.data.pojo.ArticleCond;
import com.ihk.article.data.services.IArticleServices;
import com.ihk.constanttype.ContCompanyId;
import com.ihk.constanttype.EnumChartCycel;
import com.ihk.constanttype.EnumDevFlag;
import com.ihk.constanttype.EnumPrivCode;
import com.ihk.customer.data.pojo.CustomerCond;
import com.ihk.customer.data.services.ICustomerServices;
import com.ihk.permission.PermissionUtils;
import com.ihk.saleunit.data.pojo.ConfirmCond;
import com.ihk.saleunit.data.services.IConfirmServices;
import com.ihk.user.data.pojo.CompanyProject;
import com.ihk.user.data.pojo.UserRole;
import com.ihk.user.data.services.ICompanyProjectServices;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.DateTimeUtils;
import com.ihk.utils.HighChartsUtils;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;


/**
 *  广州项目登陆成功后的主页
 */
@SuppressWarnings("rawtypes")
public class GuangZhouIndexAction extends SupperAction {

    private static final long serialVersionUID = 1L;


    @Autowired
    ICustomerServices customerServices;
    @Autowired
    ICompanyProjectServices comProServices;
    @Autowired
    IArticleServices iArticleServices;
    @Autowired
    IConfirmServices confirmServices;
    
    private int selectProjectId;

    private List<Article> listArt;
    private CustomerCond customerCond;
    private ConfirmCond cond;
    private String categories;
    private String sumlist;

    //日期坐标行(内部List中的内容为yyyy-MM-dd,dd,MM-dd)

    private List<List> listDate;
    //数据库分组结果
    private List<Map> listDBData;

    private List<Map<String, Object>> noticeList;
    private CustomerCond noticeCond;

    public void setNoticeCond(CustomerCond noticeCond) {
        this.noticeCond = noticeCond;
    }

    public CustomerCond getNoticeCond() {
        return noticeCond;
    }

    public void setNoticeList(List<Map<String, Object>> noticeList) {
        this.noticeList = noticeList;
    }

    public List<Map<String, Object>> getNoticeList() {
        return noticeList;
    }

    public CustomerCond getCustomerCond() {
        return customerCond;
    }

    public void setCustomerCond(CustomerCond customerCond) {
        this.customerCond = customerCond;
    }

    public List<List> getListDate() {
        return listDate;
    }

    public void setListDate(List<List> listDate) {
        this.listDate = listDate;
    }

    public List<Map> getListDBData() {
        return listDBData;
    }

    public void setListDBData(List<Map> listDBData) {
        this.listDBData = listDBData;
    }

    private String nowDate;

    public String getNowDate() {
        return nowDate;
    }

    public void setNowDate(String nowDate) {
        this.nowDate = nowDate;
    }

    public List<Article> getListArt() {
        return listArt;
    }

    public void setListArt(List<Article> listArt) {
        this.listArt = listArt;
    }

    public ConfirmCond getCond() {
        return cond;
    }

    public void setCond(ConfirmCond cond) {
        this.cond = cond;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getSumlist() {
        return sumlist;
    }

    public void setSumlist(String sumlist) {
        this.sumlist = sumlist;
    }

    public List<UserRole> getUrList() {
        return urList;
    }

    public void setUrList(List<UserRole> urList) {
        this.urList = urList;
    }

    public int getSelectProjectId() {
        return selectProjectId;
    }

    public void setSelectProjectId(int selectProjectId) {
        this.selectProjectId = selectProjectId;
    }


    public String login() throws Exception{
        initUserRoleList();
        nowDate = CommonUtils.getNowForString();
        //临时最新录入
        if(noticeCond == null){
            noticeCond = new CustomerCond();
        }
        noticeCond.setCompanyId(ContCompanyId.GUANG_ZHOU + "");
        noticeCond.setDate1(CommonUtils.getOneWeekBeforeForString());
        noticeCond.setDate2(CustomerUtils.getNowForString());
        List<Integer> pro = PermissionUtils.getUserProjectIdList(EnumPrivCode.REPORT_PRECUSTOMER_DOWNLOAD);
        if(pro == null || pro.size()==0)pro.add(SessionUser.getProjectId());//在没有项目权限的情况下  销售人员  查看自己所属项目的最新录入
        noticeCond.setProjectIds(pro);

        noticeList = customerServices.findTmpNotice(noticeCond);
        noticeCond.setDate1(noticeCond.getDate1().substring(5))   ;
        noticeCond.setDate2(noticeCond.getDate2().substring(5))   ;

        for(Map<String, Object> notice : noticeList){
            String projectId = new String(notice.get("project_id") + "");
            CompanyProject project = comProServices.findCompanyProjectById(Integer.parseInt(projectId));
            notice.put("project_id", project.getProjectName());

        }
        //	}
        //曲线图
        initListDate();
        //查询数据库,形成分组(日期)后的数据
        listDBData = customerServices.findCustomerGroupNum(customerCond);

        //业绩报表
        if(SessionUser.getUserId() == 2 || PermissionUtils.hasPermission(EnumPrivCode.SYSTEM_USER_CREATE, EnumDevFlag.GUANGZHOU) ){
            List<Map<String, Object>> listsum = confirmServices.sumCompanyReport(cond);
            List<Map<String, Object>> listProjectReport = confirmServices.listProjectReport(cond);

            setHighchartsData(listsum,listProjectReport);
        }

        //最新的15条公告
        if(SessionUser.getProjectId() == 66){
            this.listArt = new ArrayList<Article>();
        }else{
            ArticleCond artcond = new ArticleCond();
            artcond.topNum = 15;
            artcond.setDevFlag(EnumDevFlag.GUANGZHOU.toString());
            this.listArt = iArticleServices.findArticle(artcond);
        }

        return "loginSucc";
    }

    private List<UserRole> urList;
    /**
     * 2012-10-09
     * 为了给多项目人员作跳转用
     * 初始化的时候 如果没有权限 则根据他自身的project id 初始化一个 (为了和以前dev_code =customer_guangzhou 的项目并行,要给一个自身项目用来显示)
     * 在修改了这个
     * @param urList 所拥有的 销控中心权限的项目LIST
     * @param 19 数据库固定权限 销控中心    设计为暂时区分 dev_code = chustomerguangzhou 的项目 是否能看到 楼盘销售等模块根目录的临时权限
     * */
    private void initUserRoleList(){
        urList = PermissionUtils.getUserRoleListByUserIdAndRoleId(SessionUser.getUserId(),19);

        if(urList == null){//没有销控权限的
            urList = new ArrayList<UserRole>();
        }
        if(urList.size() == 0){//没有销控权限的
            UserRole r = new UserRole();
            r.setProjectId(SessionUser.getProjectId());
            urList.add(r);
        }
    }



    /**
     * 权限跳转项目ID  针对多项目人员 ,(因为销控中心必须要确认操作的项目 )
     * @param selectProjectId 选择的项目ID
     * */
    public String selectProjectByRole()throws Exception{
        urList = PermissionUtils.getUserRoleListByUserIdAndRoleId(SessionUser.getUserId(),19);//初始化list 多项目管理人员
        if(urList == null){//没有销控权限的
            urList = new ArrayList<UserRole>();
        }
        if(urList.size() == 0){//没有销控权限的
            UserRole r = new UserRole();
            r.setProjectId(SessionUser.getProjectId());
            urList.add(r);
        }
        SessionUser.getSessionUser().setProjectId(selectProjectId);
        return this.login();
    }





    //周期
    private String selCycel=EnumChartCycel.DAY.toString().toLowerCase();

    //初始化日期
    private void initListDate(){
        if (customerCond == null) {
            customerCond = new CustomerCond();
        }
        if (CustomerUtils.isStrEmpty(customerCond.getDate1())) {
            customerCond.setDate1(CommonUtils.getOneWeekBeforeForString());
        }
        if (CustomerUtils.isStrEmpty(customerCond.getDate2())) {
            customerCond.setDate2(CommonUtils.getOneDayBeforeForString(new Date()));
        }
        if(cond == null){
            cond = new ConfirmCond();
        }


        DateTime[] dates = DateTimeUtils.getDates(customerCond.getDate1(), customerCond.getDate2());
        List<String> listDate = DateTimeUtils.toListStr(dates);
        List<String> listSimpleDate = DateTimeUtils.toListStr(dates,"dd");
        List<String> listMMddDate = DateTimeUtils.toListStr(dates,"MM-dd");

        this.listDate = new ArrayList<List>();
        for(int i=0;i<listDate.size();i++){
            List<String> val = new ArrayList<String>();
            val.add(listDate.get(i));
            val.add(listSimpleDate.get(i));
            val.add(listMMddDate.get(i));

            this.listDate.add(val);
        }

    }

    public String getChartXAxis(){
        String str = "";

        if(selCycel.equals(EnumChartCycel.WEEK.toString().toLowerCase())){
            str = HighChartsUtils.getDaysXAxisMonday(customerCond.getDate1(),customerCond.getDate2());
        }
        else if(selCycel.equals(EnumChartCycel.MONTH.toString().toLowerCase())){
            str = HighChartsUtils.getDaysXAxisMonthFirstDay(customerCond.getDate1(),customerCond.getDate2());
        }
        else {
            str = HighChartsUtils.getDaysXAxis(customerCond.getDate1(),customerCond.getDate2());
        }

        return str;
    }

    @SuppressWarnings("unchecked")
    public String getChartSeriesData(){
        String[] xAxis = getChartXAxis().replace("[", "").replace("]", "").replace(" ", "").replace("'", "").split(",");

        // xy轴形成的点的map（唯一对应一点）
        Map map = new HashMap(); //
        for (int i=0;i<listDBData.size(); i++) {
            String key = "";

            if(selCycel.equals(EnumChartCycel.WEEK.toString().toLowerCase())){
                key = DateTimeUtils.getMondayStr(listDBData.get(i).get("categoryDate").toString()).substring(5);
            }
            else if(selCycel.equals(EnumChartCycel.MONTH.toString().toLowerCase())){
                key = DateTimeUtils.getMonthFirstDayStrMMdd(listDBData.get(i).get("categoryDate").toString());
            }
            else{
                key = listDBData.get(i).get("categoryDate").toString().substring(5);
            }

            //累计求和
            if(map.containsKey(key)){
                Integer val = Integer.valueOf(map.get(key).toString())+ Integer.valueOf(listDBData.get(i).get("num").toString());
                map.put(key,val);
            }
            else{
                map.put(key, listDBData.get(i).get("num"));
            }

        }

        String str = HighChartsUtils.getChartSeriesByX(xAxis, "人数", map);

        return str;
    }

    /**
     * 设置业绩排行榜数据
     * @param listsum
     */
    private void setHighchartsData(List<Map<String, Object>> listsum , List<Map<String, Object>> listProjectReport ) {
        List<String> listcompany = new ArrayList<String>();
        List<String> listsummoney = new ArrayList<String>();
        int i=0;
        sumlist = "";
        for(Map<String, Object> map : listsum){
            String company = (String) map.get("company");
            listcompany.add(company);

            BigDecimal sum_money = (BigDecimal) map.get("sum_money");
            if(sum_money==null) sum_money =  new BigDecimal(0);
            listsummoney.add(sum_money.toString());

            List<String> listproject = new ArrayList<String>();
            List<String> listprj_sum_money = new ArrayList<String>();
            for(Map<String, Object> mapproject : listProjectReport){

                String prj_company = (String) mapproject.get("company");
                if(prj_company.equalsIgnoreCase(company)){
                    String project = (String) mapproject.get("project");
                    listproject.add(project);
                    BigDecimal prj_sum_money = (BigDecimal) mapproject.get("sum_money");
                    listprj_sum_money.add(prj_sum_money.toString());
                }
            }

            sumlist += "{";
            sumlist += "y:"+sum_money + ",";
            sumlist += "color: colors["+i+"],";
            sumlist += "drilldown: {";
            sumlist += "name: '"+ company +"项目',";
            sumlist += "categories: ["+ HighChartsUtils.arrayToString(listproject.toArray(new String[listproject.size()]),",")+"],";
            sumlist += "data: ["+ HighChartsUtils.arrayToNum(listprj_sum_money.toArray(new String[listprj_sum_money.size()]),",")+"],";
            sumlist += "color: colors["+i+"]";
            sumlist += "}";
            sumlist += "},";

            i++;

            //System.out.println("company: " + company + " sum_money= " + sum_money);
        }
        if(listcompany!=null){
            String[] strings = new String[listcompany.size()];
            setCategories(HighChartsUtils.arrayToString(listcompany.toArray(strings),","));
        }
        if(sumlist.length()>0){
            setSumlist(sumlist.substring(0,sumlist.length()-1));
        }
    }






}
		
		
