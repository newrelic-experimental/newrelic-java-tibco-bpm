package com.tibco.amf.binding.soap.runtime.wsrm;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.tibco.amf.platform.runtime.extension.context.RequestContext;
import com.tibco.corona.binding.bindingsoapmodel.SOAPOperationConfiguration;
import javax.xml.namespace.QName;
import org.w3c.dom.Element;

@Weave(type=MatchType.Interface)
public abstract class RequestHandler {

	@Trace
	public void sendRequest(RequestContext requestContext, Element message, QName operationName, String soapAction,
			SOAPOperationConfiguration operationConfig) {
		if(requestContext.token == null) {
			requestContext.token = NewRelic.getAgent().getTransaction().getToken();
		}
		String soapName = soapAction != null && !soapAction.isEmpty() ? soapAction : "UnknownSOAPAction";
		String opName = operationName != null ? operationName.toString() : "UnknownOperation";
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","RequestHandler",getClass().getSimpleName(),"sendRequest",opName,soapName);
	
		Weaver.callOriginal();
	}
}
