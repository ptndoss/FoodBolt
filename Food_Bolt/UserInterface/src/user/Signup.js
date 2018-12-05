import React, { Component } from 'react';
import './Signup.css';
import { Link, Redirect } from 'react-router-dom'
import { GOOGLE_AUTH_URL, FACEBOOK_AUTH_URL } from '../resources';
import { signup } from '../common/APIUtils';
import fbLogo from '../resources/fb-logo.png';
import googleLogo from '../resources/google-logo.png';
import Alert from 'react-s-alert';
import { FormErrors } from './FormErrors';

class Signup extends Component {
    render() {
        if(this.props.authenticated) {
            return <Redirect
                to={{
                pathname: "/",
                state: { from: this.props.location }
            }}/>;            
        }

        return (
            <div className="signup-container">
                <div className="signup-content">
                    <h1 className="signup-title">Food Bolt SignUp</h1>
                    <SignupForm {...this.props} />
                    <div className="or-separator">
                        <span className="or-text">OR</span>
                    </div>
                    <SocialSignup />
                    <span className="login-link">Already on Food Bolt? <Link to="/login">Login!</Link></span>
                </div>
            </div>
        );
    }
}

class SignupForm extends Component {
    constructor(props) {
        super(props);
        this.state = {
            signupRole: 'Customer',
            firstName: '',
            lastName: '',
            email: '',
            password: '',
            formErrors: { email: '', password: '' },
            city: '',
            state: '',
            cuisine: '',
            guests: '',
            totalTables: '',
            totalOccupancy: ''
            /*
            emailValid: false,
            passwordValid: false,
            formValid: false
            */

        }
        this.handleInputChange = this.handleInputChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    validateField(fieldName, value) {
        let fieldValidationErrors = this.state.formErrors;
        let emailValid = this.state.emailValid;
        let passwordValid = this.state.passwordValid;

        switch (fieldName) {
            case 'email':
                emailValid = value.match(/^([\w.%+-]+)@([\w-]+\.)+([\w]{2,})$/i);
                fieldValidationErrors.email = emailValid ? '' : 'Please enter valid email (Eg: foodbolt@gmail.com)';
                break;
            case 'password':
                passwordValid = value.length >= 6;
                fieldValidationErrors.password = passwordValid ? '' : 'Password is too short';
                break;
            default:
                break;
        }
        this.setState({
            formErrors: fieldValidationErrors,
            emailValid: emailValid,
            passwordValid: passwordValid
        }, this.validateForm);
    }

    validateForm() {
        this.setState({ formValid: this.state.emailValid && this.state.passwordValid });
    }

    errorClass(error) {
        return (error.length === 0 ? '' : 'has-error');
    }

    handleInputChange(event) {
        const target = event.target;
        const inputName = target.name;        
        const inputValue = target.value;

        this.setState({
            [inputName]: inputValue
        }); 

        /*
        this.setState({[inputName]: inputValue },
            () => { this.validateField(inputName, inputValue) });
        */
      
    }

    handleSubmit(event) {
        event.preventDefault();   

        const signUpRequest = Object.assign({}, this.state);

        signup(signUpRequest)
        .then(response => {
            Alert.success("You're successfully registered. Please login to continue!");
            this.props.history.push("/login");
        }).catch(error => {
            Alert.error((error && error.message) || 'Oops! Something went wrong. Please try again!');            
        });
    }

    render() {
        return (

            <form onSubmit={this.handleSubmit}>

                <div className="form-item">
                    <select name="signupRole"
                        className="form-control"
                        id="signupRole"
                        value={this.state.signupRole}
                        onChange={this.handleInputChange} required>
                        <option value="Customer">Customer</option>
                        <option value="Restaurant">Restaurant</option>
                    </select>
                </div>

                {
                    this.state.signupRole === 'Customer' ?
                        <div>
                            <div className="form-item">
                                <input type="text" name="firstName"
                                    className="firstname-control" placeholder="First Name" autocomplete="off"
                                    pattern="^[0-9a-zA-Z]{1,32}$"
                                    title="First Name can have lowercase and uppercase letters. Range 1 - 32 chars."
                                    value={this.state.firstName} onChange={this.handleInputChange} required />
                                <input type="text" name="lastName"
                                    className="lastname-control" placeholder="Last Name" autocomplete="off"
                                    pattern="^[0-9a-zA-Z]{1,32}$"
                                    title="First Name can have lowercase and uppercase letters. Range 1 - 32 chars."
                                    value={this.state.lastName} onChange={this.handleInputChange} required />
                            </div>

                            {/*<span className="error-message">{this.state.formErrors.email}</span> */}
                            <div className={"form-item"}>
                                <input type="email" name="email" autocomplete="off"
                                    pattern="[a-zA-Z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$"
                                    title="Email address eg: user@gmail.com"
                                    className="form-control" placeholder="Email"
                                    value={this.state.email} onChange={this.handleInputChange} required/>
                            </div>

                            {/*<span className="error-message">{this.state.formErrors.password}</span> */}
                            <div className={"form-item"}>
                                <input type="password" name="password" autocomplete="off"
                                    pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{6,16}$"
                                    title="Passwd should contain atleast 1 uppercase, 1 lowercase, 1 number. Range 6 - 16 chars."
                                    className="form-control" placeholder="Password"
                                    value={this.state.password} onChange={this.handleInputChange} required />
                            </div>
                            
                            <div className="form-item">
                                <input type="text" name="city" autocomplete="off"
                                    pattern="^[0-9a-zA-Z ]{6,32}$"
                                    title="City Name can have lowercase, uppercase letters or spaces. Range 6 - 32 chars."
                                    className="leftform-control" placeholder="City"
                                    value={this.state.city} onChange={this.handleInputChange} required />
                                <select name="state"
                                    className="rightform-control"
                                    id="state"
                                    value={this.state.state}
                                    onChange={this.handleInputChange} required>
                                    <option value="" selected="selected">State</option>
                                    <option value="AL">AL</option>
                                    <option value="AK">AK</option>
                                    <option value="AR">AR</option>
                                    <option value="AZ">AZ</option>
                                    <option value="CA">CA</option>
                                    <option value="CO">CO</option>
                                    <option value="CT">CT</option>
                                    <option value="DC">DC</option>
                                    <option value="DE">DE</option>
                                    <option value="FL">FL</option>
                                    <option value="GA">GA</option>
                                    <option value="HI">HI</option>
                                    <option value="IA">IA</option>
                                    <option value="ID">ID</option>
                                    <option value="IL">IL</option>
                                    <option value="IN">IN</option>
                                    <option value="KS">KS</option>
                                    <option value="KY">KY</option>
                                    <option value="LA">LA</option>
                                    <option value="MA">MA</option>
                                    <option value="MD">MD</option>
                                    <option value="ME">ME</option>
                                    <option value="MI">MI</option>
                                    <option value="MN">MN</option>
                                    <option value="MO">MO</option>
                                    <option value="MS">MS</option>
                                    <option value="MT">MT</option>
                                    <option value="NC">NC</option>
                                    <option value="NE">NE</option>
                                    <option value="NH">NH</option>
                                    <option value="NJ">NJ</option>
                                    <option value="NM">NM</option>
                                    <option value="NV">NV</option>
                                    <option value="NY">NY</option>
                                    <option value="ND">ND</option>
                                    <option value="OH">OH</option>
                                    <option value="OK">OK</option>
                                    <option value="OR">OR</option>
                                    <option value="PA">PA</option>
                                    <option value="RI">RI</option>
                                    <option value="SC">SC</option>
                                    <option value="SD">SD</option>
                                    <option value="TN">TN</option>
                                    <option value="TX">TX</option>
                                    <option value="UT">UT</option>
                                    <option value="VT">VT</option>
                                    <option value="VA">VA</option>
                                    <option value="WA">WA</option>
                                    <option value="WI">WI</option>
                                    <option value="WV">WV</option>
                                    <option value="WY">WY</option>
                                    <option value="AS">AS</option>
                                    <option value="GU">GU</option>
                                    <option value="MP">MP</option>
                                    <option value="PR">PR</option>
                                    <option value="UM">UM</option>
                                    <option value="VI">VI</option>
                                    <option value="AA">AA</option>
                                    <option value="AP">AP</option>
                                    <option value="AE">AE</option>
                                </select>
                            </div>
                            <div className="form-item">
                                <select name="cuisine"
                                    className="leftform-control"
                                    id="cuisine"
                                    value={this.state.cuisine}
                                    onChange={this.handleInputChange} required>
                                    <option value="" selected="selected">Preferred Cuisine</option>
                                    <option value="American">American</option>
                                    <option value="Chinese">Chinese</option>
                                    <option value="Continental">Continental</option>
                                    <option value="Indian">Indian</option>
                                    <option value="Mexican">Mexican</option>
                                </select>
                                <input type="number" name="guests" min="1" max="25"
                                    className="rightform-control" placeholder="Guests"
                                    value={this.state.guests} onChange={this.handleInputChange} required />
                            </div>
                        </div>
                        : <div>
                            <div className="form-item">
                                <input type="text" name="name" autocomplete="off"
                                    pattern="^[0-9a-zA-Z ]{6,32}$"
                                    title="Restaurant Name can have lowercase, uppercase letters and space. Range 6 - 32 chars."
                                    className="form-control" placeholder="Restaurant Name"
                                    value={this.state.name} onChange={this.handleInputChange} required />
                            </div>
                            <div className="form-item">
                                <input type="email" name="email" autocomplete="off"
                                    pattern="[a-zA-Z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$"
                                    title="Email address eg: restaurantuser@gmail.com"
                                    className="form-control" placeholder="Email"
                                    value={this.state.email} onChange={this.handleInputChange} required />
                            </div>
                            <div className="form-item">
                                <input type="password" name="password" autocomplete="off"
                                    pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{6,16}$"
                                    title="Passwd should contain atleast 1 uppercase, 1 lowercase, 1 number. Range 6 - 16 chars."
                                    className="form-control" placeholder="Password"
                                    value={this.state.password} onChange={this.handleInputChange} required />
                            </div>
                            <div className="form-item">
                                <input type="text" name="city" autocomplete="off"
                                    pattern="^[0-9a-zA-Z ]{6,32}$"
                                    title="City Name can have lowercase, uppercase letters or spaces. Range 6 - 32 chars."
                                    className="leftform-control" placeholder="City"
                                    value={this.state.city} onChange={this.handleInputChange} required />
                                <select name="state"
                                    className="rightform-control"
                                    id="state"
                                    value={this.state.state}
                                    onChange={this.handleInputChange} required>
                                    <option value="" selected="selected">State</option>
                                    <option value="AL">AL</option>
                                    <option value="AK">AK</option>
                                    <option value="AR">AR</option>
                                    <option value="AZ">AZ</option>
                                    <option value="CA">CA</option>
                                    <option value="CO">CO</option>
                                    <option value="CT">CT</option>
                                    <option value="DC">DC</option>
                                    <option value="DE">DE</option>
                                    <option value="FL">FL</option>
                                    <option value="GA">GA</option>
                                    <option value="HI">HI</option>
                                    <option value="IA">IA</option>
                                    <option value="ID">ID</option>
                                    <option value="IL">IL</option>
                                    <option value="IN">IN</option>
                                    <option value="KS">KS</option>
                                    <option value="KY">KY</option>
                                    <option value="LA">LA</option>
                                    <option value="MA">MA</option>
                                    <option value="MD">MD</option>
                                    <option value="ME">ME</option>
                                    <option value="MI">MI</option>
                                    <option value="MN">MN</option>
                                    <option value="MO">MO</option>
                                    <option value="MS">MS</option>
                                    <option value="MT">MT</option>
                                    <option value="NC">NC</option>
                                    <option value="NE">NE</option>
                                    <option value="NH">NH</option>
                                    <option value="NJ">NJ</option>
                                    <option value="NM">NM</option>
                                    <option value="NV">NV</option>
                                    <option value="NY">NY</option>
                                    <option value="ND">ND</option>
                                    <option value="OH">OH</option>
                                    <option value="OK">OK</option>
                                    <option value="OR">OR</option>
                                    <option value="PA">PA</option>
                                    <option value="RI">RI</option>
                                    <option value="SC">SC</option>
                                    <option value="SD">SD</option>
                                    <option value="TN">TN</option>
                                    <option value="TX">TX</option>
                                    <option value="UT">UT</option>
                                    <option value="VT">VT</option>
                                    <option value="VA">VA</option>
                                    <option value="WA">WA</option>
                                    <option value="WI">WI</option>
                                    <option value="WV">WV</option>
                                    <option value="WY">WY</option>
                                    <option value="AS">AS</option>
                                    <option value="GU">GU</option>
                                    <option value="MP">MP</option>
                                    <option value="PR">PR</option>
                                    <option value="UM">UM</option>
                                    <option value="VI">VI</option>
                                    <option value="AA">AA</option>
                                    <option value="AP">AP</option>
                                    <option value="AE">AE</option>
                                </select>
                            </div>
                            <div className="form-item">
                                <select name="cuisine"
                                    className="form-control"
                                    id="cuisine"
                                    value={this.state.cuisine}
                                    onChange={this.handleInputChange} required>
                                    <option value="" selected="selected">Restaurant Cuisine</option>
                                    <option value="American">American</option>
                                    <option value="Chinese">Chinese</option>
                                    <option value="Continental">Continental</option>
                                    <option value="Indian">Indian</option>
                                    <option value="Mexican">Mexican</option>
                                </select>
                            </div>
                            <div>
                                <input type="number" name="totalTables" min="1" max="50"
                                    className="totaltables-control" placeholder="Total Tables"
                                    value={this.state.totalTables} onChange={this.handleInputChange} required />
                                <input type="number" name="totalOccupancy" min="1" max="50"
                                    className="totaloccupancy-control" placeholder="Total Occupancy"
                                    value={this.state.totalOccupancy} onChange={this.handleInputChange} required />
                            </div>
                        </div>

                }

                <div className="form-item">
                    <button type="submit" className="btn btn-block btn-primary" >Sign Up</button>
                </div>
            </form>
        );
    }
}


class SocialSignup extends Component {
    render() {
        return (
            <div className="social-signup">
                <a className="btn btn-block social-btn facebook" href={FACEBOOK_AUTH_URL}>
                    <img src={fbLogo} alt="Facebook" /> Sign up with Facebook</a>
                <a className="btn btn-block social-btn google" href={GOOGLE_AUTH_URL}>
                    <img src={googleLogo} alt="Google" /> Sign up with Google</a>
            </div>
        );
    }
}

export default Signup