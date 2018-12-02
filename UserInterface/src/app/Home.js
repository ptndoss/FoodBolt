import React, { Component } from "react";
import "./Home.css";
import rest1 from "../resources/rest1.jpg";
import rest2 from "../resources/rest2.jpg";
import rest3 from "../resources/rest3.jpg";
import rest4 from "../resources/rest4.jpg";
import rest5 from "../resources/rest5.jpg";
import rest6 from "../resources/rest6.jpg";
import rest7 from "../resources/rest7.jpg";
import rest8 from "../resources/rest8.jpg";
import { Link, NavLink } from "react-router-dom";

class Home extends Component {
  render() {
    return (
      <div id="cards">
        <div className="card" data-component="card1">
          <NavLink to="/form">
            <img src={rest1} alt="Hotel" style={{ width: "100%" }} />
          </NavLink>
          <div className="container1">
            <h4>
              <b>Merit</b>
            </h4>
            <p>International veggie &amp; vegan fare</p>
          </div>
        </div>
        <div className="card" data-component="card2">
          <NavLink to="/form">
            <img src={rest2} alt="Hotel" style={{ width: "100%" }} />
          </NavLink>
          <div className="container1">
            <h4>
              <b>Kabul Afghan Cuisine</b>
            </h4>
            <p>Casual spot for Afghan eats</p>
          </div>
        </div>
        <div className="card" data-component="card3">
          <NavLink to="/form">
            <img src={rest3} alt="Hotel" style={{ width: "100%" }} />
          </NavLink>
          <div className="container1">
            <h4>
              <b>Dish Dash</b>
            </h4>
            <p>Homey Middle Eastern food</p>
          </div>
        </div>
        <div className="card" data-component="card4">
          <NavLink to="/form">
            <img src={rest4} alt="Hotel" style={{ width: "100%" }} />
          </NavLink>
          <div className="container1">
            <h4>
              <b>Athena Grill &amp; Catering</b>
            </h4>
            <p>Homey joint for Greek standards</p>
          </div>
        </div>
        <div className="card" data-component="card5">
          <NavLink to="/form">
            <img src={rest5} alt="Hotel" style={{ width: "100%" }} />
          </NavLink>
          <div className="container1">
            <h4>
              <b>Birk's</b>
            </h4>
            <p>Steaks &amp; seafood in a bistro</p>
          </div>
        </div>
        <div className="card" data-component="card6">
          <NavLink to="/form">
            <img src={rest6} alt="Hotel" style={{ width: "100%" }} />
          </NavLink>
          <div className="container1">
            <h4>
              <b>Mio Vicino</b>
            </h4>
            <p>Californian-inspired Italian cuisine</p>
          </div>
        </div>
        <div className="card" data-component="card7">
          <NavLink to="/form">
            <img src={rest7} alt="Hotel" style={{ width: "100%" }} />
          </NavLink>
          <div className="container1">
            <h4>
              <b>San Jose Original Joe's</b>
            </h4>
            <p>Longtimer steaks &amp; Italian fare</p>
          </div>
        </div>
        <div className="card" data-component="card8">
          <NavLink to="/form">
            <img src={rest8} alt="Hotel" style={{ width: "100%" }} />
          </NavLink>
          <div className="container1">
            <h4>
              <b>Nemea Greek Taverna</b>
            </h4>
            <p>Varied Greek eats in spacious digs</p>
          </div>
        </div>
      </div>
    );
  }
}

export default Home;
