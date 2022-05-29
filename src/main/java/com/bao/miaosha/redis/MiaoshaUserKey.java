package com.bao.miaosha.redis;

public class MiaoshaUserKey extends com.bao.miaosha.redis.BasePrefix {

	public static final int TOKEN_EXPIRE = 3600*24 * 2;
	private MiaoshaUserKey(int expireSeconds, String prefix) {
		super(expireSeconds, prefix);
	}
	public static com.bao.miaosha.redis.MiaoshaUserKey token = new com.bao.miaosha.redis.MiaoshaUserKey(TOKEN_EXPIRE, "tk");
	public static com.bao.miaosha.redis.MiaoshaUserKey getById = new com.bao.miaosha.redis.MiaoshaUserKey(0, "id");
}
