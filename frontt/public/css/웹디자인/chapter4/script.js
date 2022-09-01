const listt = []

function table(){

	const submitpeaple = {
		name : document.getElementById('name1').value ,
		engname : document.getElementById('engname1').value ,
		email : document.getElementById('email1').value ,
		popol : document.getElementById('popol1').value ,
		state : document.getElementById('select1').value ,
		text : document.getElementById('textarea').value
	}
		
	listt.push(submitpeaple)

	alert(submitpeaple.name +'님 점수 등록이 되었습니다.')
	
	document.getElementById('name1').value = ''
	document.getElementById('engname1').value = ''
	document.getElementById('email1').value = '' 
	document.getElementById('popol1').value = ''	
	document.getElementById('select1').value = ''
	document.getElementById('textarea').value = ''
	
	outputtable()
}


function outputtable(){
	
	let output = '<tr>'+
					'<th>성명</th>'+
					'<th>영문명</th>'+
					'<th>메일 주소</th>'+
					'<th>포트폴리오</th>'+
					'<th>현재 상태</th>'+
				'</tr>'
				
	for(let i = 0 ; i < listt.length ; i++){
		
		output += '<tr>'+
					'<th>'+listt[i].name+'</th>'+
					'<th>'+listt[i].engname+'</th>'+
					'<th>'+listt[i].email+'</th>'+
					'<th>'+listt[i].popol+'</th>'+
					'<th>'+listt[i].state+'</th>'+
				'</tr>'
	}
				
	document.getElementById('listtable').innerHTML = output
}





let pieData = {
	labels : ['웹디자이너','웹개발자','서버엔지니어','영업직'],
	series : [14,9,8,6]
}
let pieOptions = {
	width : '100%',
	height : '440px'
}

new Chartist.Pie('.pie_chart',pieData,pieOptions)







let barData = {
	labels : ['2018년','2019년','2020년'],
	series : [[10,16,29]]
}



let barOptions = {
	axixY : {
		offset : 60 ,
		scaleMinSpace : 50 , 
		labelInterpolationFnc: function(value){
			return value + '명'
		}
	} ,
	width : '100%' ,
	height : '400px'
}

new Chartist.Bar('.bar_chart',barData,barOptions)



let barData1 = {
	labels : [],
	series : [[]]
	}
	
	
let barOptions1 = {
	axixY : {
		offset : 60 ,
		scaleMinSpace : 50 , 
		labelInterpolationFnc: function(value){
			return value + '명'
		}
	} ,
	width : '100%' ,
	height : '400px'
	}
	
	
	
	
function 차트그리기(){
	
	const name = document.getElementById('name').value;
	const money = document.getElementById('money').value;
	barData1.labels.push(name)
	barData1.series[0].push(money)

	new Chartist.Bar('.bar_chart1',barData1,barOptions1)

}


















