var login = new Vue({
  el: '#app',
  data: {
    msg:'Login to  the app',
    error:'',
    username:'',
    password:''
  },
  methods:{
	  loginSubmit: function(){
		  this.msg = "Loging in";
		  axios.post('./api/v1/userlogin',{
			  username:this.username,
			  password:this.password
		  })
		  .then(function (response) {
			    console.log(response);
			    login.error = "";
			    window.location.href = './';
			  })
			  .catch(function (error) {
			    if(error.response.status == '403'){
			    	login.error = "Username or Password is incorrect";
			    	login.msg = "Re login"
			    	console.log(login.error);
			    };
			  });
	  }
  }
});