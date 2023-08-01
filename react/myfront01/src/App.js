import logo from './logo.svg';
import './App.css';
import Header from './components/header';
import Body from './components/body';
import Footer from './components/footer';

// ** import
//    => 컴포넌트는 MyComp from real_File_path;
//       내부 코드에서 MyComp 이름으로 인식
//    => CSS는 real_File_path만 명시함

function App() {
  const name = "hotpinkJJang";
  const trip = {
      country: "베트남",
      days: "7일",
      reservation: "완료",
      memo: ["메롱", "바보", "킼키"]
  };

  return (
    <div className="App">
      <Header trip={trip}/>
      <Body name={name} country={"미국 캘리포니아"}/>
      <Footer/>
    </div>
  );
}

export default App;
