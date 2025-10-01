import { use, useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { getQuestionByQuizId, postSubmitQuiz } from "../../services/apiService";
import _, { set } from "lodash";
import "./QuizDetail.scss";
import Question from "./Question";
import { toast } from "react-toastify";
import ModalResultQuiz from "./ModalResultQuiz";

const QuizDetail = () => {
  const params = useParams();
  const quizId = params.id;

  const [dataQuiz, setDataQuiz] = useState({});
  const [index, setIndex] = useState(0);
  const [totalQuestion, setTotalQuestion] = useState(0);

  const [isShowModalResult, setIsShowModalResult] = useState(false);
  const [dataModalResult, setDataModalResult] = useState({});

  useEffect(() => {
    fetchQuestions();
  }, [quizId]);

  const fetchQuestions = async () => {
    let res = await getQuestionByQuizId(quizId);
    console.log(res);

    if (res && res.EC === 0) {
      let raw = res.DT;
      let data = _.chain(raw)
        .groupBy("id")
        .map((value, key) => {
          let answers = [];
          let questionDescription,
            image = null;
          value.forEach((item, index) => {
            if (index === 0) {
              questionDescription = item.description;
              image = item.image;
            }
            item.answers.isSelected = false;
            answers.push(item.answers);
          });
          return {
            questionId: key,
            answers,
            questionDescription,
            image,
          };
        })
        .value();

      // console.log(data);
      setDataQuiz(data);
      setTotalQuestion(data?.length);
    }
  };

  const handleNextQuestion = () => {
    if (dataQuiz && index < dataQuiz.length - 1) {
      setIndex(index + 1);
    }
  };

  const handlePreviousQuestion = () => {
    if (index > 0) {
      setIndex(index - 1);
    }
  };

  const handleFinishQuiz = async () => {
    let payload = { quizId: +quizId, answers: [] };
    let answers = [];
    if (dataQuiz && dataQuiz.length > 0) {
      dataQuiz.forEach((item) => {
        item.answers.forEach((answer) => {
          if (answer.isSelected) {
            answers.push({
              questionId: +item.questionId,
              userAnswerId: [answer.id],
            });
          }
        });
      });
    }
    payload.answers = answers;
    // console.log("handleFinishQuiz", payload);

    let res = await postSubmitQuiz(payload);
    if (res && res.EC === 0) {
      setDataModalResult({
        countCorrect: res.DT.countCorrect,
        countTotal: res.DT.countTotal,
        quizData: res.DT.quizData,
      });
      setIsShowModalResult(true);
    } else {
      toast.error(res.EM);
    }
  };

  const handleCheckAnswer = (questionId, answerId) => {
    let dataQuizClone = _.cloneDeep(dataQuiz);
    dataQuizClone.forEach((item) => {
      if (item.questionId === questionId) {
        item.answers.forEach((answer) => {
          if (answer.id === answerId) {
            answer.isSelected = true;
          } else {
            answer.isSelected = false;
          }
        });
      }
    });

    console.log("handleCheckAnswer", dataQuizClone);
    setDataQuiz(dataQuizClone);
  };

  return (
    <div className="quiz-detail-container">
      <div className="quiz-header">
        <div className="brand">
          <span className="logo" aria-hidden="true">
            Q
          </span>
          <h1 className="title">Exam Quiz</h1>
        </div>
        <div className="progress" aria-label="Progress">
          <span className="progress-text">
            Question <span className="current">{index + 1}</span> of{" "}
            <span className="total">{totalQuestion}</span>
          </span>
          <div
            className="progress-bar"
            role="progressbar"
            aria-valuenow="0"
            aria-valuemin="0"
            aria-valuemax="100"
          ></div>
        </div>
      </div>
      <div className="quiz-content">
        <div className="quiz-question">
          <section
            className="quiz-card"
            id="quiz-card"
            aria-label="Quiz Question"
          >
            <Question
              index={index}
              dataQuiz={dataQuiz && dataQuiz.length > 0 ? dataQuiz[index] : []}
              handleCheckAnswer={handleCheckAnswer}
            />

            <hr className="bg-danger border-1 border-top border-secondary my-3" />
            <div className="footer-quiz">
              <button
                className="btn btn-secondary"
                id="prev"
                onClick={handlePreviousQuestion}
                disabled={index === 0}
              >
                Previous
              </button>
              <button
                className="btn btn-primary"
                id="next"
                onClick={handleNextQuestion}
                disabled={index === dataQuiz.length - 1}
              >
                Next
              </button>
              <button
                className="btn btn-success"
                id="finish"
                onClick={handleFinishQuiz}
                disabled={index !== dataQuiz.length - 1}
              >
                Finish
              </button>
            </div>
          </section>
        </div>
        <section className="quiz-time-limit" aria-label="Quiz Time Limit">
          <div>
            <aside className="sidebar-info" aria-label="Question metadata">
              <div className="badge">Time limit: 15:00</div>
              <div className="tag">Section: Mathematics</div>
              <div className="hint">Tip: Read the question carefully.</div>
            </aside>
          </div>
        </section>
      </div>
      <ModalResultQuiz
        show={isShowModalResult}
        setShow={setIsShowModalResult}
        dataModalResult={dataModalResult}
      />
    </div>
  );
};

export default QuizDetail;
