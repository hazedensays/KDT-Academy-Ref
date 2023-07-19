
function send() {
    // 객체정의
    let student = {
        name : document.getElementById("name").value,
        age : document.getElementById("age").value,
        team : document.getElementById("team").value,
        career : document.getElementById("career").value,
        info1 : document.getElementById("info1").value,
        info2 : document.getElementById("info2").value,

        infoPrint : function() {
            return `저의 이름은 ${this.name}이고요, 나이는 ${this.age}살 입니다.
                    저희 팀 이름은 ${this.team}이고 경력은 ${this.career} 입니다.
                    희망사항은 오직 ${this.info1}이고 건의사항은 ${this.info2}예요.`;
        }
    }; //student

    //div 출력
    document.getElementById("content").innerHTML = student.infoPrint();

}