<%@ page import="com.aia.it.planner.model.PlannerJoinDaily"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/views/include/sessionCheck.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- <link href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css"
	rel="stylesheet" type="text/css" /> -->
	<link rel="stylesheet" href="<%= request.getContextPath() %>/css/default.css">
	
<style>
</style>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript"
	src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript">

	/** 아이템을 등록한다. */
	function submitItem() {
		if (!validateItem()) {
			return;
		}
		alert("등록");
	}
	/** 아이템 체크 */
	function validateItem() {
		var items = $("input[type='text'][name='item']");
		if (items.length == 0) {
			alert("작성된 아이템이 없습니다.");
			return false;
		}
		var flag = true;
		for (var i = 0; i < items.length; i++) {
			if ($(items.get(i)).val().trim() == "") {
				flag = false;
				alert("내용을 입력하지 않은 항목이 있습니다.");
				break;
			}
		}
		return flag;
	}
	/** UI 설정 */
	$(function() {
		$(".please2").sortable({
			placeholder : "itemBoxHighlight",
			connectWith : ".please",
			start : function(event, ui) {
				ui.item.data('start_pos', ui.item.index());
			},
			stop : function(event, ui) {
				var spos = ui.item.data('start_pos');
				var epos = ui.item.index();
				reorder();
			}
		});
		//$("#itemBoxWrap").disableSelection();
		$("#sortable").sortable();
		$("#sortable").disableSelection();
	});

	/** 아이템 박스 작성 */
	// function createBox() {
	//     var contents = "<div class='date'> 날짜"
	//     contents +=         
	//                   "<div class='itemBox'>"
	//                  + "<div style='float:left;'>"
	//                  + "<span class='itemNum'></span> "
	//                  + "<input type='text' name='item' style='width:300px;'/>"
	//                  + "</div>"
	//                  + "</div>";
	//                  contents     += "</div>"
	//     return contents;
	// }
	/** 아이템 박스 작성 */
	function createBox() {
		var contents = "<li class='itemBox'>" + "<div style='float:left;'>"
				+ "<span class='itemNum'></span> "
				+ "<input type='text' name='item' style='width:300px;'/>"
				+ "</div>" + "</li>";
		return contents;
	}
	//]]>
</script>
<title>Insert title here</title>
</head>
<script>
	
</script>
<body>
<%@ include file="/WEB-INF/views/include/header.jsp" %>

<h1>캘린더 저장후 이리 온다. 일단 경로 잡아둠</h1>
	uidx <input type="text" name="uidx" value="${loginInfo.uidx}"><br>
	<input type="text" name="pstartdate" value="${startdate}">/<input type="text" name="penddate" value="${enddate}"><br>
	제목<input type="text" name="ptitle" value="${ptitle}">
		<div id="sortable">
			<c:forEach items="${dateList}" var="list">
				<div class="please" name="dailytable"><div class="ddateList">${list}</div>
				<div class="please2"></div>
					<div class="itembox">
						<a href="../daily/dailyReg">+</a>
					</div>
						<div class="itembox"></div>
						
				</div>
			</c:forEach>
		</div>
		
		<span id="dailyList"></span>
	
	<%-- 		<form action="dailyList" method="post">
	
		uidx <input type="text" name="uidx" value="${loginInfo.uidx}"><br>
	
		<input type="submit" value="리스트뽑기">
		<input type="text" value="${planner.pidx}">
	
		</form>
	
			<div>
		               <c:forEach items="${listView.dailyList}" var="daily">
                  <tr>
                     <td>${daily.ptitle}</td>
                     <td>${daily.dloc}</td>
                     <td></td>
                     <td><a href="${daliy.didx}">${daliy.didx}</a></td>
                     <td></td>
                     
                  </tr>
               </c:forEach>
		
		
			</div> --%>
	
	<%@ include file="/WEB-INF/views/include/footer.jsp" %>
	
</body>
</html>

<script type="text/javascript">


console.log($('.itembox').length);
		
		
		$('.addDaily').click(function () {
			
			
			var z = $(this).next();
			
			var t=	$('.addDaily').next();
		
			var html='';
			html+='dloc		<input type="text" name="dloc">	<br>';
			html+='	dloclon		<input type="text" name="dloclon"><br>';
			html+='	dloclat		<input type="text" name="dloclat"><br>';
			html+='dmsg		<input type="text" name="dmsg"><br>';
			html+='	dphoto		<input type="file" name="dphoto"><br>';
			
			t.empty();
			
			z.html(html);
							
			});
		
		
		
		 $(document).ready(function(){
			
			dailyList();
			
		}); 
		 
		
		 	function dailyList() {
			
			$.ajax({
				url: 'http://localhost:8080/PlanIt_y2/planner/dailyList',
				type: 'GET',
				
				data: {
				uidx : '${loginInfo.uidx}'
				},
				success: function(data){
			var html = '';
			
		console.log(data);
		console.log(data[1].ptitle);
		console.log("${listView.dailyList.ptitle}");

		
		
		
		
		var please = document.getElementsByClassName("please");
		
		
		
		console.log($(document.getElementsByClassName("ddateList")).html());
		
		var ddate = $(document.getElementsByClassName("ddateList"));
		
		
		console.log(ddate);

		
		

		for(var i=0; i<data.length; i++){
						
			
						
					 	html += '<div>';
						html += '	<ul>';
						html += '		<li>ptitle : '+data[i].ptitle+'</li>';
						html += '		<li>ddate : '+data[i].ddate+'</li>';

			
						html += '	</ul>';
						html += '</div>'; 
						/* html += '<c:if test="${'+data[i].ddate+' eq '+ddate+' }">';
						html += '맞습니다';"'+data[i].ddate+'")'
						html += '</c:if>';  */
						$( '.ddateList:contains("'+data[i].ddate+'")').next().append(html);
						
						$('#dailyList').append(html);
						html='';
					}
						
		
			
		
		
		
		
		
/* 			$( '.ddateList:contains("'+data[3].ddate+'")').css( 'color', 'blue' );
 */
					alert(html);
							
					/*  $( document ).ready( function() {
					        $( '.ddateList:contains("'+ddate+'")').css( 'color', 'red' );
					      } ); */
					
					 /* if (.value=ddate) */ 
					
				} 
			

		
		});
		}
		


</script>