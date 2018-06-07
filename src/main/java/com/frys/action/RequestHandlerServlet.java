package com.frys.action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.frys.bean.DelivProperties;
import com.frys.bean.SpringConfiguration;
import com.frys.util.DeliveryHelper;
import com.frys.util.FrysHelper;

@RestController
public class RequestHandlerServlet {  //http://localhost:8080/deliv/order?tracking_code=11111

	@RequestMapping(path="/order")
	public String getOrderDetailsByTrackingCode(@RequestParam(value="tracking_code", defaultValue="909090") String trackingCode) {
		if(FrysHelper.isValueNull(trackingCode) && trackingCode.isEmpty()) {
			return null;
		}
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
	    DelivProperties props = applicationContext.getBean(DelivProperties.class);
	    DeliveryHelper helper = new DeliveryHelper();
	    helper.setApiKey(props.getApiKey());
	    helper.setHitUrl(props.getDelivUrl());
	    return helper.getDeliveryInfo(trackingCode);
	}
	
}
