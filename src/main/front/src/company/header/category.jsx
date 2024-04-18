import React, { useRef, useState } from "react";
import "./category.css";

const Category = () => {
    const dropdownRefs = useRef(Array(4).fill(null));
    const [openIndex, setOpenIndex] = useState(null);

    const handleMouseEnter = (index) => {
        setOpenIndex(index);
    };

    const handleMouseLeave = () => {
        setOpenIndex(null);
    };

    const handleItemClick = (event) => {
        event.stopPropagation(); // 부모 요소의 클릭 이벤트가 발생하지 않도록 이벤트 전파 중단
        // 클릭된 요소가 a 태그인 경우에만 드롭다운 메뉴가 닫히도록 설정
        if (event.target.tagName === "A") {
            setOpenIndex(null);
        }
    };

    const categories = [
        { label: "공고", options: ["옵션 1", "옵션 2", "옵션 3"] },
        { label: "상품", options: ["옵션 1", "옵션 2", "옵션 3"] },
        { label: "리뷰 관리", options: ["옵션 1", "옵션 2", "옵션 3"] },
        { label: "인재 추천", options: ["옵션 1", "옵션 2", "옵션 3"] },
    ];

    return (
        <div className="category">
            {categories.map((category, index) => (
                <div
                    key={index}
                    className="dropdown-wrapper"
                    onMouseEnter={() => handleMouseEnter(index)}
                    onMouseLeave={handleMouseLeave}
                    onClick={handleItemClick}
                >
                    <button className="list">{category.label}</button>
                    {openIndex === index && (
                        <ul
                            className="dropdown-menu"
                            ref={(el) => (dropdownRefs.current[index] = el)}
                            onMouseEnter={() => handleMouseEnter(index)} // 드롭다운 메뉴에 마우스가 들어가도 드롭다운을 유지
                            onMouseLeave={handleMouseLeave}
                        >
                            {category.options.map((option, optionIndex) => (
                                <li key={optionIndex}>
                                    <a className="dropdown-item" href="#">
                                        {option}
                                    </a>
                                </li>
                            ))}
                        </ul>
                    )}
                </div>
            ))}
        </div>
    );
};

export default Category;