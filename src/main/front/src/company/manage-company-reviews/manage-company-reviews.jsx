import React from 'react';
import "./manage-company-reviews.css";
import Header from "../../company_header/header";

function ManageCompanyReviews() {
    return (
        <div className="main">
            <Header />
            <div className="content">
                <div>기업 리뷰</div>
                <p> /company/manage-company-reviews</p>
            </div>
        </div>
    );
}

export default ManageCompanyReviews;