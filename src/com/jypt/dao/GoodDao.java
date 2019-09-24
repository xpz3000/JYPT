
package com.jypt.dao;
import com.jypt.model.Good;
import java.util.List;


public interface GoodDao {
	public abstract   List<Good> showGoodList(); 
	 public abstract   int  addGood(Good good);
	 public abstract    List<Good> myGoodList(Good good);
	public abstract int removeGoodById(int id);
	public abstract int correctGood(Good good);
	public abstract Good selectGoodById(Good good);
	public abstract int addToCar(Good resultGood);
	public abstract List<Good> shopCar(Good good);    
}
 