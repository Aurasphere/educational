<template>
<div>
<h3>Product details: {{ item.name }}</h3>

<div>
  <div>ID: {{ item.id }}</div>
  <div>Nome: {{ item.name }}</div>
  <div>Descrizione: {{ item.description }}</div>
</div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: 'ItemDetails',
  data() {
    return {
      item : {}
    };
  },
  props: {
    id: String
  },
   mounted() {
            axios({ method: "GET", "url": "http://myWebService/article/" + this.id ,  withCredentials: true}).then(result => {
                this.item = result.data;
            }, error => {
                console.error(error);
            });
        },
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
