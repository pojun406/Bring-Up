import React from 'react';
import "./report.css";
import Header from "../../company_header/header";

function Report() {
    return (
        <div className="main">
            <Header />
            <div className="content">
                <div>신고내역</div>
                <p> /company/report</p>
            </div>
        </div>
    );
}

export default Report;