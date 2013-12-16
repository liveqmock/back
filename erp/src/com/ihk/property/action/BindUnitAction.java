package com.ihk.property.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.property.data.pojo.PropertyUnitCond;
import com.ihk.property.data.pojo.UnitBind;
import com.ihk.property.data.pojo.UnitBindCond;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.property.data.services.IUnitBindServices;
import com.ihk.utils.SupperAction;

/**
 * 单元绑定销售
 * 主单元
 * 副单元   绑定主单元 作为主单元的附属房产
 * 相关表 bind_unit
 * 相关页面 
 * */
public class BindUnitAction extends SupperAction{

	private static final long serialVersionUID = 1L;

	@Autowired IPropertyUnitServices iPropertyUnitServices;
	@Autowired IUnitBindServices iUnitBindServices;
	
	private int zunitId;//主ID
	
	private int funitIds;//副ids
	
	private PropertyUnitCond unitCond;// 查找UNIT用
	
	/**
	 * 进入绑定单元页面
	 * 内容: 
	 * 1 一个搜索楼栋FORM 在JSP完成 相关组件
	 * 2 一个展示楼栋DIV
	 * 3 显示主单元 副单元 以及保存绑定设置的form
	 * */
	public String index(){
		if(this.unitCond == null ) unitCond = (PropertyUnitCond)request.getSession().getAttribute("SessionUnitCond");
		this.initUnitTable();//构建UNITtable 
		request.setAttribute("SessionUnitCond", unitCond);
		return "suc";
	}
	
	/**
	 * 当选择UNIT的时候,需要找到相关的BIND_UNIT资源.
	 *  根据是 主 副 未设置 来判断如何搜索相关信息.
	 *  可能是AJAX访问
	 * A: 选择的是主单元   查找出所属单元 加进列表
	 * */
	public String selectUnit(){
		
		return null;
	}
	
	/**
	 * 选择主副单元之后的提交动作
	 * 可以是撤销绑定
	 * 可以是新建绑定
	 * 可以是添加绑定
	 * 可以是删除某个附属单元
	 * */
	public String updateBindUnit(){
		//必须有主单元
		//根据主单元查找副单元,和页面的副单元做比较 共有就不变  有差做相应动作
		return "suc";
	}
	
	/**
	 * 删除绑定  1 如果type是all 根据主单元全部删除
	 * 2 如果是附属ID type是one 删除附属ids
	 * */
	public String delBind(){
		//如果是主单元ID 删除所有主单元ID的项
		
		//如果是附属房产 删除附属房产这个ID的项
		
		return "suc";
	}
	
	List<String> tableTrList; //TR 
	//构建UNIT TABLE
	private void initUnitTable(){
		tableTrList = new ArrayList<String>();
		
		if( unitCond == null || unitCond.getBuildId() ==null || unitCond.getBuildId().equals("") )return;
		
		List<PropertyUnit> listUnit = iPropertyUnitServices.findUnitsByBuildId(Integer.parseInt(unitCond.getBuildId()));
	
		if(listUnit == null || listUnit.size() == 0 )return;
		
		tableTrList = toTable(listUnit);
	}
	
	private List<String> toTable(List<PropertyUnit> ul){
		List<String> sl = new ArrayList<String>();
		while (true) {
			String ss ;
			ss = toTr(ul);
			if(ss == null || ss.trim().equals("")){
				break;
			}else{
				sl.add(ss);
			}
		}
		return sl;
	}
	
	private String toTr(List<PropertyUnit> ul){//根据floor得到TR
		String fl = "";
		List<PropertyUnit> temp = new ArrayList<PropertyUnit>();
		temp.addAll(ul);
		StringBuffer sb = new StringBuffer();
		sb.append("<tr>");
		if(ul.size() == 0)return null;
		fl = ul.get(0).getFloorNum();
		for(PropertyUnit u : temp){
			if(u.getFloorNum() == fl){
				sb.append(toTd(u));
				ul.remove(u);
			}
		}
		sb.append("</tr>");
		return sb.toString();
	}
	
	private String toTd(PropertyUnit u){//根据UNIT得到TD
		StringBuffer sb = new StringBuffer();
		String css = "";//css 确定State
		css = "class='"+bindType(u.getId())+"'";
		String uid = "uid='"+u.getId()+"'";
		sb.append("<td "+css+uid+" >");
		sb.append(u.getUnitNo());
		sb.append("</td>");
		return sb.toString();
	}
	
	private String bindType(int uid){
		
		//检查UID是是否绑定 未绑定 "no"  主"isa"  附"isb"
		UnitBindCond cond = new UnitBindCond();
		cond.setMainUnitId(uid+"");
		List<UnitBind> b = this.iUnitBindServices.findUnitBind(cond);
		if(b != null && b .size() >0){
			return "isa";
		}
		
		cond.setMainUnitId("");
		cond.setSlaveUnitId(uid+"");
		b = this.iUnitBindServices.findUnitBind(cond);
		if(b != null && b.size() > 0){
			return "isb";
		}
		
		return "no";
	}
	
	
	
	
	/**************************************************/
	public List<String> getTableTrList() {
		return tableTrList;
	}

	public PropertyUnitCond getUnitCond() {
		return unitCond;
	}

	public void setUnitCond(PropertyUnitCond unitCond) {
		this.unitCond = unitCond;
	}
	
	
	
	
}
