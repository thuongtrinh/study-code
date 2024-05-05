import React from "react";

const MessageContext = React.createContext();

class ComponentChau extends React.Component {
  render() {
    return <h3>Ông bảo là : "{this.context}"</h3>;
  }
}
ComponentChau.contextType = MessageContext;

const ContextReact = () => {
  return (
    <MessageContext.Provider value="Vào react.net học lập trình">
      <ComponentChau />
    </MessageContext.Provider>
  );
};
export default ContextReact;
