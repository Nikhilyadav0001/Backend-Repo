package nikhil.dao;

import nikhil.beans.Naukri;

public interface INaukriDao {
	public void saveObject(Naukri naukri);
	public Naukri readObject();
}