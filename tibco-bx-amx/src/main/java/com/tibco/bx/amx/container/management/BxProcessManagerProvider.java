package com.tibco.bx.amx.container.management;

import javax.xml.namespace.QName;

import org.w3c.dom.Element;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.tibco.amf.platform.runtime.extension.context.RequestContext;
import com.tibco.bx.api.BxNotificationListener.PageDirective;
import com.tibco.bx.api.services.BxProviderEndpointAttr;

@Weave
public abstract class BxProcessManagerProvider {

	@Trace
	public void invoke(QName operationName, RequestContext context, Element[] messages) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","BxProcessManagerProvider","invoke",context.getServiceName(),operationName.toString());
		Weaver.callOriginal();
	}
	
	@Trace(dispatcher=true)
	public void reply(int cursorid, PageDirective directive, BxProviderEndpointAttr replyContext) {
		Weaver.callOriginal();
	}
}
