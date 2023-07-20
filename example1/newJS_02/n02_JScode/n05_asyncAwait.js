"use strict"

// Test1
    // =>  try 블럭에서 오류발생시 모든 오류를 catch 블럭에서 처리함
    async function test1() {
        try {
          let response = await fetch('../javaScript04/snowVillage.html');
          // => fetch 는 response  받았을때 예외처리를 해주지않기 때문에
          //    catch 블럭이 실행되지 않음
          
          //let responseData = response.json(); -> 오류발생, catch 블럭실행안됨
          let responseData = await response.json(); //-> 오류발생, catch 블럭에서 처리
        } catch (error) {
          console.log(`** Test1) error => ${error}`);
          
        }
      } //test1
      test1();
      
      // Test2 
      // => async로 정의된 test2() 는 프로미스를 return 하므로 then() 또는 catch() 사용가능 
      async function test2() {
        let response = await fetch('../javaScript04/snowVillage.html');
        let user = await response.json();
      } 
     test2().catch((error)=> {console.log(`** Test2) error => ${error}`)});