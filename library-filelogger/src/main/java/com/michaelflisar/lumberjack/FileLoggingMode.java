package com.michaelflisar.lumberjack;

public enum FileLoggingMode {
    /**
     * Use this mode for Daily rollover (at midnight).
     * <br/>
     * <b>Example:</b> for pattern `location/%d_foo.txt` logging output will goto `location/foo.txt`
     * on 24th April 2019. At midnight, foo.txt will be renamed as `location/2019-04-24_foo.txt` and
     * rest of logging for 25th April will happen on new file at `location/foo.txt`.
     */
    DAILY_ROLLOVER("%d_"),

    /**
     * Use this for Monthly rollover.
     * <br/>
     * <b>Example:</b> for pattern `location/%d{yyyy/MM}/foo.txt logging output will goto
     * `location/foo.txt` in April 2019. At midnight of 30th April 2019, `location/foo.txt` will be
     * renamed as `location/2019/04/foo.txt`. A new `location/foo.txt` will be created where logging
     * output will go for the rest of May and so on.
     */
    MONTHLY_ROLLOVER("%d{yyyy/MM}/"),

    /**
     * Rollover at the first day of each week. Note: the first day of the week depends on the locale.
     * <br/>
     * <b>Example:</b> for pattern `location/%d{yyyy-ww}_foo.txt` the logging output will goto
     * `location/foo.txt` in 22nd week 2019. At midnight of last weekday in 22nd week, `location/foo.txt`
     * will be renamed as `location/2019/22/foo.txt`. A new `location/foo.txt` will be created where
     * logging output will go for 23rd week and so on.
     */
    WEEKLY_ROLLOVER("%d{yyyy-ww}_"),

    /**
     * Rollover happens when the {@link FileLoggingSetup#getFileSizeLimit()} is met. After which a
     * new file is created till {@link FileLoggingSetup#getLogFilesToKeep()} is met.
     * <br/>
     * <b>Example:</b> for pattern `location/%i_foo.txt` the logging output will goto `location/foo.txt`
     * as soon as the file size limit reaches the maxSize set, `location/foo.txt` is renamed as
     * `location/1_foo.txt`. A new `location/foo.txt` will be created for logging outputs. Similarly
     * `location/1_foo.txt` will be renamed as `location/2_foo.txt` and `location/foo.txt` as
     * `location/1_foo.txt` and a new file `location/foo.txt` will be created.
     */
    FILE_SIZE_ROLLOVER("%i_");

    /**
     * Stores the mandatory pattern for the fileName that determines what kind of rollover is needed
     * by the logback library.
     */
    private String fileNamePattern;

    FileLoggingMode(String fileNamePattern) {
        this.fileNamePattern = fileNamePattern;
    }

    public String getFileNamePattern() {
        return fileNamePattern;
    }
}