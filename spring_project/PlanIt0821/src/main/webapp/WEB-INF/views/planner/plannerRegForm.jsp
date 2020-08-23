<%@ page import="com.aia.it.planner.model.PlannerJoinDaily"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/views/include/sessionCheck.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

	<link rel="stylesheet" href="<%= request.getContextPath() %>/css/default.css">
	
		<!-- 모달  -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.0.0/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css" />


		<!-- jquery  -->
	<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>

		<!-- SORTABLE  -->
	<link href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" />
	<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>


<script>

	/* @@@@SORTABLE@@@@ */
	
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
	/** UI 설정 */"#sortable-5, #sortable-6"  
	$(function() {
		$(".sortable").sortable({
			placeholder : "itemBoxHighlight",
			connectWith : ".ddateList, .sortableBox, .sortable.ui-sortable",
			
			start : function(event, ui) {
				ui.item.data('start_pos', ui.item.index());
			},
			stop : function(event, ui) {
				var spos = ui.item.data('start_pos');
				var epos = ui.item.index();
				 reorder();  //순서 조정
			}
		});
		$("#sortable").sortable();
		$("#sortable").disableSelection();
	});

	
	/* 순서 조정 */
	function reorder() {
	    $(".sortableBox").each(function(i, box) {
	        $(box).find("#reorder").val(i + 1);

	    });
	/*  $(".sortableBox").each(function(i, box) {
		console.log($(".dayOfPlan").eq(i).val());
		 $(box).find(".ddate").val($(".dayOfPlan").eq(i).val()); 
	
	    }); */

	
		for(var i=0; i<$(".dayOfPlan").length; i++){
					
		$(".dayOfPlan").eq(i).parent('div').next('div').find("input.ddate").val($(".dayOfPlan").eq(i).val());
		
		}
		
	}
	
	
</script>

<style>

.sortable{

	border: 0.5px solid black;
	text-align: center;
	width : 500px;
	
}

</style>

<title>플래너 작성</title>
</head>

<body>
<%@ include file="/WEB-INF/views/include/header.jsp" %>
	
  <div id="dailyModal" class="modal" >
  
  	<h2>데일리 작성</h2>
  
   <form id="dailyRegForm" onsubmit="return false;" >
   <%-- action="<c:url value='/planner/dailyList'/>" --%>    
		pidx		<input type="text" name="pidx" value="${planner.pidx}" id="pidx">	<br>

		dloc		<input type="text" name="dloc" id="dloc">	<br>
		dloclon		<input type="text" name="dloclon" id="dloclon"><br>
		dloclat		<input type="text" name="dloclat" id="dloclat"><br>
		dmsg		<input type="text" name="dmsg" id="dmsg"><br>
		dphoto		<input type="file" name="dphoto" id="dphoto"><br>
		dtype		<select name="dtype" id="dtype">
					<option value="1">빨강</option>
					<option value="2">파랑</option>
					<option value="3">초록</option>
					<option value="4">분홍</option>
					<option value="5">하양</option>
				
					</select>
					<br>
		ddate(날짜)	<input type="text" name="ddate" id="ddate"><br>
		ddidx(날짜순서)<input type="text" name="ddidx" id="ddidx"><br>
		
		
			<input type="submit" value="제출" onclick="regDaily(); ">
</form>
        <a href="#" rel="modal:close">닫기</a>
      </div>
       
      

	
	
		pidx <input type="text" name="pidx" value="${pidx}"><br>
	uidx <input type="text" name="uidx" value="${loginInfo.uidx}"><br>
	<input type="text" name="pstartdate" value="${startdate}">/<input type="text" name="penddate" value="${enddate}"><br>
	제목<input type="text" name="ptitle" value="${ptitle}">
		<div id="sortable">
			<c:forEach items="${dateList}" var="list">
				<div class="sortable" name="dailytable">
				
					<div class="ddateList" class="sortable"><input type="text" class="dayOfPlan" value="${list}"></div>
					<div class="sortable"></div>
					<div class="addDailyButton" ><a href="<c:url value="/daily/dailyReg"/>">+</a></div>
						
				</div>
			</c:forEach>
		</div>
		
		<span id="dailyList"></span>
	
	
	
	<%@ include file="/WEB-INF/views/include/footer.jsp" %>
	
	<script type="text/javascript">


/* console.log($('.itembox').length);
		
		
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
							
			}); */
		
		
		
		 $(document).ready(function(){
			
			dailyList();
			
		}); 
		 
		
		 	function dailyList() {
			
			$.ajax({
				url: 'http://localhost:8080/it/planner/dailyList',
				type: 'GET',
				
				data: {
					uidx : '${loginInfo.uidx}',
					pidx : '${pidx}'
				},
				success: function(data){
			var html = '';
			
		console.log(data);
		console.log(data[1].ptitle);

		
/* 		var sortable = document.getElementsByClassName("sortable");
 */		
		
		
		console.log($(document.getElementsByClassName("ddateList")).html());
		
/* 		var ddate = $(document.getElementsByClassName("ddateList"));
 */		
		


		for(var i=0; i<data.length; i++){
					
				 	html += '<div class="sortableBox" class="sortable">';
				 
					html += '	<div class="sortable" >';
					
					html += '		<input type="text" id="reorder" value="'+data[i].ddix+'">';
					html += '		<input type="text" class="ddate" value="'+data[i].ddate+'">';
					html += '		<input type="text" value="'+data[i].dix+'">';
					html += '		<input type="text" value="'+data[i].dloc+'">';
					html += '		<input type="text" value="'+data[i].dloclon+'">';
					html += '		<input type="text" value="'+data[i].dloclat+'">';
					html += '		<input type="text" value="'+data[i].dphoto+'">';
					html += '		<input type="text" value="'+data[i].dtype+'">';
					
					html += '		<input type="text" value="'+data[i].pidx+'">';

					html += '	</div>';
					html += '	<a href="https://naver.com">경로찾기</a>';

					
					html += '</div>'; 
					/* console.log($('.dayOfPlan').eq(i).val()); */
					/* console.log(data[i].ddate); */
					
					for(var j=0; j<$('.dayOfPlan').length;j++)
						
						
					if($('.dayOfPlan').eq(j).val() == data[i].ddate){
						/* console.log("찾았다"); */
						$('.dayOfPlan').eq(j).parent('div').next().append(html);
					}
					
					
					
					/* $( '.ddateList:contains("'+data[i].ddate+'")').next().append(html); */
					/* $('#dailyList').append(html); */
					html='';

					}
		reorder();
				}
			});
		}
		
			function regDaily(){
				
				var regFormData = new FormData();
				regFormData.append('pidx', $('#pidx').val());
				regFormData.append('dloc', $('#dloc').val());
				regFormData.append('dloclon', $('#dloclon').val());
				regFormData.append('dloclat', $('#dloclat').val());
				regFormData.append('dmsg', $('#dmsg').val());
				regFormData.append('dphoto', $('#dphoto').val());

				// 파일 첨부
				/* if($('#dphoto')[0].files[0] != null){
					regFormData.append('dphoto',$('#dphoto')[0].files[0]);
				} */
				regFormData.append('dtype', $('#dtype').val());
				regFormData.append('ddate', $('#ddate').val());
				regFormData.append('ddidx', $('#ddidx').val());
				
				console.log(regFormData);
				console.log($('#ddate').val());
				$.ajax({
					/* http://localhost:8080/it/daily/dailyReg */
					url : 'dailyList2',
					type : 'POST',
					processData: false, // File 전송시 필수
					contentType: false, // multipart/form-data
					data : regFormData,
					
					success : function(data){
						alert(data); 
						dailyList();
						document.getElementById('dailyRegForm').reset();
						

					}
				});
				
			}
		
		 	
		 	

			

</script>
	
	
	
</body>
</html>

