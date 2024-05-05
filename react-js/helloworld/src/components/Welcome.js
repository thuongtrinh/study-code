import { Component } from "react";
import State from "./State";
import PropsValidation from "./PropsValidation";
import StateCountDown from "./StateCountDown";
import ComponentLifeCycle from "./ComponentLifeCycle";
import EventShowHidden from "./EventShowHidden";
import EventMouseClick from "./EventMouseClick";
import FormSubmit from "./FormSubmit";
import RenderCondition from "./RenderCondition";
import ListComponent from "./ListKey";
import ComponentCha from "./LiftingStateUp";
import ConvertUsdVnd from "./ConvertUsdVnd";
import ReactRefs from "./ReactRefs";
import ForwardingRefsP from "./ForwardingRefs";
import ContextReact from "./ContextReact";
import ContextShowUpdateNumber from "./ContextShowUpdateNumber";
import { RenderProps } from "./RenderProps";
import HoverComponent from "./HoverComponent";
import HoverComponentHOC from "./HoverComponentHOC";

class Welcome extends Component {
    render() {
        return (
            <div>
                <h1>Welcome ! I am a {this.props.name}</h1>
                <FunctionalComponentWelcome type="functional component"/><hr />
                <State/><hr />
                <PropsValidation/><hr />
                <StateCountDown/><hr />
                <ComponentLifeCycle/><hr />
                <EventShowHidden/>
                <EventMouseClick/><hr />
                <FormSubmit/><hr />
                <RenderCondition/><hr />
                <ListComponent/><hr />
                <ComponentCha/><hr/>
                <ConvertUsdVnd/><hr/>
                <ReactRefs/><hr/>
                <ForwardingRefsP/><hr/>
                <ContextReact/><hr/>
                <ContextShowUpdateNumber/><hr/>
                <RenderProps/><hr/>
                <HoverComponent/><hr/>
                <HoverComponentHOC/>
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