package com.emc.app.data.service;

import com.emc.app.entity.TransCodeCat;

public interface TransCodeCatService {
	public void save(TransCodeCat transCodeCat);
	public TransCodeCat getTransCodeCat(String tcc);
}
