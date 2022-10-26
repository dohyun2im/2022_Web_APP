
let list = null;
getdata();

function getdata(){
	$.ajax({
		url: "/jsp_web/board/api",
		success : function(re){
			let json = JSON.parse(re)
			list = json.data
			dataprint()
		}
	})
}

function addrsearch(){
	let addr = document.querySelector('.addrinput').value
	dataprint(addr);
}

function dataprint(search){	
	if(search!==undefined){
		let searchlist = [];
		for(let i=0; i<list.length; i++){
			let addrs = list[i].주소
			if(addrs.indexOf(search)!==-1){
				searchlist.push(list[i])			
			}
		}
		list=searchlist;
		if(search==''){getdata()}
	}
	
	let html = '<tr>	<th>약국명</th>	<th>전화번호</th> 	<th>주소</th> 	</tr>';
	for(let i=0; i<list.length ; i++){
		let data = list[i]
		html+= '<tr onclick="mapview('+i+')">'+
				'<td>'+data.약국명+'</td><td>'+data.대표전화+'</td><td>'+data.주소+'</td>'+
			   '<tr>'		
	}
	document.querySelector('.table1').innerHTML=html;
}


function mapview(i){
	
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	    mapOption = { 
	        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
	        level: 3 // 지도의 확대 레벨
	    };
	
	// 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
	var map = new kakao.maps.Map(mapContainer, mapOption); 
	
	// 주소-좌표 변환 객체를 생성합니다
	var geocoder = new kakao.maps.services.Geocoder();
	
	// 주소로 좌표를 검색합니다
	geocoder.addressSearch(list[i].주소, function(result, status) {

    // 정상적으로 검색이 완료됐으면 
     if (status === kakao.maps.services.Status.OK) {

        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

        // 결과값으로 받은 위치를 마커로 표시합니다
        var marker = new kakao.maps.Marker({
            map: map,
            position: coords
        });
		kakao.maps.event.addListener(marker, 'click', function() {
   			detailview(i)
		});
        // 인포윈도우로 장소에 대한 설명을 표시합니다
        var infowindow = new kakao.maps.InfoWindow({
            content: '<div style="width:150px;text-align:center;padding:6px 0;">'+list[i].약국명+'</div>'
        });
        infowindow.open(map, marker);

        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
        map.setCenter(coords);
   	 }
     
	});   
}
function detailview(i){
	let html = '<div>'+list[i].약국명+'</div>'+
			   '<div>'+list[i].주소+'</div>'+
			   '<div>'+list[i].대표전화+'</div>'+
			   '<div><button>평점주기</button></div>'+
			   '<div><button>문의하기</button></div>';
	document.querySelector('.detailbox').innerHTML=html;
	
}

getdata2()
function getdata2(){
	$.ajax({
		url: "/jsp_web/api2",
		success:function(re){
			let apilist = JSON.parse(re)

			let html = '';
			
			for(let i=0; i<apilist.length; i++){
				html+='<tr>'+
					'<td>'+apilist[i].시군구+'</td>'+
					'<td>'+apilist[i].번지본번부번+'</td>'+
					'<td>'+apilist[i].단지명+'</td>'+
					'<td>'+apilist[i].전용면적+'</td>'+
					'<td>'+apilist[i].계약년월+'</td>'+
					'<td>'+apilist[i].계약일+'</td>'+
					'<td>'+apilist[i].거래금액+'</td>'+
					'<td>'+apilist[i].층+'</td>'+
					'<td>'+apilist[i].건축년도+'</td>'+
					'<td>'+apilist[i].도로명+'</td>'+
					'<td>'+apilist[i].해제사유발생+'</td>'+
					'<td>'+apilist[i].거래유형+'</td>'+
					'<td>'+apilist[i].중개사+'</td>'+
					'</tr>';
			}
			document.querySelector('.atable').innerHTML=html;
		}
	})
}

















