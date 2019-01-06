 --查询用户是否已抢过红包，如果用户已抢过红包，则直接返回nil 
if redis.call('hexists', KEYS[3], KEYS[4]) ~= 0 then
	return nil
else
	--从红包池取出一个小红包
	local hongBao = redis.call('rpop', KEYS[1]);
	--判断红包池的红包是否为不空
	if hongBao then
		local x = cjson.decode(hongBao)
		--将红包信息与用户ID信息绑定，表示该用户已抢到红包 
		x['userId'] = KEYS[4]
		local re = cjson.encode(x)
	  	--记录用户已抢过userIdRecordKey  hset userIdRecordKey  userid 1
		redis.call('hset', KEYS[3], KEYS[4], '1')
		--将抢红包的结果详情存入hongBaoDetailListKey
		redis.call('lpush', KEYS[2], re)
		return re;
  end
end
return nil