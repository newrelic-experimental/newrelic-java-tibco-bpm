package com.tibco.bx.amx.container.services.impl;

import org.osoa.sca.ServiceRuntimeException;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.tibco.amf.platform.runtime.extension.context.MutableCallbackContext;
import com.tibco.amf.platform.runtime.extension.context.RequestContext;
import com.tibco.bx.api.services.BxMessageType;

@Weave
public abstract class CallbackHolder {

	@Trace
	public <T> void invoke(MutableCallbackContext cbContext, T[] msg, BxMessageType messageType) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","CallbackHolder","invoke",cbContext.getRequestContext().getServiceName(),cbContext.getOperationName().toString());
		Weaver.callOriginal();
	}
	
	@Trace(dispatcher=true)
	public void onCompletion(RequestContext cbContext) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","CallbackHolder","onCompletion",cbContext.getServiceName(),cbContext.getOperationName().toString());
		Weaver.callOriginal();
	}
	
	@Trace(dispatcher=true)
	public void onException(RequestContext cbContext, ServiceRuntimeException ex) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","CallbackHolder","onException",cbContext.getServiceName(),cbContext.getOperationName().toString());
		Weaver.callOriginal();
	}

}
