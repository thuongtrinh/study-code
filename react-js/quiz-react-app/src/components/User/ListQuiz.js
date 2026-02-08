import { useNavigate } from "react-router-dom";
import "./ListQuiz.scss";
import { useEffect, useState } from "react";
import { getQuizByUser } from "../../services/apiService";
import { Button } from "react-bootstrap";

const ListQuiz = () => {
  const navigate = useNavigate();
  const [arrQuiz, setArrQuiz] = useState([]);

  useEffect(() => {
    getQuizData();
  }, []);

  const getQuizData = async () => {
    const res = await getQuizByUser();
    if (res && res.EC === 0) {
      setArrQuiz(res.DT);
    }
  };

  return (
    <div className="list-quiz-container">
      {arrQuiz &&
        arrQuiz.length > 0 &&
        arrQuiz.map((item, index) => {
          return (
            <div className="card" key={`quiz-${index + 1}`}>
              <img
                src={`data:image/jpeg;base64,${item?.image}`}
                className="card-img-top"
                alt={`Alt Quiz ${index + 1}`}
              />
              <div className="card-body">
                <h5 className="card-title">Quiz {index + 1}</h5>
                <p className="card-text">{item.description}</p>
                <Button
                  className="btn btn-primary"
                  onClick={() => navigate(`/quiz/${item.id}`)}
                >
                  Start Now
                </Button>
              </div>
            </div>
          );
        })}
    </div>
  );
};

export default ListQuiz;
