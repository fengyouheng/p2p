/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.37
 * Generated at: 2018-02-04 08:03:15 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class voice_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("    <script src=\"http://res.wx.qq.com/open/js/jweixin-1.2.0.js\"></script>\n");
      out.write("    <script type=\"text/javascript\" src=\"/js/jquery.min.js\"></script>\n");
      out.write("    <title></title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<div style=\"position:absolute;z-index:-1;width:98%;height:98%;\">\n");
      out.write("    <img src=\"https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2953033256,169502064&fm=27&gp=0.jpg\"\n");
      out.write("         width=\"100%\" height=\"100%\"/>\n");
      out.write("</div>\n");
      out.write("<br>\n");
      out.write("<br>\n");
      out.write("<br>\n");
      out.write("<br>\n");
      out.write("<br>\n");
      out.write("<br>\n");
      out.write("<br>\n");
      out.write("<br>\n");
      out.write("<br>\n");
      out.write("<br>\n");
      out.write("<br>\n");
      out.write("<br>\n");
      out.write("<br>\n");
      out.write("<br>\n");
      out.write("<select id=\"select\" style=\"width: 300px;font-size: 30px\">\n");
      out.write("    <option value=\"bzhw\">\n");
      out.write("        不知火舞\n");
      out.write("    </option>\n");
      out.write("    <option value=\"aql\">\n");
      out.write("        安琪拉\n");
      out.write("    </option>\n");
      out.write("    <option value=\"dj\">\n");
      out.write("        妲己\n");
      out.write("    </option>\n");
      out.write("    <option value=\"wzj\">\n");
      out.write("        王昭君\n");
      out.write("    </option>\n");
      out.write("</select>\n");
      out.write("<br>\n");
      out.write("<br>\n");
      out.write("<br>\n");
      out.write("<br>\n");
      out.write("<br>\n");
      out.write("<br>\n");
      out.write("<br>\n");
      out.write("<br>\n");
      out.write("<br>\n");
      out.write("<br>\n");
      out.write("<br>\n");
      out.write("<br>\n");
      out.write("<br>\n");
      out.write("<br>\n");
      out.write("<br>\n");
      out.write("<br>\n");
      out.write("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button class=\"start\"><h1>开始录音</h1>\n");
      out.write("</button>\n");
      out.write("&nbsp;&nbsp;&nbsp;<button class=\"stop\"><h1>停止录音</h1></button>\n");
      out.write("&nbsp;&nbsp;&nbsp;\n");
      out.write("<button class=\"play\"><h1>播放</h1></button>\n");
      out.write("&nbsp;&nbsp;&nbsp;\n");
      out.write("<button class=\"upload\"><h1>上传评分</h1></button>\n");
      out.write("<script>\n");
      out.write("    wx.config({\n");
      out.write("        debug: false,//开启调试模式\n");
      out.write("        appId: '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${appId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("',\n");
      out.write("        timestamp: '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${timestamp}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("',\n");
      out.write("        nonceStr: '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${nonceStr}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("',\n");
      out.write("        signature: '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${signature}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("',\n");
      out.write("        jsApiList: [\n");
      out.write("            // 所有要调用的 API 都要加到这个列表中\n");
      out.write("            'onMenuShareAppMessage',\n");
      out.write("            'startRecord',\n");
      out.write("            'stopRecord',\n");
      out.write("            'playVoice',\n");
      out.write("            'translateVoice',\n");
      out.write("            'uploadVoice'\n");
      out.write("        ]\n");
      out.write("    });\n");
      out.write("    wx.ready(function () {\n");
      out.write("        var start = document.querySelector(\".start\");\n");
      out.write("        var stop = document.querySelector(\".stop\");\n");
      out.write("        var play = document.querySelector(\".play\");\n");
      out.write("        var upload = document.querySelector(\".upload\");\n");
      out.write("        var localId = null;//用于记录录音ID\n");
      out.write("        var serverId = null;\n");
      out.write("        start.onclick = function () {\n");
      out.write("            alert(\"开始录音\");\n");
      out.write("            wx.startRecord();\n");
      out.write("        };\n");
      out.write("        stop.onclick = function () {\n");
      out.write("            wx.stopRecord({\n");
      out.write("                success: function (res) {\n");
      out.write("                    localId = res.localId;\n");
      out.write("                }\n");
      out.write("            });\n");
      out.write("        };\n");
      out.write("        play.onclick = function () {\n");
      out.write("            wx.playVoice({\n");
      out.write("                localId: localId // 需要播放的音频的本地ID，由stopRecord接口获得\n");
      out.write("            });\n");
      out.write("        };\n");
      out.write("\n");
      out.write("        upload.onclick = function () {\n");
      out.write("            if (!localId) {\n");
      out.write("                alert(\"骚年,不录音我怎么给你评分啊\");\n");
      out.write("                return;\n");
      out.write("            }\n");
      out.write("            var select = $('#select option:selected').text();\n");
      out.write("            wx.uploadVoice({\n");
      out.write("                localId: localId, // 需要上传的音频的本地ID，由stopRecord接口获得\n");
      out.write("                isShowProgressTips: 1, // 默认为1，显示进度提示\n");
      out.write("                success: function (res) {\n");
      out.write("                    serverId = res.serverId; // 返回音频的服务器端ID\n");
      out.write("                    window.location.href = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${indexUrl}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/result?localId=\" + localId + \"&personName=\" + select;\n");
      out.write("                }\n");
      out.write("            });\n");
      out.write("\n");
      out.write("        };\n");
      out.write("\n");
      out.write("        // 在这里调用 API\n");
      out.write("        wx.onMenuShareAppMessage({\n");
      out.write("            title: '来聆听我的美妙的呻吟吧', // 分享标题\n");
      out.write("            desc: '与王者英雄一起吟唱', // 分享描述\n");
      out.write("            link: 'http://baidu.com', // 分享链接\n");
      out.write("            imgUrl: 'https://gss1.bdstatic.com/-vo3dSag_xI4khGkpoWK1HF6hhy/baike/w%3D268%3Bg%3D0/sign=8fa6745028738bd4c421b53799b0e0eb/3b292df5e0fe9925e92362dd32a85edf8db1710b.jpg', // 分享图标\n");
      out.write("            type: '', // 分享类型,music、video或link，不填默认为link\n");
      out.write("            dataUrl: '', // 如果type是music或video，则要提供数据链接，默认为空\n");
      out.write("            success: function () {\n");
      out.write("                // 用户确认分享后执行的回调函数\n");
      out.write("                alert(\"分享成功\")\n");
      out.write("            },\n");
      out.write("            cancel: function () {\n");
      out.write("                // 用户取消分享后执行的回调函数\n");
      out.write("                alert(\"取消分享\")\n");
      out.write("            }\n");
      out.write("        });\n");
      out.write("    });\n");
      out.write("</script>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
