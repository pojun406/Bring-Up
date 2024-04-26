import React from 'react';
import "./login.css";
import Header from "../company_header/header";

function Login() {
    const [isPersonal, setIsPersonal] = React.useState(true);
    const handleMembershipChange = (isPersonal) => {
        setIsPersonal(isPersonal);
    };
    return (
        <div className="main">
            <Header/>
            <form className="login-form">
                <header className="login-header">
                    <h1 className="logo">BringUP</h1>
                    <nav className="membership-nav">
                        <MembershipButton
                            isActive={isPersonal}
                            onClick={() => handleMembershipChange(true)}
                        >
                            개인 회원
                        </MembershipButton>
                        <MembershipButton
                            isActive={!isPersonal}
                            onClick={() => handleMembershipChange(false)}
                        >
                            기업 회원
                        </MembershipButton>
                    </nav>
                </header>
                {!isPersonal &&
                    <>
                    <main className="login-main">
                        <label htmlFor="username" className="visually-hidden">
                            아이디
                        </label>
                        <input
                            type="text"
                            id="username"
                            className="input-field"
                            placeholder="아이디"
                        />
                        <label htmlFor="password" className="visually-hidden">
                            비밀번호
                        </label>
                        <input
                            type="password"
                            id="password"
                            className="input-field"
                            placeholder="비밀번호"
                        />
                        <div className="login-options">
                            <label className="checkbox-label">
                                <input type="checkbox" className="checkbox-input"/>
                                자동 로그인
                            </label>
                            <label className="checkbox-label">
                                <input type="checkbox" className="checkbox-input"/>
                                아이디 저장
                            </label>
                        </div>
                        <button type="submit" className="login-button">
                            로그인
                        </button>
                    </main>
                    <footer className="login-footer">
                    <a href="#" className="footer-link">
                    회원가입
                    </a>
                    <span className="footer-divider"/>
                    <a href="#" className="footer-link">
                    아이디/비밀번호 찾기
                    </a>
                    </footer>
                    </>
                }
            </form>
        </div>
    );
}

const MembershipButton = ({isActive, onClick, children}) => (
    <button
        type="button"
        className={`membership-button ${isActive ? "active" : ""}`}
        onClick={onClick}
    >
        {children}
    </button>
);

export default Login;