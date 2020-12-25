<template>
  <div>
  <h3>Lista</h3>

<table>
<tr v-for="item in items" v-bind:key="item.id">
  <td><router-link :to="{ name : 'Details', params : { id : item.id }}">Details</router-link></td>
  <td>{{ item.name }}</td>
  <td>{{ item.description }}</td>
</tr>
</table>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: 'ItemList',
  data() {
    return {
      items :  []
    };
  },
  mounted() {
            axios({ method: "GET", "url": "http://myWebService/article/all",  withCredentials: true}).then(result => {
                this.items = result.data;
            }, error => {
                console.error(error);
            });
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
