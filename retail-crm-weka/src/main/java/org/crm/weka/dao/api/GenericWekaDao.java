package org.crm.weka.dao.api;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;

import weka.core.Instances;

public interface GenericWekaDao {
	
	public void loadQueryFile(File file) throws FileNotFoundException;
	
	public void loadQueryFile(File file, Map<String, String> params);
	
	public void setParameters(Map<String, String> params);
	
	public Instances getInstances() throws Exception;
	
	public Instances getInstances(String query) throws Exception;
	
	public Instances refreshInstances() throws Exception;
}
