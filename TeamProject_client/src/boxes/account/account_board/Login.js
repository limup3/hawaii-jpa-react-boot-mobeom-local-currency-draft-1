import React, { useState } from 'react';
import { Link, useHistory } from 'react-router-dom';
import { useDispatch } from 'react-redux';
import axios from 'axios';

const POST_LOGIN_REQUEST = 'POST_LOGIN_REQUEST';

export const loginRequestAction = data => ({type: POST_LOGIN_REQUEST, payload: data});

export const loginReducer = (state = {}, action) => {
  switch (action.type) {
    case 'POST_LOGIN_REQUEST': return action.payload;
    default: return state;
  }
}
const Login = () => {
  const [userId, setUserId] = useState("");
  const [password, setPassword] = useState("");
  const history = useHistory();
  const dispatch = useDispatch();

  const handleLoginButton = e => {
    e.preventDefault();
    axios.post(`http://localhost:8080/users/login`,
      {userId: userId, password: password},
      {
          'Content-type' : 'application/json',
          // 'Authorization' : 'JWT fefege...'
          'Access-Control-Allow-Origin': '*'
      })
      .then(response => {
          sessionStorage.setItem("sessionUser",JSON.stringify(response.data))
          dispatch(loginRequestAction(response.data))
          history.push("/mypage");
      })
      .catch(error => { throw(error) });
  }

  return (
    <div className="container account_login">
      <form >
        <div className="form-group">
          <input 
            type="text" 
            className="form-control" 
            id="userId" 
            placeholder="아이디"
            value={userId}
            onChange={e => setUserId("bnRFZA97")}
          />
          <input 
            type="password" 
            className="form-control" 
            id="password" 
            placeholder="비밀번호" 
            value={password}
            onChange={e => setPassword("i*fNTYQ%tYvH93")}
          />
          <div>
            <label><input type="checkbox" /> 자동로그인</label>
            <span id="login-link"><Link to="/">아이디/비밀번호 찾기</Link></span>
          </div>
        </div>
      </form>
      <button 
        type="submit" 
        className="btn btn-success" 
        id="login-button"
        onClick={handleLoginButton}
      >
        로그인
      </button>
      <div>
        <p>아직 회원이 아니신가요?</p>
        <Link to="/account/term-n-condition" className="btn btn-primary" id="login-button">회원가입</Link>
      </div>
    </div>
  );
};

export default Login;