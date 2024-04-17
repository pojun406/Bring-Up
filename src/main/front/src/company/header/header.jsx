import React from "react";
import { RxHamburgerMenu, RxEnvelopeClosed  } from "react-icons/rx";
import "./header.css";
import '@fontsource/zen-tokyo-zoo';



const Header = () =>{
    return(
        <div>
            <div className="header">
                <div className="logo">
                    <button className="bringup">
                        <span className="bringup-span1" style={{fontFamily: 'Zen Tokyo Zoo, cursive'}}>Bring</span>
                        <span className="bringup-span2" style={{fontFamily: 'Zen Tokyo Zoo, cursive'}}>UP</span>
                    </button>
                </div>
                <div className="container">
                    <div className="category">
                        <button className="div">공고</button>
                        <button className="div2">상품</button>
                        <button className="div3">인재 추천</button>
                        <button className="div4">리뷰 관리</button>
                    </div>
                    <div class="dropdown_menu">
                        
                    </div>
                </div>
                <div className="interface">
                    <button className="message">
                        <RxEnvelopeClosed size={48}/>
                    </button>
                    <button className="menu">
                        <RxHamburgerMenu  size={48}/>
                    </button>
                </div>
            </div>
            <hr className="line" />
        </div>
)
}

export default Header;