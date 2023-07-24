/* let arr = [1, 2, 3, 4, 5];
// let arr = [0, 2, 3, 4, 5];
// let arr = [1, 2, 3, 4, 100];

let square = arr.map(function(num) {return (num * num);});

try {
    for (let i of square) {
        if (i == 0 || i >= 100) {
            throw new Error("💥💥Error 발생💥💥");
        }
    }
    console.log (square);
} catch(err) {
    console.log (`Error 발생 => ${err}`) ;  
} finally {
    console.log ("메롱메롱 공부하장");
} */

let num = [0, 25, 100, 99, 111];
try {
    for (let i = 1; i <= num.length; i++) {
        for (let s of num) {
            sum = (i *= s);
            console.log(`** for Test : i=${i}, s=${s}, sum=${sum}`);
            if (sum == 0 || sum > 100) {
                throw new Error("Error 발생");
            }//if
        }//for_s
    }//for_i
} catch (error_test) {
    console.log (`catch: ${error_test}`);
} finally {
    console.log ("finally block");
}