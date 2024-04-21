import React from 'react';
import "./premium-announcements.css";
import Header from "../../company_header/header";

function PremiumAnnouncements() {
    return (
        <div className="main">
            <Header />
            <div className="content">
                <div>프리미엄 공고</div>
                <p>/company/premium-announcements</p>
            </div>
        </div>
    );
}

export default PremiumAnnouncements;