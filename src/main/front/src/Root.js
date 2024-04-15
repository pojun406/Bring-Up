import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import App from './App';
import Company from './company/c_main'; // 새로 추가한 Company 컴포넌트

const Root = () => {
    return (
        <Router>
            <Routes>
                <Route path="/" element={<App />} />
                <Route path="/company" element={<Company />} />
            </Routes>
        </Router>
    );
};

export default Root;
