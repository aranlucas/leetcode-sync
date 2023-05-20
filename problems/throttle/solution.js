/**
 * @param {Function} fn
 * @param {number} t
 * @return {Function}
 */
var throttle = function(fn, t) {
    let interval = null;
    let savedArgs = null;
    return function(...args) {
        if (interval) {
            savedArgs = args;
        } else {
            fn(...args)
            interval = setInterval(() => {
                if (savedArgs === null) {
                    clearInterval(interval);
                    interval = null;
                } else {
                    fn(...savedArgs);
                    savedArgs = null;
                }
            }, t);
        }
    }
};

/**
 * const throttled = throttle(console.log, 100);
 * throttled("log"); // logged immediately.
 * throttled("log"); // logged at t=100ms.
 */