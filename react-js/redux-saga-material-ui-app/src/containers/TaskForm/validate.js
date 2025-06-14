const validate = (values) => {
  const errors = {};
  const { title } = values;
  if (!title) {
    errors.title = "Input title, please";
  } else if (title.trim() && title.length < 5) {
    errors.title = "Title must be greater than 5 characters";
  }
  return errors;
};

export default validate;
