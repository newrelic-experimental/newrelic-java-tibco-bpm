package com.tibco.amf.binding.soap.runtime.extensions;

import java.util.Map;

import javax.wsdl.Port;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;

@Weave(type=MatchType.Interface)
public abstract class SoapJmsExtension {
	
	@Trace
	public void onRequest(Port port, String soapAction, Map<String, String> msgProperities) {
		String soapName = soapAction != null && !soapAction.isEmpty() ? soapAction : "UnknownSOAPAction";

		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","SoapJmsExtension",getClass().getSimpleName(),"onRequest",soapName);
		Weaver.callOriginal();
	}
}
