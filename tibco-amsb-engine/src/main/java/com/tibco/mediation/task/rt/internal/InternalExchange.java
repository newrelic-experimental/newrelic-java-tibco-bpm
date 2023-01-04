package com.tibco.mediation.task.rt.internal;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.tibco.amf.platform.runtime.extension.context.RequestContext;
import com.tibco.amsb.core.engine.flow.manager.OperationFlow;
import com.tibco.amsb.core.engine.processor.MediationPathStatus;

@Weave(type=MatchType.Interface)
public abstract class InternalExchange<I, U, N extends I, A extends I, S, T, X> {
	
	public abstract RequestContext getRequestContext();
	
	public abstract OperationFlow<I, U, N, A, S, T, X> getOperationFlow();

	@Trace(dispatcher=true)
	public void handleResponseFromTargetOperationMediationTask(MediationPathStatus var1) {
		String serviceName = getServiceName();
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","AMSB-Engine","InternalExchange",getClass().getSimpleName(),"handleResponseFromTargetOperationMediationTask",serviceName);
		Weaver.callOriginal();
	}

	@Trace(dispatcher=true)
	public void handleResponseFromInvokeOperationMediationTask(MediationPathStatus var1) {
		String serviceName = getServiceName();
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","AMSB-Engine","InternalExchange",getClass().getSimpleName(),"handleResponseFromInvokeOperationMediationTask",serviceName);
		Weaver.callOriginal();
	}

	@Trace(dispatcher=true)
	public void handleFaultFromInvokeOperationMediationTask(MediationPathStatus var1, Exception var2) {
		String serviceName = getServiceName();
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","AMSB-Engine","InternalExchange",getClass().getSimpleName(),"handleFaultFromInvokeOperationMediationTask",serviceName);
		Weaver.callOriginal();
	}

	@Trace(dispatcher=true)
	public void handleFaultFromInvokeOperationMediationTaskInMediationFaultPath(MediationPathStatus var1, Exception var2) {
		String serviceName = getServiceName();
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","AMSB-Engine","InternalExchange",getClass().getSimpleName(),"handleFaultFromInvokeOperationMediationTaskInMediationFaultPath",serviceName);
		Weaver.callOriginal();
	}

	@Trace(dispatcher=true)
	public void handleResponseFromInvokeOperationMediationTaskInMediationFaultPath(MediationPathStatus var1) {
		String serviceName = getServiceName();
		NewRelic.getAgent().getTracedMethod().setMetricName("Custom","AMSB-Engine","InternalExchange",getClass().getSimpleName(),"handleResponseFromInvokeOperationMediationTaskInMediationFaultPath",serviceName);
		Weaver.callOriginal();
	}

	
	private String getServiceName() {
		String serviceName = "UnknownService";
		
		RequestContext requestCtx = getRequestContext();
		
		if(requestCtx != null) {
			String tmp = requestCtx.getServiceName();
			if(tmp != null && !tmp.isEmpty()) {
				serviceName = tmp;
			}
		}
		
		
		return serviceName;
	}
}
