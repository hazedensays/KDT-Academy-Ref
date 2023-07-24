		// 1) 이전방식
		let Animal = function(){ };
		Animal.prototype.eat = function(){ console.log('먹기'); }
		Animal.prototype.sound = function(){ console.log('소리내기'); }
		Animal.prototype.breath = function(){ console.log('색색'); }
		
		let Dog = function(){};
		Dog.prototype = new Animal(); // prototype chaining 매커니즘
		Dog.prototype.sound = function(){ console.log('멍멍'); }  // 메서드오버라이딩
		Dog.prototype.eat = function(){ console.log('사료'); }    // 메서드오버라이딩
		Dog.prototype.guard = function(){ console.log('집지키기'); }
		
		let Tiger = function(){};
		Tiger.prototype = new Animal();
		Tiger.prototype.sound = function(){ console.log('어흥'); } // 메서드오버라이딩
		Tiger.prototype.eat = function(){ console.log('닭고기'); } // 메서드오버라이딩
		Tiger.prototype.attack = function(){ console.log('공격'); }
		
		let dog = new Dog();
		dog.sound();
		dog.breath(); // dog 에서 Animal 메서드 접근

		let tiger = new Tiger();
		tiger.sound();
		tiger.breath();
		
		// 2) ES6
		class Animal2 {
			//constructor() {}; -> 기본생성자 생략가능
			eat() { console.log('먹기'); }
			sound() { console.log('소리내기'); }
			breath() { console.log('색색'); }
		} //Animal2
		
		class Dog2 extends Animal2 {
			//constructor() { super(); }; -> 기본생성자 생략가능
			eat() { console.log('사료'); }
			sound() { console.log('멍멍'); }
			guard() { console.log('집지키기'); }
		} //Dog2
		
		class Tiger2 extends Animal2 {
			constructor() { super(); };
			eat() { console.log('닭고기'); }
			sound() { console.log('어흥'); }
			attack() { console.log('공격'); }
		} //Dog2
		
		let dog2 = new Dog2();
		dog2.breath();
		dog2.sound();
		dog2.eat();
		dog2.guard()
		
		let tiger2 = new Tiger2();
		tiger2.breath();
		tiger2.sound();
		tiger2.eat();
		tiger2.attack();