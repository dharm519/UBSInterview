package com.ubs.opsit.interviews;

public class BerlinClockMain {

	public static void main(String[] args) {
		
		TimeConverter berlinClockConverter = new BerlinClockConverter();
		String berlinTime =berlinClockConverter.convertTime("13:17:01");
		System.out.println(berlinTime);

	}

}
