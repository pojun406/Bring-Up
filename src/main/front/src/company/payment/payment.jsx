import React from 'react';
import "./payment.css";
import Header from "../../company_header/header";

function Payment() {
    return (
        <div className="main">
            <Header />
            <div className="content">
                <div>결제내역</div>
                <p> /company/payment</p>
            </div>
        </div>
    );
}

export default Payment;