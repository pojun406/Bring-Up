import React from 'react';
import Header from "./header/header";
import "./c_main.css";

function c_main() {
    return (
        <div className="main">
            <Header />
            <div className="content">
                <div>content</div>
                <p> /company 경로</p>
            </div>
        </div>
    );
}

export default c_main;