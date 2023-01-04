package com.tibco.mediation.task.rt.internal.extension;

import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.tibco.mediation.task.rt.internal.InternalExchange;

@Weave(type=MatchType.BaseClass)
public abstract class InvokeOperationMediationTaskBaseRT<I, U, N extends I, A extends I, S, T, X> {

	@Trace
	protected N invokeOperation(InternalExchange<I, U, N, A, S, T, X> mediationExchange, N requestNode) {
		return Weaver.callOriginal();
	}
}
