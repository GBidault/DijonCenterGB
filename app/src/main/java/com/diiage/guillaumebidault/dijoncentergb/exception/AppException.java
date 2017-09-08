package com.diiage.guillaumebidault.dijoncentergb.exception;

/**
 * Created by GuillaumeBidault on 08/09/2017.
 */

public class AppException extends Exception {

    public AppException(int Code,String message) {
        super("Code : " +Code+ ", Message : " + message);
    }

}
