import React from 'react';
import { withRouter } from 'react-router-dom'

class Login extends React.Component {
   constructor(props) {
    super(props);
    this.state = { username: '', password: '' };
	this.handleChangeUsername = this.handleChangeUsername.bind(this);
	this.handleChangePassword = this.handleChangePassword.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }
  
  handleChangeUsername(e) {
    this.setState({username : e.target.value});
  }
  
	handleChangePassword(e) {
	this.setState({password : e.target.value});
  }
  
	handleSubmit(e) {
		e.preventDefault();
		fetch('http://myWebService/login', {
		method: 'POST',
		headers: {
			'Accept': 'application/json',
			'Content-Type': 'application/json',
		},
		body: JSON.stringify({
			username: this.state.username,
			password: this.state.password
		})}).then(res => {
			if (res.status === 401) {
				this.setState({showError : true});
			} else {
				
			withRouter(({ history }) => {
				console.log("ok" + res.status);
			history.push('/list');
			}
				);
				this.props.history.push("/list");
			}
		});
	}
  
  render() {
    return (
	<div>
<h3>Login</h3>

<form onSubmit={this.handleSubmit}>
	
	Username: <input type="text" value={this.state.username}  onChange={this.handleChangeUsername}/>
  Password: <input type="text" value={this.state.password}  onChange={this.handleChangePassword}/>
	<button type="submit"> Login</button>
	{this.state.showError ? <p>Wrong username or password</p> : null }
</form>
</div>
    );
  }
}

export default Login;