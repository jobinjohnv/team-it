<template>
  <div class="animated fadeIn">
    <b-row>
      <b-col md="12">
          <br/>
          <b-table class="mb-0 table-outline" responsive="sm" hover :items="tableItems" :fields="tableFields" head-variant="light">
            <div slot="projectName" slot-scope="item">
              <div>{{item.item.projectName}}</div>
            </div>
            <div slot="createdAt" slot-scope="item">
              <div>{{formatDate(item.item.createdAt)}}</div>
            </div>
            <div slot="modifiedAt" slot-scope="item">
              <div>{{formatDate(item.item.modifiedAt)}}</div>
            </div>
             <div slot="firstName" slot-scope="item">
              <div>{{item.item.user.firstName}}</div>
            </div>
          </b-table>
      </b-col>
    </b-row>
  </div>
</template>

<script>
import CardLine1ChartExample from './dashboard/CardLine1ChartExample'
import CardLine2ChartExample from './dashboard/CardLine2ChartExample'
import CardLine3ChartExample from './dashboard/CardLine3ChartExample'
import CardBarChartExample from './dashboard/CardBarChartExample'
import MainChartExample from './dashboard/MainChartExample'
import SocialBoxChartExample from './dashboard/SocialBoxChartExample'
import CalloutChartExample from './dashboard/CalloutChartExample'
import { Callout } from '@coreui/vue'
import axios from 'axios';
import moment from 'moment';



export default {
  name: 'dashboard',
  components: {
    Callout,
    CardLine1ChartExample,
    CardLine2ChartExample,
    CardLine3ChartExample,
    CardBarChartExample,
    MainChartExample,
    SocialBoxChartExample,
    CalloutChartExample
  },
  data: function () {
    return {
      selected: 'Month',
      tableItems: [],
      tableFields: {
        projectName: {
          label: 'Project Name',
          class: 'text-center'
        },
        projectStatus: {
          label: 'Status',
          class: 'text-center'
        },
        createdAt: {
          label: 'Created On',
          class: 'text-center'
        },
        modifiedAt: {
          label: 'Modified On',
          class: 'text-center'
        },
        firstName: {
          label: 'Owner',
          class: 'text-center'
        }
      }
    }
  },
  mounted(){
    axios
      .get('./api/allprojects')
      .then(response => {
                    console.log(JSON.stringify(response.data))
                    this.tableItems = response.data //Makes it an array
                    console.log(this.tableItems)
                })
      .catch(function(error){
        console.log(error);
      })
  },
  methods: {
    'formatDate': function(value) {
  if (value) {
    return moment(String(value)).format('Do MMM YYYY h:mm')
  }
}
  }
}
</script>

<style>
  /* IE fix */
  #card-chart-01, #card-chart-02 {
    width: 100% !important;
  }
  .card {
    border: 1px solid #f1f1f1;
  }
  .card-header{
    border-bottom: 1px solid #ebeef1;
  }
  .card-footer {
    border-top: 0px solid #c8ced3; 
  }
  .tabe {
    border-bottom: 1px solid #ebeef1;
  }
  .table-outline {
    border: 1px solid #ececec;
}
.table .thead-light th {
    color: #ffffff;
    background-color: #025effbd;
    border-color: #025effbd;
}
.table th, .table td {
    padding: 0.75rem;
    vertical-align: top;
    border-top: 1px solid #ebeef1;
}
</style>
