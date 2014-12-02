package org.crm.weka.dao.api;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import weka.core.Instances;

public interface GenericWekaDao {
	
	/**
	 * 
	 * @param file
	 * @throws FileNotFoundException
	 * @throws IOException 
	 */
	public void loadQueryFile(File file) throws FileNotFoundException, IOException;
	
	/**
	 * 
	 * @param file
	 * @param params
	 * @throws Exception 
	 */
	public void loadQueryFile(File file, Map<String, String> params) throws Exception;
	
	/**
	 * 
	 * @param params
	 */
	public void setParameters(Map<String, String> params) throws Exception;
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public Instances getInstances() throws Exception;
	
	/**
	 * 
	 * @param query
	 * @return
	 * @throws Exception
	 */
	public Instances getInstances(String query) throws Exception;
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public Instances refreshInstances() throws Exception;
}
