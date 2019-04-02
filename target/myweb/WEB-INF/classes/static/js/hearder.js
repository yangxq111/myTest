$(function () {
	alert("111")
	initMenu();
});
function initMenu(){
	var html='';
	$("#menu").html(html)
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
					html += '<li><a href="${context.contextPath}/'+list[i].url+'"  class="active"  title="'+list[i].title+'">'+list[i].title+'</a></li>'
				}else{
					html += '<li><a href="${context.contextPath}/'+list[i].url+'"  title="'+list[i].title+'">'+list[i].title+'</a></li>'
				}	
			  }
	    	  $("#menu").append(html)
			  }
	      }
	  });
}