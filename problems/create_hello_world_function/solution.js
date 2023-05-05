/**
 * @return {Function}
 */
var createHelloWorld = function() {
    return function(...args) {
        return "H" + "e" + "l" + "l" + "o" + " " + "W" + "o" + "r" + "l" + "d"
    }
};

/**
 * const f = createHelloWorld();
 * f(); // "Hello World"
 */