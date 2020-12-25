import Vue from 'vue'
import App from './App.vue'
import VueRouter from 'vue-router'
import ItemDetails from './components/ItemDetails.vue'
import ItemList from './components/ItemList.vue'
import Login from './components/Login.vue'
import axios from "axios";

const router = new VueRouter({
  routes: [
    { path: '/details/:id', name: "Details", component: ItemDetails , props: true},
    { path: '/list', component: ItemList },
    { path: '/', component: ItemList },
    { path: '/login', component: Login }
  ]
})

Vue.use(VueRouter)

// Add a response interceptor
// It doesn't work properly because of CORS preflight
axios.interceptors.response.use(function (response) {
  // Do something with response data
  console.log("intercepted ok");
  console.log(response);
  return response;
}, 
function (error) {
  console.log("intercepted error" + JSON.stringify(error));
  console.log(error);
  if (error.response === 401) {
    this.$router.push("/login");
  } else {
     return Promise.reject(error);
  }
});

Vue.config.productionTip = false

new Vue({
  render: h => h(App),
  router : router
}).$mount('#app')