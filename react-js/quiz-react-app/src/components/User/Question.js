import _ from "lodash";

const Question = (props) => {
  const { dataQuiz, index } = props;
  if (_.isEmpty(dataQuiz)) return <></>;

  const handleCheckRadio = (event, answerId, questionId) => {
    console.log("handleCheckRadio", answerId, questionId);
    props.handleCheckAnswer(questionId, answerId);
  };

  return (
    <div>
      <div className="card-inner">
        <div className="quiz-img">
          <img
            src={`data:image/jpeg;base64,${dataQuiz?.image}`}
            alt={`Alt Quiz ${index + 1}`}
          />
        </div>
        <div className="question-area">
          <h2 className="question-text" id="question-text">
            Question {index + 1}: {dataQuiz?.questionDescription}
          </h2>
          <ul className="options" id="options">
            {dataQuiz.answers &&
              dataQuiz.answers.length > 0 &&
              dataQuiz.answers.map((item, index) => {
                return (
                  <li className="option" key={`answer-${index + 1}`}>
                    <label>
                      <input
                        type="radio"
                        name="answer"
                        value=""
                        checked={item.isSelected}
                        onChange={(event) =>
                          handleCheckRadio(event, item.id, dataQuiz.questionId)
                        }
                      />
                      <span>{item.description}</span>
                    </label>
                  </li>
                );
              })}
          </ul>
        </div>
      </div>
    </div>
  );
};

export default Question;
