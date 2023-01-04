package com.nr.instrumentation.tibco.bpm.amf.web;

import java.util.ArrayList;
import java.util.List;

import org.osoa.sca.RequestContext;

import com.tibco.amf.platform.runtime.extension.context.ComponentContext;

public class Utils {

	public static List<String> getTransactionComponents(ComponentContext ctx) {
		List<String> names = new ArrayList<String>();
		
		String hostName = ctx.getHostName();
		if(hostName != null && !hostName.isEmpty()) {
			names.add(hostName);
		}
		
		String appName = ctx.getApplicationName();
		if(appName != null && !appName.isEmpty()) {
			names.add(appName);
		}
		
		String compName = ctx.getComponentName();
		if(compName != null && !compName.isEmpty()) {
			names.add(compName);
		}
		
		String nodeName = ctx.getNodeName();
		if(nodeName != null && !nodeName.isEmpty()) {
			names.add(nodeName);
		}
		
		RequestContext reqCtx = ctx.getRequestContext();
		if(reqCtx != null) {
			String serviceName = reqCtx.getServiceName();
			if(serviceName != null && !serviceName.isEmpty()) {
				names.add(serviceName);
			}
		}
		
		
		return names;
	}
}
