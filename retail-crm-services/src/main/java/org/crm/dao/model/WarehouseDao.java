package org.crm.dao.model;

import java.util.List;

import org.crm.entities.Employee;
import org.crm.entities.Warehouse;

/**
 * Warehouse DAO interface.
 */
public interface WarehouseDao {

    /**
     * @param id unique id of ware house.
     * @return ware house object.
     */
    public Warehouse getWarehouseById(int id);

    /**
     * @param manager manager charger of the ware house.
     * @return the list of ware houses which is managed under the manager, null if no one has been found.
     */
    public List<Warehouse> getWarehouseByManager(Employee manager);

    /**
     * @param name ware house name.
     * @return ware house object.
     */
    public Warehouse getWarehouseByName(String name);

}
