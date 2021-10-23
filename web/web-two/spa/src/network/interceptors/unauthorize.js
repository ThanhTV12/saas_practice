import API from '../../network/API';

const UnauthorizeStatusCode = 401;

export function onFullfilled(response) {
    return Promise.resolve(response);
}

export function onRejected(error) {
    if (error) {
        const response = error.response;
        if (response.status == UnauthorizeStatusCode) {
            return window.location.href = API.url.auth;
        }
        return Promise.reject(error);
    }
}