import React from 'react';
import Header from "../../company_header/header";
import "./manage-announcements.css";

function ManageAnnouncements() {
    return (
        <div className="main">
            <Header />
            <div className="content">
                <div>공고 관리</div>
                <p> /company/manage-announcements</p>
            </div>
        </div>
    );
}

export default ManageAnnouncements;