package com.cms.sms.common;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class KeyValueTest {

	@Test
	void testGetKey() {
		KeyValue kv = new KeyValue();

		String key = "testKey"; 
		kv.setKey(key);
		assertEquals(key, kv.getKey());

		key = null;
		kv.setKey(key);
		assertEquals(key, kv.getKey());
	}

	@Test
	void testGetValue() {
		KeyValue kv = new KeyValue();
		String value = "testValue"; 

		kv.setValue(value);
		assertEquals(value, kv.getValue());
	}

	@Test
	void testSetKey() {
		KeyValue kv = new KeyValue();
		String key = "testKey"; 

		key = null;
		kv.setKey(key);

		kv.setKey(key);
		assertEquals(key, kv.getKey());
	}

	@Test
	void testSetValue() {
		KeyValue kv = new KeyValue();
		String value = "testValue"; 

		kv.setValue(value);
		assertEquals(value, kv.getValue());
	}

}
