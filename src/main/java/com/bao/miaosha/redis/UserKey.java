package com.bao.miaosha.redis;

public class UserKey extends com.bao.miaosha.redis.BasePrefix {

	private UserKey(String prefix) {
		super(prefix);
	}
	public static com.bao.miaosha.redis.UserKey getById = new com.bao.miaosha.redis.UserKey("id");
	public static com.bao.miaosha.redis.UserKey getByName = new com.bao.miaosha.redis.UserKey("name");
}
