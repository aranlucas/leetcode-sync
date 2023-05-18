class TimeLimitedCache {
    constructor() {
        this.cache = new Map();
    }
    
    /** 
    * @param {number} key
    * @param {number} value
    * @param {number} time until expiration in ms
    * @return {boolean} if un-expired key already existed
    */
    set(key, value, duration) {
        const valueInCache = this.cache.get(key);
        if (valueInCache) {
            clearTimeout(valueInCache.timeout);
        }
        const timeout = setTimeout(() => this.cache.delete(key), duration);
        this.cache.set(key, { timeout, value })
        return Boolean(valueInCache);
    }

    /** 
    * @param {number} key
    * @return {number} value associated with key
    */
    get(key) {
        return this.cache.has(key) ? this.cache.get(key).value : -1;
    }
    
    /** 
    * @return {number} count of non-expired keys
    */
    count() {
        return this.cache.size;
    }
}

/**
 * Your TimeLimitedCache object will be instantiated and called as such:
 * var obj = new TimeLimitedCache()
 * obj.set(1, 42, 1000); // false
 * obj.get(1) // 42
 * obj.count() // 1
 */