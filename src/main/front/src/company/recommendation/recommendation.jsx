import React from 'react';
import "./recommendation.css";
import Header from "../../company_header/header";

function Recommendation() {
    return (
        <div className="main">
            <Header />
            <div className="content">
                <div>인재 추천</div>
                <p> /company/recommendation</p>
            </div>
        </div>
    );
}

export default Recommendation;