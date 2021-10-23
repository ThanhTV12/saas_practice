import axios                       from 'axios';
import * as LogInterceptor         from './interceptors/log';
import * as UnauthorizeInterceptor from './interceptors/unauthorize.js';

const getInstance = () => {
    let instance = axios.create({
        baseURL : '',
        timeout : 30000,
    });
    instance.interceptors.response.use(
        UnauthorizeInterceptor.onFullfilled,
        UnauthorizeInterceptor.onRejected,
    );
    instance.interceptors.request.use(
        LogInterceptor.requestLog,
        LogInterceptor.requestError,
    );
    instance.interceptors.response.use(
        LogInterceptor.responseLog,
        LogInterceptor.responseError,
    );
    return instance;
};

const API       = {instance : getInstance(), allowChangeServer : true};
API.url         = {
    auth   : '/api/auth/sso',
    logout : '/api/auth/logout'
};
API.getAuthInfo = () => {
    return API.instance.get('/api/profile');
};



export default API;