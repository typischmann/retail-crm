package org.crm.webservices.mapping;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.MappingException;

/**
 * 
 * @author JIBAO
 *
 */

public class ExtendedDozerBeanMapper extends DozerBeanMapper {

	/**
	 * 
	 */
	public <T> T map(Object source, Class<T> destinationClass) {
		if (source == null) {
			return null;
		}
		return super.map(source, destinationClass);
	}

	/**
	 * 
	 * @param srcList
	 * @param dstItemClass
	 * @return
	 * @throws MappingException
	 */
	public <SI, DI> List<DI> map(List<SI> srcList, Class<DI> dstItemClass)
			throws MappingException {
		List<DI> dstList = new ArrayList<DI>();

		if (srcList == null) {
			return dstList;
		}

		for (SI si : srcList) {
			DI di = super.map(si, dstItemClass);
			dstList.add(di);
		}

		return dstList;
	}

	/**
	 * 
	 * @param srcList
	 * @param dstItemClass
	 * @return
	 * @throws MappingException
	 */
	public <SI, DI> List<DI> map(Collection<SI> srcList, Class<DI> dstItemClass)
			throws MappingException {
		List<DI> dstList = new ArrayList<DI>();

		if (srcList == null) {
			return dstList;
		}

		for (SI si : srcList) {
			DI di = super.map(si, dstItemClass);
			dstList.add(di);
		}

		return dstList;
	}

	/**
	 * 
	 * @param srcArray
	 * @param dstItemClass
	 * @return
	 * @throws MappingException
	 */
	public <SI, DI> DI[] map(SI[] srcArray, Class<DI> dstItemClass)
			throws MappingException {
		DI[] dstArray = (DI[]) Array.newInstance(dstItemClass, srcArray.length);

		for (int i = 0; i < dstArray.length; ++i) {
			dstArray[i] = super.map(srcArray[i], dstItemClass);
		}

		return dstArray;
	}

}
