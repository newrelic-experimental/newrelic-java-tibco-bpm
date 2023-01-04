package com.tibco.amf.binding.soap.runtime.transport.jms.inbound.base;

import javax.jms.Message;

import org.osoa.sca.ServiceRuntimeException;
import org.w3c.dom.Element;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Token;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.TracedMethod;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.nr.instrumentation.tibco.sg.amfsoap.JmsMetricUtil;
import com.tibco.amf.binding.soap.runtime.SoapBusinessInterface;
import com.tibco.amf.binding.soap.runtime.processor.SplineMessageInterceptor;
import com.tibco.amf.platform.runtime.extension.context.CallbackContext;
import com.tibco.amf.platform.runtime.extension.context.MutableRequestContext;
import com.tibco.amf.platform.runtime.extension.context.RequestContext;
import com.tibco.corona.binding.bindingsoapmodel.SOAPOperationConfiguration;

@Weave(type=MatchType.BaseClass)
public abstract class BaseJmsMessageEndpoint {

	@Trace(dispatcher=true)
	public void onMessage(Message paramMessage, SoapBusinessInterface paramSoapBusinessInterface, SOAPOperationConfiguration paramSOAPOperationConfiguration) {
		TracedMethod tracer = NewRelic.getAgent().getTracedMethod();
		JmsMetricUtil.processConsume(paramMessage, tracer);
		String soapAction = paramSOAPOperationConfiguration.getAction();
		if(soapAction == null) {
			soapAction = "UnknownSoapAction";
		}
		NewRelic.getAgent().getTracedMethod().setMetricName(new String[] {"Custom","JMSMessageEndpoint",getClass().getName(),soapAction});
		Weaver.callOriginal();
	}


	public static class ReplyCallback {

		private final MutableRequestContext requestContext = Weaver.callOriginal();

		public ReplyCallback(Message requestMessage, SplineMessageInterceptor interceptor, SOAPOperationConfiguration operationConfiguration, MutableRequestContext requestContext,
				Element healthCheckRequest) {
			if(requestContext.token == null) {
				Token t = NewRelic.getAgent().getTransaction().getToken();
				if(t != null && t.isActive()) {
					requestContext.token = t;
				} else if(t != null) {
					t.expire();
					t = null;
				}
			}
		}

		public void sendReply(Element reply, boolean mapContext, CallbackContext callbackContext) {
			String serviceName = callbackContext.getServiceName();
			if(serviceName == null || serviceName.isEmpty()) {
				serviceName = "Unknown";
			}
			NewRelic.getAgent().getTracedMethod().setMetricName("Custom","ReplyCallback","sendReply",serviceName);
			Weaver.callOriginal();
		}

		public void sendReplyForCaching(Element reply, boolean mapContext, CallbackContext callbackContext) {
			String serviceName = callbackContext.getServiceName();
			if(serviceName == null || serviceName.isEmpty()) {
				serviceName = "Unknown";
			}
			NewRelic.getAgent().getTracedMethod().setMetricName("Custom","ReplyCallback","sendReplyForCaching",serviceName);
			Weaver.callOriginal();
		}

		@Trace(async=true)
		public void onCompletion(RequestContext reqContext) {
			String serviceName = requestContext.getServiceName();
			if(serviceName == null || serviceName.isEmpty()) {
				serviceName = "Unknown";
			}
			NewRelic.getAgent().getTracedMethod().setMetricName("Custom","ReplyCallback","onCompletion",serviceName);
			if(reqContext.token != null) {
				reqContext.token.linkAndExpire();
				reqContext.token = null;
			} else if(requestContext.token != null) {
				requestContext.token.linkAndExpire();
				requestContext.token = null;
			}
			Weaver.callOriginal();
		}

		@Trace
		public void invoke(CallbackContext callbackContext, final Element reply) {
			String serviceName = requestContext.getServiceName();
			if(serviceName == null || serviceName.isEmpty()) {
				serviceName = "Unknown";
			}
			NewRelic.getAgent().getTracedMethod().setMetricName("Custom","ReplyCallback","invoke",serviceName);
			Weaver.callOriginal();
		}

		@Trace(async=true)
		public void onException(ServiceRuntimeException sre) {
			NewRelic.noticeError(sre);
			String serviceName = requestContext.getServiceName();
			if(serviceName == null || serviceName.isEmpty()) {
				serviceName = "Unknown";
			}
			NewRelic.getAgent().getTracedMethod().setMetricName("Custom","ReplyCallback","onException",serviceName);
			if(requestContext.token != null) {
				requestContext.token.linkAndExpire();
				requestContext.token = null;
			}
			Weaver.callOriginal();		
		}
	}
}
