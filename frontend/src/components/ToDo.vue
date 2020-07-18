<template>
  <div class="wrapper">

    <div class="addTask">

      <label for="taskInput">Add new task to do</label>
      <input type="text"
            id="taskInput"
            name="taskInput"
            v-model="task.title"/>
      <button id="taskButton"
              name="taskButton"
              @click="handleTask">
        Add task
      </button>
    </div>
  </div>
</template>

<script>
import axios from '../../node_modules/axios';

const URL = 'http://localhost:9000/tasks/add';

export default {
  name: 'ToDo',
  data() {
    return {
      newTask: '',
      task: {
        title: '',
        description: 'firstfromvue',
      },
    };
  },
  methods: {
    handleTask() {
      console.log(this.task);
      axios.post(`${URL}`, this.task)
        .then((response) => {
          console.log(response);
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
};
</script>

<style>

.wrapper{
  display: flex;
  flex-direction: column;
  align-items: center;
}

.addTask{
  display: flex;
  flex-direction: column;
  align-items: center;
}

.addTask label{
  font-size: 25px;
}

#taskInput{
width: 50vw;
height: 40px;
font-size: 30px;
border: 0;
border-bottom: 1px solid;
padding: 10px 0;
color: #444444;
background: none;
}

</style>
