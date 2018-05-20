package com.mwtestconsultancy.html;

public class OS {

    private String OS;

    public OS() {
        OS = System.getProperty("os.name").toLowerCase();
    }

    public boolean isWindows() {
        return (OS.indexOf("win") >= 0);
    }

    public boolean isMac() {
        return (OS.indexOf("mac") >= 0);
    }

    public boolean isUnix() {
        return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 );
    }

    public boolean isSolaris() {
        return (OS.indexOf("sunos") >= 0);
    }
}
