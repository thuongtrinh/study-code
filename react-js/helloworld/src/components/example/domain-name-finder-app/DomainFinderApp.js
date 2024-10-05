import { Component } from "react";
import Header from "./Header/Header";
import ResultContainer from "./ResultContainer/ResultContainer";
import SearchBox from "./SearchBox/SearchBox";
import "./DomainFinderApp.css";

const name = require("@rstacruz/startup-name-generator");

// Class based component
class DomainFinderApp extends Component {
  state = {
    headerText: "Just Name It!!",
    headerExpanded: true,
    suggestedNames: [],
  };

  // Animation
  handleInputChange = (inputText) => {
    this.setState({
      headerExpanded: !(inputText.length > 0),
      suggestedNames: inputText.length > 0 ? name(inputText) : [],
    });
  };

  render() {
    return (
      <div className="DomainFinderBody">
        <Header
          headTitle={this.state.headerText}
          headerExpanded={this.state.headerExpanded}
        />
        <SearchBox onInputChange={this.handleInputChange} />
        <ResultContainer suggestedNames={this.state.suggestedNames} />
      </div>
    );
  }
}

export default DomainFinderApp;
