package com.operasolutions.validation;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.TypeFactory;

public class DiffKernel {

	final static Logger logger = Logger.getLogger(DiffKernel.class);

	/**
	 * @param args
	 * @throws ClassNotFoundException
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	public static void main(String[] args) throws ClassNotFoundException,
			JsonParseException, JsonMappingException, IOException {
		// TODO Auto-generated method stub
		DiffKernel instance = new DiffKernel();
		String className = "FundOverviewEntity";
		String mysqlJson = "/com/operasolutions/validation/mysql-fundoverview.json";
		String mongoJson = "/com/operasolutions/validation/mongo-fundoverview.json";
		String testJson = "/com/operasolutions/validation/AcuityLevel.json";

		Class mysql = Class.forName("com.operasolutions.mysql." + className);
		Class mongo = Class.forName("com.operasolutions.mongo." + className);
		Class test = Class.forName("com.operasolutions.test." + "AcuityLevel");
		logger.info("class mysql:" + mysql.getCanonicalName());
		logger.info("class mongo:" + mysql.getCanonicalName());
		logger.info("class test:" + test.getCanonicalName());
		// List testResult = instance.loadJsonFile(testJson, test);
		// logger.info("test result size:" + testResult.size());
		List mysqlResult = instance.loadJsonFile(mysqlJson, mysql);
		logger.info("mysql result size:" + mysqlResult.size());

		List mongoResult = instance.loadJsonFile(mongoJson, mongo);
		logger.info("mongoResult result size:" + mongoResult.size());
		Collections.sort(mysqlResult);
		Collections.sort(mongoResult);

	}

	public <T> List<T> loadJsonFile(String location, Class<T> cl)
			throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		logger.info("file trace:" + location);
		TypeFactory tF = mapper.getTypeFactory();
		InputStream is = getClass().getResourceAsStream(location);
		logger.info("readfile:....");
		List<T> result = mapper.readValue(is,
				tF.constructCollectionType(List.class, cl));

		return result;
	}
}
