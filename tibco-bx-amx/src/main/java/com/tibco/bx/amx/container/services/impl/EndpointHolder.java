package com.tibco.bx.amx.container.services.impl;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.tibco.amf.platform.runtime.extension.context.MutableRequestContext;
import com.tibco.bx.api.services.BxMessageType;
import com.tibco.bx.api.services.BxResponseListener;
import javax.wsdl.PortType;

@Weave
public abstract class EndpointHolder {

	@Trace
	public <T> void invoke(String operationName, MutableRequestContext reqCtxt, T[] msg, BxMessageType messageType) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","EndpointHolder","invoke",operationName);
		Weaver.callOriginal();
	}
	
	public <T> void invokeRequestReply(String operationName, PortType portType, BxResponseListener listener,
			MutableRequestContext reqCtxt, T[] msg, BxMessageType messageType) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","EndpointHolder","invoke",operationName);
		Weaver.callOriginal();
	}
}
