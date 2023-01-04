package com.tibco.amf.platform.runtime.extension.support;

import javax.xml.namespace.QName;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.tibco.amf.platform.runtime.extension.context.RequestContext;

@Weave(type=MatchType.Interface)
public abstract class GenericBusinessInterface<M> {

	@Trace
	public void invoke(QName var1, RequestContext var2, M var3) {
		if(var2.token != null) {
			var2.token.link();
		}
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","GenericBusinessInterface","invoke",var2.getServiceName());
		Weaver.callOriginal();
	}
}
