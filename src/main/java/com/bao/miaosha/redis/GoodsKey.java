package com.bao.miaosha.redis;

public class GoodsKey extends com.bao.miaosha.redis.BasePrefix {

	private GoodsKey(int expireSeconds, String prefix) {
		super(expireSeconds, prefix);
	}
	public static com.bao.miaosha.redis.GoodsKey getGoodsList = new com.bao.miaosha.redis.GoodsKey(60, "gl");
	public static com.bao.miaosha.redis.GoodsKey getGoodsDetail = new com.bao.miaosha.redis.GoodsKey(60, "gd");
	public static GoodsKey getMiaoshaGoodsStock= new GoodsKey(0, "gs");
}
