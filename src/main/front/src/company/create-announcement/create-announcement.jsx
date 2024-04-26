import React from 'react';
import "./create-announcement.css";
import Header from "../../company_header/header";

function CreateAnnouncement() {
    return (
        <div className="main">
            <Header />
            <div className="content">
                <div>공고 등록</div>
                <p> /company/create-announcement</p>
            </div>
        </div>
    );
}

export default CreateAnnouncement;