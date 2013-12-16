package com.ihk.utils.saleunitnew;

import java.util.List;

import com.ihk.property.data.pojo.UnitImage;

/**
 * 单元图片工具类
 *
 */
public class UnitImageUtils {
	
	private static final String TR_START = "<tr onMouseOver=\"this.style.backgroundColor='#f1f9fe';\"" +
			" onMouseOut=\"this.style.backgroundColor=''\" bgcolor=\"#FFFFFF\" style=\"line-height: 20px;\" class=\"imageTr\">";
	
	private static final String TD_START = "<td width=\"100\" align=\"center\" valign=\"middle\">";
	
	private static final String TR_END = "</tr>";
	
	private static final String TD_END = "</td>";
	
	/**
	 * 获取tr
	 * @param imageList
	 * @return
	 */
	public static String getImageInfo(List<UnitImage> imageList){
		
		StringBuffer sb = new StringBuffer();
		
		int size = imageList.size();
		for(int i=0; i<size; i++){
			
			UnitImage image = imageList.get(i);
			
			sb.append(TR_START)
				.append(TD_START).append(image.getContext()).append(TD_END) //内容
				.append(TD_START).append(getShowHref(image.getUrl())).append(TD_END) //查看
				.append(TD_START).append(getDeleteHref(image.getId(), i+1)).append(TD_END) //删除
				.append(TR_END)
				;
		}
		
		/**
		 *  <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="line-height: 20px;"> 
		  	<td width="100" align="center" valign="middle">
				单元平面图1
			</td> 
			
			<td width="100" align="center" valign="middle">
				<a id="unitImageShow" href="#" style="color:#1199FF; text-decoration:underline" onclick="return showImageDiv('src');">查看</a>
			</td> 
			
			<td width="100" align="center" valign="middle">
				<a id="unitImageShow" href="#" style="color:#1199FF; text-decoration:underline" onclick="return showImageLg();">删除</a>
			</td> 
		  </tr>
		 */
		
		return sb.toString();
	}
	
	public static String getShowHref(String src){
		
		String ret = "<a href=\"javascript:void(0)\" style=\"color:#1199FF; text-decoration:underline\" onclick=\"return showImageDiv('" + src + "');\">查看</a>";
		
		return ret;
		
	}
	
	public static String getDeleteHref(int imageId, int rowNo){
		
		String ret = "<a href=\"javascript:void(0)\" style=\"color:#1199FF; text-decoration:underline\" onclick=\"return deleteImage('" + imageId + "','" + rowNo + "');\">删除</a>";
		
		return ret;
	}
	
}
