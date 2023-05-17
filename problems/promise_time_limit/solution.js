/**
 * @param {Function} fn
 * @param {number} t
 * @return {Function}
 */
var timeLimit = function(fn, t) {
    const p2 = new Promise((_, reject) => setTimeout(() => reject("Time Limit Exceeded"), t));
	return async function(...args) {
        const p1 = new Promise((resolve) => resolve(fn(...args)));
        return Promise.race([p1, p2]);
    }
};

/**
 * const limited = timeLimit((t) => new Promise(res => setTimeout(res, t)), 100);
 * limited(150).catch(console.log) // "Time Limit Exceeded" at t=100ms
 */