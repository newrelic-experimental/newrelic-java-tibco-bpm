package com.tibco.amf.binding.soap.runtime.transport.http;

import java.util.HashMap;

import javax.security.auth.Subject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.namespace.QName;

import org.w3c.dom.Element;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.tibco.amf.platform.runtime.extension.context.RequestContext;

@Weave
public abstract class SoapHttpOutboundEndpoint {

	@Trace
	public void processHttpPost(HashMap<String, String> actionHeaders, SoapHttpReplyCallback<byte[]> replyCallback, Subject securityObject, HttpServletRequest request, HttpServletResponse response, long timestamp) {

		String soapAction;
		soapAction = (String)actionHeaders.get("soapaction");
		if(soapAction == null) {
			soapAction = (String)actionHeaders.get("action");
		}
		if(soapAction == null) {
			soapAction = "UnknownAction";
		}
		
		NewRelic.getAgent().getTracedMethod().setMetricName(new String[] {"Custom","SoapHttpRequestCallback",getClass().getName(),"processHttpPost",soapAction});
		Weaver.callOriginal();
	}

	public void invoke(QName operationName, RequestContext requestContext, Element message) {
		NewRelic.getAgent().getTracedMethod().setMetricName(new String[] {"Custom","SoapHttpOutboundEndpoint",getClass().getName(),"invoke",operationName.toString()});
		Weaver.callOriginal();
	}
}
