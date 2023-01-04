package com.tibco.amf.binding.soap.runtime.transport.http;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

@Weave(type=MatchType.Interface)
public abstract class SoapHttpReplyCallback<M> {

	@Trace
	public void onMessage(M var1) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","SoapHttpReplyCallback",getClass().getSimpleName(),"onMessage");
		Weaver.callOriginal();
	}

	@Trace
	public void onError(M var1) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","SoapHttpReplyCallback",getClass().getSimpleName(),"onError");
		Weaver.callOriginal();
	}

	@Trace
	public void sendHttpOk() {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","SoapHttpReplyCallback",getClass().getSimpleName(),"sendHttpOk");
		Weaver.callOriginal();
	}

	@Trace
	public void sendHttpError() {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","SoapHttpReplyCallback",getClass().getSimpleName(),"sendHttpError");
		Weaver.callOriginal();
	}

	@Trace
	public void sendBytes(byte[] var1, String var2) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","SoapHttpReplyCallback",getClass().getSimpleName(),"sendBytes");
		Weaver.callOriginal();
	}

	@Trace
	public void sendErrorBytes(byte[] var1, String var2) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","SoapHttpReplyCallback",getClass().getSimpleName(),"sendErrorBytes");
		Weaver.callOriginal();
	}

}
