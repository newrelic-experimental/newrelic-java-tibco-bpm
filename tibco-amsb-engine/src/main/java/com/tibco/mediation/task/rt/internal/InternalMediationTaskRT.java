package com.tibco.mediation.task.rt.internal;

import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.tibco.mediation.task.rt.Exchange;
import com.tibco.mediation.task.rt.fault.TaskFault;

@Weave(type=MatchType.BaseClass)
public abstract class InternalMediationTaskRT<I, U, N extends I, A extends I, S, T, X> {

	@Trace
	public N execute(N input, Exchange<N> exchange) throws TaskFault {
		return Weaver.callOriginal();
	}

	@Trace
	public N execute(N var1, InternalExchange<I, U, N, A, S, T, X> var2) {
		return Weaver.callOriginal();
	}

}
