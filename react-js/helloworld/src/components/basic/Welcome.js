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
import EventAlertButton from "./EventAlertButton";
import EventToolbar from "./EventToolbar";
import UserProfileState from "./UserProfileState";
import StateUpdateNestedObject from "./StateUpdateNestedObject";
import StateRemoveArray from "./StateRemoveArray";
import StateSpreadCopy from "./StateSpreadCopy";
import StateShapeEditorWithArray from "./StateShapeEditorWithArray";
import StateCounterListWithChangeArray from "./StateCounterListWithChangeArray";
import StateInsertArray from "./StateInsertArray";
import StateCounter from "./StateCounter";

class Welcome extends Component {
    render() {
        return (
            <div>
                <h1>Hello React.js - HelloWorld</h1>
                <h2>Welcome ! I am a {this.props.name}</h2>
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
                <HoverComponentHOC/><hr/>
                <h2 style={{color:'red'}}>Kungfutech</h2>
                <EventAlertButton/><hr/>
                <EventToolbar/><hr/>
                <UserProfileState/><hr/>
                <StateSpreadCopy/><hr/>
                <StateUpdateNestedObject/><hr/>
                <StateRemoveArray/><hr/>
                <StateShapeEditorWithArray/><hr/>
                <StateCounterListWithChangeArray/><hr/>
                <StateInsertArray/><hr/>
                <StateCounter/><hr/>

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