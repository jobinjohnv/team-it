<template>
  <div class="app">
    <AppHeader fixed class="AppHeader">
      <SidebarToggler class="d-lg-none" display="md" mobile />
      <b-link class="navbar-brand" to="#">
        <img class="navbar-brand-full" src="img/brand/logo2.svg" width="89" height="25" alt="Team IT">
      </b-link>
      <SidebarToggler class="d-md-down-none" display="lg" />
      <b-navbar-nav class="d-md-down-none">
        <b-nav-item class="px-3" to="/dashboard">Dashboard</b-nav-item>
        <b-nav-item class="px-3" to="/users" exact>Users</b-nav-item>
        <b-nav-item class="px-3">Admin</b-nav-item>
      </b-navbar-nav>
      <b-navbar-nav class="ml-auto">
        <b-nav-item class="d-md-down-none">
          <i class="icon-bell"></i>
          <b-badge pill variant="danger">5</b-badge>
        </b-nav-item>
        <b-nav-item class="d-md-down-none">
          <i class="icon-list"></i>
        </b-nav-item>
        <b-nav-item class="d-md-down-none">
          <i class="icon-location-pin"></i>
        </b-nav-item>
        <DefaultHeaderDropdownAccnt/>
      </b-navbar-nav>
      <AsideToggler class="d-none d-lg-block" />
      <!--<AsideToggler class="d-lg-none" mobile />-->
    </AppHeader>
    <div class="app-body">
      <AppSidebar fixed>
        <SidebarHeader/>
        <SidebarForm/>
        <SidebarNav :navItems="nav"></SidebarNav>
        <SidebarFooter/>
       
      </AppSidebar>
      <main class="main">
        <Breadcrumb :list="list"/>
        <div class="container-fluid">
          
            <router-view/>
    
        </div>
      </main>
      <AppAside fixed>
        <!--aside-->
        <DefaultAside/>
      </AppAside>
    </div>
    <TheFooter>
      <!--footer-->
      <div class="ml-auto">
        <a href="https://google.com/">Team IT</a>
        <span class="ml-1">&copy; 2018 JeyBN</span>
      </div>
    </TheFooter>
  </div>
</template>

<script>
import nav from '@/_nav'
import { Header as AppHeader, SidebarToggler, Sidebar as AppSidebar, SidebarFooter, SidebarForm, SidebarHeader, SidebarMinimizer, SidebarNav, Aside as AppAside, AsideToggler, Footer as TheFooter, Breadcrumb } from '@coreui/vue'
import DefaultAside from './DefaultAside'
import DefaultHeaderDropdownAccnt from './DefaultHeaderDropdownAccnt'

export default {
  name: 'DefaultContainer',
  components: {
    AsideToggler,
    AppHeader,
    AppSidebar,
    AppAside,
    TheFooter,
    Breadcrumb,
    DefaultAside,
    DefaultHeaderDropdownAccnt,
    SidebarForm,
    SidebarFooter,
    SidebarToggler,
    SidebarHeader,
    SidebarNav,
    SidebarMinimizer
  },
  data () {
    return {
      nav: nav.items
    }
  },
  computed: {
    name () {
      return this.$route.name
    },
    list () {
      return this.$route.matched.filter((route) => route.name || route.meta.label )
    }
  }
}
</script>
<style>
@import url('https://fonts.googleapis.com/css?family=Montserrat');

.body{
  background-color: #ffffff
}
.app {
  font-family: 'Montserrat', sans-serif;
  font-style: bold;
  font-weight: 500;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: left;
  color: #000000;
  background-color: #ffffff
}
.app-body{
  background-color: #ffffff;
  margin-top: 40px;
}
.app-header{
  background-color: #ffffff87;
  color: #3505c5;
  border-bottom: 0px;
  box-shadow: inset 0px 20px 18px 19px #fffffff2;
}
.navbar-nav .nav-link {
    color: #170131;
}

.sidebar {
  color: #170131;
  background: #ffffff;
  
}

.sidebar .nav-link{
  color: #170131;
}

.sidebar .nav-link.active{
  color: #014ff7;
  background: #0026fc2a;
  font-weight: 1000;
  border-radius: 0px 5px 5px 0px;
  border-style: solid;
  border-width: 0px 5px 0px 0px;
}

.sidebar .nav-dropdown.open .nav-link{
  color: #0e0e0e;
  border-radius: 0px 5px 5px 0px;
}

.sidebar .nav-link:hover {
    color: #014ff7;
  background: #0026fc2a;
  font-weight: 1000;
  border-radius: 0px 5px 5px 0px;
}

</style>
