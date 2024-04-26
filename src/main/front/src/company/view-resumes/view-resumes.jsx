import React from 'react';
import "./view-resumes.css";
import Header from "../../company_header/header";

function ViewResumes() {
    return (
        <div className="main">
            <Header />
            <div className="content">
                <div>이력서 열람</div>
                <p> /company/view-resumes</p>
            </div>
        </div>
    );
}

export default ViewResumes;