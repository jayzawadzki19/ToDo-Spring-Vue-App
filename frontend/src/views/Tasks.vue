<template>
  <div class="tasks">
    <header class="header">
    <input class="new-task"
            v-model="placeHolder"
            @keyup.enter="addNew">
    </header>
    <section class="main" v-show="todos.length" v-cloak>
      <input class="toggle-all" type="checkbox">
      <ul class="todo-list">
        <li v-for="todo in todos"
            class="todo"
            :key="todo.id">
          <div class="view">
            <input class="toggle" type="checkbox" v-model="todo.completed">
            <label>{{todo.title}}</label>
            <button class="destroy"></button>
          </div>
        </li>
      </ul>
    </section>
  </div>
</template>

<script>
import api from '../Api';

export default {
  name: 'Tasks',

  methods: {
    newTask() {
      api.createNew('newTask', false);
    },
    all() {
      return api.getAll()
        .then((response) => {
          this.todos = response.data;
        })
        .catch((error) => {
          console.log(error);
        });
    },
    addNew() {
      const value = this.placeHolder;
      if (!value) {
        return;
      }

      api.createNew(value, false)
        .then((response) => {
          this.todos.push({
            id: response.data.id,
            title: value,
            completed: false,
          });
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
  data() {
    return {
      placeHolder: '',
      todos: [],
    };
  },
  mounted() {
    this.all();
  },
};
</script>

<style>

</style>
