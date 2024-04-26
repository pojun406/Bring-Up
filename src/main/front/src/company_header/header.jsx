import React from "react";
import { RxHamburgerMenu, RxEnvelopeClosed  } from "react-icons/rx";
import "./header.css";
import '@fontsource/zen-tokyo-zoo';
import Category from "./category";
import SideMenu from "./sidemenu";
import MessageTab from "./message-tab";
function Header() {
    return(
        <div>
            <div className="header">
                <div className="logo">
                    <a className="bringup" href="/company">
                        <span className="bringup-span1" style={{fontFamily: 'Zen Tokyo Zoo, cursive'}}>Bring</span>
                        <span className="bringup-span2" style={{fontFamily: 'Zen Tokyo Zoo, cursive'}}>UP</span>
                    </a>
                </div>
                <Category/>
                <div className="interface">
                    <MessageTab/>
                    <SideMenu/>
                </div>
            </div>
            <hr className="line" />
        </div>
    );
}

export default Header;