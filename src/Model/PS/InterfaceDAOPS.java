package Model.PS;

import java.util.List;

public interface InterfaceDAOPS {
    public void insert(ModelPS playstation);
    
    public void update(ModelPS playstation);
    
    public void delete(int id);
    
    public List<ModelPS> getAll();

}
