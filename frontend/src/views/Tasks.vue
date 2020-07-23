<template>
  <div class="tasks">
    <header class="header">
    <input class="new-task"
            placeholder="what needs to be done..."
            v-model="placeHolder"
            @keyup.enter="addNew">
    </header>
    <section class="main" v-show="todos.length" v-cloak>
      <ul class="todo-list">
        <li v-for="todo in todos"
            class="todo"
            :key="todo.id">
          <div class="view">
            <input class="toggle" type="checkbox" v-model="todo.completed">
            <label>{{todo.title}}</label>
            <button class="destroy" @click="remove(todo)">Remove</button>
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
      this.placeHolder = '';
    },
    remove(todo) {
      api.removeForId(todo.id)
        .then(() => {
          this.todos.splice(this.todos.indexOf(todo), 1);
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
  body {
    display: flex;
    flex-direction: column;
    align-items: center;
  }

  .tasks{
  }

  .new-task {
    display: flex;
    flex-direction: column;
    align-items: center;
    background: rgb(255,255,255, 0.3);
    border: none;
    border-bottom: black 2px solid;
    width: 50vw;
    height: 40px;
    font-size: 30px;
}
  .todo-list {
    list-style: none;
    background: rgb(255,255,255, 0.3);
    display: flex;
    flex-direction: column;
    font-size: 20px;
    padding-left: 0;
  }

  .todo {
    margin-top: 10px;
    border-bottom: 1px solid lightgray;
    width: 100%;
    display: flex;
  }

  .destroy {
    background: none;
    border: none;
    opacity: 0.2;
  }

  .toggle {
    opacity: 0.2;
  }

</style>
