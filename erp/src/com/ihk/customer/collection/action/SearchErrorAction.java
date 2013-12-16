package com.ihk.customer.collection.action;

import com.ihk.constanttype.ContTable;
import com.ihk.customer.collection.IVipCustImpMapper;
import com.ihk.customer.collection.pojo.VipCustImp;
import com.ihk.customer.collection.pojo.VipCustImpCond;
import com.ihk.utils.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 查询导入后可能需要修改的数据
 */

public class SearchErrorAction extends SupperAction{

    private static final long serialVersionUID = 1L;
    private VipCustImpCond vipCustImpCond;
    //当前页
    private int page;
    //每页的记录数
    private int rows;
    //排序字段
    private String sort;
    //排序方式 (asc|desc)
    private String order;
    //返回页面的json对象
    private JSONObject result;
    @Autowired
    private IVipCustImpMapper ivipCustImpMapper;
    //这是查询条件的KEY，每次查询把查询条件放session里面
    public static final String ORDER_QUERY_KEY = "order_query_key";

    public VipCustImpCond getVipCustImpCond() {
        return vipCustImpCond;
    }

    public void setVipCustImpCond(VipCustImpCond vipCustImpCond) {
        this.vipCustImpCond = vipCustImpCond;
    }

    public JSONObject getResult() {
        return result;
    }

    public void setResult(JSONObject result) {
        this.result = result;
    }

    /**
     * 按条件查询
     * @return
     * @throws Exception
     */
    public String conditionByQuery() throws Exception {
        if(vipCustImpCond == null){
            vipCustImpCond = new VipCustImpCond();
        }

        return null;
    }

    /**
     * 查询可能要修改的信息
     * @return
     * @throws Exception
     */
    public String search() throws Exception {
        try{

            HttpServletRequest re = ServletActionContext.getRequest();
            response.setCharacterEncoding("UTF-8");
            //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
            JSONArray jsonArray = new JSONArray();
            JSONObject jsonobj = new JSONObject();

            if(vipCustImpCond == null){
                vipCustImpCond = new VipCustImpCond();
            }
            //flag=1说明数据存在问题
            vipCustImpCond.setFlag(1);vipCustImpCond.setIsDeleted("0");

            String sort,order; //排序
            sort = re.getParameter("sort") == null ? "" : re.getParameter("sort");
            order = re.getParameter("order") == null ? "" : re.getParameter("order");

            vipCustImpCond.setSort(sort);
            vipCustImpCond.setOrder(order);

            rows = Integer.parseInt((re.getParameter("rows") == null) ? "10" : re.getParameter("rows"));
            page = Integer.parseInt((re.getParameter("page") == null) ? "1" : re.getParameter("page"));
            vipCustImpCond.pageSize = rows;
            vipCustImpCond.startLine = (page - 1) * rows;
            vipCustImpCond.setCompanyId(SessionUser.getCompanyId());
            int recordCount = ivipCustImpMapper.findVipCustImpCount(vipCustImpCond);
            List<VipCustImp> vipCustImp = ivipCustImpMapper.findVipCustImpPage(vipCustImpCond);

            for (VipCustImp con : vipCustImp) {
                jsonobj.put("id", con.getId());
                jsonobj.put("adArea", con.getAdArea());
                jsonobj.put("areaSize", con.getAreaSize());
                jsonobj.put("attribute", con.getAttribute());
                jsonobj.put("businesscircle", con.getBusinesscircle());
                jsonobj.put("constructtype", con.getConstructtype());
                jsonobj.put("contactAddr", con.getContactAddr());
                jsonobj.put("customerName", con.getCustomerName());
                jsonobj.put("customerNo", con.getCustomerNo());
                jsonobj.put("source", con.getSource());
                jsonobj.put("customer_name", con.getCustomerName());
                jsonobj.put("deal_date", DateTimeUtils.toStr(con.getDealDate()));
                jsonobj.put("idcard_no", con.getIdcardNo());
                jsonobj.put("tel", con.getTel());
                jsonobj.put("phone", con.getPhone());
                jsonobj.put("resideArea", con.getResideArea());
                jsonobj.put("wordArea", con.getWordArea());
                jsonobj.put("natives", con.getNatives());
                jsonobj.put("projectName", con.getProjectName());
                jsonobj.put("total", con.getTotal());
                jsonobj.put("area", con.getArea());
                jsonobj.put("building", con.getBuilding());
                jsonobj.put("floor", con.getFloor());
                jsonobj.put("room_no", con.getRoom_no());
                jsonobj.put("construction_area", con.getConstruction_area());
                jsonobj.put("memo", con.getMemo());
                jsonArray.add(jsonobj);
            }
            Map<String, Object> json = new HashMap<String, Object>();
            json.put("total", recordCount);// total键 存放总记录数，必须的
            json.put("rows", jsonArray);// rows键 存放每页记录 list
            result = JSONObject.fromObject(json);// 格式化result一定要是JSONObject
        }catch(Exception e){
            e.printStackTrace();
        }

        return SUCCESS;
    }



    /**
     * 导出可能有问题的数据
     * 并将原数据库中的数据标为无效
     * @return
     * @throws Exception
     */
    public String exportErrorData() throws Exception {

        try{

            VipCustImpCond	cond = new VipCustImpCond();
            cond.setFlag(1);
            cond.setIsDeleted("0");
            List<VipCustImp> vipCustImp = ivipCustImpMapper.findVipCustImpPage(cond);
            String[] thx = new String[]{"客户编号","来源","客户姓名","日期","身份证号","固话","移动电话","联系地址","居住区域","行政区域","工作区域",
                    "户籍","项目名称","组团","楼栋","楼层","房号","购买总价","建筑面积","套内面积","属性","商圈","类型"};
            final StringBuffer sb = new StringBuffer();
            sb.append(ContTable.TABLE_START).append(ContTable.TR_START);
            for(String th : thx){
                sb.append(ContTable.TH_START)
                        .append(th)
                        .append(ContTable.TH_END)
                ;
            }
            sb.append(ContTable.TR_END);
            for(VipCustImp con : vipCustImp){
                sb.append(ContTable.TR_START)
                        .append(ContTable.TD_START).append(con.getCustomerNo()).append(ContTable.TD_END)
                        .append(ContTable.TD_START).append(con.getSource()).append(ContTable.TD_END)
                        .append(ContTable.TD_START).append(con.getCustomerName()).append(ContTable.TD_END)
                        .append(ContTable.TD_START).append(DateTimeUtils.toStr(con.getDealDate())).append(ContTable.TD_END)
                        .append("<td style='vnd.ms-excel.numberformat:@'>"+con.getIdcardNo()+"</td>")
                        .append(ContTable.TD_START).append(con.getTel()).append(ContTable.TD_END)
                        .append(ContTable.TD_START).append(con.getPhone()).append(ContTable.TD_END)
                        .append(ContTable.TD_START).append(con.getContactAddr()).append(ContTable.TD_END)
                        .append(ContTable.TD_START).append(con.getResideArea()).append(ContTable.TD_END)
                        .append(ContTable.TD_START).append(con.getAdArea()).append(ContTable.TD_END)
                        .append(ContTable.TD_START).append(con.getWordArea()).append(ContTable.TD_END)
                        .append(ContTable.TD_START).append(con.getNatives()).append(ContTable.TD_END)
                        .append(ContTable.TD_START).append(con.getProjectName()).append(ContTable.TD_END)
                        .append(ContTable.TD_START).append(con.getArea()).append(ContTable.TD_END)
                        .append(ContTable.TD_START).append(con.getBuilding()).append(ContTable.TD_END)
                        .append(ContTable.TD_START).append(con.getFloor()).append(ContTable.TD_END)
                        .append(ContTable.TD_START).append(con.getRoom_no()).append(ContTable.TD_END)

                        .append(ContTable.TD_START).append(con.getTotal()).append(ContTable.TD_END)
                        .append(ContTable.TD_START).append(con.getConstruction_area()).append(ContTable.TD_END)
                        .append(ContTable.TD_START).append(con.getAreaSize()).append(ContTable.TD_END)
                        .append(ContTable.TD_START).append(con.getAttribute()).append(ContTable.TD_END)
                        .append(ContTable.TD_START).append(con.getBusinesscircle()).append(ContTable.TD_END)
                        .append(ContTable.TD_START).append(con.getConstructtype()).append(ContTable.TD_END)
                        .append(ContTable.TR_END);

                con.setIsDeleted("1");
                ivipCustImpMapper.updateVipCustImp(con);
            }

            //数据库中清除导出内容（isdelete=1）
            ivipCustImpMapper.deleteVipCustImpByFlag();

            sb.append(ContTable.TALBE_END);
            String fileName = "download-" + CustomerUtils.getNowForString() + "-.xls";
            ReportUtils.downLoadReport(sb.toString(), fileName, response);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * 允许有问题的信息导入成功
     * @return
     * @throws Exception
     */
    public String allowsImport() throws Exception {
        try {
            VipCustImpCond	cond = new VipCustImpCond();
            cond.setFlag(1);
            cond.setIsArrange("T");
            cond.setCompanyId(SessionUser.getCompanyId());
            String id = request.getParameter("id");
            if (!CommonUtils.isStrEmpty(id)){
                cond.setId(Integer.parseInt(id));
            }

            ivipCustImpMapper.updateAllowsImp(cond);

            CustomerUtils.writeResponse(response, "导入成功");
        } catch (Exception e) {
            CustomerUtils.writeResponse(response, "导入出错。"+e.getMessage());
        }

        return null;
    }
}
