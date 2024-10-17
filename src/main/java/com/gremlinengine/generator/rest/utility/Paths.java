package com.gremlinengine.generator.rest.utility;

public final class Paths {

    /**
     * The base of all rest api paths.
     */
    private static final String BASE_PATH = "/rest/v1";

    /**
     * Cv paths.
     */
    private static final String BASE_CV_PATH = BASE_PATH + "/cv";

    public static final String CREATE_CV = BASE_CV_PATH + "/create";

    public static final String GET_ALL_CVS = BASE_CV_PATH + "/get-all";

    public static final String GET_CV_BY_ID = BASE_CV_PATH + "/get/{id}";

    public static final String UPDATE_CV = BASE_CV_PATH + "/update/{id}";

    public static final String DELETE_CV = BASE_CV_PATH + "/delete/{id}";

    /**
     * Address paths.
     */
    private static final String BASE_ADDRESS_PATH = BASE_PATH + "/address";

    public static final String CREATE_ADDRESS = BASE_ADDRESS_PATH + "/create";

    public static final String GET_ALL_ADDRESSES = BASE_ADDRESS_PATH + "/get-all";

    public static final String GET_CV_ADDRESS_ID = BASE_ADDRESS_PATH + "/get/{id}";

    public static final String UPDATE_ADDRESS = BASE_ADDRESS_PATH + "/update/{id}";

    public static final String DELETE_ADDRESS = BASE_ADDRESS_PATH + "/delete/{id}";

    /**
     * Theme paths.
     */
    private static final String BASE_THEME_PATH = BASE_PATH + "/theme";

    public static final String CREATE_THEME = BASE_THEME_PATH + "/create";

    public static final String GET_ALL_THEMES = BASE_THEME_PATH + "/get-all";

    public static final String GET_THEME_BY_ID = BASE_THEME_PATH + "/get/{id}";

    public static final String UPDATE_THEME = BASE_THEME_PATH + "/update/{id}";

    public static final String DELETE_THEME = BASE_THEME_PATH + "/delete/{id}";

    private Paths() { /* Empty constructor to prohibit initialisation. */ }

}
