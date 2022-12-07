local code = redis.call('GET', KEYS[1]);
if code == ARGS[1] then
    redis.call('DELETE', KEYS[1])
    return 1;
end
return 0;