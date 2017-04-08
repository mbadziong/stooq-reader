package com.mbadziong.stooq.testdata;

public class SampleCsv {

    public static final String VALID_CSV =
            "Symbol,Data,Czas,Otwarcie,Najwyzszy,Najnizszy,Zamkniecie\r\n" +
                    "WIG,2017-04-06,17:15:00,58915.81,59406.36,58896.7,59406.36\r\n";

    public static final String INVALID_CSV = "invalid,csv,\r\nfile";

    public static final String EMPTY_CSV = "";
}
