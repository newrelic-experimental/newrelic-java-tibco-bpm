package com.tibco.amf.runtime.bindingtype.rest.inbound;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.tibco.amf.platform.runtime.extension.context.CallbackContext;
import com.tibco.amf.platform.runtime.extension.implementation.GenericMessage;

@Weave
public abstract class RESTSyncReplyCallback {

	public void invoke(CallbackContext paramCallbackContext, GenericMessage restElementArrayMessage) {
		String serviceName = paramCallbackContext.getRequestContext() != null ? paramCallbackContext.getRequestContext().getServiceName() : "UnknownService";
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","RESTSyncReplyCallback","invoke",serviceName);
		Weaver.callOriginal();
	}
}
