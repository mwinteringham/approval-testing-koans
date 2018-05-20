package com.mwtestconsultancy.scrubbers;

public class Scrubbers {

    public final static String timeStampScrubber = "[0-9]+";

    public final static String userNameScrubber = "loggedInUser\": \".*\"";

    public final static String timeStampHTMLScrubber = "id=\"timestamp\">[0-9]+";

    public final static String hiddenValueScrubber = "id=\"guid\" value=\".*\"";

}
