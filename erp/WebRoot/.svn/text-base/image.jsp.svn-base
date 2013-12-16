<%@ page contentType="image/jpeg" import="javax.imageio.ImageIO,
                                          javax.servlet.ServletOutputStream,
                                          java.awt.*,
                                          java.awt.image.BufferedImage,
                                          java.io.IOException,
                                          java.util.Random" %><%!
  Color getRandColor(int fc, int bc) {//给定范围获得随机颜色
    Random random = new Random();
    if (fc > 255) fc = 255;
    if (bc > 255) bc = 255;
    int r = fc + random.nextInt(bc - fc);
    int g = fc + random.nextInt(bc - fc);
    int b = fc + random.nextInt(bc - fc);
    return new Color(r, g, b);
  }
//  private int index = 0;
  Font getFont() {
    Random random = new Random();
    int index = random.nextInt(fontNames.length);
    String name = fontNames[index];
//    String name = fontNames[index++];
//    System.out.println("name = " + name);
    int style = random.nextInt(3);
    return new Font(name, style, 22);
  }
  String[] winFontNames = new String[]{
          "Arial", "Basemic", "Century", "Courier", "Dotum", "Garamond", "Gulim",
          "LiSu", "MingLiU", "Tahoma", "Times New Roman", "Verdana", "Serif.bold"
  };
  String[] linuxFontNames = new String[]{
          "Aharoni Book", "Baekmuk Dotum", "Bitstream Charter", "Courier", "David Medium",
          "Frank Ruehl Medium", "Luxi Mono Regular", "Monospaced.plain", "Nimbus Mono L Regular", "Serif.plain", "Utopia Regular"
  };
  String[] fontNames = System.getProperty("os.name").toLowerCase().indexOf("windows") > -1 ? winFontNames : linuxFontNames;
%><%
  //设置页面不缓存
  response.setHeader("Pragma", "No-cache");
  response.setHeader("Cache-Control", "no-cache");
  response.setDateHeader("Expires", 0);
//生成随机类
  Random random = new Random();
// 在内存中创建图象
  int width = 75 + random.nextInt(3), height = 25 + random.nextInt(3);
  BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
// 获取图形上下文
  Graphics g = image.getGraphics();
// 设定背景色
  g.setColor(getRandColor(200, 250));
  g.fillRect(0, 0, width, height);
  g.setColor(Color.BLACK);
  g.drawRect(0, 0, width - 1, height -1);
//设定字体
//画边框
//g.setColor(new Color());
//g.drawRect(0,0,width-1,height-1);
// 随机产生155条干扰线，使图象中的认证码不易被其它程序探测到

/**
  g.setColor(getRandColor(160, 200));
  for (int i = 0; i < 217; i++) {
    int x = random.nextInt(width);
    int y = random.nextInt(height);
    int xl = random.nextInt(12);
    int yl = random.nextInt(12);
    g.drawLine(x, y, x + xl, y + yl);
  }
  **/
// 取随机产生的认证码(4位数字)
  String sRand = "";
  int len = 4;
  String refer = request.getHeader("Referer");
/*
    sRand = getGuid(len).toUpperCase();
  char[] chars = sRand.toCharArray();
  //(int) (Math.random() * 26D) + 65
*/
  g.setFont(getFont());
  for (int i = 0; i < len; i++) {
    int c = (int) (random.nextInt(10));
    String rand = String.valueOf(c);
    sRand += rand;
    // 将认证码显示到图象中
    g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
    //调用函数出来的颜色相同，可能是因为种子太接近，所以只能直接生成
    g.drawString(rand, 8 + 16 * i + random.nextInt(5), 18 + random.nextInt(7));
  }
  g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
  int y1;
  int y2;
  if (random.nextInt(2) == 1) {
    y1 = random.nextInt(height / 2);
    y2 = height / 2 + random.nextInt(height / 2);
  } else {
    y1 = height / 2 + random.nextInt(height / 2);
    y2 = random.nextInt(height / 2);
  }
 // g.drawLine(0, y1, width, y2);
//    g.drawLine(0, y1+1, width, y2+1);
//    g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
//    g.drawLine(random.nextInt(width/2),0,width/2+random.nextInt(width),height);
/*
  boolean hasYesky = false;
  if (refer != null && refer.trim().length() > 0) {
    String lower = refer.trim().toLowerCase();
    if (lower.indexOf("yesky.com") >= 0 || lower.indexOf("chinabyte.com") >= 0
            || lower.indexOf("cseek.com") >= 0 || lower.indexOf("myhard.com") >= 0) {
      hasYesky = true;
    }
  }
  if (!hasYesky) {
    sRand += " referError";
  }
*/
// 将认证码存入SESSION
  session.setAttribute("rand", sRand);
// 图象生效
  g.dispose();
// 输出图象到页面
  ServletOutputStream outputStream = null;
  try {
    outputStream = response.getOutputStream();
    ImageIO.write(image, "JPEG", outputStream);
  } finally {
    if (outputStream != null) {
      try {
        outputStream.close();
      } catch (IOException e) {
      }
    }
  }
%>