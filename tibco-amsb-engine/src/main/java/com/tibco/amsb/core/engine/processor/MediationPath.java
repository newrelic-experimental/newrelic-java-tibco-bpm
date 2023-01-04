package com.tibco.amsb.core.engine.processor;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.tibco.amsb.core.engine.flow.manager.OperationFlow;
import com.tibco.mediation.task.rt.internal.InternalExchange;
import com.tibco.mediation.task.rt.internal.context.impl.MediationOperationContextImpl;

@Weave
public class MediationPath<I, U, N extends I, A extends I, S, T, X> {

	@Trace
	public void execute(InternalExchange<I, U, N, A, S, T, X> exchange, MediationPathStatus mediationPathStatus) {
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
				NewRelic.getAgent().getTracedMethod().setMetricName("Custom","MediationPath","execute",interfaceName,opName);
			}
		}
		Weaver.callOriginal();
	}
}
