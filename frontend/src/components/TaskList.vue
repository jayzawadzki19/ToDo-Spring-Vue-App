<template>
  <div class="wrapper">
<ul>
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

<style>

</style>
