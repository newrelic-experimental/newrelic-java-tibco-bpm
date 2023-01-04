package com.tibco.amf.runtime.bindingtype.rest.outbound;

import java.util.List;

import javax.security.auth.Subject;
import javax.xml.namespace.QName;

import org.apache.http.Header;
import org.apache.http.HttpHost;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.tibco.amf.model.rest.wadl.HTTPMethods;
import com.tibco.amf.platform.runtime.extension.context.ReferenceEndpointContext;
import com.tibco.amf.platform.runtime.extension.context.RequestContext;
import com.tibco.amf.sharedresource.runtime.core.http.httpclient.HttpClientConnectionFactory;

@Weave
public abstract class RESTHttpClient {

	@Trace
	public static void sendRequest(String applicationPath, String resourceURI, List<Header> headers, byte[] requestBody,
			HTTPMethods httpMethod, HttpHost hostConfiguration, HttpClientConnectionFactory connectionFactory,
			Subject subject, ReferenceEndpointContext refEndpointContext, RequestContext requestContext,
			QName operationQName, boolean dontEncodeURI) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","RESTHttpClient","sendRequest",requestContext.getServiceName(),operationQName.toString());
		Weaver.callOriginal();
	}
	
	@Trace
	public static RESTHttpResponseWrapper sendSyncRequestReply(String applicationPath, String resourceURI,
			List<Header> headers, byte[] requestBody, HTTPMethods httpMethod, HttpHost hostConfiguration,
			HttpClientConnectionFactory connectionFactory, Subject subject, ReferenceEndpointContext refEndpointContext,
			RequestContext requestContext, QName operationQName, boolean dontEncodeURI) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","RESTHttpClient","sendSyncRequestReply",requestContext.getServiceName(),operationQName.toString());
		return Weaver.callOriginal();
	}
}
