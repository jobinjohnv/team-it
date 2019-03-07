<template>
  <div class="about">
    <h1>This is an about page</h1>
	<button class=”Search__button” @click="callRestService()">CALL Spring Boot REST backend service</button>
	<h3>{{ response }}</h3>
	<h3>Username : {{username}}</h3>
  </div>
</template>
<script>
	import axios from 'axios'

export default{
name : 'about',
data (){
  return {
    response: [],
	username : '',
    errors: []
  }
},
methods:{
callRestService (){
  axios.get(`api/v1/userinfo`)
    .then(response => {
      // JSON responses are automatically parsed.
      this.response = response.data,
		this.username = response.data.username
    })
    .catch(e => {
      this.errors.push(e)
    })
	}
}
}
</script>
