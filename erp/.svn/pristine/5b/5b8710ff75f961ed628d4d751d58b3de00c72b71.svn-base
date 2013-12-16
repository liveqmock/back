package com.ihk.customer.collection.action;

import com.ihk.customer.collection.IVipCustImpMapper;
import com.ihk.customer.collection.pojo.VipCustImp;
import com.ihk.customer.collection.pojo.VipCustImpCond;
import com.ihk.utils.CustomerUtils;
import com.ihk.utils.ExportExcel;
import com.ihk.utils.SessionUser;
import com.ihk.utils.SupperAction;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * vip 客户资料上传
 */
@SuppressWarnings("serial")
public class UploadAction extends SupperAction{
    private final Logger logger = Logger.getLogger(UploadAction.class);

    private String msg="";  //返回页面信息
    int i = 0;       //计数用，返回页面保存多少条记录
    int ii = 0;      //计数用，返回重复多少条记录
    List<VipCustImp> dataset = new ArrayList<VipCustImp>();

    @Autowired
    IVipCustImpMapper iVipCustImpMapper;
    private File upload; 				//上传的文件
    public File getUpload() {
        return upload;
    }
    public void setUpload(File upload) {
        this.upload = upload;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * vip客户导入页面   点击“上传”按钮
     * @return
     * @throws Exception
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public String upload() throws Exception {
        FileInputStream is = null;
        Workbook wb=null;

        if(upload == null) {
            CustomerUtils.writeResponse(response, "错误：上传失败。（代码：upload is null.）" );
            return "fail";
        }

        int j = 1;
        int k = 0;

        try{
            String act = request.getParameter("act");
            if(act!=null && act.equals("del")){
                iVipCustImpMapper.deleteVipCustImpALL();
                iVipCustImpMapper.deleteVipCustALL();
                iVipCustImpMapper.deleteVipCustdealALL();
            }

            is = new FileInputStream(upload);
            wb = WorkbookFactory.create(is);

            Sheet sheet = wb.getSheetAt(0);
            int maxSize = sheet.getLastRowNum(); //excel的总行数
            //遍历excel
            for( j = 1;j <= maxSize; j++){
                Row row = sheet.getRow(j);
                Map map = new HashMap();

                for ( k = 0; k < row.getLastCellNum(); k++) {
                    Cell cell = row.getCell(k);
                    if(cell != null){
                        String key= sheet.getRow(0).getCell(k).getRichStringCellValue().getString();
                        switch (cell.getCellType()) {
                            //字符串
                            case Cell.CELL_TYPE_STRING:
                                map.put(key, cell.getRichStringCellValue().getString());
                                break;
                            //数字
                            case Cell.CELL_TYPE_NUMERIC:
                                if (DateUtil.isCellDateFormatted(cell)) {
                                    map.put(key, cell.getDateCellValue());
                                } else {
                                    map.put(key, cell.getNumericCellValue());
                                }
                                break;
                            //boolean
                            case Cell.CELL_TYPE_BOOLEAN:
                                map.put(key, cell.getBooleanCellValue());
                                break;
                            //方程式
                            case Cell.CELL_TYPE_FORMULA:
                                map.put(key, cell.getCellFormula());
                                break;
                            //空值
                            default:
                                map.put(key, "");
                        }
                    }

                }
                //将excel数据保存进vipCustImp
                ToUpdateVipCustImp(map,act);

            }

            ExportExcel<VipCustImp> ex = new ExportExcel<VipCustImp>();

            String[] headers ={"","原始表行号","客户编号","来源","客户姓名","日期","身份证号","固话","移动电话","联系地址","居住区域","行政区域","工作区域",
                    "户籍","项目名称","组团","楼栋","楼层","房号","购买总价","建筑面积","套内面积","属性","付款方式","商圈","类型"};

            String webroot = request.getRealPath("/");
            OutputStream out = new FileOutputStream(webroot+"\\upload\\imp_err.xls");
            String outMsg = "";
            if(msg!=null && msg.length()>0){

                outMsg = "以下重复：<a href='upload/imp_err.xls'>下载重复数据</a>（"+dataset.size()+"条)";
                try {
                    ex.exportExcel(headers, dataset, out);
                }catch (Exception e){
                    outMsg = "重复数据导出异常，请联技术人员,"+e.getMessage();
                }finally {
                    if(out!=null){
                        out.flush();
                        out.close();
                    }
                }

                CustomerUtils.writeResponse(response, "上传成功。(共："+i+"条),"+outMsg );
            } else {
                try {
                    ex.exportExcel(headers, dataset, out);
                }catch (Exception e){
                    //outMsg = "重复数据导出异常，请联技术人员,"+e.getMessage();
                    logger.warn("生成空的execl："+e.getMessage());
                }finally {
                    if(out!=null){
                        out.flush();
                        out.close();
                    }
                }
                CustomerUtils.writeResponse(response, "上传成功。(共："+i+"条)");
            }
        }catch(Exception e){
            e.printStackTrace();
            CustomerUtils.writeResponse(response, "错误：第"+j+"行，第" +k+"列，代码（"+ e.getMessage()+")");
        }

        return null;
    }

    @SuppressWarnings({ "rawtypes" })
    private void ToUpdateVipCustImp(Map map,String act) throws Exception{

        VipCustImp vipCustImp = new VipCustImp();
        String source = (String) map.get("来源");

        if(source!=null && source.length()>0){
            vipCustImp.setCompanyId(SessionUser.getCompanyId());
            vipCustImp.setSource(source);

            vipCustImp.setAdArea((String) map.get("所在地行政区"));
            vipCustImp.setAreaSize((Double) map.get("套内面积"));
            /*vipCustImp.setAttribute((String) map.get("属性")); //暂不用*/
            vipCustImp.setBusinesscircle((String) map.get("商圈"));
            vipCustImp.setConstructtype((String) map.get("普通住宅/豪宅/写字楼/商业"));


            String contactaddr = "";
            if(map.get("联系地址")!=null && !map.get("联系地址").toString().isEmpty()){
                contactaddr = map.get("联系地址").toString();
            }

            vipCustImp.setContactAddr(contactaddr);
            vipCustImp.setCreatedate(new Date());

            //由系统生成 ,暂不用
            //vipCustImp.setCustomerNo((String) map.get("客户编号"));

            try{
                //对日期的处理
                vipCustImp.setDealDate((Date) map.get("日期"));
            }catch (Exception e){
                String dealdate = (String) map.get("日期");
                if(dealdate!=null && dealdate.length()>0){
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
                    Date d_dealdate = sdf.parse(dealdate);
                    vipCustImp.setDealDate(d_dealdate);
                }
            }

            String natives = (String) map.get("户籍");
            vipCustImp.setNatives(natives);

            vipCustImp.setPaymethod((String) map.get("付款方式"));
            vipCustImp.setProjectName((String) map.get("项目名称"));
            vipCustImp.setArea((String) map.get("组团"));
            vipCustImp.setResideArea((String) map.get("居住区域"));
            vipCustImp.setTel((String) map.get("固话"));
            vipCustImp.setTotal((Double) map.get("购买总价"));
            vipCustImp.setWordArea((String) map.get("工作区域"));
            vipCustImp.setBuilding((String) map.get("楼栋"));

            try{
                //对读excel会出现数字或字符的处理
                vipCustImp.setFloor((String) map.get("楼层"));
            }catch (Exception e){
                Double floor = (Double) map.get("楼层");
                DecimalFormat df=new DecimalFormat("#");
                vipCustImp.setFloor(df.format(floor));
            }

            vipCustImp.setRoom_no((String) map.get("房号"));
            vipCustImp.setConstruction_area((Double) map.get("建筑面积"));

            vipCustImp.setIsArrange("T");
            vipCustImp.setIsDeleted("0");

            //联名客户购买分离
            //1、身份证识别是否多个，2、手机识别是否多个
            String phone= replaceString((String) map.get("移动电话"));
            String customerName= (String) map.get("客户姓名");

            String idcardNo= replaceString((String) map.get("身份证号"));
            if(idcardNo.contains(",")){
                String[] idcardNoStr = idcardNo.split(",");
                String idcardNo1 = idcardNoStr[0];
                for(int i=1; i<idcardNoStr.length; i++) {
                    if(idcardNo1.equals(idcardNoStr[i])){
                        vipCustImp.setFlag(1);
                        vipCustImp.setMemo("身份证重复");
                    } else {
                        idcardNo1 = idcardNoStr[i];
                    }
                }

                vipCustImp.setCustomerName(replaceString(customerName));
            } else {
                vipCustImp.setCustomerName(customerName);
            }

            vipCustImp.setIdcardNo(idcardNo);
            vipCustImp.setPhone(phone);


            if(natives.trim().contains("国外") || natives.trim().contains("澳门")
                    || natives.trim().contains("台湾") || natives.trim().contains("香港")
                    || contactaddr.contains("公司") || customerName.contains("公司")){
                //户籍为国外香港澳门台湾 , 联系地址里面包括公司 均不用判断身份证
            } else {
                //判断身份证号是否符合规则 flag=1代表身份证或者移动电话不符合规则
                if(idcardNo==null || idcardNo.length()==0){
                    vipCustImp.setMemo("身份证为空");
                    vipCustImp.setFlag(1);
                } else {
                    if(!isNoIdentityNo(splitFullStr(idcardNo))){
                        vipCustImp.setMemo("身份证问题");
                        vipCustImp.setFlag(1);
                    }
                }

                //判断手机号是否符合规则
                if(!isNoPhone(splitFullStr(phone))) {
                    vipCustImp.setMemo("手机号问题");
                    vipCustImp.setFlag(1);
                }
            }

            //判断是否已经导入过数据，加入条件
            VipCustImpCond cond = new VipCustImpCond();
            cond.setArea(vipCustImp.getArea());   //区域
            cond.setBuilding(vipCustImp.getBuilding()); //楼栋
            cond.setFloor(vipCustImp.getFloor());  //楼层
            cond.setRoom_no(vipCustImp.getRoom_no()); //房号
            cond.setProject_name(vipCustImp.getProjectName()); //项目名
            cond.setIsDeleted("0");  //是否删除（否）
            cond.setFlag(-1);        //标志
            cond.setCompanyId(SessionUser.getCompanyId()); //客户所属公司，根据登录人所属公司判断


            //判读是否重复
            if(iVipCustImpMapper.findVipCustImpCount(cond)==0){
                if(!"test".equals(act)){   //模拟导入不保存数据
                    iVipCustImpMapper.addVipCustImp(vipCustImp);
                }
                i++;
            } else {
                //重复数据记录List
                ii++;
                msg += vipCustImp.getProjectName()+"("+vipCustImp.getBuilding()+"-"+vipCustImp.getFloor()+"-"+vipCustImp.getRoom_no()+");";

                dataset.add(new VipCustImp(ii,"",vipCustImp.getSource(),vipCustImp.getCustomerName(),
                        vipCustImp.getDealDate(),vipCustImp.getIdcardNo(),vipCustImp.getTel(),
                        vipCustImp.getPhone(),vipCustImp.getContactAddr(),vipCustImp.getResideArea(),vipCustImp.getAdArea(),
                        vipCustImp.getWordArea(),vipCustImp.getNatives(),vipCustImp.getProjectName(),
                        vipCustImp.getArea(),vipCustImp.getBuilding(),vipCustImp.getFloor(),vipCustImp.getRoom_no(),
                        vipCustImp.getTotal(),vipCustImp.getConstruction_area(),vipCustImp.getAreaSize(),
                        vipCustImp.getAttribute(),vipCustImp.getPaymethod(),
                        vipCustImp.getBusinesscircle(),
                        vipCustImp.getConstructtype())
                );

            }

        }
    }

    private static String replaceString(String str) throws Exception{
        if (str==null || str.length()==0) return "";
        //中文逗号替换
        str = str.replaceAll("，", ",");
        //顿号分割
        str = str.replaceAll("、", ",");
        //空格分割
        str = str.replaceAll(" ", ",");
        str = str.replaceAll("/", ",");
        str = str.replaceAll("\\\\", ",");

        str = str.replaceAll(",,", ",");
        str = str.replaceAll(",,,", ",");
        str = str.replaceAll(",,,,", ",");
        str = str.replaceAll(",,,,,", ",");

        return str;
    }
    private static String replaceStringNotNull(String str) throws Exception{
        if (str==null || str.length()==0) return "";
        //中文逗号替换
        str = str.replaceAll("，", ",");
        //顿号分割
        str = str.replaceAll("、", ",");
        //空格分割
        //str = str.replaceAll(" ", ",");
        str = str.replaceAll("/", ",");
        str = str.replaceAll("\\\\", ",");

        str = str.replaceAll(",,", ",");
        str = str.replaceAll(",,,", ",");
        str = str.replaceAll(",,,,", ",");
        str = str.replaceAll(",,,,,", ",");

        return str;
    }
    /**
     * 根据不同情况的分割符 将字符分割
     * @param str
     * @return
     */
    public static String[] splitFullStr(String str) throws Exception
    {
        if (str==null || str.length()==0) return null;
        String[] result = new String[]{};
        String idcardNo = "";

        //将所有分割符改为逗号隔开

        //中文逗号替换
        idcardNo = replaceString(str);

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


    /**
     * 验证手机号是否包含错误号码
     * @return
     * @throws Exception
     */
    private boolean isNoPhone(String[] mobile) throws Exception{
        if(mobile == null)
            return false;
        Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
        for(int i=0; i<mobile.length;i++){
            Matcher m = p.matcher(mobile[i]);
            if(m.matches() != true)
                return false;
        }
        return true;
    }

    /**
     * 验证身份证号是否包含错误证件号
     * @return
     * @throws Exception
     */
    @SuppressWarnings({ "unused" })
    private boolean isNoIdentityNo(String[] identityNo) throws Exception{
        String[] ValCodeArr = { "1", "0", "x", "9", "8", "7", "6", "5", "4",
                "3", "2" };
        String[] Wi = { "7", "9", "10", "5", "8", "4", "2", "1", "6", "3", "7",
                "9", "10", "5", "8", "4", "2" };
        if(identityNo == null || identityNo.length==0) {
            return false;
        }

        for(int i=0;i<identityNo.length;i++){
            //身份证号为15位或者18位
            if (identityNo[i].length() != 15 && identityNo[i].length() != 18) {
                return false;
            }
            //身份证号除最后一位，其他都是数字
            String Ai = "";
            if (identityNo[i].length() == 18) {
                Ai = identityNo[i].substring(0, 17);
            } else if (identityNo[i].length() == 15) {
                Ai = identityNo[i].substring(0, 6) + "19" + identityNo[i].substring(6, 15);
            }
            Pattern pattern = Pattern.compile("[0-9]*");
            Matcher isNum = pattern.matcher(Ai);
            if (!isNum.matches()) {
                return false;
            }


        }
        return true;
    }

}
