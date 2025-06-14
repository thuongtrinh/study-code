import React, { Component } from "react";
import { connect } from "react-redux";
import { compose } from "redux";
import LoadingIcon from "./../../assets/images/loading2.gif";
import { GlobalLoadingDiv, IconImg } from "./styles";
import PropTypes from "prop-types";

class GlobalLoading extends Component {
  render() {
    const { showLoading } = this.props;
    let xhtml = null;
    if (showLoading) {
      xhtml = (
        <GlobalLoadingDiv>
          <IconImg src={LoadingIcon} alt="loading" />
        </GlobalLoadingDiv>
      );
    }
    return xhtml;
  }
}


GlobalLoading.propTypes = {
  showLoading: PropTypes.bool,
};


const mapStateToProps = (state) => {
  return {
    showLoading: state.ui.showLoading,
  };
};

const withConnect = connect(mapStateToProps, null);

export default compose(withConnect)(GlobalLoading);
