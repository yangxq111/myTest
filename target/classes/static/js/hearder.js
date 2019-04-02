$(function () {
	
	//initMenu();
	var strUrl, strHref;

	var Navs = document.getElementById("menu").getElementsByTagName("a");

	strUrl = location.href;

	for(var i = 0; i < Navs.length; i++) {
		var attribute=Navs[i].getAttribute("href");
		var indexOf=strUrl.indexOf(Navs[i].getAttribute("href"));
		if(strUrl.indexOf(Navs[i].getAttribute("href")) != -1) {

			Navs[i].className = "active";

		} else {

			Navs[i].className = "";

		}

	}

	/*if($("#menu a.active").length == 0) {
        Navs[0].className = "active";
	}*/
	
	

});
function initMenu(){
	var html='';
	$("#menu").html(html);
	 $.ajax({
	      url: "/hearder/getMenu",
	      dataType: "json",
	      type: 'post',
	      data: {
	      },
	      success: function(result) {
	    	  var list = result.data;
	    	  if (list!=null && list.length>0) {
	    	  for (var i = 0; i < list.length; i++) {
				if (i==0) {
					html += '<li><a href="/'+list[i].url+'" class="active"  title="'+list[i].title+'">'+list[i].title+'</a></li>'
				}else{
					html += '<li><a href="/'+list[i].url+'"  title="'+list[i].title+'">'+list[i].title+'</a></li>'
				}	
			  }
	    	  $("#menu").append(html)
			  }
	      }
	  });
}