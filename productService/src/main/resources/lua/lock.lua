redis.call('set', KEYS[1], ARGV[1], 'NX', 'PX', ARGV[2])
-- Path: productService\src\main\resources\lua\lock.lua
