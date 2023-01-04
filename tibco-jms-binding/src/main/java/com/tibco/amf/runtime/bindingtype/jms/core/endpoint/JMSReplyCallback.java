package com.tibco.amf.runtime.bindingtype.jms.core.endpoint;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

@Weave(type=MatchType.Interface)
public abstract class JMSReplyCallback<M> {

	@Trace(dispatcher=true)
	public void onMessage(M msg) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","JMSReplyCallback",getClass().getSimpleName(),"onMessage");
		Weaver.callOriginal();
	}

	@Trace(dispatcher=true)
	public void onError(M msg) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","JMSReplyCallback",getClass().getSimpleName(),"onError");
		Weaver.callOriginal();
	}

}
