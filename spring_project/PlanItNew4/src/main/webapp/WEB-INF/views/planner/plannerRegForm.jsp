<%@ page import="com.aia.it.planner.model.PlannerJoinDaily"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/sessionCheck.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">


<%--  	<link rel="stylesheet" href="<%= request.getContextPath() %>/css/default.css">
 --%>
 	<!--  <script src="//code.jquery.com/jquery-1.12.4.js"></script>  -->
	<link rel="stylesheet" href="<%= request.getContextPath() %>/css/plannerRegForm.css">

<title>플래너 작성</title>
</head>

<body>
 <%@ include file="/WEB-INF/views/include/header.jsp" %>
 
	 
       <!-- RegDaily MODAL -->
  
       <div class="modal fade" id="regDailyModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">데일리 작성</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
       


   <form id="dailyRegForm" onsubmit="return false;" >
   <%-- action="<c:url value='/planner/dailyList'/>" --%>    
   
   		ddate(날짜)	<input type="text" name="ddate" id="ddateModal" class="ddateModal" readonly>	<br>
		pidx		<input type="text" name="pidx" value="${planner.pidx}" id="pidx">	<br>
		dloc		<input type="text" name="dloc" id="dloc" >	<br>
		dloclon		<input type="text" name="dloclon" id="dloclon">	<br>
		dloclat		<input type="text" name="dloclat" id="dloclat">	<br>
		daddr		<input type="text" name="daddr" id="daddr">	<br>
		dmsg		<input type="text" name="dmsg" id="dmsg">	<br>
		dphoto		<input type="file" name="dphoto" id="dphoto">	<br>
		dtype		<select name="dtype" id="dtype">
					<option value="white">기본</option>
					<option value="#FFD0D0">음식점</option>
					<option value="#E6FCFD">숙소</option>
					<option value="#E7FEE4">교통</option>
					<option value="#FEFAC8">관광지</option>
					</select>	<br>
					
					<input type="hidden" name="ddidx" id="ddidx" value=999><br><!-- 순서 등록은 reorder에서 제배치한다 -->
		
		<a data-toggle="modal" data-target="#mapModal" >위치 찾기</a>

		<a href="#" rel="modal:close"><input type="submit" value="제출" onclick="regDaily(); "></a>
			
	</form>



      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>
       
       
       
       
       <!-- EditDaily MODAL -->
  
      
      <div class="modal fade" id="editDailyModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">데일리 에디트</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
     


   <form id="dailyEditForm" onsubmit="return false;" >
   <%-- action="<c:url value='/planner/dailyList'/>" --%>    
   		didx		<input type="text" name="didx" id="didx"  readonly><br>
   		ddate		<input type="text" name="ddate" id="eddateModal" class="ddateModal" readonly><br>
		pidx		<input type="text" name="pidx" value="${planner.pidx}" id="epidx">	<br>
		dloc		<input type="text" name="dloc" id="edloc" >	<br>
		dloclon		<input type="text" name="dloclon" id="edloclon"><br>
		dloclat		<input type="text" name="dloclat" id="edloclat"><br>
		daddr		<input type="text" name="daddr" id="edaddr"><br>
		dmsg		<input type="text" name="dmsg" id="edmsg"><br>
		dphoto		<input type="file" name="dphoto" id="edphoto"><br>
		현재 사진 		<input type="text" name="oldfile" id="oldfile"><br>
		
		dtype		<select name="dtype" id="edtype">
					<option value="white">기본</option>
					<option value="#FFD0D0">음식점</option>
					<option value="#E6FCFD">숙소</option>
					<option value="#E7FEE4">교통</option>
					<option value="#FEFAC8">관광지</option>
					
					</select>
					<br>
					<input type="hidden" name="ddidx" id="eddidx" value=999><br><!-- 순서 등록은 reorder에서 제배치한다 -->
		
		<a data-toggle="modal" data-target="#mapModal" >위치 찾기</a>
		
		
		 <a href="#" rel="modal:close"><input type="submit" value="제출" onclick="editDaily(); "></a>
			
	</form>



      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>
      
      
      
      <!-- 지도 MODAL -->
      
      <div class="modal fade" id="mapModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">위치 검색</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
   
   
   <div class="map_wrap" style="height:500px">
    <div id="map" style="height:500px;position:relative;overflow:hidden;"></div>

    <div id="menu_wrap" class="bg_white">
        <div class="option">
            <div>
                <form onsubmit="searchPlaces(); return false;">
                    키워드 : <input type="text" value="맛집" id="keyword" size="15"> 
                    <button type="submit">검색하기</button> 
                </form>
            </div>
        </div>
        <hr>
        <ul id="placesList"></ul>
        <div id="pagination"></div>
    </div>
            <input type="submit" onclick="showItemEl(); " name="back" value="검색">
    
    
	</div>
   
   
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
      
      
      
      <!-- 플래너 정보 -->
			<input type="hidden" name="pidx" value="${pidx}">
			<input type="hidden" name="uidx" value="${loginInfo.uidx}">
		<div>
			<input type="text" name="ptitle" value="${ptitle}" id="ptitle"><br>
		</div>
	 	<div style="background-color: #FAFAFA">
		 	<span><input type="text" name="pstartdate" value="${startdate}" id="pstartdate"></span>~
		 	<span><input type="text" name="penddate" value="${enddate}" id="penddate"></span>
		</div>
		
		<form id="serialize">
				<c:url value="${initParam['memberUploadPath']}" var="imagePath"/>
		
			<c:forEach items="${dateList}" var="list">
				
					<div class="ddateList" class=""><input type="text" class="dayOfPlan" value="${list}" readonly></div>
					
					<ul class="sortable sortableLeft"></ul>
					
					
					<a data-toggle="modal" data-target="#regDailyModal" class="${list}" 
					onclick="searchReset(); showItemEl(); searchPlaces(); writeddate(this);" >
					+데일리 등록
					</a>
					
					
	
			</c:forEach>
		</form>



	
	<%@ include file="/WEB-INF/views/include/footer.jsp" %>

	



<!-- 비동기 통신  -->
<script >

	

/* 페이지 시작시 리스트 출력 */
$(document).ready(function(){
	dailyList();


		}); 

		 
	/* 데일리 리스트 출력 */
	function dailyList() {
		
		$.ajax({
			url : 'http://localhost:8080/it/planner/dailyRest',
			type : 'GET',
			data : {
				uidx : '${uidx}',
				pidx : '${pidx}'
			},
			success : function(data) {
				var html = '';

				
				console.log($(
						document.getElementsByClassName("ddateList"))
						.html());

				 for (var j = 0; j < $('.dayOfPlan').length; j++) {
					 
					 $('.dayOfPlan').eq(j).parent('div').next().html('');

				 }
				
				
				for (var i = 0; i < data.length; i++) {
					
					
					html += '<li class="sortableBox sortableLeft" >';
					html += '		<input type="hidden" class="ddidx" name="dailyOrderEdit['+i+'].ddidx" value="'+data[i].ddidx+'" readonly>';
					html += '		<input type="hidden" class="ddate" name="dailyOrderEdit['+i+'].ddate" id="ddate" value="'+data[i].ddate+'" readonly>';
					html += '		<input type="hidden" class="didx" name="dailyOrderEdit['+i+'].didx" value="'+data[i].didx+'">';
					html += '		<input type="text" class="dloc" value="'+data[i].dloc+'" readonly>';
					html += '		<input type="hidden" value="'+data[i].dloclon+'">';
					html += '		<input type="hidden" value="'+data[i].dloclat+'">';
					html += '  		<input type="hidden" class="daddr" value="'+data[i].daddr+'" readonly>';
					html += '		<input type="hidden" value="'+data[i].dphoto+'">';
				 /* html += '		img	<img alt="profile " class="didxImg" src="${imagePath}/'+data[i].dphoto+'">'; */
					html += '		<input type="hidden" value="'+data[i].dmsg+'">';
					html += '		<input type="hidden" class="dtype" value="'+data[i].dtype+'">';
					html += '		<input type="hidden" value="'+data[i].pidx+'">';
					html += '		<a href="https://map.kakao.com/?sName=%27+'+data[(i-1)<0?i:i-1].daddr+'+%27&eName=%27+'+data[i].daddr+'">경로찾기</a>';
					html += '		<a data-toggle="modal" data-target="#editDailyModal" onclick="editForm('+data[i].didx+'); searchReset(); showItemEl(); searchPlaces(); "  >수정</a>';
					html += '		<input type="button" value="삭제" onclick="deleteDaily('+data[i].didx+')">';
					//kakaomap://route?sp=37.51119865054613,127.02165424220854&ep=37.5705756133826,126.98531278713301&by=PUBLICTRANSIT
					html += '<span class="handle">↕</span>' 
					html += '</li>';
					
					//<a href=#editDailyModal rel="modal:open"  onclick="editForm('+data[i].didx+')" >수정</a>
				
					 for (var j = 0; j < $('.dayOfPlan').length; j++) {

						if ($('.dayOfPlan').eq(j).val() == data[i].ddate) {
							
							$('.dayOfPlan').eq(j).parent('div').next().append(html);

							html = '';
							break;
						}
					 }
							/* $( '.ddateList:contains("'+data[i].ddate+'")').next().append(html); */
							/* $('#dailyList').append(html); */
			}
				reorder();

		}
	});
}

	/* 데일리 등록 */
	function regDaily() {

		var regFormData = new FormData();
		regFormData.append('pidx', $('#pidx').val());
		regFormData.append('dloc', $('#dloc').val());
		regFormData.append('dloclon', $('#dloclon').val());
		regFormData.append('dloclat', $('#dloclat').val());
		regFormData.append('daddr', $('#daddr').val());
		regFormData.append('dmsg', $('#dmsg').val());
		// 파일 첨부
		if ($('#dphoto')[0].files[0] != null) {
			regFormData.append('dphoto', $('#dphoto')[0].files[0]);
		}
		regFormData.append('dtype', $('#dtype').val());
		regFormData.append('ddate', $('#ddateModal').val());
		regFormData.append('ddidx', $('#ddidx').val());

		console.log(regFormData);
		console.log($('#ddate').val());
		$.ajax({
			url : 'http://localhost:8080/it/planner/dailyRest',
			type : 'post',
			processData : false, // File 전송시 필수
			contentType : false, // multipart/form-data
			data : regFormData,

			success : function(data) {
				dailyList();
				editDailyOrder();

				document.getElementById('dailyRegForm').reset();

			}
		
		});

	}

	/* 데일리 순서 등록 */
	function editDailyOrder() {

		var params = $("#serialize").serialize();
		var param = $("#serialize").serializeArray();

		console.log(params);
		console.log(param);
		


		$.ajax({
			url : 'http://localhost:8080/it/planner/dailyOrderEdit',
			type : 'post',
			/* processData: false, 
			contentType: false,  */
			data : param,
			//data: regFormData,
			success : function(data) {
				dailyList();
			}
		});
	}

	/* 데일리 삭제 */
	function deleteDaily(didx) {

		if(confirm('정말 삭제하시겠습니까?')){
		$.ajax({
			url : 'http://localhost:8080/it/planner/dailyRest/'+didx,
			type : 'delete',
			success : function(data) {
				alert(data);
				dailyList();
				}
			});
		}
	}
	
	
	
	/* 데일리 수정폼 */
	
	function editForm(didx){
		$.ajax({
			url : 'http://localhost:8080/it/planner/dailyRest/'+didx,
			type : 'GET',
			success : function(data){
				
				$('#didx').val(data.didx); 
				$('#edloc').val(data.dloc);
				$('#edloclon').val(data.dloclon);
				$('#edloclat').val(data.dloclat);
				$('#edaddr').val(data.daddr);
				$('#edmsg').val(data.dmsg);
				$('#oldfile').val(data.dphoto);
				$('#edtype').val(data.dtype);
				$('#eddateModal').val(data.ddate);
				$('#eddidx').val(data.ddidx);
		

			}
		});
	}
	
		/* 데일리 수정 */
	
		function editDaily(){

			var regFormData = new FormData();
			regFormData.append('dloc', $('#edloc').val());
			regFormData.append('dloclon', $('#edloclon').val());
			regFormData.append('dloclat', $('#edloclat').val());
			regFormData.append('daddr', $('#edaddr').val());			
			regFormData.append('dmsg', $('#edmsg').val());			
			regFormData.append('oldFile', $('#oldfile').val());
			// 파일 첨부
			if($('#edphoto')[0].files[0] != null){
				regFormData.append('dphoto',$('#edphoto')[0].files[0]);
			}
			regFormData.append('dtype', $('#edtype').val());
			regFormData.append('ddate', $('#eddateModal').val());
			regFormData.append('ddateModal', $('#eddateModal').val());			
			regFormData.append('ddidx', $('#eddidx').val());			
			
			
			$.ajax({
				url : 'http://localhost:8080/it/planner/dailyRest/'+$('#didx').val(),
				type : 'POST',
				processData: false, // File 전송시 필수
				contentType: false, // multipart/form-data
				data : regFormData,
		
				success : function(data){
					alert(data); 
					dailyList();
					document.getElementById('dailyEditForm').reset();
				}
			});
			
		}

		
		
</script>
	
	<!-- 지도API  -->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9b554607ceeb060d931e9eedfa0d54dc&libraries=services"></script>
<script>
// 마커를 담을 배열입니다
var markers = [];

var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new kakao.maps.LatLng(37.566826, 126.9786567), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };  

// 지도를 생성합니다    
var map = new kakao.maps.Map(mapContainer, mapOption); 

//주소-좌표 변환 객체를 생성
var geocoder = new daum.maps.services.Geocoder();

function resizeMap() {
    var mapContainer = document.getElementById('map');
    mapContainer.style.width = '440px';
    mapContainer.style.height = '500px'; 
}


function relayout() {    
    
    // 지도를 표시하는 div 크기를 변경한 이후 지도가 정상적으로 표출되지 않을 수도 있습니다
    // 크기를 변경한 이후에는 반드시  map.relayout 함수를 호출해야 합니다 
    // window의 resize 이벤트에 의한 크기변경은 map.relayout 함수가 자동으로 호출됩니다
    map.relayout();
}
function setCenter() {            
    // 이동할 위도 경도 위치를 생성합니다 
    var moveLatLon = new kakao.maps.LatLng(33.452613, 126.570888);
    
    // 지도 중심을 이동 시킵니다
    map.setCenter(moveLatLon);
}

function panTo() {
    // 이동할 위도 경도 위치를 생성합니다 
    var moveLatLon = new kakao.maps.LatLng(33.450580, 126.574942);
    
    // 지도 중심을 부드럽게 이동시킵니다
    // 만약 이동할 거리가 지도 화면보다 크면 부드러운 효과 없이 이동합니다
    map.panTo(moveLatLon);            
}     



resizeMap();
relayout();



// 장소 검색 객체를 생성합니다
var ps = new kakao.maps.services.Places();  

// 검색 결과 목록이나 마커를 클릭했을 때 장소명을 표출할 인포윈도우를 생성합니다
var infowindow = new kakao.maps.InfoWindow({zIndex:1});

// 키워드로 장소를 검색합니다
//searchPlaces();

// 키워드 검색을 요청하는 함수입니다
function searchPlaces() {

    var keyword = document.getElementById('keyword').value;

    if (!keyword.replace(/^\s+|\s+$/g, '')) {
        alert('키워드를 입력해주세요!');
        return false;
    }

    // 장소검색 객체를 통해 키워드로 장소검색을 요청합니다
    ps.keywordSearch( keyword, placesSearchCB); 
}

// 장소검색이 완료됐을 때 호출되는 콜백함수 입니다
function placesSearchCB(data, status, pagination) {
    if (status === kakao.maps.services.Status.OK) {

        // 정상적으로 검색이 완료됐으면
        // 검색 목록과 마커를 표출합니다
        displayPlaces(data);

        // 페이지 번호를 표출합니다
        displayPagination(pagination);

    } else if (status === kakao.maps.services.Status.ZERO_RESULT) {

        alert('검색 결과가 존재하지 않습니다.');
        return;

    } else if (status === kakao.maps.services.Status.ERROR) {

        alert('검색 결과 중 오류가 발생했습니다.');
        return;

    }
}



var listEl = document.getElementById('placesList'), 
menuEl = document.getElementById('menu_wrap'),
fragment = document.createDocumentFragment(), 
bounds = new kakao.maps.LatLngBounds(), 
listStr = '';

// 검색 결과 목록과 마커를 표출하는 함수입니다
function displayPlaces(places) {


    
	searchReset();
    
    
    
    kakao.maps.event.addListener(map, 'click', function(mouseEvent) {
        searchDetailAddrFromCoords(mouseEvent.latLng, function(result, status) {
            if (status === kakao.maps.services.Status.OK) {
                var detailAddr = !!result[0].road_address ? '<div>도로명주소 : ' + result[0].road_address.address_name + '</div>' : '';
                detailAddr += '<div>지번 주소 : ' + result[0].address.address_name + '</div>';
                                                        
                var content = '<div class="bAddr">' +
                                '<span class="title">주소정보</span>' + 
                                detailAddr +
                            '</div>'
                            
                            ;
                            
                            

                  // 마커를 클릭한 위치에 표시합니다 
                marker.setPosition(mouseEvent.latLng);
                
                marker.setMap(map);
			

                infowindow.setContent(content);
                infowindow.open(map, marker); 
                $('#dloclon').val(marker.getPosition().getLng());
                $('#dloclat').val(marker.getPosition().getLat());
                $('#daddr').val(result[0].address.address_name);
                $('#edloclon').val(marker.getPosition().getLng());
                $('#edloclat').val(marker.getPosition().getLat());
                $('#edaddr').val(result[0].address.address_name);
                relayout();
                var moveLatLon = new kakao.maps.LatLng(marker.getPosition().getLat(),marker.getPosition().getLng());
                map.panTo(moveLatLon);
                
                
                
            }   
        });
    });
    
    
    
    for ( var i=0; i<places.length; i++ ) {

        // 마커를 생성하고 지도에 표시합니다
        var placePosition = new kakao.maps.LatLng(places[i].y, places[i].x),
            marker = addMarker(placePosition, i), 
            itemEl = getListItem(i, places[i]); // 검색 결과 항목 Element를 생성합니다

        // 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
        // LatLngBounds 객체에 좌표를 추가합니다
        bounds.extend(placePosition);

        // 마커와 검색결과 항목에 mouseover 했을때
        // 해당 장소에 인포윈도우에 장소명을 표시합니다
        // mouseout 했을 때는 인포윈도우를 닫습니다
        
         
             //마크 클릭
       (function(marker, title) {
            kakao.maps.event.addListener(marker, 'click', function() {
                displayInfowindow(marker, title);
                
                $('#dloclat').val(marker.getPosition().getLat());
                $('#dloclon').val(marker.getPosition().getLng());
                $('#daddr').val(title);     
                $('#edloclat').val(marker.getPosition().getLat());
                $('#edloclon').val(marker.getPosition().getLng());
                $('#edaddr').val(title);
                relayout();
            	map.setLevel(4);    
  				var moveLatLon = new kakao.maps.LatLng(marker.getPosition().getLat(),marker.getPosition().getLng());
                map.panTo(moveLatLon);

            }); 

            
         
            //목록에서 클릭
            itemEl.onclick =  function () {
                displayInfowindow(marker, title);
                
                $('#dloclat').val(marker.getPosition().getLat());
                $('#dloclon').val(marker.getPosition().getLng());
                $('#daddr').val(title);                
                $('#edloclat').val(marker.getPosition().getLat());
                $('#edloclon').val(marker.getPosition().getLng());
                $('#edaddr').val(title);
                $("#menu_wrap").css("display","none");
                relayout();
            	map.setLevel(4);    
                var moveLatLon = new kakao.maps.LatLng(marker.getPosition().getLat(),marker.getPosition().getLng());
                map.panTo(moveLatLon);
                
                
                }; 
            
                /*    kakao.maps.event.addListener(marker, 'mouseout', function() {
                infowindow.close();
            }); */

            /*  itemEl.onmouseover =  function () {
                displayInfowindow(marker, title);
            };

            itemEl.onmouseout =  function () {
                infowindow.close();
            };  */
            
                
                
                
                
                
        })(marker, places[i].place_name);

        fragment.appendChild(itemEl);
    }

    // 검색결과 항목들을 검색결과 목록 Elemnet에 추가합니다
    listEl.appendChild(fragment);
    menuEl.scrollTop = 0;

    // 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
    map.setBounds(bounds);
    
}

// 검색결과 항목을 Element로 반환하는 함수입니다
function getListItem(index, places) {

    var el = document.createElement('li'),
    itemStr = '<span class="markerbg marker_' + (index+1) + '"></span>' +
                '<div class="info">' +
                '   <h5>' + places.place_name + '</h5>';

    if (places.road_address_name) {
        itemStr += '    <span>' + places.road_address_name + '</span>' +
                    '   <span class="jibun gray">' +  places.address_name  + '</span>';
    } else {
        itemStr += '    <span>' +  places.address_name  + '</span>'; 
    }
                 
      itemStr += '  <span class="tel">' + places.phone  + '</span>' +
                '</div>';           

    el.innerHTML = itemStr;
    el.className = 'item';

    return el;
}

// 마커를 생성하고 지도 위에 마커를 표시하는 함수입니다
function addMarker(position, idx, title) {
    var imageSrc = 'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png', // 마커 이미지 url, 스프라이트 이미지를 씁니다
        imageSize = new kakao.maps.Size(36, 37),  // 마커 이미지의 크기
        imgOptions =  {
            spriteSize : new kakao.maps.Size(36, 691), // 스프라이트 이미지의 크기
            spriteOrigin : new kakao.maps.Point(0, (idx*46)+10), // 스프라이트 이미지 중 사용할 영역의 좌상단 좌표
            offset: new kakao.maps.Point(13, 37) // 마커 좌표에 일치시킬 이미지 내에서의 좌표
        },
        markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imgOptions),
            marker = new kakao.maps.Marker({
            position: position, // 마커의 위치
            image: markerImage 
        });

    marker.setMap(map); // 지도 위에 마커를 표출합니다
    markers.push(marker);  // 배열에 생성된 마커를 추가합니다

    return marker;
}



var showItemEl = function() {
	$("#menu_wrap").css("display","block");
	
	
};


// 지도 위에 표시되고 있는 마커를 모두 제거합니다
function removeMarker() {
    for ( var i = 0; i < markers.length; i++ ) {
        markers[i].setMap(null);
    }   
    markers = [];
}

// 검색결과 목록 하단에 페이지번호를 표시는 함수입니다
function displayPagination(pagination) {
    var paginationEl = document.getElementById('pagination'),
        fragment = document.createDocumentFragment(),
        i; 

    // 기존에 추가된 페이지번호를 삭제합니다
    while (paginationEl.hasChildNodes()) {
        paginationEl.removeChild (paginationEl.lastChild);
    }

    for (i=1; i<=pagination.last; i++) {
        var el = document.createElement('a');
        el.href = "#";
        el.innerHTML = i;

        if (i===pagination.current) {
            el.className = 'on';
        } else {
            el.onclick = (function(i) {
                return function() {
                    pagination.gotoPage(i);
                }
            })(i);
        }

        fragment.appendChild(el);
    }
    paginationEl.appendChild(fragment);
}

// 검색결과 목록 또는 마커를 클릭했을 때 호출되는 함수입니다
// 인포윈도우에 장소명을 표시합니다
function displayInfowindow(marker, title) {
    var content = '<div style="padding:5px;z-index:1;">' + title + '</div>';

    infowindow.setContent(content);
    infowindow.open(map, marker);
}

 // 검색결과 목록의 자식 Element를 제거하는 함수입니다
function removeAllChildNods(el) {   
    while (el.hasChildNodes()) {
        el.removeChild (el.lastChild);
    }
}
 
function searchDetailAddrFromCoords(coords, callback) {
    // 좌표로 법정동 상세 주소 정보를 요청합니다
    geocoder.coord2Address(coords.getLng(), coords.getLat(), callback);
}
 
function searchReset(){
	
    // 검색 결과 목록에 추가된 항목들을 제거합니다
    removeAllChildNods(listEl);

    // 지도에 표시되고 있는 마커를 제거합니다
    removeMarker();
}
 

</script>
	<script>

	/* @@@@SORTABLE@@@@ */
	
	
	/** UI 설정 */ 
	$(function() {
		$(".sortable").sortable({
				placeholder : "sortable-placeholder", 
				connectWith : " .sortable.ui-sortable",
				axis:'y',
			   	cursorAt: { right: 5 },
				cursor: "move",
				handle: ".handle", 
				helper: "clone",
				delay: 500,
				distance: 30,
				start : function(event, ui) {
				
				},
				stop : function(event, ui) {
					 	reorder();  //순서 조정
					 
					 	
					 
					 editDailyOrder();

			}
			
			
			
		});
		
		
		
		$(".sortableLeft").sortable({
			axis:'x',

		});
		
		
		$(".sortable").disableSelection();
		
	});
	
	$(function() {
		
		$(".sortable").disableSelection();
		
	});
	
	
	
	
	
	/* 순서 조정 */
	function reorder() {
		//ddidx 재배치
	   $(".sortableBox").each(function(i, box) {
	        $(box).find(".ddidx").val(i + 1);

	    });


		//ddate 재배치
		for(var i=0; i<$(".dayOfPlan").length; i++){
					
		$(".dayOfPlan").eq(i).parent('div').next().find("input.ddate").val($(".dayOfPlan").eq(i).val());
		
		}
	    
		
		
		/* 
		<option value="white">기본</option>
		<option value="#FFD0D0">음식점</option>
		<option value="#E6FCFD">숙소</option>
		<option value="#E7FEE4">교통</option>
		<option value="#FEFAC8">관광지</option>
					 */
		
		
		
		//색상 재배치 sortableBox
		for(var i=0; i<$(".sortableBox").length; i++){

	    $(".sortableBox").eq(i).css("background-color",$(".dtype").eq(i).val());
	    
	    /* $(".sortableBox").eq(i).css("opacity","0.33"); */
	    
	    if($(".dtype").eq(i).val()=="#FFD0D0"){
	    
	    $(".sortableBox").eq(i).css("background-image","url('/it/resources/images/restaurant.png')");
	    
	    
	    } else if ($(".dtype").eq(i).val()=="#E6FCFD"){
	    	
   		 $(".sortableBox").eq(i).css("background-image","url('/it/resources/images/room.png')");
	    	
	    } else if ($(".dtype").eq(i).val()=="#E7FEE4"){
	    	
	   		 $(".sortableBox").eq(i).css("background-image","url('/it/resources/images/transportation.png')");
		    	
	    } else if ($(".dtype").eq(i).val()=="#FEFAC8"){
	    	
	   		 $(".sortableBox").eq(i).css("background-image","url('/it/resources/images/tourism_area.png')");
		    	
	    }
	    
	    
	    
	    
	    
	    
	    
	    $(".sortableBox").eq(i).css("background-repeat","no-repeat");
	    $(".sortableBox").eq(i).css("background-position","10px center");
	    $(".sortableBox").eq(i).css("background-size","30px");
	    $(".sortableBox").eq(i).css("minwidth","360px");
	    $(".sortableBox").eq(i).css("width","100%");

	    
	}
	
	}
	
	/* 모달에ddate를 클래스명을 활용해서 옮기는 메서드 */
	function writeddate(e){
		console.log($(e).attr('class'));
		console.log($(e).parent('div').prev('div'));

		
		$(".ddateModal").val($(e).attr('class'));
		
	}
	
	
	function resetEditForm(){
		   $('#dailyEditForm')[0].reset();	 	

	}

	
</script>
	
	
</body>
</html>


	<!-- SORTABLE  -->
	
	<link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" />
    <script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
     <script type="text/javascript" src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
    <script type="text/javascript" src="http://www.pureexample.com/js/lib/jquery.ui.touch-punch.min.js"></script>
 
