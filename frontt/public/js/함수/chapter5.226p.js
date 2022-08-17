 setTimeout(()=> {console.log('1초 후에 실행됩니다')} , 1*1000)
 let count = 0
 let 타이머 = setInterval(()=> {console.log(`1초마다 실행됩니다${count}`)
 count++
 if(count ==5 ){
	console.log('타이머가 종료됩니다.')
	clearInterval(타이머)
}
 } , 1*1000)