window.onload = function() {        //window는 생략 가능, onload = function(), 익명함수
    document.getElementById("firstP").style.color="yellow";
    document.getElementById("firstP").style.background="blue";
}

function colorChange() {
    document.getElementById("firstP").style.color="hotpink";
}

function colorChange2(id, color) {
    document.getElementById(id).style.color=color;
}

function star() {
    document.getElementById("starId").innerHTML += '⭐';
    // document.getElementById("starId").innerText += '<b>⭐</b>';
}

function minus() {
    let s = document.getElementById("starId").innerHTML;
    if (s.length > 4) {
        document.getElementById("starId").innerHTML=s.substring(0,(s.length-1));
    }
}

/* function minus() {
    let s = document.getElementById("starId").innerHTML;
    if (s.length > 4) {
        s=s.substring(0,(s.length-1));
    }
}

프로그래밍 언어에서 = 은 같다는 의미가 아니다
우측의 값을 좌측에 대입을 한다는 의미이다. */






    // ** 2. Document 객체의 주요 프로퍼티 **
let text1 = '** 문서로딩중일때 : document.readyState => '+document.readyState+'\n'; 

// 문서가 완전히 로드(출력)되었을 때, 현재 document의 프로퍼티 출력 
function printProperties() {
  
  document.getElementById('input').focus(); // 포커스 부여
  
  text1+="1. location = "+document.location+"\n";
  text1+="2. URL = "+document.URL+"\n";
  text1+="3. title = "+document.title+"\n";
  text1+="4. head.id = "+document.head.id+"\n";
  text1+="5. domain = "+document.domain+"\n";
  text1+="6. lastModified = "+document.lastModified+"\n";
  text1+="7. defaultView = "+document.defaultView+"\n";
  text1+="8. 문서로딩 완료후: readyState = "+document.readyState+"\n";
  text1+="9. body color = "+document.body.style.color+"\n";
  text1+="10. referrer: 이전 페이지 url = "+document.referrer+"\n";
  text1+="11. activeElement = "+document.activeElement.value+"\n";
  text1+="12. documentElement의 태그명 (요소에 호출된 Tag명) = "+document.documentElement.tagName+"\n";
  alert(text1);   
}
