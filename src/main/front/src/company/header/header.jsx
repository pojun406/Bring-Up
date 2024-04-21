import React from "react";
import { RxHamburgerMenu, RxEnvelopeClosed  } from "react-icons/rx";
import "./header.css";
import '@fontsource/zen-tokyo-zoo';
import Category from "./category";
import SideMenu from "./sidemenu";
function Header() {
    return(
        <div>
            <div className="header">
                <div className="logo">
                    <button className="bringup">
                        <span className="bringup-span1" style={{fontFamily: 'Zen Tokyo Zoo, cursive'}}>Bring</span>
                        <span className="bringup-span2" style={{fontFamily: 'Zen Tokyo Zoo, cursive'}}>UP</span>
                    </button>
                </div>
                <Category/>
                <div className="interface">
                    <button className="message">
                        <RxEnvelopeClosed size={48}/>
                    </button>
                    <SideMenu/>
                </div>
            </div>
            <hr className="line" />
        </div>
    );
}

export default Header;