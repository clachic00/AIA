<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<style>
	#memberList {
		overflow: hidden;
	}
	div.card {
		width : 33%;
		float: left;
		
		border : 1px solid #DDD;
		
	}
	
	div.card>ul>li {
		list-style: none;
		
		font-size: 12px;
	}
</style>
</head>
<body>
	<h1>회원수정</h1>
	<form id="editForm" onsubmit="return false;">
		Idx <input type="text" name="idx" id="idx" readonly><br>
		아이디 <input type="text" name="uid" id="euid" readonly><br>
		비밀번호 <input type="password" name="upw" id="eupw"><br>
		이름 <input type="text" name="uname" id="euname"><br>
		사진 <input type="file" name="photo" id="ephoto"><br>
		현재 사진 <input type="text" name="oldfile" id="oldfile"><br>
		<input type="submit" value="회원수정" onclick="editSubmit(); "><br>
	</form>
	
	<hr>
	
	<h1>회원가입</h1>
	<form id="regForm" onsubmit="return false;">
		아이디 <input type="text" name="uid" id="uid"><br>
		비밀번호 <input type="text" name="upw" id="upw"><br>
		이름 <input type="text" name="uname" id="uname"><br>
		사진 <input type="file" name="photo" id="photo"><br>
		<input type="submit" value="회원가입" onclick="regSubmit(); "><br>
	</form>
	<hr>
	<h1>회원 리스트</h1>
	<hr>
	<div id="memberList"></div>
	
	<script>
	
	$(document).ready(function(){
		
		memberList();
		
	});
	
	function deleteMember(idx){
		if(confirm('정말 삭제하시겠습니까?')){
			
			$.ajax({
				url : 'http://localhost:8080/mm/members/' + idx,
				type : 'DELETE',
				success : function(data){
					
					alert(data);
					memberList();
				}
			});
			
		}
	}
	
	
	function editSubmit(){

		var regFormData = new FormData();
		regFormData.append('uid', $('#euid').val());
		regFormData.append('upw', $('#eupw').val());
		regFormData.append('uname', $('#euname').val());
		regFormData.append('oldFile', $('#oldfile').val());
		// 파일 첨부
		if($('#photo')[0].files[0] != null){
			regFormData.append('photo',$('#ephoto')[0].files[0]);
		}
		$.ajax({
			url : 'http://localhost:8080/mm/members/'+$('#idx').val(),
			type : 'POST',
			processData: false, // File 전송시 필수
			contentType: false, // multipart/form-data
			data : regFormData,
			/* data : {
					uid: $('#uid').val(), 
					upw: $('#upw').val(), 
					uname: $('#uname').val()
					}, */
			success : function(data){
				alert(data); 
				memberList();
				document.getElementById('editForm').reset();
			}
		});
		
	}
	
	function editForm(idx){
		$.ajax({
			url : 'http://localhost:8080/mm/members/'+idx,
			type : 'GET',
			success : function(data){
				$('#idx').val(data.idx);
				$('#euid').val(data.uid);
				$('#euname').val(data.uname);
				$('#oldfile').val(data.uphoto);
				$('#eupw').focus();
			}
			
		});
	}
	
	function regSubmit(){
		
		var regFormData = new FormData();
		regFormData.append('uid', $('#uid').val());
		regFormData.append('upw', $('#upw').val());
		regFormData.append('uname', $('#uname').val());
		// 파일 첨부
		if($('#photo')[0].files[0] != null){
			regFormData.append('photo',$('#photo')[0].files[0]);
		}
		console.log(regFormData);

		$.ajax({
			url : 'http://localhost:8080/mm/members',
			type : 'post',
			processData: false, // File 전송시 필수
			contentType: false, // multipart/form-data
			data : regFormData,
			/* data : {
					uid: $('#uid').val(), 
					upw: $('#upw').val(), 
					uname: $('#uname').val()
					}, */
			success : function(data){
				alert(data); 
				memberList();
				document.getElementById('regForm').reset();
			}
		});
		
	}
	
	function memberList() {
		
		$.ajax({
			url: 'http://localhost:8080/mm/members' ,
			type: 'get',
			success: function(data){
				//alert(JSON.stringify(data));
				console.log(data);
				//$('#memberList').html(JSON.stringify(data));
				
				var html = '';
				
				for(var i=0; i<data.length; i++){
					html += '<div class="card">';
					html += '	<ul>';
					html += '		<li>idx : '+data[i].idx+'</li>';
					html += '		<li>uid : '+data[i].uid+'</li>';
					html += '		<li>upw : '+data[i].upw+'</li>';
					html += '		<li>uName : '+data[i].uname+'</li>';
					html += '		<li>uPhoto :'+data[i].uphoto+'</li>';
					html += '		<li><input type="button" value="수정" onclick="editForm('+data[i].idx+')"> ';
					html += '		<input type="button" value="삭제" onclick="deleteMember('+data[i].idx+')"></li>';
					html += '	</ul>';
					html += '</div>';
				}
				
				$('#memberList').html(html);
				
			} 
		});
	}
	
	
	

	
	
	
	
	
	
	
	</script>
	
	
	
	
	
	
	
</body>
</html>


