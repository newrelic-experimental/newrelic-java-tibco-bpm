package com.tibco.amsb.rt.common.route;

import java.util.Collection;

import org.gxml.sa.GxProcessingContext;

import com.newrelic.api.agent.Trace;
import com.newrelic.api.agent.weaver.MatchType;
import com.newrelic.api.agent.weaver.Weave;
import com.newrelic.api.agent.weaver.Weaver;
import com.tibco.amsb.rt.common.transform.XSLParameter;
import com.tibco.mediation.task.rt.context.DataBindingType;

@Weave(type=MatchType.Interface)
public abstract class Router<I, U, N extends I, A extends I, S, T, X> {

	@Trace
	public String execute(Collection<XSLParameter<I, U, N, A, S, T, X>> var1, GxProcessingContext<I, U, N, A, S, T, X> var2,
			DataBindingType var3) {
		return Weaver.callOriginal();
	}
}
