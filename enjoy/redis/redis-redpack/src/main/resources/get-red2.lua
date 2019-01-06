--查询红包是否被抢完，如果被抢完了，直接返回nil
if redis.call('llen',KEYS[1]) == 0 then
	return nil
end
--查询用户是否已抢过红包，如果用户已抢过红包，则直接返回nil 
if redis.call('sadd', KEYS[3], KEYS[4]) == 0 then
	print(KEYS[4].." already exist!")
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
		--将抢红包的结果详情存入hongBaoDetailListKey
		redis.call('lpush', KEYS[2], re)
		return re;
  end
end
return nil