import React, { useRef, useState } from "react";
import "./category.css";

const Category = () => {
    const dropdownRefs = [
        useRef(null),
        useRef(null),
        useRef(null),
        useRef(null),
    ];
    const [isOpens, setIsOpens] = useState([false, false, false, false]);

    const handleClicks = (index) => {
        setIsOpens((prev) => {
            const updatedIsOpens = [...prev];
            updatedIsOpens[index] = !updatedIsOpens[index];
            return updatedIsOpens;
        });
    };

    const handleCloses = (event, index) => {
        if (dropdownRefs[index].current && !dropdownRefs[index].current.contains(event.target)) {
            setIsOpens((prev) => {
                const updatedIsOpens = [...prev];
                updatedIsOpens[index] = false;
                return updatedIsOpens;
            });
        }
    };

    return (
        <div className="category">
            <div>
                <div className="dropdown">
                    <button
                        className="list"
                        onMouseEnter={() => setIsOpens(true)}
                        onMouseLeave={() => setIsOpens(false)}
                    >
                        공고
                    </button>
                    {isOpens && (
                        <ul
                            className="dropdown-menu"
                            ref={dropdownRefs[0]}
                            onMouseEnter={() => setIsOpens(true)}
                            onMouseLeave={() => setIsOpens(false)}
                        >
                            <li>
                                <a className="dropdown-item" href="#">
                                    옵션 1
                                </a>
                            </li>
                            <li>
                                <a className="dropdown-item" href="#">
                                    옵션 2
                                </a>
                            </li>
                            <li>
                                <a className="dropdown-item" href="#">
                                    옵션 3
                                </a>
                            </li>
                        </ul>
                    )}
                </div>
            </div>
            <div>
                <div className="dropdown">
                    <button
                        className="list"
                        onMouseEnter={() => setIsOpens(true)}
                        onMouseLeave={() => setIsOpens(false)}
                    >
                        상품
                    </button>
                    {isOpens && (
                        <ul
                            className="dropdown-menu"
                            ref={dropdownRefs[1]}
                            onMouseEnter={() => setIsOpens(true)}
                            onMouseLeave={() => setIsOpens(false)}
                        >
                            <li>
                                <a className="dropdown-item" href="#">
                                    옵션 1
                                </a>
                            </li>
                            <li>
                                <a className="dropdown-item" href="#">
                                    옵션 2
                                </a>
                            </li>
                            <li>
                                <a className="dropdown-item" href="#">
                                    옵션 3
                                </a>
                            </li>
                        </ul>
                    )}
                </div>
            </div>
            <div>
                <div className="dropdown">
                    <button
                        className="list"
                        onMouseEnter={() => setIsOpens(true)}
                        onMouseLeave={() => setIsOpens(false)}
                    >
                        리뷰 관리
                    </button>
                    {isOpens && (
                        <ul
                            className="dropdown-menu"
                            ref={dropdownRefs[2]}
                            onMouseEnter={() => setIsOpens(true)}
                            onMouseLeave={() => setIsOpens(false)}
                        >
                            <li>
                                <a className="dropdown-item" href="#">
                                    옵션 1
                                </a>
                            </li>
                            <li>
                                <a className="dropdown-item" href="#">
                                    옵션 2
                                </a>
                            </li>
                            <li>
                                <a className="dropdown-item" href="#">
                                    옵션 3
                                </a>
                            </li>
                        </ul>
                    )}
                </div>
            </div>
            <div>
                <div className="dropdown">
                    <button
                        className="list"
                        onMouseEnter={() => setIsOpens(true)}
                        onMouseLeave={() => setIsOpens(false)}
                    >
                        인재 추천
                    </button>
                    {isOpens && (
                        <ul
                            className="dropdown-menu"
                            ref={dropdownRefs[3]}
                            onMouseEnter={() => setIsOpens(true)}
                            onMouseLeave={() => setIsOpens(false)}
                        >
                            <li>
                                <a className="dropdown-item" href="#">
                                    옵션 1
                                </a>
                            </li>
                            <li>
                                <a className="dropdown-item" href="#">
                                    옵션 2
                                </a>
                            </li>
                            <li>
                                <a className="dropdown-item" href="#">
                                    옵션 3
                                </a>
                            </li>
                        </ul>
                    )}
                </div>
            </div>
        </div>
    )
}

export default Category;

