  // 1) 다양한 윈도우 열기 사례
  // => window.open('url','name','속성')
  // => name: _blank, _parent, _self, _top, name지정(_blank 처럼 새창을 open)

onload = function() {
    //1.1)
    document.getElementById("win1").onclick = () => {
        window.open('./snowVillage.html','myWindow','toolbar = yes');
    }

    //1.2)
    document.getElementById("win2").onclick = () => {
        window.open('./snowVillage.html', '_self', '');
    }
    
    //1.3)
    document.getElementById("win3").onclick = () => {
        window.open('./snowVillage.html', '_blank', '');
    }
    
    //1.4)
    document.getElementById("win4").onclick = () => {
        window.open('./snowVillage.html', '', '');
        // window.open('./snowVillage.html');
    }
    
    //1.5)
    document.getElementById("win5").onclick = () => {
        window.open('', '', '');
        // window.open('', null, null);
    }
    
    //1.6)
    document.getElementById("win6").onclick = () => {
        window.open('./snowVillage.html', 'myWindow', 'left = 10, top = 10, width = 400px, height = 300px');
    }



    //2) 윈도우 이름과 윈도우 Open Test
    // myWindow에 open 하기
    document.getElementById("test").onclick = function() {
        window.open("https://www.w3schools.com/", "myWindow");
    }
}