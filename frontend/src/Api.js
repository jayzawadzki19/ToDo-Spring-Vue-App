import axios from 'axios'

const SERVER_URL = 'http://localhost:9000/tasks/';

const instance = axios.create({
  baseURL: SERVER_URL,
  timeout: 1000
});

export default {

  createNew: (text, completed) => instance.post('add', {title: text, completed: completed}),

  getAll: () => instance.get('all', {
    transformResponse: [function (data) {
      return data? JSON.parse(data)._embedded.todos : data;
    }]
  }),

  updateForId: (id, text, completed) => instance.put('update/'+id, {title: text, completed: completed}),

  removeForId: (id) => instance.delete('delete/'+id)
}
