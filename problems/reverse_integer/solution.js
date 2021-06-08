/**
 * @param {number} x
 * @return {number}
 */
var reverse = function (x) {
  const limit = Math.pow(2, 31) - 1;

  const power = x < 0 ? -1 : 1;

  const n = Number(String(Math.abs(x)).split("").reverse().join(""));

  if (n > limit) {
    return 0;
  }

  return n * power;
};