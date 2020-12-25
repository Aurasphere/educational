<template>
  <div id="app">
     <router-view></router-view>
  </div>
</template>

<script>
import ItemDetails from './components/ItemDetails.vue'
import ItemList from './components/ItemList.vue'
import Login from './components/Login.vue'

export default {
  name: 'app',
  components: {
    ItemDetails,
    ItemList,
    Login
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
