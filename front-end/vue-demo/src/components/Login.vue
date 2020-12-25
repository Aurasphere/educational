<template>
<div>
<h3>Login</h3>

<form v-on:submit="doLogin()">
	
	Username: <input type="text" v-model="username">
	Password: <input type="text" v-model="password">
	<button type="submit"> Login</button>
	<p v-if="showErrorMessage">Wrong username or password</p>
</form>
</div>
</template>

<script>
import axios from "axios";

export default {
  name: 'Login',
  data() {
    return  {
    username: "",
    password: "",
    showErrorMessage: false,
     doLogin() {
       axios({ method: "POST", "url": "http://myWebService/login" , 
       withCredentials: true,
       data : { 
         username : this.username,
         password : this.password
       }}).then(result => {
                if (result.status === 200) {
                  this.$router.push("/list");
                }
            }, error => {
                console.error(error);
            });
     }
    };
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
