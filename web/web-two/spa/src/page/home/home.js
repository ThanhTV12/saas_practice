import React, {Component}      from 'react';
import API from '../../network/API.js'


class Home extends Component {
    constructor(props) {
        super(props);
        this.state = {
            name            : '',
            email           : '',
            isLogin         : false
        }
    }

    componentDidMount = async () => {
        let response = await API.getAuthInfo()
        console.log('response')
        console.log(response)
        if (response.status == 200 && response.data.name != null) {
            this.setState({
                'name': response.data.name,
                'email': response.data.email
            })
        } else if (response.data.name == null) {
            window.location.replace(API.url.auth)
        }

    };

    login = () => {
        console.log('request login')
        this.setState({
            'isLogin': true
        })
        window.location.replace(API.url.auth)
    }

    logout = () => {
        console.log('logout')
        this.setState({
            'isLogin': false
        })
        window.location.replace(API.url.logout)
    }

    // ===== Render UI =====
    render            = () => {
        return (
            <div>
                <h5>Page 2</h5>
                <button onClick={this.login}>
                    Login
                </button>
                <button onClick={this.logout}>
                    Logout
                </button>
                <hr/>
                <h3>
                    Xin chao
                </h3>
                <h3>name: {this.state.name}</h3>
                <h3>email: {this.state.email}</h3>
            </div>

        )
    };
}

export default Home;