package com.tibco.amf.platform.runtime.extension.support;

import org.osoa.sca.ServiceRuntimeException;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.tibco.amf.platform.runtime.extension.context.CallbackContext;
import com.tibco.amf.platform.runtime.extension.context.RequestContext;

@Weave(type=MatchType.Interface)
public abstract class GenericReplyCallback<M> {

	@Trace(async=true)
	public void invoke(CallbackContext var1, M var2) {
		String serviceName = "UnknownService";
		if(var1 != null) {
			RequestContext requestCxt = var1.getRequestContext();
			if(requestCxt != null) {
				if(requestCxt.token != null) {
			
				requestCxt.token.linkAndExpire();
				requestCxt.token = null;
				}
				serviceName = requestCxt.getServiceName();
			}
		}
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","GenericReplyCallback",getClass().getSimpleName(),"invoke",serviceName);
		Weaver.callOriginal();
	}

	public void onException(ServiceRuntimeException var1) {
		NewRelic.noticeError(var1);
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","GenericReplyCallback",getClass().getSimpleName(),"onException");
		Weaver.callOriginal();
	}

}
