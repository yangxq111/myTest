$(function () {
    getFootMenu();
    getLinks();
    getConnectionInfo();

});
function getFootMenu() {
    var html = '';
    $("#footerMemu").html(html);
    $.ajax({
        url: "/footer/getFooterMenu",
        dataType: "json",
        type: 'post',
        data: {},
        success: function (result) {
            var list = result.data;
            if (list != null && list.length > 0) {
                for (var i = 0; i < list.length; i++) {
                    html += '<li><a href="/' + list[i].url + '"  title="' + list[i].title + '">' + list[i].title + '</a></li>'
                }
            }
            $("#footerMemu").html(html)
        }
    });
}
function getLinks(){
	var html='';
	$("#frientLinks").html(html);
	 $.ajax({
	      url: "/footer/getLinks",
	      dataType: "json",
	      type: 'post',
	      data: {
	      },
	      success: function(result) {
	    	  var list = result.data;
	    	  if (list!=null && list.length>0) {
				  for (var i = 0; i < list.length; i++) {
					html+='<li><a href='+list[i].linkurl+' target=\'_blank\'>'+list[i].linkTitle+'</a> </li>';
				  }
			  }
              $("#frientLinks").html(html)
          }
	  });
}
function getConnectionInfo(){
	var html='';
	$("#footerConnectionInfo").html(html);
	 $.ajax({
	      url: "/footer/getConnectionInfo",
	      dataType: "json",
	      type: 'post',
	      data: {
	      },
	      success: function(result) {
	    	  var list = result.data;
	    	  if (list!=null && list.length>0) {
				  for (var i = 0; i < list.length; i++) {
					html+='<li><span class="footer_cotact_type">'+list[i].title+'：</span><span class="footer_cotact_content">'+list[i].content+'</li>';
				  }
			  }
              $("#footerConnectionInfo").html(html)
          }
	  });
}