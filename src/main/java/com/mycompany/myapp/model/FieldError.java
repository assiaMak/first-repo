package com.mycompany.myapp.model;

import java.io.Serializable;

/**
 * @author admin
 *
 */
public class FieldError implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String path;
    private String message;

    /**
     * @param path
     * @param message
     */
    public FieldError(String path, String message) {
        this.path = path;
        this.message = message;
    }

    /**
     * @return
     */
    public String getPath() {
        return path;
    }

    /**
     * @return
     */
    public String getMessage() {
        return message;
    }
}
