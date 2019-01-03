package com.atbtm.SpringBootProject.hello;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.serializer.support.DeserializingConverter;
import org.springframework.core.serializer.support.SerializingConverter;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

public class RedisObjectSerializer implements RedisSerializer<Object> {
	private Converter<Object, byte[]> serializer = new SerializingConverter();
	private Converter<byte[], Object> deserialzer = new DeserializingConverter();
	static final byte[] EMPTY_ARRAY = new byte[0];
	
	@Override
	public byte[] serialize(Object t) throws SerializationException {
		if (t == null) {
			return null;
		}
		try {
			return this.serializer.convert(t);
		} catch (Exception e) {
			throw new SerializationException("Cannot serialze", e);
		}
	}

	@Override
	public Object deserialize(byte[] bytes) throws SerializationException {
		if (isEmpty(bytes)) {
			return null;
		}
		try {
			return this.deserialzer.convert(bytes);
		} catch (Exception e) {
			throw new SerializationException("Cannot deserialize", e);
		}
	}

	private boolean isEmpty(byte[] bytes) {
		return bytes == null || bytes.length == 0;
	}

}
