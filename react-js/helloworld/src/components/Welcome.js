import { Component } from "react";
import State from "./State";
import PropsValidation from "./PropsValidation";

class Welcome extends Component {
    render() {
        return (
            <div>
                <h1>Welcome ! I am a {this.props.name}</h1>
                <FunctionalComponentWelcome type="functional component"/>
                <State/>
                <br/>
                <PropsValidation/>
            </div>
        );
    }
}

const FunctionalComponentWelcome = function(props) {
    return (
        <div>
            <h1>Welcome ! I am a {props.type}</h1>
        </div>
    )
}

export default Welcome;