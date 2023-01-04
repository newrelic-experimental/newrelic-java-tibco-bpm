package com.tibco.amf.runtime.bindingtype.rest.inbound;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.tibco.amf.platform.runtime.extension.context.CallbackContext;
import com.tibco.amf.platform.runtime.extension.implementation.GenericMessage;

@Weave
public abstract class RESTGenericReplyCallback {

	@Trace(dispatcher=true)
	public void invoke(CallbackContext paramCallbackContext, GenericMessage genericMessage) {
		String serviceName = paramCallbackContext.getRequestContext() != null ? paramCallbackContext.getRequestContext().getServiceName() : "UnknownService";
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","RESTGenericReplyCallback","invoke",serviceName);
		Weaver.callOriginal();
	}
	
}
