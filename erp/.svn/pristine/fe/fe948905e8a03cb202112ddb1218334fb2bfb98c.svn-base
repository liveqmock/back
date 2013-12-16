package com.ihk.saleunit.action.new_unit_group;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.property.data.pojo.PropertyBuild;
import com.ihk.property.data.pojo.PropertyBuildCond;
import com.ihk.property.data.pojo.PropertyGroup;
import com.ihk.property.data.pojo.PropertyGroupDetail;
import com.ihk.property.data.pojo.PropertyGroupDetailCond;
import com.ihk.property.data.services.IPropertyBuildServices;
import com.ihk.property.data.services.IPropertyGroupDetailServices;
import com.ihk.property.data.services.IPropertyGroupServices;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.saleunit.action.new_.GuangZhouAppointNewLeftAction;
import com.ihk.utils.ActionPageCallback;
import com.ihk.utils.ActionTemplate;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.MyTransationTemplate;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;

/**
 * 查询组团明细
 * 
 */
public class SearchPropertyGroupDetailAction extends SupperAction {

	private static final long serialVersionUID = 1L;

	@Autowired
	IPropertyGroupDetailServices propertyGroupDetailServices;
	@Autowired
	IPropertyGroupServices propertyGroupServices;
	@Autowired
	IPropertyBuildServices propertyBuildServices;
	@Autowired
	IPropertyUnitServices propertyUnitServices;
	private PropertyGroupDetailCond searchPropertyGroupDetailCond;
	private List<PropertyGroupDetail> searchListPropertyGroupDetail;
	private int groupId;

	/**
	 * 执行查询
	 */
	public String searchPropertyGroupDetail() throws Exception {
		if (searchPropertyGroupDetailCond == null) {
			searchPropertyGroupDetailCond = new PropertyGroupDetailCond();

			// searchPropertyGroupCond.setDate1(CommonUtils.getMonthFirstForString());
			// searchPropertyGroupCond.setDate2(CommonUtils.getMonthEndForString());
		}
		searchPropertyGroupDetailCond.setGroupId(groupId + "");
		PropertyGroup thisGroup = propertyGroupServices
				.findPropertyGroupById(groupId);
		request.getSession().setAttribute("thisGroup", thisGroup);

		ActionTemplate actionTemplate = new ActionTemplate(this,
				searchPropertyGroupDetailCond);
		actionTemplate.executePage(new ActionPageCallback() {

			@Override
			public void initActionPageList() {

				searchListPropertyGroupDetail = propertyGroupDetailServices
						.findPropertyGroupDetailPage(searchPropertyGroupDetailCond);
			}

		}, 20);

		if (searchListPropertyGroupDetail == null)
			searchListPropertyGroupDetail = new ArrayList<PropertyGroupDetail>();
		initSel();
		return "finish";
	}

	private List<List<String>> groList;
	public List<List<String>> getGroList() {
		return groList;
	}
	public void setGroList(List<List<String>> groList) {
		this.groList = groList;
	}
	/**
	 * 执行查询 Map
	 */
	public String searchPropertyGroupDetailMap() throws Exception {
		PropertyGroup thisGroup = propertyGroupServices
		.findPropertyGroupById(groupId);
		request.getSession().setAttribute("thisGroup", thisGroup);
		groList = GuangZhouAppointNewLeftAction.getStaticGroupStrByGroupId(groupId, propertyUnitServices, propertyBuildServices);
		return "finish";
	}

	private List<PropertyBuild> addGroupBuilds;

	public List<PropertyBuild> getAddGroupBuilds() {
		return addGroupBuilds;
	}

	public void setAddGroupBuilds(List<PropertyBuild> addGroupBuilds) {
		this.addGroupBuilds = addGroupBuilds;
	}

	/**
	 * 新建组团 弹窗
	 * 
	 * @param groupId
	 *            组团ID
	 * @return addGroupBuilds 项目下的所有build
	 * */
	public String dialogAddUnitForGroup() {
		PropertyBuildCond cond = new PropertyBuildCond();
		PropertyGroup thisGroup = propertyGroupServices
				.findPropertyGroupById(groupId);
		cond.setPropertyId(thisGroup.getProjectId() + "");
		addGroupBuilds = propertyBuildServices.findPropertyBuild(cond);
		return "dialog";
	}

	private String buildIds;
	private String unitIds;

	/**
	 * 新建组团的同时 给该组团添加明细 FORM
	 * 
	 * @param groupId
	 * @param buildIds
	 * @param unitIds
	 * */
	public String dialogAddUnitForGroupForm() throws IOException {//

		try {
			new MyTransationTemplate() {

				@Override
				protected void doExecuteCallback() throws Exception {
					PropertyGroupDetailCond cond = new PropertyGroupDetailCond();
					String[] buids;
					cond = new PropertyGroupDetailCond();
					PropertyGroupDetail pojo = new PropertyGroupDetail();
					pojo.setCreatedId(SessionUser.getUserId());
					pojo.setCreatedTime(new Date());
					pojo.setModId(SessionUser.getUserId());
					pojo.setModTime(new Date());
					cond.setPojo(pojo);
					cond.setGroupId(groupId + "");
					if (buildIds != null) {
						buids = buildIds.split(",");

						if (buids != null && buids.length > 0) {
							for (String bid : buids) {
								if (bid.trim().equals(""))
									continue;
								cond.setBuildId(Integer.parseInt(bid.trim())
										+ "");
								propertyGroupDetailServices
										.addUnitByBuildId(cond);
							}
						}
					}

					List<Integer> ids = initIds(unitIds);
					if (ids != null && ids.size() > 0) {
						cond.setIds(ids);
						propertyGroupDetailServices.addUnitByUnitIds(cond);
					}
					CustomerUtils.writeResponse(response, "操作成功");

				}
			}.execute();
		} catch (Exception e1) {
			e1.printStackTrace();
			CustomerUtils.writeResponse(response, "操作失败");
		}
		return null;
	}

	/**
	 * 查询页面需要信息初始化
	 * */
	private void initSel() {

	}

	/**
	 * ajax新增组团
	 * 
	 * @return
	 * @throws Exception
	 */
	public String ajaxCreatePropertyGroup() throws Exception {

		// 信息提示
		final Map<String, String> mapMassage = new HashMap<String, String>();

		try {
			new MyTransationTemplate() {

				@Override
				protected void doExecuteCallback() throws Exception {
					/**
					 * 新增前的一些数据处理 if(createPropertyGroup.getGroupName() == null
					 * || createPropertyGroup.getGroupName().trim().equals("")
					 * || createPropertyGroup.getChipType() == null ||
					 * createPropertyGroup.getChipType().trim().equals("") ||
					 * createPropertyGroup.getProjectId() == 0){ throw new
					 * Exception(); }
					 * createPropertyGroup.setCompanyProject(SessionUser
					 * .getProjectId()); //预处理表中的创建人信息
					 * CommonPojoUtils.initPojoCommonFiled(createPropertyGroup);
					 * 
					 * propertyGroupServices.addPropertyGroup(
					 * createPropertyGroup);
					 * 
					 * mapMassage.put("type", "true");
					 */

				}
			}.execute();

		} catch (Exception e) {

			mapMassage.put("type", "false");
			// mapMassage.put("message", e.getMessage());
			// mapMassage.put("message", "请填写完整的资料");
			e.printStackTrace();
		}

		CustomerUtils.writeResponse(response, CommonUtils
				.getMapJson(mapMassage));

		return null;
	}

	/**
	 * 根据string 拿Integer List
	 * */
	private List<Integer> initIds(String initIds) {

		if (initIds == null || initIds.trim().equals(""))
			return null;
		List<Integer> intIds = new ArrayList<Integer>();
		try {
			String[] ids = initIds.split(",");

			for (String uid : ids) {
				if (uid.trim().equals(""))
					continue;
				intIds.add(Integer.parseInt(uid.trim()));
			}
		} catch (Exception e) {
			return null;
		}
		return intIds;
	}

	public String getBuildIds() {
		return buildIds;
	}

	public void setBuildIds(String buildIds) {
		this.buildIds = buildIds;
	}

	public String getUnitIds() {
		return unitIds;
	}

	public void setUnitIds(String unitIds) {
		this.unitIds = unitIds;
	}

	public PropertyGroupDetailCond getSearchPropertyGroupDetailCond() {
		return searchPropertyGroupDetailCond;
	}

	public void setSearchPropertyGroupDetailCond(
			PropertyGroupDetailCond searchPropertyGroupDetailCond) {
		this.searchPropertyGroupDetailCond = searchPropertyGroupDetailCond;
	}

	public List<PropertyGroupDetail> getSearchListPropertyGroupDetail() {
		return searchListPropertyGroupDetail;
	}

	public void setSearchListPropertyGroupDetail(
			List<PropertyGroupDetail> searchListPropertyGroupDetail) {
		this.searchListPropertyGroupDetail = searchListPropertyGroupDetail;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

}
