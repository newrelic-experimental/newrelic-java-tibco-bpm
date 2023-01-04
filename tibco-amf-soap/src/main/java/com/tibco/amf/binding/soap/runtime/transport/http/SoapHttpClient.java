package com.tibco.amf.binding.soap.runtime.transport.http;

import java.util.List;

import javax.security.auth.Subject;

import org.apache.http.HttpHost;
import org.w3c.dom.Document;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.tibco.amf.binding.soap.runtime.context.ContextVariableMappingConfiguration;
import com.tibco.amf.platform.runtime.extension.context.CallbackContext;
import com.tibco.amf.platform.runtime.extension.context.EndpointContext;
import com.tibco.amf.platform.runtime.extension.context.ReferenceEndpointContext;
import com.tibco.amf.platform.runtime.extension.context.RequestContext;
import com.tibco.amf.sharedresource.runtime.core.http.httpclient.HttpClientConnectionFactory;
import com.tibco.amf.spline.api.context.ISplineExchange;
import com.tibco.amf.spline.api.context.ISplineSOAPMessage;
import com.tibco.amf.spline.api.context.ISplineSOAPMessage.SoapVersion;


@Weave
public abstract class SoapHttpClient {

	@Trace(dispatcher=true)
	public static HttpClientReply sendBytesSyncRequestReply(byte[] request, String soapAction, String endpointUri,
			HttpClientConnectionFactory connectionFactory, HttpHost hostConfiguration, SoapVersion soapVersion,
			ReferenceEndpointContext refEndpointContext, RequestContext requestContext,
			List<ContextVariableMappingConfiguration> mappings, Subject subject, String componentUri,
			ISplineExchange splineExchange, String contentType) {
		if(requestContext.token == null) {
			requestContext.token = NewRelic.getAgent().getTransaction().getToken();
		}
		String soapName = soapAction != null && !soapAction.isEmpty() ? soapAction : "UnknownSOAPAction";
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","SoapHttpClient","sendBytesSyncRequestReply",soapName);
		return Weaver.callOriginal();
	}
	
	@Trace(dispatcher=true)
	public static void sendRequest(Document soapEnvelope, String soapAction, String endpointUri, HttpClientConnectionFactory connectionFactory, HttpHost hostConfiguration, ISplineSOAPMessage.SoapVersion soapVersion, ReferenceEndpointContext refEndpointContext, RequestContext requestContext, List<ContextVariableMappingConfiguration> mappings, Subject subject, String componentUri, ISplineExchange splineExchange) {
		if(requestContext.token == null) {
			requestContext.token = NewRelic.getAgent().getTransaction().getToken();
		}
		String soapName = soapAction != null && !soapAction.isEmpty() ? soapAction : "UnknownSOAPAction";
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","SoapHttpClient","sendRequest",soapName);
		Weaver.callOriginal();
	}

	@Trace(dispatcher=true)
	public static void sendRequest(Document soapEnvelope, String soapAction, String endpointUri, HttpClientConnectionFactory connectionFactory, HttpHost hostConfiguration, ISplineSOAPMessage.SoapVersion soapVersion, List<ContextVariableMappingConfiguration> mappings, CallbackContext callbackContext, ISplineExchange splineExchange, EndpointContext endpointContext) {
		RequestContext requestContext = callbackContext.getRequestContext();
		if(requestContext.token == null) {
			requestContext.token = NewRelic.getAgent().getTransaction().getToken();
		}
		String soapName = soapAction != null && !soapAction.isEmpty() ? soapAction : "UnknownSOAPAction";
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","SoapHttpClient","sendRequest",soapName);
		Weaver.callOriginal();

	}

	@Trace(dispatcher=true)
	public static HttpClientReply sendSyncRequestReply(Document soapEnvelope, String soapAction, String endpointUri, HttpClientConnectionFactory connectionFactory, HttpHost hostConfiguration, ISplineSOAPMessage.SoapVersion soapVersion, ReferenceEndpointContext refEndpointContext, RequestContext requestContext, List<ContextVariableMappingConfiguration> mappings, Subject subject, String componentUri, ISplineExchange splineExchange) {
		if(requestContext.token == null) {
			requestContext.token = NewRelic.getAgent().getTransaction().getToken();
		}
		return Weaver.callOriginal();
	}
	
	public static void sendRequestAsBytes(byte[] request, String soapAction, String endpointUri,
			HttpClientConnectionFactory connectionFactory, HttpHost hostConfiguration, SoapVersion soapVersion,
			ReferenceEndpointContext refEndpointContext, RequestContext requestContext,
			List<ContextVariableMappingConfiguration> mappings, Subject subject, String componentUri,
			ISplineExchange splineExchange, String contentType) {
		if(requestContext.token == null) {
			requestContext.token = NewRelic.getAgent().getTransaction().getToken();
		}
		String soapName = soapAction != null && !soapAction.isEmpty() ? soapAction : "UnknownSOAPAction";
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","SoapHttpClient","sendRequestAsBytes",soapName);
		Weaver.callOriginal();
	}

	public static void sendRequestAsBytes(byte[] request, String soapAction, String endpointUri,
			HttpClientConnectionFactory connectionFactory, HttpHost hostConfiguration, SoapVersion soapVersion,
			List<ContextVariableMappingConfiguration> mappings, CallbackContext callbackContext,
			ISplineExchange splineExchange, EndpointContext endpointContext, String contentType) {
		RequestContext requestContext = callbackContext.getRequestContext();
		if(requestContext.token == null) {
			requestContext.token = NewRelic.getAgent().getTransaction().getToken();
		}
		String soapName = soapAction != null && !soapAction.isEmpty() ? soapAction : "UnknownSOAPAction";
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","SoapHttpClient","sendRequestAsBytes",soapName);
		Weaver.callOriginal();
	}
}
