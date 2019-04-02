<header> 
  <div class="header">
  <div class="rowFluid">
    <div class="span2 col-md-12">
      <div class="logo"> <a href="${context.contextPath}/index.do" title="返回首页"> <img src="${context.contextPath}/skin/images/logo.png" alt="响应式公司网站模板(自适应移动设备)" /> </a> </div>
    </div>
    <div class="span8">
      <div class="mobileMenuBtn"><span class="span1"></span><span class="span2"></span><span class="span3"></span></div>
      <div class="mobileMenuBtn_shad"></div>
      <div class="header_menu">
        <ul id="menu">
          <li><a href="${context.contextPath}/index.do"  class='active'  title="首页">首页</a></li>
          
          <li><a href="${context.contextPath}/solution.do" title="解决方案">解决方案</a></li>
          
          <li><a href="${context.contextPath}/about.do" title="关于我们">关于我们</a></li>
          
          <li><a href="${context.contextPath}/clientCase.do" title="客户案例">客户案例</a></li>
          
          <li><a href="${context.contextPath}/programWebsite.do" title="建站方案">建站方案</a></li>
          
          <li><a href="${context.contextPath}/news.do" title="新闻资讯">新闻资讯</a></li>
          
          <li><a href="${context.contextPath}/technicalSupport.do" title="技术支持">技术支持</a></li>
          
          <li><a href="${context.contextPath}/contact.do" title="联系我们">联系我们</a></li>
          
        </ul>
      </div>
    </div>
    <div class="span2"> </div>
  </div>
</div>
<script src="${context.contextPath}/js/hearder.js"></script>
<script>
			$(function() {

				var strUrl, strHref;

				var Navs = document.getElementById("menu").getElementsByTagName("a");

				strUrl = location.href.toLowerCase();

				for(var i = 0; i < Navs.length; i++) {

					if(strUrl.indexOf(Navs[i].getAttribute("href")) != -1) {

						Navs[i].className = "active";

					} else {

						Navs[i].className = "";

					}

				}

				if($("#menu a.active").length == 0) {
					Navs[0].className = "active";
				}

			})
    </script>
</header> 
