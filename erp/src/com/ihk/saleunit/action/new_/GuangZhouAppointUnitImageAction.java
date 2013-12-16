package com.ihk.saleunit.action.new_;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ihk.constanttype.EnumCodeTypeName;
import com.ihk.property.data.pojo.PropertyUnit;
import com.ihk.property.data.pojo.UnitImage;
import com.ihk.property.data.services.IPropertyUnitServices;
import com.ihk.property.data.services.IUnitImageServices;
import com.ihk.utils.CommonPojoUtils;
import com.ihk.utils.CommonUtils;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.DescUtils;
import com.ihk.utils.SupperAction;
import com.ihk.utils.saleunitnew.UnitImageUtils;
import com.ihk.utils.upload.UploadUtils;


/**
 *  单元图片
 */
@SuppressWarnings("rawtypes")
public class GuangZhouAppointUnitImageAction extends SupperAction{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	IPropertyUnitServices unitServices;
	@Autowired
	IUnitImageServices unitImageServices; 
	
	public String unitImage() throws Exception{
		
		int unitId = Integer.parseInt(request.getParameter("id"));
		
		unit = unitServices.findPropertyUnitById(unitId);
		
		return "unitImage";
	}
	
	public String getUnitImageUrl() throws Exception{
		
		String url = "";

		try{
			
			int unitId = Integer.parseInt(request.getParameter("unitId"));
			unit = unitServices.findPropertyUnitById(unitId);
			
			if(unit != null){
				//url = "upload/0612143858.jpg";
				url = unitImageServices.findUnitImageByUnitId(unit.getId()).get(0).getUrl();
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		CustomerUtils.writeResponse(response, url);
		
		return null;
	}
	
	public String getUnitImageIsCanShow() throws Exception{
		
		String data = "";

		try{
			
			int unitId = Integer.parseInt(request.getParameter("unitId"));
			unit = unitServices.findPropertyUnitById(unitId);
			
			if(unit != null){
				 List<UnitImage> tmpList = unitImageServices.findUnitImageByUnitId(unit.getId());
				 if(!CommonUtils.isCollectionEmpty(tmpList)){
					 data = "true";
				 }
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		CustomerUtils.writeResponse(response, data);
		
		return null;
	}
	
	/**
	 * 
	 * 判断该单元是否有图片
	 * @return <tr>...</tr>(可以查看及删除)
	 * @throws Exception
	 */
	public String getUnitImageInfo() throws Exception{
		
		String data = "";

		try{
			
			int unitId = Integer.parseInt(request.getParameter("unitId"));
			unit = unitServices.findPropertyUnitById(unitId);
			
			if(unit != null){
				 List<UnitImage> tmpList = unitImageServices.findUnitImageByUnitId(unit.getId());
				 if(!CommonUtils.isCollectionEmpty(tmpList)){
					 
					 data = UnitImageUtils.getImageInfo(tmpList);
				 }
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		CustomerUtils.writeResponse(response, data);
		
		return null;
	}
	
	/**
	 * 查找一些下拉框的值及单元id
	 * @return
	 * @throws Exception
	 */
	public String toUploadUnitImage() throws Exception{
		
		unitId = request.getParameter("unitId");
		init();
		
		return "toUploadUnitImage";
	}
	
	public String uploadUnitImage() throws Exception{
		
		try{
			
			String unitId = request.getParameter("unitIdValue");
			String type = request.getParameter("type");
			String context = request.getParameter("context");
			String url = UploadUtils.uploadFile(getUnitImage(), getUnitImageFileName());
			
			UnitImage unitImage = new UnitImage();
			unitImage.setUid(Integer.parseInt(unitId));
			unitImage.setType(type);
			unitImage.setContext(context);
			unitImage.setUrl(url);
			CommonPojoUtils.initPojoCommonFiled(unitImage);
			
			unitImageServices.addUnitImage(unitImage);
			
			setUpMarkToClose();
			setUploadStr("图片上传成功");
			setLoadClose("true");
			
		}catch(Exception e){
			setUploadStr("图片上传失败,请重试");
		}
		
		init();
		
		return "uploadUnitImage";
	}
	
	public String toShowImageIframe() throws Exception{
		
		imageList = new ArrayList<UnitImage>();
		try{
			
			int unitId = Integer.parseInt(request.getParameter("unitId"));
			imageList = unitImageServices.findUnitImageByUnitId(unitId);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return "toShowImageIframe";
	}

	public String deleteUnitImage() throws Exception{

		String out = "";
		int imageId = Integer.parseInt(request.getParameter("imageId"));
		
		try{
			
			unitImageServices.deleteUnitImage(imageId);
			out = "true";
			
		}catch(Exception e){
		}
		
		CustomerUtils.writeResponse(response, out);
		
		return null;
	}
	
	private void init(){
		
		selImageType = DescUtils.getInitSelForGuangZhou(selImageType, EnumCodeTypeName.SALEUNIT_PIC_TYPE);
	}
	
	///
	private PropertyUnit unit;
	private String unitId;
	
	private File unitImage;
	private String unitImageFileName; //根据unitImage自动绑定文件名
	private String unitImageContentType; //根据unitImage自动绑定文件类型
	
	private String uploadStr;
	private String loadClose; //是否关闭上传弹出框,"true"就关闭
	
	private List<UnitImage> imageList; //图片显示
	
	private LinkedHashMap selImageType; //图片类型
	
	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}
	
	public String getUnitId() {
		return unitId;
	}
	
	public void setSelImageType(LinkedHashMap selImageType) {
		this.selImageType = selImageType;
	}
	
	public LinkedHashMap getSelImageType() {
		return selImageType;
	}
	
	public void setLoadClose(String loadClose) {
		this.loadClose = loadClose;
	}
	
	public String getLoadClose() {
		return loadClose;
	}
	
	public void setImageList(List<UnitImage> imageList) {
		this.imageList = imageList;
	}
	
	public List<UnitImage> getImageList() {
		return imageList;
	}
	
	public void setUploadStr(String uploadStr) {
		this.uploadStr = uploadStr;
	}
	
	public String getUploadStr() {
		return uploadStr;
	}

	public File getUnitImage() {
		return unitImage;
	}

	public void setUnitImage(File unitImage) {
		this.unitImage = unitImage;
	}

	public String getUnitImageFileName() {
		return unitImageFileName;
	}

	public void setUnitImageFileName(String unitImageFileName) {
		this.unitImageFileName = unitImageFileName;
	}

	public String getUnitImageContentType() {
		return unitImageContentType;
	}

	public void setUnitImageContentType(String unitImageContentType) {
		this.unitImageContentType = unitImageContentType;
	}

	public void setUnit(PropertyUnit unit) {
		this.unit = unit;
	}
	
	public PropertyUnit getUnit() {
		return unit;
	}
	

}
