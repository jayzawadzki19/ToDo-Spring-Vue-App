import Vue from 'vue';
import VueRouter from 'vue-router';
import Home from '../views/Home.vue';
import Tasks from '../views/Tasks.vue';

Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home,
  },
  {
    path: '/tasks',
    name: 'Tasks',
    component: Tasks,
  },
];

const router = new VueRouter({
  routes,
});

export default router;
