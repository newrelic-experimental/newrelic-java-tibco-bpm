package com.tibco.amf.platform.runtime.componentframework.messagingbus;

import java.util.Map;

import javax.print.attribute.standard.Destination;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

@Weave(type=MatchType.Interface)
public abstract class RemoteSender<M> {

	@Trace
	public void send(String scaAddress, M message, Map<String, Object> properties, QOS qos) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","RemoteSender",getClass().getSimpleName(),"send",scaAddress);
		Weaver.callOriginal();
	}

	@Trace
	public void send(String scaAddress, M message, Map<String, Object> properties, long ttl, QOS qos) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","RemoteSender",getClass().getSimpleName(),"send",scaAddress);
		Weaver.callOriginal();
	}

	@Trace
	public void send(String scaAddress, Exception exception, Map<String, Object> properties, QOS qos) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","RemoteSender",getClass().getSimpleName(),"send",scaAddress);
		Weaver.callOriginal();
	}

	@Trace
	public void send(String scaAddress, Exception exception, Map<String, Object> properties, long ttl, QOS qos) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","RemoteSender",getClass().getSimpleName(),"send",scaAddress);
		Weaver.callOriginal();
	}

	@Trace
	public void send(Destination dest, M message, Map<String, Object> properties, long ttl, QOS qos) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","RemoteSender",getClass().getSimpleName(),"send",dest.getName());
		Weaver.callOriginal();
	}

}
