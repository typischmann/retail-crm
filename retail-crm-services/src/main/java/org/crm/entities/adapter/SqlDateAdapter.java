package org.crm.entities.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.Date;


/**
 * Created by tczhaodachuan on 3/23/2015.
 */
public class SqlDateAdapter extends XmlAdapter<Date, java.sql.Date> {

    @Override
    public java.sql.Date unmarshal(Date date) throws Exception {
        if (null == date) {
            return null;
        }
        return new java.sql.Date(date.getTime());
    }

    @Override
    public Date marshal(java.sql.Date sqlDate) throws Exception {
        if (null == sqlDate) {
            return null;
        }
        return new java.sql.Date(sqlDate.getTime());
    }
}
