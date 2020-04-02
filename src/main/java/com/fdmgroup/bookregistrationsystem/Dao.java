package com.fdmgroup.bookregistrationsystem;

public interface Dao<T, ID> {

	void save(Book T);

	T read(ID id);

}
