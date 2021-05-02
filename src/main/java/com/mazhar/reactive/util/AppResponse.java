/**
 * 
 */
package com.mazhar.reactive.util;

import java.util.LinkedHashMap;

import static com.mazhar.microblog.util.AppConstant.MESSAGE;
import static com.mazhar.microblog.util.AppConstant.STATUS;

/**
 * @author Mazhar Ibna Zahur
 *
 *April 20, 2021 1:29:55 AM
 */
public class AppResponse {

	private static LinkedHashMap<String, Object> responseModel = new LinkedHashMap<>();

	public static Object resourceNotFound(String message) {
		responseModel.put(STATUS, Boolean.FALSE);
		responseModel.put(MESSAGE, message);
		return responseModel;
	}

	public static Object resourceCreated() {
		responseModel.put(STATUS, Boolean.TRUE);
		responseModel.put(MESSAGE, "Resource created successfully!");
		return responseModel;
	}

	public static Object operationFail(String message) {
		responseModel.put(STATUS, Boolean.FALSE);
		responseModel.put(MESSAGE, message);
		return responseModel;
	}

	public static Object operationFail() {
		responseModel.put(STATUS, Boolean.FALSE);
		responseModel.put(MESSAGE, "Operation fail to execute");
		return responseModel;
	}

	public static Object operationSuccess() {
		responseModel.put(STATUS, Boolean.TRUE);
		responseModel.put(MESSAGE, "Operation successfully executed!");
		return responseModel;
	}

}
