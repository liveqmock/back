package com.ihk.user.manager;

import com.ihk.constanttype.EnumDevFlag;
import com.ihk.constanttype.EnumPrivCode;
import com.ihk.permission.PermissionUtils;
import com.ihk.user.data.pojo.*;
import com.ihk.user.data.services.IPrivServices;
import com.ihk.utils.*;
import com.ihk.utils.method.ActionAjaxMethodModifyCallback;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Lenovo
 * Date: 13-9-16
 * Time: 下午3:26
 * To change this template use File | Settings | File Templates.
 */
public class PrivAction  extends SupperAction {
    @Autowired
    IPrivServices iPrivServices;

    private List<Priv> privList;
    private PrivCond privCond;
    private int privId;
    private String privCode;
    private String privName;
    private String remark;
    private String devFlag;

    private int orderIndex=999;


    public int getPrivId() {
        return privId;
    }

    public void setPrivId(int privId) {
        this.privId = privId;
    }

    public String getDevFlag() {
        return devFlag;
    }

    public void setDevFlag(String devFlag) {
        this.devFlag = devFlag;
    }

    public List<Priv> getPrivList() {
        return privList;
    }

    public void setPrivList(List<Priv> privList) {
        this.privList = privList;
    }

    public PrivCond getPrivCond() {
        return privCond;
    }

    public void setPrivCond(PrivCond privCond) {
        this.privCond = privCond;
    }

    public String getPrivCode() {
        return privCode;
    }

    public void setPrivCode(String privCode) {
        this.privCode = privCode;
    }

    public String getPrivName() {
        return privName;
    }

    public void setPrivName(String privName) {
        this.privName = privName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(int orderIndex) {
        this.orderIndex = orderIndex;
    }

    /**
     * 权限列表
     * @return
     */
    public String searchPriv() {
        this.privList = iPrivServices.findAll();
        privCond = new PrivCond();
        return "success";
    }

    /**
     * 保存新增权限
     * @return
     */
    public String addPriv(){
        ActionTemplate.executeAjaxMethod(true,this, new ActionAjaxMethodModifyCallback() {

            @Override
            public void modifyMethodException(Exception e) {
                setUpEasyuiAjaxForFail(e.getMessage());
            }

            @Override
            public void modifyMethod() throws Exception {
                if(!PermissionUtils.hasPermission(EnumPrivCode.SYSTEM_POWER_CREATE, EnumDevFlag.GUANGZHOU)){
                    throw new Exception("权限不够");
                }
                if(privName.trim().length()==0){
                    throw new Exception("必须填写角色名称");
                }
                if(privCode.trim().length()==0){
                    throw new Exception("必须填写开发标记");
                }


                Priv priv = new Priv();
                priv.setPrivName(privName);
                priv.setPrivCode(privCode);
                priv.setDevFlag(devFlag);
                priv.setOrderIndex(orderIndex);
                priv.setRemark(remark);


                iPrivServices.addPriv(priv);
            }
        });
        return null;
    }

    /**
     * 具体的查询action
     * @return
     */
    public String searchPrivAjax() {
        privCond = new PrivCond();


        ActionTemplate.executeAjaxPage(this, privCond, new ActionAjaxPageCallback() {

            @Override
            public int initTotal() throws Exception {
                //不分页的做法
                privCond.pageSize = 0;
                return 0;
            }

            //获取table中要显示的json
            @Override
            public List<Map<String, String>> initRows() throws Exception {

                List<Map<String, String>> retList = new ArrayList<Map<String,String>>();

                List<Priv> list = iPrivServices.findAll();

                if(!CommonUtils.isCollectionEmpty(list)){

                    Map<String, String> map = null;

                    //与jsp中table的表头(th field)定义一致
                    for(Priv obj : list){

                        map = new HashMap<String, String>();

                        map.put("id", obj.getId()+"");
                        map.put("privName", obj.getPrivName());
                        map.put("privCode", obj.getPrivCode());

                        map.put("devFlag", obj.getDevFlag());
                        map.put("orderIndex", obj.getOrderIndex()+"");
                        map.put("remark", obj.getRemark());

                        retList.add(map);
                    }

                }
                return retList;
            }
        });
        return null;
    }

    /**
     * 编辑角色
     * @return
     */
    public String editPriv(){
        Priv priv = iPrivServices.findPrivById(this.privId);
        setPrivId(priv.getId());
        setPrivName(priv.getPrivName());
        setPrivCode(priv.getPrivCode());
        setDevFlag(priv.getDevFlag());
        setOrderIndex(priv.getOrderIndex());
        setRemark(priv.getRemark());

        return "update";
    }


    /**
     * 保存修改角色
     * @return
     */
    public String updatePriv(){
        ActionTemplate.executeAjaxMethod(true,this, new ActionAjaxMethodModifyCallback() {

            @Override
            public void modifyMethodException(Exception e) {
                setUpEasyuiAjaxForFail(e.getMessage());
            }

            @Override
            public void modifyMethod() throws Exception {
                if(!PermissionUtils.hasPermission(EnumPrivCode.SYSTEM_POWER_CREATE, EnumDevFlag.GUANGZHOU)){
                    throw new Exception("权限不够");
                }
                Priv priv = new Priv();
                priv.setId(privId);
                priv.setPrivCode(privCode);
                priv.setPrivName(privName);
                priv.setOrderIndex(orderIndex);
                priv.setDevFlag(devFlag);
                priv.setRemark(remark);
                iPrivServices.updatePriv(priv);
            }
        });
        return null;
    }
}
