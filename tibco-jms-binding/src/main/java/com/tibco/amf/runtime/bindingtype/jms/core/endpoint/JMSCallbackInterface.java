package com.tibco.amf.runtime.bindingtype.jms.core.endpoint;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.Token;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.NewField;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.tibco.amf.platform.runtime.extension.context.RequestContext;
import org.osoa.sca.ServiceRuntimeException;

@Weave(type=MatchType.Interface)
public class JMSCallbackInterface {
	
	@NewField
	public Token token = null;

	@Trace(async=true)
	public void onCompletion(RequestContext requestContext)  {
		if(token != null) {
			token.linkAndExpire();
			token = null;
		}
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","JMSCallbackInterface",getClass().getSimpleName(),"onCompletion",requestContext.getServiceName());
		Weaver.callOriginal();
	}

	@Trace(async=true)
	public void onException(RequestContext requestContext, ServiceRuntimeException exception) {
		NewRelic.noticeError(exception);
		if(token != null) {
			token.linkAndExpire();
			token = null;
		}
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","JMSCallbackInterface",getClass().getSimpleName(),"onException",requestContext.getServiceName());
		Weaver.callOriginal();
	}

}
