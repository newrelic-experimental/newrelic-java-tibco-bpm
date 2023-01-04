package com.tibco.amf.platform.runtime.componentframework.internal.proxies.operation;

import java.lang.reflect.Method;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import javax.xml.namespace.QName;

import org.osoa.sca.ServiceRuntimeException;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.tibco.amf.platform.runtime.componentframework.internal.proxies.SourceProxyAdapter;
import com.tibco.amf.platform.runtime.componentframework.internal.proxies.SourceProxyOperationAdapter;
import com.tibco.amf.platform.runtime.componentframework.internal.proxies.TargetProxyAdapter;
import com.tibco.amf.platform.runtime.componentframework.internal.proxies.TargetProxyOperationAdapter;
import com.tibco.amf.platform.runtime.extension.context.MutableCallbackContext;
import com.tibco.amf.platform.runtime.extension.context.MutableInvocationContext;
import com.tibco.amf.platform.runtime.extension.context.MutableRequestContext;
import com.tibco.amf.platform.runtime.extension.databinding.MessageConverter;
import com.tibco.amf.platform.runtime.extension.interceptor.MessageInterception;

@Weave(type=MatchType.BaseClass)
public abstract class OperationHandler {

	@Trace(dispatcher=true)
	public Object invoke(QName operationName, Object requestMessage, MutableRequestContext requestContext,
			SourceProxyOperationAdapter sourceProxyOperationAdapter, TargetProxyAdapter targetProxyAdapter,
			TargetProxyOperationAdapter targetProxyOperationAdapter,
			MessageConverter<?, ?, ?, ?>[] requestMessageConverters,
			MessageConverter<?, ?, ?, ?>[] callbackMessageConverters, ExecutorService executors,
			ExecutorService timerExecutor, long timeout, TimeUnit unit, boolean persistMessageExchange) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","OperationHandler",getClass().getSimpleName(),"invoke",operationName.toString());
		return Weaver.callOriginal();
	}
	
	@Trace(dispatcher=true)
	protected void handleASyncRuntimeException(QName operationName, MutableRequestContext requestContext,
			SourceProxyOperationAdapter sourceProxyOperationAdapter, TargetProxyAdapter targetProxyAdapter,
			TargetProxyOperationAdapter targetProxyOperationAdapter, Object callbackObject,
			ServiceRuntimeException serviceRuntimeException, Method onExceptionMethod, int len) {
		NewRelic.noticeError(serviceRuntimeException);
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","OperationHandler",getClass().getSimpleName(),"handleASyncRuntimeException",operationName.toString());
		Weaver.callOriginal();
	}
	
	@Trace(dispatcher=true)
	protected void handleSyncRuntimeException(QName operationName, MutableRequestContext requestContext,
			SourceProxyOperationAdapter sourceProxyOperationAdapter, TargetProxyAdapter targetProxyAdapter,
			TargetProxyOperationAdapter targetProxyOperationAdapter, Throwable throwable) {
		NewRelic.noticeError(throwable);
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","OperationHandler",getClass().getSimpleName(),"handleSyncRuntimeException",operationName.toString());
		Weaver.callOriginal();
	}
	
	@Trace(dispatcher=true)
	public <M> Object intercept(QName operationName,
			MessageInterception.InterceptionPoint interceptionPoint,
			SourceProxyOperationAdapter sourceProxyOperationAdapter, SourceProxyAdapter sourceProxyAdapter,
			TargetProxyAdapter targetProxyAdapter, MutableInvocationContext invocationContext,
			Object message) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","OperationHandler",getClass().getSimpleName(),"intercept",operationName.toString());
		return Weaver.callOriginal();
	}
	
	@Trace(dispatcher=true)
	protected void invokeCallback(QName operationName, MutableCallbackContext callbackContext,
			SourceProxyOperationAdapter sourceProxyOperationAdapter, TargetProxyAdapter targetProxyAdapter,
			Object target, Object message) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","OperationHandler",getClass().getSimpleName(),"invokeCallback",operationName.toString());
		Weaver.callOriginal();
	}
	
	@Trace(dispatcher=true)
	protected Object invokeMethodWithThreadContext(SourceProxyAdapter sourceProxyAdapter,
			TargetProxyAdapter targetProxyAdapter, MutableRequestContext requestContext,
			Method method, QName operationName, Object target, Object[] arguments) {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","OperationHandler",getClass().getSimpleName(),"invokeMethodWithThreadContext",operationName.toString());
		return Weaver.callOriginal();
	}
	
	@Trace(dispatcher=true)
	protected void invokeMethodWithThreadContext(ClassLoader classLoader, Method method, Object target, Object[] arguments)  {
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","OperationHandler",getClass().getSimpleName(),"invokeMethodWithThreadContext",method.getName());
		Weaver.callOriginal();
	}
	
	
}
