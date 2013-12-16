<%@ page import="java.io.OutputStream"%>
<%@ page import="java.util.List"%>
<%@ page import="com.ihk.customer.data.pojo.*"%>
<%@ page import="com.ihk.customer.data.services.*"%>
<%@ page import="com.ihk.customer.data.pojo.*"%>
<%@ page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@page contentType="text/html;charset=gbk" pageEncoding="GBK"%>
<%@page import="java.text.DateFormat"%>



<%

    //本地存放路径
    String s2 = "C:\\expdata.xml";
	
	
    response.setContentType("application/unknown;");
    response.addHeader("Content-Disposition", "attachment; filename=expdata.xml");
    OutputStream bos = response.getOutputStream();


    try{
    
        if (session.getAttribute("allCustomerList")!=null){
        	
        	 List tmpList = (List)session.getAttribute("allCustomerList");

            //头
            String line_top="<?xml version=\"1.0\" encoding=\"GB2312\"?>\n" +
                    "<?mso-application progid=\"Excel.Sheet\"?>\n" +
                    "<Workbook\n" +
                    "xmlns:x=\"urn:schemas-microsoft-com:office:excel\"\n" +
                    "xmlns=\"urn:schemas-microsoft-com:office:spreadsheet\"\n" +
                    "xmlns:ss=\"urn:schemas-microsoft-com:office:spreadsheet\">\n" +
                    "\n" +
                    "<Styles>\n" +
                    "<Style ss:ID=\"Default\" ss:Name=\"Normal\">\n" +
                    "<Alignment ss:Vertical=\"Bottom\"/>\n" +
                    "<Borders/>\n" +
                    "<Font/>\n" +
                    "<Interior/>\n" +
                    "<NumberFormat/>\n" +
                    "<Protection/>\n" +
                    "</Style>\n" +
                    "<Style ss:ID=\"s27\">\n" +
                    "<Font x:Family=\"Swiss\" ss:Color=\"#0000FF\" ss:Bold=\"1\"/>\n" +
                    "</Style>\n" +
                    "<Style ss:ID=\"s21\">\n" +
                    "<NumberFormat ss:Format=\"yyyy\\-mm\\-dd\"/>\n" +
                    "</Style>\n" +
                    "<Style ss:ID=\"s22\">\n" +
                    "<NumberFormat ss:Format=\"yyyy\\-mm\\-dd\\ hh:mm:ss\"/>\n" +
                    "</Style>\n" +
                    "<Style ss:ID=\"s23\">\n" +
                    "<NumberFormat ss:Format=\"hh:mm:ss\"/>\n" +
                    "</Style>\n" +
                    "</Styles>\n" +
                    "\n" +
                    "<Worksheet ss:Name=\"Sheet1\">\n" +
                    "<ss:Table>\n";

            bos.write(line_top.getBytes(),0,line_top.getBytes().length);
            //内容

            String[] colname = {"销售人员","日期","客户姓名","性别","电话","固话","同行人数","是否首次到场","是否业主",
                    "客户背景","是否有提及关系户","需求面积","投资额度","影响客户购买的原因","意向区域","客户初步评级",
                    "评级备注","备注1","备注2","备注3","备注4","经办人"
            };

            String line = "<ss:Row>\n" ;

            for(int i=0 ;i<colname.length;i++){
                line+= "<ss:Cell ss:StyleID=\"s27\"><Data ss:Type=\"String\">"+colname[i]+"</Data></ss:Cell>\n";
            }

            line+= "</ss:Row>\n";

            bos.write(line.getBytes(),0,line.getBytes().length);

            for(int i=0 ;i<tmpList.size();i++){
            	Customer cust=(Customer)tmpList.get(i);

                String mobileNo =  cust.getHomePhone()==null?"":  cust.getHomePhone();
                String telNo =  cust.getPhone()==null?"":  cust.getPhone();
                
                String is_first="";
              	if(cust.getIsFirst()==null){
              		is_first = "";
             	}else if(cust.getIsFirst().equals("0")){
            		is_first = "否";
             	}else{
             		is_first = "是";
             	}
                String is_owner=""; 
               if(cust.getIsOwner()==null){
               	is_owner="";
               }else if(cust.getIsOwner().equals("0")){
               	is_owner="否";
               }else{
                	is_owner="是";
                }
                String rating =  cust.getRating()==null?"":  cust.getDescRating();
				String gender = cust.getGender().equals("0")?"女":"男";
				String pri ="";
				if(cust.getPriceAmount()==null || cust.getPriceAmount().equals("")){
					pri ="";
				}else{
					pri =cust.getDescPriceAmount();
				}
				
                String reqArea = cust.getRequestArea()==null?"":cust.getDescCustomerRequestArea();
                String inPart = cust.getIntentionPart()==null?"":cust.getDescIntentionPart();
              
                line = "<ss:Row>\n" +
                        "  <ss:Cell><Data ss:Type=\"String\">"+cust.getDescUserId()+"</Data></ss:Cell>\n" +
                        "  <ss:Cell><Data ss:Type=\"String\">"+DateFormat.getDateInstance().format(cust.getCreatedTime())+"</Data></ss:Cell>\n" +
                        "  <ss:Cell><Data ss:Type=\"String\">"+cust.getCustomerName()+"</Data></ss:Cell>\n" +
                        "  <ss:Cell><Data ss:Type=\"String\">"+gender+"</Data></ss:Cell>\n"  ;
                line +="  <ss:Cell><Data ss:Type=\"String\">"+telNo +"</Data></ss:Cell>\n" ;
                line +="  <ss:Cell><Data ss:Type=\"String\">"+mobileNo +"</Data></ss:Cell>\n" ;

                line +="  <ss:Cell><Data ss:Type=\"String\">"+cust.getPeerNumber() +"</Data></ss:Cell>\n" ;
                line +="  <ss:Cell><Data ss:Type=\"String\">"+is_first +"</Data></ss:Cell>\n" ;
                line +="  <ss:Cell><Data ss:Type=\"String\">"+is_owner +"</Data></ss:Cell>\n" ;
                line +="  <ss:Cell><Data ss:Type=\"String\">"+cust.getBackground() +"</Data></ss:Cell>\n" ;

                line +="  <ss:Cell><Data ss:Type=\"String\">"+cust.getRelationDesc()  +"</Data></ss:Cell>\n" ;
                line +="  <ss:Cell><Data ss:Type=\"String\">"+reqArea  +"</Data></ss:Cell>\n" ;
                line +="  <ss:Cell><Data ss:Type=\"String\">"+pri +"</Data></ss:Cell>\n" ;
                line +="  <ss:Cell><Data ss:Type=\"String\">"+cust.getBuyReson()+"</Data></ss:Cell>\n" ;
                line +="  <ss:Cell><Data ss:Type=\"String\">"+inPart+"</Data></ss:Cell>\n" ;
                line +="  <ss:Cell><Data ss:Type=\"String\">"+rating +"</Data></ss:Cell>\n" ;
        
                line +="  <ss:Cell><Data ss:Type=\"String\">"+cust.getRatingRemark() +"</Data></ss:Cell>\n" ;
                line +="  <ss:Cell><Data ss:Type=\"String\">"+cust.getRemark1() +"</Data></ss:Cell>\n" ;
                line +="  <ss:Cell><Data ss:Type=\"String\">"+cust.getRemark2()+"</Data></ss:Cell>\n" ;
                line +="  <ss:Cell><Data ss:Type=\"String\">"+cust.getRemark3() +"</Data></ss:Cell>\n" ;
                line +="  <ss:Cell><Data ss:Type=\"String\">"+cust.getRemark4() +"</Data></ss:Cell>\n" ;
                line +="  <ss:Cell><Data ss:Type=\"String\">"+cust.getDescUserId() +"</Data></ss:Cell>\n" ;



                line += "</ss:Row>\n";
                bos.write(line.getBytes(),0,line.getBytes().length);

                //--------------end
                

            }


            //底
            String line_bottom ="</ss:Table>\n" +
                    "</Worksheet>\n" +
                    "</Workbook>";




            bos.write(line_bottom.getBytes(),0,line_bottom.getBytes().length);
            bos.flush();
            bos.close();
        }
        bos.close();
    }catch(Exception e){
        e.printStackTrace() ;
        System.out.println("export Exception error:"+e.toString());
    }finally{
        try{
        	out.clear();
        	out = pageContext.pushBody();
            bos.flush();
        }catch(Exception e){
            System.out.println("export error:"+e.toString());
        }
        bos.close() ;
    }

%>
