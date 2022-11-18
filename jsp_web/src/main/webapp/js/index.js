/**
 * 
 */
 getpactive1()
 function getpactive1(){
	 $.ajax({
		url: "/jsp_web/admin/regist",
		type:"get",
		data:{"type":1 , "option":"pactive1"},
		success : function(re){
			let json = JSON.parse(re)
			console.log(json)
			let html = '';
			
			json.forEach(p => {
				html +=		   '<div class="item">'+
					'				<a href="/jsp_web/product/view.jsp?pno='+p.pno+'">'+
					'					<img alt="" src="/jsp_web/admin/pimg/'+p.pimg+'">'+
					'				</a>'+
					'				<div class="item_info">'+
					'					<div class="item_title">'+p.pname+'</div>'+
					'					<div class="item_size">Free</div>'+
					'					<div class="item_price">'+p.pprice.toLocaleString("ko-KR")+"원"+'</div>'+
					'					<div>'+
					'						<span class="item_sale">'+(p.pprice*(1-p.pdiscount)).toLocaleString("ko-KR")+"원"+'</span>'+
					'						<span class="item_discount">'+(100*p.pdiscount)+"%"+'</span>'+
					'						<span class="item_review">리뷰 40000</span>'+
					'					</div>'+
					'					'+
					'				</div>'+
					'				'+
					'				<div>'+
					'					<span class="badge text-bg-dark">주문폭주</span>'+
					'					<span class="badge text-bg-dark">1+1</span>'+
					'				</div>'+
					'			</div>';
			})
			
			document.querySelector('.itemlist').innerHTML += html; 
		}
		
	})
	
}
datas = [50,100,30];
chart()
function chart(){
	var context = document
	    .getElementById('myChart')
	    .getContext('2d');
	var myChart = new Chart(context, {
	    type: 'bar', // 차트의 형태
	    data: { // 차트에 들어갈 데이터
	        labels: [
	            //x 축
	            '1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'
	        ],
	        datasets: [
	            { //데이터
	                label: '김도현 사원 2022 실적', //차트 제목
	                fill: false, // line 형태일 때, 선 안쪽을 채우는지 안채우는지
	                data: 
	                    datas//x축 label에 대응되는 데이터 값
	                ,
	                backgroundColor: [
	                    //색상
	               'rgba(255, 99, 132, 0.2)',
	                   'rgba(54, 162, 235, 0.2)',
	                   'rgba(255, 206, 86, 0.2)',
	                   'rgba(75, 192, 192, 0.2)',
	                   'rgba(153, 102, 255, 0.2)',
	                   'rgba(255, 159, 64, 0.2)',
	                   'rgba(255, 99, 132, 0.2)',
	                   'rgba(54, 162, 235, 0.2)',
	                   'rgba(255, 206, 86, 0.2)',
	                   'rgba(75, 192, 192, 0.2)',
	                   'rgba(153, 102, 255, 0.2)',
	                   'rgba(255, 159, 64, 0.2)'
	                ],
	                borderColor: [
	                    //경계선 색상
	                    'rgba(255, 99, 132, 1)',
	                    'rgba(54, 162, 235, 1)',
	                    'rgba(255, 206, 86, 1)',
	                    'rgba(75, 192, 192, 1)',
	                    'rgba(153, 102, 255, 1)',
	                    'rgba(255, 159, 64, 1)',
	                    'rgba(255, 99, 132, 1)',
	                    'rgba(54, 162, 235, 1)',
	                    'rgba(255, 206, 86, 1)',
	                    'rgba(75, 192, 192, 1)',
	                    'rgba(153, 102, 255, 1)',
	                    'rgba(255, 159, 64, 1)'
	                ],
	                borderWidth: 3 //경계선 굵기
	            } 
	        ]
	    },
	    options: {
	        scales: {
	            yAxes: [
	                {
	                    ticks: {
	                        beginAtZero: true
	                    }
	                }
	            ]
	        }
	    }
	});
}
