import React from 'react';
import "./details.css";
import Header from "../../company_header/header";

function Details() {
    return (
        <div className="main">
            <Header />
            <div className="content">
                <div>기업 상세</div>
                <p> /company/details</p>
            </div>
        </div>
    );
}

export default Details;