import '../Header.css';

const Header = () => {
    return(
        <div className="header">
            <h3>📅 Today is｡｡｡</h3>
            <h1>{new Date().toDateString()}</h1>
            {/* toDateString() : 날짜를 문자열로 */}
        </div>
    );  
};

export default Header;