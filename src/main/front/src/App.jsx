import './App.css';
import {Link} from "react-router-dom";
import React, {useEffect, useState} from 'react';
import axios from 'axios';

function App() {
    const [hello, setHello] = useState('')

    useEffect(() => {
        axios.get('/api/hello')
            .then(response => setHello(response.data))
            .catch(error => console.log(error))
    }, []);

    return (
        <div>
            백엔드에서 가져온 데이터입니다 : {hello}
            <div className="App">
                <Link to="/company">기업 메인</Link>

            </div>
        </div>
    );
}

export default App;
