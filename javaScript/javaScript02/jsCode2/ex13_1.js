onload = function() {
    let p = document.getElementById('p');
    //이벤트 핸들러를 익명함수로
    p.addEventListener('mouseover', function(){this.style.color="hotpink";});
    p.addEventListener('mouseout', function(){this.style.color="greenyellow";});

    //이벤트 핸들러를 함수를 만들어 놓고 call (매개변수로 사용)
    p.addEventListener('mouseover', over);
    p.addEventListener('mouseout', out);
    //콜백함수는 호출할 때 ()를 사용하지 않는다
    //p.addEventListener('mouseout', out()); -> 잘못된 예시
    //over() 일반함수 call
}

function over() {
    this.style.backgroundColor="hotpink";
    this.style.color="greenyellow";
}

function out() {
    this.style.backgroundColor="greenyellow";
    this.style.color="hotpink";
}
