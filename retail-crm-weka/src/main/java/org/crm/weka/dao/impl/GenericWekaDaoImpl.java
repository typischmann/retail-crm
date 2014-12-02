package org.crm.weka.dao.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.crm.weka.dao.api.GenericWekaDao;
import org.springframework.stereotype.Repository;

import weka.core.Instances;
import weka.experiment.InstanceQuery;

@Repository("genericWekaDao")
public class GenericWekaDaoImpl extends InstanceQuery implements GenericWekaDao {	
	
	private Instances instances;
	
	private Properties dataBaseProps;	
	
	private Map<String, Integer> paramToTypeMap;
	
	private Map<String, String> paramToValueMap;
	
	public final static String paramPrefix="weka_param_";
	
	public static String dataBasePropsFile="src/main/resources/weka/weka-database.props";
	
	public GenericWekaDaoImpl() throws Exception{
		super();
		this.instances=null;
		this.dataBaseProps=null;
		this.paramToTypeMap=null;
		this.paramToValueMap=null;
		this.intializeDao(this.getDatabaseProps());
	}
	
	protected String getDatabaseProps(){
		return GenericWekaDaoImpl.dataBasePropsFile;
	}
	
	private void intializeDao(String filePath) throws Exception{
		if(this.dataBaseProps==null){
			this.dataBaseProps=new Properties();
		}
		this.dataBaseProps.load(new FileInputStream(new File(filePath)));
		
		if(this.paramToTypeMap==null){
			this.paramToTypeMap=new HashMap<String, Integer>();			
		}
		
		if(this.paramToValueMap==null){
			this.paramToValueMap=new HashMap<String, String>();
		}
		
		for(Object param : this.dataBaseProps.keySet()){
			if(param.toString().startsWith(GenericWekaDaoImpl.paramPrefix)){
				String typeString=this.dataBaseProps.getProperty(param.toString());
				Integer type=Integer.valueOf(typeString);	
				this.paramToTypeMap.put(param.toString(), type);
				this.paramToValueMap.put(param.toString(), "null");
			}		
		}
		
		for(String param : this.paramToTypeMap.keySet()){
			if(this.dataBaseProps.containsKey((Object)param)){
				this.dataBaseProps.remove(param);
			}
		}

		this.setUsername(this.dataBaseProps.getProperty("username"));
		this.dataBaseProps.remove("username");
		this.setPassword(this.dataBaseProps.getProperty("password"));
		this.dataBaseProps.remove("password");
		this.initialize(this.dataBaseProps);
	}
	
	private boolean validateQueryFile(File file){
		if(!file.isFile()||!file.exists()){
			return false;
		}else{
			return true;
		}
	}
	
	private void reviseParameterValues() throws Exception{
		Set<String> keys=this.paramToValueMap.keySet();
		for(String key : keys){
			String value=this.paramToValueMap.get(key);
			//the revision will be skipped, if the value is null.
			if(value.compareTo("null")==0){
				continue;
			}
			
			switch(this.paramToTypeMap.get(key)){
			case STRING:
				break;
			case INTEGER:
				break;
			case DATE:
				value="to_date('"+value+"', 'DD.MM.YYYY')";
				break;
			case DOUBLE:
			case FLOAT:
				break;
			default:
				throw new Exception("Unhandled SQL data type "+this.paramToTypeMap.get(key).toString()+" for parameter "+key);
			}
			this.paramToValueMap.put(key, value);
		}
	}
	
	private String replaceQueryParameter(String query){
		String revisedQuery=query;
		return revisedQuery;
	}
	
	/**
	 * {@inheritDoc}}
	 */
	public Instances getInstances() throws Exception{		
		if(instances==null){
			instances=super.retrieveInstances();
		}
		return instances;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Instances getInstances(String query) throws Exception{		
		if(instances==null){
			instances=super.retrieveInstances(query);
		}
		return instances;
	}

	/**
	 * {@inheritDoc}
	 * @throws IOException 
	 */
	public void loadQueryFile(File file) throws IOException {
		// TODO Auto-generated method stub
		if(!this.validateQueryFile(file)){
			throw new FileNotFoundException(file.getName()+" is not found or not validated.");
		}
		String query = new String(Files.readAllBytes(Paths.get(file.getAbsolutePath())));	
		query=this.replaceQueryParameter(query);
		this.setQuery(query);		
	}

	/**
	 * {@inheritDoc}
	 * @throws Exception 
	 */
	public void loadQueryFile(File file, Map<String, String> params) throws Exception {
		this.setParameters(params);
		this.loadQueryFile(file);				
	}

	/**
	 * {@inheritDoc}
	 */
	public void setParameters(Map<String, String> params) throws Exception {
		this.paramToValueMap.clear();
		for(String param : params.keySet()){
			if(!this.paramToValueMap.containsKey(param.toString())){
				throw new Exception("The definition of the input parameter "+param.toString()+" is not found.");
			}
			this.paramToValueMap.put(param, params.get(param).toString());
		}
		this.reviseParameterValues();		
	}

	/**
	 * {@inheritDoc}
	 */
	public Instances refreshInstances() throws Exception {
		this.instances=super.retrieveInstances();
		return this.instances;
	}
	
	
	

}
