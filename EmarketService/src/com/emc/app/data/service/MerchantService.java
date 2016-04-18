package com.emc.app.data.service;

import java.util.List;

import com.emc.app.entity.Merchant;

public interface MerchantService {
	public void save(Merchant merchant);
	public void delete(Merchant merchant);
	public Merchant getMerchant(Merchant merchant);
	public List<Merchant> getMerchants(Merchant merchant);
}
