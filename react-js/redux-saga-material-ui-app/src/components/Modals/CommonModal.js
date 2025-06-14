import { Modal } from "@mui/material";
import { Component } from "react";
import CloseIcon from "@mui/icons-material/Close";
import { ContentDiv, HeaderDiv, ModalDiv, styleIcon, TitleDiv } from "./style";
import { bindActionCreators, compose } from "redux";
import { connect } from "react-redux";
import * as modalActions from "./../../actions/modal";
import PropTypes from "prop-types";

class CommonModal extends Component {
  render() {
    const { open, title, component, modalActionCreators } = this.props;
    const { hideModal } = modalActionCreators;
    return (
      <Modal open={open} onClose={true}>
        <ModalDiv>
          <HeaderDiv>
            <TitleDiv>{title}</TitleDiv>
            <CloseIcon sx={styleIcon} onClick={hideModal} />
          </HeaderDiv>
          <ContentDiv>{component}</ContentDiv>
        </ModalDiv>
      </Modal>
    );
  }
}

CommonModal.propTypes = {
  title: PropTypes.string,
  open: PropTypes.bool,
  component: PropTypes.object,
  modalActionCreators: PropTypes.shape({
    hideModal: PropTypes.func,
  }),
};

const mapStateToProps = (state) => {
  return {
    open: state.modal.showModal,
    title: state.modal.title,
    component: state.modal.component,
  };
};

const mapDispatchToProps = (dispatch) => {
  return {
    modalActionCreators: bindActionCreators(modalActions, dispatch),
  };
};

const withConnect = connect(mapStateToProps, mapDispatchToProps);

export default compose(withConnect)(CommonModal);
