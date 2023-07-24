/**
** 입력값의 무결성 확인
** member 무결성 확인사항
// ID : 길이(4~10), 영문자,숫자 로만 구성
// Password : 길이(4~10), 영문,숫자,특수문자로 구성, 특수문자는 반드시 1개 이상 포함할것
// Password2: 재입력후 Password 와 일치성 확인
// Name : 길이(2이상), 영문 또는 한글로 만 입력
// Age: 정수의 범위  ( 숫자이면서, '.'이 없어야함 )  
// BirthDay : 입력 여부 확인  ( length == 10 )
// Point : 실수 ( 구간설정 100 ~ 10000 까지만 가능 )
// Jno : select 를 이용 (X)
// Info : (X)

** 작성 규칙
   => JavaScript function 으로 정의 하고 
      결과를 true or false 로 return
   => 정규식을 활용한다.
   
** match Test
   => 아래 조건에 true -> not (!)  match 적용해보면
   => 정확하지 않으므로 (부적절, replace 를 사용)
        ...       
        } else if (!id.match(/[a-z.0-9]/gi)) {
            alert(' ID는 영문자와 숫자로만 입력하세요. !!!')
            return false;
        }    
 */

        "use strict"

        // 1) ID
        function idCheck() {
          let id=document.getElementById('id').value;
          if (id.length<4 || id.length>10) { 
             document.getElementById('iMessage').innerHTML='id 는 4~10 글자 입니다.' ;
             return false;
        
          // => 영문과 숫자로만 입력했는지 : id 에서 영문과 숫자를 모두 '' 로 변경했을때 length 가 0 이면 OK    
          }else if ( id.replace(/[a-z.0-9]/gi,'').length > 0 ) {
              document.getElementById('iMessage').innerHTML='id 는 영문과 숫자만 입력하세요.' ;
              return false;
          }else {
             document.getElementById('iMessage').innerHTML='' ;
             return true;
           };//if
        } //idCheck
        
        
        // 2) Password
        function pwCheck() {
          let password=document.getElementById('password').value;
          let special = /[`~!@#$%^&*|\\\'\";:\/?]/gi;
          special = /[!-*.@]/gi;  // 특수문자범위 축소
        
          if (password.length<4 || password.length>10) { 
            document.getElementById('pMessage').innerHTML='password 는 4~10 글자 입니다.' ;
            return false;
          // => 영문, 숫자, 특수문자 로만 구성 되었는지 확인  
          }else if(password.replace(/[a-z.0-9.!-*.@]/gi,'').length > 0) {  
            document.getElementById('pMessage').innerHTML = '영문, 숫자, 특수문자 로만 입력하세요 ~~';
            return false;
          // => 특수문자 포함 확인 : 정규식의 test 메서드 활용 
          }else if (special.test(password) == false) {
            document.getElementById('pMessage').innerHTML = '특수문자가 포함되어야 합니다.';
            return false;
          }else {
            document.getElementById('pMessage').innerHTML = '';
            return true;
          }
        } //pwCheck
        
        
        // 3) Password2
        // => Password 와 동일성확인
        function pw2Check() {
          let password=document.getElementById('password').value;
          let password2=document.getElementById('password2').value;
        
          if (password!=password2) { 
            document.getElementById('p2Message').innerHTML='password 가 다릅니다.' ;
            return false;
          }else {
            document.getElementById('p2Message').innerHTML='' ;
            return true;  
          }
        } //pw2Check
        
        // 4) Name : 길이, 한글과 영문
        function nmCheck() {
          let name=document.getElementById('name').value;
        
          if (name.length<2) { 
            document.getElementById('nMessage').innerHTML='name 은 2글자 이상 입력하세요.' ;
            return false;
          }else if ( name.replace(/[a-z.가-힣]/gi,'').length>0 ) {
            document.getElementById('nMessage').innerHTML='name 은 한글과 영문으로만 입력하세요.' ;
            return false;
          }else {
            document.getElementById('nMessage').innerHTML='' ;
            return true;  
          }
        } //nmChec 
        
        
        // 5) Age (정수)
        //    => 정수의 조건 : 숫자이면서, "."이 없어야함
        //    => Number.inInteger(n) : 정수 확인 가능 (n이 정수일 때만 true)
        //    => 단 n이 숫자 타입이어야함. value는 문자로 인식되기 때문에 parseInt를 써서 숫자화해야함
        //    => 단, parseInt(age) 사용시 주의
        //    => 실수 입력 시 정수로 바뀌어 처리됨
        //    => 문자(숫자 뒤쪽에 포함된 문자일 때)가 포함된 숫자도 앞쪽의 숫자값만 가져와 정수 return됨
        function agCheck() {
          let age=document.getElementById('age').value;
        
          //console.log("parseInt(age) => " + parseInt(age)); 
          //console.log("Number.isInterger(age) => " + Number.isInteger(age));  ----1
          //console.log("Number.isInterger(parseInt(age)) => " + Number.isInteger(parseInt(age))); ----2
          //age에 123.456 이나 123aaa 를 넣어도 parseInt를 적용하면 소수점과 문자를 버리고 정수 타입으로 반환되어
          //정수 타입인지 확인할 시에 true가 나온다
        
          // '^' -> 아니다
          if (age.replace(/[^0-9]/g,'').length < age.length || Number.isInteger(parseInt(age)) == false) {
            document.getElementById("aMessage").innerHTML = "숫자만 입력하세요.";
            return false;
          } else {
            document.getElementById("aMessage").innerHTML = '';
            return true;
          }
        } //agChec 
        
        
        // 6) Birthday
        function bdCheck() {
          let birthday=document.getElementById('birthday').value;
        
          if (birthday.length!=10) { 
            document.getElementById('bMessage').innerHTML='birthday (yyyy-mm-dd) 입력 확인 !!!' ;
            return false;
          }else {
            document.getElementById('bMessage').innerHTML='' ;
            return true;
          };//if
        } //bdCheck
        
        
        // 7) Point
        // => 정수 또는 실수 허용
        // => 범위: 100 ~ 10000
        // => parseFloat(point)
        //    -> 오류 또는 입력값이 없는 경우 NaN return
        //    -> 확인 : Number.isNaN(parseFloat(point)) 
        //    -> 단, 숫자로 시작하면 뒤쪽에 문자가 섞여있어도 숫자값만 사용함 ( NaN 을 return 하지않음 ) 
        function poCheck() {
          let point=document.getElementById('point').value;
        
          console.log ("parseFloat(point) => " + parseFloat(point));
          console.log ("Number.isNaN(point) => " + Number.isNaN(point));
          console.log ("Number.isNaN(parseFloat(point)) => " + Number.isNaN(parseFloat(point)));
        
          // 숫자가 아닌 값이 있는지 확인 & Number.isNaN 적용
          // 소수점이 있으면 포함시켜야 하므로 정규식에 추가
          // 소수점이 기호가 아니라 비교값이므로 "/." 식으로 표기함
        
          if (point.replace(/[^0-9. /.]/g, '').length < point.length ||
              Number.isNaN(parseFloat(point)) == true) { //==true는 생략 가능
                document.getElementById("oMessage").innerHTML = "point는 정수 / 실수로만 입력 가능";
                return false;
            } else if (parseFloat(point) < 100 || parseFloat(point) > 10000) {
                document.getElementById("oMessage").innerHTML = "100~10000 범위 내에서 입력하세요";
                return false;
            } else {
                document.getElementById("oMessage").innerHTML = '';
                return true;
            }
        } //poCheck