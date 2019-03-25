<template>
<div>
  <b-row>
    <b-col cols="12" xl="6">
      <transition name="slide">
      <b-card :header="caption">
        <b-table :hover="hover" :striped="striped" :bordered="bordered" :small="small" :fixed="fixed" responsive="sm" :items="items" :fields="fields" :current-page="currentPage" :per-page="perPage" @row-clicked="rowClicked">
          <template slot="id" slot-scope="data">
            <strong>{{data.item.id}}</strong>
          </template>
          <template slot="name" slot-scope="data">
            <strong>{{data.item.name}}</strong>
          </template>
          <template slot="status" slot-scope="data">
            <b-badge :variant="getBadge(data.item.status)">{{data.item.status}}</b-badge>
          </template>
        </b-table>
        <nav>
          <b-pagination size="sm" :total-rows="getRowCount(items)" :per-page="perPage" v-model="currentPage" prev-text="Prev" next-text="Next" hide-goto-end-buttons/>
        </nav>
      </b-card>
      </transition>
    </b-col>
  </b-row>
    <b-row>
    <b-col cols="12" xl="6">
      <transition name="slide">
      <b-card :header="Roles">
        <b-table :hover="hover" :striped="striped" :bordered="bordered" :small="small" :fixed="fixed" responsive="sm" :items="roles" :fields="fields2" :current-page="currentPage" :per-page="perPage" @row-clicked="rowClicked">
          <template slot="id" slot-scope="data">
            <strong>{{data.item.id}}</strong>
          </template>
          <template slot="name" slot-scope="data">
            <strong>{{data.item.roleName}}</strong>
          </template>
         
        </b-table>
        <nav>
          <b-pagination size="sm" :total-rows="getRowCount(items)" :per-page="perPage" v-model="currentPage" prev-text="Prev" next-text="Next" hide-goto-end-buttons/>
        </nav>
      </b-card>
      </transition>
    </b-col>
  </b-row>
  </div>
</template>

<script>
import usersData from './UsersData'
import axios from 'axios';

export default {
  name: 'Users',
  props: {
    caption: {
      type: String,
      default: 'Users'
    },
    Roles: {
      type: String,
      default: 'Roles'
    },
    hover: {
      type: Boolean,
      default: true
    },
    striped: {
      type: Boolean,
      default: true
    },
    bordered: {
      type: Boolean,
      default: false
    },
    small: {
      type: Boolean,
      default: false
    },
    fixed: {
      type: Boolean,
      default: false
    }
  },
  data: () => {
    return {
      items: usersData.filter((user) => user.id < 42),
      roles:null,
      fields: [
        {key: 'id'},
        {key: 'name'},
        {key: 'registered'},
        {key: 'role'},
        {key: 'status'}
      ],
       fields2: [
        {key: 'id'},
        {key: 'name'}
      ],
      currentPage: 1,
      perPage: 5,
      totalRows: 0
    }
  },
  mounted(){
    axios
      .get('./api/v1/allroles')
      .then(response => {
                    console.log(JSON.stringify(response.data))
                    this.roles = response.data //Makes it an array
                    console.log(this.roles)
                })
      .catch(function(error){
        console.log(error);
      })
  },
  computed: {
  },
  methods: {
    getBadge (status) {
      return status === 'Active' ? 'success'
        : status === 'Inactive' ? 'secondary'
          : status === 'Pending' ? 'warning'
            : status === 'Banned' ? 'danger' : 'primary'
    },
    getRowCount (items) {
      return items.length
    },
    userLink (id) {
      return `users/${id.toString()}`
    },
    rowClicked (item) {
      const userLink = this.userLink(item.id)
      this.$router.push({path: userLink})
    }

  }
}
</script>

<style scoped>
.card-body >>> table > tbody > tr > td {
  cursor: pointer;
}
</style>
