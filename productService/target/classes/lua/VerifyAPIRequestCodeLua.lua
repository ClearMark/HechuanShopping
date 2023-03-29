local code = redis.call('GET', KEYS[1]);
if (code == ARGV[1])
then
    redis.call('del', KEYS[1]);
    return true
end
return false;