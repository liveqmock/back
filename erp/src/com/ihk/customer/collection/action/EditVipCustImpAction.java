package com.ihk.customer.collection.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.ihk.customer.collection.pojo.VipCustImpCond;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.SessionUser;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.customer.collection.IVipCustImpMapper;
import com.ihk.customer.collection.pojo.VipCustImp;
import com.ihk.utils.SupperAction;
import com.ihk.utils.base.PojoDeleteCond;
import com.opensymphony.xwork2.ActionContext;

@SuppressWarnings("serial")
public class EditVipCustImpAction extends SupperAction{
    private final Logger logger = Logger.getLogger(EditVipCustImpAction.class);

    @Autowired IVipCustImpMapper iVipCustImpMapper;
    VipCustImp vipCustImp;
    /**
     * 查询
     * @return
     * @throws Exception
     */
    public String query() throws Exception{
        int id = Integer.parseInt(request.getParameter("id"));
        VipCustImpCond vipcustimpcond =new VipCustImpCond();
        vipcustimpcond.setCompanyId(SessionUser.getCompanyId());
        vipcustimpcond.setId(id);
        vipCustImp = iVipCustImpMapper.findVipCustImpById(vipcustimpcond);
        ActionContext.getContext().getValueStack().set("vipCustImp",vipCustImp);
        return "success";
    }

    /**
     * 修改
     * @return
     * @throws Exception
     */
    public String editImp() throws Exception {

        try{
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date date = df.parse(request.getParameter("dt"));
            VipCustImpCond vipcustimpcond =new VipCustImpCond();
            vipcustimpcond.setCompanyId(SessionUser.getCompanyId());
            vipcustimpcond.setId(vipCustImp.getId());
            VipCustImp cust = iVipCustImpMapper.findVipCustImpById(vipcustimpcond);
            vipCustImp.setDealDate(date);
            vipCustImp.setIsArrange(cust.getIsArrange());
            iVipCustImpMapper.updateVipCustImp(vipCustImp);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return SUCCESS;
    }

    /**
     * 删除
     * @return
     * @throws Exception
     */
    public String delete() throws Exception {
        try{
            iVipCustImpMapper.deleteVipCustImp(Integer.parseInt(request.getParameter("id")));
            CustomerUtils.writeResponse(response, "删除成功。");
        } catch (Exception e) {
            e.printStackTrace();
            CustomerUtils.writeResponse(response, "删除失败。");
            logger.error("删除失败。" + e.getMessage());
        }

        return null;
    }

    public VipCustImp getVipCustImp() {
        return vipCustImp;
    }

    public void setVipCustImp(VipCustImp vipCustImp) {
        this.vipCustImp = vipCustImp;
    }
}
