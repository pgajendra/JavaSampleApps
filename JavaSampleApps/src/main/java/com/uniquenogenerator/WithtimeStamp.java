package com.uniquenogenerator;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

public class WithtimeStamp {

	public static void main(String[] args) {

		AtomicLong atmLong = new AtomicLong(System.currentTimeMillis());
		System.out.println(atmLong.getAndIncrement());
		long timestamp = atmLong.getAndIncrement();
		String l = timestamp + "";
		Date date = new Date(timestamp);
		System.out.println(date);

	}

}
