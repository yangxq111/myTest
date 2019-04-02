<!DOCTYPE html>
<html lang="zh-cn">
	<head>
		<meta charset="utf-8" />
		<title>页面测试</title>
		<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport" />
		<script  src="/js/jquery1.8.3.min.js"></script>
		<script >
			$(function(){ 
			var timer1=null;
				timer1=window.setInterval('startTime()',1000);
			});	
			 function startTime()     
            {     
                var today=new Date();//定义日期对象     
                var yyyy = today.getFullYear();//通过日期对象的getFullYear()方法返回年      
                var MM = today.getMonth()+1;//通过日期对象的getMonth()方法返回年      
                var dd = today.getDate();//通过日期对象的getDate()方法返回年       
                var hh=today.getHours();//通过日期对象的getHours方法返回小时     
                var mm=today.getMinutes();//通过日期对象的getMinutes方法返回分钟     
                var ss=today.getSeconds();//通过日期对象的getSeconds方法返回秒     
                // 如果分钟或小时的值小于10，则在其值前加0，比如如果时间是下午3点20分9秒的话，则显示15：20：09     
                MM=checkTime(MM);  
                dd=checkTime(dd);  
                mm=checkTime(mm);     
                ss=checkTime(ss);      
                var day; //用于保存星期（getDay()方法得到星期编号）  
                if(today.getDay()==0)   day   =   "星期日 ";
                if(today.getDay()==1)   day   =   "星期一 ";
                if(today.getDay()==2)   day   =   "星期二 ";
                if(today.getDay()==3)   day   =   "星期三 ";
                if(today.getDay()==4)   day   =   "星期四 ";
                if(today.getDay()==5)   day   =   "星期五 ";
                if(today.getDay()==6)   day   =   "星期六 ";
                document.getElementById('nowDateTimeSpan').innerHTML=yyyy+"-"+MM +"-"+ dd +" " + hh+":"+mm+":"+ss+"   " + day;     
            }     
              
            function checkTime(i)     
            {     
                if (i<10){  
                    i="0" + i;  
                }     
                  return i;  
            } 
		</script>
	</head>
	<body>
		<#--<#include "/head.ftl" > -->
		
		
		 <#--welcome ${name}  to freemarker!
    	年龄：${age}
    	<br>
	    <#list list as x>
	    	姓名：${x.username},
	    	时间：${x.complainsTime}
	    </#list>-->
	    
	    <br>
	    当前时间：<font color="#33FFFF"><span id="nowDateTimeSpan"></span></font>
	    
		<#--<#include "/foot.ftl" > 	-->
        <h1>欢迎登录!</h1>
        <form action="/admin/generateKey.do" method="post">
            <input type="text" name="username"><br>
            <input type="password" name="password"><br>
            <input type="submit" value="提交">
        </form>
	</body>
</html>