import React from 'react';
import "./manage-products.css";
import Header from "../../company_header/header";

function ManageProducts() {
    return (
        <div className="main">
            <Header />
            <div className="content">
                <div>상품 관리</div>
                <p>/company/manage-products</p>
            </div>
        </div>
    );
}

export default ManageProducts;