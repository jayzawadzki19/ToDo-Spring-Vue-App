import axios from 'axios';

const SERVER_URL = 'http://localhost:9000/tasks/';

const instance = axios.create({
  baseURL: SERVER_URL,
  timeout: 1000,
});

export default {
  /* eslint no-underscore-dangle: 0 */

  createNew: (title, completed) => instance.post('add', { title, completed }),

  getAll: () => instance.get('all', {
    transformResponse: [function (data) {
      return data ? JSON.parse(data) : data;
    }],
  }),

  updateForId: (id, title, completed) => instance.put(`update/${id}`, { title, completed }),

  removeForId: (id) => instance.delete(`delete/${id}`),
};
