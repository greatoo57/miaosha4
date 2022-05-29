package com.bao.miaosha.redis;

public class OrderKey extends BasePrefix {

	public OrderKey(String prefix) {
		super(prefix);
	}
	public static com.bao.miaosha.redis.OrderKey getMiaoshaOrderByUidGid = new com.bao.miaosha.redis.OrderKey("moug");
}
