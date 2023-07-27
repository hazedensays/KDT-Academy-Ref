// ** 컴포넌트 1개에, 1개 파일
//    => 그러므로 export default 많이 사용됨

function Header(props) {
    return (
        <header>
            <h1>** Header **</h1>
            <p>나는 {props.trip.country}을 {props.trip.days}동안 여행할 예정!!<br></br>
            난 j이기 때문에 예약은 모두 {props.trip.reservation}했어요~</p>

            {/* <p>난 j이기 때문에 예약은 모두 {props.trip}했어요~</p>  이건 오류 */}
        </header>
    );
}

export default Header;