class CommonUtils {
  static LIMIT_PAGING_USER = 5;

  static isBlank = (text) => {
    return !text || String(text).trim().length === 0;
  };

  static isContainSpace = (text) => {
    return /\s/.test(text);
  };

  static isValidateEmail = (email) => {
    return email.match(
      /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
    );
  };
}

export default CommonUtils;
