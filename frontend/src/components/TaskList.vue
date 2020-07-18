<template>
  <div class="listWrapper">
<ul class="list">
    <li v-for="task in tasks" :key="task.id">
        <p>{{task.title}}</p>
    </li>
</ul>
  </div>
</template>

<script>
import axios from '../../node_modules/axios';

const URL = 'http://localhost:9000/tasks/all';

export default {

  data() {
    return {
      tasks: [],
    };
  },

  created() {
    this.hadnleTask();
  },

  mounted() {
    this.$root.$on('reload', () => {
      this.hadnleTask();
    });
  },

  methods: {
    hadnleTask() {
      axios.get(`${URL}`)
        .then((response) => {
          console.log(response);
          this.tasks = response.data;
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
};
</script>

<style scoped>
ul li{
display: flex;
flex-direction: column;
padding: 10px;
list-style-type: none;
background: rgb(255, 255, 255, 0.4);
align-items:center;
width: 40vw;
border-radius: 15%;
}

ul li p{
    display: flex;
    flex-direction: column;
    margin: 5px;
}
</style>
