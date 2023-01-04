package com.tibco.amsb.core.engine.processor;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.tibco.amsb.core.engine.flow.manager.OperationFlow;
import com.tibco.mediation.task.rt.internal.InternalExchange;
import com.tibco.mediation.task.rt.internal.context.impl.MediationOperationContextImpl;

@Weave
public abstract class MediationPathProcessor<I, U, N extends I, A extends I, S, T, X> {

	@Trace(dispatcher=true)
	public void processInputPath(InternalExchange<I, U, N, A, S, T, X> exchange, MediationPathStatus mediationPathStatus) {
		OperationFlow<I, U, N, A, S, T, X> opFlow = exchange.getOperationFlow();
		if(opFlow != null) {
			MediationOperationContextImpl<I, U, N, A, S, T, X> opCtx = opFlow.getOperationContext();
			if(opCtx != null) {
				String interfaceName = opCtx.getInterfaceName();
				if(interfaceName == null || interfaceName.isEmpty()) {
					interfaceName = "UnknownInterface";
				}
				String opName = opCtx.getOperationName();
				if(opName == null || opName.isEmpty()) {
					opName = "UnknownOperation";
				}
				NewRelic.getAgent().getTracedMethod().setMetricName("Custom","MediationPathProcessor","processInputPath",interfaceName,opName);
			}
		}
		
		Weaver.callOriginal();
	}
	
	@Trace(dispatcher=true)
	public void processInputSubPath(InternalExchange<I, U, N, A, S, T, X> exchange, MediationPathStatus mediationPathStatus) { 
		OperationFlow<I, U, N, A, S, T, X> opFlow = exchange.getOperationFlow();
		if(opFlow != null) {
			MediationOperationContextImpl<I, U, N, A, S, T, X> opCtx = opFlow.getOperationContext();
			if(opCtx != null) {
				String interfaceName = opCtx.getInterfaceName();
				if(interfaceName == null || interfaceName.isEmpty()) {
					interfaceName = "UnknownInterface";
				}
				String opName = opCtx.getOperationName();
				if(opName == null || opName.isEmpty()) {
					opName = "UnknownOperation";
				}
				NewRelic.getAgent().getTracedMethod().setMetricName("Custom","MediationPathProcessor","processInputSubPath",interfaceName,opName);
			}
		}
		
		Weaver.callOriginal();
	}
	
	@Trace(dispatcher=true)
	public void processRequest(InternalExchange<I, U, N, A, S, T, X> exchange) {
		OperationFlow<I, U, N, A, S, T, X> opFlow = exchange.getOperationFlow();
		if(opFlow != null) {
			MediationOperationContextImpl<I, U, N, A, S, T, X> opCtx = opFlow.getOperationContext();
			if(opCtx != null) {
				String interfaceName = opCtx.getInterfaceName();
				if(interfaceName == null || interfaceName.isEmpty()) {
					interfaceName = "UnknownInterface";
				}
				String opName = opCtx.getOperationName();
				if(opName == null || opName.isEmpty()) {
					opName = "UnknownOperation";
				}
				NewRelic.getAgent().getTracedMethod().setMetricName("Custom","MediationPathProcessor","processRequest",interfaceName,opName);
			}
		}
		
		Weaver.callOriginal();
	}
	
	@Trace(dispatcher=true)
	public void processResponse(InternalExchange<I, U, N, A, S, T, X> exchange, MediationPathStatus mediationPathStatus) {
		OperationFlow<I, U, N, A, S, T, X> opFlow = exchange.getOperationFlow();
		if(opFlow != null) {
			MediationOperationContextImpl<I, U, N, A, S, T, X> opCtx = opFlow.getOperationContext();
			if(opCtx != null) {
				String interfaceName = opCtx.getInterfaceName();
				if(interfaceName == null || interfaceName.isEmpty()) {
					interfaceName = "UnknownInterface";
				}
				String opName = opCtx.getOperationName();
				if(opName == null || opName.isEmpty()) {
					opName = "UnknownOperation";
				}
				NewRelic.getAgent().getTracedMethod().setMetricName("Custom","MediationPathProcessor","processResponse",interfaceName,opName);
			}
		}
		
		Weaver.callOriginal();
	}
	
	@Trace(dispatcher=true)
	public void handleFaultFromInvokeOperationMediationTask(InternalExchange<I, U, N, A, S, T, X> exchange, MediationPathStatus mediationPathStatus, Exception exp) {
		NewRelic.noticeError(exp);
		OperationFlow<I, U, N, A, S, T, X> opFlow = exchange.getOperationFlow();
		if(opFlow != null) {
			MediationOperationContextImpl<I, U, N, A, S, T, X> opCtx = opFlow.getOperationContext();
			if(opCtx != null) {
				String interfaceName = opCtx.getInterfaceName();
				if(interfaceName == null || interfaceName.isEmpty()) {
					interfaceName = "UnknownInterface";
				}
				String opName = opCtx.getOperationName();
				if(opName == null || opName.isEmpty()) {
					opName = "UnknownOperation";
				}
				NewRelic.getAgent().getTracedMethod().setMetricName("Custom","MediationPathProcessor","handleFaultFromInvokeOperationMediationTask",interfaceName,opName);
			}
		}
		
		Weaver.callOriginal();
	}
	
	@Trace(dispatcher=true)
	public void handleFaultFromInvokeOperationMediationTaskInMediationFaultPath(InternalExchange<I, U, N, A, S, T, X> exchange, MediationPathStatus mediationPathStatus, Exception exp) {
		NewRelic.noticeError(exp);
		OperationFlow<I, U, N, A, S, T, X> opFlow = exchange.getOperationFlow();
		if(opFlow != null) {
			MediationOperationContextImpl<I, U, N, A, S, T, X> opCtx = opFlow.getOperationContext();
			if(opCtx != null) {
				String interfaceName = opCtx.getInterfaceName();
				if(interfaceName == null || interfaceName.isEmpty()) {
					interfaceName = "UnknownInterface";
				}
				String opName = opCtx.getOperationName();
				if(opName == null || opName.isEmpty()) {
					opName = "UnknownOperation";
				}
				NewRelic.getAgent().getTracedMethod().setMetricName("Custom","MediationPathProcessor","handleFaultFromInvokeOperationMediationTaskInMediationFaultPath",interfaceName,opName);
			}
		}
		
		Weaver.callOriginal();
	}
	
	@Trace(dispatcher=true)
	public void handleResponseFromInvokeOperationMediationTask(InternalExchange<I, U, N, A, S, T, X> exchange, MediationPathStatus mediationPathStatus) {
		OperationFlow<I, U, N, A, S, T, X> opFlow = exchange.getOperationFlow();
		if(opFlow != null) {
			MediationOperationContextImpl<I, U, N, A, S, T, X> opCtx = opFlow.getOperationContext();
			if(opCtx != null) {
				String interfaceName = opCtx.getInterfaceName();
				if(interfaceName == null || interfaceName.isEmpty()) {
					interfaceName = "UnknownInterface";
				}
				String opName = opCtx.getOperationName();
				if(opName == null || opName.isEmpty()) {
					opName = "UnknownOperation";
				}
				NewRelic.getAgent().getTracedMethod().setMetricName("Custom","MediationPathProcessor","handleResponseFromInvokeOperationMediationTask",interfaceName,opName);
			}
		}
		
		Weaver.callOriginal();
	}
	
	@Trace(dispatcher=true)
	public void handleResponseFromInvokeOperationMediationTaskInMediationFaultPath(InternalExchange<I, U, N, A, S, T, X> exchange, MediationPathStatus mediationPathStatus) {
		OperationFlow<I, U, N, A, S, T, X> opFlow = exchange.getOperationFlow();
		if(opFlow != null) {
			MediationOperationContextImpl<I, U, N, A, S, T, X> opCtx = opFlow.getOperationContext();
			if(opCtx != null) {
				String interfaceName = opCtx.getInterfaceName();
				if(interfaceName == null || interfaceName.isEmpty()) {
					interfaceName = "UnknownInterface";
				}
				String opName = opCtx.getOperationName();
				if(opName == null || opName.isEmpty()) {
					opName = "UnknownOperation";
				}
				NewRelic.getAgent().getTracedMethod().setMetricName("Custom","MediationPathProcessor","handleResponseFromInvokeOperationMediationTask",interfaceName,opName);
			}
		}
		
		Weaver.callOriginal();
	}
}
