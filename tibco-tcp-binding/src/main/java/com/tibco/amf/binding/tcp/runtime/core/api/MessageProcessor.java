package com.tibco.amf.binding.tcp.runtime.core.api;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

@Weave(type=MatchType.Interface)
public abstract class MessageProcessor {

	@Trace(dispatcher=true)
	public void process(byte[] var1) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","MessageProcessor",getClass().getSimpleName(),"process");
		Weaver.callOriginal();
	}
}
