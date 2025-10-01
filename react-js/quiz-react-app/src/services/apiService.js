import axiosInstance from "../utils/axiosCutomize";

const postCreateUser = async (email, password, username, role, image) => {
  const data = new FormData();
  data.append("email", email);
  data.append("password", password);
  data.append("username", username);
  data.append("role", role);
  data.append("userImage", image);

  return axiosInstance.post("api/v1/participant", data);
};

const getAllUsers = () => {
  return axiosInstance.get("api/v1/participant/all");
};

const putUpdateUser = async (id, username, role, image) => {
  const data = new FormData();
  data.append("id", id);
  data.append("username", username);
  data.append("role", role);
  data.append("userImage", image);

  return axiosInstance.put("api/v1/participant", data);
};

const deleteUser = (userId) => {
  return axiosInstance.delete("api/v1/participant", { data: { id: userId } });
};

const getUserPaging = (page, limit) => {
  return axiosInstance.get(`api/v1/participant?page=${page}&limit=${limit}`);
};

const postLogin = async (email, password) => {
  const data = new FormData();
  data.append("email", email);
  data.append("password", password);

  return axiosInstance.post("api/v1/login", data);
};

const postRegister = async (email, password, username) => {
  const data = new FormData();
  data.append("email", email);
  data.append("password", password);
  data.append("username", username);

  return axiosInstance.post("api/v1/register", data);
};

const getQuizByUser = async (data) => {
  return axiosInstance.get("api/v1/quiz-by-participant");
};

const getQuestionByQuizId = async (id) => {
  return axiosInstance.get(`api/v1/questions-by-quiz?quizId=${id}`);
};

const postSubmitQuiz = async (data) => {
  return axiosInstance.post("api/v1/quiz-submit", { ...data });
};

export {
  postCreateUser,
  getAllUsers,
  putUpdateUser,
  deleteUser,
  getUserPaging,
  postLogin,
  postRegister,
  getQuizByUser,
  getQuestionByQuizId,
  postSubmitQuiz,
};
