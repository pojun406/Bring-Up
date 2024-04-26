import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import App from './App';
import Company from './company/c_main';
import ManageAnnouncements from "./company/manage-announcements/manage-announcements";
import AdvertisingBanners from "./company/advertising-banners/advertising-banners";
import CreateAnnouncement from "./company/create-announcement/create-announcement";
import ManageCompanyReviews from "./company/manage-company-reviews/manage-company-reviews";
import ManageInterviewReviews from "./company/manage-interview-reviews/manage-interview-reviews";
import ManageProducts from "./company/manage-products/manage-products";
import PremiumAnnouncements from "./company/premium-announcements/premium-announcements";
import Recommendation from "./company/recommendation/recommendation";
import ViewResumes from "./company/view-resumes/view-resumes";
import Details from "./company/details/details";
import ModifyingInformation from "./company/modifying-information/modifying-information";
import Payment from "./company/payment/payment";
import Report from "./company/report/report";
import Login from "./login/login";

const Root = () => {
    return (
        <Router>
            <Routes>
                <Route path="/" element={<App />} />
                <Route path="/login" element={<Login />} />
                <Route path="/company" element={<Company />} />
                <Route path="/company/manage-announcements" element={<ManageAnnouncements />} />
                <Route path="/company/advertising-banners" element={<AdvertisingBanners />} />
                <Route path="/company/create-announcement" element={<CreateAnnouncement />} />
                <Route path="/company/manage-company-reviews" element={<ManageCompanyReviews />} />
                <Route path="/company/manage-interview-reviews" element={<ManageInterviewReviews />} />
                <Route path="/company/manage-products" element={<ManageProducts />} />
                <Route path="/company/premium-announcements" element={<PremiumAnnouncements />} />
                <Route path="/company/recommendation" element={<Recommendation />} />
                <Route path="/company/view-resumes" element={<ViewResumes />} />
                <Route path="/company/details" element={<Details />} />
                <Route path="/company/modifying-information" element={<ModifyingInformation />} />
                <Route path="/company/payment" element={<Payment />} />
                <Route path="/company/report" element={<Report />} />
            </Routes>
        </Router>
    );
};

export default Root;
