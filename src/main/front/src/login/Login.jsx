/*eslint-disable*/
import React, { useState } from 'react';
import './Login.css';

function Login() {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    const handleLogin = () => {
        // 로그인 로직을 추가하세요
        console.log(`Email: ${email}, Password: ${password}`);
    };

    return (
        <div className="login-container">
            <div className="login-box">
                <h2 className="login-title">로그인</h2>
                <form>
                    <div className="form-group">
                        <input
                            type="email"
                            value={email}
                            onChange={(e) => setEmail(e.target.value)}
                            placeholder="이메일"
                            className="login-input"
                        />
                    </div>
                    <div className="form-group">
                        <input
                            type="password"
                            value={password}
                            onChange={(e) => setPassword(e.target.value)}
                            placeholder="비밀번호"
                            className="login-input"
                        />
                    </div>
                    <button type="button" onClick={handleLogin} className="login-button">로그인</button>
                </form>
                <p className="forgot-password">비밀번호를 잊으셨나요?</p>
                <hr />
                <div className="signup-link">
                    계정이 없으신가요? <a href="#">회원가입</a>
                </div>
            </div>
        </div>
    );
}

export default Login;