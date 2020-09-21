<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/sessionCheck.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>플래너 리스트</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<link href="https://fonts.googleapis.com/css2?family=Jua&family=Montserrat+Alternates:wght@600&display=swap"
   rel="stylesheet">
<link rel="stylesheet"
   href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
<style>

	#card-title {
	   color: #1ABC9C;
	   margin-top: 5px;
	   margin-bottom: -10px;
	   height: 80px;
	}

/* 게시글 검색 버튼  */
	#boardListSearchBtn {
	   margin-top: 5px;
	   border: 1px solid lightgrey;
	   border-radius: 20%;
	   background-color: white;
	   border: none;
	   border-radius: 20%;
	   background-color: white;
	   color: grey;
	}

/*게시글 검색 input  */
	#boardListSearchInput {
	   width: 80%;
	   border-top: none;
	   border-left: none;
	   border-right: none;
	   border-bottom: 1px solid lightgrey;
	}

/*게시글 작성자 이름 */

	#boardListName {
	   color: grey;
	   font-size: 9px;
	}
	
	#loginFormLogo {
   margin-top: 10px;
   margin-bottom: 0;
   font-family: 'Montserrat Alternates', sans-serif;
   float: left;
}

	#plannerListWrap{
	width : 500px;
	min-width: 360px;
	margin: auto;
	margin-top: 50px;
	}
	
	.planner{
	
	border-bottom:0.5px solid lightgrey;
	height: 50px;
	width : 500px;
	min-width: 360px;
	margin: auto;
	
	}
	
	
	ul{
	list-style: none;
	}
	
	.listButton{
	float: right;
	font-size: 15px;
	cursor: pointer;
	padding-right: 6px;
	margin-top: 5px;
	}
	
	
</style>
</head>
<%@ include file="/WEB-INF/views/include/header.jsp" %>

<body>

<c:url value="${initParam['memberUploadPath']}" var="imagePath"/>
	
	<div id="plannerListWrap">
<div class="card-title" id="card-title" style="text-align: center;">
         <!--2번시작 : 검색과 제목창시작  -->
         
         <div id="boardListHeadTitle">
            <h3 id="loginFormLogo" class="card-title text-center">planner</h3>
            <br> <br>
            <p id="ptext" align="left">여행 플랜을 확인하세요.</p>
         </div>
         
         <div class="searchBox">
            <form>
               <select name="searchType" style="display: none">
                  <option value="both">ID + NAME</option>
               </select> <input type="text" name="keyword" id="boardListSearchInput">
               <button type="submit" value="검색" id="boardListSearchBtn">
                  <i class="fa fa-search" aria-hidden="true"></i>
               </button>
            </form>
         </div>
      </div>
      <br><br>
      <div style="">
      	<ul id="plannerList"></ul>
      	
      </div>
	</div>


<script>
	$(document).ready(function(){
		
		plannerList();
		
	});

function deletePlanner(pidx){
	if(confirm('정말 삭제하시겠습니까?')){
		
		$.ajax({
			url : 'http://localhost:8080/it/planner/plannerRest/' + pidx,
			type : 'DELETE',
			success : function(data){
				
				plannerList();
				
			}
		});
		
	}
}



function plannerList() {
	$.ajax({
		url: 'http://localhost:8080/it/planner/plannerRest/'+${loginInfo.uidx},
		type: 'get',
	
		success: function(data){
			//alert(JSON.stringify(data));
			//$('#memberList').html(JSON.stringify(data));
			var html = '';
			 
			for(var i=0; i<data.length; i++){
				
				var sdd=data[i].pstartdate;
				var edd=data[i].penddate;
			    var ar1 = sdd.split('-');
			    var ar2 = edd.split('-');
			    var curr = new Date(ar1[0], ar1[1], ar1[2]);
			    var end = new Date(ar2[0], ar2[1], ar2[2]);
			    var betweenDay =( (end.getTime() - curr.getTime()) / 1000 / 60 / 60 / 24);
				var betweenDay2 = betweenDay+1;
				
				html += '	<li class="planlist">';
				html += '		<form action="http://localhost:8080/it/planner/plannerEdit" method="post">'
				html += '		<div class="planner">';
				html += '       <img src="${imagePath}/${loginInfo.photo}" width="30px" height="30px">'; 
				html += '		<div class="num"style="width:20px; margin-left:6px; margin-right:6px; display: Inline-block; font-size:18px;"></div>'
				html += '       <input type="text" name="ptitle" value="'+data[i].ptitle+'" style="width:200px; border:0; font-size:20px;" readonly>';
				html += '		<input type="text" value="'+betweenDay+'박'+betweenDay2+'일" style="width:115px; border:0; font-size:20px;" readonly>';
				html += '		<input type="hidden" name="pidx" value="'+data[i].pidx+'" readonly>';
				html += '		<input type="hidden" name="pstartdate" value="'+data[i].pstartdate+'" readonly>';
				html += '		<input type="hidden" name="penddate" value="'+data[i].penddate+'" readonly>';
				html += '		<input type="hidden" name="uidx" value="'+data[i].uidx+'" readonly>';
				html += '		<label class="listButton"><a onclick="deletePlanner('+data[i].pidx+')">삭제</a></label>';
				html += '		<label for="editPlanner" class="listButton" ><a>수정</a></label> '; 			
				html += '		<input type="submit" id="editPlanner" value="수정" style="display:none;"> '; 
				html += '		</div>';
				html += '		</form>'
				html += '	</li>';
			}
			
			$('#plannerList').html(html);
			reorder();
			
		} 
		
		
	});
}


function reorder() {

$(".planlist").each(function(i, box) {
    $(box).find(".num").html(i + 1);

});


}



</script>

</body>
</html>