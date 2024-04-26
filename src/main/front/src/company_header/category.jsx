import React, { useRef, useState } from "react";
import "./category.css";
function Category() {
    const dropdownRefs = useRef(Array(4).fill(null));
    const [openIndex, setOpenIndex] = useState(null);

    const handleMouseEnter = (index) => {
        if(openIndex!==null){
            setOpenIndex(null);
        }
        setOpenIndex(index);
    };

    const handleMouseLeave = () => {
        setOpenIndex(null);
    };

    const handleItemClick = (event) => {
        event.stopPropagation();
        if (event.target.tagName === "A") {
            setOpenIndex(null);
        }
    };

    const categories = [
        {
            label: "공고", options: [
                {label: "공고 관리", href: "manage-announcements"},
                {label: "공고 등록", href: "create-announcement"},
            ],
        },
        {
            label: "상품", options: [
                {label: "상품 관리", href: "manage-products"},
                {label: "프리미엄 공고", href: "premium-announcements"},
                {label: "광고 배너", href: "advertising-banners"},
                {label: "이력서 열람", href: "view-resumes"},
            ],
        },
        {
            label: "리뷰 관리", options: [
                {label: "기업 리뷰", href: "manage-company-reviews"},
                {label: "면접 리뷰", href: "manage-interview-reviews"},
            ],
        },
        {
            label: "인재 추천", options: [
                {label: "인재 추천", href: "recommendation"},
            ],
        },
    ];

    return (
        <div className="category">
            {categories.map((category, index) => (
                <div
                    key={index}
                    className="dropdown-wrapper"
                    onMouseEnter={()=>handleMouseEnter(index)}
                    onMouseLeave={handleMouseLeave}
                    onClick={handleItemClick}
                >
                    <button className="list">{category.label}</button>
                    {openIndex === index && (
                        <ul
                            className="dropdown-menu"
                            ref={(el) => (dropdownRefs.current[index] = el)}
                            onClick={handleItemClick}
                        >
                            {category.options.map((option, optionIndex) => (
                                <a className="dropdown-item" href={`/company/${option.href}`}>
                                    <li key={optionIndex} onClick={handleItemClick}>
                                        {option.label}
                                    </li>
                                </a>
                            ))}
                        </ul>
                    )}
                </div>
            ))}
        </div>
    );
}
export default Category;