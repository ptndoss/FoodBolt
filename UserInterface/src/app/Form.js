import React, { Component } from "react";
import "./Form.css";
import { ACCESS_TOKEN } from "../resources";
import { reserve } from "../common/APIUtils";
import Alert from "react-s-alert";

class Form extends Component {
  constructor(props) {
    super(props);
    this.state = {
      guests: "",
      date: "",
      time: ""
    };
    this.handleInputChange = this.handleInputChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleInputChange(event) {
    const target = event.target;
    const inputName = target.name;
    const inputValue = target.value;

    this.setState({
      [inputName]: inputValue
    });
  }

  handleSubmit(event) {
    event.preventDefault();

    const reserveRequest = Object.assign({}, this.state);

    reserve(reserveRequest)
      .then(response => {
        localStorage.setItem(ACCESS_TOKEN, response.accessToken);
        Alert.success("You're successfully logged in!");
        this.props.history.push("/preorder");
      })
      .catch(error => {
        Alert.error(
          (error && error.message) || "Something went wrong. Please try again!"
        );
      });
  }
  render() {
    return (
      <center>
        <div id="reserve">
          <form onSubmit={this.handleSubmit}>
            <h1>RESERVATION</h1>
            <input
              type="text"
              id="form1"
              name="guests"
              value={this.state.guests}
              onChange={this.handleInputChange}
              placeholder="Number of Guests"
              autoComplete="off"
              required
            />
            <br />
            <input
              type="text"
              id="form2"
              name="date"
              value={this.state.date}
              onChange={this.handleInputChange}
              placeholder="Date"
              autoComplete="off"
              required
            />
            <br />
            <input
              type="text"
              id="form3"
              name="time"
              value={this.state.time}
              onChange={this.handleInputChange}
              placeholder="Time"
              autoComplete="off"
              required
            />
            <div id="book">
              <button>Book Table</button>
            </div>
          </form>
        </div>
      </center>
    );
  }
}

export default Form;
