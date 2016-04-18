package com.emc.app.spi.poi;

import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.emc.app.data.service.MerchantCodeService;
import com.emc.app.entity.MerchantCode;
@Component("merchantCodePoi")
public class MerchantCodePoiImp implements MerchantCodePoi{
	@Autowired
	private MerchantCodeService merchantCodeService;
	public void setMerchantCodeService(MerchantCodeService merchantCodeService){
		this.merchantCodeService = merchantCodeService;
	}
	public Response getMerchantCodes(int first,	int max) {
		List<MerchantCode> list = merchantCodeService.getMerchantCodes(first, max);
		return Response.ok(list).build();
	}
	
}
