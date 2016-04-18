package com.emc.app.spi.poi;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.emc.app.data.service.MerchantCodeService;
import com.emc.app.data.service.MerchantService;
import com.emc.app.entity.Entity;
import com.emc.app.entity.Merchant;
import com.emc.app.entity.MerchantCode;
@Component("merchantPoi")
public class MerchantPoiImp implements MerchantPoi {
	@Autowired
	private MerchantService merchantService;
	@Autowired
	private MerchantCodeService merchantCodeService;
	public void setMerchantService(MerchantService merchantService){
		this.merchantService = merchantService;
	}
	public void setMerchantCodeService(MerchantCodeService merchantCodeService){
		this.merchantCodeService = merchantCodeService;
	}
	public Response save(Merchant merchant) {
		MerchantCode code = new MerchantCode();
		code.setMcc(merchant.getMerchantCode().getMcc());
		code = merchantCodeService.getMerchantCode(code);
		merchant.setMerchantCode(code);
		merchantService.save(merchant);
		return Response.ok(new Entity("200", "Successful")).build();
	}
	
	public Response getMerchant(String mcId){
		Merchant mc = new Merchant();
		mc.setMcId(mcId);
		Merchant merchant = merchantService.getMerchant(mc);	
		return Response.ok(merchant).build();
	}
}
