package com.ubs.opsit.interviews;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BerlinClockConverterTest{
	
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    public void testMidnightUpper() {
    	String actual = new BerlinClockConverter().convertTime("00:00:00");
        String expected = "Y\n" +
                "0000\n" +
                "0000\n" +
                "00000000000\n" +
                "0000";

        assertEquals(expected, actual.toString());

    }


    @Test
    public void testMiddleOfAfterNoon() {
    	String actual = new BerlinClockConverter().convertTime("13:17:01");
        String expected = "0\n" +
                "RR00\n" +
                "RRR0\n" +
                "YYR00000000\n" +
                "YY00";

        assertEquals(expected, actual.toString());
    }


    @Test
    public void testJustBeforeMidnight() {
    	String actual = new BerlinClockConverter().convertTime("23:59:59");
        String expected = "0\n" +
                "RRRR\n" +
                "RRR0\n" +
                "YYRYYRYYRYY\n" +
                "YYYY";

        assertEquals(expected, actual.toString());
    }
    
    @Test
    public void testMidnight() {
    	String actual = new BerlinClockConverter().convertTime("24:00:00");
        String expected = "Y\n" +
                "RRRR\n" +
                "RRRR\n" +
                "00000000000\n" +
                "0000";

        assertEquals(expected, actual.toString());
    }

    @Test
    public void testUpperInvalidHours() {
    	String actual = new BerlinClockConverter().convertTime("25:00:00");
    	String expected = "Hours out of bounds.";
    	assertEquals(expected, actual.toString());
    }


    @Test
    public void testUpperInvalidMinutes() {
    	String actual = new BerlinClockConverter().convertTime("00:60:00");
    	String expected = "Minutes out of bounds.";
    	assertEquals(expected, actual.toString());
    }

    @Test
    public void testUpperInvalidSeconds() {
    	String actual = new BerlinClockConverter().convertTime("00:00:60");
    	String expected = "Seconds out of bounds.";
    	assertEquals(expected, actual.toString());
    }

  
    @Test
    public void testLowerInvalidHours() {
    	String actual = new BerlinClockConverter().convertTime("-01:00:00");
    	String expected = "Hours out of bounds.";
    	assertEquals(expected, actual.toString());
    }


    @Test
    public void testLowerInvalidMinutes() {
    	String actual = new BerlinClockConverter().convertTime("00:-01:00");
    	String expected = "Minutes out of bounds.";
    	assertEquals(expected, actual.toString());

    }

    @Test
    public void testLowerInvalidSeconds() {
    	String actual = new BerlinClockConverter().convertTime("00:00:-01");
    	String expected = "Seconds out of bounds.";
    	assertEquals(expected, actual.toString());

    }
    
    @Test
    public void testInvalidString() {
    	String actual = new BerlinClockConverter().convertTime("00:00");
    	String expected = "Invalid time provided.";
    	assertEquals(expected, actual.toString());
    }

    @Test
    public void testNullString() {
    	String actual = new BerlinClockConverter().convertTime(null);
    	String expected = "No time provided";
    	assertEquals(expected, actual.toString());

    }

    @Test
    public void testEmptyString() {
    	String actual = new BerlinClockConverter().convertTime("");
    	String expected = "Invalid time provided.";
    	assertEquals(expected, actual.toString());
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

}
