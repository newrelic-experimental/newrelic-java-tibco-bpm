package com.tibco.bx.amx.container;

import javax.xml.namespace.QName;

import org.w3c.dom.Element;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.tibco.amf.platform.runtime.extension.context.RequestContext;

@Weave
public abstract class BxImplementationAdapter {

	public abstract String getNodeName();

	@Trace
	public void invoke(QName operationName, RequestContext context, Element[] messages) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","BxImplementationAdapter","invoke",context.getServiceName(),operationName.toString());
		Weaver.callOriginal();
	}
}
