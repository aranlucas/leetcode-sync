
const map = {
  "(": ")",
  "[": "]",
  "{": "}",
};

/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function (s) {
  if (s.length === 0 || s.length % 2 !== 0) {
    return false;
  }
  const stack = [];

  for (let el of s) {
    if (map[el]) {
      stack.push(map[el]);
    } else {
      if (el !== stack.pop()) {
        return false;
      }
    }
  }

  return stack.length === 0;
};