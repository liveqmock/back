package com.ihk.saleunit.action.check_fee;

import com.ihk.constanttype.ContUnitSaleState;
import com.ihk.constanttype.EnumUnitCheckfeeType;
import com.ihk.property.data.pojo.Checkfee;
import com.ihk.saleunit.action.check_fee.pojo.CheckFeeCond;
import com.ihk.saleunit.data.pojo.ConfirmCond;
import com.ihk.utils.ActionTemplate;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.SessionUser;
import com.ihk.utils.method.ActionAjaxMethodModifyCallback;
import com.opensymphony.xwork2.ActionContext;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Lenovo
 * Date: 13-5-23
 * Time: 下午3:23
 * 对数表管理.
 * 添加对数单元  对单元表update,对数表insert
 * 删除对数单元  对单元表update,对数表delete
 * 不结佣        对单元表update,对数表delete
 * 开发商确认    对单元表update,对数表update
 */
public class CheckFeeManagerAction extends CheckFeeAction {
	
    private static final long serialVersionUID = 8547136327329384259L;

    /**
     * 新建对数表
     * @return
     * @throws Exception
     */
    public String checkfee_list() throws Exception {

        initSearchDate();
        initListDate();
        saleMap = ContUnitSaleState.getContractState(false);
        checkFeeTypeMap = EnumUnitCheckfeeType.getCheckfeeType();

        return SUCCESS;
    }

    /**
     * 修改对数表
     * @return
     * @throws Exception
     */
    public String checkfee_mod() throws Exception {

        initSearchDate();
        initListDate();
        saleMap = ContUnitSaleState.getContractState(false);
        checkFeeTypeMap = EnumUnitCheckfeeType.getCheckfeeType();

        return SUCCESS;
    }

    /**
     * 查询已确认的对数表
     * @return
     * @throws Exception
     */
    public String checkfee_confirm() throws Exception {

        initSearchDate();
        initListDate();
        saleMap = ContUnitSaleState.getContractState(false);
        checkFeeTypeMap = EnumUnitCheckfeeType.getCheckfeeType();

        return SUCCESS;
    }

    /**
     * 对数表查询
     * @return 返回json
     * @throws Exception
     */
    public String checkfee_unit() throws Exception {

        setCond();

        String signDate = request.getParameter("signDate");
        String signDateEnd = request.getParameter("signDateEnd");
        String saleState = request.getParameter("saleState");

        if(saleState.equals(ContUnitSaleState.CONFIRM)) {
            //成交
            if(!CommonUtils.isStrEmpty(signDate)){
                confirmCond.setStartDate(signDate);
            }
            if(!CommonUtils.isStrEmpty(signDateEnd)){
                confirmCond.setEndDate(CommonUtils.getDateString(CommonUtils.getAfterDateForDay(CommonUtils.getDateFromString(signDateEnd),1)));
            }
        } else {
            //合同
            if(!CommonUtils.isStrEmpty(signDate)){
                confirmCond.setDate1(signDate);
            }
            if(!CommonUtils.isStrEmpty(signDateEnd)){
                confirmCond.setDate2(CommonUtils.getDateString(CommonUtils.getAfterDateForDay(CommonUtils.getDateFromString(signDateEnd),1)));
            }

        }

        unitList(confirmCond);

        return SUCCESS;
    }

    /**
     * 部分回款筛选条件
     * @return
     * @throws Exception
     */
    public String checkfee_unit_receipt() throws Exception {

        setCond();

        String receiptDate = request.getParameter("receiptDate");
        String receiptDateEnd = request.getParameter("receiptDateEnd");
        if(!CommonUtils.isStrEmpty(receiptDate)){
            confirmCond.setDate1(receiptDate);
        }
        if(!CommonUtils.isStrEmpty(receiptDateEnd)){
            confirmCond.setDate2(CommonUtils.getDateString(CommonUtils.getAfterDateForDay(CommonUtils.getDateFromString(receiptDateEnd),1)));
        }

        unitReceiptList(confirmCond);

        return SUCCESS;
    }

    /**
     * 修改对数表 查询
     * @return 返回json
     * @throws Exception
     */
    public String checkfeemod_unit() throws Exception {

        setCond();

        String signDate = request.getParameter("signDate");

        if(!CommonUtils.isStrEmpty(signDate)) {
            confirmCond.setDate1(CommonUtils.getDateString(CommonUtils.getAfterDateForDay(CommonUtils.getDateFromString(signDate),1)));
        }

        unitList(confirmCond);

        return SUCCESS;
    }

    /**
     * 加入对数表
     * 1、property_unit 更改状态、对数日期
     * 2、checkfee 新增记录
     * 3、sale_unit_receipt 实收表加入checkfee_id
     * @return
     * @throws Exception
     */
    public String add_checkfee() throws Exception{
    	
    	ActionTemplate.executeAjaxMethod(true, this, new ActionAjaxMethodModifyCallback() {
			
			@Override
			public void modifyMethodException(Exception e) {
			}
			
			@Override
			public void modifyMethod() throws Exception {
				
				String seleType = request.getParameter("seleType");
				String receiptId = request.getParameter("receiptId");
				String ids = request.getParameter("ids");
				String checkFeeDateStr = request.getParameter("checkFeeDate");
				String projectIds = request.getParameter("projectIds");
				Date checkFeeDate = CommonUtils.getDateFromString(checkFeeDateStr);

                String repayMoneys = CommonUtils.isStrEmpty(request.getParameter("repayMoney"))? "0": request.getParameter("repayMoney");
                String repayAmounts = CommonUtils.isStrEmpty(request.getParameter("repayAmount"))? "0": request.getParameter("repayAmount");

				if(CommonUtils.isStrZeroEmpty(ids)){
					return ;
				}
				
				String[] idsArr = ids.split(",");
                String[] repayMoneysArr = repayMoneys.split(",");
                String[] repayAmountsArr = repayAmounts.split(",");

                if(CommonUtils.isStrEmpty(seleType)) {
                    seleType = getRefund(projectIds,checkFeeDate);
                }

				List<Integer> idIntList = new ArrayList<Integer>();
				for(int i=0;i<idsArr.length;i++){
					int unitId = Integer.parseInt(idsArr[i]);
					idIntList.add(unitId);

                    //处理回款金额
                    if(PART_REFUND.equals(seleType)) {
                        BigDecimal repayMoney = new BigDecimal(repayMoneysArr[i]);
                        BigDecimal repayAmount = new BigDecimal(repayAmountsArr[i]);

                        //存入对数表
                        addCheckfee(unitId,checkFeeDate,receiptId,repayMoney,repayAmount,seleType,projectIds,i);
                    } else {
                        addCheckfee(unitId,checkFeeDate,receiptId,BigDecimal.ZERO,BigDecimal.ZERO,seleType,projectIds,i);
                    }

				}

                //对单元状态日期更新
				propertyUnitServices.updateUnitCheckFeeByIdsAndDate(idIntList, checkFeeDate, EnumUnitCheckfeeType.CheckFeeIng.getValue());
                addCheckfeeList(projectIds,checkFeeDate,seleType);
			}
		});
    	
    	return null;
    }
    
    /**
     * 删除对数
     * 1、property_unit 更改状态、对数日期(清空)
     * 2、checkfee 删除记录
     * 3、sale_unit_receipt 实收表 清除checkfee_id ，设为 0
     * @return
     * @throws Exception
     */
    public String del_checkfee() throws Exception{
    	
    	ActionTemplate.executeAjaxMethod(true, this, new ActionAjaxMethodModifyCallback() {
			
			@Override
			public void modifyMethodException(Exception e) {
			}
			
			@Override
			public void modifyMethod() throws Exception {

                String projectIds = request.getParameter("projectIds");
                String receiptId = request.getParameter("receiptId");
				String ids = request.getParameter("ids");
                String checkFeeDateStr = request.getParameter("checkFeeDate");
                Date checkFeeDate = CommonUtils.getDateFromString(checkFeeDateStr);

				if(CommonUtils.isStrZeroEmpty(ids)){
					
					return ;
				}
				
				String[] idsArr = ids.split(",");
				
				List<Integer> idIntList = new ArrayList<Integer>();
                int i=0;
				for(String idStr : idsArr){
                    int unitId = Integer.parseInt(idStr);
					idIntList.add(unitId);

                    //存入对数表
                    delCheckfee(unitId,checkFeeDate,receiptId,projectIds,i);
                    i++;
				}
				
				propertyUnitServices.updateUnitCheckFeeByIdsAndDate(idIntList, null, EnumUnitCheckfeeType.HaveNotCheckFee.getValue());
				
			}
		});
    	
    	return null;
    }

    /**
     * 恢复可对数
     * @return
     * @throws Exception
     */
    public String resume_checkfee() throws Exception{

        ActionTemplate.executeAjaxMethod(true, this, new ActionAjaxMethodModifyCallback() {

            @Override
            public void modifyMethodException(Exception e) {
            }

            @Override
            public void modifyMethod() throws Exception {

                String ids = request.getParameter("ids");
                String checkFeeDateStr = request.getParameter("checkFeeDate");

                if(CommonUtils.isStrZeroEmpty(ids)){
                    return ;
                }

                String[] idsArr = ids.split(",");
                String[] checkFeeDateArr = checkFeeDateStr.split(",");

                List<Integer> idIntList = new ArrayList<Integer>();
                int i=0;
                for(String idStr : idsArr){
                    int unitId = Integer.parseInt(idStr);
                    idIntList.add(unitId);

                    Date checkFeeDate = CommonUtils.getDateFromString(checkFeeDateArr[i]);
                    //存入对数表
                    delCheckfee(unitId,checkFeeDate);
                    i++;
                }

                propertyUnitServices.updateUnitCheckFeeByIdsAndDate(idIntList, null, EnumUnitCheckfeeType.HaveNotCheckFee.getValue());

            }
        });

        return null;
    }
    /**
     * 确认与开发商已对数
     * 1、property_unit 更改状态、对数日期(不变)
     * 2、checkfee 更改checkfee_type
     * 3、sale_unit_receipt 不更改
     * @return
     * @throws Exception
     */
    public String final_checkfee() throws Exception{
    	
    	ActionTemplate.executeAjaxMethod(true, this, new ActionAjaxMethodModifyCallback() {
			
			@Override
			public void modifyMethodException(Exception e) {
			}
			
			@Override
			public void modifyMethod() throws Exception {
				
				String ids = request.getParameter("ids");
                int checkfeeType = EnumUnitCheckfeeType.CheckFeeEd.getValue();
                String checkFeeDateStr = request.getParameter("checkFeeDate");
                Date checkFeeDate = CommonUtils.getDateFromString(checkFeeDateStr);

				if(CommonUtils.isStrZeroEmpty(ids)){
					
					return ;
				}
				
				String[] idsArr = ids.split(",");
				
				List<Integer> idIntList = new ArrayList<Integer>();
				for(String idStr : idsArr){
                    int unitId = Integer.parseInt(idStr);

					idIntList.add(unitId);
                    updateCheckfee(unitId,checkfeeType,checkFeeDate);
				}
				
				propertyUnitServices.updateUnitCheckFeeByIdsAndDate(idIntList, checkFeeDate, checkfeeType);
				
			}
		});
    	
    	return null;
    }


    /**
     * 获取修改预对数表下的对数日期
     * @return
     * @throws Exception
     */
    public String getCheckFeeDateList() throws Exception{
    	
        JSONObject jsonCheckFeeDate;
        JSONArray jsonArray = new JSONArray();
        response.setContentType("application/json;");
        response.setCharacterEncoding("UTF-8");
        confirmCond = new ConfirmCond();
        confirmCond.setPropertyId(request.getParameter("propertyId"));
        List<Map<String, Object>> checkFeeDateList = confirmServices.checkFeeDateList(confirmCond);
        for (int i = 0; i < checkFeeDateList.size(); i++) {
            Map<String, Object> mapobject = checkFeeDateList.get(i);

            String  checkfee_date = mapobject.get("checkfee_date")==null?"":mapobject.get("checkfee_date").toString();
            if(!CommonUtils.isStrEmpty(checkfee_date)){
                Map<String, Object> json = new HashMap<String, Object>();
                json.put("checkFeeDate", CommonUtils.getDateString(CommonUtils.getDateFromString(checkfee_date)));
                jsonArray.add(json);
            }

        }
        Map<String, Object> json = new HashMap<String, Object>();
        json.put("rows", jsonArray);
        jsonCheckFeeDate = JSONObject.fromObject(json);

        ActionContext.getContext().getValueStack().set("checkFeeDateList", jsonCheckFeeDate);
        return SUCCESS;
    }
    
    /**
     * 获取修改预对数表下的对数日期easyui combotree 
     * @return
     * @throws Exception
     */
    public String getCheckFeeDateListForCombotree() throws Exception{
    	
    	String noText = "-没有对数日期-";
    	String changeText = "-选择对数日期-";
    	
    	JSONArray array = new JSONArray();
    	JSONObject json = null;
    	
    	String propertyId = request.getParameter("propertyId");
    	String checkFeeType = request.getParameter("checkFeeType");
    	if(CommonUtils.isStrZeroEmpty(propertyId)){
    		
    		json = new JSONObject();
    		
    		json.put("id", "");
    		json.put("text", noText);
    		
    		array.add(json);
    		
    		CustomerUtils.writeResponse(response, array.toString());
    		
    		return null;
    	}
    	
    	 confirmCond = new ConfirmCond();
         confirmCond.setPropertyId(propertyId);
         confirmCond.setCheckFeeType(checkFeeType);
         List<Map<String, Object>> checkFeeDateList = confirmServices.checkFeeDateList(confirmCond);
         
         if(CommonUtils.isCollectionEmpty(checkFeeDateList)){
        	 
        	json = new JSONObject();
     		
     		json.put("id", "");
     		json.put("text", noText);
        	 
     		array.add(json);
        	 
         }else{
        	 
        	 json = new JSONObject();
        	 
        	 json.put("id", "");
     		 json.put("text", changeText);
     		 
     		 array.add(json);
        	 
        	 for (int i = 0; i < checkFeeDateList.size(); i++) {
            	 
                 Map<String, Object> mapobject = checkFeeDateList.get(i);

                 String checkfee_date = mapobject.get("checkfee_date")==null?"":mapobject.get("checkfee_date").toString();
                 if(!CommonUtils.isStrEmpty(checkfee_date)){
                	 
                	 json.put("id", CommonUtils.getDateString(CommonUtils.getDateFromString(checkfee_date)));
                	 json.put("text", CommonUtils.getDateString(CommonUtils.getDateFromString(checkfee_date)));
                	 
                     array.add(json);
                 }

             }
         }
         
        CustomerUtils.writeResponse(response, array.toString());
    	
    	return null;
    }

    /**
     * 不结佣（不对数）
     * @return
     * @throws Exception
     */
    public String donot_checkfee() throws Exception{

        ActionTemplate.executeAjaxMethod(true, this, new ActionAjaxMethodModifyCallback() {

            @Override
            public void modifyMethodException(Exception e) {
            }

            @Override
            public void modifyMethod() throws Exception {
                String seleType = request.getParameter("seleType");
                String receiptId = request.getParameter("receiptId");
                String projectIds = request.getParameter("projectIds");
                String ids = request.getParameter("ids");
                String checkFeeDateStr = request.getParameter("checkFeeDate");
                Date checkFeeDate = CommonUtils.getDateFromString(checkFeeDateStr);

                if(CommonUtils.isStrZeroEmpty(ids)){

                    return ;
                }

                String[] idsArr = ids.split(",");

                List<Integer> idIntList = new ArrayList<Integer>();
                int i=0;
                for(String idStr : idsArr){
                    int unitId = Integer.parseInt(idStr);

                    idIntList.add(unitId);
                    delCheckfee(unitId,checkFeeDate,receiptId,projectIds,i);
                    i++;
                }

                propertyUnitServices.updateUnitCheckFeeByIdsAndDate(idIntList, null, EnumUnitCheckfeeType.NoCheckFee.getValue());

            }
        });

        return null;
    }
    
    /**
     * 根据项目id及对数日期判断为全额或部分回款 
     * @return
     * @throws Exception
     */
    public String getCheckFeeRefundType() throws Exception{
    	
		String projectIds = request.getParameter("projectIds");
		String checkFeeDateStr = request.getParameter("checkFeeDate");
		Date checkFeeDate = CommonUtils.getDateFromString(checkFeeDateStr);
    	
    	String type = getRefund(projectIds, checkFeeDate); //1：全额，2：部分
    	
    	Map<String, String> map = new HashMap<String, String>();
    	map.put("type", type);
    	
    	CustomerUtils.writeResponse(response, CommonUtils.getMapJson(map));
    	
    	return null;
    }

    /**
     * 加入对数表
     * 1、checkfee 新增记录
     * 2、部分回款需要写 sale_unit_receipt 的 checkfee_id
     * @param unitId  单元id
     * @param checkFeeDate  对数日期
     * @param receiptId 实收
     * @param seleType 是否全额回款（0--全额，1--部分）
     * @param repayMoney 回款金额
     * @param repayAmount 回款总金额
     */
    private void addCheckfee(int unitId,Date checkFeeDate,String receiptId,
                             BigDecimal repayMoney,BigDecimal repayAmount,
                             String seleType,String projectIds,int iarr){
        Date date = new Date();
        Checkfee checkfee = new Checkfee();

        checkfee.setUnitId(unitId);
        checkfee.setCheckfeeDate(checkFeeDate);
        checkfee.setCheckfeeType(EnumUnitCheckfeeType.CheckFeeIng.getValue());
        checkfee.setIsDeleted(CommonUtils.NORMAL);
        checkfee.setCreatedId(SessionUser.getUserId());
        checkfee.setCreatedTime(date);
        checkfee.setModId(SessionUser.getUserId());
        checkfee.setModTime(date);
        checkfee.setRepayMoney(repayMoney);
        checkfee.setRepayAmount(repayAmount);

        if(CommonUtils.isStrEmpty(seleType)) {
            seleType = getRefund(projectIds,checkFeeDate);
        }

        if(seleType.equals(ALL_REFUND)){
            //全额回款
            iCheckfeeServices.addCheckfee(checkfee);

        } else {
            //部分
            if (receiptId==null){
                //实收id为空，重新获取实收金额等
                Map<String, Object> map = getSaleUnitReceipt(unitId);
                receiptId = (String)map.get("receiptId");
            }

            //增加到checkfee 表
            CheckFeeCond cond = new CheckFeeCond();
            cond.setUnitId(unitId);
            cond.setCheckfeeDate(checkFeeDate);
            List<Checkfee> checkfeeList= iCheckfeeServices.findCheckfee(cond);
            if(checkfeeList!=null && checkfeeList.size()>0){
                //已存在
                Checkfee cf = checkfeeList.get(0);
                cond = new CheckFeeCond();
                cond.setId(cf.getId());
                cond.setRepayMoney(repayMoney);
                cond.setModId(SessionUser.getUserId());
                cond.setModTime(date);
                iCheckfeeServices.updateCheckfeeByRepay(cond);
            }else{
                iCheckfeeServices.addCheckfee(checkfee);
            }

            updateSaleUnitReceipt(receiptId,checkfee.getId(),iarr);

        }
    }

    /**
     * 删除对数表
     * @param unitId 单元id
     * @param checkFeeDate 对数日期
     * @param receiptId 实收id
     * @param projectIds 项目id
     */
    private void delCheckfee(int unitId,Date checkFeeDate,String receiptId,String projectIds,int iarr){

        delCheckfee(unitId,checkFeeDate);

        String seleType = getRefund(projectIds,checkFeeDate);
        if(seleType.equals(PART_REFUND)){
            if (!CommonUtils.isStrEmpty(receiptId)) {
                updateSaleUnitReceipt(receiptId,0,iarr);
            }
        }

    }

    /**
     * 删除checkfee
     * @param unitId
     * @param checkFeeDate
     */
    private void delCheckfee(int unitId,Date checkFeeDate){
        CheckFeeCond checkFeeCond = new CheckFeeCond();
        checkFeeCond.setUnitId(unitId);
        checkFeeCond.setCheckfeeDate(checkFeeDate);

        iCheckfeeServices.deleteCheckfeeByUnitId(checkFeeCond);
    }

    /**
     * 更新对数表状态（通过单元id和对数日期更改对数表状态）
     * @param unitId 单元id
     * @param checkfeeType 对数日期
     */
    private void updateCheckfee(int unitId,int checkfeeType,Date checkFeeDate){
        Date date = new Date();
        CheckFeeCond checkFeeCond = new CheckFeeCond();
        checkFeeCond.setUnitId(unitId);
        checkFeeCond.setCheckfeeType(checkfeeType);
        checkFeeCond.setCheckfeeDate(checkFeeDate);
        checkFeeCond.setModId(SessionUser.getUserId());
        checkFeeCond.setModTime(date);
        iCheckfeeServices.updateCheckfeeByUnitId(checkFeeCond);
    }

    /**
     * 更新 实收表
     * @param receiptId
     */
    private void updateSaleUnitReceipt(String receiptId ,int checkfeeId,int iarr) {

        String[] receiptIdArr = receiptId.split(",");
        String[] receiptIdStr = receiptIdArr[iarr].split(separator);

        for(String strReceiptIdArr : receiptIdStr){
            if(!CommonUtils.isStrEmpty(strReceiptIdArr)) {
                int iReceiptId = Integer.parseInt(strReceiptIdArr);

                //部分回款，将实收对数日期设为 0
                iSaleUnitReceiptServices.updateSaleUnitReceiptCheckFeeId(iReceiptId,checkfeeId);
                //BaseLogger.info(this.getClass(),"=====" + iReceiptId + "===");
            }
        }
    }
}
