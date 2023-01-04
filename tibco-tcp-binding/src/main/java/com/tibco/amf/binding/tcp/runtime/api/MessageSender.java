package com.tibco.amf.binding.tcp.runtime.api;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

@Weave(type=MatchType.Interface)
public abstract class MessageSender {

	@Trace
	public void sendMessage(byte[] var1) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","MessageSender",getClass().getSimpleName(),"sendMessage");
		Weaver.callOriginal();
	}
}
