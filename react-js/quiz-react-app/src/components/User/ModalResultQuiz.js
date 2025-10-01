import _ from "lodash";
import { Button, Modal } from "react-bootstrap";

function ModalResultQuiz(props) {
  const { show, setShow, dataModalResult } = props;

  const handleClose = () => {
    setShow(false);
  };

  return (
    <>
      <Modal show={show} onHide={handleClose}>
        <Modal.Header closeButton>
          <Modal.Title>Result Quiz</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <div>Total Question: {dataModalResult?.countTotal}</div>
          <div>Total correct answer: {dataModalResult?.countCorrect}</div>
        </Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={handleClose}>
            Close
          </Button>
        </Modal.Footer>
      </Modal>
    </>
  );
}

export default ModalResultQuiz;
