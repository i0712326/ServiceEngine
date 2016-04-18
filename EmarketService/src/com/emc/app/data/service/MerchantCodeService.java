package com.emc.app.data.service;

import java.util.List;

import com.emc.app.entity.MerchantCode;

public interface MerchantCodeService {
	public void save(MerchantCode merchantCode);
	public void delete(MerchantCode merchantCode);
	public MerchantCode getMerchantCode(MerchantCode merchantCode);
	public List<MerchantCode> getMerchantCodes(int first, int max);
}
