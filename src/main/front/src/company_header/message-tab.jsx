import React, {useState, useEffect, useRef} from "react";
import "./message-tab.css";
import { RxEnvelopeClosed } from "react-icons/rx";

function MessageTab() {
    const [isOpen, setIsOpen] = useState(false);
    const messageTabRef = useRef(null);

    const handleClickOutside = (event) => {
        if (messageTabRef.current && !messageTabRef.current.contains(event.target)) {
            setIsOpen(false);
        }
    };

    useEffect(() => {
        const listener = document.addEventListener('mousedown', handleClickOutside);
        return () => {
            document.removeEventListener('mousedown', handleClickOutside);
        };
    }, [isOpen]);
    const handleToggle = () => {
        setIsOpen(!isOpen);
    };

    return (
        <>
            <RxEnvelopeClosed size={50} className="message" onClick={handleToggle}/>
            <div className={`message-tab ${isOpen ? 'open' : 'closed'}`} ref={messageTabRef}>
                
            </div>
        </>
    );
}

export default MessageTab;